package p000;

import p000.AbstractC0703PC;

public final class C0840SC implements InterfaceC1632dE {

    public static final C0840SC f2607a = new C0840SC();

    public static C0840SC m4018c() {
        return f2607a;
    }

    @Override
    public final InterfaceC1725fE mo633a(Class cls) {
        if (!AbstractC0703PC.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (InterfaceC1725fE) AbstractC0703PC.m3499r(cls.asSubclass(AbstractC0703PC.class)).mo567m(AbstractC0703PC.c.f2102c, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    @Override
    public final boolean mo634b(Class cls) {
        return AbstractC0703PC.class.isAssignableFrom(cls);
    }
}
