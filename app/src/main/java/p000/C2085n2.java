package p000;

import java.lang.reflect.Array;

public final class C2085n2 {

    public final C2224q2[] f6289a;

    public int f6290b;

    public final int f6291c;

    public final int f6292d;

    public C2085n2(int i, int i2) {
        C2224q2[] c2224q2Arr = new C2224q2[i];
        this.f6289a = c2224q2Arr;
        int length = c2224q2Arr.length;
        for (int i3 = 0; i3 < length; i3++) {
            this.f6289a[i3] = new C2224q2(((i2 + 4) * 17) + 1);
        }
        this.f6292d = i2 * 17;
        this.f6291c = i;
        this.f6290b = -1;
    }

    public C2224q2 m8719a() {
        return this.f6289a[this.f6290b];
    }

    public byte[][] m8720b(int i, int i2) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, this.f6291c * i2, this.f6292d * i);
        int i3 = this.f6291c * i2;
        for (int i4 = 0; i4 < i3; i4++) {
            bArr[(i3 - i4) - 1] = this.f6289a[i4 / i2].m9097b(i);
        }
        return bArr;
    }

    public void m8721c() {
        this.f6290b++;
    }
}
