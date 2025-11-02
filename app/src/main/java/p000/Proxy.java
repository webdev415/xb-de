package p000;

public class Proxy {

    public String configId = null;

    public String localIP = null;

    public int localPort = 0;

    public String proxyHost = null;

    public String country = null;

    public int proxyPort = 0;

    public int serverType = 1;

    public int basePort = 0;

    public long g = -1;

    public int h = 0;

    public int k = 3;

    public int getProxyPort() {
        return Math.max(proxyPort, basePort);
    }
}
