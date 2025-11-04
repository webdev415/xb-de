package p000;

public final class C0469K8 {

    public static final int[] f1540g = {3808, 476, 2107, 1799};

    public final C0325H2 f1541a;

    public boolean f1542b;

    public int f1543c;

    public int f1544d;

    public int f1545e;

    public int f1546f;

    public static final class a {

        public final int f1547a;

        public final int f1548b;

        public a(int i, int i2) {
            this.f1547a = i;
            this.f1548b = i2;
        }

        public int m2311a() {
            return this.f1547a;
        }

        public int m2312b() {
            return this.f1548b;
        }

        public C0857Sk m2313c() {
            return new C0857Sk(this.f1547a, this.f1548b);
        }

        public String toString() {
            return "<" + this.f1547a + ' ' + this.f1548b + '>';
        }
    }

    public C0469K8(C0325H2 c0325h2) {
        this.f1541a = c0325h2;
    }

    public static float m2293b(a aVar, a aVar2) {
        return AbstractC2477vg.m10355b(aVar.m2311a(), aVar.m2312b(), aVar2.m2311a(), aVar2.m2312b());
    }

    public static float m2294c(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        return AbstractC2477vg.m10354a(c0857Sk.m4067c(), c0857Sk.m4068d(), c0857Sk2.m4067c(), c0857Sk2.m4068d());
    }

    public static C0857Sk[] m2295d(C0857Sk[] c0857SkArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float fM4067c = c0857SkArr[0].m4067c() - c0857SkArr[2].m4067c();
        float fM4068d = c0857SkArr[0].m4068d() - c0857SkArr[2].m4068d();
        float fM4067c2 = (c0857SkArr[0].m4067c() + c0857SkArr[2].m4067c()) / 2.0f;
        float fM4068d2 = (c0857SkArr[0].m4068d() + c0857SkArr[2].m4068d()) / 2.0f;
        float f2 = fM4067c * f;
        float f3 = fM4068d * f;
        C0857Sk c0857Sk = new C0857Sk(fM4067c2 + f2, fM4068d2 + f3);
        C0857Sk c0857Sk2 = new C0857Sk(fM4067c2 - f2, fM4068d2 - f3);
        float fM4067c3 = c0857SkArr[1].m4067c() - c0857SkArr[3].m4067c();
        float fM4068d3 = c0857SkArr[1].m4068d() - c0857SkArr[3].m4068d();
        float fM4067c4 = (c0857SkArr[1].m4067c() + c0857SkArr[3].m4067c()) / 2.0f;
        float fM4068d4 = (c0857SkArr[1].m4068d() + c0857SkArr[3].m4068d()) / 2.0f;
        float f4 = fM4067c3 * f;
        float f5 = f * fM4068d3;
        return new C0857Sk[]{c0857Sk, new C0857Sk(fM4067c4 + f4, fM4068d4 + f5), c0857Sk2, new C0857Sk(fM4067c4 - f4, fM4068d4 - f5)};
    }

    public static int m2296h(long j, boolean z) throws C2340sh {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new C2020lk(C2611yc.f8074k).m8404a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (C2112nk unused) {
            throw C2340sh.m9579a();
        }
    }

    public static int m2297m(int[] iArr, int i) throws C2340sh {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(f1540g[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw C2340sh.m9579a();
    }

    public C1151Z1 m2298a(boolean z) throws C2340sh {
        C0857Sk[] c0857SkArrM2300f = m2300f(m2304k());
        if (z) {
            C0857Sk c0857Sk = c0857SkArrM2300f[0];
            c0857SkArrM2300f[0] = c0857SkArrM2300f[2];
            c0857SkArrM2300f[2] = c0857Sk;
        }
        m2299e(c0857SkArrM2300f);
        C0325H2 c0325h2 = this.f1541a;
        int i = this.f1546f;
        return new C1151Z1(m2309q(c0325h2, c0857SkArrM2300f[i % 4], c0857SkArrM2300f[(i + 1) % 4], c0857SkArrM2300f[(i + 2) % 4], c0857SkArrM2300f[(i + 3) % 4]), m2305l(c0857SkArrM2300f), this.f1542b, this.f1544d, this.f1543c);
    }

    public final void m2299e(C0857Sk[] c0857SkArr) throws C2340sh {
        int i;
        long j;
        long j2;
        if (!m2307o(c0857SkArr[0]) || !m2307o(c0857SkArr[1]) || !m2307o(c0857SkArr[2]) || !m2307o(c0857SkArr[3])) {
            throw C2340sh.m9579a();
        }
        int i2 = this.f1545e * 2;
        int[] iArr = {m2310r(c0857SkArr[0], c0857SkArr[1], i2), m2310r(c0857SkArr[1], c0857SkArr[2], i2), m2310r(c0857SkArr[2], c0857SkArr[3], i2), m2310r(c0857SkArr[3], c0857SkArr[0], i2)};
        this.f1546f = m2297m(iArr, i2);
        long j3 = 0;
        for (int i3 = 0; i3 < 4; i3++) {
            int i4 = iArr[(this.f1546f + i3) % 4];
            if (this.f1542b) {
                j = j3 << 7;
                j2 = (i4 >> 1) & 127;
            } else {
                j = j3 << 10;
                j2 = ((i4 >> 2) & 992) + ((i4 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int iM2296h = m2296h(j3, this.f1542b);
        if (this.f1542b) {
            this.f1543c = (iM2296h >> 6) + 1;
            i = iM2296h & 63;
        } else {
            this.f1543c = (iM2296h >> 11) + 1;
            i = iM2296h & 2047;
        }
        this.f1544d = i + 1;
    }

    public final C0857Sk[] m2300f(a aVar) throws C2340sh {
        this.f1545e = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z = true;
        while (this.f1545e < 9) {
            a aVarM2303j = m2303j(aVar, z, 1, -1);
            a aVarM2303j2 = m2303j(aVar2, z, 1, 1);
            a aVarM2303j3 = m2303j(aVar3, z, -1, 1);
            a aVarM2303j4 = m2303j(aVar4, z, -1, -1);
            if (this.f1545e > 2) {
                double dM2293b = (m2293b(aVarM2303j4, aVarM2303j) * this.f1545e) / (m2293b(aVar4, aVar) * (this.f1545e + 2));
                if (dM2293b < 0.75d || dM2293b > 1.25d || !m2308p(aVarM2303j, aVarM2303j2, aVarM2303j3, aVarM2303j4)) {
                    break;
                }
            }
            z = !z;
            this.f1545e++;
            aVar4 = aVarM2303j4;
            aVar = aVarM2303j;
            aVar2 = aVarM2303j2;
            aVar3 = aVarM2303j3;
        }
        int i = this.f1545e;
        if (i != 5 && i != 7) {
            throw C2340sh.m9579a();
        }
        this.f1542b = i == 5;
        return m2295d(new C0857Sk[]{new C0857Sk(aVar.m2311a() + 0.5f, aVar.m2312b() - 0.5f), new C0857Sk(aVar2.m2311a() + 0.5f, aVar2.m2312b() + 0.5f), new C0857Sk(aVar3.m2311a() - 0.5f, aVar3.m2312b() + 0.5f), new C0857Sk(aVar4.m2311a() - 0.5f, aVar4.m2312b() - 0.5f)}, (r0 * 2) - 3, this.f1545e * 2);
    }

    public final int m2301g(a aVar, a aVar2) {
        float fM2293b = m2293b(aVar, aVar2);
        float fM2311a = (aVar2.m2311a() - aVar.m2311a()) / fM2293b;
        float fM2312b = (aVar2.m2312b() - aVar.m2312b()) / fM2293b;
        float fM2311a2 = aVar.m2311a();
        float fM2312b2 = aVar.m2312b();
        boolean zM1493e = this.f1541a.m1493e(aVar.m2311a(), aVar.m2312b());
        int iCeil = (int) Math.ceil(fM2293b);
        int i = 0;
        for (int i2 = 0; i2 < iCeil; i2++) {
            fM2311a2 += fM2311a;
            fM2312b2 += fM2312b;
            if (this.f1541a.m1493e(AbstractC2477vg.m10356c(fM2311a2), AbstractC2477vg.m10356c(fM2312b2)) != zM1493e) {
                i++;
            }
        }
        float f = i / fM2293b;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zM1493e ? 1 : -1;
        }
        return 0;
    }

    public final int m2302i() {
        if (this.f1542b) {
            return (this.f1543c * 4) + 11;
        }
        int i = this.f1543c;
        return i <= 4 ? (i * 4) + 15 : (i * 4) + ((((i - 4) / 8) + 1) * 2) + 15;
    }

    public final a m2303j(a aVar, boolean z, int i, int i2) {
        int iM2311a = aVar.m2311a() + i;
        int iM2312b = aVar.m2312b();
        while (true) {
            iM2312b += i2;
            if (!m2306n(iM2311a, iM2312b) || this.f1541a.m1493e(iM2311a, iM2312b) != z) {
                break;
            }
            iM2311a += i;
        }
        int i3 = iM2311a - i;
        int i4 = iM2312b - i2;
        while (m2306n(i3, i4) && this.f1541a.m1493e(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (m2306n(i5, i4) && this.f1541a.m1493e(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    public final a m2304k() {
        C0857Sk c0857SkM2313c;
        C0857Sk c0857Sk;
        C0857Sk c0857Sk2;
        C0857Sk c0857Sk3;
        C0857Sk c0857SkM2313c2;
        C0857Sk c0857SkM2313c3;
        C0857Sk c0857SkM2313c4;
        C0857Sk c0857SkM2313c5;
        try {
            C0857Sk[] c0857SkArrM4291c = new C0953Uo(this.f1541a).m4291c();
            c0857Sk2 = c0857SkArrM4291c[0];
            c0857Sk3 = c0857SkArrM4291c[1];
            c0857Sk = c0857SkArrM4291c[2];
            c0857SkM2313c = c0857SkArrM4291c[3];
        } catch (C2340sh unused) {
            int iM1499o = this.f1541a.m1499o() / 2;
            int iM1496j = this.f1541a.m1496j() / 2;
            int i = iM1499o + 7;
            int i2 = iM1496j - 7;
            C0857Sk c0857SkM2313c6 = m2303j(new a(i, i2), false, 1, -1).m2313c();
            int i3 = iM1496j + 7;
            C0857Sk c0857SkM2313c7 = m2303j(new a(i, i3), false, 1, 1).m2313c();
            int i4 = iM1499o - 7;
            C0857Sk c0857SkM2313c8 = m2303j(new a(i4, i3), false, -1, 1).m2313c();
            c0857SkM2313c = m2303j(new a(i4, i2), false, -1, -1).m2313c();
            c0857Sk = c0857SkM2313c8;
            c0857Sk2 = c0857SkM2313c6;
            c0857Sk3 = c0857SkM2313c7;
        }
        int iM10356c = AbstractC2477vg.m10356c((((c0857Sk2.m4067c() + c0857SkM2313c.m4067c()) + c0857Sk3.m4067c()) + c0857Sk.m4067c()) / 4.0f);
        int iM10356c2 = AbstractC2477vg.m10356c((((c0857Sk2.m4068d() + c0857SkM2313c.m4068d()) + c0857Sk3.m4068d()) + c0857Sk.m4068d()) / 4.0f);
        try {
            C0857Sk[] c0857SkArrM4291c2 = new C0953Uo(this.f1541a, 15, iM10356c, iM10356c2).m4291c();
            c0857SkM2313c2 = c0857SkArrM4291c2[0];
            c0857SkM2313c3 = c0857SkArrM4291c2[1];
            c0857SkM2313c4 = c0857SkArrM4291c2[2];
            c0857SkM2313c5 = c0857SkArrM4291c2[3];
        } catch (C2340sh unused2) {
            int i5 = iM10356c + 7;
            int i6 = iM10356c2 - 7;
            c0857SkM2313c2 = m2303j(new a(i5, i6), false, 1, -1).m2313c();
            int i7 = iM10356c2 + 7;
            c0857SkM2313c3 = m2303j(new a(i5, i7), false, 1, 1).m2313c();
            int i8 = iM10356c - 7;
            c0857SkM2313c4 = m2303j(new a(i8, i7), false, -1, 1).m2313c();
            c0857SkM2313c5 = m2303j(new a(i8, i6), false, -1, -1).m2313c();
        }
        return new a(AbstractC2477vg.m10356c((((c0857SkM2313c2.m4067c() + c0857SkM2313c5.m4067c()) + c0857SkM2313c3.m4067c()) + c0857SkM2313c4.m4067c()) / 4.0f), AbstractC2477vg.m10356c((((c0857SkM2313c2.m4068d() + c0857SkM2313c5.m4068d()) + c0857SkM2313c3.m4068d()) + c0857SkM2313c4.m4068d()) / 4.0f));
    }

    public final C0857Sk[] m2305l(C0857Sk[] c0857SkArr) {
        return m2295d(c0857SkArr, this.f1545e * 2, m2302i());
    }

    public final boolean m2306n(int i, int i2) {
        return i >= 0 && i < this.f1541a.m1499o() && i2 > 0 && i2 < this.f1541a.m1496j();
    }

    public final boolean m2307o(C0857Sk c0857Sk) {
        return m2306n(AbstractC2477vg.m10356c(c0857Sk.m4067c()), AbstractC2477vg.m10356c(c0857Sk.m4068d()));
    }

    public final boolean m2308p(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(aVar.m2311a() - 3, aVar.m2312b() + 3);
        a aVar6 = new a(aVar2.m2311a() - 3, aVar2.m2312b() - 3);
        a aVar7 = new a(aVar3.m2311a() + 3, aVar3.m2312b() - 3);
        a aVar8 = new a(aVar4.m2311a() + 3, aVar4.m2312b() + 3);
        int iM2301g = m2301g(aVar8, aVar5);
        return iM2301g != 0 && m2301g(aVar5, aVar6) == iM2301g && m2301g(aVar6, aVar7) == iM2301g && m2301g(aVar7, aVar8) == iM2301g;
    }

    public final C0325H2 m2309q(C0325H2 c0325h2, C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4) {
        AbstractC0574Mc abstractC0574McM2857b = AbstractC0574Mc.m2857b();
        int iM2302i = m2302i();
        float f = iM2302i / 2.0f;
        int i = this.f1545e;
        float f2 = f - i;
        float f3 = f + i;
        return abstractC0574McM2857b.mo2858c(c0325h2, iM2302i, iM2302i, f2, f2, f3, f2, f3, f3, f2, f3, c0857Sk.m4067c(), c0857Sk.m4068d(), c0857Sk2.m4067c(), c0857Sk2.m4068d(), c0857Sk3.m4067c(), c0857Sk3.m4068d(), c0857Sk4.m4067c(), c0857Sk4.m4068d());
    }

    public final int m2310r(C0857Sk c0857Sk, C0857Sk c0857Sk2, int i) {
        float fM2294c = m2294c(c0857Sk, c0857Sk2);
        float f = fM2294c / i;
        float fM4067c = c0857Sk.m4067c();
        float fM4068d = c0857Sk.m4068d();
        float fM4067c2 = ((c0857Sk2.m4067c() - c0857Sk.m4067c()) * f) / fM2294c;
        float fM4068d2 = (f * (c0857Sk2.m4068d() - c0857Sk.m4068d())) / fM2294c;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.f1541a.m1493e(AbstractC2477vg.m10356c((f2 * fM4067c2) + fM4067c), AbstractC2477vg.m10356c((f2 * fM4068d2) + fM4068d))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
