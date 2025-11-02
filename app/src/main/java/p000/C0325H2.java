package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class C0325H2 implements Cloneable {

    public final int f1009l;

    public final int f1010m;

    public final int f1011n;

    public final int[] f1012o;

    public C0325H2(int i) {
        this(i, i);
    }

    public final String m1489a(String str, String str2, String str3) {
        StringBuilder sb = new StringBuilder(this.f1010m * (this.f1009l + 1));
        for (int i = 0; i < this.f1010m; i++) {
            for (int i2 = 0; i2 < this.f1009l; i2++) {
                sb.append(m1493e(i2, i) ? str : str2);
            }
            sb.append(str3);
        }
        return sb.toString();
    }

    public void m1490b() {
        int length = this.f1012o.length;
        for (int i = 0; i < length; i++) {
            this.f1012o[i] = 0;
        }
    }

    public C0325H2 clone() {
        return new C0325H2(this.f1009l, this.f1010m, this.f1011n, (int[]) this.f1012o.clone());
    }

    public void m1492d(int i, int i2) {
        int i3 = (i2 * this.f1011n) + (i / 32);
        int[] iArr = this.f1012o;
        iArr[i3] = (1 << (i & 31)) ^ iArr[i3];
    }

    public boolean m1493e(int i, int i2) {
        return ((this.f1012o[(i2 * this.f1011n) + (i / 32)] >>> (i & 31)) & 1) != 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0325H2)) {
            return false;
        }
        C0325H2 c0325h2 = (C0325H2) obj;
        return this.f1009l == c0325h2.f1009l && this.f1010m == c0325h2.f1010m && this.f1011n == c0325h2.f1011n && Arrays.equals(this.f1012o, c0325h2.f1012o);
    }

    public int[] m1494f() {
        int length = this.f1012o.length - 1;
        while (length >= 0 && this.f1012o[length] == 0) {
            length--;
        }
        if (length < 0) {
            return null;
        }
        int i = this.f1011n;
        int i2 = length / i;
        int i3 = (length % i) << 5;
        int i4 = 31;
        while ((this.f1012o[length] >>> i4) == 0) {
            i4--;
        }
        return new int[]{i3 + i4, i2};
    }

    public int[] m1495h() {
        int i = this.f1009l;
        int i2 = this.f1010m;
        int i3 = -1;
        int i4 = -1;
        for (int i5 = 0; i5 < this.f1010m; i5++) {
            int i6 = 0;
            while (true) {
                int i7 = this.f1011n;
                if (i6 < i7) {
                    int i8 = this.f1012o[(i7 * i5) + i6];
                    if (i8 != 0) {
                        if (i5 < i2) {
                            i2 = i5;
                        }
                        if (i5 > i4) {
                            i4 = i5;
                        }
                        int i9 = i6 << 5;
                        if (i9 < i) {
                            int i10 = 0;
                            while ((i8 << (31 - i10)) == 0) {
                                i10++;
                            }
                            int i11 = i10 + i9;
                            if (i11 < i) {
                                i = i11;
                            }
                        }
                        if (i9 + 31 > i3) {
                            int i12 = 31;
                            while ((i8 >>> i12) == 0) {
                                i12--;
                            }
                            int i13 = i9 + i12;
                            if (i13 > i3) {
                                i3 = i13;
                            }
                        }
                    }
                    i6++;
                }
            }
        }
        if (i3 < i || i4 < i2) {
            return null;
        }
        return new int[]{i, i2, (i3 - i) + 1, (i4 - i2) + 1};
    }

    public int hashCode() {
        int i = this.f1009l;
        return (((((((i * 31) + i) * 31) + this.f1010m) * 31) + this.f1011n) * 31) + Arrays.hashCode(this.f1012o);
    }

    public int m1496j() {
        return this.f1010m;
    }

    public C0233F2 m1497m(int i, C0233F2 c0233f2) {
        if (c0233f2 == null || c0233f2.m1193o() < this.f1009l) {
            c0233f2 = new C0233F2(this.f1009l);
        } else {
            c0233f2.m1186d();
        }
        int i2 = i * this.f1011n;
        for (int i3 = 0; i3 < this.f1011n; i3++) {
            c0233f2.m1198v(i3 << 5, this.f1012o[i2 + i3]);
        }
        return c0233f2;
    }

    public int[] m1498n() {
        int[] iArr;
        int i = 0;
        int i2 = 0;
        while (true) {
            iArr = this.f1012o;
            if (i2 >= iArr.length || iArr[i2] != 0) {
                break;
            }
            i2++;
        }
        if (i2 == iArr.length) {
            return null;
        }
        int i3 = this.f1011n;
        int i4 = i2 / i3;
        int i5 = (i2 % i3) << 5;
        while ((iArr[i2] << (31 - i)) == 0) {
            i++;
        }
        return new int[]{i5 + i, i4};
    }

    public int m1499o() {
        return this.f1009l;
    }

    public void m1500q() {
        C0233F2 c0233f2 = new C0233F2(this.f1009l);
        C0233F2 c0233f22 = new C0233F2(this.f1009l);
        int i = (this.f1010m + 1) / 2;
        for (int i2 = 0; i2 < i; i2++) {
            c0233f2 = m1497m(i2, c0233f2);
            int i3 = (this.f1010m - 1) - i2;
            c0233f22 = m1497m(i3, c0233f22);
            c0233f2.m1196t();
            c0233f22.m1196t();
            m1503t(i2, c0233f22);
            m1503t(i3, c0233f2);
        }
    }

    public void m1501r(int i, int i2) {
        int i3 = (i2 * this.f1011n) + (i / 32);
        int[] iArr = this.f1012o;
        iArr[i3] = (1 << (i & 31)) | iArr[i3];
    }

    public void m1502s(int i, int i2, int i3, int i4) {
        if (i2 < 0 || i < 0) {
            throw new IllegalArgumentException("Left and top must be nonnegative");
        }
        if (i4 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException("Height and width must be at least 1");
        }
        int i5 = i3 + i;
        int i6 = i4 + i2;
        if (i6 > this.f1010m || i5 > this.f1009l) {
            throw new IllegalArgumentException("The region must fit inside the matrix");
        }
        while (i2 < i6) {
            int i7 = this.f1011n * i2;
            for (int i8 = i; i8 < i5; i8++) {
                int[] iArr = this.f1012o;
                int i9 = (i8 / 32) + i7;
                iArr[i9] = iArr[i9] | (1 << (i8 & 31));
            }
            i2++;
        }
    }

    public void m1503t(int i, C0233F2 c0233f2) {
        int[] iArrM1190j = c0233f2.m1190j();
        int[] iArr = this.f1012o;
        int i2 = this.f1011n;
        System.arraycopy(iArrM1190j, 0, iArr, i * i2, i2);
    }

    public String toString() {
        return m1504u("X ", "  ");
    }

    public String m1504u(String str, String str2) {
        return m1489a(str, str2, "\n");
    }

    public C0325H2(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException("Both dimensions must be greater than 0");
        }
        this.f1009l = i;
        this.f1010m = i2;
        int i3 = (i + 31) / 32;
        this.f1011n = i3;
        this.f1012o = new int[i3 * i2];
    }

    public C0325H2(int i, int i2, int i3, int[] iArr) {
        this.f1009l = i;
        this.f1010m = i2;
        this.f1011n = i3;
        this.f1012o = iArr;
    }
}
