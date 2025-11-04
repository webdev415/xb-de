package p000;

import java.util.Collection;
import java.util.Collections;

public final class C0424J9 extends AbstractC1284ao {
    @Override
    public boolean[] mo1533d(String str) {
        int length = str.length();
        if (length == 7) {
            try {
                str = str + AbstractC1182Zn.m5077s(str);
            } catch (C2610yb e) {
                throw new IllegalArgumentException(e);
            }
        } else {
            if (length != 8) {
                throw new IllegalArgumentException("Requested contents should be 7 or 8 digits long, but got ".concat(String.valueOf(length)));
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
        boolean[] zArr = new boolean[67];
        int iM4408b = AbstractC0992Vh.m4408b(zArr, 0, AbstractC1182Zn.f3466d, true);
        for (int i = 0; i <= 3; i++) {
            iM4408b += AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3469g[Character.digit(str.charAt(i), 10)], false);
        }
        int iM4408b2 = iM4408b + AbstractC0992Vh.m4408b(zArr, iM4408b, AbstractC1182Zn.f3467e, false);
        for (int i2 = 4; i2 <= 7; i2++) {
            iM4408b2 += AbstractC0992Vh.m4408b(zArr, iM4408b2, AbstractC1182Zn.f3469g[Character.digit(str.charAt(i2), 10)], true);
        }
        AbstractC0992Vh.m4408b(zArr, iM4408b2, AbstractC1182Zn.f3466d, true);
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.EAN_8);
    }
}
