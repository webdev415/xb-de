package p000;

/* loaded from: classes.dex */
public final class C0286G9 extends AbstractC1182Zn {

    public static final int[] f861j = {0, 11, 13, 14, 19, 25, 28, 21, 22, 26};

    public final int[] f862i = new int[4];

    public static void m1358t(StringBuilder sb, int i) throws C2340sh {
        for (int i2 = 0; i2 < 10; i2++) {
            if (i == f861j[i2]) {
                sb.insert(0, (char) (i2 + 48));
                return;
            }
        }
        throw C2340sh.m9579a();
    }

    @Override
    public int mo1359m(C0233F2 c0233f2, int[] iArr, StringBuilder sb) throws C2340sh {
        int[] iArr2 = this.f862i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM1193o = c0233f2.m1193o();
        int i = iArr[1];
        int i2 = 0;
        for (int i3 = 0; i3 < 6 && i < iM1193o; i3++) {
            int iM5073k = AbstractC1182Zn.m5073k(c0233f2, iArr2, i, AbstractC1182Zn.f3470h);
            sb.append((char) ((iM5073k % 10) + 48));
            for (int i4 : iArr2) {
                i += i4;
            }
            if (iM5073k >= 10) {
                i2 |= 1 << (5 - i3);
            }
        }
        m1358t(sb, i2);
        int i5 = AbstractC1182Zn.m5074o(c0233f2, i, true, AbstractC1182Zn.f3467e)[1];
        for (int i6 = 0; i6 < 6 && i5 < iM1193o; i6++) {
            sb.append((char) (AbstractC1182Zn.m5073k(c0233f2, iArr2, i5, AbstractC1182Zn.f3469g) + 48));
            for (int i7 : iArr2) {
                i5 += i7;
            }
        }
        return i5;
    }

    @Override
    public BarcodeFormat mo1360r() {
        return BarcodeFormat.EAN_13;
    }
}
