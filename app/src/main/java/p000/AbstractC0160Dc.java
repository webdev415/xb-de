package p000;

public abstract class AbstractC0160Dc extends AbstractC0095C2 {

    public static final byte[] f392d = new byte[0];

    public byte[] f393b;

    public final int[] f394c;

    public AbstractC0160Dc(AbstractC1784gg abstractC1784gg) {
        super(abstractC1784gg);
        this.f393b = f392d;
        this.f394c = new int[32];
    }

    public static int m695g(int[] iArr) throws C2340sh {
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4++) {
            int i5 = iArr[i4];
            if (i5 > i) {
                i3 = i4;
                i = i5;
            }
            if (i5 > i2) {
                i2 = i5;
            }
        }
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < length; i8++) {
            int i9 = i8 - i3;
            int i10 = iArr[i8] * i9 * i9;
            if (i10 > i7) {
                i6 = i8;
                i7 = i10;
            }
        }
        if (i3 <= i6) {
            int i11 = i3;
            i3 = i6;
            i6 = i11;
        }
        if (i3 - i6 <= length / 16) {
            throw C2340sh.m9579a();
        }
        int i12 = i3 - 1;
        int i13 = -1;
        int i14 = i12;
        while (i12 > i6) {
            int i15 = i12 - i6;
            int i16 = i15 * i15 * (i3 - i12) * (i2 - iArr[i12]);
            if (i16 > i13) {
                i14 = i12;
                i13 = i16;
            }
            i12--;
        }
        return i14 << 3;
    }

    @Override
    public C0325H2 mo366b() {
        AbstractC1784gg abstractC1784ggM369e = m369e();
        int iM7737d = abstractC1784ggM369e.m7737d();
        int iM7736a = abstractC1784ggM369e.m7736a();
        C0325H2 c0325h2 = new C0325H2(iM7737d, iM7736a);
        m696h(iM7737d);
        int[] iArr = this.f394c;
        for (int i = 1; i < 5; i++) {
            byte[] bArrMo1970c = abstractC1784ggM369e.mo1970c((iM7736a * i) / 5, this.f393b);
            int i2 = (iM7737d << 2) / 5;
            for (int i3 = iM7737d / 5; i3 < i2; i3++) {
                int i4 = (bArrMo1970c[i3] & 255) >> 3;
                iArr[i4] = iArr[i4] + 1;
            }
        }
        int iM695g = m695g(iArr);
        byte[] bArrMo1969b = abstractC1784ggM369e.mo1969b();
        for (int i5 = 0; i5 < iM7736a; i5++) {
            int i6 = i5 * iM7737d;
            for (int i7 = 0; i7 < iM7737d; i7++) {
                if ((bArrMo1969b[i6 + i7] & 255) < iM695g) {
                    c0325h2.m1501r(i7, i5);
                }
            }
        }
        return c0325h2;
    }

    @Override
    public C0233F2 mo367c(int i, C0233F2 c0233f2) throws C2340sh {
        AbstractC1784gg abstractC1784ggM369e = m369e();
        int iM7737d = abstractC1784ggM369e.m7737d();
        if (c0233f2 == null || c0233f2.m1193o() < iM7737d) {
            c0233f2 = new C0233F2(iM7737d);
        } else {
            c0233f2.m1186d();
        }
        m696h(iM7737d);
        byte[] bArrMo1970c = abstractC1784ggM369e.mo1970c(i, this.f393b);
        int[] iArr = this.f394c;
        for (int i2 = 0; i2 < iM7737d; i2++) {
            int i3 = (bArrMo1970c[i2] & 255) >> 3;
            iArr[i3] = iArr[i3] + 1;
        }
        int iM695g = m695g(iArr);
        if (iM7737d < 3) {
            for (int i4 = 0; i4 < iM7737d; i4++) {
                if ((bArrMo1970c[i4] & 255) < iM695g) {
                    c0233f2.m1197u(i4);
                }
            }
        } else {
            int i5 = 1;
            int i6 = bArrMo1970c[0] & 255;
            int i7 = bArrMo1970c[1] & 255;
            while (i5 < iM7737d - 1) {
                int i8 = i5 + 1;
                int i9 = bArrMo1970c[i8] & 255;
                if ((((i7 << 2) - i6) - i9) / 2 < iM695g) {
                    c0233f2.m1197u(i5);
                }
                i6 = i7;
                i5 = i8;
                i7 = i9;
            }
        }
        return c0233f2;
    }

    public final void m696h(int i) {
        if (this.f393b.length < i) {
            this.f393b = new byte[i];
        }
        for (int i2 = 0; i2 < 32; i2++) {
            this.f394c[i2] = 0;
        }
    }
}
