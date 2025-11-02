package p000;

public final class C2659ze extends C2567xe {

    public static final a f8256p = new a(null);

    public static final C2659ze f8257q = new C2659ze(1, 0);

    public static final class a {
        public a() {
        }

        public final C2659ze m11031a() {
            return C2659ze.f8257q;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2659ze(int i, int i2) {
        super(i, i2, 1);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof C2659ze) {
            if (!isEmpty() || !((C2659ze) obj).isEmpty()) {
                C2659ze c2659ze = (C2659ze) obj;
                if (m10716d() != c2659ze.m10716d() || m10717f() != c2659ze.m10717f()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (m10716d() * 31) + m10717f();
    }

    @Override
    public boolean isEmpty() {
        return m10716d() > m10717f();
    }

    public boolean m11028k(int i) {
        return m10716d() <= i && i <= m10717f();
    }

    public Integer m11029o() {
        return Integer.valueOf(m10717f());
    }

    public Integer m11030p() {
        return Integer.valueOf(m10716d());
    }

    @Override
    public String toString() {
        return m10716d() + ".." + m10717f();
    }
}
