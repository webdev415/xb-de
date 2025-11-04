package p000;

import android.os.RemoteException;

public final class RunnableC1210aE implements Runnable {

    public final C0569MG f3523l;

    public final C2142oD f3524m;

    public RunnableC1210aE(C2142oD c2142oD, C0569MG c0569mg) {
        this.f3523l = c0569mg;
        this.f3524m = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f3524m.f6550d;
        if (interfaceC1707ex == null) {
            this.f3524m.mo349g().m9618G().m10616a("Failed to send measurementEnabled to service");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f3523l);
            interfaceC1707ex.mo825p(this.f3523l);
            this.f3524m.m8849m0();
        } catch (RemoteException e) {
            this.f3524m.mo349g().m9618G().m10617b("Failed to send measurementEnabled to the service", e);
        }
    }
}
