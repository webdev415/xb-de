package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.TrafficStats;
import android.text.TextUtils;
import android.util.JsonReader;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.util.concurrent.ExecutionException;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONException;
import org.json.JSONObject;
import p000.AbstractC0263Fn;
import p000.AbstractC2383te;
import p000.C2242qb;

/* loaded from: classes.dex */
public class C1965kb {

    public static final Pattern f6011d = Pattern.compile("[0-9]+s");

    public static final Charset f6012e = Charset.forName("UTF-8");

    public final Context f6013a;

    public final InterfaceC2388tj f6014b;

    public final C0214Ek f6015c = new C0214Ek();

    public C1965kb(Context context, InterfaceC2388tj interfaceC2388tj) {
        this.f6013a = context;
        this.f6014b = interfaceC2388tj;
    }

    public static String m8273a(String str, String str2, String str3) {
        String str4;
        if (TextUtils.isEmpty(str)) {
            str4 = "";
        } else {
            str4 = ", " + str;
        }
        return String.format("Firebase options used while communicating with Firebase server APIs: %s, %s%s", str2, str3, str4);
    }

    public static JSONObject m8274b(String str, String str2) throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fid", str);
            jSONObject.put("appId", str2);
            jSONObject.put("authVersion", "FIS_v2");
            jSONObject.put("sdkVersion", "a:18.0.0");
            return jSONObject;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static JSONObject m8275c() throws JSONException {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("sdkVersion", "a:18.0.0");
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("installation", jSONObject);
            return jSONObject2;
        } catch (JSONException e) {
            throw new IllegalStateException(e);
        }
    }

    public static byte[] m8276h(JSONObject jSONObject) {
        return jSONObject.toString().getBytes("UTF-8");
    }

    public static boolean m8277i(int i) {
        return i >= 200 && i < 300;
    }

    public static void m8278j() {
        Log.e("Firebase-Installations", "Firebase Installations can not communicate with Firebase server APIs due to invalid configuration. Please update your Firebase initialization process and set valid Firebase options (API key, Project ID, Application ID) when initializing Firebase.");
    }

    public static void m8279k(HttpURLConnection httpURLConnection, String str, String str2, String str3) throws IOException {
        String strM8281o = m8281o(httpURLConnection);
        if (TextUtils.isEmpty(strM8281o)) {
            return;
        }
        Log.w("Firebase-Installations", strM8281o);
        Log.w("Firebase-Installations", m8273a(str, str2, str3));
    }

    public static long m8280m(String str) {
        AbstractC1085Xi.m4793b(f6011d.matcher(str).matches(), "Invalid Expiration Timestamp.");
        if (str == null || str.length() == 0) {
            return 0L;
        }
        return Long.parseLong(str.substring(0, str.length() - 1));
    }

    public static String m8281o(HttpURLConnection httpURLConnection) throws IOException {
        InputStream errorStream = httpURLConnection.getErrorStream();
        if (errorStream == null) {
            return null;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(errorStream, f6012e));
        try {
            try {
                StringBuilder sb = new StringBuilder();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        break;
                    }
                    sb.append(line);
                    sb.append('\n');
                }
                String str = String.format("Error when communicating with the Firebase Installations server API. HTTP response: [%d %s: %s]", Integer.valueOf(httpURLConnection.getResponseCode()), httpURLConnection.getResponseMessage(), sb);
                try {
                    bufferedReader.close();
                } catch (IOException unused) {
                }
                return str;
            } catch (IOException unused2) {
                bufferedReader.close();
                return null;
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException unused3) {
                }
                throw th;
            }
        } catch (IOException unused4) {
            return null;
        }
    }

    public static void m8282s(URLConnection uRLConnection, byte[] bArr) throws IOException {
        OutputStream outputStream = uRLConnection.getOutputStream();
        if (outputStream == null) {
            throw new IOException("Cannot send request to FIS servers. No OutputStream available.");
        }
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
        try {
            gZIPOutputStream.write(bArr);
        } finally {
            try {
                gZIPOutputStream.close();
                outputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    public AbstractC2383te m8283d(String str, String str2, String str3, String str4, String str5) throws C2242qb {
        int responseCode;
        AbstractC2383te abstractC2383teM8288n;
        if (!this.f6015c.m1068b()) {
            throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
        }
        URL urlM8286g = m8286g(String.format("projects/%s/installations", str3));
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32769);
            HttpURLConnection httpURLConnectionM8287l = m8287l(urlM8286g, str);
            try {
                try {
                    httpURLConnectionM8287l.setRequestMethod("POST");
                    httpURLConnectionM8287l.setDoOutput(true);
                    if (str5 != null) {
                        httpURLConnectionM8287l.addRequestProperty("x-goog-fis-android-iid-migration-auth", str5);
                    }
                    m8290q(httpURLConnectionM8287l, str2, str4);
                    responseCode = httpURLConnectionM8287l.getResponseCode();
                    this.f6015c.m1070f(responseCode);
                } catch (Throwable th) {
                    httpURLConnectionM8287l.disconnect();
                    TrafficStats.clearThreadStatsTag();
                    throw th;
                }
            } catch (IOException | AssertionError unused) {
            }
            if (m8277i(responseCode)) {
                abstractC2383teM8288n = m8288n(httpURLConnectionM8287l);
            } else {
                m8279k(httpURLConnectionM8287l, str4, str, str3);
                if (responseCode == 429) {
                    throw new C2242qb("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", C2242qb.a.TOO_MANY_REQUESTS);
                }
                if (responseCode < 500 || responseCode >= 600) {
                    m8278j();
                    abstractC2383teM8288n = AbstractC2383te.m9706a().mo3979e(AbstractC2383te.b.BAD_CONFIG).mo3975a();
                }
                httpURLConnectionM8287l.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
            httpURLConnectionM8287l.disconnect();
            TrafficStats.clearThreadStatsTag();
            return abstractC2383teM8288n;
        }
        throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
    }

    public AbstractC0263Fn m8284e(String str, String str2, String str3, String str4) throws C2242qb {
        int responseCode;
        AbstractC0263Fn abstractC0263FnM8289p;
        AbstractC0263Fn.a aVarMo1287b;
        if (!this.f6015c.m1068b()) {
            throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
        }
        URL urlM8286g = m8286g(String.format("projects/%s/installations/%s/authTokens:generate", str3, str2));
        for (int i = 0; i <= 1; i++) {
            TrafficStats.setThreadStatsTag(32771);
            HttpURLConnection httpURLConnectionM8287l = m8287l(urlM8286g, str);
            try {
                try {
                    httpURLConnectionM8287l.setRequestMethod("POST");
                    httpURLConnectionM8287l.addRequestProperty("Authorization", "FIS_v2 " + str4);
                    httpURLConnectionM8287l.setDoOutput(true);
                    m8291r(httpURLConnectionM8287l);
                    responseCode = httpURLConnectionM8287l.getResponseCode();
                    this.f6015c.m1070f(responseCode);
                } catch (IOException | AssertionError unused) {
                }
                if (m8277i(responseCode)) {
                    abstractC0263FnM8289p = m8289p(httpURLConnectionM8287l);
                } else {
                    m8279k(httpURLConnectionM8287l, null, str, str3);
                    if (responseCode == 401 || responseCode == 404) {
                        aVarMo1287b = AbstractC0263Fn.m1282a().mo1287b(AbstractC0263Fn.b.AUTH_ERROR);
                        abstractC0263FnM8289p = aVarMo1287b.mo1286a();
                    } else {
                        if (responseCode == 429) {
                            throw new C2242qb("Firebase servers have received too many requests from this client in a short period of time. Please try again later.", C2242qb.a.TOO_MANY_REQUESTS);
                        }
                        if (responseCode < 500 || responseCode >= 600) {
                            m8278j();
                            aVarMo1287b = AbstractC0263Fn.m1282a().mo1287b(AbstractC0263Fn.b.BAD_CONFIG);
                            abstractC0263FnM8289p = aVarMo1287b.mo1286a();
                        }
                    }
                }
                return abstractC0263FnM8289p;
            } finally {
                httpURLConnectionM8287l.disconnect();
                TrafficStats.clearThreadStatsTag();
            }
        }
        throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
    }

    public final String m8285f() {
        try {
            Context context = this.f6013a;
            byte[] bArrM4082a = AbstractC0874T0.m4082a(context, context.getPackageName());
            if (bArrM4082a != null) {
                return AbstractC2013ld.m8395b(bArrM4082a, false);
            }
            Log.e("ContentValues", "Could not get fingerprint hash for package: " + this.f6013a.getPackageName());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("ContentValues", "No such package: " + this.f6013a.getPackageName(), e);
            return null;
        }
    }

    public final URL m8286g(String str) throws C2242qb {
        try {
            return new URL(String.format("https://%s/%s/%s", "firebaseinstallations.googleapis.com", "v1", str));
        } catch (MalformedURLException e) {
            throw new C2242qb(e.getMessage(), C2242qb.a.UNAVAILABLE);
        }
    }

    public final HttpURLConnection m8287l(URL url, String str) throws C2242qb {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setConnectTimeout(10000);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setReadTimeout(10000);
            httpURLConnection.addRequestProperty("Content-Type", "application/json");
            httpURLConnection.addRequestProperty("Accept", "application/json");
            httpURLConnection.addRequestProperty("Content-Encoding", "gzip");
            httpURLConnection.addRequestProperty("Cache-Control", "no-cache");
            httpURLConnection.addRequestProperty("X-Android-Package", this.f6013a.getPackageName());
            InterfaceC1320bd interfaceC1320bd = (InterfaceC1320bd) this.f6014b.get();
            if (interfaceC1320bd != null) {
                try {
                    httpURLConnection.addRequestProperty("x-firebase-client", (String) AbstractC2346sn.m9590a(interfaceC1320bd.mo5660a()));
                } catch (InterruptedException e) {
                    e = e;
                    Thread.currentThread().interrupt();
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                    httpURLConnection.addRequestProperty("X-Android-Cert", m8285f());
                    httpURLConnection.addRequestProperty("x-goog-api-key", str);
                    return httpURLConnection;
                } catch (ExecutionException e2) {
                    e = e2;
                    Log.w("ContentValues", "Failed to get heartbeats header", e);
                    httpURLConnection.addRequestProperty("X-Android-Cert", m8285f());
                    httpURLConnection.addRequestProperty("x-goog-api-key", str);
                    return httpURLConnection;
                }
            }
            httpURLConnection.addRequestProperty("X-Android-Cert", m8285f());
            httpURLConnection.addRequestProperty("x-goog-api-key", str);
            return httpURLConnection;
        } catch (IOException unused) {
            throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
        }
    }

    public final AbstractC2383te m8288n(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f6012e));
        AbstractC0263Fn.a aVarM1282a = AbstractC0263Fn.m1282a();
        AbstractC2383te.a aVarM9706a = AbstractC2383te.m9706a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("name")) {
                aVarM9706a.mo3980f(jsonReader.nextString());
            } else if (strNextName.equals("fid")) {
                aVarM9706a.mo3977c(jsonReader.nextString());
            } else if (strNextName.equals("refreshToken")) {
                aVarM9706a.mo3978d(jsonReader.nextString());
            } else if (strNextName.equals("authToken")) {
                jsonReader.beginObject();
                while (jsonReader.hasNext()) {
                    String strNextName2 = jsonReader.nextName();
                    if (strNextName2.equals("token")) {
                        aVarM1282a.mo1288c(jsonReader.nextString());
                    } else if (strNextName2.equals("expiresIn")) {
                        aVarM1282a.mo1289d(m8280m(jsonReader.nextString()));
                    } else {
                        jsonReader.skipValue();
                    }
                }
                aVarM9706a.mo3976b(aVarM1282a.mo1286a());
                jsonReader.endObject();
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return aVarM9706a.mo3979e(AbstractC2383te.b.OK).mo3975a();
    }

    public final AbstractC0263Fn m8289p(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = httpURLConnection.getInputStream();
        JsonReader jsonReader = new JsonReader(new InputStreamReader(inputStream, f6012e));
        AbstractC0263Fn.a aVarM1282a = AbstractC0263Fn.m1282a();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            if (strNextName.equals("token")) {
                aVarM1282a.mo1288c(jsonReader.nextString());
            } else if (strNextName.equals("expiresIn")) {
                aVarM1282a.mo1289d(m8280m(jsonReader.nextString()));
            } else {
                jsonReader.skipValue();
            }
        }
        jsonReader.endObject();
        jsonReader.close();
        inputStream.close();
        return aVarM1282a.mo1287b(AbstractC0263Fn.b.OK).mo1286a();
    }

    public final void m8290q(HttpURLConnection httpURLConnection, String str, String str2) throws IOException {
        m8282s(httpURLConnection, m8276h(m8274b(str, str2)));
    }

    public final void m8291r(HttpURLConnection httpURLConnection) throws IOException {
        m8282s(httpURLConnection, m8276h(m8275c()));
    }
}
