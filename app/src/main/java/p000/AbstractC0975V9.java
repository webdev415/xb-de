package p000;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractC0975V9 {

    public static final int[] f2942a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    public static class a {

        public static final int[] f2943a;

        static {
            int[] iArr = new int[EnumC0991Vg.values().length];
            f2943a = iArr;
            try {
                iArr[EnumC0991Vg.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2943a[EnumC0991Vg.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2943a[EnumC0991Vg.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2943a[EnumC0991Vg.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static void m4343a(String str, C0233F2 c0233f2, String str2) throws UnsupportedEncodingException, C0127Cp {
        try {
            for (byte b : str.getBytes(str2)) {
                c0233f2.m1185c(b, 8);
            }
        } catch (UnsupportedEncodingException e) {
            throw new C0127Cp(e);
        }
    }

    public static void m4344b(CharSequence charSequence, C0233F2 c0233f2) throws C0127Cp {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iM4358p = m4358p(charSequence.charAt(i));
            if (iM4358p == -1) {
                throw new C0127Cp();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iM4358p2 = m4358p(charSequence.charAt(i2));
                if (iM4358p2 == -1) {
                    throw new C0127Cp();
                }
                c0233f2.m1185c((iM4358p * 45) + iM4358p2, 11);
                i += 2;
            } else {
                c0233f2.m1185c(iM4358p, 6);
                i = i2;
            }
        }
    }

    public static void m4345c(String str, EnumC0991Vg enumC0991Vg, C0233F2 c0233f2, String str2) throws UnsupportedEncodingException, C0127Cp {
        int i = a.f2943a[enumC0991Vg.ordinal()];
        if (i == 1) {
            m4350h(str, c0233f2);
            return;
        }
        if (i == 2) {
            m4344b(str, c0233f2);
        } else if (i == 3) {
            m4343a(str, c0233f2, str2);
        } else {
            if (i != 4) {
                throw new C0127Cp("Invalid mode: ".concat(String.valueOf(enumC0991Vg)));
            }
            m4347e(str, c0233f2);
        }
    }

    public static void m4346d(EnumC2364t4 enumC2364t4, C0233F2 c0233f2) {
        c0233f2.m1185c(EnumC0991Vg.ECI.m4406e(), 4);
        c0233f2.m1185c(enumC2364t4.m9679g(), 8);
    }

    public static void m4347e(String str, C0233F2 c0233f2) throws UnsupportedEncodingException, C0127Cp {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            if (bytes.length % 2 != 0) {
                throw new C0127Cp("Kanji byte size not even");
            }
            int length = bytes.length - 1;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i == -1) {
                    throw new C0127Cp("Invalid byte sequence");
                }
                c0233f2.m1185c(((i >> 8) * 192) + (i & 255), 13);
            }
        } catch (UnsupportedEncodingException e) {
            throw new C0127Cp(e);
        }
    }

    public static void m4348f(int i, C0126Co c0126Co, EnumC0991Vg enumC0991Vg, C0233F2 c0233f2) throws C0127Cp {
        int iM4407g = enumC0991Vg.m4407g(c0126Co);
        int i2 = 1 << iM4407g;
        if (i < i2) {
            c0233f2.m1185c(i, iM4407g);
            return;
        }
        throw new C0127Cp(i + " is bigger than " + (i2 - 1));
    }

    public static void m4349g(EnumC0991Vg enumC0991Vg, C0233F2 c0233f2) {
        c0233f2.m1185c(enumC0991Vg.m4406e(), 4);
    }

    public static void m4350h(CharSequence charSequence, C0233F2 c0233f2) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                c0233f2.m1185c((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    c0233f2.m1185c((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    c0233f2.m1185c(iCharAt, 4);
                }
            }
        }
    }

    public static int m4351i(EnumC0991Vg enumC0991Vg, C0233F2 c0233f2, C0233F2 c0233f22, C0126Co c0126Co) {
        return c0233f2.m1193o() + enumC0991Vg.m4407g(c0126Co) + c0233f22.m1193o();
    }

    public static int m4352j(C0050B3 c0050b3) {
        return AbstractC2385tg.m9708a(c0050b3) + AbstractC2385tg.m9710c(c0050b3) + AbstractC2385tg.m9711d(c0050b3) + AbstractC2385tg.m9712e(c0050b3);
    }

    public static int m4353k(C0233F2 c0233f2, EnumC1363ca enumC1363ca, C0126Co c0126Co, C0050B3 c0050b3) throws C0127Cp {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            AbstractC2523wg.m10567a(c0233f2, enumC1363ca, c0126Co, i3, c0050b3);
            int iM4352j = m4352j(c0050b3);
            if (iM4352j < i) {
                i2 = i3;
                i = iM4352j;
            }
        }
        return i2;
    }

    public static EnumC0991Vg m4354l(String str, String str2) {
        if ("Shift_JIS".equals(str2) && m4361s(str)) {
            return EnumC0991Vg.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (m4358p(cCharAt) == -1) {
                    return EnumC0991Vg.BYTE;
                }
                z = true;
            }
        }
        return z ? EnumC0991Vg.ALPHANUMERIC : z2 ? EnumC0991Vg.NUMERIC : EnumC0991Vg.BYTE;
    }

    public static C0126Co m4355m(int i, EnumC1363ca enumC1363ca) throws C0127Cp {
        for (int i2 = 1; i2 <= 40; i2++) {
            C0126Co c0126CoM513i = C0126Co.m513i(i2);
            if (m4364v(i, c0126CoM513i, enumC1363ca)) {
                return c0126CoM513i;
            }
        }
        throw new C0127Cp("Data too big");
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static C2618yj m4356n(String r6, EnumC1363ca r7, java.util.Map r8) throws NumberFormatException, UnsupportedEncodingException, C0127Cp {
        /*
            if (r8 == 0) goto Lc
            T9 r0 = p000.EnumC0883T9.CHARACTER_SET
            boolean r0 = r8.containsKey(r0)
            if (r0 == 0) goto Lc
            r0 = 1
            goto Ld
        Lc:
            r0 = 0
        Ld:
            if (r0 == 0) goto L1a
            T9 r1 = p000.EnumC0883T9.CHARACTER_SET
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            goto L1c
        L1a:
            java.lang.String r1 = "ISO-8859-1"
        L1c:
            Vg r2 = m4354l(r6, r1)
            F2 r3 = new F2
            r3.<init>()
            Vg r4 = p000.EnumC0991Vg.BYTE
            if (r2 != r4) goto L34
            if (r0 == 0) goto L34
            t4 r0 = p000.EnumC2364t4.m9677c(r1)
            if (r0 == 0) goto L34
            m4346d(r0, r3)
        L34:
            if (r8 == 0) goto L51
            T9 r0 = p000.EnumC0883T9.GS1_FORMAT
            boolean r5 = r8.containsKey(r0)
            if (r5 == 0) goto L51
            java.lang.Object r0 = r8.get(r0)
            java.lang.String r0 = r0.toString()
            boolean r0 = java.lang.Boolean.parseBoolean(r0)
            if (r0 == 0) goto L51
            Vg r0 = p000.EnumC0991Vg.FNC1_FIRST_POSITION
            m4349g(r0, r3)
        L51:
            m4349g(r2, r3)
            F2 r0 = new F2
            r0.<init>()
            m4345c(r6, r2, r0, r1)
            if (r8 == 0) goto L89
            T9 r1 = p000.EnumC0883T9.QR_VERSION
            boolean r5 = r8.containsKey(r1)
            if (r5 == 0) goto L89
            java.lang.Object r1 = r8.get(r1)
            java.lang.String r1 = r1.toString()
            int r1 = java.lang.Integer.parseInt(r1)
            Co r1 = p000.C0126Co.m513i(r1)
            int r5 = m4351i(r2, r3, r0, r1)
            boolean r5 = m4364v(r5, r1, r7)
            if (r5 == 0) goto L81
            goto L8d
        L81:
            Cp r6 = new Cp
            java.lang.String r7 = "Data too big for requested version"
            r6.<init>(r7)
            throw r6
        L89:
            Co r1 = m4362t(r7, r2, r3, r0)
        L8d:
            F2 r5 = new F2
            r5.<init>()
            r5.m1184b(r3)
            if (r2 != r4) goto L9c
            int r6 = r0.m1194q()
            goto La0
        L9c:
            int r6 = r6.length()
        La0:
            m4348f(r6, r1, r2, r5)
            r5.m1184b(r0)
            Co$b r6 = r1.m517f(r7)
            int r0 = r1.m518h()
            int r3 = r6.m525d()
            int r0 = r0 - r3
            m4363u(r0, r5)
            int r3 = r1.m518h()
            int r6 = r6.m524c()
            F2 r6 = m4360r(r5, r3, r0, r6)
            yj r0 = new yj
            r0.<init>()
            r0.m10895c(r7)
            r0.m10898f(r2)
            r0.m10899g(r1)
            int r2 = r1.m516e()
            B3 r3 = new B3
            r3.<init>(r2, r2)
            r2 = -1
            if (r8 == 0) goto Lf7
            T9 r4 = p000.EnumC0883T9.QR_MASK_PATTERN
            boolean r5 = r8.containsKey(r4)
            if (r5 == 0) goto Lf7
            java.lang.Object r8 = r8.get(r4)
            java.lang.String r8 = r8.toString()
            int r8 = java.lang.Integer.parseInt(r8)
            boolean r4 = p000.C2618yj.m10893b(r8)
            if (r4 == 0) goto Lf7
            goto Lf8
        Lf7:
            r8 = r2
        Lf8:
            if (r8 != r2) goto Lfe
            int r8 = m4353k(r6, r7, r1, r3)
        Lfe:
            r0.m10896d(r8)
            p000.AbstractC2523wg.m10567a(r6, r7, r1, r8, r3)
            r0.m10897e(r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0975V9.m4356n(java.lang.String, ca, java.util.Map):yj");
    }

    public static byte[] m4357o(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new C2066mk(C2611yc.f8075l).m8639b(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    public static int m4358p(int i) {
        int[] iArr = f2942a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static void m4359q(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws C0127Cp {
        if (i4 >= i3) {
            throw new C0127Cp("Block ID too large");
        }
        int i5 = i % i3;
        int i6 = i3 - i5;
        int i7 = i / i3;
        int i8 = i7 + 1;
        int i9 = i2 / i3;
        int i10 = i9 + 1;
        int i11 = i7 - i9;
        int i12 = i8 - i10;
        if (i11 != i12) {
            throw new C0127Cp("EC bytes mismatch");
        }
        if (i3 != i6 + i5) {
            throw new C0127Cp("RS blocks mismatch");
        }
        if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
            throw new C0127Cp("Total bytes mismatch");
        }
        if (i4 < i6) {
            iArr[0] = i9;
            iArr2[0] = i11;
        } else {
            iArr[0] = i10;
            iArr2[0] = i12;
        }
    }

    public static C0233F2 m4360r(C0233F2 c0233f2, int i, int i2, int i3) throws C0127Cp {
        if (c0233f2.m1194q() != i2) {
            throw new C0127Cp("Number of bits and data bytes does not match");
        }
        ArrayList arrayList = new ArrayList<>(i3);
        int i4 = 0;
        int iMax = 0;
        int iMax2 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int[] iArr = new int[1];
            int[] iArr2 = new int[1];
            m4359q(i, i2, i3, i5, iArr, iArr2);
            int i6 = iArr[0];
            byte[] bArr = new byte[i6];
            c0233f2.m1199w(i4 << 3, bArr, 0, i6);
            byte[] bArrM4357o = m4357o(bArr, iArr2[0]);
            arrayList.add(new C0555M2(bArr, bArrM4357o));
            iMax = Math.max(iMax, i6);
            iMax2 = Math.max(iMax2, bArrM4357o.length);
            i4 += iArr[0];
        }
        if (i2 != i4) {
            throw new C0127Cp("Data bytes does not match offset");
        }
        C0233F2 c0233f22 = new C0233F2();
        for (int i7 = 0; i7 < iMax; i7++) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                byte[] bArrM2813a = ((C0555M2) it.next()).m2813a();
                if (i7 < bArrM2813a.length) {
                    c0233f22.m1185c(bArrM2813a[i7], 8);
                }
            }
        }
        for (int i8 = 0; i8 < iMax2; i8++) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                byte[] bArrM2814b = ((C0555M2) it2.next()).m2814b();
                if (i8 < bArrM2814b.length) {
                    c0233f22.m1185c(bArrM2814b[i8], 8);
                }
            }
        }
        if (i == c0233f22.m1194q()) {
            return c0233f22;
        }
        throw new C0127Cp("Interleaving error: " + i + " and " + c0233f22.m1194q() + " differ.");
    }

    public static boolean m4361s(String str) throws UnsupportedEncodingException {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static C0126Co m4362t(EnumC1363ca enumC1363ca, EnumC0991Vg enumC0991Vg, C0233F2 c0233f2, C0233F2 c0233f22) {
        return m4355m(m4351i(enumC0991Vg, c0233f2, c0233f22, m4355m(m4351i(enumC0991Vg, c0233f2, c0233f22, C0126Co.m513i(1)), enumC1363ca)), enumC1363ca);
    }

    public static void m4363u(int i, C0233F2 c0233f2) throws C0127Cp {
        int i2 = i << 3;
        if (c0233f2.m1193o() > i2) {
            throw new C0127Cp("data bits cannot fit in the QR Code" + c0233f2.m1193o() + " > " + i2);
        }
        for (int i3 = 0; i3 < 4 && c0233f2.m1193o() < i2; i3++) {
            c0233f2.m1183a(false);
        }
        int iM1193o = c0233f2.m1193o() & 7;
        if (iM1193o > 0) {
            while (iM1193o < 8) {
                c0233f2.m1183a(false);
                iM1193o++;
            }
        }
        int iM1194q = i - c0233f2.m1194q();
        for (int i4 = 0; i4 < iM1194q; i4++) {
            c0233f2.m1185c((i4 & 1) == 0 ? 236 : 17, 8);
        }
        if (c0233f2.m1193o() != i2) {
            throw new C0127Cp("Bits size does not equal capacity");
        }
    }

    public static boolean m4364v(int i, C0126Co c0126Co, EnumC1363ca enumC1363ca) {
        return c0126Co.m518h() - c0126Co.m517f(enumC1363ca).m525d() >= (i + 7) / 8;
    }
}
