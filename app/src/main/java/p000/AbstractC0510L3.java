package p000;

import java.io.Serializable;

public abstract class AbstractC0510L3 implements InterfaceC2200pf, Serializable {

    public static final Object f1653r = a.f1660l;

    public transient InterfaceC2200pf f1654l;

    public final Object f1655m;

    public final Class f1656n;

    public final String f1657o;

    public final String f1658p;

    public final boolean f1659q;

    public static class a implements Serializable {

        public static final a f1660l = new a();
    }

    public AbstractC0510L3(Object obj, Class cls, String str, String str2, boolean z) {
        this.f1655m = obj;
        this.f1656n = cls;
        this.f1657o = str;
        this.f1658p = str2;
        this.f1659q = z;
    }

    public InterfaceC2200pf mo2580a() {
        InterfaceC2200pf interfaceC2200pf = this.f1654l;
        if (interfaceC2200pf != null) {
            return interfaceC2200pf;
        }
        InterfaceC2200pf interfaceC2200pfMo2581b = mo2581b();
        this.f1654l = interfaceC2200pfMo2581b;
        return interfaceC2200pfMo2581b;
    }

    public abstract InterfaceC2200pf mo2581b();

    public Object m2582d() {
        return this.f1655m;
    }

    public String m2583f() {
        return this.f1657o;
    }

    public InterfaceC2292rf m2584g() {
        Class cls = this.f1656n;
        if (cls == null) {
            return null;
        }
        return this.f1659q ? AbstractC2251qk.m9159b(cls) : AbstractC2251qk.m9158a(cls);
    }

    public String m2585h() {
        return this.f1658p;
    }
}
