package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C0713Pd extends AbstractC0946Uh {

    public static final int[] f2136b = {6, 8, 10, 12, 14};

    public static final int[] f2137c = {1, 1, 1, 1};

    public static final int[][] f2138d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};

    public static final int[][] f2139e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};

    public int f2140a = -1;

    public static int m3554i(int[] iArr) throws C2340sh {
        int length = f2139e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float fM4263f = AbstractC0946Uh.m4263f(iArr, f2139e[i2], 0.5f);
            if (fM4263f < f) {
                i = i2;
                f = fM4263f;
            } else if (fM4263f == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw C2340sh.m9579a();
    }

    public static void m3555k(C0233F2 c0233f2, int i, int i2, StringBuilder sb) throws C2340sh {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            AbstractC0946Uh.m4264g(c0233f2, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (m3554i(iArr2) + 48));
            sb.append((char) (m3554i(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    public static int[] m3556m(C0233F2 c0233f2, int i, int[] iArr) throws C2340sh {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int iM1193o = c0233f2.m1193o();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < iM1193o) {
            if (c0233f2.m1189h(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (AbstractC0946Uh.m4263f(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw C2340sh.m9579a();
    }

    public static int m3557n(C0233F2 c0233f2) throws C2340sh {
        int iM1193o = c0233f2.m1193o();
        int iM1191m = c0233f2.m1191m(0);
        if (iM1191m != iM1193o) {
            return iM1191m;
        }
        throw C2340sh.m9579a();
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh, C2610yb {
        boolean z;
        int[] iArrM3560l = m3560l(c0233f2);
        int[] iArrM3559j = m3559j(c0233f2);
        StringBuilder sb = new StringBuilder(20);
        m3555k(c0233f2, iArrM3560l[1], iArrM3559j[0], sb);
        String string = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = f2136b;
        }
        int length = string.length();
        int length2 = iArr.length;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            if (i2 >= length2) {
                z = false;
                break;
            }
            int i4 = iArr[i2];
            if (length == i4) {
                z = true;
                break;
            }
            if (i4 > i3) {
                i3 = i4;
            }
            i2++;
        }
        if (!z && length > i3) {
            z = true;
        }
        if (!z) {
            throw C2610yb.m10853a();
        }
        float f = i;
        return new C0720Pk(string, null, new C0857Sk[]{new C0857Sk(iArrM3560l[1], f), new C0857Sk(iArrM3559j[0], f)}, BarcodeFormat.ITF);
    }

    public final int[] m3559j(C0233F2 c0233f2) {
        int[] iArrM3556m;
        c0233f2.m1196t();
        try {
            int iM3557n = m3557n(c0233f2);
            try {
                iArrM3556m = m3556m(c0233f2, iM3557n, f2138d[0]);
            } catch (C2340sh unused) {
                iArrM3556m = m3556m(c0233f2, iM3557n, f2138d[1]);
            }
            m3561o(c0233f2, iArrM3556m[0]);
            int i = iArrM3556m[0];
            iArrM3556m[0] = c0233f2.m1193o() - iArrM3556m[1];
            iArrM3556m[1] = c0233f2.m1193o() - i;
            return iArrM3556m;
        } finally {
            c0233f2.m1196t();
        }
    }

    public final int[] m3560l(C0233F2 c0233f2) throws C2340sh {
        int[] iArrM3556m = m3556m(c0233f2, m3557n(c0233f2), f2137c);
        int i = iArrM3556m[1];
        int i2 = iArrM3556m[0];
        this.f2140a = (i - i2) / 4;
        m3561o(c0233f2, i2);
        return iArrM3556m;
    }

    public final void m3561o(C0233F2 c0233f2, int i) throws C2340sh {
        int iMin = Math.min(this.f2140a * 10, i);
        for (int i2 = i - 1; iMin > 0 && i2 >= 0 && !c0233f2.m1189h(i2); i2--) {
            iMin--;
        }
        if (iMin != 0) {
            throw C2340sh.m9579a();
        }
    }
}
