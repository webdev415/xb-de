package p000;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class C0420J5 {

    public final String f1266a;

    public final Set f1267b;

    public final Set f1268c;

    public final int f1269d;

    public final int f1270e;

    public final InterfaceC0604N5 f1271f;

    public final Set f1272g;

    public C0420J5(String str, Set set, Set set2, int i, int i2, InterfaceC0604N5 interfaceC0604N5, Set set3) {
        this.f1266a = str;
        this.f1267b = Collections.unmodifiableSet(set);
        this.f1268c = Collections.unmodifiableSet(set2);
        this.f1269d = i;
        this.f1270e = i2;
        this.f1271f = interfaceC0604N5;
        this.f1272g = Collections.unmodifiableSet(set3);
    }

    public static b m1794c(C0167Dj c0167Dj) {
        return new b(c0167Dj, new C0167Dj[0]);
    }

    public static b m1795d(C0167Dj c0167Dj, C0167Dj... c0167DjArr) {
        return new b(c0167Dj, c0167DjArr);
    }

    public static b m1796e(Class cls) {
        return new b(cls, new Class[0]);
    }

    public static b m1797f(Class cls, Class... clsArr) {
        return new b(cls, clsArr);
    }

    public static C0420J5 m1798l(final Object obj, Class cls) {
        return m1799m(cls).m1816e(new InterfaceC0604N5() {
            @Override
            public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                return C0420J5.m1800q(obj, interfaceC0466K5);
            }
        }).m1814c();
    }

    public static b m1799m(Class cls) {
        return m1796e(cls).m1817f();
    }

    public static C0420J5 m1802s(final Object obj, Class cls, Class... clsArr) {
        return m1797f(cls, clsArr).m1816e(new InterfaceC0604N5() {
            @Override
            public final Object mo432a(InterfaceC0466K5 interfaceC0466K5) {
                return C0420J5.m1801r(obj, interfaceC0466K5);
            }
        }).m1814c();
    }

    public Set m1803g() {
        return this.f1268c;
    }

    public InterfaceC0604N5 m1804h() {
        return this.f1271f;
    }

    public String m1805i() {
        return this.f1266a;
    }

    public Set m1806j() {
        return this.f1267b;
    }

    public Set m1807k() {
        return this.f1272g;
    }

    public boolean m1808n() {
        return this.f1269d == 1;
    }

    public boolean m1809o() {
        return this.f1269d == 2;
    }

    public boolean m1810p() {
        return this.f1270e == 0;
    }

    public C0420J5 m1811t(InterfaceC0604N5 interfaceC0604N5) {
        return new C0420J5(this.f1266a, this.f1267b, this.f1268c, this.f1269d, this.f1270e, interfaceC0604N5, this.f1272g);
    }

    public String toString() {
        return "Component<" + Arrays.toString(this.f1267b.toArray()) + ">{" + this.f1269d + ", type=" + this.f1270e + ", deps=" + Arrays.toString(this.f1268c.toArray()) + "}";
    }

    public static class b {

        public String f1273a;

        public final Set f1274b;

        public final Set f1275c;

        public int f1276d;

        public int f1277e;

        public InterfaceC0604N5 f1278f;

        public final Set f1279g;

        public b(C0167Dj c0167Dj, C0167Dj... c0167DjArr) {
            this.f1273a = null;
            HashSet hashSet = new HashSet();
            this.f1274b = hashSet;
            this.f1275c = new HashSet();
            this.f1276d = 0;
            this.f1277e = 0;
            this.f1279g = new HashSet();
            AbstractC1177Zi.m5051c(c0167Dj, "Null interface");
            hashSet.add(c0167Dj);
            for (C0167Dj c0167Dj2 : c0167DjArr) {
                AbstractC1177Zi.m5051c(c0167Dj2, "Null interface");
            }
            Collections.addAll(this.f1274b, c0167DjArr);
        }

        public b m1813b(C0193E8 c0193e8) {
            AbstractC1177Zi.m5051c(c0193e8, "Null dependency");
            m1820i(c0193e8.m877b());
            this.f1275c.add(c0193e8);
            return this;
        }

        public C0420J5 m1814c() {
            AbstractC1177Zi.m5052d(this.f1278f != null, "Missing required property: factory.");
            return new C0420J5(this.f1273a, new HashSet(this.f1274b), new HashSet(this.f1275c), this.f1276d, this.f1277e, this.f1278f, this.f1279g);
        }

        public b m1815d() {
            return m1819h(2);
        }

        public b m1816e(InterfaceC0604N5 interfaceC0604N5) {
            this.f1278f = (InterfaceC0604N5) AbstractC1177Zi.m5051c(interfaceC0604N5, "Null factory");
            return this;
        }

        public final b m1817f() {
            this.f1277e = 1;
            return this;
        }

        public b m1818g(String str) {
            this.f1273a = str;
            return this;
        }

        public final b m1819h(int i) {
            AbstractC1177Zi.m5052d(this.f1276d == 0, "Instantiation type has already been set.");
            this.f1276d = i;
            return this;
        }

        public final void m1820i(C0167Dj c0167Dj) {
            AbstractC1177Zi.m5049a(!this.f1274b.contains(c0167Dj), "Components are not allowed to depend on interfaces they themselves provide.");
        }

        public b(Class cls, Class... clsArr) {
            this.f1273a = null;
            HashSet hashSet = new HashSet();
            this.f1274b = hashSet;
            this.f1275c = new HashSet();
            this.f1276d = 0;
            this.f1277e = 0;
            this.f1279g = new HashSet();
            AbstractC1177Zi.m5051c(cls, "Null interface");
            hashSet.add(C0167Dj.m716b(cls));
            for (Class cls2 : clsArr) {
                AbstractC1177Zi.m5051c(cls2, "Null interface");
                this.f1274b.add(C0167Dj.m716b(cls2));
            }
        }
    }

    public static Object m1800q(Object obj, InterfaceC0466K5 interfaceC0466K5) {
        return obj;
    }

    public static Object m1801r(Object obj, InterfaceC0466K5 interfaceC0466K5) {
        return obj;
    }
}
