package p000;

public final class C0463K2 {

    public final C0325H2 f1514a;

    public final C0325H2 f1515b;

    public final C0080Bo f1516c;

    public C0463K2(C0325H2 c0325h2) throws C2610yb {
        int iM1496j = c0325h2.m1496j();
        if (iM1496j < 8 || iM1496j > 144 || (iM1496j & 1) != 0) {
            throw C2610yb.m10853a();
        }
        this.f1516c = m2255j(c0325h2);
        C0325H2 c0325h2M2256a = m2256a(c0325h2);
        this.f1514a = c0325h2M2256a;
        this.f1515b = new C0325H2(c0325h2M2256a.m1499o(), c0325h2M2256a.m1496j());
    }

    public static C0080Bo m2255j(C0325H2 c0325h2) {
        return C0080Bo.m328h(c0325h2.m1496j(), c0325h2.m1499o());
    }

    public final C0325H2 m2256a(C0325H2 c0325h2) {
        int iM333f = this.f1516c.m333f();
        int iM332e = this.f1516c.m332e();
        if (c0325h2.m1496j() != iM333f) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iM330c = this.f1516c.m330c();
        int iM329b = this.f1516c.m329b();
        int i = iM333f / iM330c;
        int i2 = iM332e / iM329b;
        C0325H2 c0325h22 = new C0325H2(i2 * iM329b, i * iM330c);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * iM330c;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * iM329b;
                for (int i7 = 0; i7 < iM330c; i7++) {
                    int i8 = ((iM330c + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < iM329b; i10++) {
                        if (c0325h2.m1493e(((iM329b + 2) * i5) + 1 + i10, i8)) {
                            c0325h22.m1501r(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return c0325h22;
    }

    public C0080Bo m2257b() {
        return this.f1516c;
    }

    public byte[] m2258c() throws C2610yb {
        byte[] bArr = new byte[this.f1516c.m334g()];
        int iM1496j = this.f1514a.m1496j();
        int iM1499o = this.f1514a.m1499o();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == iM1496j && i == 0 && !z) {
                bArr[i2] = (byte) m2259d(iM1496j, iM1499o);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = iM1496j - 2;
                if (i3 == i4 && i == 0 && (iM1499o & 3) != 0 && !z2) {
                    bArr[i2] = (byte) m2260e(iM1496j, iM1499o);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == iM1496j + 4 && i == 2 && (iM1499o & 7) == 0 && !z3) {
                    bArr[i2] = (byte) m2261f(iM1496j, iM1499o);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (iM1499o & 7) == 4 && !z4) {
                    bArr[i2] = (byte) m2262g(iM1496j, iM1499o);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    while (true) {
                        if (i3 < iM1496j && i >= 0 && !this.f1515b.m1493e(i, i3)) {
                            bArr[i2] = (byte) m2264i(i3, i, iM1496j, iM1499o);
                            i2++;
                        }
                        int i5 = i3 - 2;
                        int i6 = i + 2;
                        if (i5 < 0 || i6 >= iM1499o) {
                            break;
                        }
                        i3 = i5;
                        i = i6;
                    }
                    int i7 = i3 - 1;
                    int i8 = i + 5;
                    while (true) {
                        if (i7 >= 0 && i8 < iM1499o && !this.f1515b.m1493e(i8, i7)) {
                            bArr[i2] = (byte) m2264i(i7, i8, iM1496j, iM1499o);
                            i2++;
                        }
                        int i9 = i7 + 2;
                        int i10 = i8 - 2;
                        if (i9 >= iM1496j || i10 < 0) {
                            break;
                        }
                        i7 = i9;
                        i8 = i10;
                    }
                    i3 = i7 + 5;
                    i = i8 - 1;
                }
            }
            if (i3 >= iM1496j && i >= iM1499o) {
                break;
            }
        }
        if (i2 == this.f1516c.m334g()) {
            return bArr;
        }
        throw C2610yb.m10853a();
    }

    public final int m2259d(int i, int i2) {
        int i3 = i - 1;
        int i4 = (m2263h(i3, 0, i, i2) ? 1 : 0) << 1;
        if (m2263h(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m2263h(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m2263h(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (m2263h(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (m2263h(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (m2263h(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return m2263h(3, i8, i, i2) ? i11 | 1 : i11;
    }

    public final int m2260e(int i, int i2) {
        int i3 = (m2263h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (m2263h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (m2263h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m2263h(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (m2263h(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (m2263h(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (m2263h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return m2263h(1, i9, i, i2) ? i10 | 1 : i10;
    }

    public final int m2261f(int i, int i2) {
        int i3 = i - 1;
        int i4 = (m2263h(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (m2263h(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (m2263h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (m2263h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (m2263h(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (m2263h(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m2263h(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return m2263h(1, i5, i, i2) ? i13 | 1 : i13;
    }

    public final int m2262g(int i, int i2) {
        int i3 = (m2263h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (m2263h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (m2263h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (m2263h(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (m2263h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (m2263h(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (m2263h(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return m2263h(3, i7, i, i2) ? i10 | 1 : i10;
    }

    public final boolean m2263h(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f1515b.m1501r(i2, i);
        return this.f1514a.m1493e(i2, i);
    }

    public final int m2264i(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (m2263h(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (m2263h(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (m2263h(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (m2263h(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (m2263h(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (m2263h(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (m2263h(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return m2263h(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
