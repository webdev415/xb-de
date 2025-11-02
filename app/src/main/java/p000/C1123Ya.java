package p000;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C1123Ya {

    public static final b f3333f = new b();

    public final C0325H2 f3334a;

    public boolean f3336c;

    public final InterfaceC0903Tk f3338e;

    public final List f3335b = new ArrayList<>();

    public final int[] f3337d = new int[5];

    public static final class b implements Serializable, Comparator {
        public b() {
        }

        @Override
        public int compare(C1031Wa c1031Wa, C1031Wa c1031Wa2) {
            return Float.compare(c1031Wa.m4490i(), c1031Wa2.m4490i());
        }
    }

    public C1123Ya(C0325H2 c0325h2, InterfaceC0903Tk interfaceC0903Tk) {
        this.f3334a = c0325h2;
        this.f3338e = interfaceC0903Tk;
    }

    public static float m4920a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void m4921e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void m4922f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean m4923i(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public static boolean m4924j(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    public static double m4925o(C1031Wa c1031Wa, C1031Wa c1031Wa2) {
        double dM4067c = c1031Wa.m4067c() - c1031Wa2.m4067c();
        double dM4068d = c1031Wa.m4068d() - c1031Wa2.m4068d();
        return (dM4067c * dM4067c) + (dM4068d * dM4068d);
    }

    public final boolean m4926b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] iArrM4931k = m4931k();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.f3334a.m1493e(i2 - i6, i - i6)) {
            iArrM4931k[2] = iArrM4931k[2] + 1;
            i6++;
        }
        if (iArrM4931k[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.f3334a.m1493e(i2 - i6, i - i6)) {
            iArrM4931k[1] = iArrM4931k[1] + 1;
            i6++;
        }
        if (iArrM4931k[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.f3334a.m1493e(i2 - i6, i - i6)) {
            iArrM4931k[0] = iArrM4931k[0] + 1;
            i6++;
        }
        if (iArrM4931k[0] == 0) {
            return false;
        }
        int iM1496j = this.f3334a.m1496j();
        int iM1499o = this.f3334a.m1499o();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= iM1496j || (i5 = i2 + i7) >= iM1499o || !this.f3334a.m1493e(i5, i8)) {
                break;
            }
            iArrM4931k[2] = iArrM4931k[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= iM1496j || (i4 = i2 + i7) >= iM1499o || this.f3334a.m1493e(i4, i9)) {
                break;
            }
            iArrM4931k[3] = iArrM4931k[3] + 1;
            i7++;
        }
        if (iArrM4931k[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= iM1496j || (i3 = i2 + i7) >= iM1499o || !this.f3334a.m1493e(i3, i10)) {
                break;
            }
            iArrM4931k[4] = iArrM4931k[4] + 1;
            i7++;
        }
        if (iArrM4931k[4] == 0) {
            return false;
        }
        return m4924j(iArrM4931k);
    }

    public final float m4927c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        C0325H2 c0325h2 = this.f3334a;
        int iM1499o = c0325h2.m1499o();
        int[] iArrM4931k = m4931k();
        int i8 = i;
        while (i8 >= 0 && c0325h2.m1493e(i8, i2)) {
            iArrM4931k[2] = iArrM4931k[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !c0325h2.m1493e(i8, i2)) {
            int i9 = iArrM4931k[1];
            if (i9 > i3) {
                break;
            }
            iArrM4931k[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrM4931k[1] <= i3) {
            while (i8 >= 0 && c0325h2.m1493e(i8, i2) && (i7 = iArrM4931k[0]) <= i3) {
                iArrM4931k[0] = i7 + 1;
                i8--;
            }
            if (iArrM4931k[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iM1499o && c0325h2.m1493e(i10, i2)) {
                iArrM4931k[2] = iArrM4931k[2] + 1;
                i10++;
            }
            if (i10 == iM1499o) {
                return Float.NaN;
            }
            while (i10 < iM1499o && !c0325h2.m1493e(i10, i2) && (i6 = iArrM4931k[3]) < i3) {
                iArrM4931k[3] = i6 + 1;
                i10++;
            }
            if (i10 != iM1499o && iArrM4931k[3] < i3) {
                while (i10 < iM1499o && c0325h2.m1493e(i10, i2) && (i5 = iArrM4931k[4]) < i3) {
                    iArrM4931k[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrM4931k[4];
                if (i11 < i3 && Math.abs(((((iArrM4931k[0] + iArrM4931k[1]) + iArrM4931k[2]) + iArrM4931k[3]) + i11) - i4) * 5 < i4 && m4923i(iArrM4931k)) {
                    return m4920a(iArrM4931k, i10);
                }
            }
        }
        return Float.NaN;
    }

    public final float m4928d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        C0325H2 c0325h2 = this.f3334a;
        int iM1496j = c0325h2.m1496j();
        int[] iArrM4931k = m4931k();
        int i8 = i;
        while (i8 >= 0 && c0325h2.m1493e(i2, i8)) {
            iArrM4931k[2] = iArrM4931k[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !c0325h2.m1493e(i2, i8)) {
            int i9 = iArrM4931k[1];
            if (i9 > i3) {
                break;
            }
            iArrM4931k[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && iArrM4931k[1] <= i3) {
            while (i8 >= 0 && c0325h2.m1493e(i2, i8) && (i7 = iArrM4931k[0]) <= i3) {
                iArrM4931k[0] = i7 + 1;
                i8--;
            }
            if (iArrM4931k[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < iM1496j && c0325h2.m1493e(i2, i10)) {
                iArrM4931k[2] = iArrM4931k[2] + 1;
                i10++;
            }
            if (i10 == iM1496j) {
                return Float.NaN;
            }
            while (i10 < iM1496j && !c0325h2.m1493e(i2, i10) && (i6 = iArrM4931k[3]) < i3) {
                iArrM4931k[3] = i6 + 1;
                i10++;
            }
            if (i10 != iM1496j && iArrM4931k[3] < i3) {
                while (i10 < iM1496j && c0325h2.m1493e(i2, i10) && (i5 = iArrM4931k[4]) < i3) {
                    iArrM4931k[4] = i5 + 1;
                    i10++;
                }
                int i11 = iArrM4931k[4];
                if (i11 < i3 && Math.abs(((((iArrM4931k[0] + iArrM4931k[1]) + iArrM4931k[2]) + iArrM4931k[3]) + i11) - i4) * 5 < i4 * 2 && m4923i(iArrM4931k)) {
                    return m4920a(iArrM4931k, i10);
                }
            }
        }
        return Float.NaN;
    }

    public final C1169Za m4929g(Map map) throws C2340sh {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int iM1496j = this.f3334a.m1496j();
        int iM1499o = this.f3334a.m1499o();
        int i = (iM1496j * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zM4933m = false;
        while (i2 < iM1496j && !zM4933m) {
            m4921e(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < iM1499o) {
                if (this.f3334a.m1493e(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 != 4) {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                } else if (m4923i(iArr) && m4932l(iArr, i2, i3)) {
                    if (this.f3336c) {
                        zM4933m = m4933m();
                    } else {
                        int iM4930h = m4930h();
                        int i5 = iArr[2];
                        if (iM4930h > i5) {
                            i2 += (iM4930h - i5) - 2;
                            i3 = iM1499o - 1;
                        }
                    }
                    m4921e(iArr);
                    i = 2;
                    i4 = 0;
                } else {
                    m4922f(iArr);
                    i4 = 3;
                }
                i3++;
            }
            if (m4923i(iArr) && m4932l(iArr, i2, iM1499o)) {
                i = iArr[0];
                if (this.f3336c) {
                    zM4933m = m4933m();
                }
            }
            i2 += i;
        }
        C1031Wa[] c1031WaArrM4934n = m4934n();
        C0857Sk.m4066e(c1031WaArrM4934n);
        return new C1169Za(c1031WaArrM4934n);
    }

    public final int m4930h() {
        if (this.f3335b.size() <= 1) {
            return 0;
        }
        C1031Wa c1031Wa = null;
        for (C1031Wa c1031Wa2 : this.f3335b) {
            if (c1031Wa2.m4489h() >= 2) {
                if (c1031Wa != null) {
                    this.f3336c = true;
                    return ((int) (Math.abs(c1031Wa.m4067c() - c1031Wa2.m4067c()) - Math.abs(c1031Wa.m4068d() - c1031Wa2.m4068d()))) / 2;
                }
                c1031Wa = c1031Wa2;
            }
        }
        return 0;
    }

    public final int[] m4931k() {
        m4921e(this.f3337d);
        return this.f3337d;
    }

    public final boolean m4932l(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iM4920a = (int) m4920a(iArr, i2);
        float fM4928d = m4928d(i, iM4920a, iArr[2], i4);
        if (!Float.isNaN(fM4928d)) {
            int i5 = (int) fM4928d;
            float fM4927c = m4927c(iM4920a, i5, iArr[2], i4);
            if (!Float.isNaN(fM4927c) && m4926b(i5, (int) fM4927c)) {
                float f = i4 / 7.0f;
                while (true) {
                    if (i3 < this.f3335b.size()) {
                        C1031Wa c1031Wa = (C1031Wa) this.f3335b.get(i3);
                        if (c1031Wa.m4487f(f, fM4928d, fM4927c)) {
                            this.f3335b.set(i3, c1031Wa.m4488g(fM4928d, fM4927c, f));
                            break;
                        }
                        i3++;
                    } else {
                        C1031Wa c1031Wa2 = new C1031Wa(fM4927c, fM4928d, f);
                        this.f3335b.add(c1031Wa2);
                        InterfaceC0903Tk interfaceC0903Tk = this.f3338e;
                        if (interfaceC0903Tk != null) {
                            interfaceC0903Tk.mo3293a(c1031Wa2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean m4933m() {
        int size = this.f3335b.size();
        float fAbs = 0.0f;
        int i = 0;
        float fM4490i = 0.0f;
        for (C1031Wa c1031Wa : this.f3335b) {
            if (c1031Wa.m4489h() >= 2) {
                i++;
                fM4490i += c1031Wa.m4490i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = fM4490i / size;
        Iterator it = this.f3335b.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(((C1031Wa) it.next()).m4490i() - f);
        }
        return fAbs <= fM4490i * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C1031Wa[] m4934n() throws C2340sh {
        /*
            r26 = this;
            r0 = r26
            java.util.List r1 = r0.f3335b
            int r1 = r1.size()
            r2 = 3
            if (r1 < r2) goto Ld8
            java.util.List r1 = r0.f3335b
            Ya$b r3 = p000.C1123Ya.f3333f
            r1.sort(r3)
            Wa[] r1 = new p000.C1031Wa[r2]
            r2 = 0
            r5 = r2
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L1b:
            java.util.List r8 = r0.f3335b
            int r8 = r8.size()
            r9 = 2
            int r8 = r8 - r9
            if (r5 >= r8) goto Lc9
            java.util.List r8 = r0.f3335b
            java.lang.Object r8 = r8.get(r5)
            Wa r8 = (p000.C1031Wa) r8
            float r10 = r8.m4490i()
            int r5 = r5 + 1
            r11 = r5
        L34:
            java.util.List r12 = r0.f3335b
            int r12 = r12.size()
            r13 = 1
            int r12 = r12 - r13
            if (r11 >= r12) goto L1b
            java.util.List r12 = r0.f3335b
            java.lang.Object r12 = r12.get(r11)
            Wa r12 = (p000.C1031Wa) r12
            double r14 = m4925o(r8, r12)
            int r11 = r11 + 1
            r3 = r11
        L4d:
            java.util.List r4 = r0.f3335b
            int r4 = r4.size()
            if (r3 >= r4) goto L34
            java.util.List r4 = r0.f3335b
            java.lang.Object r4 = r4.get(r3)
            Wa r4 = (p000.C1031Wa) r4
            float r16 = r4.m4490i()
            r17 = 1068708659(0x3fb33333, float:1.4)
            float r17 = r17 * r10
            int r16 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r16 > 0) goto Lc6
            double r16 = m4925o(r12, r4)
            double r18 = m4925o(r8, r4)
            int r20 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r20 >= 0) goto L8f
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L86
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L81
            r20 = r14
            goto La6
        L81:
            r20 = r18
        L83:
            r18 = r14
            goto La6
        L86:
            r20 = r14
            r24 = r16
            r16 = r18
            r18 = r24
            goto La6
        L8f:
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto La1
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9c
            r20 = r16
            r16 = r18
            goto L83
        L9c:
            r20 = r16
        L9e:
            r16 = r14
            goto La6
        La1:
            r20 = r18
            r18 = r16
            goto L9e
        La6:
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r18 * r22
            double r18 = r16 - r18
            double r18 = java.lang.Math.abs(r18)
            double r20 = r20 * r22
            double r16 = r16 - r20
            double r16 = java.lang.Math.abs(r16)
            double r18 = r18 + r16
            int r16 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r16 >= 0) goto Lc6
            r1[r2] = r8
            r1[r13] = r12
            r1[r9] = r4
            r6 = r18
        Lc6:
            int r3 = r3 + 1
            goto L4d
        Lc9:
            r3 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto Ld3
            return r1
        Ld3:
            sh r1 = p000.C2340sh.m9579a()
            throw r1
        Ld8:
            sh r1 = p000.C2340sh.m9579a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1123Ya.m4934n():Wa[]");
    }
}
