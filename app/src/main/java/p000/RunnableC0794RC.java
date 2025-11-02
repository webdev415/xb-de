package p000;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class RunnableC0794RC implements Runnable {

    public final URL f2356l;

    public final InterfaceC0519LC f2357m;

    public final String f2358n;

    public final Map f2359o;

    public final C0611NC f2360p;

    public RunnableC0794RC(C0611NC c0611nc, String str, URL url, byte[] bArr, Map map, InterfaceC0519LC interfaceC0519LC) {
        this.f2360p = c0611nc;
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(url);
        AbstractC1085Xi.m4801j(interfaceC0519LC);
        this.f2356l = url;
        this.f2357m = interfaceC0519LC;
        this.f2358n = str;
        this.f2359o = null;
    }

    public final void m3773a(int i, Exception exc, byte[] bArr, Map map) {
        this.f2357m.mo2649a(this.f2358n, i, exc, bArr, map);
    }

    public final void m3774b(final int i, final Exception exc, final byte[] bArr, final Map map) {
        this.f2360p.mo354l().m7374C(new Runnable() {
            @Override
            public final void run() {
                this.f2209l.m3773a(i, exc, bArr, map);
            }
        });
    }

    @Override
    public final void run() throws Throwable {
        HttpURLConnection httpURLConnection;
        Map<String, List<String>> headerFields;
        this.f2360p.mo353k();
        int responseCode = 0;
        try {
            URLConnection uRLConnectionMo167a = AbstractC0039At.m166b().mo167a(this.f2356l, "client-measurement");
            if (!(uRLConnectionMo167a instanceof HttpURLConnection)) {
                throw new IOException("Failed to obtain HTTP connection");
            }
            httpURLConnection = (HttpURLConnection) uRLConnectionMo167a;
            httpURLConnection.setDefaultUseCaches(false);
            httpURLConnection.setConnectTimeout(60000);
            httpURLConnection.setReadTimeout(61000);
            httpURLConnection.setInstanceFollowRedirects(false);
            httpURLConnection.setDoInput(true);
            try {
                responseCode = httpURLConnection.getResponseCode();
                headerFields = httpURLConnection.getHeaderFields();
            } catch (IOException e) {
                e = e;
                headerFields = null;
            } catch (Throwable th) {
                th = th;
                headerFields = null;
            }
            try {
                C0611NC c0611nc = this.f2360p;
                byte[] bArrM3308u = C0611NC.m3308u(httpURLConnection);
                httpURLConnection.disconnect();
                m3774b(responseCode, null, bArrM3308u, headerFields);
            } catch (IOException e2) {
                e = e2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                m3774b(responseCode, e, null, headerFields);
            } catch (Throwable th2) {
                th = th2;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                m3774b(responseCode, null, null, headerFields);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            httpURLConnection = null;
            headerFields = null;
        } catch (Throwable th3) {
            th = th3;
            httpURLConnection = null;
            headerFields = null;
        }
    }
}
