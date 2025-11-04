package p000;

import java.util.EnumMap;
import java.util.Map;

public final class C1044Wn {

    public final int[] f3116a = new int[4];

    public final StringBuilder f3117b = new StringBuilder();

    public static Map m4539c(String str) {
        if (str.length() != 2) {
            return null;
        }
        EnumMap enumMap = new EnumMap(EnumC0811Rk.class);
        enumMap.put((EnumMap) EnumC0811Rk.ISSUE_NUMBER, (EnumC0811Rk) Integer.valueOf(str));
        return enumMap;
    }

    public final int m4540a(C0233F2 c0233f2, int[] iArr, StringBuilder sb) throws C2340sh {
        int[] iArr2 = this.f3116a;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM1193o = c0233f2.m1193o();
        int iM1192n = iArr[1];
        int i = 0;
        for (int i2 = 0; i2 < 2 && iM1192n < iM1193o; i2++) {
            int iM5073k = AbstractC1182Zn.m5073k(c0233f2, iArr2, iM1192n, AbstractC1182Zn.f3470h);
            sb.append((char) ((iM5073k % 10) + 48));
            for (int i3 : iArr2) {
                iM1192n += i3;
            }
            if (iM5073k >= 10) {
                i |= 1 << (1 - i2);
            }
            if (i2 != 1) {
                iM1192n = c0233f2.m1192n(c0233f2.m1191m(iM1192n));
            }
        }
        if (sb.length() != 2) {
            throw C2340sh.m9579a();
        }
        if (Integer.parseInt(sb.toString()) % 4 == i) {
            return iM1192n;
        }
        throw C2340sh.m9579a();
    }

    public C0720Pk m4541b(int i, C0233F2 c0233f2, int[] iArr) throws C2340sh {
        StringBuilder sb = this.f3117b;
        sb.setLength(0);
        int iM4540a = m4540a(c0233f2, iArr, sb);
        String string = sb.toString();
        Map mapM4539c = m4539c(string);
        float f = i;
        C0720Pk c0720Pk = new C0720Pk(string, null, new C0857Sk[]{new C0857Sk((iArr[0] + iArr[1]) / 2.0f, f), new C0857Sk(iM4540a, f)}, BarcodeFormat.UPC_EAN_EXTENSION);
        if (mapM4539c != null) {
            c0720Pk.m3581g(mapM4539c);
        }
        return c0720Pk;
    }
}
