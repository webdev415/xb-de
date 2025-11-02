package p000;

public final class C0509L2 {

    public final byte[] f1650a;

    public int f1651b;

    public int f1652c;

    public C0509L2(byte[] bArr) {
        this.f1650a = bArr;
    }

    public int m2576a() {
        return ((this.f1650a.length - this.f1651b) * 8) - this.f1652c;
    }

    public int m2577b() {
        return this.f1652c;
    }

    public int m2578c() {
        return this.f1651b;
    }

    public int m2579d(int i) {
        if (i <= 0 || i > 32 || i > m2576a()) {
            throw new IllegalArgumentException(String.valueOf(i));
        }
        int i2 = this.f1652c;
        int i3 = 0;
        if (i2 > 0) {
            int i4 = 8 - i2;
            int iMin = Math.min(i, i4);
            int i5 = i4 - iMin;
            byte[] bArr = this.f1650a;
            int i6 = this.f1651b;
            int i7 = (((255 >> (8 - iMin)) << i5) & bArr[i6]) >> i5;
            i -= iMin;
            int i8 = this.f1652c + iMin;
            this.f1652c = i8;
            if (i8 == 8) {
                this.f1652c = 0;
                this.f1651b = i6 + 1;
            }
            i3 = i7;
        }
        if (i <= 0) {
            return i3;
        }
        while (i >= 8) {
            int i9 = i3 << 8;
            byte[] bArr2 = this.f1650a;
            int i10 = this.f1651b;
            i3 = (bArr2[i10] & 255) | i9;
            this.f1651b = i10 + 1;
            i -= 8;
        }
        if (i <= 0) {
            return i3;
        }
        int i11 = 8 - i;
        int i12 = (i3 << i) | ((((255 >> i11) << i11) & this.f1650a[this.f1651b]) >> i11);
        this.f1652c += i;
        return i12;
    }
}
