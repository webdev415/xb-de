package p000;

public abstract class AbstractC0501Kv extends AbstractC1191Zw {

    public boolean f1640b;

    public AbstractC0501Kv(C2266qz c2266qz) {
        super(c2266qz);
        this.f8058a.m9240n();
    }

    public abstract boolean mo2545A();

    public final void m2546v() {
        if (!m2550z()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m2547w() {
        if (this.f1640b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (mo2545A()) {
            return;
        }
        this.f8058a.m9236R();
        this.f1640b = true;
    }

    public final void m2548x() {
        if (this.f1640b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2549y();
        this.f8058a.m9236R();
        this.f1640b = true;
    }

    public final boolean m2550z() {
        return this.f1640b;
    }

    public void mo2549y() {
    }
}
