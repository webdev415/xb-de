package p000;

import android.os.RemoteException;

public final class RunnableC0014AD implements Runnable {

    public final C0569MG f46l;

    public final C2142oD f47m;

    public RunnableC0014AD(C2142oD c2142oD, C0569MG c0569mg) {
        this.f46l = c0569mg;
        this.f47m = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f47m.f6550d;
        if (interfaceC1707ex == null) {
            this.f47m.mo349g().m9618G().m10616a("Failed to reset data on the service: not connected to service");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f46l);
            interfaceC1707ex.mo801C(this.f46l);
        } catch (RemoteException e) {
            this.f47m.mo349g().m9618G().m10617b("Failed to reset data on the service: remote exception", e);
        }
        this.f47m.m8849m0();
    }
}
