package p000;

public abstract class AbstractC2513wF extends AbstractC2283rF {

    public boolean f7815c;

    public AbstractC2513wF(C0200EF c0200ef) {
        super(c0200ef);
        this.f6912b.m908C0();
    }

    public final void m10440u() {
        if (!m10442w()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m10441v() {
        if (this.f7815c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2541x();
        this.f6912b.m906B0();
        this.f7815c = true;
    }

    public final boolean m10442w() {
        return this.f7815c;
    }

    public abstract boolean mo2541x();
}
