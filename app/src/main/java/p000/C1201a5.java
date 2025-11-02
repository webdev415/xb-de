package p000;

import java.util.Collection;
import java.util.Collections;

public class C1201a5 extends AbstractC0992Vh {
    public static int m5099h(boolean[] zArr, int i, int i2) {
        for (int i3 = 0; i3 < 9; i3++) {
            boolean z = true;
            int i4 = i + i3;
            if (((1 << (8 - i3)) & i2) == 0) {
                z = false;
            }
            zArr[i4] = z;
        }
        return 9;
    }

    public static int m5100i(String str, int i) {
        int iIndexOf = 0;
        int i2 = 1;
        for (int length = str.length() - 1; length >= 0; length--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(str.charAt(length)) * i2;
            i2++;
            if (i2 > i) {
                i2 = 1;
            }
        }
        return iIndexOf % 47;
    }

    public static String m5101j(String str) {
        int i;
        String str2;
        int length = str.length();
        StringBuilder sb = new StringBuilder(length << 1);
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == 0) {
                str2 = "bU";
            } else {
                if (cCharAt <= 26) {
                    sb.append('a');
                    i = cCharAt + '@';
                } else if (cCharAt <= 31) {
                    sb.append('b');
                    i = cCharAt + '&';
                } else {
                    if (cCharAt != ' ' && cCharAt != '$' && cCharAt != '%' && cCharAt != '+') {
                        if (cCharAt <= ',') {
                            sb.append('c');
                            i = cCharAt + ' ';
                        } else if (cCharAt > '9') {
                            if (cCharAt == ':') {
                                str2 = "cZ";
                            } else if (cCharAt <= '?') {
                                sb.append('b');
                                i = cCharAt + 11;
                            } else if (cCharAt == '@') {
                                str2 = "bV";
                            } else if (cCharAt > 'Z') {
                                if (cCharAt <= '_') {
                                    sb.append('b');
                                    i = cCharAt - 16;
                                } else if (cCharAt == '`') {
                                    str2 = "bW";
                                } else if (cCharAt <= 'z') {
                                    sb.append('d');
                                    i = cCharAt - ' ';
                                } else {
                                    if (cCharAt > 127) {
                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + cCharAt + "'");
                                    }
                                    sb.append('b');
                                    i = cCharAt - '+';
                                }
                            }
                        }
                    }
                    sb.append(cCharAt);
                }
                cCharAt = (char) i;
                sb.append(cCharAt);
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override
    public boolean[] mo1533d(String str) {
        String strM5101j = m5101j(str);
        int length = strM5101j.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long after converting to extended encoding, but got ".concat(String.valueOf(length)));
        }
        boolean[] zArr = new boolean[((strM5101j.length() + 4) * 9) + 1];
        int iM5099h = m5099h(zArr, 0, C1154Z4.f3385e);
        for (int i = 0; i < length; i++) {
            iM5099h += m5099h(zArr, iM5099h, C1154Z4.f3384d["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(strM5101j.charAt(i))]);
        }
        int iM5100i = m5100i(strM5101j, 20);
        int[] iArr = C1154Z4.f3384d;
        int iM5099h2 = iM5099h + m5099h(zArr, iM5099h, iArr[iM5100i]);
        int iM5099h3 = iM5099h2 + m5099h(zArr, iM5099h2, iArr[m5100i(strM5101j + "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".charAt(iM5100i), 15)]);
        zArr[iM5099h3 + m5099h(zArr, iM5099h3, C1154Z4.f3385e)] = true;
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.CODE_93);
    }
}
