package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0021Ab implements InterfaceC1134Yl {

    public final InterfaceC1134Yl f64l;

    public AbstractC0021Ab(InterfaceC1134Yl interfaceC1134Yl) {
        AbstractC0116Ce.m476e(interfaceC1134Yl, "delegate");
        this.f64l = interfaceC1134Yl;
    }

    @Override
    public void close() {
        this.f64l.close();
    }

    @Override
    public C0125Cn mo114d() {
        return this.f64l.mo114d();
    }

    @Override
    public void flush() {
        this.f64l.flush();
    }

    @Override
    public void mo115h(C2409u3 c2409u3, long j) {
        AbstractC0116Ce.m476e(c2409u3, "source");
        this.f64l.mo115h(c2409u3, j);
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f64l + ')';
    }
}
