package p000;

import java.util.Map;

/* loaded from: classes.dex */
public class C0607N8 {

    public final C0325H2 f1909a;

    public InterfaceC0903Tk f1910b;

    public C0607N8(C0325H2 c0325h2) {
        this.f1909a = c0325h2;
    }

    public static int m3297c(C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, float f) throws C2340sh {
        int iM10356c = (AbstractC2477vg.m10356c(C0857Sk.m4065b(c0857Sk, c0857Sk2) / f) + AbstractC2477vg.m10356c(C0857Sk.m4065b(c0857Sk, c0857Sk3) / f)) / 2;
        int i = iM10356c + 7;
        int i2 = i & 3;
        if (i2 == 0) {
            return iM10356c + 8;
        }
        if (i2 == 2) {
            return iM10356c + 6;
        }
        if (i2 != 3) {
            return i;
        }
        throw C2340sh.m9579a();
    }

    public static C0626Ni m3298d(C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4, int i) {
        float fM4067c;
        float fM4068d;
        float f;
        float f2 = i - 3.5f;
        if (c0857Sk4 != null) {
            fM4067c = c0857Sk4.m4067c();
            fM4068d = c0857Sk4.m4068d();
            f = f2 - 3.0f;
        } else {
            fM4067c = (c0857Sk2.m4067c() - c0857Sk.m4067c()) + c0857Sk3.m4067c();
            fM4068d = (c0857Sk2.m4068d() - c0857Sk.m4068d()) + c0857Sk3.m4068d();
            f = f2;
        }
        return C0626Ni.m3323b(3.5f, 3.5f, f2, 3.5f, f, f, 3.5f, f2, c0857Sk.m4067c(), c0857Sk.m4068d(), c0857Sk2.m4067c(), c0857Sk2.m4068d(), fM4067c, fM4068d, c0857Sk3.m4067c(), c0857Sk3.m4068d());
    }

    public static C0325H2 m3299h(C0325H2 c0325h2, C0626Ni c0626Ni, int i) {
        return AbstractC0574Mc.m2857b().mo2859d(c0325h2, i, i, c0626Ni);
    }

    public final float m3300a(C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3) {
        return (m3301b(c0857Sk, c0857Sk2) + m3301b(c0857Sk, c0857Sk3)) / 2.0f;
    }

    public final float m3301b(C0857Sk c0857Sk, C0857Sk c0857Sk2) {
        float fM3306j = m3306j((int) c0857Sk.m4067c(), (int) c0857Sk.m4068d(), (int) c0857Sk2.m4067c(), (int) c0857Sk2.m4068d());
        float fM3306j2 = m3306j((int) c0857Sk2.m4067c(), (int) c0857Sk2.m4068d(), (int) c0857Sk.m4067c(), (int) c0857Sk.m4068d());
        return Float.isNaN(fM3306j) ? fM3306j2 / 7.0f : Float.isNaN(fM3306j2) ? fM3306j / 7.0f : (fM3306j + fM3306j2) / 14.0f;
    }

    public final C0653O8 m3302e(Map map) {
        this.f1910b = map == null ? null : (InterfaceC0903Tk) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
        return m3304g(new C1123Ya(this.f1909a, this.f1910b).m4929g(map));
    }

    public final C0001A0 m3303f(float f, int i, int i2, float f2) throws C2340sh {
        int i3 = (int) (f2 * f);
        int iMax = Math.max(0, i - i3);
        int iMin = Math.min(this.f1909a.m1499o() - 1, i + i3) - iMax;
        float f3 = 3.0f * f;
        if (iMin < f3) {
            throw C2340sh.m9579a();
        }
        int iMax2 = Math.max(0, i2 - i3);
        int iMin2 = Math.min(this.f1909a.m1496j() - 1, i2 + i3) - iMax2;
        if (iMin2 >= f3) {
            return new C0047B0(this.f1909a, iMax, iMax2, iMin, iMin2, f, this.f1910b).m178c();
        }
        throw C2340sh.m9579a();
    }

    public final C0653O8 m3304g(C1169Za c1169Za) throws C2340sh, C2610yb {
        C0001A0 c0001a0M3303f;
        C1031Wa c1031WaM5036b = c1169Za.m5036b();
        C1031Wa c1031WaM5037c = c1169Za.m5037c();
        C1031Wa c1031WaM5035a = c1169Za.m5035a();
        float fM3300a = m3300a(c1031WaM5036b, c1031WaM5037c, c1031WaM5035a);
        if (fM3300a < 1.0f) {
            throw C2340sh.m9579a();
        }
        int iM3297c = m3297c(c1031WaM5036b, c1031WaM5037c, c1031WaM5035a, fM3300a);
        C0126Co c0126CoM512g = C0126Co.m512g(iM3297c);
        int iM516e = c0126CoM512g.m516e() - 7;
        if (c0126CoM512g.m515d().length > 0) {
            float fM4067c = (c1031WaM5037c.m4067c() - c1031WaM5036b.m4067c()) + c1031WaM5035a.m4067c();
            float fM4068d = (c1031WaM5037c.m4068d() - c1031WaM5036b.m4068d()) + c1031WaM5035a.m4068d();
            float f = 1.0f - (3.0f / iM516e);
            int iM4067c = (int) (c1031WaM5036b.m4067c() + ((fM4067c - c1031WaM5036b.m4067c()) * f));
            int iM4068d = (int) (c1031WaM5036b.m4068d() + (f * (fM4068d - c1031WaM5036b.m4068d())));
            for (int i = 4; i <= 16; i <<= 1) {
                try {
                    c0001a0M3303f = m3303f(fM3300a, iM4067c, iM4068d, i);
                    break;
                } catch (C2340sh unused) {
                }
            }
            c0001a0M3303f = null;
        } else {
            c0001a0M3303f = null;
        }
        return new C0653O8(m3299h(this.f1909a, m3298d(c1031WaM5036b, c1031WaM5037c, c1031WaM5035a, c0001a0M3303f, iM3297c), iM3297c), c0001a0M3303f == null ? new C0857Sk[]{c1031WaM5035a, c1031WaM5036b, c1031WaM5037c} : new C0857Sk[]{c1031WaM5035a, c1031WaM5036b, c1031WaM5037c, c0001a0M3303f});
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0087, code lost:
    
        if (r15 != r0) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x008f, code lost:
    
        return p000.AbstractC2477vg.m10355b(r19, r6, r1, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0090, code lost:
    
        return Float.NaN;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final float m3305i(int r18, int r19, int r20, int r21) {
        /*
            r17 = this;
            int r0 = r21 - r19
            int r0 = java.lang.Math.abs(r0)
            int r1 = r20 - r18
            int r1 = java.lang.Math.abs(r1)
            r3 = 1
            if (r0 <= r1) goto L11
            r0 = r3
            goto L12
        L11:
            r0 = 0
        L12:
            if (r0 == 0) goto L1d
            r4 = r18
            r1 = r19
            r6 = r20
            r5 = r21
            goto L25
        L1d:
            r1 = r18
            r4 = r19
            r5 = r20
            r6 = r21
        L25:
            int r7 = r5 - r1
            int r7 = java.lang.Math.abs(r7)
            int r8 = r6 - r4
            int r8 = java.lang.Math.abs(r8)
            int r9 = -r7
            r10 = 2
            int r9 = r9 / r10
            r11 = -1
            if (r1 >= r5) goto L39
            r12 = r3
            goto L3a
        L39:
            r12 = r11
        L3a:
            if (r4 >= r6) goto L3d
            r11 = r3
        L3d:
            int r5 = r5 + r12
            r13 = r1
            r14 = r4
            r15 = 0
        L41:
            if (r13 == r5) goto L82
            if (r0 == 0) goto L47
            r2 = r14
            goto L48
        L47:
            r2 = r13
        L48:
            if (r0 == 0) goto L4c
            r10 = r13
            goto L4d
        L4c:
            r10 = r14
        L4d:
            if (r15 != r3) goto L57
            r16 = r0
            r0 = r3
            r19 = r5
            r3 = r17
            goto L5e
        L57:
            r3 = r17
            r16 = r0
            r19 = r5
            r0 = 0
        L5e:
            H2 r5 = r3.f1909a
            boolean r2 = r5.m1493e(r2, r10)
            if (r0 != r2) goto L70
            r0 = 2
            if (r15 != r0) goto L6e
            float r0 = p000.AbstractC2477vg.m10355b(r13, r14, r1, r4)
            return r0
        L6e:
            int r15 = r15 + 1
        L70:
            int r9 = r9 + r8
            if (r9 <= 0) goto L7a
            if (r14 == r6) goto L78
            int r14 = r14 + r11
            int r9 = r9 - r7
            goto L7a
        L78:
            r0 = 2
            goto L87
        L7a:
            int r13 = r13 + r12
            r5 = r19
            r0 = r16
            r3 = 1
            r10 = 2
            goto L41
        L82:
            r3 = r17
            r19 = r5
            r0 = r10
        L87:
            if (r15 != r0) goto L90
            r5 = r19
            float r0 = p000.AbstractC2477vg.m10355b(r5, r6, r1, r4)
            return r0
        L90:
            r0 = 2143289344(0x7fc00000, float:NaN)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0607N8.m3305i(int, int, int, int):float");
    }

    public final float m3306j(int i, int i2, int i3, int i4) {
        float fM1499o;
        float fM1496j;
        float fM3305i = m3305i(i, i2, i3, i4);
        int iM1499o = i - (i3 - i);
        int iM1496j = 0;
        if (iM1499o < 0) {
            fM1499o = i / (i - iM1499o);
            iM1499o = 0;
        } else if (iM1499o >= this.f1909a.m1499o()) {
            fM1499o = ((this.f1909a.m1499o() - 1) - i) / (iM1499o - i);
            iM1499o = this.f1909a.m1499o() - 1;
        } else {
            fM1499o = 1.0f;
        }
        float f = i2;
        int i5 = (int) (f - ((i4 - i2) * fM1499o));
        if (i5 < 0) {
            fM1496j = f / (i2 - i5);
        } else if (i5 >= this.f1909a.m1496j()) {
            fM1496j = ((this.f1909a.m1496j() - 1) - i2) / (i5 - i2);
            iM1496j = this.f1909a.m1496j() - 1;
        } else {
            iM1496j = i5;
            fM1496j = 1.0f;
        }
        return (fM3305i + m3305i(i, i2, (int) (i + ((iM1499o - i) * fM1496j)), iM1496j)) - 1.0f;
    }
}
