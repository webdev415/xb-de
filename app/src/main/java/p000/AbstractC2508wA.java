package p000;

public abstract class AbstractC2508wA extends AbstractC2600yA {

    public boolean f7807b;

    public AbstractC2508wA(C2266qz c2266qz) {
        super(c2266qz);
        this.f8058a.m9240n();
    }

    public final void m10436p() {
        if (!m10439s()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m10437q() {
        if (this.f7807b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo357t()) {
            return;
        }
        this.f8058a.m9236R();
        this.f7807b = true;
    }

    public final void m10438r() {
        if (this.f7807b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo7675o();
        this.f8058a.m9236R();
        this.f7807b = true;
    }

    public final boolean m10439s() {
        return this.f7807b;
    }

    public abstract boolean mo357t();

    public void mo7675o() {
    }
}
