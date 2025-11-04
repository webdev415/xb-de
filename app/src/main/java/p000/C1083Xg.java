package p000;

public final class C1083Xg {

    public static final C1083Xg f3249f = new C1083Xg(929, 3);

    public final int[] f3250a;

    public final int[] f3251b;

    public final C1129Yg f3252c;

    public final C1129Yg f3253d;

    public final int f3254e;

    public C1083Xg(int i, int i2) {
        this.f3254e = i;
        this.f3250a = new int[i];
        this.f3251b = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.f3250a[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.f3251b[this.f3250a[i5]] = i5;
        }
        this.f3252c = new C1129Yg(this, new int[]{0});
        this.f3253d = new C1129Yg(this, new int[]{1});
    }

    public int m4782a(int i, int i2) {
        return (i + i2) % this.f3254e;
    }

    public C1129Yg m4783b(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        }
        if (i2 == 0) {
            return this.f3252c;
        }
        int[] iArr = new int[i + 1];
        iArr[0] = i2;
        return new C1129Yg(this, iArr);
    }

    public int m4784c(int i) {
        return this.f3250a[i];
    }

    public C1129Yg m4785d() {
        return this.f3253d;
    }

    public int m4786e() {
        return this.f3254e;
    }

    public C1129Yg m4787f() {
        return this.f3252c;
    }

    public int m4788g(int i) {
        if (i != 0) {
            return this.f3250a[(this.f3254e - this.f3251b[i]) - 1];
        }
        throw new ArithmeticException();
    }

    public int m4789h(int i) {
        if (i != 0) {
            return this.f3251b[i];
        }
        throw new IllegalArgumentException();
    }

    public int m4790i(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.f3250a;
        int[] iArr2 = this.f3251b;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.f3254e - 1)];
    }

    public int m4791j(int i, int i2) {
        int i3 = this.f3254e;
        return ((i + i3) - i2) % i3;
    }
}
