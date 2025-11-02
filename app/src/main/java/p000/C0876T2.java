package p000;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.bouncycastle.jsse.provider.BouncyCastleJsseProvider;

/* loaded from: classes.dex */
public final class C0876T2 extends C0764Qi {

    public static final boolean f2685e;

    public static final a f2686f;

    public final Provider f2687d;

    public static final class a {
        public a() {
        }

        public final C0876T2 m4085a() {
            AbstractC0881T7 abstractC0881T7 = null;
            if (m4086b()) {
                return new C0876T2(abstractC0881T7);
            }
            return null;
        }

        public final boolean m4086b() {
            return C0876T2.f2685e;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f2686f = aVar;
        boolean z = false;
        try {
            Class.forName("org.bouncycastle.jsse.provider.BouncyCastleJsseProvider", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f2685e = z;
    }

    public C0876T2() {
        this.f2687d = new BouncyCastleJsseProvider();
    }

    @Override
    public void mo1315e(SSLSocket sSLSocket, String str, List list) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        AbstractC0116Ce.m476e(list, "protocols");
        super.mo1315e(sSLSocket, str, list);
    }

    @Override
    public String mo1316g(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        return super.mo1316g(sSLSocket);
    }

    @Override
    public SSLContext mo3681m() throws NoSuchAlgorithmException {
        SSLContext sSLContext = SSLContext.getInstance("TLS", this.f2687d);
        AbstractC0116Ce.m475d(sSLContext, "SSLContext.getInstance(\"TLS\", provider)");
        return sSLContext;
    }

    @Override
    public X509TrustManager mo3683o() throws NoSuchAlgorithmException, KeyStoreException, NoSuchProviderException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("PKIX", "BCJSSE");
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

    public C0876T2(AbstractC0881T7 abstractC0881T7) {
        this();
    }
}
