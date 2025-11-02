package p000;

public final class C0767Ql {

    public static final a f2288c = new a(null);

    public int f2289a;

    public final int[] f2290b = new int[10];

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public final int m3697a(int i) {
        return this.f2290b[i];
    }

    public final int m3698b() {
        if ((this.f2289a & 2) != 0) {
            return this.f2290b[1];
        }
        return -1;
    }

    public final int m3699c() {
        if ((this.f2289a & 128) != 0) {
            return this.f2290b[7];
        }
        return 65535;
    }

    public final int m3700d() {
        if ((this.f2289a & 16) != 0) {
            return this.f2290b[4];
        }
        return Integer.MAX_VALUE;
    }

    public final int m3701e(int i) {
        return (this.f2289a & 32) != 0 ? this.f2290b[5] : i;
    }

    public final boolean m3702f(int i) {
        return ((1 << i) & this.f2289a) != 0;
    }

    public final void m3703g(C0767Ql c0767Ql) {
        AbstractC0116Ce.m476e(c0767Ql, "other");
        for (int i = 0; i < 10; i++) {
            if (c0767Ql.m3702f(i)) {
                m3704h(i, c0767Ql.m3697a(i));
            }
        }
    }

    public final C0767Ql m3704h(int i, int i2) {
        if (i >= 0) {
            int[] iArr = this.f2290b;
            if (i < iArr.length) {
                this.f2289a = (1 << i) | this.f2289a;
                iArr[i] = i2;
            }
        }
        return this;
    }

    public final int m3705i() {
        return Integer.bitCount(this.f2289a);
    }
}
