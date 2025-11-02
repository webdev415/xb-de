package p000;

import java.util.Formatter;

/* loaded from: classes.dex */
public class C0377I8 {

    public final C0968V2 f1134a;

    public final C1302b5[] f1135b;

    public C0377I8(C0968V2 c0968v2) {
        this.f1134a = new C0968V2(c0968v2);
        this.f1135b = new C1302b5[(c0968v2.m4315e() - c0968v2.m4317g()) + 1];
    }

    public final C0968V2 m1678a() {
        return this.f1134a;
    }

    public final C1302b5 m1679b(int i) {
        return this.f1135b[m1682e(i)];
    }

    public final C1302b5 m1680c(int i) {
        C1302b5 c1302b5;
        C1302b5 c1302b52;
        C1302b5 c1302b5M1679b = m1679b(i);
        if (c1302b5M1679b != null) {
            return c1302b5M1679b;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iM1682e = m1682e(i) - i2;
            if (iM1682e >= 0 && (c1302b52 = this.f1135b[iM1682e]) != null) {
                return c1302b52;
            }
            int iM1682e2 = m1682e(i) + i2;
            C1302b5[] c1302b5Arr = this.f1135b;
            if (iM1682e2 < c1302b5Arr.length && (c1302b5 = c1302b5Arr[iM1682e2]) != null) {
                return c1302b5;
            }
        }
        return null;
    }

    public final C1302b5[] m1681d() {
        return this.f1135b;
    }

    public final int m1682e(int i) {
        return i - this.f1134a.m4317g();
    }

    public final void m1683f(int i, C1302b5 c1302b5) {
        this.f1135b[m1682e(i)] = c1302b5;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (C1302b5 c1302b5 : this.f1135b) {
                if (c1302b5 == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(c1302b5.m5635c()), Integer.valueOf(c1302b5.m5637e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}
