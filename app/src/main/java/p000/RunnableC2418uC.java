package p000;

public final class RunnableC2418uC implements Runnable {

    public final C0425JA f7378l;

    public final long f7379m;

    public final long f7380n;

    public final boolean f7381o;

    public final C0425JA f7382p;

    public final C1207aB f7383q;

    public RunnableC2418uC(C1207aB c1207aB, C0425JA c0425ja, long j, long j2, boolean z, C0425JA c0425ja2) {
        this.f7378l = c0425ja;
        this.f7379m = j;
        this.f7380n = j2;
        this.f7381o = z;
        this.f7382p = c0425ja2;
        this.f7383q = c1207aB;
    }

    @Override
    public final void run() {
        this.f7383q.m5174f0(this.f7378l);
        if (!C0798RG.m3790a() || !this.f7383q.mo347e().m10818t(AbstractC0818Rr.f2489c1)) {
            this.f7383q.m5134J(this.f7379m, false);
        }
        C1207aB.m5119m0(this.f7383q, this.f7378l, this.f7380n, true, this.f7381o);
        C1207aB.m5120n0(this.f7383q, this.f7378l, this.f7382p);
    }
}
