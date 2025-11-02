package p000;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class C2044m7 implements InterfaceC1226ak {

    public static final C0857Sk[] f6137b = new C0857Sk[0];

    public final C0468K7 f6138a = new C0468K7();

    public static C0325H2 m8441d(C0325H2 c0325h2) throws C2340sh {
        int[] iArrM1498n = c0325h2.m1498n();
        int[] iArrM1494f = c0325h2.m1494f();
        if (iArrM1498n == null || iArrM1494f == null) {
            throw C2340sh.m9579a();
        }
        int iM8442e = m8442e(iArrM1498n, c0325h2);
        int i = iArrM1498n[1];
        int i2 = iArrM1494f[1];
        int i3 = iArrM1498n[0];
        int i4 = ((iArrM1494f[0] - i3) + 1) / iM8442e;
        int i5 = ((i2 - i) + 1) / iM8442e;
        if (i4 <= 0 || i5 <= 0) {
            throw C2340sh.m9579a();
        }
        int i6 = iM8442e / 2;
        int i7 = i + i6;
        int i8 = i3 + i6;
        C0325H2 c0325h22 = new C0325H2(i4, i5);
        for (int i9 = 0; i9 < i5; i9++) {
            int i10 = (i9 * iM8442e) + i7;
            for (int i11 = 0; i11 < i4; i11++) {
                if (c0325h2.m1493e((i11 * iM8442e) + i8, i10)) {
                    c0325h22.m1501r(i11, i9);
                }
            }
        }
        return c0325h22;
    }

    public static int m8442e(int[] iArr, C0325H2 c0325h2) throws C2340sh {
        int iM1499o = c0325h2.m1499o();
        int i = iArr[0];
        int i2 = iArr[1];
        while (i < iM1499o && c0325h2.m1493e(i, i2)) {
            i++;
        }
        if (i == iM1499o) {
            throw C2340sh.m9579a();
        }
        int i3 = i - iArr[0];
        if (i3 != 0) {
            return i3;
        }
        throw C2340sh.m9579a();
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    @Override
    public C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) throws C2340sh, C2548x4 {
        C0857Sk[] c0857SkArrM3385b;
        C0698P7 c0698p7M2292b;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            C0653O8 c0653o8M2637b = new C0515L8(binaryBitmap.m597a()).m2637b();
            C0698P7 c0698p7M2292b2 = this.f6138a.m2292b(c0653o8M2637b.m3384a());
            c0857SkArrM3385b = c0653o8M2637b.m3385b();
            c0698p7M2292b = c0698p7M2292b2;
        } else {
            c0698p7M2292b = this.f6138a.m2292b(m8441d(binaryBitmap.m597a()));
            c0857SkArrM3385b = f6137b;
        }
        C0720Pk c0720Pk = new C0720Pk(c0698p7M2292b.m3483h(), c0698p7M2292b.m3480e(), c0857SkArrM3385b, BarcodeFormat.DATA_MATRIX);
        List listM3476a = c0698p7M2292b.m3476a();
        if (listM3476a != null) {
            c0720Pk.m3582h(EnumC0811Rk.BYTE_SEGMENTS, listM3476a);
        }
        String strM3477b = c0698p7M2292b.m3477b();
        if (strM3477b != null) {
            c0720Pk.m3582h(EnumC0811Rk.ERROR_CORRECTION_LEVEL, strM3477b);
        }
        return c0720Pk;
    }

    @Override
    public void mo140c() {
    }
}
