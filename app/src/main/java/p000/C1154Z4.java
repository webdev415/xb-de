package p000;

import java.util.Arrays;
import java.util.Map;

public final class C1154Z4 extends AbstractC0946Uh {

    public static final char[] f3383c = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".toCharArray();

    public static final int[] f3384d;

    public static final int f3385e;

    public final StringBuilder f3386a = new StringBuilder(20);

    public final int[] f3387b = new int[6];

    static {
        int[] iArr = {276, 328, 324, 322, 296, 292, 290, 336, 274, 266, 424, 420, 418, 404, 402, 394, 360, 356, 354, 308, 282, 344, 332, 326, 300, 278, 436, 434, 428, 422, 406, 410, 364, 358, 310, 314, 302, 468, 466, 458, 366, 374, 430, 294, 474, 470, 306, 350};
        f3384d = iArr;
        f3385e = iArr[47];
    }

    public static void m5013i(CharSequence charSequence) throws C2548x4 {
        int length = charSequence.length();
        m5014j(charSequence, length - 2, 20);
        m5014j(charSequence, length - 1, 15);
    }

    public static void m5014j(CharSequence charSequence, int i, int i2) throws C2548x4 {
        int iIndexOf = 0;
        int i3 = 1;
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%abcd*".indexOf(charSequence.charAt(i4)) * i3;
            i3++;
            if (i3 > i2) {
                i3 = 1;
            }
        }
        if (charSequence.charAt(i) != f3383c[iIndexOf % 47]) {
            throw C2548x4.m10627a();
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:12:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static String m5015k(CharSequence r9) throws C2610yb {
        /*
            int r0 = r9.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lb0
            char r4 = r9.charAt(r3)
            r5 = 97
            if (r4 < r5) goto L9e
            r5 = 100
            if (r4 > r5) goto L9e
            int r5 = r0 + (-1)
            if (r3 >= r5) goto La7
            int r3 = r3 + 1
            char r5 = r9.charAt(r3)
            r6 = 79
            r7 = 90
            r8 = 65
            switch(r4) {
                case 97: goto L97;
                case 98: goto L4e;
                case 99: goto L3d;
                case 100: goto L2f;
                default: goto L2c;
            }
        L2c:
            r4 = r2
            goto L9e
        L2f:
            if (r5 < r8) goto L38
            if (r5 > r7) goto L38
            int r5 = r5 + 32
        L35:
            char r4 = (char) r5
            goto L9e
        L38:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L3d:
            if (r5 < r8) goto L44
            if (r5 > r6) goto L44
            int r5 = r5 + (-32)
            goto L35
        L44:
            if (r5 != r7) goto L49
            r4 = 58
            goto L9e
        L49:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L4e:
            if (r5 < r8) goto L57
            r4 = 69
            if (r5 > r4) goto L57
            int r5 = r5 + (-38)
            goto L35
        L57:
            r4 = 70
            if (r5 < r4) goto L62
            r4 = 74
            if (r5 > r4) goto L62
            int r5 = r5 + (-11)
            goto L35
        L62:
            r4 = 75
            if (r5 < r4) goto L6b
            if (r5 > r6) goto L6b
            int r5 = r5 + 16
            goto L35
        L6b:
            r4 = 80
            if (r5 < r4) goto L76
            r4 = 84
            if (r5 > r4) goto L76
            int r5 = r5 + 43
            goto L35
        L76:
            r4 = 85
            if (r5 != r4) goto L7b
            goto L2c
        L7b:
            r4 = 86
            if (r5 != r4) goto L82
            r4 = 64
            goto L9e
        L82:
            r4 = 87
            if (r5 != r4) goto L89
            r4 = 96
            goto L9e
        L89:
            r4 = 88
            if (r5 < r4) goto L92
            if (r5 > r7) goto L92
            r4 = 127(0x7f, float:1.78E-43)
            goto L9e
        L92:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        L97:
            if (r5 < r8) goto La2
            if (r5 > r7) goto La2
            int r5 = r5 + (-64)
            goto L35
        L9e:
            r1.append(r4)
            goto Lac
        La2:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        La7:
            yb r9 = p000.C2610yb.m10853a()
            throw r9
        Lac:
            int r3 = r3 + 1
            goto Lb
        Lb0:
            java.lang.String r9 = r1.toString()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1154Z4.m5015k(java.lang.CharSequence):java.lang.String");
    }

    private static char m5016m(int i) throws C2340sh {
        int i2 = 0;
        while (true) {
            int[] iArr = f3384d;
            if (i2 >= iArr.length) {
                throw C2340sh.m9579a();
            }
            if (iArr[i2] == i) {
                return f3383c[i2];
            }
            i2++;
        }
    }

    public static int m5017n(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        int length = iArr.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int iRound = Math.round((iArr[i4] * 9.0f) / i);
            if (iRound <= 0 || iRound > 4) {
                return -1;
            }
            if ((i4 & 1) == 0) {
                for (int i5 = 0; i5 < iRound; i5++) {
                    i3 = (i3 << 1) | 1;
                }
            } else {
                i3 <<= iRound;
            }
        }
        return i3;
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh, C2548x4 {
        int iM1191m = c0233f2.m1191m(m5018l(c0233f2)[1]);
        int iM1193o = c0233f2.m1193o();
        int[] iArr = this.f3387b;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f3386a;
        sb.setLength(0);
        while (true) {
            AbstractC0946Uh.m4264g(c0233f2, iM1191m, iArr);
            int iM5017n = m5017n(iArr);
            if (iM5017n < 0) {
                throw C2340sh.m9579a();
            }
            char cM5016m = m5016m(iM5017n);
            sb.append(cM5016m);
            int i2 = iM1191m;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iM1191m2 = c0233f2.m1191m(i2);
            if (cM5016m == '*') {
                sb.deleteCharAt(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                if (iM1191m2 == iM1193o || !c0233f2.m1189h(iM1191m2)) {
                    throw C2340sh.m9579a();
                }
                if (sb.length() < 2) {
                    throw C2340sh.m9579a();
                }
                m5013i(sb);
                sb.setLength(sb.length() - 2);
                float f = i;
                return new C0720Pk(m5015k(sb), null, new C0857Sk[]{new C0857Sk((r14[1] + r14[0]) / 2.0f, f), new C0857Sk(iM1191m + (i4 / 2.0f), f)}, BarcodeFormat.CODE_93);
            }
            iM1191m = iM1191m2;
        }
    }

    public final int[] m5018l(C0233F2 c0233f2) throws C2340sh {
        int iM1193o = c0233f2.m1193o();
        int iM1191m = c0233f2.m1191m(0);
        Arrays.fill(this.f3387b, 0);
        int[] iArr = this.f3387b;
        int length = iArr.length;
        boolean z = false;
        int i = 0;
        int i2 = iM1191m;
        while (iM1191m < iM1193o) {
            if (c0233f2.m1189h(iM1191m) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i != length - 1) {
                    i++;
                } else {
                    if (m5017n(iArr) == f3385e) {
                        return new int[]{i2, iM1191m};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i3 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i3);
                    iArr[i3] = 0;
                    iArr[i] = 0;
                    i--;
                }
                iArr[i] = 1;
                z = !z;
            }
            iM1191m++;
        }
        throw C2340sh.m9579a();
    }
}
