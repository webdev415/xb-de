package p000;

/* loaded from: classes.dex */
public final class C1331bo extends AbstractC1182Zn {

    public static final int[] f3885j = {1, 1, 1, 1, 1, 1};

    public static final int[][] f3886k = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    public final int[] f3887i = new int[4];

    public static String m5681t(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c = cArr[5];
        switch (c) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append("00000");
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append("00000");
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c);
                break;
        }
        if (str.length() >= 8) {
            sb.append(str.charAt(7));
        }
        return sb.toString();
    }

    public static void m5682u(StringBuilder sb, int i) throws C2340sh {
        for (int i2 = 0; i2 <= 1; i2++) {
            for (int i3 = 0; i3 < 10; i3++) {
                if (i == f3886k[i2][i3]) {
                    sb.insert(0, (char) (i2 + 48));
                    sb.append((char) (i3 + 48));
                    return;
                }
            }
        }
        throw C2340sh.m9579a();
    }

    @Override
    public boolean mo5078i(String str) {
        return super.mo5078i(m5681t(str));
    }

    @Override
    public int[] mo5079l(C0233F2 c0233f2, int i) {
        return AbstractC1182Zn.m5074o(c0233f2, i, true, f3885j);
    }

    @Override
    public int mo1359m(C0233F2 c0233f2, int[] iArr, StringBuilder sb) throws C2340sh {
        int[] iArr2 = this.f3887i;
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
        m5682u(sb, i2);
        return i;
    }

    @Override
    public BarcodeFormat mo1360r() {
        return BarcodeFormat.UPC_E;
    }
}
