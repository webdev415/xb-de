package p000;

import android.os.RemoteException;

public final class RunnableC1117YD implements Runnable {

    public final C0569MG f3319l;

    public final C2142oD f3320m;

    public RunnableC1117YD(C2142oD c2142oD, C0569MG c0569mg) {
        this.f3319l = c0569mg;
        this.f3320m = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f3320m.f6550d;
        if (interfaceC1707ex == null) {
            this.f3320m.mo349g().m9618G().m10616a("Failed to send consent settings to service");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f3319l);
            interfaceC1707ex.mo824n(this.f3319l);
            this.f3320m.m8849m0();
        } catch (RemoteException e) {
            this.f3320m.mo349g().m9618G().m10617b("Failed to send consent settings to the service", e);
        }
    }
}
