package p000;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public final class C1299b2 implements InterfaceC0081Bp {
    public static C0325H2 m5619b(String str, BarcodeFormat barcodeFormat, int i, int i2, Charset charset, int i3, int i4) {
        if (barcodeFormat == BarcodeFormat.AZTEC) {
            return m5620c(AbstractC1021W9.m4457d(str.getBytes(charset), i3, i4), i, i2);
        }
        throw new IllegalArgumentException("Can only encode AZTEC, but got ".concat(String.valueOf(barcodeFormat)));
    }

    public static C0325H2 m5620c(C1105Y1 c1105y1, int i, int i2) {
        C0325H2 c0325h2M4865a = c1105y1.m4865a();
        if (c0325h2M4865a == null) {
            throw new IllegalStateException();
        }
        int iM1499o = c0325h2M4865a.m1499o();
        int iM1496j = c0325h2M4865a.m1496j();
        int iMax = Math.max(i, iM1499o);
        int iMax2 = Math.max(i2, iM1496j);
        int iMin = Math.min(iMax / iM1499o, iMax2 / iM1496j);
        int i3 = (iMax - (iM1499o * iMin)) / 2;
        int i4 = (iMax2 - (iM1496j * iMin)) / 2;
        C0325H2 c0325h2 = new C0325H2(iMax, iMax2);
        int i5 = 0;
        while (i5 < iM1496j) {
            int i6 = 0;
            int i7 = i3;
            while (i6 < iM1499o) {
                if (c0325h2M4865a.m1493e(i6, i5)) {
                    c0325h2.m1502s(i7, i4, iMin, iMin);
                }
                i6++;
                i7 += iMin;
            }
            i5++;
            i4 += iMin;
        }
        return c0325h2;
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) throws NumberFormatException {
        Charset charsetForName = StandardCharsets.ISO_8859_1;
        int i3 = 0;
        if (map != null) {
            EnumC0883T9 enumC0883T9 = EnumC0883T9.CHARACTER_SET;
            if (map.containsKey(enumC0883T9)) {
                charsetForName = Charset.forName(map.get(enumC0883T9).toString());
            }
            EnumC0883T9 enumC0883T92 = EnumC0883T9.ERROR_CORRECTION;
            i = map.containsKey(enumC0883T92) ? Integer.parseInt(map.get(enumC0883T92).toString()) : 33;
            EnumC0883T9 enumC0883T93 = EnumC0883T9.AZTEC_LAYERS;
            if (map.containsKey(enumC0883T93)) {
                i3 = Integer.parseInt(map.get(enumC0883T93).toString());
            }
        }
        return m5619b(str, barcodeFormat, i, i2, charsetForName, i, i3);
    }
}
