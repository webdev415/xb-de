package p000;

import java.util.Map;

public final class C0514L7 {

    public final C2020lk f1690a = new C2020lk(C2611yc.f8078o);

    public final void m2631a(byte[] bArr, int i, int i2, int i3, int i4) throws C2548x4 {
        int i5 = i2 + i3;
        int i6 = i4 == 0 ? 1 : 2;
        int[] iArr = new int[i5 / i6];
        for (int i7 = 0; i7 < i5; i7++) {
            if (i4 == 0 || i7 % 2 == i4 - 1) {
                iArr[i7 / i6] = bArr[i7 + i] & 255;
            }
        }
        try {
            this.f1690a.m8404a(iArr, i3 / i6);
            for (int i8 = 0; i8 < i2; i8++) {
                if (i4 == 0 || i8 % 2 == i4 - 1) {
                    bArr[i8 + i] = (byte) iArr[i8 / i6];
                }
            }
        } catch (C2112nk unused) {
            throw C2548x4.m10627a();
        }
    }

    public C0698P7 m2632b(C0325H2 c0325h2, Map map) throws C2610yb, C2548x4 {
        int i;
        byte[] bArrM1664a = new C0371I2(c0325h2).m1664a();
        m2631a(bArrM1664a, 0, 10, 10, 0);
        int i2 = bArrM1664a[0] & 15;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            m2631a(bArrM1664a, 20, 84, 40, 1);
            m2631a(bArrM1664a, 20, 84, 40, 2);
            i = 94;
        } else {
            if (i2 != 5) {
                throw C2610yb.m10853a();
            }
            m2631a(bArrM1664a, 20, 68, 56, 1);
            m2631a(bArrM1664a, 20, 68, 56, 2);
            i = 78;
        }
        byte[] bArr = new byte[i];
        System.arraycopy(bArrM1664a, 0, bArr, 0, 10);
        System.arraycopy(bArrM1664a, 20, bArr, 10, bArr.length - 10);
        return AbstractC0100C7.m405a(bArr, i2);
    }
}
