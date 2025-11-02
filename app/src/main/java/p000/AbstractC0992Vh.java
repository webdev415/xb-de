package p000;

import java.util.Collection;
import java.util.Map;
import java.util.regex.Pattern;

public abstract class AbstractC0992Vh implements InterfaceC0081Bp {

    public static final Pattern f2983a = Pattern.compile("[0-9]+");

    public static int m4408b(boolean[] zArr, int i, int[] iArr, boolean z) {
        int i2 = 0;
        for (int i3 : iArr) {
            int i4 = 0;
            while (i4 < i3) {
                zArr[i] = z;
                i4++;
                i++;
            }
            i2 += i3;
            z = !z;
        }
        return i2;
    }

    public static void m4409c(String str) {
        if (!f2983a.matcher(str).matches()) {
            throw new IllegalArgumentException("Input should only contain digits 0-9");
        }
    }

    public static C0325H2 m4410g(boolean[] zArr, int i, int i2, int i3) {
        int length = zArr.length;
        int i4 = i3 + length;
        int iMax = Math.max(i, i4);
        int iMax2 = Math.max(1, i2);
        int i5 = iMax / i4;
        int i6 = (iMax - (length * i5)) / 2;
        C0325H2 c0325h2 = new C0325H2(iMax, iMax2);
        int i7 = 0;
        while (i7 < length) {
            if (zArr[i7]) {
                c0325h2.m1502s(i6, 0, i5, iMax2);
            }
            i7++;
            i6 += i5;
        }
        return c0325h2;
    }

    @Override
    public C0325H2 mo319a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map map) throws NumberFormatException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        }
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i + 'x' + i2);
        }
        Collection collectionMo1534f = mo1534f();
        if (collectionMo1534f != null && !collectionMo1534f.contains(barcodeFormat)) {
            throw new IllegalArgumentException("Can only encode " + collectionMo1534f + ", but got " + barcodeFormat);
        }
        int iMo4411e = mo4411e();
        if (map != null) {
            EnumC0883T9 enumC0883T9 = EnumC0883T9.MARGIN;
            if (map.containsKey(enumC0883T9)) {
                iMo4411e = Integer.parseInt(map.get(enumC0883T9).toString());
            }
        }
        return m4410g(mo1533d(str), i, i2, iMo4411e);
    }

    public abstract boolean[] mo1533d(String str);

    public int mo4411e() {
        return 10;
    }

    public abstract Collection mo1534f();
}
