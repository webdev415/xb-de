package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class C0422J7 {

    public static final String[] f1280b = {"CTRL_PS", " ", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "CTRL_LL", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    public static final String[] f1281c = {"CTRL_PS", " ", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "CTRL_US", "CTRL_ML", "CTRL_DL", "CTRL_BS"};

    public static final String[] f1282d = {"CTRL_PS", " ", "\u0001", "\u0002", "\u0003", "\u0004", "\u0005", "\u0006", "\u0007", "\b", "\t", "\n", "\u000b", "\f", "\r", "\u001b", "\u001c", "\u001d", "\u001e", "\u001f", "@", "\\", "^", "_", "`", "|", "~", "\u007f", "CTRL_LL", "CTRL_UL", "CTRL_PL", "CTRL_BS"};

    public static final String[] f1283e = {"", "\r", "\r\n", ". ", ", ", ": ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", ":", ";", "<", "=", ">", "?", "[", "]", "{", "}", "CTRL_UL"};

    public static final String[] f1284f = {"CTRL_PS", " ", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ",", ".", "CTRL_UL", "CTRL_US"};

    public C1151Z1 f1285a;

    public static class a {

        public static final int[] f1286a;

        static {
            int[] iArr = new int[b.values().length];
            f1286a = iArr;
            try {
                iArr[b.UPPER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f1286a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f1286a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f1286a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f1286a[b.DIGIT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public enum b {
        UPPER,
        LOWER,
        MIXED,
        DIGIT,
        PUNCT,
        BINARY
    }

    public static byte[] m1822a(boolean[] zArr) {
        int length = (zArr.length + 7) / 8;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = m1826h(zArr, i << 3);
        }
        return bArr;
    }

    public static String m1823e(b bVar, int i) {
        int i2 = a.f1286a[bVar.ordinal()];
        if (i2 == 1) {
            return f1280b[i];
        }
        if (i2 == 2) {
            return f1281c[i];
        }
        if (i2 == 3) {
            return f1282d[i];
        }
        if (i2 == 4) {
            return f1283e[i];
        }
        if (i2 == 5) {
            return f1284f[i];
        }
        throw new IllegalStateException("Bad table");
    }

    public static String m1824f(boolean[] zArr) {
        int length = zArr.length;
        b bVar = b.UPPER;
        StringBuilder sb = new StringBuilder(20);
        b bVarM1825g = bVar;
        int i = 0;
        while (i < length) {
            if (bVar != b.BINARY) {
                int i2 = bVar == b.DIGIT ? 4 : 5;
                if (length - i < i2) {
                    break;
                }
                int iM1827i = m1827i(zArr, i, i2);
                i += i2;
                String strM1823e = m1823e(bVar, iM1827i);
                if (strM1823e.startsWith("CTRL_")) {
                    bVarM1825g = m1825g(strM1823e.charAt(5));
                    if (strM1823e.charAt(6) != 'L') {
                        bVarM1825g = bVar;
                        bVar = bVarM1825g;
                    }
                } else {
                    sb.append(strM1823e);
                }
                bVar = bVarM1825g;
            } else {
                if (length - i < 5) {
                    break;
                }
                int iM1827i2 = m1827i(zArr, i, 5);
                int i3 = i + 5;
                if (iM1827i2 == 0) {
                    if (length - i3 < 11) {
                        break;
                    }
                    iM1827i2 = m1827i(zArr, i3, 11) + 31;
                    i3 = i + 16;
                }
                int i4 = 0;
                while (true) {
                    if (i4 >= iM1827i2) {
                        i = i3;
                        break;
                    }
                    if (length - i3 < 8) {
                        i = length;
                        break;
                    }
                    sb.append((char) m1827i(zArr, i3, 8));
                    i3 += 8;
                    i4++;
                }
                bVar = bVarM1825g;
            }
        }
        return sb.toString();
    }

    public static b m1825g(char c) {
        return c != 'B' ? c != 'D' ? c != 'P' ? c != 'L' ? c != 'M' ? b.UPPER : b.MIXED : b.LOWER : b.PUNCT : b.DIGIT : b.BINARY;
    }

    public static byte m1826h(boolean[] zArr, int i) {
        int length = zArr.length - i;
        return (byte) (length >= 8 ? m1827i(zArr, i, 8) : m1827i(zArr, i, length) << (8 - length));
    }

    public static int m1827i(boolean[] zArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            i3 <<= 1;
            if (zArr[i4]) {
                i3 |= 1;
            }
        }
        return i3;
    }

    public static int m1828j(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }

    public final boolean[] m1829b(boolean[] zArr) throws C2610yb {
        int i;
        C2611yc c2611yc;
        if (this.f1285a.m5011d() <= 2) {
            c2611yc = C2611yc.f8073j;
            i = 6;
        } else {
            i = 8;
            if (this.f1285a.m5011d() <= 8) {
                c2611yc = C2611yc.f8077n;
            } else if (this.f1285a.m5011d() <= 22) {
                c2611yc = C2611yc.f8072i;
                i = 10;
            } else {
                c2611yc = C2611yc.f8071h;
                i = 12;
            }
        }
        int iM5010c = this.f1285a.m5010c();
        int length = zArr.length / i;
        if (length < iM5010c) {
            throw C2610yb.m10853a();
        }
        int length2 = zArr.length % i;
        int[] iArr = new int[length];
        int i2 = 0;
        while (i2 < length) {
            iArr[i2] = m1827i(zArr, length2, i);
            i2++;
            length2 += i;
        }
        try {
            new C2020lk(c2611yc).m8404a(iArr, length - iM5010c);
            int i3 = 1 << i;
            int i4 = i3 - 1;
            int i5 = 0;
            for (int i6 = 0; i6 < iM5010c; i6++) {
                int i7 = iArr[i6];
                if (i7 == 0 || i7 == i4) {
                    throw C2610yb.m10853a();
                }
                if (i7 == 1 || i7 == i3 - 2) {
                    i5++;
                }
            }
            boolean[] zArr2 = new boolean[(iM5010c * i) - i5];
            int i8 = 0;
            for (int i9 = 0; i9 < iM5010c; i9++) {
                int i10 = iArr[i9];
                if (i10 == 1 || i10 == i3 - 2) {
                    Arrays.fill(zArr2, i8, (i8 + i) - 1, i10 > 1);
                    i8 += i - 1;
                } else {
                    int i11 = i - 1;
                    while (i11 >= 0) {
                        int i12 = i8 + 1;
                        zArr2[i8] = ((1 << i11) & i10) != 0;
                        i11--;
                        i8 = i12;
                    }
                }
            }
            return zArr2;
        } catch (C2112nk e) {
            throw C2610yb.m10854b(e);
        }
    }

    public C0698P7 m1830c(C1151Z1 c1151z1) throws C2610yb {
        this.f1285a = c1151z1;
        boolean[] zArrM1829b = m1829b(m1831d(c1151z1.m3384a()));
        C0698P7 c0698p7 = new C0698P7(m1822a(zArrM1829b), m1824f(zArrM1829b), null, null);
        c0698p7.m3487l(zArrM1829b.length);
        return c0698p7;
    }

    public final boolean[] m1831d(C0325H2 c0325h2) {
        boolean zM5012e = this.f1285a.m5012e();
        int iM5011d = this.f1285a.m5011d();
        int i = (zM5012e ? 11 : 14) + (iM5011d << 2);
        int[] iArr = new int[i];
        boolean[] zArr = new boolean[m1828j(iM5011d, zM5012e)];
        int i2 = 2;
        if (zM5012e) {
            for (int i3 = 0; i3 < i; i3++) {
                iArr[i3] = i3;
            }
        } else {
            int i4 = i / 2;
            int i5 = ((i + 1) + (((i4 - 1) / 15) * 2)) / 2;
            for (int i6 = 0; i6 < i4; i6++) {
                iArr[(i4 - i6) - 1] = (i5 - r12) - 1;
                iArr[i4 + i6] = (i6 / 15) + i6 + i5 + 1;
            }
        }
        int i7 = 0;
        int i8 = 0;
        while (i7 < iM5011d) {
            int i9 = ((iM5011d - i7) << i2) + (zM5012e ? 9 : 12);
            int i10 = i7 << 1;
            int i11 = (i - 1) - i10;
            int i12 = 0;
            while (i12 < i9) {
                int i13 = i12 << 1;
                int i14 = 0;
                while (i14 < i2) {
                    int i15 = i10 + i14;
                    int i16 = i10 + i12;
                    zArr[i8 + i13 + i14] = c0325h2.m1493e(iArr[i15], iArr[i16]);
                    int i17 = iArr[i16];
                    int i18 = i11 - i14;
                    zArr[(i9 * 2) + i8 + i13 + i14] = c0325h2.m1493e(i17, iArr[i18]);
                    int i19 = i11 - i12;
                    zArr[(i9 * 4) + i8 + i13 + i14] = c0325h2.m1493e(iArr[i18], iArr[i19]);
                    zArr[(i9 * 6) + i8 + i13 + i14] = c0325h2.m1493e(iArr[i19], iArr[i15]);
                    i14++;
                    iM5011d = iM5011d;
                    zM5012e = zM5012e;
                    i2 = 2;
                }
                i12++;
                i2 = 2;
            }
            i8 += i9 << 3;
            i7++;
            i2 = 2;
        }
        return zArr;
    }
}
