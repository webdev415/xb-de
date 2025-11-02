package p000;

/* loaded from: classes.dex */
public final class RunnableC1056Wz implements Runnable {

    public final C2303rq f3161l;

    public final BinderC0183Dz f3162m;

    public RunnableC1056Wz(BinderC0183Dz binderC0183Dz, C2303rq c2303rq) {
        this.f3161l = c2303rq;
        this.f3162m = binderC0183Dz;
    }

    @Override
    public final void run() {
        this.f3162m.f441c.m968z0();
        if (this.f3161l.f6978n.m8448d() == null) {
            this.f3162m.f441c.m967z(this.f3161l);
        } else {
            this.f3162m.f441c.m925X(this.f3161l);
        }
    }
}
