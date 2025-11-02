package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import javax.net.ssl.SSLSocket;

public final class C1811h6 {

    public static final C0281G4[] f5677e;

    public static final C0281G4[] f5678f;

    public static final C1811h6 f5679g;

    public static final C1811h6 f5680h;

    public static final C1811h6 f5681i;

    public static final C1811h6 f5682j;

    public static final b f5683k = new b(null);

    public final boolean f5684a;

    public final boolean f5685b;

    public final String[] f5686c;

    public final String[] f5687d;

    public static final class a {

        public boolean f5688a;

        public String[] f5689b;

        public String[] f5690c;

        public boolean f5691d;

        public a(C1811h6 c1811h6) {
            AbstractC0116Ce.m476e(c1811h6, "connectionSpec");
            this.f5688a = c1811h6.m7796f();
            this.f5689b = c1811h6.f5686c;
            this.f5690c = c1811h6.f5687d;
            this.f5691d = c1811h6.m7798h();
        }

        public final C1811h6 m7800a() {
            return new C1811h6(this.f5688a, this.f5691d, this.f5689b, this.f5690c);
        }

        public final a m7801b(C0281G4... c0281g4Arr) {
            AbstractC0116Ce.m476e(c0281g4Arr, "cipherSuites");
            if (!this.f5688a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList<>(c0281g4Arr.length);
            for (C0281G4 c0281g4 : c0281g4Arr) {
                arrayList.add(c0281g4.m1339c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return m7802c((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a m7802c(String... strArr) throws CloneNotSupportedException {
            AbstractC0116Ce.m476e(strArr, "cipherSuites");
            if (!this.f5688a) {
                throw new IllegalArgumentException("no cipher suites for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one cipher suite is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f5689b = (String[]) objClone;
            return this;
        }

        public final a m7803d(boolean z) {
            if (!this.f5688a) {
                throw new IllegalArgumentException("no TLS extensions for cleartext connections".toString());
            }
            this.f5691d = z;
            return this;
        }

        public final a m7804e(EnumC0171Dn... enumC0171DnArr) {
            AbstractC0116Ce.m476e(enumC0171DnArr, "tlsVersions");
            if (!this.f5688a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            ArrayList arrayList = new ArrayList<>(enumC0171DnArr.length);
            for (EnumC0171Dn enumC0171Dn : enumC0171DnArr) {
                arrayList.add(enumC0171Dn.m734c());
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
            }
            String[] strArr = (String[]) array;
            return m7805f((String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final a m7805f(String... strArr) throws CloneNotSupportedException {
            AbstractC0116Ce.m476e(strArr, "tlsVersions");
            if (!this.f5688a) {
                throw new IllegalArgumentException("no TLS versions for cleartext connections".toString());
            }
            if (!(!(strArr.length == 0))) {
                throw new IllegalArgumentException("At least one TLS version is required".toString());
            }
            Object objClone = strArr.clone();
            if (objClone == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.String>");
            }
            this.f5690c = (String[]) objClone;
            return this;
        }

        public a(boolean z) {
            this.f5688a = z;
        }
    }

    public static final class b {
        public b() {
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    static {
        C0281G4 c0281g4 = C0281G4.f825n1;
        C0281G4 c0281g42 = C0281G4.f828o1;
        C0281G4 c0281g43 = C0281G4.f831p1;
        C0281G4 c0281g44 = C0281G4.f784Z0;
        C0281G4 c0281g45 = C0281G4.f795d1;
        C0281G4 c0281g46 = C0281G4.f786a1;
        C0281G4 c0281g47 = C0281G4.f798e1;
        C0281G4 c0281g48 = C0281G4.f816k1;
        C0281G4 c0281g49 = C0281G4.f813j1;
        C0281G4[] c0281g4Arr = {c0281g4, c0281g42, c0281g43, c0281g44, c0281g45, c0281g46, c0281g47, c0281g48, c0281g49};
        f5677e = c0281g4Arr;
        C0281G4[] c0281g4Arr2 = {c0281g4, c0281g42, c0281g43, c0281g44, c0281g45, c0281g46, c0281g47, c0281g48, c0281g49, C0281G4.f754K0, C0281G4.f756L0, C0281G4.f809i0, C0281G4.f812j0, C0281G4.f745G, C0281G4.f753K, C0281G4.f814k};
        f5678f = c0281g4Arr2;
        a aVarM7801b = new a(true).m7801b((C0281G4[]) Arrays.copyOf(c0281g4Arr, c0281g4Arr.length));
        EnumC0171Dn enumC0171Dn = EnumC0171Dn.TLS_1_3;
        EnumC0171Dn enumC0171Dn2 = EnumC0171Dn.TLS_1_2;
        f5679g = aVarM7801b.m7804e(enumC0171Dn, enumC0171Dn2).m7803d(true).m7800a();
        f5680h = new a(true).m7801b((C0281G4[]) Arrays.copyOf(c0281g4Arr2, c0281g4Arr2.length)).m7804e(enumC0171Dn, enumC0171Dn2).m7803d(true).m7800a();
        f5681i = new a(true).m7801b((C0281G4[]) Arrays.copyOf(c0281g4Arr2, c0281g4Arr2.length)).m7804e(enumC0171Dn, enumC0171Dn2, EnumC0171Dn.TLS_1_1, EnumC0171Dn.TLS_1_0).m7803d(true).m7800a();
        f5682j = new a(false).m7800a();
    }

    public C1811h6(boolean z, boolean z2, String[] strArr, String[] strArr2) {
        this.f5684a = z;
        this.f5685b = z2;
        this.f5686c = strArr;
        this.f5687d = strArr2;
    }

    public final void m7793c(SSLSocket sSLSocket, boolean z) throws CloneNotSupportedException {
        AbstractC0116Ce.m476e(sSLSocket, "sslSocket");
        C1811h6 c1811h6M7797g = m7797g(sSLSocket, z);
        if (c1811h6M7797g.m7799i() != null) {
            sSLSocket.setEnabledProtocols(c1811h6M7797g.f5687d);
        }
        if (c1811h6M7797g.m7794d() != null) {
            sSLSocket.setEnabledCipherSuites(c1811h6M7797g.f5686c);
        }
    }

    public final List m7794d() {
        String[] strArr = this.f5686c;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(C0281G4.f840s1.m1342b(str));
        }
        return AbstractC2181p5.m9019G(arrayList);
    }

    public final boolean m7795e(SSLSocket sSLSocket) {
        AbstractC0116Ce.m476e(sSLSocket, "socket");
        if (!this.f5684a) {
            return false;
        }
        String[] strArr = this.f5687d;
        if (strArr != null && !AbstractC2623yo.m10943r(strArr, sSLSocket.getEnabledProtocols(), AbstractC2595y5.m10834b())) {
            return false;
        }
        String[] strArr2 = this.f5686c;
        return strArr2 == null || AbstractC2623yo.m10943r(strArr2, sSLSocket.getEnabledCipherSuites(), C0281G4.f840s1.m1343c());
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C1811h6)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        boolean z = this.f5684a;
        C1811h6 c1811h6 = (C1811h6) obj;
        if (z != c1811h6.f5684a) {
            return false;
        }
        return !z || (Arrays.equals(this.f5686c, c1811h6.f5686c) && Arrays.equals(this.f5687d, c1811h6.f5687d) && this.f5685b == c1811h6.f5685b);
    }

    public final boolean m7796f() {
        return this.f5684a;
    }

    public final C1811h6 m7797g(SSLSocket sSLSocket, boolean z) throws CloneNotSupportedException {
        String[] enabledCipherSuites;
        String[] enabledProtocols;
        if (this.f5686c != null) {
            String[] enabledCipherSuites2 = sSLSocket.getEnabledCipherSuites();
            AbstractC0116Ce.m475d(enabledCipherSuites2, "sslSocket.enabledCipherSuites");
            enabledCipherSuites = AbstractC2623yo.m10906B(enabledCipherSuites2, this.f5686c, C0281G4.f840s1.m1343c());
        } else {
            enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f5687d != null) {
            String[] enabledProtocols2 = sSLSocket.getEnabledProtocols();
            AbstractC0116Ce.m475d(enabledProtocols2, "sslSocket.enabledProtocols");
            enabledProtocols = AbstractC2623yo.m10906B(enabledProtocols2, this.f5687d, AbstractC2595y5.m10834b());
        } else {
            enabledProtocols = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        AbstractC0116Ce.m475d(supportedCipherSuites, "supportedCipherSuites");
        int iM10946u = AbstractC2623yo.m10946u(supportedCipherSuites, "TLS_FALLBACK_SCSV", C0281G4.f840s1.m1343c());
        if (z && iM10946u != -1) {
            AbstractC0116Ce.m475d(enabledCipherSuites, "cipherSuitesIntersection");
            String str = supportedCipherSuites[iM10946u];
            AbstractC0116Ce.m475d(str, "supportedCipherSuites[indexOfFallbackScsv]");
            enabledCipherSuites = AbstractC2623yo.m10937l(enabledCipherSuites, str);
        }
        a aVar = new a(this);
        AbstractC0116Ce.m475d(enabledCipherSuites, "cipherSuitesIntersection");
        a aVarM7802c = aVar.m7802c((String[]) Arrays.copyOf(enabledCipherSuites, enabledCipherSuites.length));
        AbstractC0116Ce.m475d(enabledProtocols, "tlsVersionsIntersection");
        return aVarM7802c.m7805f((String[]) Arrays.copyOf(enabledProtocols, enabledProtocols.length)).m7800a();
    }

    public final boolean m7798h() {
        return this.f5685b;
    }

    public int hashCode() {
        if (!this.f5684a) {
            return 17;
        }
        String[] strArr = this.f5686c;
        int iHashCode = (527 + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        String[] strArr2 = this.f5687d;
        return ((iHashCode + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31) + (!this.f5685b ? 1 : 0);
    }

    public final List m7799i() {
        String[] strArr = this.f5687d;
        if (strArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList<>(strArr.length);
        for (String str : strArr) {
            arrayList.add(EnumC0171Dn.f428s.m735a(str));
        }
        return AbstractC2181p5.m9019G(arrayList);
    }

    public String toString() {
        if (!this.f5684a) {
            return "ConnectionSpec()";
        }
        return "ConnectionSpec(cipherSuites=" + Objects.toString(m7794d(), "[all enabled]") + ", tlsVersions=" + Objects.toString(m7799i(), "[all enabled]") + ", supportsTlsExtensions=" + this.f5685b + ')';
    }
}
