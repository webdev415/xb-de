package p000;

import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import p000.AbstractC1126Yd;

public final class C2481vk extends AbstractC1126Yd {

    public static final AbstractC1126Yd f7743s = new C2481vk(null, new Object[0], 0);

    public final transient Object f7744p;

    public final transient Object[] f7745q;

    public final transient int f7746r;

    public static class a extends AbstractC1220ae {

        public final transient AbstractC1126Yd f7747n;

        public final transient Object[] f7748o;

        public final transient int f7749p;

        public final transient int f7750q;

        public class C2725a extends AbstractC1080Xd {
            public C2725a() {
            }

            @Override
            public boolean mo4497i() {
                return true;
            }

            @Override
            public int size() {
                return a.this.f7750q;
            }

            @Override
            public Entry get(int i) {
                AbstractC1131Yi.m4971g(i, a.this.f7750q);
                int i2 = i * 2;
                Object obj = a.this.f7748o[a.this.f7749p + i2];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f7748o[i2 + (a.this.f7749p ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        public a(AbstractC1126Yd abstractC1126Yd, Object[] objArr, int i, int i2) {
            this.f7747n = abstractC1126Yd;
            this.f7748o = objArr;
            this.f7749p = i;
            this.f7750q = i2;
        }

        @Override
        public AbstractC2209po iterator() {
            return mo5260k().iterator();
        }

        @Override
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            return value != null && value.equals(this.f7747n.get(key));
        }

        @Override
        public int mo4493d(Object[] objArr, int i) {
            return mo5260k().mo4493d(objArr, i);
        }

        @Override
        public boolean mo4497i() {
            return true;
        }

        @Override
        public AbstractC1080Xd mo5261r() {
            return new C2725a();
        }

        @Override
        public int size() {
            return this.f7750q;
        }
    }

    public static final class b extends AbstractC1220ae {

        public final transient AbstractC1126Yd f7752n;

        public final transient AbstractC1080Xd f7753o;

        public b(AbstractC1126Yd abstractC1126Yd, AbstractC1080Xd abstractC1080Xd) {
            this.f7752n = abstractC1126Yd;
            this.f7753o = abstractC1080Xd;
        }

        @Override
        public boolean contains(Object obj) {
            return this.f7752n.get(obj) != null;
        }

        @Override
        public int mo4493d(Object[] objArr, int i) {
            return mo5260k().mo4493d(objArr, i);
        }

        @Override
        public boolean mo4497i() {
            return true;
        }

        @Override
        public AbstractC1080Xd mo5260k() {
            return this.f7753o;
        }

        @Override
        public int size() {
            return this.f7752n.size();
        }

        @Override
        public AbstractC2209po iterator() {
            return mo5260k().iterator();
        }
    }

    public static final class c extends AbstractC1080Xd {

        public final transient Object[] f7754n;

        public final transient int f7755o;

        public final transient int f7756p;

        public c(Object[] objArr, int i, int i2) {
            this.f7754n = objArr;
            this.f7755o = i;
            this.f7756p = i2;
        }

        @Override
        public Object get(int i) {
            AbstractC1131Yi.m4971g(i, this.f7756p);
            Object obj = this.f7754n[(i * 2) + this.f7755o];
            Objects.requireNonNull(obj);
            return obj;
        }

        @Override
        public boolean mo4497i() {
            return true;
        }

        @Override
        public int size() {
            return this.f7756p;
        }
    }

    public C2481vk(Object obj, Object[] objArr, int i) {
        this.f7744p = obj;
        this.f7745q = objArr;
        this.f7746r = i;
    }

    public static C2481vk m10387h(int i, Object[] objArr, AbstractC1126Yd.a aVar) {
        if (i == 0) {
            return (C2481vk) f7743s;
        }
        if (i == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            AbstractC1348c5.m5730a(obj, obj2);
            return new C2481vk(null, objArr, 1);
        }
        AbstractC1131Yi.m4975k(i, objArr.length >> 1);
        Object objM10388i = m10388i(objArr, i, AbstractC1220ae.m5253o(i), 0);
        if (objM10388i instanceof Object[]) {
            Object[] objArr2 = (Object[]) objM10388i;
            AbstractC1126Yd.a.C2703a c2703a = (AbstractC1126Yd.a.C2703a) objArr2[2];
            if (aVar == null) {
                throw c2703a.m4951a();
            }
            aVar.f3350e = c2703a;
            Object obj3 = objArr2[0];
            int iIntValue = ((Integer) objArr2[1]).intValue();
            objArr = Arrays.copyOf(objArr, iIntValue * 2);
            objM10388i = obj3;
            i = iIntValue;
        }
        return new C2481vk(objM10388i, objArr, i);
    }

    public static Object m10388i(Object[] objArr, int i, int i2, int i3) {
        AbstractC1126Yd.a.C2703a c2703a = null;
        if (i == 1) {
            Object obj = objArr[i3];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[i3 ^ 1];
            Objects.requireNonNull(obj2);
            AbstractC1348c5.m5730a(obj, obj2);
            return null;
        }
        int i4 = i2 - 1;
        int i5 = -1;
        if (i2 <= 128) {
            byte[] bArr = new byte[i2];
            Arrays.fill(bArr, (byte) -1);
            int i6 = 0;
            for (int i7 = 0; i7 < i; i7++) {
                int i8 = (i7 * 2) + i3;
                int i9 = (i6 * 2) + i3;
                Object obj3 = objArr[i8];
                Objects.requireNonNull(obj3);
                Object obj4 = objArr[i8 ^ 1];
                Objects.requireNonNull(obj4);
                AbstractC1348c5.m5730a(obj3, obj4);
                int iM4389b = AbstractC0987Vc.m4389b(obj3.hashCode());
                while (true) {
                    int i10 = iM4389b & i4;
                    int i11 = bArr[i10] & 255;
                    if (i11 == 255) {
                        bArr[i10] = (byte) i9;
                        if (i6 < i7) {
                            objArr[i9] = obj3;
                            objArr[i9 ^ 1] = obj4;
                        }
                        i6++;
                    } else {
                        if (obj3.equals(objArr[i11])) {
                            int i12 = i11 ^ 1;
                            Object obj5 = objArr[i12];
                            Objects.requireNonNull(obj5);
                            c2703a = new AbstractC1126Yd.a.C2703a(obj3, obj4, obj5);
                            objArr[i12] = obj4;
                            break;
                        }
                        iM4389b = i10 + 1;
                    }
                }
            }
            return i6 == i ? bArr : new Object[]{bArr, Integer.valueOf(i6), c2703a};
        }
        if (i2 <= 32768) {
            short[] sArr = new short[i2];
            Arrays.fill(sArr, (short) -1);
            int i13 = 0;
            for (int i14 = 0; i14 < i; i14++) {
                int i15 = (i14 * 2) + i3;
                int i16 = (i13 * 2) + i3;
                Object obj6 = objArr[i15];
                Objects.requireNonNull(obj6);
                Object obj7 = objArr[i15 ^ 1];
                Objects.requireNonNull(obj7);
                AbstractC1348c5.m5730a(obj6, obj7);
                int iM4389b2 = AbstractC0987Vc.m4389b(obj6.hashCode());
                while (true) {
                    int i17 = iM4389b2 & i4;
                    int i18 = sArr[i17] & 65535;
                    if (i18 == 65535) {
                        sArr[i17] = (short) i16;
                        if (i13 < i14) {
                            objArr[i16] = obj6;
                            objArr[i16 ^ 1] = obj7;
                        }
                        i13++;
                    } else {
                        if (obj6.equals(objArr[i18])) {
                            int i19 = i18 ^ 1;
                            Object obj8 = objArr[i19];
                            Objects.requireNonNull(obj8);
                            c2703a = new AbstractC1126Yd.a.C2703a(obj6, obj7, obj8);
                            objArr[i19] = obj7;
                            break;
                        }
                        iM4389b2 = i17 + 1;
                    }
                }
            }
            return i13 == i ? sArr : new Object[]{sArr, Integer.valueOf(i13), c2703a};
        }
        int[] iArr = new int[i2];
        Arrays.fill(iArr, -1);
        int i20 = 0;
        int i21 = 0;
        while (i20 < i) {
            int i22 = (i20 * 2) + i3;
            int i23 = (i21 * 2) + i3;
            Object obj9 = objArr[i22];
            Objects.requireNonNull(obj9);
            Object obj10 = objArr[i22 ^ 1];
            Objects.requireNonNull(obj10);
            AbstractC1348c5.m5730a(obj9, obj10);
            int iM4389b3 = AbstractC0987Vc.m4389b(obj9.hashCode());
            while (true) {
                int i24 = iM4389b3 & i4;
                int i25 = iArr[i24];
                if (i25 == i5) {
                    iArr[i24] = i23;
                    if (i21 < i20) {
                        objArr[i23] = obj9;
                        objArr[i23 ^ 1] = obj10;
                    }
                    i21++;
                } else {
                    if (obj9.equals(objArr[i25])) {
                        int i26 = i25 ^ 1;
                        Object obj11 = objArr[i26];
                        Objects.requireNonNull(obj11);
                        c2703a = new AbstractC1126Yd.a.C2703a(obj9, obj10, obj11);
                        objArr[i26] = obj10;
                        break;
                    }
                    iM4389b3 = i24 + 1;
                    i5 = -1;
                }
            }
            i20++;
            i5 = -1;
        }
        return i21 == i ? iArr : new Object[]{iArr, Integer.valueOf(i21), c2703a};
    }

    public static Object m10389j(Object obj, Object[] objArr, int i, int i2, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i == 1) {
            Object obj3 = objArr[i2];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i2 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        }
        if (obj == null) {
            return null;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            int length = bArr.length - 1;
            int iM4389b = AbstractC0987Vc.m4389b(obj2.hashCode());
            while (true) {
                int i3 = iM4389b & length;
                int i4 = bArr[i3] & 255;
                if (i4 == 255) {
                    return null;
                }
                if (obj2.equals(objArr[i4])) {
                    return objArr[i4 ^ 1];
                }
                iM4389b = i3 + 1;
            }
        } else if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            int length2 = sArr.length - 1;
            int iM4389b2 = AbstractC0987Vc.m4389b(obj2.hashCode());
            while (true) {
                int i5 = iM4389b2 & length2;
                int i6 = sArr[i5] & 65535;
                if (i6 == 65535) {
                    return null;
                }
                if (obj2.equals(objArr[i6])) {
                    return objArr[i6 ^ 1];
                }
                iM4389b2 = i5 + 1;
            }
        } else {
            int[] iArr = (int[]) obj;
            int length3 = iArr.length - 1;
            int iM4389b3 = AbstractC0987Vc.m4389b(obj2.hashCode());
            while (true) {
                int i7 = iM4389b3 & length3;
                int i8 = iArr[i7];
                if (i8 == -1) {
                    return null;
                }
                if (obj2.equals(objArr[i8])) {
                    return objArr[i8 ^ 1];
                }
                iM4389b3 = i7 + 1;
            }
        }
    }

    @Override
    public AbstractC1220ae mo4939a() {
        return new a(this, this.f7745q, 0, this.f7746r);
    }

    @Override
    public AbstractC1220ae mo4940b() {
        return new b(this, new c(this.f7745q, 0, this.f7746r));
    }

    @Override
    public AbstractC1034Wd mo4941c() {
        return new c(this.f7745q, 1, this.f7746r);
    }

    @Override
    public Object get(Object obj) {
        Object objM10389j = m10389j(this.f7744p, this.f7745q, this.f7746r, 0, obj);
        if (objM10389j == null) {
            return null;
        }
        return objM10389j;
    }

    @Override
    public int size() {
        return this.f7746r;
    }
}
