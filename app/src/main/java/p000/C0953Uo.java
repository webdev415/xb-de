package p000;

/* loaded from: classes.dex */
public final class C0953Uo {

    public final C0325H2 f2873a;

    public final int f2874b;

    public final int f2875c;

    public final int f2876d;

    public final int f2877e;

    public final int f2878f;

    public final int f2879g;

    public C0953Uo(C0325H2 c0325h2) {
        this(c0325h2, 10, c0325h2.m1499o() / 2, c0325h2.m1496j() / 2);
    }

    public final C0857Sk[] m4289a(C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4) {
        C0857Sk c0857Sk5;
        C0857Sk c0857Sk6;
        C0857Sk c0857Sk7;
        C0857Sk c0857Sk8;
        float fM4067c = c0857Sk.m4067c();
        float fM4068d = c0857Sk.m4068d();
        float fM4067c2 = c0857Sk2.m4067c();
        float fM4068d2 = c0857Sk2.m4068d();
        float fM4067c3 = c0857Sk3.m4067c();
        float fM4068d3 = c0857Sk3.m4068d();
        float fM4067c4 = c0857Sk4.m4067c();
        float fM4068d4 = c0857Sk4.m4068d();
        if (fM4067c < this.f2875c / 2.0f) {
            c0857Sk5 = new C0857Sk(fM4067c4 - 1.0f, fM4068d4 + 1.0f);
            c0857Sk6 = new C0857Sk(fM4067c2 + 1.0f, fM4068d2 + 1.0f);
            c0857Sk7 = new C0857Sk(fM4067c3 - 1.0f, fM4068d3 - 1.0f);
            c0857Sk8 = new C0857Sk(fM4067c + 1.0f, fM4068d - 1.0f);
        } else {
            c0857Sk5 = new C0857Sk(fM4067c4 + 1.0f, fM4068d4 + 1.0f);
            c0857Sk6 = new C0857Sk(fM4067c2 + 1.0f, fM4068d2 - 1.0f);
            c0857Sk7 = new C0857Sk(fM4067c3 - 1.0f, fM4068d3 + 1.0f);
            c0857Sk8 = new C0857Sk(fM4067c - 1.0f, fM4068d - 1.0f);
        }
        return new C0857Sk[]{c0857Sk5, c0857Sk6, c0857Sk7, c0857Sk8};
    }

    public final boolean m4290b(int i, int i2, int i3, boolean z) {
        if (z) {
            while (i <= i2) {
                if (this.f2873a.m1493e(i, i3)) {
                    return true;
                }
                i++;
            }
            return false;
        }
        while (i <= i2) {
            if (this.f2873a.m1493e(i3, i)) {
                return true;
            }
            i++;
        }
        return false;
    }

    public C0857Sk[] m4291c() throws C2340sh {
        int i = this.f2876d;
        int i2 = this.f2877e;
        int i3 = this.f2879g;
        int i4 = this.f2878f;
        boolean z = false;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = true;
        while (z6) {
            boolean z7 = false;
            boolean zM4290b = true;
            while (true) {
                if ((!zM4290b && z2) || i2 >= this.f2875c) {
                    break;
                }
                zM4290b = m4290b(i3, i4, i2, false);
                if (zM4290b) {
                    i2++;
                    z2 = true;
                    z7 = true;
                } else if (!z2) {
                    i2++;
                }
            }
            if (i2 < this.f2875c) {
                boolean zM4290b2 = true;
                while (true) {
                    if ((!zM4290b2 && z3) || i4 >= this.f2874b) {
                        break;
                    }
                    zM4290b2 = m4290b(i, i2, i4, true);
                    if (zM4290b2) {
                        i4++;
                        z3 = true;
                        z7 = true;
                    } else if (!z3) {
                        i4++;
                    }
                }
                if (i4 < this.f2874b) {
                    boolean zM4290b3 = true;
                    while (true) {
                        if ((!zM4290b3 && z4) || i < 0) {
                            break;
                        }
                        zM4290b3 = m4290b(i3, i4, i, false);
                        if (zM4290b3) {
                            i--;
                            z4 = true;
                            z7 = true;
                        } else if (!z4) {
                            i--;
                        }
                    }
                    if (i >= 0) {
                        z6 = z7;
                        boolean zM4290b4 = true;
                        while (true) {
                            if ((!zM4290b4 && z5) || i3 < 0) {
                                break;
                            }
                            zM4290b4 = m4290b(i, i2, i3, true);
                            if (zM4290b4) {
                                i3--;
                                z6 = true;
                                z5 = true;
                            } else if (!z5) {
                                i3--;
                            }
                        }
                        if (i3 < 0) {
                        }
                    }
                }
            }
            z = true;
            break;
        }
        if (z) {
            throw C2340sh.m9579a();
        }
        int i5 = i2 - i;
        C0857Sk c0857SkM4292d = null;
        C0857Sk c0857SkM4292d2 = null;
        for (int i6 = 1; c0857SkM4292d2 == null && i6 < i5; i6++) {
            c0857SkM4292d2 = m4292d(i, i4 - i6, i + i6, i4);
        }
        if (c0857SkM4292d2 == null) {
            throw C2340sh.m9579a();
        }
        C0857Sk c0857SkM4292d3 = null;
        for (int i7 = 1; c0857SkM4292d3 == null && i7 < i5; i7++) {
            c0857SkM4292d3 = m4292d(i, i3 + i7, i + i7, i3);
        }
        if (c0857SkM4292d3 == null) {
            throw C2340sh.m9579a();
        }
        C0857Sk c0857SkM4292d4 = null;
        for (int i8 = 1; c0857SkM4292d4 == null && i8 < i5; i8++) {
            c0857SkM4292d4 = m4292d(i2, i3 + i8, i2 - i8, i3);
        }
        if (c0857SkM4292d4 == null) {
            throw C2340sh.m9579a();
        }
        for (int i9 = 1; c0857SkM4292d == null && i9 < i5; i9++) {
            c0857SkM4292d = m4292d(i2, i4 - i9, i2 - i9, i4);
        }
        if (c0857SkM4292d != null) {
            return m4289a(c0857SkM4292d, c0857SkM4292d2, c0857SkM4292d4, c0857SkM4292d3);
        }
        throw C2340sh.m9579a();
    }

    public final C0857Sk m4292d(float f, float f2, float f3, float f4) {
        int iM10356c = AbstractC2477vg.m10356c(AbstractC2477vg.m10354a(f, f2, f3, f4));
        float f5 = iM10356c;
        float f6 = (f3 - f) / f5;
        float f7 = (f4 - f2) / f5;
        for (int i = 0; i < iM10356c; i++) {
            float f8 = i;
            int iM10356c2 = AbstractC2477vg.m10356c((f8 * f6) + f);
            int iM10356c3 = AbstractC2477vg.m10356c((f8 * f7) + f2);
            if (this.f2873a.m1493e(iM10356c2, iM10356c3)) {
                return new C0857Sk(iM10356c2, iM10356c3);
            }
        }
        return null;
    }

    public C0953Uo(C0325H2 c0325h2, int i, int i2, int i3) throws C2340sh {
        this.f2873a = c0325h2;
        int iM1496j = c0325h2.m1496j();
        this.f2874b = iM1496j;
        int iM1499o = c0325h2.m1499o();
        this.f2875c = iM1499o;
        int i4 = i / 2;
        int i5 = i2 - i4;
        this.f2876d = i5;
        int i6 = i2 + i4;
        this.f2877e = i6;
        int i7 = i3 - i4;
        this.f2879g = i7;
        int i8 = i3 + i4;
        this.f2878f = i8;
        if (i7 < 0 || i5 < 0 || i8 >= iM1496j || i6 >= iM1499o) {
            throw C2340sh.m9579a();
        }
    }
}
