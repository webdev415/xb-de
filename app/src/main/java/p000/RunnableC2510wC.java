package p000;

/* loaded from: classes.dex */
public final class RunnableC2510wC implements Runnable {

    public final C1981kr f7808l;

    public final C1207aB f7809m;

    public RunnableC2510wC(C1207aB c1207aB, C1981kr c1981kr) {
        this.f7808l = c1981kr;
        this.f7809m = c1207aB;
    }

    @Override
    public final void run() {
        if (!this.f7809m.mo351i().m7655A(this.f7808l)) {
            this.f7809m.mo349g().m9621J().m10617b("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.f7808l.m8311a()));
            return;
        }
        this.f7809m.mo349g().m9622K().m10617b("Setting DMA consent(FE)", this.f7808l);
        if (this.f7809m.mo3788t().m8884j0()) {
            this.f7809m.mo3788t().m8879e0();
        } else {
            this.f7809m.mo3788t().m8869U(false);
        }
    }
}
