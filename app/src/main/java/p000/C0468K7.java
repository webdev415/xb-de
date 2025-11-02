package p000;

public final class C0468K7 {

    public final C2020lk f1539a = new C2020lk(C2611yc.f8076m);

    public final void m2291a(byte[] bArr, int i) throws C2548x4 {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        try {
            this.f1539a.m8404a(iArr, bArr.length - i);
            for (int i3 = 0; i3 < i; i3++) {
                bArr[i3] = (byte) iArr[i3];
            }
        } catch (C2112nk unused) {
            throw C2548x4.m10627a();
        }
    }

    public C0698P7 m2292b(C0325H2 c0325h2) throws C2548x4 {
        C0463K2 c0463k2 = new C0463K2(c0325h2);
        C1812h7[] c1812h7ArrM7806b = C1812h7.m7806b(c0463k2.m2258c(), c0463k2.m2257b());
        int iM7808c = 0;
        for (C1812h7 c1812h7 : c1812h7ArrM7806b) {
            iM7808c += c1812h7.m7808c();
        }
        byte[] bArr = new byte[iM7808c];
        int length = c1812h7ArrM7806b.length;
        for (int i = 0; i < length; i++) {
            C1812h7 c1812h72 = c1812h7ArrM7806b[i];
            byte[] bArrM7807a = c1812h72.m7807a();
            int iM7808c2 = c1812h72.m7808c();
            m2291a(bArrM7807a, iM7808c2);
            for (int i2 = 0; i2 < iM7808c2; i2++) {
                bArr[(i2 * length) + i] = bArrM7807a[i2];
            }
        }
        return AbstractC0054B7.m201a(bArr);
    }
}
