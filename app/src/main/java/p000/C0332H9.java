package p000;

import java.util.Collection;
import java.util.Collections;

public final class C0332H9 extends AbstractC1284ao {
    @Override
    public boolean[] mo1533d(String str) {
        int length = str.length();
        if (length == 12) {
            try {
                str = str + AbstractC1182Zn.m5077s(str);
            } catch (C2610yb e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (length != 13) {
                throw new IllegalArgumentException("Requested contents should be 12 or 13 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!AbstractC1182Zn.m5072j(str)) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C2610yb unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        AbstractC0992Vh.m4409c(str);
        int i = C0286G9.f861j[Character.digit(str.charAt(0), 10)];
        boolean[] zArr = new boolean[95];
        int iM4408b = AbstractC0992Vh.m4408b(zArr, 0, AbstractC1182Zn.f3466d, true);
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit += 10;
            }
            iM4408b += AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3470h[iDigit], false);
        }
        int iM4408b2 = iM4408b + AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3467e, false);
        for (int i3 = 7; i3 <= 12; i3++) {
            iM4408b2 += AbstractC0992Vh.m4408b(zArr, iM4408b2, AbstractC1182Zn.f3469g[Character.digit(str.charAt(i3), 10)], true);
        }
        AbstractC0992Vh.m4408b(zArr, iM4408b2, AbstractC1182Zn.f3466d, true);
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.EAN_13);
    }
}
