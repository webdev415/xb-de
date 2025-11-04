package p000;

import android.net.http.X509TrustManagerExtensions;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.X509TrustManager;

public final class C0507L0 extends AbstractC2041m4 {

    public static final a f1644d = new a(null);

    public final X509TrustManager f1645b;

    public final X509TrustManagerExtensions f1646c;

    public static final class a {
        public a() {
        }

        public final C0507L0 m2574a(X509TrustManager x509TrustManager) {
            X509TrustManagerExtensions x509TrustManagerExtensions;
            AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
            try {
                x509TrustManagerExtensions = new X509TrustManagerExtensions(x509TrustManager);
            } catch (IllegalArgumentException unused) {
                x509TrustManagerExtensions = null;
            }
            if (x509TrustManagerExtensions != null) {
                return new C0507L0(x509TrustManager, x509TrustManagerExtensions);
            }
            return null;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0507L0(X509TrustManager x509TrustManager, X509TrustManagerExtensions x509TrustManagerExtensions) {
        AbstractC0116Ce.m476e(x509TrustManager, "trustManager");
        AbstractC0116Ce.m476e(x509TrustManagerExtensions, "x509TrustManagerExtensions");
        this.f1645b = x509TrustManager;
        this.f1646c = x509TrustManagerExtensions;
    }

    @Override
    public List mo2573a(List list, String str) throws CertificateException, SSLPeerUnverifiedException {
        AbstractC0116Ce.m476e(list, "chain");
        AbstractC0116Ce.m476e(str, "hostname");
        Object[] array = list.toArray(new X509Certificate[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }
        try {
            List<X509Certificate> listCheckServerTrusted = this.f1646c.checkServerTrusted((X509Certificate[]) array, "RSA", str);
            AbstractC0116Ce.m475d(listCheckServerTrusted, "x509TrustManagerExtensio…ficates, \"RSA\", hostname)");
            return listCheckServerTrusted;
        } catch (CertificateException e) {
            SSLPeerUnverifiedException sSLPeerUnverifiedException = new SSLPeerUnverifiedException(e.getMessage());
            sSLPeerUnverifiedException.initCause(e);
            throw sSLPeerUnverifiedException;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0507L0) && ((C0507L0) obj).f1645b == this.f1645b;
    }

    public int hashCode() {
        return System.identityHashCode(this.f1645b);
    }
}
