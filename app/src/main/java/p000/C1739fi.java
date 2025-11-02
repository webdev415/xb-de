package p000;

import java.util.List;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class C1739fi extends AbstractC0184E implements RandomAccess {

    public static final a f5506o = new a(null);

    public final C0096C3[] f5507m;

    public final int[] f5508n;

    public static final class a {
        public a() {
        }

        public static void m7600b(a aVar, long j, C2409u3 c2409u3, int i, List list, int i2, int i3, List list2, int i4, Object obj) {
            aVar.m7601a((i4 & 1) != 0 ? 0L : j, c2409u3, (i4 & 4) != 0 ? 0 : i, list, (i4 & 16) != 0 ? 0 : i2, (i4 & 32) != 0 ? list.size() : i3, list2);
        }

        public final void m7601a(long j, C2409u3 c2409u3, int i, List list, int i2, int i3, List list2) {
            int i4;
            int i5;
            int i6;
            int i7;
            C2409u3 c2409u32;
            int i8 = i;
            if (!(i2 < i3)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            for (int i9 = i2; i9 < i3; i9++) {
                if (!(((C0096C3) list.get(i9)).m387u() >= i8)) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
            }
            C0096C3 c0096c3 = (C0096C3) list.get(i2);
            C0096C3 c0096c32 = (C0096C3) list.get(i3 - 1);
            int i10 = -1;
            if (i8 == c0096c3.m387u()) {
                int iIntValue = ((Number) list2.get(i2)).intValue();
                int i11 = i2 + 1;
                C0096C3 c0096c33 = (C0096C3) list.get(i11);
                i4 = i11;
                i5 = iIntValue;
                c0096c3 = c0096c33;
            } else {
                i4 = i2;
                i5 = -1;
            }
            if (c0096c3.m374h(i8) == c0096c32.m374h(i8)) {
                int iMin = Math.min(c0096c3.m387u(), c0096c32.m387u());
                int i12 = 0;
                for (int i13 = i8; i13 < iMin && c0096c3.m374h(i13) == c0096c32.m374h(i13); i13++) {
                    i12++;
                }
                long jM7602c = j + m7602c(c2409u3) + 2 + i12 + 1;
                c2409u3.mo5934y(-i12);
                c2409u3.mo5934y(i5);
                int i14 = i8 + i12;
                while (i8 < i14) {
                    c2409u3.mo5934y(c0096c3.m374h(i8) & 255);
                    i8++;
                }
                if (i4 + 1 == i3) {
                    if (!(i14 == ((C0096C3) list.get(i4)).m387u())) {
                        throw new IllegalStateException("Check failed.".toString());
                    }
                    c2409u3.mo5934y(((Number) list2.get(i4)).intValue());
                    return;
                } else {
                    C2409u3 c2409u33 = new C2409u3();
                    c2409u3.mo5934y(((int) (m7602c(c2409u33) + jM7602c)) * (-1));
                    m7601a(jM7602c, c2409u33, i14, list, i4, i3, list2);
                    c2409u3.m9920f0(c2409u33);
                    return;
                }
            }
            int i15 = 1;
            for (int i16 = i4 + 1; i16 < i3; i16++) {
                if (((C0096C3) list.get(i16 - 1)).m374h(i8) != ((C0096C3) list.get(i16)).m374h(i8)) {
                    i15++;
                }
            }
            long jM7602c2 = j + m7602c(c2409u3) + 2 + (i15 * 2);
            c2409u3.mo5934y(i15);
            c2409u3.mo5934y(i5);
            for (int i17 = i4; i17 < i3; i17++) {
                byte bM374h = ((C0096C3) list.get(i17)).m374h(i8);
                if (i17 == i4 || bM374h != ((C0096C3) list.get(i17 - 1)).m374h(i8)) {
                    c2409u3.mo5934y(bM374h & 255);
                }
            }
            C2409u3 c2409u34 = new C2409u3();
            while (i4 < i3) {
                byte bM374h2 = ((C0096C3) list.get(i4)).m374h(i8);
                int i18 = i4 + 1;
                int i19 = i18;
                while (true) {
                    if (i19 >= i3) {
                        i6 = i3;
                        break;
                    } else {
                        if (bM374h2 != ((C0096C3) list.get(i19)).m374h(i8)) {
                            i6 = i19;
                            break;
                        }
                        i19++;
                    }
                }
                if (i18 == i6 && i8 + 1 == ((C0096C3) list.get(i4)).m387u()) {
                    c2409u3.mo5934y(((Number) list2.get(i4)).intValue());
                    i7 = i6;
                    c2409u32 = c2409u34;
                } else {
                    c2409u3.mo5934y(((int) (jM7602c2 + m7602c(c2409u34))) * i10);
                    i7 = i6;
                    c2409u32 = c2409u34;
                    m7601a(jM7602c2, c2409u34, i8 + 1, list, i4, i6, list2);
                }
                c2409u34 = c2409u32;
                i4 = i7;
                i10 = -1;
            }
            c2409u3.m9920f0(c2409u34);
        }

        public final long m7602c(C2409u3 c2409u3) {
            return c2409u3.m9911Y() / 4;
        }

        /* JADX WARN: Code restructure failed: missing block: B:55:0x00e7, code lost:
        
            continue;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final C1739fi m7603d(C0096C3... r17) {
            /*
                Method dump skipped, instructions count: 320
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C1739fi.a.m7603d(C3[]):fi");
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C1739fi(C0096C3[] c0096c3Arr, int[] iArr) {
        this.f5507m = c0096c3Arr;
        this.f5508n = iArr;
    }

    @Override
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof C0096C3) {
            return m7594f((C0096C3) obj);
        }
        return false;
    }

    @Override
    public int mo841d() {
        return this.f5507m.length;
    }

    public /* bridge */ boolean m7594f(C0096C3 c0096c3) {
        return super.contains(c0096c3);
    }

    @Override
    public C0096C3 get(int i) {
        return this.f5507m[i];
    }

    public final C0096C3[] m7596h() {
        return this.f5507m;
    }

    public final int[] m7597i() {
        return this.f5508n;
    }

    @Override
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof C0096C3) {
            return m7598k((C0096C3) obj);
        }
        return -1;
    }

    public /* bridge */ int m7598k(C0096C3 c0096c3) {
        return super.indexOf(c0096c3);
    }

    @Override
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof C0096C3) {
            return m7599o((C0096C3) obj);
        }
        return -1;
    }

    public /* bridge */ int m7599o(C0096C3 c0096c3) {
        return super.lastIndexOf(c0096c3);
    }

    public C1739fi(C0096C3[] c0096c3Arr, int[] iArr, AbstractC0881T7 abstractC0881T7) {
        this(c0096c3Arr, iArr);
    }
}
