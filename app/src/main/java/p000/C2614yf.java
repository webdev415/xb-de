package p000;

public final class C2614yf implements Comparable {

    public static final a f8098p = new a(null);

    public static final C2614yf f8099q = C2660zf.m11032a();

    public final int f8100l;

    public final int f8101m;

    public final int f8102n;

    public final int f8103o;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2614yf(int i, int i2, int i3) {
        this.f8100l = i;
        this.f8101m = i2;
        this.f8102n = i3;
        this.f8103o = m10880e(i, i2, i3);
    }

    @Override
    public int compareTo(C2614yf c2614yf) {
        AbstractC0116Ce.m476e(c2614yf, "other");
        return this.f8103o - c2614yf.f8103o;
    }

    public final int m10880e(int i, int i2, int i3) {
        if (new C2659ze(0, 255).m11028k(i) && new C2659ze(0, 255).m11028k(i2) && new C2659ze(0, 255).m11028k(i3)) {
            return (i << 16) + (i2 << 8) + i3;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i2 + '.' + i3).toString());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        C2614yf c2614yf = obj instanceof C2614yf ? (C2614yf) obj : null;
        return c2614yf != null && this.f8103o == c2614yf.f8103o;
    }

    public int hashCode() {
        return this.f8103o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f8100l);
        sb.append('.');
        sb.append(this.f8101m);
        sb.append('.');
        sb.append(this.f8102n);
        return sb.toString();
    }
}
