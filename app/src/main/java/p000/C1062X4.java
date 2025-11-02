package p000;

import java.util.Arrays;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1062X4 extends AbstractC0946Uh {

    public static final int[] f3168e = {52, 289, 97, 352, 49, 304, 112, 37, 292, 100, 265, 73, 328, 25, 280, 88, 13, 268, 76, 28, 259, 67, 322, 19, 274, 82, 7, 262, 70, 22, 385, 193, 448, 145, 400, 208, 133, 388, 196, 168, 162, 138, 42};

    public final boolean f3169a;

    public final boolean f3170b;

    public final StringBuilder f3171c;

    public final int[] f3172d;

    public C1062X4() {
        this(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static String m4625i(CharSequence r12) throws C2610yb {
        /*
            int r0 = r12.length()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            r2 = 0
            r3 = r2
        Lb:
            if (r3 >= r0) goto Lba
            char r4 = r12.charAt(r3)
            r5 = 47
            r6 = 37
            r7 = 36
            r8 = 43
            if (r4 == r8) goto L27
            if (r4 == r7) goto L27
            if (r4 == r6) goto L27
            if (r4 != r5) goto L22
            goto L27
        L22:
            r1.append(r4)
            goto Lb1
        L27:
            int r3 = r3 + 1
            char r9 = r12.charAt(r3)
            r10 = 90
            r11 = 65
            if (r4 == r7) goto Laa
            r7 = 79
            if (r4 == r6) goto L5b
            if (r4 == r8) goto L4f
            if (r4 == r5) goto L3d
        L3b:
            r4 = r2
            goto L22
        L3d:
            if (r9 < r11) goto L45
            if (r9 > r7) goto L45
            int r9 = r9 + (-32)
        L43:
            char r4 = (char) r9
            goto L22
        L45:
            if (r9 != r10) goto L4a
            r4 = 58
            goto L22
        L4a:
            yb r12 = p000.C2610yb.m10853a()
            throw r12
        L4f:
            if (r9 < r11) goto L56
            if (r9 > r10) goto L56
            int r9 = r9 + 32
            goto L43
        L56:
            yb r12 = p000.C2610yb.m10853a()
            throw r12
        L5b:
            if (r9 < r11) goto L64
            r4 = 69
            if (r9 > r4) goto L64
            int r9 = r9 + (-38)
            goto L43
        L64:
            r4 = 70
            if (r9 < r4) goto L6f
            r4 = 74
            if (r9 > r4) goto L6f
            int r9 = r9 + (-11)
            goto L43
        L6f:
            r4 = 75
            if (r9 < r4) goto L78
            if (r9 > r7) goto L78
            int r9 = r9 + 16
            goto L43
        L78:
            r4 = 80
            if (r9 < r4) goto L83
            r4 = 84
            if (r9 > r4) goto L83
            int r9 = r9 + 43
            goto L43
        L83:
            r4 = 85
            if (r9 != r4) goto L88
            goto L3b
        L88:
            r4 = 86
            if (r9 != r4) goto L8f
            r4 = 64
            goto L22
        L8f:
            r4 = 87
            if (r9 != r4) goto L96
            r4 = 96
            goto L22
        L96:
            r4 = 88
            if (r9 == r4) goto La6
            r4 = 89
            if (r9 == r4) goto La6
            if (r9 != r10) goto La1
            goto La6
        La1:
            yb r12 = p000.C2610yb.m10853a()
            throw r12
        La6:
            r4 = 127(0x7f, float:1.78E-43)
            goto L22
        Laa:
            if (r9 < r11) goto Lb5
            if (r9 > r10) goto Lb5
            int r9 = r9 + (-64)
            goto L43
        Lb1:
            int r3 = r3 + 1
            goto Lb
        Lb5:
            yb r12 = p000.C2610yb.m10853a()
            throw r12
        Lba:
            java.lang.String r12 = r1.toString()
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1062X4.m4625i(java.lang.CharSequence):java.lang.String");
    }

    public static int[] m4626j(C0233F2 c0233f2, int[] iArr) throws C2340sh {
        int iM1193o = c0233f2.m1193o();
        int iM1191m = c0233f2.m1191m(0);
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
                    if (m4628l(iArr) == 148 && c0233f2.m1195r(Math.max(0, i2 - ((iM1191m - i2) / 2)), i2, false)) {
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

    public static char m4627k(int i) throws C2340sh {
        int i2 = 0;
        while (true) {
            int[] iArr = f3168e;
            if (i2 >= iArr.length) {
                if (i == 148) {
                    return '*';
                }
                throw C2340sh.m9579a();
            }
            if (iArr[i2] == i) {
                return "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(i2);
            }
            i2++;
        }
    }

    public static int m4628l(int[] iArr) {
        int length = iArr.length;
        int i = 0;
        while (true) {
            int i2 = Integer.MAX_VALUE;
            for (int i3 : iArr) {
                if (i3 < i2 && i3 > i) {
                    i2 = i3;
                }
            }
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < length; i7++) {
                int i8 = iArr[i7];
                if (i8 > i2) {
                    i5 |= 1 << ((length - 1) - i7);
                    i4++;
                    i6 += i8;
                }
            }
            if (i4 == 3) {
                for (int i9 = 0; i9 < length && i4 > 0; i9++) {
                    int i10 = iArr[i9];
                    if (i10 > i2) {
                        i4--;
                        if ((i10 << 1) >= i6) {
                            return -1;
                        }
                    }
                }
                return i5;
            }
            if (i4 <= 3) {
                return -1;
            }
            i = i2;
        }
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh, C2548x4 {
        int[] iArr = this.f3172d;
        Arrays.fill(iArr, 0);
        StringBuilder sb = this.f3171c;
        sb.setLength(0);
        int iM1191m = c0233f2.m1191m(m4626j(c0233f2, iArr)[1]);
        int iM1193o = c0233f2.m1193o();
        while (true) {
            AbstractC0946Uh.m4264g(c0233f2, iM1191m, iArr);
            int iM4628l = m4628l(iArr);
            if (iM4628l < 0) {
                throw C2340sh.m9579a();
            }
            char cM4627k = m4627k(iM4628l);
            sb.append(cM4627k);
            int i2 = iM1191m;
            for (int i3 : iArr) {
                i2 += i3;
            }
            int iM1191m2 = c0233f2.m1191m(i2);
            if (cM4627k == '*') {
                sb.setLength(sb.length() - 1);
                int i4 = 0;
                for (int i5 : iArr) {
                    i4 += i5;
                }
                int i6 = (iM1191m2 - iM1191m) - i4;
                if (iM1191m2 != iM1193o && (i6 << 1) < i4) {
                    throw C2340sh.m9579a();
                }
                if (this.f3169a) {
                    int length = sb.length() - 1;
                    int iIndexOf = 0;
                    for (int i7 = 0; i7 < length; i7++) {
                        iIndexOf += "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".indexOf(this.f3171c.charAt(i7));
                    }
                    if (sb.charAt(length) != "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-. $/+%".charAt(iIndexOf % 43)) {
                        throw C2548x4.m10627a();
                    }
                    sb.setLength(length);
                }
                if (sb.length() == 0) {
                    throw C2340sh.m9579a();
                }
                float f = i;
                return new C0720Pk(this.f3170b ? m4625i(sb) : sb.toString(), null, new C0857Sk[]{new C0857Sk((r2[1] + r2[0]) / 2.0f, f), new C0857Sk(iM1191m + (i4 / 2.0f), f)}, BarcodeFormat.CODE_39);
            }
            iM1191m = iM1191m2;
        }
    }

    public C1062X4(boolean z) {
        this(z, false);
    }

    public C1062X4(boolean z, boolean z2) {
        this.f3169a = z;
        this.f3170b = z2;
        this.f3171c = new StringBuilder(20);
        this.f3172d = new int[9];
    }
}
