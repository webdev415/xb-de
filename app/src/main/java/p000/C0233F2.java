package p000;

import java.util.Arrays;

public final class C0233F2 implements Cloneable {

    public int[] f633l;

    public int f634m;

    public C0233F2() {
        this.f634m = 0;
        this.f633l = new int[1];
    }

    public static int[] m1182s(int i) {
        return new int[(i + 31) / 32];
    }

    public void m1183a(boolean z) {
        m1188f(this.f634m + 1);
        if (z) {
            int[] iArr = this.f633l;
            int i = this.f634m;
            int i2 = i / 32;
            iArr[i2] = (1 << (i & 31)) | iArr[i2];
        }
        this.f634m++;
    }

    public void m1184b(C0233F2 c0233f2) {
        int i = c0233f2.f634m;
        m1188f(this.f634m + i);
        for (int i2 = 0; i2 < i; i2++) {
            m1183a(c0233f2.m1189h(i2));
        }
    }

    public void m1185c(int i, int i2) {
        if (i2 < 0 || i2 > 32) {
            throw new IllegalArgumentException("Num bits must be between 0 and 32");
        }
        m1188f(this.f634m + i2);
        while (i2 > 0) {
            boolean z = true;
            if (((i >> (i2 - 1)) & 1) != 1) {
                z = false;
            }
            m1183a(z);
            i2--;
        }
    }

    public void m1186d() {
        int length = this.f633l.length;
        for (int i = 0; i < length; i++) {
            this.f633l[i] = 0;
        }
    }

    public C0233F2 clone() {
        return new C0233F2((int[]) this.f633l.clone(), this.f634m);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0233F2)) {
            return false;
        }
        C0233F2 c0233f2 = (C0233F2) obj;
        return this.f634m == c0233f2.f634m && Arrays.equals(this.f633l, c0233f2.f633l);
    }

    public final void m1188f(int i) {
        if (i > (this.f633l.length << 5)) {
            int[] iArrM1182s = m1182s(i);
            int[] iArr = this.f633l;
            System.arraycopy(iArr, 0, iArrM1182s, 0, iArr.length);
            this.f633l = iArrM1182s;
        }
    }

    public boolean m1189h(int i) {
        return ((1 << (i & 31)) & this.f633l[i / 32]) != 0;
    }

    public int hashCode() {
        return (this.f634m * 31) + Arrays.hashCode(this.f633l);
    }

    public int[] m1190j() {
        return this.f633l;
    }

    public int m1191m(int i) {
        int i2 = this.f634m;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & this.f633l[i3];
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f633l;
            if (i3 == iArr.length) {
                return this.f634m;
            }
            i4 = iArr[i3];
        }
        return Math.min((i3 << 5) + Integer.numberOfTrailingZeros(i4), this.f634m);
    }

    public int m1192n(int i) {
        int i2 = this.f634m;
        if (i >= i2) {
            return i2;
        }
        int i3 = i / 32;
        int i4 = (-(1 << (i & 31))) & (~this.f633l[i3]);
        while (i4 == 0) {
            i3++;
            int[] iArr = this.f633l;
            if (i3 == iArr.length) {
                return this.f634m;
            }
            i4 = ~iArr[i3];
        }
        return Math.min((i3 << 5) + Integer.numberOfTrailingZeros(i4), this.f634m);
    }

    public int m1193o() {
        return this.f634m;
    }

    public int m1194q() {
        return (this.f634m + 7) / 8;
    }

    public boolean m1195r(int i, int i2, boolean z) {
        if (i2 < i || i < 0 || i2 > this.f634m) {
            throw new IllegalArgumentException();
        }
        if (i2 == i) {
            return true;
        }
        int i3 = i2 - 1;
        int i4 = i / 32;
        int i5 = i3 / 32;
        int i6 = i4;
        while (i6 <= i5) {
            int i7 = (2 << (i6 >= i5 ? 31 & i3 : 31)) - (1 << (i6 > i4 ? 0 : i & 31));
            int i8 = this.f633l[i6] & i7;
            if (!z) {
                i7 = 0;
            }
            if (i8 != i7) {
                return false;
            }
            i6++;
        }
        return true;
    }

    public void m1196t() {
        int[] iArr = new int[this.f633l.length];
        int i = (this.f634m - 1) / 32;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            long j = this.f633l[i3];
            long j2 = ((j & 1431655765) << 1) | ((j >> 1) & 1431655765);
            long j3 = ((j2 & 858993459) << 2) | ((j2 >> 2) & 858993459);
            long j4 = ((j3 & 252645135) << 4) | ((j3 >> 4) & 252645135);
            long j5 = ((j4 & 16711935) << 8) | ((j4 >> 8) & 16711935);
            iArr[i - i3] = (int) (((j5 & 65535) << 16) | ((j5 >> 16) & 65535));
        }
        int i4 = this.f634m;
        int i5 = i2 << 5;
        if (i4 != i5) {
            int i6 = i5 - i4;
            int i7 = iArr[0] >>> i6;
            for (int i8 = 1; i8 < i2; i8++) {
                int i9 = iArr[i8];
                iArr[i8 - 1] = i7 | (i9 << (32 - i6));
                i7 = i9 >>> i6;
            }
            iArr[i] = i7;
        }
        this.f633l = iArr;
    }

    public String toString() {
        int i = this.f634m;
        StringBuilder sb = new StringBuilder(i + (i / 8) + 1);
        for (int i2 = 0; i2 < this.f634m; i2++) {
            if ((i2 & 7) == 0) {
                sb.append(' ');
            }
            sb.append(m1189h(i2) ? 'X' : '.');
        }
        return sb.toString();
    }

    public void m1197u(int i) {
        int[] iArr = this.f633l;
        int i2 = i / 32;
        iArr[i2] = (1 << (i & 31)) | iArr[i2];
    }

    public void m1198v(int i, int i2) {
        this.f633l[i / 32] = i2;
    }

    public void m1199w(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = 0; i4 < i3; i4++) {
            int i5 = 0;
            for (int i6 = 0; i6 < 8; i6++) {
                if (m1189h(i)) {
                    i5 |= 1 << (7 - i6);
                }
                i++;
            }
            bArr[i2 + i4] = (byte) i5;
        }
    }

    public void m1200x(C0233F2 c0233f2) {
        if (this.f634m != c0233f2.f634m) {
            throw new IllegalArgumentException("Sizes don't match");
        }
        int i = 0;
        while (true) {
            int[] iArr = this.f633l;
            if (i >= iArr.length) {
                return;
            }
            iArr[i] = iArr[i] ^ c0233f2.f633l[i];
            i++;
        }
    }

    public C0233F2(int i) {
        this.f634m = i;
        this.f633l = m1182s(i);
    }

    public C0233F2(int[] iArr, int i) {
        this.f633l = iArr;
        this.f634m = i;
    }
}
