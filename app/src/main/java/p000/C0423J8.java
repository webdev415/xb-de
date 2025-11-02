package p000;

public final class C0423J8 extends C0377I8 {

    public final boolean f1294c;

    public C0423J8(C0968V2 c0968v2, boolean z) {
        super(c0968v2);
        this.f1294c = z;
    }

    public void m1832g(C2131o2 c2131o2) {
        C1302b5[] c1302b5ArrM1681d = m1681d();
        m1838m();
        m1837l(c1302b5ArrM1681d, c2131o2);
        C0968V2 c0968v2M1678a = m1678a();
        C0857Sk c0857SkM4318h = this.f1294c ? c0968v2M1678a.m4318h() : c0968v2M1678a.m4319i();
        C0857Sk c0857SkM4312b = this.f1294c ? c0968v2M1678a.m4312b() : c0968v2M1678a.m4313c();
        int iM1682e = m1682e((int) c0857SkM4318h.m4068d());
        int iM1682e2 = m1682e((int) c0857SkM4312b.m4068d());
        int iM5635c = -1;
        int i = 0;
        int iMax = 1;
        while (iM1682e < iM1682e2) {
            C1302b5 c1302b5 = c1302b5ArrM1681d[iM1682e];
            if (c1302b5 != null) {
                int iM5635c2 = c1302b5.m5635c() - iM5635c;
                if (iM5635c2 == 0) {
                    i++;
                } else {
                    if (iM5635c2 == 1) {
                        iMax = Math.max(iMax, i);
                    } else if (iM5635c2 < 0 || c1302b5.m5635c() >= c2131o2.m8833c() || iM5635c2 > iM1682e) {
                        c1302b5ArrM1681d[iM1682e] = null;
                    } else {
                        if (iMax > 2) {
                            iM5635c2 *= iMax - 2;
                        }
                        boolean z = iM5635c2 >= iM1682e;
                        for (int i2 = 1; i2 <= iM5635c2 && !z; i2++) {
                            z = c1302b5ArrM1681d[iM1682e - i2] != null;
                        }
                        if (z) {
                            c1302b5ArrM1681d[iM1682e] = null;
                        }
                    }
                    iM5635c = c1302b5.m5635c();
                    i = 1;
                }
            }
            iM1682e++;
        }
    }

    public final void m1833h(C2131o2 c2131o2) {
        C0968V2 c0968v2M1678a = m1678a();
        C0857Sk c0857SkM4318h = this.f1294c ? c0968v2M1678a.m4318h() : c0968v2M1678a.m4319i();
        C0857Sk c0857SkM4312b = this.f1294c ? c0968v2M1678a.m4312b() : c0968v2M1678a.m4313c();
        int iM1682e = m1682e((int) c0857SkM4312b.m4068d());
        C1302b5[] c1302b5ArrM1681d = m1681d();
        int iM5635c = -1;
        int i = 0;
        int iMax = 1;
        for (int iM1682e2 = m1682e((int) c0857SkM4318h.m4068d()); iM1682e2 < iM1682e; iM1682e2++) {
            C1302b5 c1302b5 = c1302b5ArrM1681d[iM1682e2];
            if (c1302b5 != null) {
                c1302b5.m5642j();
                int iM5635c2 = c1302b5.m5635c() - iM5635c;
                if (iM5635c2 == 0) {
                    i++;
                } else {
                    if (iM5635c2 == 1) {
                        iMax = Math.max(iMax, i);
                    } else if (c1302b5.m5635c() >= c2131o2.m8833c()) {
                        c1302b5ArrM1681d[iM1682e2] = null;
                    }
                    iM5635c = c1302b5.m5635c();
                    i = 1;
                }
            }
        }
    }

    public C2131o2 m1834i() {
        C1302b5[] c1302b5ArrM1681d = m1681d();
        C2270r2 c2270r2 = new C2270r2();
        C2270r2 c2270r22 = new C2270r2();
        C2270r2 c2270r23 = new C2270r2();
        C2270r2 c2270r24 = new C2270r2();
        for (C1302b5 c1302b5 : c1302b5ArrM1681d) {
            if (c1302b5 != null) {
                c1302b5.m5642j();
                int iM5637e = c1302b5.m5637e() % 30;
                int iM5635c = c1302b5.m5635c();
                if (!this.f1294c) {
                    iM5635c += 2;
                }
                int i = iM5635c % 3;
                if (i == 0) {
                    c2270r22.m9256b((iM5637e * 3) + 1);
                } else if (i == 1) {
                    c2270r24.m9256b(iM5637e / 3);
                    c2270r23.m9256b(iM5637e % 3);
                } else if (i == 2) {
                    c2270r2.m9256b(iM5637e + 1);
                }
            }
        }
        if (c2270r2.m9255a().length == 0 || c2270r22.m9255a().length == 0 || c2270r23.m9255a().length == 0 || c2270r24.m9255a().length == 0 || c2270r2.m9255a()[0] <= 0 || c2270r22.m9255a()[0] + c2270r23.m9255a()[0] < 3 || c2270r22.m9255a()[0] + c2270r23.m9255a()[0] > 90) {
            return null;
        }
        C2131o2 c2131o2 = new C2131o2(c2270r2.m9255a()[0], c2270r22.m9255a()[0], c2270r23.m9255a()[0], c2270r24.m9255a()[0]);
        m1837l(c1302b5ArrM1681d, c2131o2);
        return c2131o2;
    }

    public int[] m1835j() {
        int iM5635c;
        C2131o2 c2131o2M1834i = m1834i();
        if (c2131o2M1834i == null) {
            return null;
        }
        m1833h(c2131o2M1834i);
        int iM8833c = c2131o2M1834i.m8833c();
        int[] iArr = new int[iM8833c];
        for (C1302b5 c1302b5 : m1681d()) {
            if (c1302b5 != null && (iM5635c = c1302b5.m5635c()) < iM8833c) {
                iArr[iM5635c] = iArr[iM5635c] + 1;
            }
        }
        return iArr;
    }

    public boolean m1836k() {
        return this.f1294c;
    }

    public final void m1837l(C1302b5[] c1302b5Arr, C2131o2 c2131o2) {
        for (int i = 0; i < c1302b5Arr.length; i++) {
            C1302b5 c1302b5 = c1302b5Arr[i];
            if (c1302b5 != null) {
                int iM5637e = c1302b5.m5637e() % 30;
                int iM5635c = c1302b5.m5635c();
                if (iM5635c > c2131o2.m8833c()) {
                    c1302b5Arr[i] = null;
                } else {
                    if (!this.f1294c) {
                        iM5635c += 2;
                    }
                    int i2 = iM5635c % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && iM5637e + 1 != c2131o2.m8831a()) {
                                c1302b5Arr[i] = null;
                            }
                        } else if (iM5637e / 3 != c2131o2.m8832b() || iM5637e % 3 != c2131o2.m8834d()) {
                            c1302b5Arr[i] = null;
                        }
                    } else if ((iM5637e * 3) + 1 != c2131o2.m8835e()) {
                        c1302b5Arr[i] = null;
                    }
                }
            }
        }
    }

    public final void m1838m() {
        for (C1302b5 c1302b5 : m1681d()) {
            if (c1302b5 != null) {
                c1302b5.m5642j();
            }
        }
    }

    @Override
    public String toString() {
        return "IsLeft: " + this.f1294c + '\n' + super.toString();
    }
}
