package p000;

import android.os.RemoteException;

public final class RunnableC0106CD implements Runnable {

    public final C0569MG f248l;

    public final C2142oD f249m;

    public RunnableC0106CD(C2142oD c2142oD, C0569MG c0569mg) {
        this.f248l = c0569mg;
        this.f249m = c2142oD;
    }

    @Override
    public final void run() throws Throwable {
        InterfaceC1707ex interfaceC1707ex = this.f249m.f6550d;
        if (interfaceC1707ex == null) {
            this.f249m.mo349g().m9618G().m10616a("Discarding data. Failed to send app launch");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f248l);
            interfaceC1707ex.mo820i(this.f248l);
            this.f249m.mo3785q().m8665J();
            this.f249m.m8866P(interfaceC1707ex, null, this.f248l);
            this.f249m.m8849m0();
        } catch (RemoteException e) {
            this.f249m.mo349g().m9618G().m10617b("Failed to send app launch to the service", e);
        }
    }
}
