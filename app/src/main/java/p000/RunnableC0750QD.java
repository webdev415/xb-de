package p000;

import android.os.Bundle;
import android.os.RemoteException;

public final class RunnableC0750QD implements Runnable {

    public final C0569MG f2214l;

    public final Bundle f2215m;

    public final C2142oD f2216n;

    public RunnableC0750QD(C2142oD c2142oD, C0569MG c0569mg, Bundle bundle) {
        this.f2214l = c0569mg;
        this.f2215m = bundle;
        this.f2216n = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f2216n.f6550d;
        if (interfaceC1707ex == null) {
            this.f2216n.mo349g().m9618G().m10616a("Failed to send default event parameters to service");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f2214l);
            interfaceC1707ex.mo829v(this.f2215m, this.f2214l);
        } catch (RemoteException e) {
            this.f2216n.mo349g().m9618G().m10617b("Failed to send default event parameters to service", e);
        }
    }
}
