package p000;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

public final class C1016W4 extends AbstractC0992Vh {

    public enum a {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    public static int m4445h(CharSequence charSequence, int i, int i2) {
        a aVarM4446i;
        a aVarM4446i2;
        char cCharAt;
        a aVarM4446i3 = m4446i(charSequence, i);
        a aVar = a.ONE_DIGIT;
        if (aVarM4446i3 == aVar) {
            return i2 == 101 ? 101 : 100;
        }
        a aVar2 = a.UNCODABLE;
        if (aVarM4446i3 == aVar2) {
            return (i >= charSequence.length() || ((cCharAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || (cCharAt >= '`' && (cCharAt < 241 || cCharAt > 244))))) ? 100 : 101;
        }
        if (i2 == 101 && aVarM4446i3 == a.FNC_1) {
            return 101;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 != 100) {
            if (aVarM4446i3 == a.FNC_1) {
                aVarM4446i3 = m4446i(charSequence, i + 1);
            }
            return aVarM4446i3 == a.TWO_DIGITS ? 99 : 100;
        }
        a aVar3 = a.FNC_1;
        if (aVarM4446i3 == aVar3 || (aVarM4446i = m4446i(charSequence, i + 2)) == aVar2 || aVarM4446i == aVar) {
            return 100;
        }
        if (aVarM4446i == aVar3) {
            return m4446i(charSequence, i + 3) == a.TWO_DIGITS ? 99 : 100;
        }
        int i3 = i + 4;
        while (true) {
            aVarM4446i2 = m4446i(charSequence, i3);
            if (aVarM4446i2 != a.TWO_DIGITS) {
                break;
            }
            i3 += 2;
        }
        return aVarM4446i2 == a.ONE_DIGIT ? 100 : 99;
    }

    public static a m4446i(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return a.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == 241) {
            return a.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return a.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return a.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        return (cCharAt2 < '0' || cCharAt2 > '9') ? a.ONE_DIGIT : a.TWO_DIGITS;
    }

    @Override
    public boolean[] mo1533d(String str) throws NumberFormatException {
        int length = str.length();
        if (length <= 0 || length > 80) {
            throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
        }
        int iM4408b = 0;
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            switch (cCharAt) {
                case 241:
                case 242:
                case 243:
                case 244:
                    break;
                default:
                    if (cCharAt > 127) {
                        throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt)));
                    }
                    break;
            }
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 1;
        while (true) {
            int i6 = 103;
            if (i2 >= length) {
                int[][] iArr = C0970V4.f2934a;
                arrayList.add(iArr[i3 % 103]);
                arrayList.add(iArr[106]);
                int i7 = 0;
                for (int[] iArr2 : arrayList) {
                    for (int i8 : iArr2) {
                        i7 += i8;
                    }
                }
                boolean[] zArr = new boolean[i7];
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    iM4408b += AbstractC0992Vh.m4408b(zArr, iM4408b, (int[]) it.next(), true);
                }
                return zArr;
            }
            int iM4445h = m4445h(str, i2, i4);
            int iCharAt = 100;
            if (iM4445h == i4) {
                switch (str.charAt(i2)) {
                    case 241:
                        iCharAt = 102;
                        break;
                    case 242:
                        iCharAt = 97;
                        break;
                    case 243:
                        iCharAt = 96;
                        break;
                    case 244:
                        if (i4 == 101) {
                            iCharAt = 101;
                            break;
                        }
                        break;
                    default:
                        if (i4 != 100) {
                            if (i4 != 101) {
                                iCharAt = Integer.parseInt(str.substring(i2, i2 + 2));
                                i2++;
                                break;
                            } else {
                                char cCharAt2 = str.charAt(i2);
                                iCharAt = cCharAt2 - ' ';
                                if (iCharAt < 0) {
                                    iCharAt = cCharAt2 + '@';
                                    break;
                                }
                            }
                        } else {
                            iCharAt = str.charAt(i2) - ' ';
                            break;
                        }
                        break;
                }
                i2++;
            } else {
                if (i4 != 0) {
                    i6 = iM4445h;
                } else if (iM4445h == 100) {
                    i6 = 104;
                } else if (iM4445h != 101) {
                    i6 = 105;
                }
                iCharAt = i6;
                i4 = iM4445h;
            }
            arrayList.add(C0970V4.f2934a[iCharAt]);
            i3 += iCharAt * i5;
            if (i2 != 0) {
                i5++;
            }
        }
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.CODE_128);
    }
}
