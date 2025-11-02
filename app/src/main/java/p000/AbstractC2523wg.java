package p000;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;

/* loaded from: classes.dex */
public abstract class AbstractC2523wg {

    public static final int[][] f7869a = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};

    public static final int[][] f7870b = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};

    public static final int[][] f7871c = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, ModuleDescriptor.MODULE_VERSION, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, 134, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, 142, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, 142, 170}};

    public static final int[][] f7872d = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};

    public static void m10567a(C0233F2 c0233f2, EnumC1363ca enumC1363ca, C0126Co c0126Co, int i, C0050B3 c0050b3) throws C0127Cp {
        m10569c(c0050b3);
        m10570d(c0126Co, c0050b3);
        m10578l(enumC1363ca, i, c0050b3);
        m10585s(c0126Co, c0050b3);
        m10572f(c0233f2, i, c0050b3);
    }

    public static int m10568b(int i, int i2) {
        if (i2 == 0) {
            throw new IllegalArgumentException("0 polynomial");
        }
        int iM10580n = m10580n(i2);
        int iM10580n2 = i << (iM10580n - 1);
        while (m10580n(iM10580n2) >= iM10580n) {
            iM10580n2 ^= i2 << (m10580n(iM10580n2) - iM10580n);
        }
        return iM10580n2;
    }

    public static void m10569c(C0050B3 c0050b3) {
        c0050b3.m189a((byte) -1);
    }

    public static void m10570d(C0126Co c0126Co, C0050B3 c0050b3) throws C0127Cp {
        m10576j(c0050b3);
        m10571e(c0050b3);
        m10584r(c0126Co, c0050b3);
        m10577k(c0050b3);
    }

    public static void m10571e(C0050B3 c0050b3) throws C0127Cp {
        if (c0050b3.m190b(8, c0050b3.m192d() - 8) == 0) {
            throw new C0127Cp();
        }
        c0050b3.m194f(8, c0050b3.m192d() - 8, 1);
    }

    public static void m10572f(C0233F2 c0233f2, int i, C0050B3 c0050b3) throws C0127Cp {
        boolean zM1189h;
        int iM193e = c0050b3.m193e() - 1;
        int iM192d = c0050b3.m192d() - 1;
        int i2 = 0;
        int i3 = -1;
        while (iM193e > 0) {
            if (iM193e == 6) {
                iM193e--;
            }
            while (iM192d >= 0 && iM192d < c0050b3.m192d()) {
                for (int i4 = 0; i4 < 2; i4++) {
                    int i5 = iM193e - i4;
                    if (m10581o(c0050b3.m190b(i5, iM192d))) {
                        if (i2 < c0233f2.m1193o()) {
                            zM1189h = c0233f2.m1189h(i2);
                            i2++;
                        } else {
                            zM1189h = false;
                        }
                        if (i != -1 && AbstractC2385tg.m9713f(i, i5, iM192d)) {
                            zM1189h = !zM1189h;
                        }
                        c0050b3.m195g(i5, iM192d, zM1189h);
                    }
                }
                iM192d += i3;
            }
            i3 = -i3;
            iM192d += i3;
            iM193e -= 2;
        }
        if (i2 == c0233f2.m1193o()) {
            return;
        }
        throw new C0127Cp("Not all bits consumed: " + i2 + '/' + c0233f2.m1193o());
    }

    public static void m10573g(int i, int i2, C0050B3 c0050b3) throws C0127Cp {
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = i + i3;
            if (!m10581o(c0050b3.m190b(i4, i2))) {
                throw new C0127Cp();
            }
            c0050b3.m194f(i4, i2, 0);
        }
    }

    public static void m10574h(int i, int i2, C0050B3 c0050b3) {
        for (int i3 = 0; i3 < 5; i3++) {
            int[] iArr = f7870b[i3];
            for (int i4 = 0; i4 < 5; i4++) {
                c0050b3.m194f(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void m10575i(int i, int i2, C0050B3 c0050b3) {
        for (int i3 = 0; i3 < 7; i3++) {
            int[] iArr = f7869a[i3];
            for (int i4 = 0; i4 < 7; i4++) {
                c0050b3.m194f(i + i4, i2 + i3, iArr[i4]);
            }
        }
    }

    public static void m10576j(C0050B3 c0050b3) throws C0127Cp {
        int length = f7869a[0].length;
        m10575i(0, 0, c0050b3);
        m10575i(c0050b3.m193e() - length, 0, c0050b3);
        m10575i(0, c0050b3.m193e() - length, c0050b3);
        m10573g(0, 7, c0050b3);
        m10573g(c0050b3.m193e() - 8, 7, c0050b3);
        m10573g(0, c0050b3.m193e() - 8, c0050b3);
        m10579m(7, 0, c0050b3);
        m10579m(c0050b3.m192d() - 8, 0, c0050b3);
        m10579m(7, c0050b3.m192d() - 7, c0050b3);
    }

    public static void m10577k(C0050B3 c0050b3) {
        int i = 8;
        while (i < c0050b3.m193e() - 8) {
            int i2 = i + 1;
            int i3 = i2 % 2;
            if (m10581o(c0050b3.m190b(i, 6))) {
                c0050b3.m194f(i, 6, i3);
            }
            if (m10581o(c0050b3.m190b(6, i))) {
                c0050b3.m194f(6, i, i3);
            }
            i = i2;
        }
    }

    public static void m10578l(EnumC1363ca enumC1363ca, int i, C0050B3 c0050b3) throws C0127Cp {
        int iM192d;
        C0233F2 c0233f2 = new C0233F2();
        m10582p(enumC1363ca, i, c0233f2);
        for (int i2 = 0; i2 < c0233f2.m1193o(); i2++) {
            boolean zM1189h = c0233f2.m1189h((c0233f2.m1193o() - 1) - i2);
            int[] iArr = f7872d[i2];
            c0050b3.m195g(iArr[0], iArr[1], zM1189h);
            int iM193e = 8;
            if (i2 < 8) {
                iM192d = 8;
                iM193e = (c0050b3.m193e() - i2) - 1;
            } else {
                iM192d = (c0050b3.m192d() - 7) + (i2 - 8);
            }
            c0050b3.m195g(iM193e, iM192d, zM1189h);
        }
    }

    public static void m10579m(int i, int i2, C0050B3 c0050b3) throws C0127Cp {
        for (int i3 = 0; i3 < 7; i3++) {
            int i4 = i2 + i3;
            if (!m10581o(c0050b3.m190b(i, i4))) {
                throw new C0127Cp();
            }
            c0050b3.m194f(i, i4, 0);
        }
    }

    public static int m10580n(int i) {
        return 32 - Integer.numberOfLeadingZeros(i);
    }

    public static boolean m10581o(int i) {
        return i == -1;
    }

    public static void m10582p(EnumC1363ca enumC1363ca, int i, C0233F2 c0233f2) throws C0127Cp {
        if (!C2618yj.m10893b(i)) {
            throw new C0127Cp("Invalid mask pattern");
        }
        int iM5857e = (enumC1363ca.m5857e() << 3) | i;
        c0233f2.m1185c(iM5857e, 5);
        c0233f2.m1185c(m10568b(iM5857e, 1335), 10);
        C0233F2 c0233f22 = new C0233F2();
        c0233f22.m1185c(21522, 15);
        c0233f2.m1200x(c0233f22);
        if (c0233f2.m1193o() == 15) {
            return;
        }
        throw new C0127Cp("should not happen but we got: " + c0233f2.m1193o());
    }

    public static void m10583q(C0126Co c0126Co, C0233F2 c0233f2) throws C0127Cp {
        c0233f2.m1185c(c0126Co.m519j(), 6);
        c0233f2.m1185c(m10568b(c0126Co.m519j(), 7973), 12);
        if (c0233f2.m1193o() == 18) {
            return;
        }
        throw new C0127Cp("should not happen but we got: " + c0233f2.m1193o());
    }

    public static void m10584r(C0126Co c0126Co, C0050B3 c0050b3) {
        if (c0126Co.m519j() < 2) {
            return;
        }
        int[] iArr = f7871c[c0126Co.m519j() - 1];
        for (int i : iArr) {
            if (i >= 0) {
                for (int i2 : iArr) {
                    if (i2 >= 0 && m10581o(c0050b3.m190b(i2, i))) {
                        m10574h(i2 - 2, i - 2, c0050b3);
                    }
                }
            }
        }
    }

    public static void m10585s(C0126Co c0126Co, C0050B3 c0050b3) throws C0127Cp {
        if (c0126Co.m519j() < 7) {
            return;
        }
        C0233F2 c0233f2 = new C0233F2();
        m10583q(c0126Co, c0233f2);
        int i = 17;
        for (int i2 = 0; i2 < 6; i2++) {
            for (int i3 = 0; i3 < 3; i3++) {
                boolean zM1189h = c0233f2.m1189h(i);
                i--;
                c0050b3.m195g(i2, (c0050b3.m192d() - 11) + i3, zM1189h);
                c0050b3.m195g((c0050b3.m192d() - 11) + i3, i2, zM1189h);
            }
        }
    }
}
