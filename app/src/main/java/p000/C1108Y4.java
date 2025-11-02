package p000;

import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class C1108Y4 extends AbstractC0992Vh {
    public static void m4871h(int i, int[] iArr) {
        for (int i2 = 0; i2 < 9; i2++) {
            int i3 = 1;
            if (((1 << (8 - i2)) & i) != 0) {
                i3 = 2;
            }
            iArr[i2] = i3;
        }
    }

    public static String m4872i(String str) {
        String str2;
        int i;
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt != 0) {
                char c = cCharAt;
                if (cCharAt != ' ') {
                    if (cCharAt == '@') {
                        str2 = "%V";
                    } else if (cCharAt != '`') {
                        c = cCharAt;
                        if (cCharAt != '-') {
                            c = cCharAt;
                            if (cCharAt != '.') {
                                if (cCharAt <= 26) {
                                    sb.append('$');
                                    i = cCharAt + 64;
                                } else if (cCharAt < ' ') {
                                    sb.append('%');
                                    i = cCharAt + 38;
                                } else if (cCharAt <= ',' || cCharAt == '/' || cCharAt == ':') {
                                    sb.append('/');
                                    i = cCharAt + 32;
                                } else {
                                    i = cCharAt;
                                    if (cCharAt > '9') {
                                        if (cCharAt <= '?') {
                                            sb.append('%');
                                            i = cCharAt + 11;
                                        } else {
                                            i = cCharAt;
                                            if (cCharAt > 'Z') {
                                                if (cCharAt <= '_') {
                                                    sb.append('%');
                                                    i = cCharAt - 16;
                                                } else if (cCharAt <= 'z') {
                                                    sb.append('+');
                                                    i = cCharAt - 32;
                                                } else {
                                                    if (cCharAt > 127) {
                                                        throw new IllegalArgumentException("Requested content contains a non-encodable character: '" + str.charAt(i2) + "'");
                                                    }
                                                    sb.append('%');
                                                    i = cCharAt - 43;
                                                }
                                            }
                                        }
                                    }
                                }
                                c = (char) i;
                            }
                        }
                    } else {
                        str2 = "%W";
                    }
                }
                sb.append(c);
            } else {
                str2 = "%U";
            }
            sb.append(str2);
        }
        return sb.toString();
    }

    @Override
    public boolean[] mo1533d(String str) {
        int length = str.length();
        if (length > 80) {
            throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got ".concat(String.valueOf(length)));
        }
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            if ("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i)) < 0) {
                str = m4872i(str);
                length = str.length();
                if (length > 80) {
                    throw new IllegalArgumentException("Requested contents should be less than 80 digits long, but got " + length + " (extended full ASCII mode)");
                }
            } else {
                i++;
            }
        }
        int[] iArr = new int[9];
        boolean[] zArr = new boolean[(length * 13) + 25];
        m4871h(148, iArr);
        int iM4408b = AbstractC0992Vh.m4408b(zArr, 0, iArr, true);
        int[] iArr2 = {1};
        int iM4408b2 = iM4408b + AbstractC0992Vh.m4408b(zArr, iM4408b, iArr2, false);
        for (int i2 = 0; i2 < length; i2++) {
            m4871h(C1062X4.f3168e["0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(str.charAt(i2))], iArr);
            int iM4408b3 = iM4408b2 + AbstractC0992Vh.m4408b(zArr, iM4408b2, iArr, true);
            iM4408b2 = iM4408b3 + AbstractC0992Vh.m4408b(zArr, iM4408b3, iArr2, false);
        }
        m4871h(148, iArr);
        AbstractC0992Vh.m4408b(zArr, iM4408b2, iArr, true);
        return zArr;
    }

    @Override
    public Collection mo1534f() {
        return Collections.singleton(BarcodeFormat.CODE_39);
    }
}
