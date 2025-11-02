package p000;

/* loaded from: classes.dex */
public final class C0515L8 {

    public final C0325H2 f1691a;

    public final C0953Uo f1692b;

    public C0515L8(C0325H2 c0325h2) {
        this.f1691a = c0325h2;
        this.f1692b = new C0953Uo(c0325h2);
    }

    public static C0857Sk m2633f(C0857Sk c0857Sk, float f, float f2) {
        float fM4067c = c0857Sk.m4067c();
        float fM4068d = c0857Sk.m4068d();
        return new C0857Sk(fM4067c < f ? fM4067c - 1.0f : fM4067c + 1.0f, fM4068d < f2 ? fM4068d - 1.0f : fM4068d + 1.0f);
    }

    public static C0325H2 m2634g(C0325H2 c0325h2, C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4, int i, int i2) {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return AbstractC0574Mc.m2857b().mo2858c(c0325h2, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, c0857Sk.m4067c(), c0857Sk.m4068d(), c0857Sk4.m4067c(), c0857Sk4.m4068d(), c0857Sk3.m4067c(), c0857Sk3.m4068d(), c0857Sk2.m4067c(), c0857Sk2.m4068d());
    }

    public static C0857Sk m2635h(C0857Sk c0857Sk, C0857Sk c0857Sk2, int i) {
        float f = i + 1;
        return new C0857Sk(c0857Sk.m4067c() + ((c0857Sk2.m4067c() - c0857Sk.m4067c()) / f), c0857Sk.m4068d() + ((c0857Sk2.m4068d() - c0857Sk.m4068d()) / f));
    }

    public final C0857Sk m2636a(C0857Sk[] c0857SkArr) {
        C0857Sk c0857Sk = c0857SkArr[0];
        C0857Sk c0857Sk2 = c0857SkArr[1];
        C0857Sk c0857Sk3 = c0857SkArr[2];
        C0857Sk c0857Sk4 = c0857SkArr[3];
        int iM2642j = m2642j(c0857Sk, c0857Sk4);
        C0857Sk c0857SkM2635h = m2635h(c0857Sk, c0857Sk2, (m2642j(c0857Sk2, c0857Sk4) + 1) << 2);
        C0857Sk c0857SkM2635h2 = m2635h(c0857Sk3, c0857Sk2, (iM2642j + 1) << 2);
        int iM2642j2 = m2642j(c0857SkM2635h, c0857Sk4);
        int iM2642j3 = m2642j(c0857SkM2635h2, c0857Sk4);
        float f = iM2642j2 + 1;
        C0857Sk c0857Sk5 = new C0857Sk(c0857Sk4.m4067c() + ((c0857Sk3.m4067c() - c0857Sk2.m4067c()) / f), c0857Sk4.m4068d() + ((c0857Sk3.m4068d() - c0857Sk2.m4068d()) / f));
        float f2 = iM2642j3 + 1;
        C0857Sk c0857Sk6 = new C0857Sk(c0857Sk4.m4067c() + ((c0857Sk.m4067c() - c0857Sk2.m4067c()) / f2), c0857Sk4.m4068d() + ((c0857Sk.m4068d() - c0857Sk2.m4068d()) / f2));
        if (m2640e(c0857Sk5)) {
            return (m2640e(c0857Sk6) && m2642j(c0857SkM2635h, c0857Sk5) + m2642j(c0857SkM2635h2, c0857Sk5) <= m2642j(c0857SkM2635h, c0857Sk6) + m2642j(c0857SkM2635h2, c0857Sk6)) ? c0857Sk6 : c0857Sk5;
        }
        if (m2640e(c0857Sk6)) {
            return c0857Sk6;
        }
        return null;
    }

    public C0653O8 m2637b() throws C2340sh {
        int iMax;
        int i;
        C0857Sk[] c0857SkArrM2639d = m2639d(m2638c(this.f1692b.m4291c()));
        C0857Sk c0857SkM2636a = m2636a(c0857SkArrM2639d);
        c0857SkArrM2639d[3] = c0857SkM2636a;
        if (c0857SkM2636a == null) {
            throw C2340sh.m9579a();
        }
        C0857Sk[] c0857SkArrM2641i = m2641i(c0857SkArrM2639d);
        C0857Sk c0857Sk = c0857SkArrM2641i[0];
        C0857Sk c0857Sk2 = c0857SkArrM2641i[1];
        C0857Sk c0857Sk3 = c0857SkArrM2641i[2];
        C0857Sk c0857Sk4 = c0857SkArrM2641i[3];
        int iM2642j = m2642j(c0857Sk, c0857Sk4);
        int i2 = iM2642j + 1;
        int iM2642j2 = m2642j(c0857Sk3, c0857Sk4);
        int i3 = iM2642j2 + 1;
        if ((i2 & 1) == 1) {
            i2 = iM2642j + 2;
        }
        if ((i3 & 1) == 1) {
            i3 = iM2642j2 + 2;
        }
        if (i2 * 4 >= i3 * 7 || i3 * 4 >= i2 * 7) {
            iMax = i2;
            i = i3;
        } else {
            iMax = Math.max(i2, i3);
            i = iMax;
        }
        return new C0653O8(m2634g(this.f1691a, c0857Sk, c0857Sk2, c0857Sk3, c0857Sk4, iMax, i), new C0857Sk[]{c0857Sk, c0857Sk2, c0857Sk3, c0857Sk4});
    }

    public final C0857Sk[] m2638c(C0857Sk[] c0857SkArr) {
        C0857Sk c0857Sk = c0857SkArr[0];
        C0857Sk c0857Sk2 = c0857SkArr[1];
        C0857Sk c0857Sk3 = c0857SkArr[3];
        C0857Sk c0857Sk4 = c0857SkArr[2];
        int iM2642j = m2642j(c0857Sk, c0857Sk2);
        int iM2642j2 = m2642j(c0857Sk2, c0857Sk3);
        int iM2642j3 = m2642j(c0857Sk3, c0857Sk4);
        int iM2642j4 = m2642j(c0857Sk4, c0857Sk);
        C0857Sk[] c0857SkArr2 = {c0857Sk4, c0857Sk, c0857Sk2, c0857Sk3};
        if (iM2642j > iM2642j2) {
            c0857SkArr2[0] = c0857Sk;
            c0857SkArr2[1] = c0857Sk2;
            c0857SkArr2[2] = c0857Sk3;
            c0857SkArr2[3] = c0857Sk4;
            iM2642j = iM2642j2;
        }
        if (iM2642j > iM2642j3) {
            c0857SkArr2[0] = c0857Sk2;
            c0857SkArr2[1] = c0857Sk3;
            c0857SkArr2[2] = c0857Sk4;
            c0857SkArr2[3] = c0857Sk;
        } else {
            iM2642j3 = iM2642j;
        }
        if (iM2642j3 > iM2642j4) {
            c0857SkArr2[0] = c0857Sk3;
            c0857SkArr2[1] = c0857Sk4;
            c0857SkArr2[2] = c0857Sk;
            c0857SkArr2[3] = c0857Sk2;
        }
        return c0857SkArr2;
    }

    public final C0857Sk[] m2639d(C0857Sk[] c0857SkArr) {
        C0857Sk c0857Sk = c0857SkArr[0];
        C0857Sk c0857Sk2 = c0857SkArr[1];
        C0857Sk c0857Sk3 = c0857SkArr[2];
        C0857Sk c0857Sk4 = c0857SkArr[3];
        int iM2642j = (m2642j(c0857Sk, c0857Sk4) + 1) << 2;
        if (m2642j(m2635h(c0857Sk2, c0857Sk3, iM2642j), c0857Sk) < m2642j(m2635h(c0857Sk3, c0857Sk2, iM2642j), c0857Sk4)) {
            c0857SkArr[0] = c0857Sk;
            c0857SkArr[1] = c0857Sk2;
            c0857SkArr[2] = c0857Sk3;
            c0857SkArr[3] = c0857Sk4;
        } else {
            c0857SkArr[0] = c0857Sk2;
            c0857SkArr[1] = c0857Sk3;
            c0857SkArr[2] = c0857Sk4;
            c0857SkArr[3] = c0857Sk;
        }
        return c0857SkArr;
    }

    public final boolean m2640e(C0857Sk c0857Sk) {
        return c0857Sk.m4067c() >= 0.0f && c0857Sk.m4067c() < ((float) this.f1691a.m1499o()) && c0857Sk.m4068d() > 0.0f && c0857Sk.m4068d() < ((float) this.f1691a.m1496j());
    }

    public final C0857Sk[] m2641i(C0857Sk[] c0857SkArr) {
        C0857Sk c0857Sk = c0857SkArr[0];
        C0857Sk c0857Sk2 = c0857SkArr[1];
        C0857Sk c0857Sk3 = c0857SkArr[2];
        C0857Sk c0857Sk4 = c0857SkArr[3];
        int iM2642j = m2642j(c0857Sk, c0857Sk4) + 1;
        C0857Sk c0857SkM2635h = m2635h(c0857Sk, c0857Sk2, (m2642j(c0857Sk3, c0857Sk4) + 1) << 2);
        C0857Sk c0857SkM2635h2 = m2635h(c0857Sk3, c0857Sk2, iM2642j << 2);
        int iM2642j2 = m2642j(c0857SkM2635h, c0857Sk4);
        int i = iM2642j2 + 1;
        int iM2642j3 = m2642j(c0857SkM2635h2, c0857Sk4);
        int i2 = iM2642j3 + 1;
        if ((i & 1) == 1) {
            i = iM2642j2 + 2;
        }
        if ((i2 & 1) == 1) {
            i2 = iM2642j3 + 2;
        }
        float fM4067c = (((c0857Sk.m4067c() + c0857Sk2.m4067c()) + c0857Sk3.m4067c()) + c0857Sk4.m4067c()) / 4.0f;
        float fM4068d = (((c0857Sk.m4068d() + c0857Sk2.m4068d()) + c0857Sk3.m4068d()) + c0857Sk4.m4068d()) / 4.0f;
        C0857Sk c0857SkM2633f = m2633f(c0857Sk, fM4067c, fM4068d);
        C0857Sk c0857SkM2633f2 = m2633f(c0857Sk2, fM4067c, fM4068d);
        C0857Sk c0857SkM2633f3 = m2633f(c0857Sk3, fM4067c, fM4068d);
        C0857Sk c0857SkM2633f4 = m2633f(c0857Sk4, fM4067c, fM4068d);
        int i3 = i2 << 2;
        int i4 = i << 2;
        return new C0857Sk[]{m2635h(m2635h(c0857SkM2633f, c0857SkM2633f2, i3), c0857SkM2633f4, i4), m2635h(m2635h(c0857SkM2633f2, c0857SkM2633f, i3), c0857SkM2633f3, i4), m2635h(m2635h(c0857SkM2633f3, c0857SkM2633f4, i3), c0857SkM2633f2, i4), m2635h(m2635h(c0857SkM2633f4, c0857SkM2633f3, i3), c0857SkM2633f, i4)};
    }

    public final int m2642j(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        int iM4067c = (int) c0857Sk.m4067c();
        int iM4068d = (int) c0857Sk.m4068d();
        int iM4067c2 = (int) c0857Sk2.m4067c();
        int iM4068d2 = (int) c0857Sk2.m4068d();
        int i = 0;
        boolean z = Math.abs(iM4068d2 - iM4068d) > Math.abs(iM4067c2 - iM4067c);
        if (z) {
            iM4068d = iM4067c;
            iM4067c = iM4068d;
            iM4068d2 = iM4067c2;
            iM4067c2 = iM4068d2;
        }
        int iAbs = Math.abs(iM4067c2 - iM4067c);
        int iAbs2 = Math.abs(iM4068d2 - iM4068d);
        int i2 = (-iAbs) / 2;
        int i3 = iM4068d < iM4068d2 ? 1 : -1;
        int i4 = iM4067c >= iM4067c2 ? -1 : 1;
        boolean zM1493e = this.f1691a.m1493e(z ? iM4068d : iM4067c, z ? iM4067c : iM4068d);
        while (iM4067c != iM4067c2) {
            boolean zM1493e2 = this.f1691a.m1493e(z ? iM4068d : iM4067c, z ? iM4067c : iM4068d);
            if (zM1493e2 != zM1493e) {
                i++;
                zM1493e = zM1493e2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iM4068d == iM4068d2) {
                    break;
                }
                iM4068d += i3;
                i2 -= iAbs;
            }
            iM4067c += i4;
        }
        return i;
    }
}
