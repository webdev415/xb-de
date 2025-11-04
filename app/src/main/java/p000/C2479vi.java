package p000;

import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.util.Map;

public final class C2479vi implements InterfaceC0081Bp {
    public static C0325H2 m10369b(byte[][] bArr, int i) {
        int i2 = i * 2;
        C0325H2 c0325h2 = new C0325H2(bArr[0].length + i2, bArr.length + i2);
        c0325h2.m1490b();
        int iM1496j = (c0325h2.m1496j() - i) - 1;
        int i3 = 0;
        while (i3 < bArr.length) {
            byte[] bArr2 = bArr[i3];
            for (int i4 = 0; i4 < bArr[0].length; i4++) {
                if (bArr2[i4] == 1) {
                    c0325h2.m1501r(i4 + i, iM1496j);
                }
            }
            i3++;
            iM1496j--;
        }
        return c0325h2;
    }

    public static C0325H2 m10370c(C2064mi c2064mi, String str, int i, int i2, int i3, int i4) throws C0127Cp {
        boolean z;
        c2064mi.m8592e(str, i);
        byte[][] bArrM8720b = c2064mi.m8593f().m8720b(1, 4);
        if ((i3 > i2) != (bArrM8720b[0].length < bArrM8720b.length)) {
            bArrM8720b = m10371d(bArrM8720b);
            z = true;
        } else {
            z = false;
        }
        int iMin = Math.min(i2 / bArrM8720b[0].length, i3 / bArrM8720b.length);
        if (iMin <= 1) {
            return m10369b(bArrM8720b, i4);
        }
        byte[][] bArrM8720b2 = c2064mi.m8593f().m8720b(iMin, iMin << 2);
        if (z) {
            bArrM8720b2 = m10371d(bArrM8720b2);
        }
        return m10369b(bArrM8720b2, i4);
    }

    public static byte[][] m10371d(byte[][] bArr) {
        byte[][] bArr2 = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, bArr[0].length, bArr.length);
        for (int i = 0; i < bArr.length; i++) {
            int length = (bArr.length - i) - 1;
            for (int i2 = 0; i2 < bArr[0].length; i2++) {
                bArr2[i2][length] = bArr[i][i2];
            }
        }
        return bArr2;
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) {
        if (barcodeFormat != BarcodeFormat.PDF_417) {
            throw new IllegalArgumentException("Can only encode PDF_417, but got ".concat(String.valueOf(barcodeFormat)));
        }
        C2064mi c2064mi = new C2064mi();
        if (map != null) {
            EnumC0883T9 enumC0883T9 = EnumC0883T9.PDF417_COMPACT;
            if (map.containsKey(enumC0883T9)) {
                c2064mi.m8594h(Boolean.parseBoolean(map.get(enumC0883T9).toString()));
            }
            EnumC0883T9 enumC0883T92 = EnumC0883T9.PDF417_COMPACTION;
            if (map.containsKey(enumC0883T92)) {
                c2064mi.m8595i(EnumC2503w5.valueOf(map.get(enumC0883T92).toString()));
            }
            EnumC0883T9 enumC0883T93 = EnumC0883T9.PDF417_DIMENSIONS;
            if (map.containsKey(enumC0883T93)) {
                AbstractC2524wh.m10586a(map.get(enumC0883T93));
                throw null;
            }
            EnumC0883T9 enumC0883T94 = EnumC0883T9.MARGIN;
            i = map.containsKey(enumC0883T94) ? Integer.parseInt(map.get(enumC0883T94).toString()) : 30;
            EnumC0883T9 enumC0883T95 = EnumC0883T9.ERROR_CORRECTION;
            i = map.containsKey(enumC0883T95) ? Integer.parseInt(map.get(enumC0883T95).toString()) : 2;
            EnumC0883T9 enumC0883T96 = EnumC0883T9.CHARACTER_SET;
            if (map.containsKey(enumC0883T96)) {
                c2064mi.m8596j(Charset.forName(map.get(enumC0883T96).toString()));
            }
        }
        return m10370c(c2064mi, str, i, i, i2, i);
    }
}
