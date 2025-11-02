package p000;

import p000.C0224Eu;

public final class C1143Yu extends C0224Eu.a {

    public final Boolean f3365p;

    public final C0224Eu f3366q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1143Yu(C0224Eu c0224Eu, Boolean bool) {
        super(c0224Eu);
        this.f3365p = bool;
        this.f3366q = c0224Eu;
    }

    @Override
    public final void mo794a() {
        if (this.f3365p != null) {
            ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f3366q.f600i)).setMeasurementEnabled(this.f3365p.booleanValue(), this.f601l);
        } else {
            ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f3366q.f600i)).clearMeasurementEnabled(this.f601l);
        }
    }
}
