package p000;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class C0764Qi {

    public static volatile C0764Qi f2266a;

    public static final Logger f2267b;

    public static final a f2268c;

    public static final class a {
        public a() {
        }

        public final List m3685b(List list) {
            AbstractC0116Ce.m476e(list, "protocols");
            ArrayList arrayList = new ArrayList<>();
            for (Object obj : list) {
                if (((EnumC2342sj) obj) != EnumC2342sj.HTTP_1_0) {
                    arrayList.add(obj);
                }
            }
            ArrayList arrayList2 = new ArrayList<>(AbstractC1857i5.m7866n(arrayList, 10));
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((EnumC2342sj) it.next()).toString());
            }
            return arrayList2;
        }

        public final byte[] m3686c(List list) {
            AbstractC0116Ce.m476e(list, "protocols");
            C2409u3 c2409u3 = new C2409u3();
            for (String str : m3685b(list)) {
                c2409u3.mo5926L(str.length());
                c2409u3.mo5925H(str);
            }
            return c2409u3.mo7331F();
        }

        public final C0764Qi m3687d() {
            C0645O0.f1989c.m3352b();
            C0764Qi c0764QiM1318a = C0277G0.f701f.m1318a();
            if (c0764QiM1318a != null) {
                return c0764QiM1318a;
            }
            C0764Qi c0764QiM3747a = C0782R0.f2306g.m3747a();
            AbstractC0116Ce.m473b(c0764QiM3747a);
            return c0764QiM3747a;
        }

        public final C0764Qi m3688e() {
            C1176Zh c1176ZhM5047a;
            C0876T2 c0876t2M4085a;
            C2043m6 c2043m6M8439b;
            if (m3693j() && (c2043m6M8439b = C2043m6.f6134f.m8439b()) != null) {
                return c2043m6M8439b;
            }
            if (m3692i() && (c0876t2M4085a = C0876T2.f2686f.m4085a()) != null) {
                return c0876t2M4085a;
            }
            if (m3694k() && (c1176ZhM5047a = C1176Zh.f3453f.m5047a()) != null) {
                return c1176ZhM5047a;
            }
            C1035We c1035WeM4500a = C1035We.f3064e.m4500a();
            if (c1035WeM4500a != null) {
                return c1035WeM4500a;
            }
            C0764Qi c0764QiM4152a = C0897Te.f2757i.m4152a();
            return c0764QiM4152a != null ? c0764QiM4152a : new C0764Qi();
        }

        public final C0764Qi m3689f() {
            return m3691h() ? m3687d() : m3688e();
        }

        public final C0764Qi m3690g() {
            return C0764Qi.f2266a;
        }

        public final boolean m3691h() {
            return AbstractC0116Ce.m472a("Dalvik", System.getProperty("java.vm.name"));
        }

        public final boolean m3692i() {
            Provider provider = Security.getProviders()[0];
            AbstractC0116Ce.m475d(provider, "Security.getProviders()[0]");
            return AbstractC0116Ce.m472a("BC", provider.getName());
        }

        public final boolean m3693j() {
            Provider provider = Security.getProviders()[0];
            AbstractC0116Ce.m475d(provider, "Security.getProviders()[0]");
            return AbstractC0116Ce.m472a("Conscrypt", provider.getName());
        }

        public final boolean m3694k() {
            Provider provider = Security.getProviders()[0];
            AbstractC0116Ce.m475d(provider, "Security.getProviders()[0]");
            return AbstractC0116Ce.m472a("OpenJSSE", provider.getName());
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f2268c = aVar;
        f2266a = aVar.m3689f();
        f2267b = Logger.getLogger(OkHttpClient.class.getName());
    }

    public static void m3674k(C0764Qi c0764Qi, String str, int i, Throwable th, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
        }
        if ((i2 & 2) != 0) {
            i = 4;
        }
        if ((i2 & 4) != 0) {
            th = null;
        }
        c0764Qi.m3679j(str, i, th);
    }

    public void mo3675b(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
    }

    public AbstractC2041m4 mo1314c(X509TrustManager x509TrustManager) {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        return new C2546x2(mo3676d(x509TrustManager));
    }

    public InterfaceC0723Pn mo3676d(X509TrustManager x509TrustManager) {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        X509Certificate[] acceptedIssuers = x509TrustManager.getAcceptedIssuers();
        AbstractC0116Ce.m475d(acceptedIssuers, "trustManager.acceptedIssuers");
        return new C2592y2((X509Certificate[]) Arrays.copyOf(acceptedIssuers, acceptedIssuers.length));
    }

    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
    }

    public void mo3677f(Socket socket, InetSocketAddress inetSocketAddress, int i) throws IOException {
        AbstractC0116Ce.m476e(socket, "socket");
        AbstractC0116Ce.m476e(inetSocketAddress, "address");
        socket.connect(inetSocketAddress, i);
    }

    public String mo1316g(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return null;
    }

    public Object mo3678h(String str) {
        AbstractC0116Ce.m476e(str, "closer");
        if (f2267b.isLoggable(Level.FINE)) {
            return new Throwable(str);
        }
        return null;
    }

    public boolean mo1317i(String str) {
        AbstractC0116Ce.m476e(str, "hostname");
        return true;
    }

    public void m3679j(String str, int i, Throwable th) {
        AbstractC0116Ce.m476e(str, "message");
        f2267b.log(i == 5 ? Level.WARNING : Level.INFO, str, th);
    }

    public void mo3680l(String str, Object obj) {
        AbstractC0116Ce.m476e(str, "message");
        if (obj == null) {
            str = str + " To see where this was allocated, set the OkHttpClient logger level to FINE: Logger.getLogger(OkHttpClient.class.getName()).setLevel(Level.FINE);";
        }
        m3679j(str, 5, (Throwable) obj);
    }

    public SSLContext mo3681m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS");
        AbstractC0116Ce.m475d(sSLContext, "SSLContext.getInstance(\"TLS\")");
        return sSLContext;
    }

    public SSLSocketFactory mo3682n(X509TrustManager x509TrustManager) throws KeyManagementException {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        try {
            SSLContext sSLContextMo3681m = mo3681m();
            sSLContextMo3681m.init(null, new TrustManager[]{x509TrustManager}, null);
            SSLSocketFactory socketFactory = sSLContextMo3681m.getSocketFactory();
            AbstractC0116Ce.m475d(socketFactory, "newSSLContext().apply {\n…ll)\n      }.socketFactory");
            return socketFactory;
        } catch (GeneralSecurityException e) {
            throw new AssertionError("No System TLS: " + e, e);
        }
    }

    public X509TrustManager mo3683o() {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        AbstractC0116Ce.m475d(trustManagerFactory, "factory");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        AbstractC0116Ce.m473b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager != null) {
                return (X509TrustManager) trustManager;
            }
            throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        AbstractC0116Ce.m475d(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public String toString() {
        String simpleName = getClass().getSimpleName();
        AbstractC0116Ce.m475d(simpleName, "javaClass.simpleName");
        return simpleName;
    }
}
