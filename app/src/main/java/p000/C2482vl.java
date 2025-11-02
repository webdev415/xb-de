package p000;

public final class C2482vl {

    public static final a f7757h = new a(null);

    public final byte[] f7758a;

    public int f7759b;

    public int f7760c;

    public boolean f7761d;

    public boolean f7762e;

    public C2482vl f7763f;

    public C2482vl f7764g;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2482vl() {
        this.f7758a = new byte[8192];
        this.f7762e = true;
        this.f7761d = false;
    }

    public final void m10396a() {
        C2482vl c2482vl = this.f7764g;
        int i = 0;
        if (!(c2482vl != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        AbstractC0116Ce.m473b(c2482vl);
        if (c2482vl.f7762e) {
            int i2 = this.f7760c - this.f7759b;
            C2482vl c2482vl2 = this.f7764g;
            AbstractC0116Ce.m473b(c2482vl2);
            int i3 = 8192 - c2482vl2.f7760c;
            C2482vl c2482vl3 = this.f7764g;
            AbstractC0116Ce.m473b(c2482vl3);
            if (!c2482vl3.f7761d) {
                C2482vl c2482vl4 = this.f7764g;
                AbstractC0116Ce.m473b(c2482vl4);
                i = c2482vl4.f7759b;
            }
            if (i2 > i3 + i) {
                return;
            }
            C2482vl c2482vl5 = this.f7764g;
            AbstractC0116Ce.m473b(c2482vl5);
            m10401f(c2482vl5, i2);
            m10397b();
            C2528wl.m10594b(this);
        }
    }

    public final C2482vl m10397b() {
        C2482vl c2482vl = this.f7763f;
        if (c2482vl == this) {
            c2482vl = null;
        }
        C2482vl c2482vl2 = this.f7764g;
        AbstractC0116Ce.m473b(c2482vl2);
        c2482vl2.f7763f = this.f7763f;
        C2482vl c2482vl3 = this.f7763f;
        AbstractC0116Ce.m473b(c2482vl3);
        c2482vl3.f7764g = this.f7764g;
        this.f7763f = null;
        this.f7764g = null;
        return c2482vl;
    }

    public final C2482vl m10398c(C2482vl c2482vl) {
        AbstractC0116Ce.m476e(c2482vl, "segment");
        c2482vl.f7764g = this;
        c2482vl.f7763f = this.f7763f;
        C2482vl c2482vl2 = this.f7763f;
        AbstractC0116Ce.m473b(c2482vl2);
        c2482vl2.f7764g = c2482vl;
        this.f7763f = c2482vl;
        return c2482vl;
    }

    public final C2482vl m10399d() {
        this.f7761d = true;
        return new C2482vl(this.f7758a, this.f7759b, this.f7760c, true, false);
    }

    public final C2482vl m10400e(int i) {
        C2482vl c2482vlM10595c;
        if (!(i > 0 && i <= this.f7760c - this.f7759b)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (i >= 1024) {
            c2482vlM10595c = m10399d();
        } else {
            c2482vlM10595c = C2528wl.m10595c();
            byte[] bArr = this.f7758a;
            byte[] bArr2 = c2482vlM10595c.f7758a;
            int i2 = this.f7759b;
            AbstractC2637z1.m10984f(bArr, bArr2, 0, i2, i2 + i, 2, null);
        }
        c2482vlM10595c.f7760c = c2482vlM10595c.f7759b + i;
        this.f7759b += i;
        C2482vl c2482vl = this.f7764g;
        AbstractC0116Ce.m473b(c2482vl);
        c2482vl.m10398c(c2482vlM10595c);
        return c2482vlM10595c;
    }

    public final void m10401f(C2482vl c2482vl, int i) {
        AbstractC0116Ce.m476e(c2482vl, "sink");
        if (!c2482vl.f7762e) {
            throw new IllegalStateException("only owner can write".toString());
        }
        int i2 = c2482vl.f7760c;
        if (i2 + i > 8192) {
            if (c2482vl.f7761d) {
                throw new IllegalArgumentException();
            }
            int i3 = c2482vl.f7759b;
            if ((i2 + i) - i3 > 8192) {
                throw new IllegalArgumentException();
            }
            byte[] bArr = c2482vl.f7758a;
            AbstractC2637z1.m10984f(bArr, bArr, 0, i3, i2, 2, null);
            c2482vl.f7760c -= c2482vl.f7759b;
            c2482vl.f7759b = 0;
        }
        byte[] bArr2 = this.f7758a;
        byte[] bArr3 = c2482vl.f7758a;
        int i4 = c2482vl.f7760c;
        int i5 = this.f7759b;
        AbstractC2637z1.m10982d(bArr2, bArr3, i4, i5, i5 + i);
        c2482vl.f7760c += i;
        this.f7759b += i;
    }

    public C2482vl(byte[] bArr, int i, int i2, boolean z, boolean z2) {
        AbstractC0116Ce.m476e(bArr, "data");
        this.f7758a = bArr;
        this.f7759b = i;
        this.f7760c = i2;
        this.f7761d = z;
        this.f7762e = z2;
    }
}
