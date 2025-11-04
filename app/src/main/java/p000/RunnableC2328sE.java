package p000;

public final class RunnableC2328sE implements Runnable {

    public final InterfaceC1707ex f7028l;

    public final ServiceConnectionC1959kE f7029m;

    public RunnableC2328sE(ServiceConnectionC1959kE serviceConnectionC1959kE, InterfaceC1707ex interfaceC1707ex) {
        this.f7028l = interfaceC1707ex;
        this.f7029m = serviceConnectionC1959kE;
    }

    @Override
    public final void run() {
        synchronized (this.f7029m) {
            try {
                this.f7029m.f5993a = false;
                if (!this.f7029m.f5995c.m8881g0()) {
                    this.f7029m.f5995c.mo349g().m9617F().m10616a("Connected to remote service");
                    this.f7029m.f5995c.m8865O(this.f7028l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
