package p000;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import p000.AbstractC1034Wd;

/* loaded from: classes.dex */
public abstract class AbstractC1126Yd implements Map, Serializable {

    public static final Entry[] f3342o = new Entry[0];

    public transient AbstractC1220ae f3343l;

    public transient AbstractC1220ae f3344m;

    public transient AbstractC1034Wd f3345n;

    public static class a {

        public Comparator f3346a;

        public Object[] f3347b;

        public int f3348c = 0;

        public boolean f3349d = false;

        public C2703a f3350e;

        public static final class C2703a {

            public final Object f3351a;

            public final Object f3352b;

            public final Object f3353c;

            public C2703a(Object obj, Object obj2, Object obj3) {
                this.f3351a = obj;
                this.f3352b = obj2;
                this.f3353c = obj3;
            }

            public IllegalArgumentException m4951a() {
                String strValueOf = String.valueOf(this.f3351a);
                String strValueOf2 = String.valueOf(this.f3352b);
                String strValueOf3 = String.valueOf(this.f3351a);
                String strValueOf4 = String.valueOf(this.f3353c);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 39 + strValueOf2.length() + strValueOf3.length() + strValueOf4.length());
                sb.append("Multiple entries with same key: ");
                sb.append(strValueOf);
                sb.append("=");
                sb.append(strValueOf2);
                sb.append(" and ");
                sb.append(strValueOf3);
                sb.append("=");
                sb.append(strValueOf4);
                return new IllegalArgumentException(sb.toString());
            }
        }

        public a(int i) {
            this.f3347b = new Object[i * 2];
        }

        public static void m4945f(Object[] objArr, int i, Comparator comparator) {
            Entry[] entryArr = new Entry[i];
            for (int i2 = 0; i2 < i; i2++) {
                int i3 = i2 * 2;
                Object obj = objArr[i3];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i3 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i2] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i, AbstractC1786gi.m7739a(comparator).m7743e(AbstractC2201pg.m9068d()));
            for (int i4 = 0; i4 < i; i4++) {
                int i5 = i4 * 2;
                objArr[i5] = entryArr[i4].getKey();
                objArr[i5 + 1] = entryArr[i4].getValue();
            }
        }

        public final AbstractC1126Yd m4946a(boolean z) {
            Object[] objArrM4949d;
            C2703a c2703a;
            C2703a c2703a2;
            if (z && (c2703a2 = this.f3350e) != null) {
                throw c2703a2.m4951a();
            }
            int length = this.f3348c;
            if (this.f3346a == null) {
                objArrM4949d = this.f3347b;
            } else {
                if (this.f3349d) {
                    this.f3347b = Arrays.copyOf(this.f3347b, length * 2);
                }
                objArrM4949d = this.f3347b;
                if (!z) {
                    objArrM4949d = m4949d(objArrM4949d, this.f3348c);
                    if (objArrM4949d.length < this.f3347b.length) {
                        length = objArrM4949d.length >>> 1;
                    }
                }
                m4945f(objArrM4949d, length, this.f3346a);
            }
            this.f3349d = true;
            C2481vk c2481vkM10387h = C2481vk.m10387h(length, objArrM4949d, this);
            if (!z || (c2703a = this.f3350e) == null) {
                return c2481vkM10387h;
            }
            throw c2703a.m4951a();
        }

        public AbstractC1126Yd m4947b() {
            return m4946a(true);
        }

        public final void m4948c(int i) {
            int i2 = i * 2;
            Object[] objArr = this.f3347b;
            if (i2 > objArr.length) {
                this.f3347b = Arrays.copyOf(objArr, AbstractC1034Wd.a.m4498a(objArr.length, i2));
                this.f3349d = false;
            }
        }

        public final Object[] m4949d(Object[] objArr, int i) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i2 = i - 1; i2 >= 0; i2--) {
                Object obj = objArr[i2 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i2);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i - bitSet.cardinality()) * 2];
            int i3 = 0;
            int i4 = 0;
            while (i3 < i * 2) {
                if (bitSet.get(i3 >>> 1)) {
                    i3 += 2;
                } else {
                    int i5 = i4 + 1;
                    int i6 = i3 + 1;
                    Object obj2 = objArr[i3];
                    Objects.requireNonNull(obj2);
                    objArr2[i4] = obj2;
                    i4 += 2;
                    i3 += 2;
                    Object obj3 = objArr[i6];
                    Objects.requireNonNull(obj3);
                    objArr2[i5] = obj3;
                }
            }
            return objArr2;
        }

        public a m4950e(Object obj, Object obj2) {
            m4948c(this.f3348c + 1);
            AbstractC1348c5.m5730a(obj, obj2);
            Object[] objArr = this.f3347b;
            int i = this.f3348c;
            objArr[i * 2] = obj;
            objArr[(i * 2) + 1] = obj2;
            this.f3348c = i + 1;
            return this;
        }
    }

    public static AbstractC1126Yd m4938f() {
        return C2481vk.f7743s;
    }

    public abstract AbstractC1220ae mo4939a();

    public abstract AbstractC1220ae mo4940b();

    public abstract AbstractC1034Wd mo4941c();

    @Override
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override
    public AbstractC1220ae entrySet() {
        AbstractC1220ae abstractC1220ae = this.f3343l;
        if (abstractC1220ae != null) {
            return abstractC1220ae;
        }
        AbstractC1220ae abstractC1220aeMo4939a = mo4939a();
        this.f3343l = abstractC1220aeMo4939a;
        return abstractC1220aeMo4939a;
    }

    @Override
    public AbstractC1220ae keySet() {
        AbstractC1220ae abstractC1220ae = this.f3344m;
        if (abstractC1220ae != null) {
            return abstractC1220ae;
        }
        AbstractC1220ae abstractC1220aeMo4940b = mo4940b();
        this.f3344m = abstractC1220aeMo4940b;
        return abstractC1220aeMo4940b;
    }

    @Override
    public boolean equals(Object obj) {
        return AbstractC2201pg.m9065a(this, obj);
    }

    @Override
    public AbstractC1034Wd values() {
        AbstractC1034Wd abstractC1034Wd = this.f3345n;
        if (abstractC1034Wd != null) {
            return abstractC1034Wd;
        }
        AbstractC1034Wd abstractC1034WdMo4941c = mo4941c();
        this.f3345n = abstractC1034WdMo4941c;
        return abstractC1034WdMo4941c;
    }

    @Override
    public abstract Object get(Object obj);

    @Override
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    @Override
    public int hashCode() {
        return AbstractC0583Ml.m2914b(entrySet());
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        return AbstractC2201pg.m9067c(this);
    }
}
