package p000;

public final class C2611yc {

    public static final C2611yc f8071h = new C2611yc(4201, 4096, 1);

    public static final C2611yc f8072i = new C2611yc(1033, 1024, 1);

    public static final C2611yc f8073j;

    public static final C2611yc f8074k;

    public static final C2611yc f8075l;

    public static final C2611yc f8076m;

    public static final C2611yc f8077n;

    public static final C2611yc f8078o;

    public final int[] f8079a;

    public final int[] f8080b;

    public final C2657zc f8081c;

    public final C2657zc f8082d;

    public final int f8083e;

    public final int f8084f;

    public final int f8085g;

    static {
        C2611yc c2611yc = new C2611yc(67, 64, 1);
        f8073j = c2611yc;
        f8074k = new C2611yc(19, 16, 1);
        f8075l = new C2611yc(285, 256, 0);
        C2611yc c2611yc2 = new C2611yc(301, 256, 1);
        f8076m = c2611yc2;
        f8077n = c2611yc2;
        f8078o = c2611yc;
    }

    public C2611yc(int i, int i2, int i3) {
        this.f8084f = i;
        this.f8083e = i2;
        this.f8085g = i3;
        this.f8079a = new int[i2];
        this.f8080b = new int[i2];
        int i4 = 1;
        for (int i5 = 0; i5 < i2; i5++) {
            this.f8079a[i5] = i4;
            i4 <<= 1;
            if (i4 >= i2) {
                i4 = (i4 ^ i) & (i2 - 1);
            }
        }
        for (int i6 = 0; i6 < i2 - 1; i6++) {
            this.f8080b[this.f8079a[i6]] = i6;
        }
        this.f8081c = new C2657zc(this, new int[]{0});
        this.f8082d = new C2657zc(this, new int[]{1});
    }

    public static int m10855a(int i, int i2) {
        return i ^ i2;
    }

    public C2657zc m10856b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f8081c;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new C2657zc(this, iArr);
    }

    public int m10857c(int i) {
        return this.f8079a[i];
    }

    public int m10858d() {
        return this.f8085g;
    }

    public C2657zc m10859e() {
        return this.f8082d;
    }

    public int m10860f() {
        return this.f8083e;
    }

    public C2657zc m10861g() {
        return this.f8081c;
    }

    public int m10862h(int i) {
        if (i != 0) {
            return this.f8079a[(this.f8083e - this.f8080b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int m10863i(int i) {
        if (i != 0) {
            return this.f8080b[i];
        }
        throw new IllegalArgumentException();
    }

    public int m10864j(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f8079a;
        int[] iArr2 = this.f8080b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f8083e - 1)];
    }

    public String toString() {
        return "GF(0x" + Integer.toHexString(this.f8084f) + ',' + this.f8083e + ')';
    }
}
