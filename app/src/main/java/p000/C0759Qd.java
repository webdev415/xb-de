package p000;

import java.util.Collection;
import java.util.Collections;

public final class C0759Qd extends AbstractC0992Vh {

    public static final int[] f2244b = {1, 1, 1, 1};

    public static final int[] f2245c = {3, 1, 1};

    public static final int[][] f2246d = {new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    @Override
    public boolean[] mo1533d(String str) {
        int length = str.length();
        if (length % 2 != 0) {
            throw new IllegalArgumentException("The length of the input should be even");
        }
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        AbstractC0992Vh.m4409c(str);
        boolean[] zArr = new boolean[(length * 9) + 9];
        int iM4408b = AbstractC0992Vh.m4408b(zArr, 0, f2244b, true);
        for (int i = 0; i < length; i += 2) {
            int iDigit = Character.digit(str.charAt(i), 10);
            int iDigit2 = Character.digit(str.charAt(i + 1), 10);
            int[] iArr = new int[10];
            for (int i2 = 0; i2 < 5; i2++) {
                int i3 = i2 * 2;
                int[][] iArr2 = f2246d;
                iArr[i3] = iArr2[iDigit][i2];
                iArr[i3 + 1] = iArr2[iDigit2][i2];
            }
            iM4408b += AbstractC0992Vh.m4408b(zArr, iM4408b, iArr, true);
        }
        AbstractC0992Vh.m4408b(zArr, iM4408b, f2245c, true);
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.ITF);
    }
}
