package p000;

import p000.InterfaceC0191E6;

public abstract class AbstractC0000A implements InterfaceC0191E6.c {

    public final InterfaceC0986Vb f0l;

    public final InterfaceC0191E6.c f1m;

    public AbstractC0000A(InterfaceC0191E6.c cVar, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC0116Ce.m476e(cVar, "baseKey");
        AbstractC0116Ce.m476e(interfaceC0986Vb, "safeCast");
        this.f0l = interfaceC0986Vb;
        this.f1m = cVar instanceof AbstractC0000A ? ((AbstractC0000A) cVar).f1m : cVar;
    }

    public final boolean m0a(InterfaceC0191E6.c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        return cVar == this || this.f1m == cVar;
    }

    public final InterfaceC0191E6.b m1b(InterfaceC0191E6.b bVar) {
        AbstractC0116Ce.m476e(bVar, "element");
        return (InterfaceC0191E6.b) this.f0l.mo15n(bVar);
    }
}
