package p000;

/* loaded from: classes.dex */
public final class C0612ND implements InterfaceC1632dE {

    public InterfaceC1632dE[] f1917a;

    public C0612ND(InterfaceC1632dE... interfaceC1632dEArr) {
        this.f1917a = interfaceC1632dEArr;
    }

    @Override
    public final InterfaceC1725fE mo633a(Class cls) {
        for (InterfaceC1632dE interfaceC1632dE : this.f1917a) {
            if (interfaceC1632dE.mo634b(cls)) {
                return interfaceC1632dE.mo633a(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    @Override
    public final boolean mo634b(Class cls) {
        for (InterfaceC1632dE interfaceC1632dE : this.f1917a) {
            if (interfaceC1632dE.mo634b(cls)) {
                return true;
            }
        }
        return false;
    }
}
