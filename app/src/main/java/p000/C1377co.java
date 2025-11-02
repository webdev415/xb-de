package p000;

import java.util.Collection;
import java.util.Collections;

public final class C1377co extends AbstractC1284ao {
    @Override
    public boolean[] mo1533d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + AbstractC1182Zn.m5077s(C1331bo.m5681t(str));
            } catch (C2610yb e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got ".concat(String.valueOf(length)));
            }
            try {
                if (!AbstractC1182Zn.m5072j(C1331bo.m5681t(str))) {
                    throw new IllegalArgumentException("Contents do not pass checksum");
                }
            } catch (C2610yb unused) {
                throw new IllegalArgumentException("Illegal contents");
            }
        }
        AbstractC0992Vh.m4409c(str);
        int iDigit = Character.digit(str.charAt(0), 10);
        if (iDigit != 0 && iDigit != 1) {
            throw new IllegalArgumentException("Number system must be 0 or 1");
        }
        int i = C1331bo.f3886k[iDigit][Character.digit(str.charAt(7), 10)];
        boolean[] zArr = new boolean[51];
        int iM4408b = AbstractC0992Vh.m4408b(zArr, 0, AbstractC1182Zn.f3466d, true);
        for (int i2 = 1; i2 <= 6; i2++) {
            int iDigit2 = Character.digit(str.charAt(i2), 10);
            if (((i >> (6 - i2)) & 1) == 1) {
                iDigit2 += 10;
            }
            iM4408b += AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3470h[iDigit2], false);
        }
        AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3468f, false);
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.UPC_E);
    }
}
