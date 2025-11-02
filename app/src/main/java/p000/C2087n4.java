package p000;

import java.security.Principal;
import java.security.PublicKey;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLPeerUnverifiedException;
import p000.C0096C3;

/* loaded from: classes.dex */
public final class C2087n4 {

    public final Set f6295a;

    public final AbstractC2041m4 f6296b;

    public static final b f6294d = new b(null);

    public static final C2087n4 f6293c = new a().m8728a();

    public static final class a {

        public final List f6297a = new ArrayList<>();

        public final C2087n4 m8728a() {
            return new C2087n4(AbstractC2181p5.m9022J(this.f6297a), null, 2, 0 == true ? 1 : 0);
        }
    }

    public static final class b {
        public b() {
        }

        public final String m8729a(Certificate certificate) {
            AbstractC0116Ce.m476e(certificate, "certificate");
            if (!(certificate instanceof X509Certificate)) {
                throw new IllegalArgumentException("Certificate pinning requires X509 certificates".toString());
            }
            return "sha256/" + m8730b((X509Certificate) certificate).mo371c();
        }

        public final C0096C3 m8730b(X509Certificate x509Certificate) {
            AbstractC0116Ce.m476e(x509Certificate, "$this$sha256Hash");
            C0096C3.a aVar = C0096C3.f235p;
            PublicKey publicKey = x509Certificate.getPublicKey();
            AbstractC0116Ce.m475d(publicKey, "publicKey");
            byte[] encoded = publicKey.getEncoded();
            AbstractC0116Ce.m475d(encoded, "publicKey.encoded");
            return C0096C3.a.m392e(aVar, encoded, 0, 0, 3, null).m386t();
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC0894Tb {

        public final List f6299n;

        public final String f6300o;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(List list, String str) {
            super(0);
            this.f6299n = list;
            this.f6300o = str;
        }

        @Override
        public final List mo4135c() {
            List listMo2573a;
            AbstractC2041m4 abstractC2041m4M8726d = C2087n4.this.m8726d();
            if (abstractC2041m4M8726d == null || (listMo2573a = abstractC2041m4M8726d.mo2573a(this.f6299n, this.f6300o)) == null) {
                listMo2573a = this.f6299n;
            }
            List<Certificate> list = listMo2573a;
            ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(list, 10));
            for (Certificate certificate : list) {
                if (certificate == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
                }
                arrayList.add((X509Certificate) certificate);
            }
            return arrayList;
        }
    }

    public C2087n4(Set set, AbstractC2041m4 abstractC2041m4) {
        AbstractC0116Ce.m476e(set, "pins");
        this.f6295a = set;
        this.f6296b = abstractC2041m4;
    }

    public final void m8723a(String str, List list) {
        AbstractC0116Ce.m476e(str, "hostname");
        AbstractC0116Ce.m476e(list, "peerCertificates");
        m8724b(str, new c(list, str));
    }

    public final void m8724b(String str, InterfaceC0894Tb interfaceC0894Tb) throws SSLPeerUnverifiedException {
        AbstractC0116Ce.m476e(str, "hostname");
        AbstractC0116Ce.m476e(interfaceC0894Tb, "cleanedPeerCertificatesFn");
        List listM8725c = m8725c(str);
        if (listM8725c.isEmpty()) {
            return;
        }
        List<X509Certificate> list = (List) interfaceC0894Tb.mo4135c();
        for (X509Certificate x509Certificate : list) {
            Iterator it = listM8725c.iterator();
            if (it.hasNext()) {
                AbstractC2524wh.m10586a(it.next());
                throw null;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Certificate pinning failure!");
        sb.append("\n  Peer certificate chain:");
        for (X509Certificate x509Certificate2 : list) {
            sb.append("\n    ");
            sb.append(f6294d.m8729a(x509Certificate2));
            sb.append(": ");
            Principal subjectDN = x509Certificate2.getSubjectDN();
            AbstractC0116Ce.m475d(subjectDN, "element.subjectDN");
            sb.append(subjectDN.getName());
        }
        sb.append("\n  Pinned certificates for ");
        sb.append(str);
        sb.append(":");
        Iterator it2 = listM8725c.iterator();
        while (it2.hasNext()) {
            AbstractC2524wh.m10586a(it2.next());
            sb.append("\n    ");
            sb.append((Object) null);
        }
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        throw new SSLPeerUnverifiedException(string);
    }

    public final List m8725c(String str) {
        AbstractC0116Ce.m476e(str, "hostname");
        Set set = this.f6295a;
        List listM7783f = AbstractC1810h5.m7783f();
        Iterator it = set.iterator();
        if (!it.hasNext()) {
            return listM7783f;
        }
        AbstractC2524wh.m10586a(it.next());
        throw null;
    }

    public final AbstractC2041m4 m8726d() {
        return this.f6296b;
    }

    public final C2087n4 m8727e(AbstractC2041m4 abstractC2041m4) {
        AbstractC0116Ce.m476e(abstractC2041m4, "certificateChainCleaner");
        return AbstractC0116Ce.m472a(this.f6296b, abstractC2041m4) ? this : new C2087n4(this.f6295a, abstractC2041m4);
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2087n4) {
            C2087n4 c2087n4 = (C2087n4) obj;
            if (AbstractC0116Ce.m472a(c2087n4.f6295a, this.f6295a) && AbstractC0116Ce.m472a(c2087n4.f6296b, this.f6296b)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (1517 + this.f6295a.hashCode()) * 41;
        AbstractC2041m4 abstractC2041m4 = this.f6296b;
        return iHashCode + (abstractC2041m4 != null ? abstractC2041m4.hashCode() : 0);
    }

    public C2087n4(Set set, AbstractC2041m4 abstractC2041m4, int i, AbstractC0881T7 abstractC0881T7) {
        this(set, (i & 2) != 0 ? null : abstractC2041m4);
    }
}
