package p000;

import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;

public final class C2546x2 extends AbstractC2041m4 {

    public static final a f7936c = new a(null);

    public final InterfaceC0723Pn f7937b;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2546x2(InterfaceC0723Pn interfaceC0723Pn) {
        AbstractC0116Ce.m476e(interfaceC0723Pn, "trustRootIndex");
        this.f7937b = interfaceC0723Pn;
    }

    @Override
    public List mo2573a(List list, String str) throws SSLPeerUnverifiedException {
        AbstractC0116Ce.m476e(list, "chain");
        AbstractC0116Ce.m476e(str, "hostname");
        ArrayDeque arrayDeque = new ArrayDeque(list);
        ArrayList arrayList = new ArrayList<>();
        Object objRemoveFirst = arrayDeque.removeFirst();
        AbstractC0116Ce.m475d(objRemoveFirst, "queue.removeFirst()");
        arrayList.add(objRemoveFirst);
        boolean z = false;
        for (int i = 0; i < 9; i++) {
            Object obj = arrayList.get(arrayList.size() - 1);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
            }
            X509Certificate x509Certificate = (X509Certificate) obj;
            X509Certificate x509CertificateMo3585a = this.f7937b.mo3585a(x509Certificate);
            if (x509CertificateMo3585a == null) {
                Iterator it = arrayDeque.iterator();
                AbstractC0116Ce.m475d(it, "queue.iterator()");
                while (it.hasNext()) {
                    Object next = it.next();
                    if (next == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                    }
                    X509Certificate x509Certificate2 = (X509Certificate) next;
                    if (m10626b(x509Certificate, x509Certificate2)) {
                        it.remove();
                        arrayList.add(x509Certificate2);
                    }
                }
                if (z) {
                    return arrayList;
                }
                throw new SSLPeerUnverifiedException("Failed to find a trusted cert that signed " + x509Certificate);
            }
            if (arrayList.size() > 1 || (!AbstractC0116Ce.m472a(x509Certificate, x509CertificateMo3585a))) {
                arrayList.add(x509CertificateMo3585a);
            }
            if (m10626b(x509CertificateMo3585a, x509CertificateMo3585a)) {
                return arrayList;
            }
            z = true;
        }
        throw new SSLPeerUnverifiedException("Certificate chain too long: " + arrayList);
    }

    public final boolean m10626b(X509Certificate x509Certificate, X509Certificate x509Certificate2) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        if (!AbstractC0116Ce.m472a(x509Certificate.getIssuerDN(), x509Certificate2.getSubjectDN())) {
            return false;
        }
        try {
            x509Certificate.verify(x509Certificate2.getPublicKey());
            return true;
        } catch (GeneralSecurityException unused) {
            return false;
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return (obj instanceof C2546x2) && AbstractC0116Ce.m472a(((C2546x2) obj).f7937b, this.f7937b);
    }

    public int hashCode() {
        return this.f7937b.hashCode();
    }
}
