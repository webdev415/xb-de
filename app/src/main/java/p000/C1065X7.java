package p000;

public final class C1065X7 extends AbstractC0574Mc {
    @Override
    public C0325H2 mo2858c(C0325H2 c0325h2, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        return mo2859d(c0325h2, i, i2, C0626Ni.m3323b(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override
    public C0325H2 mo2859d(C0325H2 c0325h2, int i, int i2, C0626Ni c0626Ni) throws C2340sh {
        if (i <= 0 || i2 <= 0) {
            throw C2340sh.m9579a();
        }
        C0325H2 c0325h22 = new C0325H2(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = i4 + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = (i5 / 2) + 0.5f;
                fArr[i5 + 1] = f;
            }
            c0626Ni.m3328f(fArr);
            AbstractC0574Mc.m2856a(c0325h2, fArr);
            for (int i6 = 0; i6 < i3; i6 += 2) {
                try {
                    if (c0325h2.m1493e((int) fArr[i6], (int) fArr[i6 + 1])) {
                        c0325h22.m1501r(i6 / 2, i4);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw C2340sh.m9579a();
                }
            }
        }
        return c0325h22;
    }
}
