package p000;

import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class C0029Aj implements InterfaceC1226ak {

    public static final C0857Sk[] f78b = new C0857Sk[0];

    public final C0560M7 f79a = new C0560M7();

    private static C0325H2 m136d(C0325H2 c0325h2) throws C2340sh {
        int[] iArrM1498n = c0325h2.m1498n();
        int[] iArrM1494f = c0325h2.m1494f();
        if (iArrM1498n == null || iArrM1494f == null) {
            throw C2340sh.m9579a();
        }
        float fM137e = m137e(iArrM1498n, c0325h2);
        int i = iArrM1498n[1];
        int i2 = iArrM1494f[1];
        int i3 = iArrM1498n[0];
        int i4 = iArrM1494f[0];
        if (i3 >= i4 || i >= i2) {
            throw C2340sh.m9579a();
        }
        int i5 = i2 - i;
        if (i5 != i4 - i3 && (i4 = i3 + i5) >= c0325h2.m1499o()) {
            throw C2340sh.m9579a();
        }
        int iRound = Math.round(((i4 - i3) + 1) / fM137e);
        int iRound2 = Math.round((i5 + 1) / fM137e);
        if (iRound <= 0 || iRound2 <= 0) {
            throw C2340sh.m9579a();
        }
        if (iRound2 != iRound) {
            throw C2340sh.m9579a();
        }
        int i6 = (int) (fM137e / 2.0f);
        int i7 = i + i6;
        int i8 = i3 + i6;
        int i9 = (((int) ((iRound - 1) * fM137e)) + i8) - i4;
        if (i9 > 0) {
            if (i9 > i6) {
                throw C2340sh.m9579a();
            }
            i8 -= i9;
        }
        int i10 = (((int) ((iRound2 - 1) * fM137e)) + i7) - i2;
        if (i10 > 0) {
            if (i10 > i6) {
                throw C2340sh.m9579a();
            }
            i7 -= i10;
        }
        C0325H2 c0325h22 = new C0325H2(iRound, iRound2);
        for (int i11 = 0; i11 < iRound2; i11++) {
            int i12 = ((int) (i11 * fM137e)) + i7;
            for (int i13 = 0; i13 < iRound; i13++) {
                if (c0325h2.m1493e(((int) (i13 * fM137e)) + i8, i12)) {
                    c0325h22.m1501r(i13, i11);
                }
            }
        }
        return c0325h22;
    }

    public static float m137e(int[] iArr, C0325H2 c0325h2) throws C2340sh {
        int iM1496j = c0325h2.m1496j();
        int iM1499o = c0325h2.m1499o();
        int i = iArr[0];
        boolean z = true;
        int i2 = iArr[1];
        int i3 = 0;
        while (i < iM1499o && i2 < iM1496j) {
            if (z != c0325h2.m1493e(i, i2)) {
                i3++;
                if (i3 == 5) {
                    break;
                }
                z = !z;
            }
            i++;
            i2++;
        }
        if (i == iM1499o || i2 == iM1496j) {
            throw C2340sh.m9579a();
        }
        return (i - iArr[0]) / 7.0f;
    }

    @Override
    public C0720Pk decode(BinaryBitmap binaryBitmap) {
        return mo139b(binaryBitmap, null);
    }

    @Override
    public final C0720Pk mo139b(BinaryBitmap binaryBitmap, Map map) throws C2340sh, C2610yb, C2548x4 {
        C0857Sk[] c0857SkArrM3385b;
        C0698P7 c0698p7M2828b;
        if (map == null || !map.containsKey(DecodeHintType.PURE_BARCODE)) {
            C0653O8 c0653o8M3302e = new C0607N8(binaryBitmap.m597a()).m3302e(map);
            C0698P7 c0698p7M2828b2 = this.f79a.m2828b(c0653o8M3302e.m3384a(), map);
            c0857SkArrM3385b = c0653o8M3302e.m3385b();
            c0698p7M2828b = c0698p7M2828b2;
        } else {
            c0698p7M2828b = this.f79a.m2828b(m136d(binaryBitmap.m597a()), map);
            c0857SkArrM3385b = f78b;
        }
        if (c0698p7M2828b.m3479d() instanceof C2664zj) {
            ((C2664zj) c0698p7M2828b.m3479d()).m11038a(c0857SkArrM3385b);
        }
        C0720Pk c0720Pk = new C0720Pk(c0698p7M2828b.m3483h(), c0698p7M2828b.m3480e(), c0857SkArrM3385b, BarcodeFormat.QR_CODE);
        List listM3476a = c0698p7M2828b.m3476a();
        if (listM3476a != null) {
            c0720Pk.m3582h(EnumC0811Rk.BYTE_SEGMENTS, listM3476a);
        }
        String strM3477b = c0698p7M2828b.m3477b();
        if (strM3477b != null) {
            c0720Pk.m3582h(EnumC0811Rk.ERROR_CORRECTION_LEVEL, strM3477b);
        }
        if (c0698p7M2828b.m3484i()) {
            c0720Pk.m3582h(EnumC0811Rk.STRUCTURED_APPEND_SEQUENCE, Integer.valueOf(c0698p7M2828b.m3482g()));
            c0720Pk.m3582h(EnumC0811Rk.STRUCTURED_APPEND_PARITY, Integer.valueOf(c0698p7M2828b.m3481f()));
        }
        return c0720Pk;
    }

    @Override
    public void mo140c() {
    }
}
