package p000;

import java.util.EnumMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1090Xn {

    public static final int[] f3286c = {24, 20, 18, 17, 12, 6, 3, 10, 9, 5};

    public final int[] f3287a = new int[4];

    public final StringBuilder f3288b = new StringBuilder();

    public static int m4836c(int i) throws C2340sh {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f3286c[i2]) {
                return i2;
            }
        }
        throw C2340sh.m9579a();
    }

    public static int m4837d(CharSequence charSequence) {
        int length = charSequence.length();
        int iCharAt = 0;
        for (int i = length - 2; i >= 0; i -= 2) {
            iCharAt += charSequence.charAt(i) - '0';
        }
        int iCharAt2 = iCharAt * 3;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            iCharAt2 += charSequence.charAt(i2) - '0';
        }
        return (iCharAt2 * 3) % 10;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static String m4838e(String r5) throws NumberFormatException {
        /*
            r0 = 1
            r1 = 0
            char r2 = r5.charAt(r1)
            r3 = 48
            if (r2 == r3) goto L4d
            r3 = 53
            if (r2 == r3) goto L4a
            r3 = 57
            java.lang.String r4 = ""
            if (r2 == r3) goto L15
            goto L4f
        L15:
            r2 = -1
            int r3 = r5.hashCode()
            switch(r3) {
                case 54118329: goto L35;
                case 54395376: goto L2a;
                case 54395377: goto L1f;
                default: goto L1d;
            }
        L1d:
            r1 = r2
            goto L3e
        L1f:
            java.lang.String r1 = "99991"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L28
            goto L1d
        L28:
            r1 = 2
            goto L3e
        L2a:
            java.lang.String r1 = "99990"
            boolean r1 = r5.equals(r1)
            if (r1 != 0) goto L33
            goto L1d
        L33:
            r1 = r0
            goto L3e
        L35:
            java.lang.String r3 = "90000"
            boolean r3 = r5.equals(r3)
            if (r3 != 0) goto L3e
            goto L1d
        L3e:
            switch(r1) {
                case 0: goto L48;
                case 1: goto L45;
                case 2: goto L42;
                default: goto L41;
            }
        L41:
            goto L4f
        L42:
            java.lang.String r5 = "0.00"
            return r5
        L45:
            java.lang.String r5 = "Used"
            return r5
        L48:
            r5 = 0
            return r5
        L4a:
            java.lang.String r4 = "$"
            goto L4f
        L4d:
            java.lang.String r4 = "£"
        L4f:
            java.lang.String r5 = r5.substring(r0)
            int r5 = java.lang.Integer.parseInt(r5)
            int r0 = r5 / 100
            java.lang.String r0 = java.lang.String.valueOf(r0)
            int r5 = r5 % 100
            r1 = 10
            if (r5 >= r1) goto L6e
            java.lang.String r1 = "0"
            java.lang.String r5 = java.lang.String.valueOf(r5)
            java.lang.String r5 = r1.concat(r5)
            goto L72
        L6e:
            java.lang.String r5 = java.lang.String.valueOf(r5)
        L72:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r4)
            r1.append(r0)
            r0 = 46
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1090Xn.m4838e(java.lang.String):java.lang.String");
    }

    public static Map m4839f(String str) {
        String strM4838e;
        if (str.length() != 5 || (strM4838e = m4838e(str)) == null) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC0811Rk.class);
        enumMap.put((EnumMap) EnumC0811Rk.SUGGESTED_PRICE, (EnumC0811Rk) strM4838e);
        return enumMap;
    }

    public final int m4840a(C0233F2 c0233f2, int[] iArr, StringBuilder sb) throws C2340sh {
        int[] iArr2 = this.f3287a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM1193o = c0233f2.m1193o();
        int iM1192n = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 5 && iM1192n < iM1193o; i2++) {
            int iM5073k = AbstractC1182Zn.m5073k(c0233f2, iArr2, iM1192n, AbstractC1182Zn.f3470h);
            sb.append((char) ((iM5073k % 10) + 48));
            for (int i3 : iArr2) {
                iM1192n += i3;
            }
            if (iM5073k >= 10) {
                i |= 1 << (4 - i2);
            }
            if (i2 != 4) {
                iM1192n = c0233f2.m1192n(c0233f2.m1191m(iM1192n));
            }
        }
        if (sb.length() != 5) {
            throw C2340sh.m9579a();
        }
        if (m4837d(sb.toString()) == m4836c(i)) {
            return iM1192n;
        }
        throw C2340sh.m9579a();
    }

    public C0720Pk m4841b(int i, C0233F2 c0233f2, int[] iArr) throws C2340sh {
        StringBuilder sb = this.f3288b;
        sb.setLength(0);
        int iM4840a = m4840a(c0233f2, iArr, sb);
        String string = sb.toString();
        Map mapM4839f = m4839f(string);
        float f = i;
        C0720Pk c0720Pk = new C0720Pk(string, null, new C0857Sk[]{new C0857Sk((iArr[0] + iArr[1]) / 2.0f, f), new C0857Sk(iM4840a, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapM4839f != null) {
            c0720Pk.m3581g(mapM4839f);
        }
        return c0720Pk;
    }
}
