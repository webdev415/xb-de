package p000;

public final class RunnableC2419uD implements Runnable {

    public final C0569MG f7384l;

    public final boolean f7385m;

    public final C2053mG f7386n;

    public final C2142oD f7387o;

    public RunnableC2419uD(C2142oD c2142oD, C0569MG c0569mg, boolean z, C2053mG c2053mG) {
        this.f7384l = c0569mg;
        this.f7385m = z;
        this.f7386n = c2053mG;
        this.f7387o = c2142oD;
    }

    @Override
    public final void run() throws Throwable {
        InterfaceC1707ex interfaceC1707ex = this.f7387o.f6550d;
        if (interfaceC1707ex == null) {
            this.f7387o.mo349g().m9618G().m10616a("Discarding data. Failed to set user property");
            return;
        }
        AbstractC1085Xi.m4801j(this.f7384l);
        this.f7387o.m8866P(interfaceC1707ex, this.f7385m ? null : this.f7386n, this.f7384l);
        this.f7387o.m8849m0();
    }
}
