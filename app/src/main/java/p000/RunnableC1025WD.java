package p000;

import android.os.Bundle;
import android.os.RemoteException;

/* loaded from: classes.dex */
public final class RunnableC1025WD implements Runnable {

    public final C0569MG f3043l;

    public final Bundle f3044m;

    public final C2142oD f3045n;

    public RunnableC1025WD(C2142oD c2142oD, C0569MG c0569mg, Bundle bundle) {
        this.f3043l = c0569mg;
        this.f3044m = bundle;
        this.f3045n = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f3045n.f6550d;
        if (interfaceC1707ex == null) {
            this.f3045n.mo349g().m9618G().m10616a("Failed to send default event parameters to service");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f3043l);
            interfaceC1707ex.mo823m(this.f3044m, this.f3043l);
        } catch (RemoteException e) {
            this.f3045n.mo349g().m9618G().m10617b("Failed to send default event parameters to service", e);
        }
    }
}
