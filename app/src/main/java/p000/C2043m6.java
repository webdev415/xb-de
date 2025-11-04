package p000;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.conscrypt.Conscrypt;
import org.conscrypt.ConscryptHostnameVerifier;

public final class C2043m6 extends C0764Qi {

    public static final boolean f6133e;

    public static final a f6134f;

    public final Provider f6135d;

    public static final class a {
        public a() {
        }

        public final boolean m8438a(int i, int i2, int i3) {
            Conscrypt.Version version = Conscrypt.version();
            return version.major() != i ? version.major() > i : version.minor() != i2 ? version.minor() > i2 : version.patch() >= i3;
        }

        public final C2043m6 m8439b() {
            AbstractC0881T7 abstractC0881T7 = null;
            if (m8440c()) {
                return new C2043m6(abstractC0881T7);
            }
            return null;
        }

        public final boolean m8440c() {
            return C2043m6.f6133e;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b implements ConscryptHostnameVerifier {

        public static final b f6136a = new b();
    }

    static {
        a aVar = new a(null);
        f6134f = aVar;
        boolean z = false;
        try {
            Class.forName("org.conscrypt.Conscrypt$Version", false, aVar.getClass().getClassLoader());
            if (Conscrypt.isAvailable()) {
                if (aVar.m8438a(2, 1, 0)) {
                    z = true;
                }
            }
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
        }
        f6133e = z;
    }

    public C2043m6() {
        Provider providerNewProvider = Conscrypt.newProvider();
        AbstractC0116Ce.m475d(providerNewProvider, "Conscrypt.newProvider()");
        this.f6135d = providerNewProvider;
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        if (!Conscrypt.isConscrypt(sSLSocket)) {
            super.mo1315e(sSLSocket, str, list);
            return;
        }
        Conscrypt.setUseSessionTickets(sSLSocket, true);
        Object[] array = C0764Qi.f2268c.m3685b(list).toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        Conscrypt.setApplicationProtocols(sSLSocket, (String[]) array);
    }

    @Override
    public String mo1316g(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return Conscrypt.isConscrypt(sSLSocket) ? Conscrypt.getApplicationProtocol(sSLSocket) : super.mo1316g(sSLSocket);
    }

    @Override
    public SSLContext mo3681m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f6135d);
        AbstractC0116Ce.m475d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override
    public SSLSocketFactory mo3682n(X509TrustManager x509TrustManager) throws NoSuchAlgorithmException, KeyManagementException {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        SSLContext sSLContextMo3681m = mo3681m();
        sSLContextMo3681m.init(null, new TrustManager[]{x509TrustManager}, null);
        SSLSocketFactory socketFactory = sSLContextMo3681m.getSocketFactory();
        AbstractC0116Ce.m475d(socketFactory, "newSSLContext().apply {\n…null)\n    }.socketFactory");
        return socketFactory;
    }

    @Override
    public X509TrustManager mo3683o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init((KeyStore) null);
        AbstractC0116Ce.m475d(trustManagerFactory, "TrustManagerFactory.getI…(null as KeyStore?)\n    }");
        TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();
        AbstractC0116Ce.m473b(trustManagers);
        if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
            TrustManager trustManager = trustManagers[0];
            if (trustManager == null) {
                throw new NullPointerException("null cannot be cast to non-null type javax.net.ssl.X509TrustManager");
            }
            X509TrustManager x509TrustManager = (X509TrustManager) trustManager;
            Conscrypt.setHostnameVerifier(x509TrustManager, b.f6136a);
            return x509TrustManager;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Unexpected default trust managers: ");
        String string = Arrays.toString(trustManagers);
        AbstractC0116Ce.m475d(string, "java.util.Arrays.toString(this)");
        sb.append(string);
        throw new IllegalStateException(sb.toString().toString());
    }

    public C2043m6(AbstractC0881T7 abstractC0881T7) {
        this();
    }
}
