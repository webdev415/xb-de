package p000;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;

/* loaded from: classes.dex */
public abstract class AbstractC2198pd {
    public static final boolean m9059a(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (AbstractC0116Ce.m477f(cCharAt, 31) <= 0 || AbstractC0116Ce.m477f(cCharAt, 127) >= 0 || AbstractC0584Mm.m2928L(" #%/:?@[\\]", cCharAt, 0, false, 6, null) != -1) {
                return true;
            }
        }
        return false;
    }

    public static final boolean m9060b(String str, int i, int i2, byte[] bArr, int i3) {
        int i4 = i3;
        while (i < i2) {
            if (i4 == bArr.length) {
                return false;
            }
            if (i4 != i3) {
                if (str.charAt(i) != '.') {
                    return false;
                }
                i++;
            }
            int i5 = i;
            int i6 = 0;
            while (i5 < i2) {
                char cCharAt = str.charAt(i5);
                if (AbstractC0116Ce.m477f(cCharAt, 48) < 0 || AbstractC0116Ce.m477f(cCharAt, 57) > 0) {
                    break;
                }
                if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + cCharAt) - 48) > 255) {
                    return false;
                }
                i5++;
            }
            if (i5 - i == 0) {
                return false;
            }
            bArr[i4] = (byte) i6;
            i4++;
            i = i5;
        }
        return i4 == i3 + 4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0097, code lost:
    
        if (r13 == 16) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0099, code lost:
    
        if (r14 != (-1)) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x009b, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x009c, code lost:
    
        r0 = r13 - r14;
        java.lang.System.arraycopy(r9, r14, r9, 16 - r0, r0);
        java.util.Arrays.fill(r9, r14, (16 - r13) + r14, (byte) 0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00ae, code lost:
    
        return java.net.InetAddress.getByAddress(r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:31:0x006b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final InetAddress m9061c(String r18, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 175
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2198pd.m9061c(java.lang.String, int, int):java.net.InetAddress");
    }

    public static final String m9062d(byte[] bArr) {
        int i = -1;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i3 < bArr.length) {
            int i5 = i3;
            while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                i5 += 2;
            }
            int i6 = i5 - i3;
            if (i6 > i4 && i6 >= 4) {
                i = i3;
                i4 = i6;
            }
            i3 = i5 + 2;
        }
        C2409u3 c2409u3 = new C2409u3();
        while (i2 < bArr.length) {
            if (i2 == i) {
                c2409u3.mo5926L(58);
                i2 += i4;
                if (i2 == 16) {
                    c2409u3.mo5926L(58);
                }
            } else {
                if (i2 > 0) {
                    c2409u3.mo5926L(58);
                }
                c2409u3.mo5932m((AbstractC2623yo.m10927b(bArr[i2], 255) << 8) | AbstractC2623yo.m10927b(bArr[i2 + 1], 255));
                i2 += 2;
            }
        }
        return c2409u3.m9908V();
    }

    public static final String m9063e(String str) {
        int length;
        AbstractC0116Ce.m476e(str, "$this$toCanonicalHost");
        int i = 0;
        if (!AbstractC0584Mm.m2918B(str, ":", false, 2, null)) {
            try {
                String ascii = IDN.toASCII(str);
                AbstractC0116Ce.m475d(ascii, "IDN.toASCII(host)");
                Locale locale = Locale.US;
                AbstractC0116Ce.m475d(locale, "Locale.US");
                if (ascii == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                }
                String lowerCase = ascii.toLowerCase(locale);
                AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                if (lowerCase.length() != 0 && !m9059a(lowerCase)) {
                    return lowerCase;
                }
                return null;
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }
        if (AbstractC0538Lm.m2731w(str, "[", false, 2, null) && AbstractC0538Lm.m2719k(str, "]", false, 2, null)) {
            i = 1;
            length = str.length() - 1;
        } else {
            length = str.length();
        }
        InetAddress inetAddressM9061c = m9061c(str, i, length);
        if (inetAddressM9061c == null) {
            return null;
        }
        byte[] address = inetAddressM9061c.getAddress();
        if (address.length == 16) {
            AbstractC0116Ce.m475d(address, "address");
            return m9062d(address);
        }
        if (address.length == 4) {
            return inetAddressM9061c.getHostAddress();
        }
        throw new AssertionError("Invalid IPv6 address: '" + str + '\'');
    }
}
