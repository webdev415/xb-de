package p000;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class DlnaCaster {

    private static final String TAG = "DlnaCaster";
    private volatile boolean discoveryActive = false;

    public interface DeviceListener {
        void onDeviceFound(String friendlyName, String url);
    }

    public void discoverDevices(DeviceListener deviceListener, int timeoutMs) {
        new Thread(() -> {
            try (DatagramSocket socket = new DatagramSocket()) {
                socket.setReuseAddress(true);

                String mSearch = "M-SEARCH * HTTP/1.1\r\n" +
                        "HOST: 239.255.255.250:1900\r\n" +
                        "MAN: \"ssdp:discover\"\r\n" +
                        "MX: 2\r\n" +
                        "ST: urn:schemas-upnp-org:device:MediaRenderer:1\r\n\r\n";

                byte[] sendData = mSearch.getBytes(StandardCharsets.UTF_8);
                socket.send(new DatagramPacket(sendData, sendData.length,
                        InetAddress.getByName("239.255.255.250"), 1900));

                long startTime = System.currentTimeMillis();

                DatagramPacket receivePacket = new DatagramPacket(new byte[2048], 2048);
                // while (true) {
                while (discoveryActive && (timeoutMs <= 0 || System.currentTimeMillis() - startTime < timeoutMs)) {
                    socket.receive(receivePacket);
                    String response = new String(receivePacket.getData(), 0, receivePacket.getLength(), StandardCharsets.UTF_8);
                    String url = parseLocation(response);
                    if (url != null) {
                        try (InputStream inputStream = new URL(url).openStream()) {
                            String friendlyName = parseFriendlyName(inputStream);
                            deviceListener.onDeviceFound(friendlyName, url);
                        } catch (Exception e) {
                            Log.w(TAG, "Failed to fetch device XML: " + url, e);
                        }
                    }
                }
            } catch (IOException e) {
                Log.e(TAG, "Device discovery failed", e);
            } finally {
                Log.d(TAG, "Device discovery finished");
                discoveryActive = false;
            }
        }).start();
    }

    public void stopDiscovery() {
        discoveryActive = false;
    }

    private String parseLocation(String response) {
        for (String line : response.split("\r?\n")) {
            if (line.toLowerCase().startsWith("location:")) {
                return line.substring(9).trim();
            }
        }
        return null;
    }

    private String parseFriendlyName(InputStream xmlStream) throws XmlPullParserException, IOException {
        XmlPullParser parser = XmlPullParserFactory.newInstance().newPullParser();
        parser.setInput(xmlStream, "UTF-8");
        for (int eventType = parser.getEventType(); eventType != XmlPullParser.END_DOCUMENT; eventType = parser.next()) {
            if (eventType == XmlPullParser.START_TAG && "friendlyName".equals(parser.getName())) {
                return parser.nextText();
            }
        }
        return "Unknown Device";
    }

    public String resolveControlURL(InputStream xmlStream, String baseUrl) throws XmlPullParserException, IOException {
        XmlPullParserFactory parserFactory = XmlPullParserFactory.newInstance();
        parserFactory.setNamespaceAware(true);
        XmlPullParser parser = parserFactory.newPullParser();
        parser.setInput(xmlStream, "UTF-8");

        boolean inService = false;
        boolean avTransportService = false;
        String controlUrl = null;

        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if (eventType == XmlPullParser.START_TAG) {
                String tagName = parser.getName();

                if ("service".equals(tagName)) {
                    inService = true;
                    avTransportService = false;
                } else if (inService && "serviceType".equals(tagName)) {
                    String serviceType = parser.nextText();
                    if (serviceType != null && serviceType.contains("AVTransport")) {
                        avTransportService = true;
                    }
                } else if (inService && avTransportService && "controlURL".equals(tagName)) {
                    controlUrl = parser.nextText().trim();
                    break;
                }
            } else if (eventType == XmlPullParser.END_TAG && "service".equals(parser.getName())) {
                inService = false;
            }
            eventType = parser.next();
        }

        if (controlUrl == null || controlUrl.trim().isEmpty()) {
            Log.e(TAG, "Control URL path not found in XML description.");
            return null;
        }

        // Resolve absolute or relative URL
        try {
            URL url = new URL(controlUrl);
            if (url.getHost() != null && !url.getHost().isEmpty()) {
                return controlUrl; // valid absolute URL
            }
        } catch (MalformedURLException ignored) {
            // malformed or relative URL
        }

        // Fallback: resolve relative URL against base
        URL resolvedUrl = new URL(new URL(baseUrl), controlUrl);
        return resolvedUrl.toString();
    }

    public void sendSoapRequest(String controlUrl, String soapBody, String action) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) new URL(controlUrl).openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        connection.setRequestProperty("SOAPAction", "\"urn:schemas-upnp-org:service:AVTransport:1#" + action + "\"");

        try (OutputStream os = connection.getOutputStream()) {
            os.write(soapBody.getBytes(StandardCharsets.UTF_8));
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8))) {
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            Log.d(TAG, action + " response: " + response);
        } catch (IOException e) {
            if (connection.getErrorStream() != null) connection.getErrorStream().close();
        }

        Log.d(TAG, action + " response code: " + connection.getResponseCode());
    }

    public void playMedia(String controlUrl, String mediaUri) throws IOException {
        String setUri = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"
                + "<s:Body>"
                + "<u:SetAVTransportURI xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\">"
                + "<InstanceID>0</InstanceID>"
                + "<CurrentURI>" + mediaUri + "</CurrentURI>"
                + "<CurrentURIMetaData></CurrentURIMetaData>"
                + "</u:SetAVTransportURI>"
                + "</s:Body></s:Envelope>";

        String play = "<?xml version=\"1.0\" encoding=\"utf-8\"?>"
                + "<s:Envelope xmlns:s=\"http://schemas.xmlsoap.org/soap/envelope/\" "
                + "s:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\">"
                + "<s:Body>"
                + "<u:Play xmlns:u=\"urn:schemas-upnp-org:service:AVTransport:1\">"
                + "<InstanceID>0</InstanceID>"
                + "<Speed>1</Speed>"
                + "</u:Play>"
                + "</s:Body></s:Envelope>";

        sendSoapRequest(controlUrl, setUri, "SetAVTransportURI");
        sendSoapRequest(controlUrl, play, "Play");
    }
}
