package p000;

import java.util.Comparator;

public abstract class AbstractC1786gi implements Comparator {
    public static AbstractC1786gi m7739a(Comparator comparator) {
        return comparator instanceof AbstractC1786gi ? (AbstractC1786gi) comparator : new C2549x5(comparator);
    }

    public static AbstractC1786gi m7740c() {
        return C2017lh.f6093l;
    }

    public AbstractC1080Xd m7741b(Iterable iterable) {
        return AbstractC1080Xd.m4759u(this, iterable);
    }

    @Override
    public abstract int compare(Object obj, Object obj2);

    public AbstractC1786gi m7742d() {
        return m7743e(AbstractC2201pg.m9066b());
    }

    public AbstractC1786gi m7743e(InterfaceC2289rc interfaceC2289rc) {
        return new C0004A3(interfaceC2289rc, this);
    }
}
