package p000;

public abstract class AbstractC0067Bb implements InterfaceC2161om {

    public final InterfaceC2161om f155l;

    public AbstractC0067Bb(InterfaceC2161om interfaceC2161om) {
        AbstractC0116Ce.m476e(interfaceC2161om, "delegate");
        this.f155l = interfaceC2161om;
    }

    public final InterfaceC2161om m238a() {
        return this.f155l;
    }

    @Override
    public void close() {
        this.f155l.close();
    }

    @Override
    public C0125Cn mo239d() {
        return this.f155l.mo239d();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f155l + ')';
    }
}
