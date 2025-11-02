package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2296rj extends AbstractC0510L3 implements InterfaceC2384tf {

    public final boolean f6959s;

    public AbstractC2296rj(Object obj, Class cls, String str, String str2, int i) {
        super(obj, cls, str, str2, (i & 1) == 1);
        this.f6959s = (i & 2) == 2;
    }

    @Override
    public InterfaceC2200pf mo2580a() {
        return this.f6959s ? this : super.mo2580a();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AbstractC2296rj) {
            AbstractC2296rj abstractC2296rj = (AbstractC2296rj) obj;
            return m2584g().equals(abstractC2296rj.m2584g()) && m2583f().equals(abstractC2296rj.m2583f()) && m2585h().equals(abstractC2296rj.m2585h()) && AbstractC0116Ce.m472a(m2582d(), abstractC2296rj.m2582d());
        }
        if (obj instanceof InterfaceC2384tf) {
            return obj.equals(mo2580a());
        }
        return false;
    }

    public int hashCode() {
        return (((m2584g().hashCode() * 31) + m2583f().hashCode()) * 31) + m2585h().hashCode();
    }

    public String toString() {
        InterfaceC2200pf interfaceC2200pfMo2580a = mo2580a();
        if (interfaceC2200pfMo2580a != this) {
            return interfaceC2200pfMo2580a.toString();
        }
        return "property " + m2583f() + " (Kotlin reflection is not available)";
    }
}
