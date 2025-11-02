package p000;

import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import org.openjsse.net.ssl.OpenJSSE;

/* loaded from: classes.dex */
public final class C1176Zh extends C0764Qi {

    public static final boolean f3452e;

    public static final a f3453f;

    public final Provider f3454d;

    public static final class a {
        public a() {
        }

        public final C1176Zh m5047a() {
            AbstractC0881T7 abstractC0881T7 = null;
            if (m5048b()) {
                return new C1176Zh(abstractC0881T7);
            }
            return null;
        }

        public final boolean m5048b() {
            return C1176Zh.f3452e;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        a aVar = new a(null);
        f3453f = aVar;
        boolean z = false;
        try {
            Class.forName("org.openjsse.net.ssl.OpenJSSE", false, aVar.getClass().getClassLoader());
            z = true;
        } catch (ClassNotFoundException unused) {
        }
        f3452e = z;
    }

    public C1176Zh() {
        this.f3454d = new OpenJSSE();
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
        SSLContext sSLContext = SSLContext.getInstance("TLSv1.3", this.f3454d);
        AbstractC0116Ce.m475d(sSLContext, "SSLContext.getInstance(\"TLSv1.3\", provider)");
        return sSLContext;
    }

    @Override
    public X509TrustManager mo3683o() throws NoSuchAlgorithmException, KeyStoreException {
        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm(), this.f3454d);
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

    public C1176Zh(AbstractC0881T7 abstractC0881T7) {
        this();
    }
}
