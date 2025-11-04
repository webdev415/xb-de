package p000;

import java.util.Set;

public interface InterfaceC0466K5 {
    default Object mo2282a(Class cls) {
        return mo2288g(C0167Dj.m716b(cls));
    }

    InterfaceC2388tj mo2283b(C0167Dj c0167Dj);

    default InterfaceC2388tj mo2284c(Class cls) {
        return mo2287f(C0167Dj.m716b(cls));
    }

    default Set mo2285d(C0167Dj c0167Dj) {
        return (Set) mo2283b(c0167Dj).get();
    }

    default Set m2286e(Class cls) {
        return mo2285d(C0167Dj.m716b(cls));
    }

    InterfaceC2388tj mo2287f(C0167Dj c0167Dj);

    default Object mo2288g(C0167Dj c0167Dj) {
        InterfaceC2388tj interfaceC2388tjMo2287f = mo2287f(c0167Dj);
        if (interfaceC2388tjMo2287f == null) {
            return null;
        }
        return interfaceC2388tjMo2287f.get();
    }
}
