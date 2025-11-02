package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C2569xg implements InterfaceC1226ak {

    public static final C0857Sk[] f8008b = new C0857Sk[0];

    public final C0514L7 f8009a = new C0514L7();

    private static C0325H2 m10721d(C0325H2 c0325h2) throws C2340sh {
        int[] iArrM1495h = c0325h2.m1495h();
        if (iArrM1495h == null) {
            throw C2340sh.m9579a();
        }
        int i = iArrM1495h[0];
        int i2 = iArrM1495h[1];
        int i3 = iArrM1495h[2];
        int i4 = iArrM1495h[3];
        C0325H2 c0325h22 = new C0325H2(30, 33);
        for (int i5 = 0; i5 < 33; i5++) {
            int i6 = (((i5 * i4) + (i4 / 2)) / 33) + i2;
            for (int i7 = 0; i7 < 30; i7++) {
                if (c0325h2.m1493e(((((i7 * i3) + (i3 / 2)) + (((i5 & 1) * i3) / 2)) / 30) + i, i6)) {
                    c0325h22.m1501r(i7, i5);
                }
            }
        }
        return c0325h22;
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    @Override
    public C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) throws C2340sh, C2610yb, C2548x4 {
        C0698P7 c0698p7M2632b = this.f8009a.m2632b(m10721d(binaryBitmap.m597a()), map);
        C0720Pk c0720Pk = new C0720Pk(c0698p7M2632b.m3483h(), c0698p7M2632b.m3480e(), f8008b, BarcodeFormat.MAXICODE);
        String strM3477b = c0698p7M2632b.m3477b();
        if (strM3477b != null) {
            c0720Pk.m3582h(EnumC0811Rk.ERROR_CORRECTION_LEVEL, strM3477b);
        }
        return c0720Pk;
    }

    @Override
    public void mo140c() {
    }
}
