package p000;

/* loaded from: classes.dex */
public final class RunnableC2190pE implements Runnable {

    public final InterfaceC1707ex f6638l;

    public final ServiceConnectionC1959kE f6639m;

    public RunnableC2190pE(ServiceConnectionC1959kE serviceConnectionC1959kE, InterfaceC1707ex interfaceC1707ex) {
        this.f6638l = interfaceC1707ex;
        this.f6639m = serviceConnectionC1959kE;
    }

    @Override
    public final void run() {
        synchronized (this.f6639m) {
            try {
                this.f6639m.f5993a = false;
                if (!this.f6639m.f5995c.m8881g0()) {
                    this.f6639m.f5995c.mo349g().m9622K().m10616a("Connected to service");
                    this.f6639m.f5995c.m8865O(this.f6638l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
