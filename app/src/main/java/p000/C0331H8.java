package p000;

import java.util.Formatter;

public final class C0331H8 {

    public final C2131o2 f1022a;

    public final C0377I8[] f1023b;

    public C0968V2 f1024c;

    public final int f1025d;

    public C0331H8(C2131o2 c2131o2, C0968V2 c0968v2) {
        this.f1022a = c2131o2;
        int iM8831a = c2131o2.m8831a();
        this.f1025d = iM8831a;
        this.f1024c = c0968v2;
        this.f1023b = new C0377I8[iM8831a + 2];
    }

    public static boolean m1516b(C1302b5 c1302b5, C1302b5 c1302b52) {
        if (c1302b52 == null || !c1302b52.m5639g() || c1302b52.m5633a() != c1302b5.m5633a()) {
            return false;
        }
        c1302b5.m5641i(c1302b52.m5635c());
        return true;
    }

    public static int m1517c(int i, int i2, C1302b5 c1302b5) {
        if (c1302b5 == null || c1302b5.m5639g()) {
            return i2;
        }
        if (!c1302b5.m5640h(i)) {
            return i2 + 1;
        }
        c1302b5.m5641i(i);
        return 0;
    }

    public final void m1518a(C0377I8 c0377i8) {
        if (c0377i8 != null) {
            ((C0423J8) c0377i8).m1832g(this.f1022a);
        }
    }

    public final int m1519d() {
        int iM1521f = m1521f();
        if (iM1521f == 0) {
            return 0;
        }
        for (int i = 1; i < this.f1025d + 1; i++) {
            C1302b5[] c1302b5ArrM1681d = this.f1023b[i].m1681d();
            for (int i2 = 0; i2 < c1302b5ArrM1681d.length; i2++) {
                C1302b5 c1302b5 = c1302b5ArrM1681d[i2];
                if (c1302b5 != null && !c1302b5.m5639g()) {
                    m1520e(i, i2, c1302b5ArrM1681d);
                }
            }
        }
        return iM1521f;
    }

    public final void m1520e(int i, int i2, C1302b5[] c1302b5Arr) {
        C1302b5 c1302b5 = c1302b5Arr[i2];
        C1302b5[] c1302b5ArrM1681d = this.f1023b[i - 1].m1681d();
        C0377I8 c0377i8 = this.f1023b[i + 1];
        C1302b5[] c1302b5ArrM1681d2 = c0377i8 != null ? c0377i8.m1681d() : c1302b5ArrM1681d;
        C1302b5[] c1302b5Arr2 = new C1302b5[14];
        c1302b5Arr2[2] = c1302b5ArrM1681d[i2];
        c1302b5Arr2[3] = c1302b5ArrM1681d2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            c1302b5Arr2[0] = c1302b5Arr[i3];
            c1302b5Arr2[4] = c1302b5ArrM1681d[i3];
            c1302b5Arr2[5] = c1302b5ArrM1681d2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            c1302b5Arr2[8] = c1302b5Arr[i4];
            c1302b5Arr2[10] = c1302b5ArrM1681d[i4];
            c1302b5Arr2[11] = c1302b5ArrM1681d2[i4];
        }
        if (i2 < c1302b5Arr.length - 1) {
            int i5 = i2 + 1;
            c1302b5Arr2[1] = c1302b5Arr[i5];
            c1302b5Arr2[6] = c1302b5ArrM1681d[i5];
            c1302b5Arr2[7] = c1302b5ArrM1681d2[i5];
        }
        if (i2 < c1302b5Arr.length - 2) {
            int i6 = i2 + 2;
            c1302b5Arr2[9] = c1302b5Arr[i6];
            c1302b5Arr2[12] = c1302b5ArrM1681d[i6];
            c1302b5Arr2[13] = c1302b5ArrM1681d2[i6];
        }
        for (int i7 = 0; i7 < 14 && !m1516b(c1302b5, c1302b5Arr2[i7]); i7++) {
        }
    }

    public final int m1521f() {
        m1522g();
        return m1523h() + m1524i();
    }

    public final void m1522g() {
        C0377I8[] c0377i8Arr = this.f1023b;
        C0377I8 c0377i8 = c0377i8Arr[0];
        if (c0377i8 == null || c0377i8Arr[this.f1025d + 1] == null) {
            return;
        }
        C1302b5[] c1302b5ArrM1681d = c0377i8.m1681d();
        C1302b5[] c1302b5ArrM1681d2 = this.f1023b[this.f1025d + 1].m1681d();
        for (int i = 0; i < c1302b5ArrM1681d.length; i++) {
            C1302b5 c1302b5 = c1302b5ArrM1681d[i];
            if (c1302b5 != null && c1302b5ArrM1681d2[i] != null && c1302b5.m5635c() == c1302b5ArrM1681d2[i].m5635c()) {
                for (int i2 = 1; i2 <= this.f1025d; i2++) {
                    C1302b5 c1302b52 = this.f1023b[i2].m1681d()[i];
                    if (c1302b52 != null) {
                        c1302b52.m5641i(c1302b5ArrM1681d[i].m5635c());
                        if (!c1302b52.m5639g()) {
                            this.f1023b[i2].m1681d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    public final int m1523h() {
        C0377I8 c0377i8 = this.f1023b[0];
        if (c0377i8 == null) {
            return 0;
        }
        C1302b5[] c1302b5ArrM1681d = c0377i8.m1681d();
        int i = 0;
        for (int i2 = 0; i2 < c1302b5ArrM1681d.length; i2++) {
            C1302b5 c1302b5 = c1302b5ArrM1681d[i2];
            if (c1302b5 != null) {
                int iM5635c = c1302b5.m5635c();
                int iM1517c = 0;
                for (int i3 = 1; i3 < this.f1025d + 1 && iM1517c < 2; i3++) {
                    C1302b5 c1302b52 = this.f1023b[i3].m1681d()[i2];
                    if (c1302b52 != null) {
                        iM1517c = m1517c(iM5635c, iM1517c, c1302b52);
                        if (!c1302b52.m5639g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public final int m1524i() {
        C0377I8[] c0377i8Arr = this.f1023b;
        int i = this.f1025d;
        if (c0377i8Arr[i + 1] == null) {
            return 0;
        }
        C1302b5[] c1302b5ArrM1681d = c0377i8Arr[i + 1].m1681d();
        int i2 = 0;
        for (int i3 = 0; i3 < c1302b5ArrM1681d.length; i3++) {
            C1302b5 c1302b5 = c1302b5ArrM1681d[i3];
            if (c1302b5 != null) {
                int iM5635c = c1302b5.m5635c();
                int iM1517c = 0;
                for (int i4 = this.f1025d + 1; i4 > 0 && iM1517c < 2; i4--) {
                    C1302b5 c1302b52 = this.f1023b[i4].m1681d()[i3];
                    if (c1302b52 != null) {
                        iM1517c = m1517c(iM5635c, iM1517c, c1302b52);
                        if (!c1302b52.m5639g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int m1525j() {
        return this.f1025d;
    }

    public int m1526k() {
        return this.f1022a.m8832b();
    }

    public int m1527l() {
        return this.f1022a.m8833c();
    }

    public C0968V2 m1528m() {
        return this.f1024c;
    }

    public C0377I8 m1529n(int i) {
        return this.f1023b[i];
    }

    public C0377I8[] m1530o() {
        m1518a(this.f1023b[0]);
        m1518a(this.f1023b[this.f1025d + 1]);
        int i = 928;
        while (true) {
            int iM1519d = m1519d();
            if (iM1519d <= 0 || iM1519d >= i) {
                break;
            }
            i = iM1519d;
        }
        return this.f1023b;
    }

    public void m1531p(C0968V2 c0968v2) {
        this.f1024c = c0968v2;
    }

    public void m1532q(int i, C0377I8 c0377i8) {
        this.f1023b[i] = c0377i8;
    }

    public String toString() {
        C0377I8[] c0377i8Arr = this.f1023b;
        C0377I8 c0377i8 = c0377i8Arr[0];
        if (c0377i8 == null) {
            c0377i8 = c0377i8Arr[this.f1025d + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < c0377i8.m1681d().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.f1025d + 2; i2++) {
                    C0377I8 c0377i82 = this.f1023b[i2];
                    if (c0377i82 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        C1302b5 c1302b5 = c0377i82.m1681d()[i];
                        if (c1302b5 == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(c1302b5.m5635c()), Integer.valueOf(c1302b5.m5637e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
