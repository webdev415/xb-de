package p000;

public abstract class AbstractC1021W9 {

    public static final int[] f3037a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    public static int[] m4454a(C0233F2 c0233f2, int i, int i2) {
        int[] iArr = new int[i2];
        int iM1193o = c0233f2.m1193o() / i;
        for (int i3 = 0; i3 < iM1193o; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= c0233f2.m1189h((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    public static void m4455b(C0325H2 c0325h2, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    c0325h2.m1501r(i5, i4);
                    c0325h2.m1501r(i5, i6);
                    c0325h2.m1501r(i4, i5);
                    c0325h2.m1501r(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        c0325h2.m1501r(i7, i7);
        int i8 = i7 + 1;
        c0325h2.m1501r(i8, i7);
        c0325h2.m1501r(i7, i8);
        int i9 = i + i2;
        c0325h2.m1501r(i9, i7);
        c0325h2.m1501r(i9, i8);
        c0325h2.m1501r(i9, i9 - 1);
    }

    public static void m4456c(C0325H2 c0325h2, boolean z, int i, C0233F2 c0233f2) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (c0233f2.m1189h(i3)) {
                    c0325h2.m1501r(i4, i2 - 5);
                }
                if (c0233f2.m1189h(i3 + 7)) {
                    c0325h2.m1501r(i2 + 5, i4);
                }
                if (c0233f2.m1189h(20 - i3)) {
                    c0325h2.m1501r(i4, i2 + 5);
                }
                if (c0233f2.m1189h(27 - i3)) {
                    c0325h2.m1501r(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (c0233f2.m1189h(i3)) {
                c0325h2.m1501r(i5, i2 - 7);
            }
            if (c0233f2.m1189h(i3 + 10)) {
                c0325h2.m1501r(i2 + 7, i5);
            }
            if (c0233f2.m1189h(29 - i3)) {
                c0325h2.m1501r(i5, i2 + 7);
            }
            if (c0233f2.m1189h(39 - i3)) {
                c0325h2.m1501r(i2 - 7, i5);
            }
            i3++;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static C1105Y1 m4457d(byte[] bArr, int i, int i2) {
        C0233F2 c0233f2M4461h;
        int i3;
        boolean z;
        int iAbs;
        int iM4462i;
        int i4;
        C0233F2 c0233f2M8464a = new C2059md(bArr).m8464a();
        int iM1193o = ((c0233f2M8464a.m1193o() * i) / 100) + 11;
        int iM1193o2 = c0233f2M8464a.m1193o() + iM1193o;
        int i5 = 1;
        if (i2 == 0) {
            C0233F2 c0233f2M4461h2 = null;
            int i6 = 0;
            int i7 = 0;
            while (i6 <= 32) {
                boolean z2 = i6 <= 3 ? i5 : 0;
                int i8 = z2 != 0 ? i6 + 1 : i6;
                int iM4462i2 = m4462i(i8, z2);
                if (iM1193o2 <= iM4462i2) {
                    if (c0233f2M4461h2 == null || i7 != f3037a[i8]) {
                        int i9 = f3037a[i8];
                        i7 = i9;
                        c0233f2M4461h2 = m4461h(c0233f2M8464a, i9);
                    }
                    int i10 = iM4462i2 - (iM4462i2 % i7);
                    if ((z2 == 0 || c0233f2M4461h2.m1193o() <= (i7 << 6)) && c0233f2M4461h2.m1193o() + iM1193o <= i10) {
                        c0233f2M4461h = c0233f2M4461h2;
                        i3 = i7;
                        z = z2;
                        iAbs = i8;
                        iM4462i = iM4462i2;
                    }
                }
                i6++;
                i5 = i5;
            }
            throw new IllegalArgumentException("Data too large for an Aztec code");
        }
        z = i2 < 0;
        iAbs = Math.abs(i2);
        if (iAbs > (z ? 4 : 32)) {
            throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
        }
        iM4462i = m4462i(iAbs, z);
        i3 = f3037a[iAbs];
        int i11 = iM4462i - (iM4462i % i3);
        c0233f2M4461h = m4461h(c0233f2M8464a, i3);
        if (c0233f2M4461h.m1193o() + iM1193o > i11) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        if (z && c0233f2M4461h.m1193o() > (i3 << 6)) {
            throw new IllegalArgumentException("Data to large for user specified layer");
        }
        C0233F2 c0233f2M4458e = m4458e(c0233f2M4461h, iM4462i, i3);
        int iM1193o3 = c0233f2M4461h.m1193o() / i3;
        C0233F2 c0233f2M4459f = m4459f(z, iAbs, iM1193o3);
        int i12 = (z ? 11 : 14) + (iAbs << 2);
        int[] iArr = new int[i12];
        int i13 = 2;
        if (z) {
            for (int i14 = 0; i14 < i12; i14++) {
                iArr[i14] = i14;
            }
            i4 = i12;
        } else {
            int i15 = i12 / 2;
            i4 = i12 + 1 + (((i15 - 1) / 15) * 2);
            int i16 = i4 / 2;
            for (int i17 = 0; i17 < i15; i17++) {
                iArr[(i15 - i17) - i5] = (i16 - r14) - 1;
                iArr[i15 + i17] = (i17 / 15) + i17 + i16 + i5;
            }
        }
        C0325H2 c0325h2 = new C0325H2(i4);
        int i18 = 0;
        int i19 = 0;
        while (i18 < iAbs) {
            int i20 = ((iAbs - i18) << i13) + (z ? 9 : 12);
            int i21 = 0;
            while (i21 < i20) {
                int i22 = i21 << 1;
                int i23 = 0;
                while (i23 < i13) {
                    if (c0233f2M4458e.m1189h(i19 + i22 + i23)) {
                        int i24 = i18 << 1;
                        c0325h2.m1501r(iArr[i24 + i23], iArr[i24 + i21]);
                    }
                    if (c0233f2M4458e.m1189h((i20 << 1) + i19 + i22 + i23)) {
                        int i25 = i18 << 1;
                        c0325h2.m1501r(iArr[i25 + i21], iArr[((i12 - 1) - i25) - i23]);
                    }
                    if (c0233f2M4458e.m1189h((i20 << 2) + i19 + i22 + i23)) {
                        int i26 = (i12 - 1) - (i18 << 1);
                        c0325h2.m1501r(iArr[i26 - i23], iArr[i26 - i21]);
                    }
                    if (c0233f2M4458e.m1189h((i20 * 6) + i19 + i22 + i23)) {
                        int i27 = i18 << 1;
                        c0325h2.m1501r(iArr[((i12 - 1) - i27) - i21], iArr[i27 + i23]);
                    }
                    i23++;
                    i13 = 2;
                }
                i21++;
                i13 = 2;
            }
            i19 += i20 << 3;
            i18++;
            i13 = 2;
        }
        m4456c(c0325h2, z, i4, c0233f2M4459f);
        int i28 = i4 / 2;
        if (z) {
            m4455b(c0325h2, i28, 5);
        } else {
            m4455b(c0325h2, i28, 7);
            int i29 = 0;
            int i30 = 0;
            while (i30 < (i12 / 2) - 1) {
                for (int i31 = i28 & 1; i31 < i4; i31 += 2) {
                    int i32 = i28 - i29;
                    c0325h2.m1501r(i32, i31);
                    int i33 = i28 + i29;
                    c0325h2.m1501r(i33, i31);
                    c0325h2.m1501r(i31, i32);
                    c0325h2.m1501r(i31, i33);
                }
                i30 += 15;
                i29 += 16;
            }
        }
        C1105Y1 c1105y1 = new C1105Y1();
        c1105y1.m4867c(z);
        c1105y1.m4870f(i4);
        c1105y1.m4868d(iAbs);
        c1105y1.m4866b(iM1193o3);
        c1105y1.m4869e(c0325h2);
        return c1105y1;
    }

    public static C0233F2 m4458e(C0233F2 c0233f2, int i, int i2) {
        int iM1193o = c0233f2.m1193o() / i2;
        C2066mk c2066mk = new C2066mk(m4460g(i2));
        int i3 = i / i2;
        int[] iArrM4454a = m4454a(c0233f2, i2, i3);
        c2066mk.m8639b(iArrM4454a, i3 - iM1193o);
        C0233F2 c0233f22 = new C0233F2();
        c0233f22.m1185c(0, i % i2);
        for (int i4 : iArrM4454a) {
            c0233f22.m1185c(i4, i2);
        }
        return c0233f22;
    }

    public static C0233F2 m4459f(boolean z, int i, int i2) {
        int i3;
        C0233F2 c0233f2 = new C0233F2();
        int i4 = i - 1;
        if (z) {
            c0233f2.m1185c(i4, 2);
            c0233f2.m1185c(i2 - 1, 6);
            i3 = 28;
        } else {
            c0233f2.m1185c(i4, 5);
            c0233f2.m1185c(i2 - 1, 11);
            i3 = 40;
        }
        return m4458e(c0233f2, i3, 4);
    }

    public static C2611yc m4460g(int i) {
        if (i == 4) {
            return C2611yc.f8074k;
        }
        if (i == 6) {
            return C2611yc.f8073j;
        }
        if (i == 8) {
            return C2611yc.f8077n;
        }
        if (i == 10) {
            return C2611yc.f8072i;
        }
        if (i == 12) {
            return C2611yc.f8071h;
        }
        throw new IllegalArgumentException("Unsupported word size ".concat(String.valueOf(i)));
    }

    public static C0233F2 m4461h(C0233F2 c0233f2, int i) {
        C0233F2 c0233f22 = new C0233F2();
        int iM1193o = c0233f2.m1193o();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iM1193o) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iM1193o || c0233f2.m1189h(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                c0233f22.m1185c(i7, i);
                i3--;
            } else if (i7 == 0) {
                i7 = i4 | 1;
                c0233f22.m1185c(i7, i);
                i3--;
            } else {
                c0233f22.m1185c(i4, i);
            }
            i3 += i;
        }
        return c0233f22;
    }

    public static int m4462i(int i, boolean z) {
        return ((z ? 88 : 112) + (i << 4)) * i;
    }
}
