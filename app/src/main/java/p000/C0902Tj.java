package p000;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class C0902Tj extends AbstractC0414J {

    public static final int[] f2767k = {7, 5, 4, 3, 1};

    public static final int[] f2768l = {4, 20, 52, 104, 204};

    public static final int[] f2769m = {0, 348, 1388, 2948, 3988};

    public static final int[][] f2770n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};

    public static final int[][] f2771o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, ModuleDescriptor.MODULE_VERSION, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};

    public static final int[][] f2772p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    public final List f2773g = new ArrayList<>(11);

    public final List f2774h = new ArrayList<>();

    public final int[] f2775i = new int[2];

    public boolean f2776j;

    public static int m4161A(C0233F2 c0233f2, int i) {
        return c0233f2.m1189h(i) ? c0233f2.m1191m(c0233f2.m1192n(i)) : c0233f2.m1192n(c0233f2.m1191m(i));
    }

    public static boolean m4162B(C1077Xa c1077Xa, boolean z, boolean z2) {
        return (c1077Xa.m4736c() == 0 && z && z2) ? false : true;
    }

    public static boolean m4163C(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            C0388Ia c0388Ia = (C0388Ia) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                C0342Ha c0342Ha = (C0342Ha) it2.next();
                Iterator it3 = c0388Ia.m1685a().iterator();
                while (it3.hasNext()) {
                    if (c0342Ha.equals((C0342Ha) it3.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean m4164D(List list) {
        for (int[] iArr : f2772p) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (((C0342Ha) list.get(i)).m1561a().m4736c() != iArr[i]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void m4165F(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            C0388Ia c0388Ia = (C0388Ia) it.next();
            if (c0388Ia.m1685a().size() != collection.size()) {
                Iterator it2 = c0388Ia.m1685a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    } else if (!collection.contains((C0342Ha) it2.next())) {
                        break;
                    }
                }
            }
        }
    }

    public static void m4166H(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    public static C0720Pk m4167w(List list) {
        String strMo175d = AbstractC0046B.m172a(AbstractC0279G2.m1320a(list)).mo175d();
        C0857Sk[] c0857SkArrM4734a = ((C0342Ha) list.get(0)).m1561a().m4734a();
        C0857Sk[] c0857SkArrM4734a2 = ((C0342Ha) list.get(list.size() - 1)).m1561a().m4734a();
        return new C0720Pk(strMo175d, null, new C0857Sk[]{c0857SkArrM4734a[0], c0857SkArrM4734a[1], c0857SkArrM4734a2[0], c0857SkArrM4734a2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    public final C1077Xa m4168E(C0233F2 c0233f2, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.f2775i[0] - 1;
            while (i5 >= 0 && !c0233f2.m1189h(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.f2775i;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.f2775i;
            int i7 = iArr2[0];
            int iM1192n = c0233f2.m1192n(iArr2[1] + 1);
            i2 = iM1192n;
            i3 = i7;
            i4 = iM1192n - this.f2775i[1];
        }
        int[] iArrM1768k = m1768k();
        System.arraycopy(iArrM1768k, 0, iArrM1768k, 1, iArrM1768k.length - 1);
        iArrM1768k[0] = i4;
        try {
            return new C1077Xa(AbstractC0414J.m1766r(iArrM1768k, f2770n), new int[]{i3, i2}, i3, i2, i);
        } catch (C2340sh unused) {
            return null;
        }
    }

    public C0342Ha m4169G(C0233F2 c0233f2, List list, int i) throws C2340sh {
        C1077Xa c1077XaM4168E;
        C1859i7 c1859i7M4175x;
        boolean z = list.size() % 2 == 0;
        if (this.f2776j) {
            z = !z;
        }
        int iM4161A = -1;
        boolean z2 = true;
        do {
            m4177z(c0233f2, list, iM4161A);
            c1077XaM4168E = m4168E(c0233f2, i, z);
            if (c1077XaM4168E == null) {
                iM4161A = m4161A(c0233f2, this.f2775i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        C1859i7 c1859i7M4175x2 = m4175x(c0233f2, c1077XaM4168E, z, true);
        if (!list.isEmpty() && ((C0342Ha) list.get(list.size() - 1)).m1564d()) {
            throw C2340sh.m9579a();
        }
        try {
            c1859i7M4175x = m4175x(c0233f2, c1077XaM4168E, z, false);
        } catch (C2340sh unused) {
            c1859i7M4175x = null;
        }
        return new C0342Ha(c1859i7M4175x2, c1859i7M4175x, c1077XaM4168E);
    }

    public final void m4170I(int i) {
        boolean zM1687c;
        int i2 = 0;
        boolean zM1687c2 = false;
        while (true) {
            if (i2 >= this.f2774h.size()) {
                zM1687c = false;
                break;
            }
            C0388Ia c0388Ia = (C0388Ia) this.f2774h.get(i2);
            if (c0388Ia.m1686b() > i) {
                zM1687c = c0388Ia.m1687c(this.f2773g);
                break;
            } else {
                zM1687c2 = c0388Ia.m1687c(this.f2773g);
                i2++;
            }
        }
        if (zM1687c || zM1687c2 || m4163C(this.f2773g, this.f2774h)) {
            return;
        }
        this.f2774h.add(i2, new C0388Ia(this.f2773g, i, false));
        m4165F(this.f2773g, this.f2774h);
    }

    @Override
    public void mo140c() {
        this.f2773g.clear();
        this.f2774h.clear();
    }

    @Override
    public C0720Pk mo3558d(int i, C0233F2 c0233f2, Map map) {
        this.f2773g.clear();
        this.f2776j = false;
        try {
            return m4167w(m4176y(i, c0233f2));
        } catch (C2340sh unused) {
            this.f2773g.clear();
            this.f2776j = true;
            return m4167w(m4176y(i, c0233f2));
        }
    }

    public final void m4171s(int i) throws C2340sh {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int iM10357d = AbstractC2477vg.m10357d(m1771n());
        int iM10357d2 = AbstractC2477vg.m10357d(m1769l());
        boolean z5 = true;
        if (iM10357d > 13) {
            z2 = true;
            z = false;
        } else if (iM10357d < 4) {
            z = true;
            z2 = false;
        } else {
            z = false;
            z2 = false;
        }
        if (iM10357d2 > 13) {
            z4 = true;
            z3 = false;
        } else if (iM10357d2 < 4) {
            z3 = true;
            z4 = false;
        } else {
            z3 = false;
            z4 = false;
        }
        int i2 = (iM10357d + iM10357d2) - i;
        boolean z6 = (iM10357d & 1) == 1;
        boolean z7 = (iM10357d2 & 1) == 0;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw C2340sh.m9579a();
                }
                if (z6) {
                    if (z7) {
                        throw C2340sh.m9579a();
                    }
                    z2 = true;
                } else {
                    if (!z7) {
                        throw C2340sh.m9579a();
                    }
                    z4 = true;
                }
            } else if (z6) {
                if (!z7) {
                    throw C2340sh.m9579a();
                }
                if (iM10357d < iM10357d2) {
                    z4 = true;
                } else {
                    z3 = true;
                    z2 = true;
                }
            } else if (z7) {
                throw C2340sh.m9579a();
            }
            z5 = z;
        } else if (z6) {
            if (z7) {
                throw C2340sh.m9579a();
            }
        } else {
            if (!z7) {
                throw C2340sh.m9579a();
            }
            z3 = true;
            z5 = z;
        }
        if (z5) {
            if (z2) {
                throw C2340sh.m9579a();
            }
            AbstractC0414J.m1764p(m1771n(), m1772o());
        }
        if (z2) {
            AbstractC0414J.m1763i(m1771n(), m1772o());
        }
        if (z3) {
            if (z4) {
                throw C2340sh.m9579a();
            }
            AbstractC0414J.m1764p(m1769l(), m1772o());
        }
        if (z4) {
            AbstractC0414J.m1763i(m1769l(), m1770m());
        }
    }

    public final boolean m4172t() {
        C0342Ha c0342Ha = (C0342Ha) this.f2773g.get(0);
        C1859i7 c1859i7M1562b = c0342Ha.m1562b();
        C1859i7 c1859i7M1563c = c0342Ha.m1563c();
        if (c1859i7M1563c == null) {
            return false;
        }
        int iM7870a = c1859i7M1563c.m7870a();
        int i = 2;
        for (int i2 = 1; i2 < this.f2773g.size(); i2++) {
            C0342Ha c0342Ha2 = (C0342Ha) this.f2773g.get(i2);
            iM7870a += c0342Ha2.m1562b().m7870a();
            int i3 = i + 1;
            C1859i7 c1859i7M1563c2 = c0342Ha2.m1563c();
            if (c1859i7M1563c2 != null) {
                iM7870a += c1859i7M1563c2.m7870a();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (iM7870a % 211) == c1859i7M1562b.m7871b();
    }

    public final List m4173u(List list, int i) throws C2340sh {
        while (i < this.f2774h.size()) {
            C0388Ia c0388Ia = (C0388Ia) this.f2774h.get(i);
            this.f2773g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.f2773g.addAll(((C0388Ia) it.next()).m1685a());
            }
            this.f2773g.addAll(c0388Ia.m1685a());
            if (m4164D(this.f2773g)) {
                if (m4172t()) {
                    return this.f2773g;
                }
                ArrayList arrayList = new ArrayList<>(list);
                arrayList.add(c0388Ia);
                try {
                    return m4173u(arrayList, i + 1);
                } catch (C2340sh unused) {
                    continue;
                }
            }
            i++;
        }
        throw C2340sh.m9579a();
    }

    public final List m4174v(boolean z) {
        List listM4173u = null;
        if (this.f2774h.size() > 25) {
            this.f2774h.clear();
            return null;
        }
        this.f2773g.clear();
        if (z) {
            Collections.reverse(this.f2774h);
        }
        try {
            listM4173u = m4173u(new ArrayList<>(), 0);
        } catch (C2340sh unused) {
        }
        if (z) {
            Collections.reverse(this.f2774h);
        }
        return listM4173u;
    }

    public C1859i7 m4175x(C0233F2 c0233f2, C1077Xa c1077Xa, boolean z, boolean z2) throws C2340sh {
        int[] iArrM1767j = m1767j();
        Arrays.fill(iArrM1767j, 0);
        int[] iArrM4735b = c1077Xa.m4735b();
        if (z2) {
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
        float fM10357d = AbstractC2477vg.m10357d(iArrM1767j) / 17.0f;
        float f = (c1077Xa.m4735b()[1] - c1077Xa.m4735b()[0]) / 15.0f;
        if (Math.abs(fM10357d - f) / f > 0.3f) {
            throw C2340sh.m9579a();
        }
        int[] iArrM1771n = m1771n();
        int[] iArrM1769l = m1769l();
        float[] fArrM1772o = m1772o();
        float[] fArrM1770m = m1770m();
        for (int i3 = 0; i3 < iArrM1767j.length; i3++) {
            float f2 = (iArrM1767j[i3] * 1.0f) / fM10357d;
            int i4 = (int) (0.5f + f2);
            if (i4 <= 0) {
                if (f2 < 0.3f) {
                    throw C2340sh.m9579a();
                }
                i4 = 1;
            } else if (i4 > 8) {
                if (f2 > 8.7f) {
                    throw C2340sh.m9579a();
                }
                i4 = 8;
            }
            int i5 = i3 / 2;
            if ((i3 & 1) == 0) {
                iArrM1771n[i5] = i4;
                fArrM1772o[i5] = f2 - i4;
            } else {
                iArrM1769l[i5] = i4;
                fArrM1770m[i5] = f2 - i4;
            }
        }
        m4171s(17);
        int iM4736c = (((c1077Xa.m4736c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i6 = 0;
        int i7 = 0;
        for (int length2 = iArrM1771n.length - 1; length2 >= 0; length2--) {
            if (m4162B(c1077Xa, z, z2)) {
                i6 += iArrM1771n[length2] * f2771o[iM4736c][length2 * 2];
            }
            i7 += iArrM1771n[length2];
        }
        int i8 = 0;
        for (int length3 = iArrM1769l.length - 1; length3 >= 0; length3--) {
            if (m4162B(c1077Xa, z, z2)) {
                i8 += iArrM1769l[length3] * f2771o[iM4736c][(length3 * 2) + 1];
            }
        }
        int i9 = i6 + i8;
        if ((i7 & 1) != 0 || i7 > 13 || i7 < 4) {
            throw C2340sh.m9579a();
        }
        int i10 = (13 - i7) / 2;
        int i11 = f2767k[i10];
        return new C1859i7((AbstractC0948Uj.m4268b(iArrM1771n, i11, true) * f2768l[i10]) + AbstractC0948Uj.m4268b(iArrM1769l, 9 - i11, false) + f2769m[i10], i9);
    }

    public List m4176y(int i, C0233F2 c0233f2) throws C2340sh {
        boolean z = false;
        while (!z) {
            try {
                List list = this.f2773g;
                list.add(m4169G(c0233f2, list, i));
            } catch (C2340sh e) {
                if (this.f2773g.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (m4172t()) {
            return this.f2773g;
        }
        boolean z2 = !this.f2774h.isEmpty();
        m4170I(i);
        if (z2) {
            List listM4174v = m4174v(false);
            if (listM4174v != null) {
                return listM4174v;
            }
            List listM4174v2 = m4174v(true);
            if (listM4174v2 != null) {
                return listM4174v2;
            }
        }
        throw C2340sh.m9579a();
    }

    public final void m4177z(C0233F2 c0233f2, List list, int i) throws C2340sh {
        int[] iArrM1768k = m1768k();
        iArrM1768k[0] = 0;
        iArrM1768k[1] = 0;
        iArrM1768k[2] = 0;
        iArrM1768k[3] = 0;
        int iM1193o = c0233f2.m1193o();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((C0342Ha) list.get(list.size() - 1)).m1561a().m4735b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.f2776j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < iM1193o) {
            z2 = !c0233f2.m1189h(i);
            if (!z2) {
                break;
            } else {
                i++;
            }
        }
        int i2 = 0;
        boolean z3 = z2;
        int i3 = i;
        while (i < iM1193o) {
            if (c0233f2.m1189h(i) != z3) {
                iArrM1768k[i2] = iArrM1768k[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        m4166H(iArrM1768k);
                    }
                    if (AbstractC0414J.m1765q(iArrM1768k)) {
                        int[] iArr = this.f2775i;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        m4166H(iArrM1768k);
                    }
                    i3 += iArrM1768k[0] + iArrM1768k[1];
                    iArrM1768k[0] = iArrM1768k[2];
                    iArrM1768k[1] = iArrM1768k[3];
                    iArrM1768k[2] = 0;
                    iArrM1768k[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                iArrM1768k[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw C2340sh.m9579a();
    }
}
