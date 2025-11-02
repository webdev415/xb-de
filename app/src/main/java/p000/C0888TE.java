package p000;

public final class C0888TE {

    public RunnableC1164ZE f2737a;

    public final C0796RE f2738b;

    public C0888TE(C0796RE c0796re) {
        this.f2738b = c0796re;
    }

    public final void m4122a() {
        this.f2738b.mo356n();
        if (this.f2737a != null) {
            this.f2738b.f2361c.removeCallbacks(this.f2737a);
        }
        this.f2738b.mo351i().f5570u.m8427a(false);
        this.f2738b.m3779D(false);
        if (this.f2738b.mo347e().m10818t(AbstractC0818Rr.f2452L0) && this.f2738b.mo3786r().m5135J0()) {
            this.f2738b.mo349g().m9622K().m10616a("Retrying trigger URI registration in foreground");
            this.f2738b.mo3786r().m5131H0();
        }
    }

    public final void m4123b(long j) {
        this.f2737a = new RunnableC1164ZE(this, this.f2738b.mo345b().mo2815a(), j);
        this.f2738b.f2361c.postDelayed(this.f2737a, 2000L);
    }
}
