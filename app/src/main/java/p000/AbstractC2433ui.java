package p000;

import java.lang.reflect.Array;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AbstractC2433ui {

    public static final C1216aa f7558a = new C1216aa();

    public static C0968V2 m10152a(C0423J8 c0423j8) {
        int[] iArrM1835j;
        if (c0423j8 == null || (iArrM1835j = c0423j8.m1835j()) == null) {
            return null;
        }
        int iM10167p = m10167p(iArrM1835j);
        int i = 0;
        int i2 = 0;
        for (int i3 : iArrM1835j) {
            i2 += iM10167p - i3;
            if (i3 > 0) {
                break;
            }
        }
        C1302b5[] c1302b5ArrM1681d = c0423j8.m1681d();
        for (int i4 = 0; i2 > 0 && c1302b5ArrM1681d[i4] == null; i4++) {
            i2--;
        }
        for (int length = iArrM1835j.length - 1; length >= 0; length--) {
            int i5 = iArrM1835j[length];
            i += iM10167p - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = c1302b5ArrM1681d.length - 1; i > 0 && c1302b5ArrM1681d[length2] == null; length2--) {
            i--;
        }
        return c0423j8.m1678a().m4311a(i2, i, c0423j8.m1836k());
    }

    public static void m10153b(C0331H8 c0331h8, C2270r2[][] c2270r2Arr) throws C2340sh {
        C2270r2 c2270r2 = c2270r2Arr[0][1];
        int[] iArrM9255a = c2270r2.m9255a();
        int iM1525j = (c0331h8.m1525j() * c0331h8.m1527l()) - m10169r(c0331h8.m1526k());
        if (iArrM9255a.length == 0) {
            if (iM1525j <= 0 || iM1525j > 928) {
                throw C2340sh.m9579a();
            }
            c2270r2.m9256b(iM1525j);
            return;
        }
        if (iArrM9255a[0] == iM1525j || iM1525j <= 0 || iM1525j > 928) {
            return;
        }
        c2270r2.m9256b(iM1525j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        r0 = -r0;
        r8 = !r8;
        r1 = r1 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m10154c(C0325H2 r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.m1493e(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2433ui.m10154c(H2, int, int, boolean, int, int):int");
    }

    public static boolean m10155d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    public static int m10156e(int[] iArr, int[] iArr2, int i) throws C2548x4 {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return f7558a.m5248a(iArr, i, iArr2);
        }
        throw C2548x4.m10627a();
    }

    public static C2270r2[][] m10157f(C0331H8 c0331h8) {
        int iM5635c;
        C2270r2[][] c2270r2Arr = (C2270r2[][]) Array.newInstance((Class<?>) C2270r2.class, c0331h8.m1527l(), c0331h8.m1525j() + 2);
        for (C2270r2[] c2270r2Arr2 : c2270r2Arr) {
            int i = 0;
            while (true) {
                if (i < c2270r2Arr2.length) {
                    c2270r2Arr2[i] = new C2270r2();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (C0377I8 c0377i8 : c0331h8.m1530o()) {
            if (c0377i8 != null) {
                for (C1302b5 c1302b5 : c0377i8.m1681d()) {
                    if (c1302b5 != null && (iM5635c = c1302b5.m5635c()) >= 0 && iM5635c < c2270r2Arr.length) {
                        c2270r2Arr[iM5635c][i2].m9256b(c1302b5.m5637e());
                    }
                }
            }
            i2++;
        }
        return c2270r2Arr;
    }

    public static C0698P7 m10158g(C0331H8 c0331h8) throws C2340sh {
        C2270r2[][] c2270r2ArrM10157f = m10157f(c0331h8);
        m10153b(c0331h8, c2270r2ArrM10157f);
        ArrayList arrayList = new ArrayList<>();
        int[] iArr = new int[c0331h8.m1527l() * c0331h8.m1525j()];
        ArrayList arrayList2 = new ArrayList<>();
        ArrayList arrayList3 = new ArrayList<>();
        for (int i = 0; i < c0331h8.m1527l(); i++) {
            int i2 = 0;
            while (i2 < c0331h8.m1525j()) {
                int i3 = i2 + 1;
                int[] iArrM9255a = c2270r2ArrM10157f[i][i3].m9255a();
                int iM1525j = (c0331h8.m1525j() * i) + i2;
                if (iArrM9255a.length == 0) {
                    arrayList.add(Integer.valueOf(iM1525j));
                } else if (iArrM9255a.length == 1) {
                    iArr[iM1525j] = iArrM9255a[0];
                } else {
                    arrayList3.add(Integer.valueOf(iM1525j));
                    arrayList2.add(iArrM9255a);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return m10159h(c0331h8.m1526k(), iArr, AbstractC2156oi.m8965b(arrayList), AbstractC2156oi.m8965b(arrayList3), iArr2);
    }

    public static C0698P7 m10159h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) throws C2548x4 {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw C2548x4.m10627a();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return m10161j(iArr, i, iArr2);
            } catch (C2548x4 unused) {
                if (length == 0) {
                    throw C2548x4.m10627a();
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw C2548x4.m10627a();
                    }
                    i5++;
                }
                i2 = i3;
            }
        }
    }

    public static C0698P7 m10160i(C0325H2 c0325h2, C0857Sk c0857Sk, C0857Sk c0857Sk2, C0857Sk c0857Sk3, C0857Sk c0857Sk4, int i, int i2) {
        C0968V2 c0968v2;
        C0331H8 c0331h8M10173v;
        C0377I8 c0423j8;
        int i3;
        int i4;
        int i5;
        C0377I8 c0377i8;
        int i6;
        C0968V2 c0968v22 = new C0968V2(c0325h2, c0857Sk, c0857Sk2, c0857Sk3, c0857Sk4);
        C0423J8 c0423j8M10170s = null;
        boolean z = true;
        C0423J8 c0423j8M10170s2 = null;
        boolean z2 = true;
        while (true) {
            c0968v2 = c0968v22;
            if (c0857Sk != null) {
                c0423j8M10170s = m10170s(c0325h2, c0968v2, c0857Sk, true, i, i2);
            }
            if (c0857Sk3 != null) {
                c0423j8M10170s2 = m10170s(c0325h2, c0968v2, c0857Sk3, false, i, i2);
            }
            c0331h8M10173v = m10173v(c0423j8M10170s, c0423j8M10170s2);
            if (c0331h8M10173v == null) {
                throw C2340sh.m9579a();
            }
            c0968v22 = c0331h8M10173v.m1528m();
            if (!z2 || c0968v22 == null || (c0968v22.m4317g() >= c0968v2.m4317g() && c0968v22.m4315e() <= c0968v2.m4315e())) {
                break;
            }
            z2 = false;
        }
        c0331h8M10173v.m1531p(c0968v2);
        int iM1525j = c0331h8M10173v.m1525j() + 1;
        c0331h8M10173v.m1532q(0, c0423j8M10170s);
        c0331h8M10173v.m1532q(iM1525j, c0423j8M10170s2);
        boolean z3 = c0423j8M10170s != null;
        int iMin = i;
        int iMax = i2;
        int i7 = 1;
        while (i7 <= iM1525j) {
            int i8 = z3 ? i7 : iM1525j - i7;
            if (c0331h8M10173v.m1529n(i8) == null) {
                if (i8 == 0 || i8 == iM1525j) {
                    c0423j8 = new C0423J8(c0968v2, i8 == 0 ? z : false);
                } else {
                    c0423j8 = new C0377I8(c0968v2);
                }
                C0377I8 c0377i82 = c0423j8;
                c0331h8M10173v.m1532q(i8, c0377i82);
                int i9 = -1;
                int iM4317g = c0968v2.m4317g();
                int i10 = -1;
                while (iM4317g <= c0968v2.m4315e()) {
                    int iM10171t = m10171t(c0331h8M10173v, i8, iM4317g, z3);
                    if (iM10171t >= 0 && iM10171t <= c0968v2.m4314d()) {
                        i6 = iM10171t;
                    } else if (i10 != i9) {
                        i6 = i10;
                    } else {
                        i3 = i10;
                        i4 = iM4317g;
                        i5 = i9;
                        c0377i8 = c0377i82;
                        i10 = i3;
                        iM4317g = i4 + 1;
                        c0377i82 = c0377i8;
                        i9 = i5;
                    }
                    i3 = i10;
                    int i11 = iM4317g;
                    i5 = i9;
                    c0377i8 = c0377i82;
                    C1302b5 c1302b5M10162k = m10162k(c0325h2, c0968v2.m4316f(), c0968v2.m4314d(), z3, i6, i11, iMin, iMax);
                    i4 = i11;
                    if (c1302b5M10162k != null) {
                        c0377i8.m1683f(i4, c1302b5M10162k);
                        iMin = Math.min(iMin, c1302b5M10162k.m5638f());
                        iMax = Math.max(iMax, c1302b5M10162k.m5638f());
                        i10 = i6;
                    } else {
                        i10 = i3;
                    }
                    iM4317g = i4 + 1;
                    c0377i82 = c0377i8;
                    i9 = i5;
                }
            }
            i7++;
            z = true;
        }
        return m10158g(c0331h8M10173v);
    }

    public static C0698P7 m10161j(int[] iArr, int i, int[] iArr2) throws C2610yb, C2548x4 {
        if (iArr.length == 0) {
            throw C2610yb.m10853a();
        }
        int i2 = 1 << (i + 1);
        int iM10156e = m10156e(iArr, iArr2, i2);
        m10174w(iArr, i2);
        C0698P7 c0698p7M617b = AbstractC0146D7.m617b(iArr, String.valueOf(i));
        c0698p7M617b.m3486k(Integer.valueOf(iM10156e));
        c0698p7M617b.m3485j(Integer.valueOf(iArr2.length));
        return c0698p7M617b;
    }

    public static C1302b5 m10162k(C0325H2 c0325h2, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int iM8790d;
        int iM8964a;
        int iM10154c = m10154c(c0325h2, i, i2, z, i3, i4);
        int[] iArrM10168q = m10168q(c0325h2, i, i2, z, iM10154c, i4);
        if (iArrM10168q == null) {
            return null;
        }
        int iM10357d = AbstractC2477vg.m10357d(iArrM10168q);
        if (z) {
            i7 = iM10154c + iM10357d;
        } else {
            for (int i8 = 0; i8 < iArrM10168q.length / 2; i8++) {
                int i9 = iArrM10168q[i8];
                iArrM10168q[i8] = iArrM10168q[(iArrM10168q.length - 1) - i8];
                iArrM10168q[(iArrM10168q.length - 1) - i8] = i9;
            }
            iM10154c -= iM10357d;
            i7 = iM10154c;
        }
        if (m10155d(iM10357d, i5, i6) && (iM8964a = AbstractC2156oi.m8964a((iM8790d = AbstractC2110ni.m8790d(iArrM10168q)))) != -1) {
            return new C1302b5(iM10154c, i7, m10165n(iM8790d), iM8964a);
        }
        return null;
    }

    public static C2131o2 m10163l(C0423J8 c0423j8, C0423J8 c0423j82) {
        C2131o2 c2131o2M1834i;
        C2131o2 c2131o2M1834i2;
        if (c0423j8 == null || (c2131o2M1834i = c0423j8.m1834i()) == null) {
            if (c0423j82 == null) {
                return null;
            }
            return c0423j82.m1834i();
        }
        if (c0423j82 == null || (c2131o2M1834i2 = c0423j82.m1834i()) == null || c2131o2M1834i.m8831a() == c2131o2M1834i2.m8831a() || c2131o2M1834i.m8832b() == c2131o2M1834i2.m8832b() || c2131o2M1834i.m8833c() == c2131o2M1834i2.m8833c()) {
            return c2131o2M1834i;
        }
        return null;
    }

    public static int[] m10164m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    public static int m10165n(int i) {
        return m10166o(m10164m(i));
    }

    public static int m10166o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int m10167p(int[] iArr) {
        int iMax = -1;
        for (int i : iArr) {
            iMax = Math.max(iMax, i);
        }
        return iMax;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] m10168q(C0325H2 r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = r2
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.m1493e(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2433ui.m10168q(H2, int, int, boolean, int, int):int[]");
    }

    public static int m10169r(int i) {
        return 2 << i;
    }

    public static C0423J8 m10170s(C0325H2 c0325h2, C0968V2 c0968v2, C0857Sk c0857Sk, boolean z, int i, int i2) {
        C0423J8 c0423j8 = new C0423J8(c0968v2, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int iM4067c = (int) c0857Sk.m4067c();
            for (int iM4068d = (int) c0857Sk.m4068d(); iM4068d <= c0968v2.m4315e() && iM4068d >= c0968v2.m4317g(); iM4068d += i4) {
                C1302b5 c1302b5M10162k = m10162k(c0325h2, 0, c0325h2.m1499o(), z, iM4067c, iM4068d, i, i2);
                if (c1302b5M10162k != null) {
                    c0423j8.m1683f(iM4068d, c1302b5M10162k);
                    iM4067c = z ? c1302b5M10162k.m5636d() : c1302b5M10162k.m5634b();
                }
            }
            i3++;
        }
        return c0423j8;
    }

    public static int m10171t(C0331H8 c0331h8, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        C1302b5 c1302b5M1679b = m10172u(c0331h8, i4) ? c0331h8.m1529n(i4).m1679b(i2) : null;
        if (c1302b5M1679b != null) {
            return z ? c1302b5M1679b.m5634b() : c1302b5M1679b.m5636d();
        }
        C1302b5 c1302b5M1680c = c0331h8.m1529n(i).m1680c(i2);
        if (c1302b5M1680c != null) {
            return z ? c1302b5M1680c.m5636d() : c1302b5M1680c.m5634b();
        }
        if (m10172u(c0331h8, i4)) {
            c1302b5M1680c = c0331h8.m1529n(i4).m1680c(i2);
        }
        if (c1302b5M1680c != null) {
            return z ? c1302b5M1680c.m5634b() : c1302b5M1680c.m5636d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!m10172u(c0331h8, i)) {
                C0968V2 c0968v2M1528m = c0331h8.m1528m();
                return z ? c0968v2M1528m.m4316f() : c0968v2M1528m.m4314d();
            }
            for (C1302b5 c1302b5 : c0331h8.m1529n(i).m1681d()) {
                if (c1302b5 != null) {
                    return (z ? c1302b5.m5634b() : c1302b5.m5636d()) + (i3 * i5 * (c1302b5.m5634b() - c1302b5.m5636d()));
                }
            }
            i5++;
        }
    }

    public static boolean m10172u(C0331H8 c0331h8, int i) {
        return i >= 0 && i <= c0331h8.m1525j() + 1;
    }

    public static C0331H8 m10173v(C0423J8 c0423j8, C0423J8 c0423j82) {
        C2131o2 c2131o2M10163l;
        if ((c0423j8 == null && c0423j82 == null) || (c2131o2M10163l = m10163l(c0423j8, c0423j82)) == null) {
            return null;
        }
        return new C0331H8(c2131o2M10163l, C0968V2.m4310j(m10152a(c0423j8), m10152a(c0423j82)));
    }

    public static void m10174w(int[] iArr, int i) throws C2610yb {
        if (iArr.length < 4) {
            throw C2610yb.m10853a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw C2610yb.m10853a();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw C2610yb.m10853a();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
