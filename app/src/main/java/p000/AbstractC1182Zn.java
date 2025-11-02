package p000;

import java.util.Arrays;
import java.util.Map;

public abstract class AbstractC1182Zn extends AbstractC0946Uh {

    public static final int[] f3466d = {1, 1, 1};

    public static final int[] f3467e = {1, 1, 1, 1, 1};

    public static final int[] f3468f = {1, 1, 1, 1, 1, 1};

    public static final int[][] f3469g;

    public static final int[][] f3470h;

    public final StringBuilder f3471a = new StringBuilder(20);

    public final C1136Yn f3472b = new C1136Yn();

    public final C0470K9 f3473c = new C0470K9();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        f3469g = iArr;
        int[][] iArr2 = new int[20][];
        f3470h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = f3469g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            f3470h[i] = iArr4;
        }
    }

    public static boolean m5072j(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return m5077s(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public static int m5073k(C0233F2 c0233f2, int[] iArr, int i, int[][] iArr2) throws C2340sh {
        AbstractC0946Uh.m4264g(c0233f2, i, iArr);
        int length = iArr2.length;
        float f = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float fM4263f = AbstractC0946Uh.m4263f(iArr, iArr2[i3], 0.7f);
            if (fM4263f < f) {
                i2 = i3;
                f = fM4263f;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw C2340sh.m9579a();
    }

    public static int[] m5074o(C0233F2 c0233f2, int i, boolean z, int[] iArr) {
        return m5075p(c0233f2, i, z, iArr, new int[iArr.length]);
    }

    public static int[] m5075p(C0233F2 c0233f2, int i, boolean z, int[] iArr, int[] iArr2) throws C2340sh {
        int iM1193o = c0233f2.m1193o();
        int iM1192n = z ? c0233f2.m1192n(i) : c0233f2.m1191m(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = iM1192n;
        while (iM1192n < iM1193o) {
            if (c0233f2.m1189h(iM1192n) != z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (AbstractC0946Uh.m4263f(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, iM1192n};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            iM1192n++;
        }
        throw C2340sh.m9579a();
    }

    public static int[] m5076q(C0233F2 c0233f2) throws C2340sh {
        int[] iArr = new int[f3466d.length];
        int[] iArrM5075p = null;
        boolean zM1195r = false;
        int i = 0;
        while (!zM1195r) {
            int[] iArr2 = f3466d;
            Arrays.fill(iArr, 0, iArr2.length, 0);
            iArrM5075p = m5075p(c0233f2, i, false, iArr2, iArr);
            int i2 = iArrM5075p[0];
            int i3 = iArrM5075p[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                zM1195r = c0233f2.m1195r(i4, i2, false);
            }
            i = i3;
        }
        return iArrM5075p;
    }

    public static int m5077s(CharSequence charSequence) throws C2610yb {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int iCharAt = charSequence.charAt(i2) - '0';
            if (iCharAt < 0 || iCharAt > 9) {
                throw C2610yb.m10853a();
            }
            i += iCharAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int iCharAt2 = charSequence.charAt(i4) - '0';
            if (iCharAt2 < 0 || iCharAt2 > 9) {
                throw C2610yb.m10853a();
            }
            i3 += iCharAt2;
        }
        return (1000 - i3) % 10;
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) {
        return mo4288n(i, c0233f2, m5076q(c0233f2), map);
    }

    public boolean mo5078i(String str) {
        return m5072j(str);
    }

    public int[] mo5079l(C0233F2 c0233f2, int i) {
        return m5074o(c0233f2, i, false, f3466d);
    }

    public abstract int mo1359m(C0233F2 c0233f2, int[] iArr, StringBuilder sb);

    public C0720Pk mo4288n(int i, C0233F2 c0233f2, int[] iArr, Map map) throws C2340sh, C2610yb, C2548x4 {
        int length;
        String strM2316c;
        InterfaceC0903Tk interfaceC0903Tk = map == null ? null : (InterfaceC0903Tk) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        if (interfaceC0903Tk != null) {
            interfaceC0903Tk.mo3293a(new C0857Sk((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.f3471a;
        sb.setLength(0);
        int iMo1359m = mo1359m(c0233f2, iArr, sb);
        if (interfaceC0903Tk != null) {
            interfaceC0903Tk.mo3293a(new C0857Sk(iMo1359m, i));
        }
        int[] iArrMo5079l = mo5079l(c0233f2, iMo1359m);
        if (interfaceC0903Tk != null) {
            interfaceC0903Tk.mo3293a(new C0857Sk((iArrMo5079l[0] + iArrMo5079l[1]) / 2.0f, i));
        }
        int i2 = iArrMo5079l[1];
        int i3 = (i2 - iArrMo5079l[0]) + i2;
        if (i3 >= c0233f2.m1193o() || !c0233f2.m1195r(i2, i3, false)) {
            throw C2340sh.m9579a();
        }
        String string = sb.toString();
        if (string.length() < 8) {
            throw C2610yb.m10853a();
        }
        if (!mo5078i(string)) {
            throw C2548x4.m10627a();
        }
        BarcodeFormat barcodeFormatMo1360R = mo1360r();
        float f = i;
        C0720Pk c0720Pk = new C0720Pk(string, null, new C0857Sk[]{new C0857Sk((iArr[1] + iArr[0]) / 2.0f, f), new C0857Sk((iArrMo5079l[1] + iArrMo5079l[0]) / 2.0f, f)}, barcodeFormatMo1360R);
        try {
            C0720Pk c0720PkM4990a = this.f3472b.m4990a(i, c0233f2, iArrMo5079l[1]);
            c0720Pk.m3582h(EnumC0811Rk.UPC_EAN_EXTENSION, c0720PkM4990a.m3580f());
            c0720Pk.m3581g(c0720PkM4990a.m3578d());
            c0720Pk.m3575a(c0720PkM4990a.m3579e());
            length = c0720PkM4990a.m3580f().length();
        } catch (AbstractC1327bk unused) {
            length = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(DecodeHintType.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i4 : iArr2) {
                if (length != i4) {
                }
            }
            throw C2340sh.m9579a();
        }
        if ((barcodeFormatMo1360R == BarcodeFormat.EAN_13 || barcodeFormatMo1360R == BarcodeFormat.UPC_A) && (strM2316c = this.f3473c.m2316c(string)) != null) {
            c0720Pk.m3582h(EnumC0811Rk.POSSIBLE_COUNTRY, strM2316c);
        }
        return c0720Pk;
    }

    public abstract BarcodeFormat mo1360r();
}
