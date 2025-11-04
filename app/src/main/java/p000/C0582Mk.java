package p000;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class C0582Mk implements InterfaceC0466K5 {

    public final Set f1840a;

    public final Set f1841b;

    public final Set f1842c;

    public final Set f1843d;

    public final Set f1844e;

    public final Set f1845f;

    public final InterfaceC0466K5 f1846g;

    public static class a implements InterfaceC2526wj {

        public final Set f1847a;

        public final InterfaceC2526wj f1848b;

        public a(Set set, InterfaceC2526wj interfaceC2526wj) {
            this.f1847a = set;
            this.f1848b = interfaceC2526wj;
        }
    }

    public C0582Mk(Component component, InterfaceC0466K5 interfaceC0466K5) {
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        HashSet hashSet3 = new HashSet();
        HashSet hashSet4 = new HashSet();
        HashSet hashSet5 = new HashSet();
        for (Dependency dependency : component.m1803g()) {
            if (dependency.m879d()) {
                boolean zM881f = dependency.m881f();
                C0167Dj c0167DjM877b = dependency.m877b();
                if (zM881f) {
                    hashSet4.add(c0167DjM877b);
                } else {
                    hashSet.add(c0167DjM877b);
                }
            } else if (dependency.m878c()) {
                hashSet3.add(dependency.m877b());
            } else {
                boolean zM881f2 = dependency.m881f();
                C0167Dj c0167DjM877b2 = dependency.m877b();
                if (zM881f2) {
                    hashSet5.add(c0167DjM877b2);
                } else {
                    hashSet2.add(c0167DjM877b2);
                }
            }
        }
        if (!component.m1807k().isEmpty()) {
            hashSet.add(C0167Dj.m716b(InterfaceC2526wj.class));
        }
        this.f1840a = Collections.unmodifiableSet(hashSet);
        this.f1841b = Collections.unmodifiableSet(hashSet2);
        this.f1842c = Collections.unmodifiableSet(hashSet3);
        this.f1843d = Collections.unmodifiableSet(hashSet4);
        this.f1844e = Collections.unmodifiableSet(hashSet5);
        this.f1845f = component.m1807k();
        this.f1846g = interfaceC0466K5;
    }

    @Override
    public Object mo2282a(Class cls) {
        if (!this.f1840a.contains(C0167Dj.m716b(cls))) {
            throw new C0285G8(String.format("Attempting to request an undeclared dependency %s.", cls));
        }
        Object objMo2282a = this.f1846g.mo2282a(cls);
        return !cls.equals(InterfaceC2526wj.class) ? objMo2282a : new a(this.f1845f, (InterfaceC2526wj) objMo2282a);
    }

    @Override
    public InterfaceC2388tj mo2283b(C0167Dj c0167Dj) {
        if (this.f1844e.contains(c0167Dj)) {
            return this.f1846g.mo2283b(c0167Dj);
        }
        throw new C0285G8(String.format("Attempting to request an undeclared dependency Provider<Set<%s>>.", c0167Dj));
    }

    @Override
    public InterfaceC2388tj mo2284c(Class cls) {
        return mo2287f(C0167Dj.m716b(cls));
    }

    @Override
    public Set mo2285d(C0167Dj c0167Dj) {
        if (this.f1843d.contains(c0167Dj)) {
            return this.f1846g.mo2285d(c0167Dj);
        }
        throw new C0285G8(String.format("Attempting to request an undeclared dependency Set<%s>.", c0167Dj));
    }

    @Override
    public InterfaceC2388tj mo2287f(C0167Dj c0167Dj) {
        if (this.f1841b.contains(c0167Dj)) {
            return this.f1846g.mo2287f(c0167Dj);
        }
        throw new C0285G8(String.format("Attempting to request an undeclared dependency Provider<%s>.", c0167Dj));
    }

    @Override
    public Object mo2288g(C0167Dj c0167Dj) {
        if (this.f1840a.contains(c0167Dj)) {
            return this.f1846g.mo2288g(c0167Dj);
        }
        throw new C0285G8(String.format("Attempting to request an undeclared dependency %s.", c0167Dj));
    }
}
