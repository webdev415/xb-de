package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C0075Bj implements InterfaceC0081Bp {
    public static C0325H2 m318b(C2618yj c2618yj, int i, int i2, int i3) {
        C0050B3 c0050b3M10894a = c2618yj.m10894a();
        if (c0050b3M10894a == null) {
            throw new IllegalStateException();
        }
        int iM193e = c0050b3M10894a.m193e();
        int iM192d = c0050b3M10894a.m192d();
        int i4 = i3 << 1;
        int i5 = iM193e + i4;
        int i6 = i4 + iM192d;
        int iMax = Math.max(i, i5);
        int iMax2 = Math.max(i2, i6);
        int iMin = Math.min(iMax / i5, iMax2 / i6);
        int i7 = (iMax - (iM193e * iMin)) / 2;
        int i8 = (iMax2 - (iM192d * iMin)) / 2;
        C0325H2 c0325h2 = new C0325H2(iMax, iMax2);
        int i9 = 0;
        while (i9 < iM192d) {
            int i10 = 0;
            int i11 = i7;
            while (i10 < iM193e) {
                if (c0050b3M10894a.m190b(i10, i9) == 1) {
                    c0325h2.m1502s(i11, i8, iMin, iMin);
                }
                i10++;
                i11 += iMin;
            }
            i9++;
            i8 += iMin;
        }
        return c0325h2;
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) throws NumberFormatException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i + 'x' + i2);
        }
        EnumC1363ca enumC1363caValueOf = EnumC1363ca.L;
        int i3 = 4;
        if (map != null) {
            EnumC0883T9 enumC0883T9 = EnumC0883T9.ERROR_CORRECTION;
            if (map.containsKey(enumC0883T9)) {
                enumC1363caValueOf = EnumC1363ca.valueOf(map.get(enumC0883T9).toString());
            }
            EnumC0883T9 enumC0883T92 = EnumC0883T9.MARGIN;
            if (map.containsKey(enumC0883T92)) {
                i3 = Integer.parseInt(map.get(enumC0883T92).toString());
            }
        }
        return m318b(AbstractC0975V9.m4356n(str, enumC1363caValueOf, map), i, i2, i3);
    }
}
