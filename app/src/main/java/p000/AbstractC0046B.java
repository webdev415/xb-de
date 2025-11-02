package p000;

public abstract class AbstractC0046B {

    public final C0233F2 f102a;

    public final C2565xc f103b;

    public AbstractC0046B(C0233F2 c0233f2) {
        this.f102a = c0233f2;
        this.f103b = new C2565xc(c0233f2);
    }

    public static AbstractC0046B m172a(C0233F2 c0233f2) {
        if (c0233f2.m1189h(1)) {
            return new C1897j(c0233f2);
        }
        if (!c0233f2.m1189h(2)) {
            return new C0920U0(c0233f2);
        }
        int iM10658g = C2565xc.m10658g(c0233f2, 1, 4);
        if (iM10658g == 4) {
            return new C1617d(c0233f2);
        }
        if (iM10658g == 5) {
            return new C1663e(c0233f2);
        }
        int iM10658g2 = C2565xc.m10658g(c0233f2, 1, 5);
        if (iM10658g2 == 12) {
            return new C1710f(c0233f2);
        }
        if (iM10658g2 == 13) {
            return new C1757g(c0233f2);
        }
        switch (C2565xc.m10658g(c0233f2, 1, 7)) {
            case 56:
                return new C1804h(c0233f2, "310", "11");
            case 57:
                return new C1804h(c0233f2, "320", "11");
            case 58:
                return new C1804h(c0233f2, "310", "13");
            case 59:
                return new C1804h(c0233f2, "320", "13");
            case 60:
                return new C1804h(c0233f2, "310", "15");
            case 61:
                return new C1804h(c0233f2, "320", "15");
            case 62:
                return new C1804h(c0233f2, "310", "17");
            case 63:
                return new C1804h(c0233f2, "320", "17");
            default:
                throw new IllegalStateException("unknown decoder: ".concat(String.valueOf(c0233f2)));
        }
    }

    public final C2565xc m173b() {
        return this.f103b;
    }

    public final C0233F2 m174c() {
        return this.f102a;
    }

    public abstract String mo175d();
}
