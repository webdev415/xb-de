package p000;

import java.util.Arrays;

public abstract class AbstractC2105nd {
    public static int m8744a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            loop0: while (true) {
                char cCharAt = charSequence.charAt(i);
                while (m8749f(cCharAt) && i < length) {
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

    /* JADX WARN: Removed duplicated region for block: B:15:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static String m8745b(String r8, EnumC1043Wm r9, AbstractC0882T8 r10, AbstractC0882T8 r11) {
        /*
            m r0 = new m
            r0.<init>()
            E3 r1 = new E3
            r1.<init>()
            un r2 = new un
            r2.<init>()
            Dp r3 = new Dp
            r3.<init>()
            L9 r4 = new L9
            r4.<init>()
            s2 r5 = new s2
            r5.<init>()
            r6 = 6
            U9[] r6 = new p000.InterfaceC0929U9[r6]
            r7 = 0
            r6[r7] = r0
            r0 = 1
            r6[r0] = r1
            r1 = 2
            r6[r1] = r2
            r2 = 3
            r6[r2] = r3
            r2 = 4
            r6[r2] = r4
            r3 = 5
            r6[r3] = r5
            X9 r4 = new X9
            r4.<init>(r8)
            r4.m4677n(r9)
            r4.m4675l(r10, r11)
            java.lang.String r9 = "[)>\u001e05\u001d"
            boolean r9 = r8.startsWith(r9)
            java.lang.String r10 = "\u001e\u0004"
            if (r9 == 0) goto L5d
            boolean r9 = r8.endsWith(r10)
            if (r9 == 0) goto L5d
            r8 = 236(0xec, float:3.31E-43)
        L50:
            r4.m4681r(r8)
            r4.m4676m(r1)
            int r8 = r4.f3195d
            int r8 = r8 + 7
            r4.f3195d = r8
            goto L6e
        L5d:
            java.lang.String r9 = "[)>\u001e06\u001d"
            boolean r9 = r8.startsWith(r9)
            if (r9 == 0) goto L6e
            boolean r8 = r8.endsWith(r10)
            if (r8 == 0) goto L6e
            r8 = 237(0xed, float:3.32E-43)
            goto L50
        L6e:
            boolean r8 = r4.m4672i()
            if (r8 == 0) goto L87
            r8 = r6[r7]
            r8.mo776a(r4)
            int r8 = r4.m4668e()
            if (r8 < 0) goto L6e
            int r7 = r4.m4668e()
            r4.m4673j()
            goto L6e
        L87:
            int r8 = r4.m4664a()
            r4.m4679p()
            Vm r9 = r4.m4670g()
            int r9 = r9.m4425a()
            if (r8 >= r9) goto La3
            if (r7 == 0) goto La3
            if (r7 == r3) goto La3
            if (r7 == r2) goto La3
            r8 = 254(0xfe, float:3.56E-43)
            r4.m4681r(r8)
        La3:
            java.lang.StringBuilder r8 = r4.m4665b()
            int r10 = r8.length()
            if (r10 >= r9) goto Lb2
            r10 = 129(0x81, float:1.81E-43)
        Laf:
            r8.append(r10)
        Lb2:
            int r10 = r8.length()
            if (r10 >= r9) goto Lc2
            int r10 = r8.length()
            int r10 = r10 + r0
            char r10 = m8758o(r10)
            goto Laf
        Lc2:
            java.lang.StringBuilder r8 = r4.m4665b()
            java.lang.String r8 = r8.toString()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2105nd.m8745b(java.lang.String, Wm, T8, T8):java.lang.String");
    }

    public static int m8746c(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        for (int i2 = 0; i2 < 6; i2++) {
            int iCeil = (int) Math.ceil(fArr[i2]);
            iArr[i2] = iCeil;
            if (i > iCeil) {
                Arrays.fill(bArr, (byte) 0);
                i = iCeil;
            }
            if (i == iCeil) {
                bArr[i2] = (byte) (bArr[i2] + 1);
            }
        }
        return i;
    }

    public static int m8747d(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static void m8748e(char c) {
        String hexString = Integer.toHexString(c);
        throw new IllegalArgumentException("Illegal character: " + c + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }

    public static boolean m8749f(char c) {
        return c >= '0' && c <= '9';
    }

    public static boolean m8750g(char c) {
        return c >= 128 && c <= 255;
    }

    public static boolean m8751h(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean m8752i(char c) {
        return c >= ' ' && c <= '^';
    }

    public static boolean m8753j(char c) {
        if (c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'a' && c <= 'z';
        }
        return true;
    }

    public static boolean m8754k(char c) {
        if (m8756m(c) || c == ' ') {
            return true;
        }
        if (c < '0' || c > '9') {
            return c >= 'A' && c <= 'Z';
        }
        return true;
    }

    public static boolean m8755l(char c) {
        return false;
    }

    public static boolean m8756m(char c) {
        return c == '\r' || c == '*' || c == '>';
    }

    /* JADX WARN: Code restructure failed: missing block: B:123:0x01dd, code lost:
    
        return 5;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m8757n(CharSequence r20, int r21, int r22) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2105nd.m8757n(java.lang.CharSequence, int, int):int");
    }

    public static char m8758o(int i) {
        int i2 = (i * 149) % 253;
        int i3 = i2 + 130;
        if (i3 > 254) {
            i3 = i2 - 124;
        }
        return (char) i3;
    }
}
