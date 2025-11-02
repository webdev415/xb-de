package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class C0856Sj extends AbstractC0414J {

    public static final int[] f2650i = {1, 10, 34, 70, 126};

    public static final int[] f2651j = {4, 20, 48, 81};

    public static final int[] f2652k = {0, 161, 961, 2015, 2715};

    public static final int[] f2653l = {0, 336, 1036, 1516};

    public static final int[] f2654m = {8, 6, 4, 3, 1};

    public static final int[] f2655n = {2, 4, 6, 8};

    public static final int[][] f2656o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};

    public final List f2657g = new ArrayList<>();

    public final List f2658h = new ArrayList<>();

    public static void m4056s(Collection collection, C0304Gi c0304Gi) {
        if (c0304Gi == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0304Gi c0304Gi2 = (C0304Gi) it.next();
            if (c0304Gi2.m7871b() == c0304Gi.m7871b()) {
                c0304Gi2.m1402e();
                return;
            }
        }
        collection.add(c0304Gi);
    }

    public static boolean m4057u(C0304Gi c0304Gi, C0304Gi c0304Gi2) {
        int iM7870a = (c0304Gi.m7870a() + (c0304Gi2.m7870a() * 16)) % 79;
        int iM4736c = (c0304Gi.m1401d().m4736c() * 9) + c0304Gi2.m1401d().m4736c();
        if (iM4736c > 72) {
            iM4736c--;
        }
        if (iM4736c > 8) {
            iM4736c--;
        }
        return iM7870a == iM4736c;
    }

    public static C0720Pk m4058v(C0304Gi c0304Gi, C0304Gi c0304Gi2) {
        String strValueOf = String.valueOf((c0304Gi.m7871b() * 4537077) + c0304Gi2.m7871b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - strValueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(strValueOf);
        int i = 0;
        for (int i2 = 0; i2 < 13; i2++) {
            int iCharAt = sb.charAt(i2) - '0';
            if ((i2 & 1) == 0) {
                iCharAt *= 3;
            }
            i += iCharAt;
        }
        int i3 = 10 - (i % 10);
        if (i3 == 10) {
            i3 = 0;
        }
        sb.append(i3);
        C0857Sk[] c0857SkArrM4734a = c0304Gi.m1401d().m4734a();
        C0857Sk[] c0857SkArrM4734a2 = c0304Gi2.m1401d().m4734a();
        return new C0720Pk(sb.toString(), null, new C0857Sk[]{c0857SkArrM4734a[0], c0857SkArrM4734a[1], c0857SkArrM4734a2[0], c0857SkArrM4734a2[1]}, BarcodeFormat.RSS_14);
    }

    @Override
    public void mo140c() {
        this.f2657g.clear();
        this.f2658h.clear();
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) throws C2340sh {
        m4056s(this.f2657g, m4061x(c0233f2, false, i, map));
        c0233f2.m1196t();
        m4056s(this.f2658h, m4061x(c0233f2, true, i, map));
        c0233f2.m1196t();
        for (C0304Gi c0304Gi : this.f2657g) {
            if (c0304Gi.m1400c() > 1) {
                for (C0304Gi c0304Gi2 : this.f2658h) {
                    if (c0304Gi2.m1400c() > 1 && m4057u(c0304Gi, c0304Gi2)) {
                        return m4058v(c0304Gi, c0304Gi2);
                    }
                }
            }
        }
        throw C2340sh.m9579a();
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[PHI: r6 r7
  0x002a: PHI (r6v5 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002a: PHI (r7v5 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[PHI: r6 r7
  0x002d: PHI (r6v4 boolean) = (r6v2 boolean), (r6v10 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]
  0x002d: PHI (r7v4 boolean) = (r7v2 boolean), (r7v14 boolean) binds: [B:25:0x0044, B:12:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4059t(boolean r10, int r11) throws C2340sh {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0856Sj.m4059t(boolean, int):void");
    }

    public final C1859i7 m4060w(C0233F2 c0233f2, C1077Xa c1077Xa, boolean z) throws C2340sh {
        int[] iArrM1767j = m1767j();
        Arrays.fill(iArrM1767j, 0);
        int[] iArrM4735b = c1077Xa.m4735b();
        if (z) {
            AbstractC0946Uh.m4265h(c0233f2, iArrM4735b[0], iArrM1767j);
        } else {
            AbstractC0946Uh.m4264g(c0233f2, iArrM4735b[1], iArrM1767j);
            int i = 0;
            for (int length = iArrM1767j.length - 1; i < length; length--) {
                int i2 = iArrM1767j[i];
                iArrM1767j[i] = iArrM1767j[length];
                iArrM1767j[length] = i2;
                i++;
            }
        }
        int i3 = z ? 16 : 15;
        float fM10357d = AbstractC2477vg.m10357d(iArrM1767j) / i3;
        int[] iArrM1771n = m1771n();
        int[] iArrM1769l = m1769l();
        float[] fArrM1772o = m1772o();
        float[] fArrM1770m = m1770m();
        for (int i4 = 0; i4 < iArrM1767j.length; i4++) {
            float f = iArrM1767j[i4] / fM10357d;
            int i5 = (int) (0.5f + f);
            if (i5 <= 0) {
                i5 = 1;
            } else if (i5 > 8) {
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                iArrM1771n[i6] = i5;
                fArrM1772o[i6] = f - i5;
            } else {
                iArrM1769l[i6] = i5;
                fArrM1770m[i6] = f - i5;
            }
        }
        m4059t(z, i3);
        int i7 = 0;
        int i8 = 0;
        for (int length2 = iArrM1771n.length - 1; length2 >= 0; length2--) {
            int i9 = iArrM1771n[length2];
            i7 = (i7 * 9) + i9;
            i8 += i9;
        }
        int i10 = 0;
        int i11 = 0;
        for (int length3 = iArrM1769l.length - 1; length3 >= 0; length3--) {
            int i12 = iArrM1769l[length3];
            i10 = (i10 * 9) + i12;
            i11 += i12;
        }
        int i13 = i7 + (i10 * 3);
        if (!z) {
            if ((i11 & 1) != 0 || i11 > 10 || i11 < 4) {
                throw C2340sh.m9579a();
            }
            int i14 = (10 - i11) / 2;
            int i15 = f2655n[i14];
            return new C1859i7((AbstractC0948Uj.m4268b(iArrM1769l, 9 - i15, false) * f2651j[i14]) + AbstractC0948Uj.m4268b(iArrM1771n, i15, true) + f2653l[i14], i13);
        }
        if ((i8 & 1) != 0 || i8 > 12 || i8 < 4) {
            throw C2340sh.m9579a();
        }
        int i16 = (12 - i8) / 2;
        int i17 = f2654m[i16];
        return new C1859i7((AbstractC0948Uj.m4268b(iArrM1771n, i17, false) * f2650i[i16]) + AbstractC0948Uj.m4268b(iArrM1769l, 9 - i17, true) + f2652k[i16], i13);
    }

    public final C0304Gi m4061x(C0233F2 c0233f2, boolean z, int i, Map map) {
        try {
            C1077Xa c1077XaM4063z = m4063z(c0233f2, i, z, m4062y(c0233f2, z));
            InterfaceC0903Tk interfaceC0903Tk = map == null ? null : (InterfaceC0903Tk) map.get(DecodeHintType.NEED_RESULT_POINT_CALLBACK);
            if (interfaceC0903Tk != null) {
                int[] iArrM4735b = c1077XaM4063z.m4735b();
                float fM1193o = ((iArrM4735b[0] + iArrM4735b[1]) - 1) / 2.0f;
                if (z) {
                    fM1193o = (c0233f2.m1193o() - 1) - fM1193o;
                }
                interfaceC0903Tk.mo3293a(new C0857Sk(fM1193o, i));
            }
            C1859i7 c1859i7M4060w = m4060w(c0233f2, c1077XaM4063z, true);
            C1859i7 c1859i7M4060w2 = m4060w(c0233f2, c1077XaM4063z, false);
            return new C0304Gi((c1859i7M4060w.m7871b() * 1597) + c1859i7M4060w2.m7871b(), c1859i7M4060w.m7870a() + (c1859i7M4060w2.m7870a() * 4), c1077XaM4063z);
        } catch (C2340sh unused) {
            return null;
        }
    }

    public final int[] m4062y(C0233F2 c0233f2, boolean z) throws C2340sh {
        int[] iArrM1768k = m1768k();
        iArrM1768k[0] = 0;
        iArrM1768k[1] = 0;
        iArrM1768k[2] = 0;
        iArrM1768k[3] = 0;
        int iM1193o = c0233f2.m1193o();
        int i = 0;
        boolean z2 = false;
        while (i < iM1193o) {
            z2 = !c0233f2.m1189h(i);
            if (z == z2) {
                break;
            }
            i++;
        }
        int i2 = 0;
        int i3 = i;
        while (i < iM1193o) {
            if (c0233f2.m1189h(i) != z2) {
                iArrM1768k[i2] = iArrM1768k[i2] + 1;
            } else {
                if (i2 != 3) {
                    i2++;
                } else {
                    if (AbstractC0414J.m1765q(iArrM1768k)) {
                        return new int[]{i3, i};
                    }
                    i3 += iArrM1768k[0] + iArrM1768k[1];
                    iArrM1768k[0] = iArrM1768k[2];
                    iArrM1768k[1] = iArrM1768k[3];
                    iArrM1768k[2] = 0;
                    iArrM1768k[3] = 0;
                    i2--;
                }
                iArrM1768k[i2] = 1;
                z2 = !z2;
            }
            i++;
        }
        throw C2340sh.m9579a();
    }

    public final C1077Xa m4063z(C0233F2 c0233f2, int i, boolean z, int[] iArr) throws C2340sh {
        int iM1193o;
        int i2;
        boolean zM1189h = c0233f2.m1189h(iArr[0]);
        int i3 = iArr[0] - 1;
        while (i3 >= 0 && zM1189h != c0233f2.m1189h(i3)) {
            i3--;
        }
        int i4 = i3 + 1;
        int i5 = iArr[0] - i4;
        int[] iArrM1768k = m1768k();
        System.arraycopy(iArrM1768k, 0, iArrM1768k, 1, iArrM1768k.length - 1);
        iArrM1768k[0] = i5;
        int iM1766r = AbstractC0414J.m1766r(iArrM1768k, f2656o);
        int i6 = iArr[1];
        if (z) {
            int iM1193o2 = (c0233f2.m1193o() - 1) - i4;
            iM1193o = (c0233f2.m1193o() - 1) - i6;
            i2 = iM1193o2;
        } else {
            iM1193o = i6;
            i2 = i4;
        }
        return new C1077Xa(iM1766r, new int[]{i4, iArr[1]}, i2, iM1193o, i);
    }
}
