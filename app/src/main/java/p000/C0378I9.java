package p000;

public final class C0378I9 extends AbstractC1182Zn {

    public final int[] f1136i = new int[4];

    @Override
    public int mo1359m(C0233F2 c0233f2, int[] iArr, StringBuilder sb) {
        int[] iArr2 = this.f1136i;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iM1193o = c0233f2.m1193o();
        int i = iArr[1];
        for (int i2 = 0; i2 < 4 && i < iM1193o; i2++) {
            sb.append((char) (AbstractC1182Zn.m5073k(c0233f2, iArr2, i, AbstractC1182Zn.f3469g) + 48));
            for (int i3 : iArr2) {
                i += i3;
            }
        }
        int i4 = AbstractC1182Zn.m5074o(c0233f2, i, true, AbstractC1182Zn.f3467e)[1];
        for (int i5 = 0; i5 < 4 && i4 < iM1193o; i5++) {
            sb.append((char) (AbstractC1182Zn.m5073k(c0233f2, iArr2, i4, AbstractC1182Zn.f3469g) + 48));
            for (int i6 : iArr2) {
                i4 += i6;
            }
        }
        return i4;
    }

    @Override
    public BarcodeFormat mo1360r() {
        return BarcodeFormat.EAN_8;
    }
}
