package p000;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
public class C2411u5 extends AbstractMap implements Serializable {

    public static final Object f7348u = new Object();

    public transient Object f7349l;

    public transient int[] f7350m;

    public transient Object[] f7351n;

    public transient Object[] f7352o;

    public transient int f7353p;

    public transient int f7354q;

    public transient Set f7355r;

    public transient Set f7356s;

    public transient Collection f7357t;

    public class a extends e {
        public a() {
            super(C2411u5.this, null);
        }

        @Override
        public Object mo9986c(int i) {
            return C2411u5.this.m9956G(i);
        }
    }

    public class b extends e {
        public b() {
            super(C2411u5.this, null);
        }

        @Override
        public Entry mo9986c(int i) {
            return C2411u5.this.new g(i);
        }
    }

    public class c extends e {
        public c() {
            super(C2411u5.this, null);
        }

        @Override
        public Object mo9986c(int i) {
            return C2411u5.this.m9972W(i);
        }
    }

    public class d extends AbstractSet {
        public d() {
        }

        @Override
        public void clear() {
            C2411u5.this.clear();
        }

        @Override
        public boolean contains(Object obj) {
            Map mapM9982w = C2411u5.this.m9982w();
            if (mapM9982w != null) {
                return mapM9982w.entrySet().contains(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int iM9953D = C2411u5.this.m9953D(entry.getKey());
            return iM9953D != -1 && AbstractC0303Gh.m1398a(C2411u5.this.m9972W(iM9953D), entry.getValue());
        }

        @Override
        public Iterator iterator() {
            return C2411u5.this.m9984y();
        }

        @Override
        public boolean remove(Object obj) {
            Map mapM9982w = C2411u5.this.m9982w();
            if (mapM9982w != null) {
                return mapM9982w.entrySet().remove(obj);
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            if (C2411u5.this.m9959J()) {
                return false;
            }
            int iM9951B = C2411u5.this.m9951B();
            int iM10319f = AbstractC2457v5.m10319f(entry.getKey(), entry.getValue(), iM9951B, C2411u5.this.m9963N(), C2411u5.this.m9961L(), C2411u5.this.m9962M(), C2411u5.this.m9964O());
            if (iM10319f == -1) {
                return false;
            }
            C2411u5.this.m9958I(iM10319f, iM9951B);
            C2411u5.m9940e(C2411u5.this);
            C2411u5.this.m9952C();
            return true;
        }

        @Override
        public int size() {
            return C2411u5.this.size();
        }
    }

    public abstract class e implements Iterator {

        public int f7362l;

        public int f7363m;

        public int f7364n;

        public e() {
            this.f7362l = C2411u5.this.f7353p;
            this.f7363m = C2411u5.this.m9985z();
            this.f7364n = -1;
        }

        public final void m9988b() {
            if (C2411u5.this.f7353p != this.f7362l) {
                throw new ConcurrentModificationException();
            }
        }

        public abstract Object mo9986c(int i);

        public void m9989d() {
            this.f7362l += 32;
        }

        @Override
        public boolean hasNext() {
            return this.f7363m >= 0;
        }

        @Override
        public Object next() {
            m9988b();
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            int i = this.f7363m;
            this.f7364n = i;
            Object objMo9986c = mo9986c(i);
            this.f7363m = C2411u5.this.m9950A(this.f7363m);
            return objMo9986c;
        }

        @Override
        public void remove() {
            m9988b();
            AbstractC1348c5.m5732c(this.f7364n >= 0);
            m9989d();
            C2411u5 c2411u5 = C2411u5.this;
            c2411u5.remove(c2411u5.m9956G(this.f7364n));
            this.f7363m = C2411u5.this.m9975o(this.f7363m, this.f7364n);
            this.f7364n = -1;
        }

        public e(C2411u5 c2411u5, a aVar) {
            this();
        }
    }

    public class f extends AbstractSet {
        public f() {
        }

        @Override
        public void clear() {
            C2411u5.this.clear();
        }

        @Override
        public boolean contains(Object obj) {
            return C2411u5.this.containsKey(obj);
        }

        @Override
        public Iterator iterator() {
            return C2411u5.this.m9957H();
        }

        @Override
        public boolean remove(Object obj) {
            Map mapM9982w = C2411u5.this.m9982w();
            return mapM9982w != null ? mapM9982w.keySet().remove(obj) : C2411u5.this.m9960K(obj) != C2411u5.f7348u;
        }

        @Override
        public int size() {
            return C2411u5.this.size();
        }
    }

    public final class g extends AbstractC0230F {

        public final Object f7367l;

        public int f7368m;

        public g(int i) {
            this.f7367l = C2411u5.this.m9956G(i);
            this.f7368m = i;
        }

        public final void m9990a() {
            int i = this.f7368m;
            if (i == -1 || i >= C2411u5.this.size() || !AbstractC0303Gh.m1398a(this.f7367l, C2411u5.this.m9956G(this.f7368m))) {
                this.f7368m = C2411u5.this.m9953D(this.f7367l);
            }
        }

        @Override
        public Object getKey() {
            return this.f7367l;
        }

        @Override
        public Object getValue() {
            Map mapM9982w = C2411u5.this.m9982w();
            if (mapM9982w != null) {
                return AbstractC0073Bh.m306a(mapM9982w.get(this.f7367l));
            }
            m9990a();
            int i = this.f7368m;
            return i == -1 ? AbstractC0073Bh.m307b() : C2411u5.this.m9972W(i);
        }

        @Override
        public Object setValue(Object obj) {
            Map mapM9982w = C2411u5.this.m9982w();
            if (mapM9982w != null) {
                return AbstractC0073Bh.m306a(mapM9982w.put(this.f7367l, obj));
            }
            m9990a();
            int i = this.f7368m;
            if (i == -1) {
                C2411u5.this.put(this.f7367l, obj);
                return AbstractC0073Bh.m307b();
            }
            Object objM9972W = C2411u5.this.m9972W(i);
            C2411u5.this.m9971V(this.f7368m, obj);
            return objM9972W;
        }
    }

    public class h extends AbstractCollection {
        public h() {
        }

        @Override
        public void clear() {
            C2411u5.this.clear();
        }

        @Override
        public Iterator iterator() {
            return C2411u5.this.m9973X();
        }

        @Override
        public int size() {
            return C2411u5.this.size();
        }
    }

    public C2411u5() {
        m9954E(3);
    }

    public static int m9940e(C2411u5 c2411u5) {
        int i = c2411u5.f7354q;
        c2411u5.f7354q = i - 1;
        return i;
    }

    public static C2411u5 m9949r() {
        return new C2411u5();
    }

    public int m9950A(int i) {
        int i2 = i + 1;
        if (i2 < this.f7354q) {
            return i2;
        }
        return -1;
    }

    public final int m9951B() {
        return (1 << (this.f7353p & 31)) - 1;
    }

    public void m9952C() {
        this.f7353p += 32;
    }

    public final int m9953D(Object obj) {
        if (m9959J()) {
            return -1;
        }
        int iM4390c = AbstractC0987Vc.m4390c(obj);
        int iM9951B = m9951B();
        int iM10321h = AbstractC2457v5.m10321h(m9963N(), iM4390c & iM9951B);
        if (iM10321h == 0) {
            return -1;
        }
        int iM10315b = AbstractC2457v5.m10315b(iM4390c, iM9951B);
        do {
            int i = iM10321h - 1;
            int iM9983x = m9983x(i);
            if (AbstractC2457v5.m10315b(iM9983x, iM9951B) == iM10315b && AbstractC0303Gh.m1398a(obj, m9956G(i))) {
                return i;
            }
            iM10321h = AbstractC2457v5.m10316c(iM9983x, iM9951B);
        } while (iM10321h != 0);
        return -1;
    }

    public void m9954E(int i) {
        AbstractC1131Yi.m4969e(i >= 0, "Expected size must be >= 0");
        this.f7353p = AbstractC0254Fe.m1249a(i, 1, 1073741823);
    }

    public void m9955F(int i, Object obj, Object obj2, int i2, int i3) {
        m9968S(i, AbstractC2457v5.m10317d(i2, 0, i3));
        m9970U(i, obj);
        m9971V(i, obj2);
    }

    public final Object m9956G(int i) {
        return m9962M()[i];
    }

    public Iterator m9957H() {
        Map mapM9982w = m9982w();
        return mapM9982w != null ? mapM9982w.keySet().iterator() : new a();
    }

    public void m9958I(int i, int i2) {
        Object objM9963N = m9963N();
        int[] iArrM9961L = m9961L();
        Object[] objArrM9962M = m9962M();
        Object[] objArrM9964O = m9964O();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrM9962M[i] = null;
            objArrM9964O[i] = null;
            iArrM9961L[i] = 0;
            return;
        }
        Object obj = objArrM9962M[i3];
        objArrM9962M[i] = obj;
        objArrM9964O[i] = objArrM9964O[i3];
        objArrM9962M[i3] = null;
        objArrM9964O[i3] = null;
        iArrM9961L[i] = iArrM9961L[i3];
        iArrM9961L[i3] = 0;
        int iM4390c = AbstractC0987Vc.m4390c(obj) & i2;
        int iM10321h = AbstractC2457v5.m10321h(objM9963N, iM4390c);
        if (iM10321h == size) {
            AbstractC2457v5.m10322i(objM9963N, iM4390c, i + 1);
            return;
        }
        while (true) {
            int i4 = iM10321h - 1;
            int i5 = iArrM9961L[i4];
            int iM10316c = AbstractC2457v5.m10316c(i5, i2);
            if (iM10316c == size) {
                iArrM9961L[i4] = AbstractC2457v5.m10317d(i5, i + 1, i2);
                return;
            }
            iM10321h = iM10316c;
        }
    }

    public boolean m9959J() {
        return this.f7349l == null;
    }

    public final Object m9960K(Object obj) {
        if (m9959J()) {
            return f7348u;
        }
        int iM9951B = m9951B();
        int iM10319f = AbstractC2457v5.m10319f(obj, null, iM9951B, m9963N(), m9961L(), m9962M(), null);
        if (iM10319f == -1) {
            return f7348u;
        }
        Object objM9972W = m9972W(iM10319f);
        m9958I(iM10319f, iM9951B);
        this.f7354q--;
        m9952C();
        return objM9972W;
    }

    public final int[] m9961L() {
        int[] iArr = this.f7350m;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    public final Object[] m9962M() {
        Object[] objArr = this.f7351n;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public final Object m9963N() {
        Object obj = this.f7349l;
        Objects.requireNonNull(obj);
        return obj;
    }

    public final Object[] m9964O() {
        Object[] objArr = this.f7352o;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    public void m9965P(int i) {
        this.f7350m = Arrays.copyOf(m9961L(), i);
        this.f7351n = Arrays.copyOf(m9962M(), i);
        this.f7352o = Arrays.copyOf(m9964O(), i);
    }

    public final void m9966Q(int i) {
        int iMin;
        int length = m9961L().length;
        if (i <= length || (iMin = Math.min(1073741823, (Math.max(1, length >>> 1) + length) | 1)) == length) {
            return;
        }
        m9965P(iMin);
    }

    public final int m9967R(int i, int i2, int i3, int i4) {
        Object objM10314a = AbstractC2457v5.m10314a(i2);
        int i5 = i2 - 1;
        if (i4 != 0) {
            AbstractC2457v5.m10322i(objM10314a, i3 & i5, i4 + 1);
        }
        Object objM9963N = m9963N();
        int[] iArrM9961L = m9961L();
        for (int i6 = 0; i6 <= i; i6++) {
            int iM10321h = AbstractC2457v5.m10321h(objM9963N, i6);
            while (iM10321h != 0) {
                int i7 = iM10321h - 1;
                int i8 = iArrM9961L[i7];
                int iM10315b = AbstractC2457v5.m10315b(i8, i) | i6;
                int i9 = iM10315b & i5;
                int iM10321h2 = AbstractC2457v5.m10321h(objM10314a, i9);
                AbstractC2457v5.m10322i(objM10314a, i9, iM10321h);
                iArrM9961L[i7] = AbstractC2457v5.m10317d(iM10315b, iM10321h2, i5);
                iM10321h = AbstractC2457v5.m10316c(i8, i);
            }
        }
        this.f7349l = objM10314a;
        m9969T(i5);
        return i5;
    }

    public final void m9968S(int i, int i2) {
        m9961L()[i] = i2;
    }

    public final void m9969T(int i) {
        this.f7353p = AbstractC2457v5.m10317d(this.f7353p, 32 - Integer.numberOfLeadingZeros(i), 31);
    }

    public final void m9970U(int i, Object obj) {
        m9962M()[i] = obj;
    }

    public final void m9971V(int i, Object obj) {
        m9964O()[i] = obj;
    }

    public final Object m9972W(int i) {
        return m9964O()[i];
    }

    public Iterator m9973X() {
        Map mapM9982w = m9982w();
        return mapM9982w != null ? mapM9982w.values().iterator() : new c();
    }

    @Override
    public void clear() {
        if (m9959J()) {
            return;
        }
        m9952C();
        Map mapM9982w = m9982w();
        if (mapM9982w != null) {
            this.f7353p = AbstractC0254Fe.m1249a(size(), 3, 1073741823);
            mapM9982w.clear();
            this.f7349l = null;
        } else {
            Arrays.fill(m9962M(), 0, this.f7354q, (Object) null);
            Arrays.fill(m9964O(), 0, this.f7354q, (Object) null);
            AbstractC2457v5.m10320g(m9963N());
            Arrays.fill(m9961L(), 0, this.f7354q, 0);
        }
        this.f7354q = 0;
    }

    @Override
    public boolean containsKey(Object obj) {
        Map mapM9982w = m9982w();
        return mapM9982w != null ? mapM9982w.containsKey(obj) : m9953D(obj) != -1;
    }

    @Override
    public boolean containsValue(Object obj) {
        Map mapM9982w = m9982w();
        if (mapM9982w != null) {
            return mapM9982w.containsValue(obj);
        }
        for (int i = 0; i < this.f7354q; i++) {
            if (AbstractC0303Gh.m1398a(obj, m9972W(i))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set entrySet() {
        Set set = this.f7356s;
        if (set != null) {
            return set;
        }
        Set setM9978s = m9978s();
        this.f7356s = setM9978s;
        return setM9978s;
    }

    @Override
    public Object get(Object obj) {
        Map mapM9982w = m9982w();
        if (mapM9982w != null) {
            return mapM9982w.get(obj);
        }
        int iM9953D = m9953D(obj);
        if (iM9953D == -1) {
            return null;
        }
        m9974n(iM9953D);
        return m9972W(iM9953D);
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public Set keySet() {
        Set set = this.f7355r;
        if (set != null) {
            return set;
        }
        Set setM9980u = m9980u();
        this.f7355r = setM9980u;
        return setM9980u;
    }

    public int m9975o(int i, int i2) {
        return i - 1;
    }

    public int m9976p() {
        AbstractC1131Yi.m4979o(m9959J(), "Arrays already allocated");
        int i = this.f7353p;
        int iM10323j = AbstractC2457v5.m10323j(i);
        this.f7349l = AbstractC2457v5.m10314a(iM10323j);
        m9969T(iM10323j - 1);
        this.f7350m = new int[i];
        this.f7351n = new Object[i];
        this.f7352o = new Object[i];
        return i;
    }

    @Override
    public Object put(Object obj, Object obj2) {
        int iM9967R;
        if (m9959J()) {
            m9976p();
        }
        Map mapM9982w = m9982w();
        if (mapM9982w != null) {
            return mapM9982w.put(obj, obj2);
        }
        int[] iArrM9961L = m9961L();
        Object[] objArrM9962M = m9962M();
        Object[] objArrM9964O = m9964O();
        int i = this.f7354q;
        int i2 = i + 1;
        int iM4390c = AbstractC0987Vc.m4390c(obj);
        int iM9951B = m9951B();
        int i3 = iM4390c & iM9951B;
        int iM10321h = AbstractC2457v5.m10321h(m9963N(), i3);
        if (iM10321h == 0) {
            if (i2 <= iM9951B) {
                AbstractC2457v5.m10322i(m9963N(), i3, i2);
                iM9967R = iM9951B;
            }
            iM9967R = m9967R(iM9951B, AbstractC2457v5.m10318e(iM9951B), iM4390c, i);
        } else {
            int iM10315b = AbstractC2457v5.m10315b(iM4390c, iM9951B);
            int i4 = 0;
            while (true) {
                int i5 = iM10321h - 1;
                int i6 = iArrM9961L[i5];
                if (AbstractC2457v5.m10315b(i6, iM9951B) == iM10315b && AbstractC0303Gh.m1398a(obj, objArrM9962M[i5])) {
                    Object obj3 = objArrM9964O[i5];
                    objArrM9964O[i5] = obj2;
                    m9974n(i5);
                    return obj3;
                }
                int iM10316c = AbstractC2457v5.m10316c(i6, iM9951B);
                i4++;
                if (iM10316c != 0) {
                    iM10321h = iM10316c;
                } else {
                    if (i4 >= 9) {
                        return m9977q().put(obj, obj2);
                    }
                    if (i2 <= iM9951B) {
                        iArrM9961L[i5] = AbstractC2457v5.m10317d(i6, i2, iM9951B);
                    }
                }
            }
            iM9967R = iM9951B;
        }
        m9966Q(i2);
        m9955F(i, obj, obj2, iM4390c, iM9967R);
        this.f7354q = i2;
        m9952C();
        return null;
    }

    public Map m9977q() {
        Map mapM9979t = m9979t(m9951B() + 1);
        int iM9985z = m9985z();
        while (iM9985z >= 0) {
            mapM9979t.put(m9956G(iM9985z), m9972W(iM9985z));
            iM9985z = m9950A(iM9985z);
        }
        this.f7349l = mapM9979t;
        this.f7350m = null;
        this.f7351n = null;
        this.f7352o = null;
        m9952C();
        return mapM9979t;
    }

    @Override
    public Object remove(Object obj) {
        Map mapM9982w = m9982w();
        if (mapM9982w != null) {
            return mapM9982w.remove(obj);
        }
        Object objM9960K = m9960K(obj);
        if (objM9960K == f7348u) {
            return null;
        }
        return objM9960K;
    }

    public Set m9978s() {
        return new d();
    }

    @Override
    public int size() {
        Map mapM9982w = m9982w();
        return mapM9982w != null ? mapM9982w.size() : this.f7354q;
    }

    public Map m9979t(int i) {
        return new LinkedHashMap(i, 1.0f);
    }

    public Set m9980u() {
        return new f();
    }

    public Collection m9981v() {
        return new h();
    }

    @Override
    public Collection values() {
        Collection collection = this.f7357t;
        if (collection != null) {
            return collection;
        }
        Collection collectionM9981v = m9981v();
        this.f7357t = collectionM9981v;
        return collectionM9981v;
    }

    public Map m9982w() {
        Object obj = this.f7349l;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    public final int m9983x(int i) {
        return m9961L()[i];
    }

    public Iterator m9984y() {
        Map mapM9982w = m9982w();
        return mapM9982w != null ? mapM9982w.entrySet().iterator() : new b();
    }

    public int m9985z() {
        return isEmpty() ? -1 : 0;
    }

    public void m9974n(int i) {
    }
}
