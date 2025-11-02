package p000;

import p000.C1079Xc;

public final class C1125Yc {

    public static final a f3339c = new a(null);

    public long f3340a;

    public final InterfaceC2547x3 f3341b;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C1125Yc(InterfaceC2547x3 interfaceC2547x3) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        this.f3341b = interfaceC2547x3;
        this.f3340a = 262144;
    }

    public final C1079Xc m4936a() {
        C1079Xc.a aVar = new C1079Xc.a();
        while (true) {
            String strM4937b = m4937b();
            if (strM4937b.length() == 0) {
                return aVar.m4745d();
            }
            aVar.m4743b(strM4937b);
        }
    }

    public final String m4937b() {
        String strMo7346q = this.f3341b.mo7346q(this.f3340a);
        this.f3340a -= strMo7346q.length();
        return strMo7346q;
    }
}
