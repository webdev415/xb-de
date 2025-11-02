package p000;

import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public abstract class AbstractC2635z implements InterfaceC0191E6.b {

    public final c f8164l;

    public AbstractC2635z(c cVar) {
        AbstractC0116Ce.m476e(cVar, "key");
        this.f8164l = cVar;
    }

    @Override
    public InterfaceC0191E6 mo852B(c cVar) {
        return a.m861c(this, cVar);
    }

    @Override
    public Object mo853E(Object obj, InterfaceC1920jc interfaceC1920jc) {
        return a.m859a(this, obj, interfaceC1920jc);
    }

    @Override
    public InterfaceC0191E6 mo854I(InterfaceC0191E6 interfaceC0191E6) {
        return a.m862d(this, interfaceC0191E6);
    }

    @Override
    public b mo855b(c cVar) {
        return a.m860b(this, cVar);
    }

    @Override
    public c getKey() {
        return this.f8164l;
    }
}
