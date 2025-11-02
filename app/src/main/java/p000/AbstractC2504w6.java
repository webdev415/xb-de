package p000;

import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public abstract class AbstractC2504w6 extends AbstractC2408u2 {

    public final InterfaceC0191E6 f7802m;

    public transient InterfaceC2458v6 f7803n;

    public AbstractC2504w6(InterfaceC2458v6 interfaceC2458v6) {
        this(interfaceC2458v6, interfaceC2458v6 != null ? interfaceC2458v6.mo197f() : null);
    }

    @Override
    public InterfaceC0191E6 mo197f() {
        InterfaceC0191E6 interfaceC0191E6 = this.f7802m;
        AbstractC0116Ce.m473b(interfaceC0191E6);
        return interfaceC0191E6;
    }

    @Override
    public void mo9898k() {
        InterfaceC2458v6 interfaceC2458v6 = this.f7803n;
        if (interfaceC2458v6 != null && interfaceC2458v6 != this) {
            InterfaceC0191E6.b bVarMo855b = mo197f().mo855b(InterfaceC2550x6.f7940a);
            AbstractC0116Ce.m473b(bVarMo855b);
            ((InterfaceC2550x6) bVarMo855b).mo1349J(interfaceC2458v6);
        }
        this.f7803n = C0052B5.f120l;
    }

    public final InterfaceC2458v6 m10432l() {
        InterfaceC2458v6 interfaceC2458v6Mo1350S = this.f7803n;
        if (interfaceC2458v6Mo1350S == null) {
            InterfaceC2550x6 interfaceC2550x6 = (InterfaceC2550x6) mo197f().mo855b(InterfaceC2550x6.f7940a);
            if (interfaceC2550x6 == null || (interfaceC2458v6Mo1350S = interfaceC2550x6.mo1350S(this)) == null) {
                interfaceC2458v6Mo1350S = this;
            }
            this.f7803n = interfaceC2458v6Mo1350S;
        }
        return interfaceC2458v6Mo1350S;
    }

    public AbstractC2504w6(InterfaceC2458v6 interfaceC2458v6, InterfaceC0191E6 interfaceC0191E6) {
        super(interfaceC2458v6);
        this.f7802m = interfaceC0191E6;
    }
}
