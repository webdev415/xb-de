package p000;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbstractC2295ri {

    public static final byte[] f6955c;

    public static final byte[] f6953a = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 38, 13, 9, 44, 58, 35, 45, 46, 36, 47, 43, 37, 42, 61, 94, 0, 32, 0, 0, 0};

    public static final byte[] f6954b = {59, 60, 62, 64, 91, 92, 93, 95, 96, 126, 33, 13, 9, 44, 58, 10, 45, 46, 36, 47, 34, 124, 42, 40, 41, 63, 123, 125, 39, 0};

    public static final byte[] f6956d = new byte[128];

    public static final Charset f6957e = StandardCharsets.ISO_8859_1;

    public static class a {

        public static final int[] f6958a;

        static {
            int[] iArr = new int[EnumC2503w5.values().length];
            f6958a = iArr;
            try {
                iArr[EnumC2503w5.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6958a[EnumC2503w5.BYTE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6958a[EnumC2503w5.NUMERIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        int i = 0;
        byte[] bArr = new byte[128];
        f6955c = bArr;
        Arrays.fill(bArr, (byte) -1);
        int i2 = 0;
        while (true) {
            byte[] bArr2 = f6953a;
            if (i2 >= bArr2.length) {
                break;
            }
            byte b = bArr2[i2];
            if (b > 0) {
                f6955c[b] = (byte) i2;
            }
            i2++;
        }
        Arrays.fill(f6956d, (byte) -1);
        while (true) {
            byte[] bArr3 = f6954b;
            if (i >= bArr3.length) {
                return;
            }
            byte b2 = bArr3[i];
            if (b2 > 0) {
                f6956d[b2] = (byte) i;
            }
            i++;
        }
    }

    public static int m9415a(String str, int i, Charset charset) throws C0127Cp {
        int i2;
        CharsetEncoder charsetEncoderNewEncoder = charset.newEncoder();
        int length = str.length();
        int i3 = i;
        while (i3 < length) {
            char cCharAt = str.charAt(i3);
            int i4 = 0;
            while (i4 < 13 && m9425k(cCharAt) && (i2 = i3 + (i4 = i4 + 1)) < length) {
                cCharAt = str.charAt(i2);
            }
            if (i4 >= 13) {
                return i3 - i;
            }
            char cCharAt2 = str.charAt(i3);
            if (!charsetEncoderNewEncoder.canEncode(cCharAt2)) {
                throw new C0127Cp("Non-encodable character detected: " + cCharAt2 + " (Unicode: " + ((int) cCharAt2) + ')');
            }
            i3++;
        }
        return i3 - i;
    }

    public static int m9416b(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            loop0: while (true) {
                char cCharAt = charSequence.charAt(i);
                while (m9425k(cCharAt) && i < length) {
                    i2++;
                    i++;
                    if (i < length) {
                        break;
                    }
                }
            }
        }
        return i2;
    }

    public static int m9417c(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = i;
        while (i2 < length) {
            char cCharAt = charSequence.charAt(i2);
            int i3 = 0;
            while (i3 < 13 && m9425k(cCharAt) && i2 < length) {
                i3++;
                i2++;
                if (i2 < length) {
                    cCharAt = charSequence.charAt(i2);
                }
            }
            if (i3 < 13) {
                if (i3 <= 0) {
                    if (!m9428n(charSequence.charAt(i2))) {
                        break;
                    }
                    i2++;
                }
            } else {
                return (i2 - i) - i3;
            }
        }
        return i2 - i;
    }

    public static void m9418d(byte[] bArr, int i, int i2, int i3, StringBuilder sb) {
        int i4;
        sb.append((i2 == 1 && i3 == 0) ? (char) 913 : i2 % 6 == 0 ? (char) 924 : (char) 901);
        if (i2 >= 6) {
            char[] cArr = new char[5];
            i4 = i;
            while ((i + i2) - i4 >= 6) {
                long j = 0;
                for (int i5 = 0; i5 < 6; i5++) {
                    j = (j << 8) + (bArr[i4 + i5] & 255);
                }
                for (int i6 = 0; i6 < 5; i6++) {
                    cArr[i6] = (char) (j % 900);
                    j /= 900;
                }
                for (int i7 = 4; i7 >= 0; i7--) {
                    sb.append(cArr[i7]);
                }
                i4 += 6;
            }
        } else {
            i4 = i;
        }
        while (i4 < i + i2) {
            sb.append((char) (bArr[i4] & 255));
            i4++;
        }
    }

    public static String m9419e(String str, EnumC2503w5 enumC2503w5, Charset charset) throws C0127Cp {
        EnumC2364t4 enumC2364t4M9677c;
        StringBuilder sb = new StringBuilder(str.length());
        if (charset == null) {
            charset = f6957e;
        } else if (!f6957e.equals(charset) && (enumC2364t4M9677c = EnumC2364t4.m9677c(charset.name())) != null) {
            m9422h(enumC2364t4M9677c.m9679g(), sb);
        }
        int length = str.length();
        int i = a.f6958a[enumC2503w5.ordinal()];
        if (i == 1) {
            m9421g(str, 0, length, sb, 0);
        } else if (i == 2) {
            byte[] bytes = str.getBytes(charset);
            m9418d(bytes, 0, bytes.length, 1, sb);
        } else if (i != 3) {
            int i2 = 0;
            int iM9421g = 0;
            int i3 = 0;
            while (i2 < length) {
                int iM9416b = m9416b(str, i2);
                if (iM9416b >= 13) {
                    sb.append((char) 902);
                    m9420f(str, i2, iM9416b, sb);
                    i2 += iM9416b;
                    iM9421g = 0;
                    i3 = 2;
                } else {
                    int iM9417c = m9417c(str, i2);
                    if (iM9417c >= 5 || iM9416b == length) {
                        if (i3 != 0) {
                            sb.append((char) 900);
                            iM9421g = 0;
                            i3 = 0;
                        }
                        iM9421g = m9421g(str, i2, iM9417c, sb, iM9421g);
                        i2 += iM9417c;
                    } else {
                        int iM9415a = m9415a(str, i2, charset);
                        if (iM9415a == 0) {
                            iM9415a = 1;
                        }
                        int i4 = iM9415a + i2;
                        byte[] bytes2 = str.substring(i2, i4).getBytes(charset);
                        if (bytes2.length == 1 && i3 == 0) {
                            m9418d(bytes2, 0, 1, 0, sb);
                        } else {
                            m9418d(bytes2, 0, bytes2.length, i3, sb);
                            i3 = 1;
                            iM9421g = 0;
                        }
                        i2 = i4;
                    }
                }
            }
        } else {
            sb.append((char) 902);
            m9420f(str, 0, length, sb);
        }
        return sb.toString();
    }

    public static void m9420f(String str, int i, int i2, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder((i2 / 3) + 1);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        BigInteger bigIntegerValueOf2 = BigInteger.valueOf(0L);
        int i3 = 0;
        while (i3 < i2) {
            sb2.setLength(0);
            int iMin = Math.min(44, i2 - i3);
            StringBuilder sb3 = new StringBuilder("1");
            int i4 = i + i3;
            sb3.append(str.substring(i4, i4 + iMin));
            BigInteger bigInteger = new BigInteger(sb3.toString());
            do {
                sb2.append((char) bigInteger.mod(bigIntegerValueOf).intValue());
                bigInteger = bigInteger.divide(bigIntegerValueOf);
            } while (!bigInteger.equals(bigIntegerValueOf2));
            for (int length = sb2.length() - 1; length >= 0; length--) {
                sb.append(sb2.charAt(length));
            }
            i3 += iMin;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:45:0x00af, code lost:
    
        if (r8 == ' ') goto L32;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00cd A[EDGE_INSN: B:74:0x00cd->B:56:0x00cd BREAK  A[LOOP:0: B:3:0x000f->B:91:0x000f], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m9421g(CharSequence r16, int r17, int r18, StringBuilder r19, int r20) {
        /*
            Method dump skipped, instructions count: 246
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2295ri.m9421g(java.lang.CharSequence, int, int, java.lang.StringBuilder, int):int");
    }

    public static void m9422h(int i, StringBuilder sb) throws C0127Cp {
        char c;
        if (i >= 0 && i < 900) {
            sb.append((char) 927);
        } else {
            if (i >= 810900) {
                if (i >= 811800) {
                    throw new C0127Cp("ECI number not in valid range from 0..811799, but was ".concat(String.valueOf(i)));
                }
                sb.append((char) 925);
                c = (char) (810900 - i);
                sb.append(c);
            }
            sb.append((char) 926);
            sb.append((char) ((i / 900) - 1));
            i %= 900;
        }
        c = (char) i;
        sb.append(c);
    }

    public static boolean m9423i(char c) {
        if (c != ' ') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean m9424j(char c) {
        if (c != ' ') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean m9425k(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean m9426l(char c) {
        return f6955c[c] != -1;
    }

    public static boolean m9427m(char c) {
        return f6956d[c] != -1;
    }

    public static boolean m9428n(char c) {
        if (c == '\t' || c == '\n' || c == '\r') {
            return true;
        }
        return c >= ' ' && c <= '~';
    }
}
