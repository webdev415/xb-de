package p000;

public final class RunnableC0518LB implements Runnable {

    public final boolean f1697l;

    public final C1207aB f1698m;

    public RunnableC0518LB(C1207aB c1207aB, boolean z) {
        this.f1697l = z;
        this.f1698m = c1207aB;
    }

    @Override
    public final void run() {
        boolean zM9242p = this.f1698m.f8058a.m9242p();
        boolean zM9241o = this.f1698m.f8058a.m9241o();
        this.f1698m.f8058a.m9239m(this.f1697l);
        if (zM9241o == this.f1697l) {
            this.f1698m.f8058a.mo349g().m9622K().m10617b("Default data collection state already set to", Boolean.valueOf(this.f1697l));
        }
        if (this.f1698m.f8058a.m9242p() == zM9242p || this.f1698m.f8058a.m9242p() != this.f1698m.f8058a.m9241o()) {
            this.f1698m.f8058a.mo349g().m9624M().m10618c("Default data collection is different than actual status", Boolean.valueOf(this.f1697l), Boolean.valueOf(zM9242p));
        }
        this.f1698m.m5137K0();
    }
}
