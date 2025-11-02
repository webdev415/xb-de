package p000;

import p000.C2567xe;

public abstract class AbstractC1132Yj extends AbstractC1086Xj {
    public static int m4981b(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static int m4982c(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long m4983d(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static int m4984e(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static C2567xe m4985f(int i, int i2) {
        return C2567xe.f8004o.m10720a(i, i2, -1);
    }

    public static C2567xe m4986g(C2567xe c2567xe, int i) {
        AbstractC0116Ce.m476e(c2567xe, "<this>");
        AbstractC1086Xj.m4806a(i > 0, Integer.valueOf(i));
        C2567xe.a aVar = C2567xe.f8004o;
        int iM10716d = c2567xe.m10716d();
        int iM10717f = c2567xe.m10717f();
        if (c2567xe.m10718g() <= 0) {
            i = -i;
        }
        return aVar.m10720a(iM10716d, iM10717f, i);
    }

    public static C2659ze m4987h(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? C2659ze.f8256p.m11031a() : new C2659ze(i, i2 - 1);
    }
}
