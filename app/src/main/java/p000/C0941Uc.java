package p000;

import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class C0941Uc {

    public static final a f2850e = new a(null);

    public final InterfaceC0071Bf f2851a;

    public final EnumC0171Dn f2852b;

    public final C0281G4 f2853c;

    public final List f2854d;

    public static final class a {

        public static final class C2700a extends AbstractC0025Af implements InterfaceC0894Tb {

            public final List f2855m;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C2700a(List list) {
                super(0);
                this.f2855m = list;
            }

            @Override
            public final List mo4135c() {
                return this.f2855m;
            }
        }

        public a() {
        }

        public final C0941Uc m4248a(SSLSession sSLSession) throws IOException {
            List listM7783f;
            AbstractC0116Ce.m476e(sSLSession, "$this$handshake");
            String cipherSuite = sSLSession.getCipherSuite();
            if (cipherSuite == null) {
                throw new IllegalStateException("cipherSuite == null".toString());
            }
            int iHashCode = cipherSuite.hashCode();
            if (iHashCode == 1019404634 ? cipherSuite.equals("TLS_NULL_WITH_NULL_NULL") : iHashCode == 1208658923 && cipherSuite.equals("SSL_NULL_WITH_NULL_NULL")) {
                throw new IOException("cipherSuite == " + cipherSuite);
            }
            C0281G4 c0281g4M1342b = C0281G4.f840s1.m1342b(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null".toString());
            }
            if (AbstractC0116Ce.m472a("NONE", protocol)) {
                throw new IOException("tlsVersion == NONE");
            }
            EnumC0171Dn enumC0171DnM735a = EnumC0171Dn.f428s.m735a(protocol);
            try {
                listM7783f = m4249b(sSLSession.getPeerCertificates());
            } catch (SSLPeerUnverifiedException unused) {
                listM7783f = AbstractC1810h5.m7783f();
            }
            return new C0941Uc(enumC0171DnM735a, c0281g4M1342b, m4249b(sSLSession.getLocalCertificates()), new C2700a(listM7783f));
        }

        public final List m4249b(Certificate[] certificateArr) {
            return certificateArr != null ? AbstractC2623yo.m10945t((Certificate[]) Arrays.copyOf(certificateArr, certificateArr.length)) : AbstractC1810h5.m7783f();
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC0894Tb {

        public final InterfaceC0894Tb f2856m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(InterfaceC0894Tb interfaceC0894Tb) {
            super(0);
            this.f2856m = interfaceC0894Tb;
        }

        @Override
        public final List mo4135c() {
            try {
                return (List) this.f2856m.mo4135c();
            } catch (SSLPeerUnverifiedException unused) {
                return AbstractC1810h5.m7783f();
            }
        }
    }

    public C0941Uc(EnumC0171Dn enumC0171Dn, C0281G4 c0281g4, List list, InterfaceC0894Tb interfaceC0894Tb) {
        AbstractC0116Ce.m476e(enumC0171Dn, "tlsVersion");
        AbstractC0116Ce.m476e(c0281g4, "cipherSuite");
        AbstractC0116Ce.m476e(list, "localCertificates");
        AbstractC0116Ce.m476e(interfaceC0894Tb, "peerCertificatesFn");
        this.f2852b = enumC0171Dn;
        this.f2853c = c0281g4;
        this.f2854d = list;
        this.f2851a = AbstractC0209Ef.m1038a(new b(interfaceC0894Tb));
    }

    public final C0281G4 m4243a() {
        return this.f2853c;
    }

    public final String m4244b(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return ((X509Certificate) certificate).getSubjectDN().toString();
        }
        String type = certificate.getType();
        AbstractC0116Ce.m475d(type, "type");
        return type;
    }

    public final List m4245c() {
        return this.f2854d;
    }

    public final List m4246d() {
        return (List) this.f2851a.getValue();
    }

    public final EnumC0171Dn m4247e() {
        return this.f2852b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0941Uc) {
            C0941Uc c0941Uc = (C0941Uc) obj;
            if (c0941Uc.f2852b == this.f2852b && AbstractC0116Ce.m472a(c0941Uc.f2853c, this.f2853c) && AbstractC0116Ce.m472a(c0941Uc.m4246d(), m4246d()) && AbstractC0116Ce.m472a(c0941Uc.f2854d, this.f2854d)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((527 + this.f2852b.hashCode()) * 31) + this.f2853c.hashCode()) * 31) + m4246d().hashCode()) * 31) + this.f2854d.hashCode();
    }

    public String toString() {
        List listM4246d = m4246d();
        ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(listM4246d, 10));
        Iterator it = listM4246d.iterator();
        while (it.hasNext()) {
            arrayList.add(m4244b((Certificate) it.next()));
        }
        String string = arrayList.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("Handshake{");
        sb.append("tlsVersion=");
        sb.append(this.f2852b);
        sb.append(' ');
        sb.append("cipherSuite=");
        sb.append(this.f2853c);
        sb.append(' ');
        sb.append("peerCertificates=");
        sb.append(string);
        sb.append(' ');
        sb.append("localCertificates=");
        List list = this.f2854d;
        ArrayList arrayList2 = new ArrayList<>(AbstractC1857i5.m7866n(list, 10));
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            arrayList2.add(m4244b((Certificate) it2.next()));
        }
        sb.append(arrayList2);
        sb.append('}');
        return sb.toString();
    }
}
