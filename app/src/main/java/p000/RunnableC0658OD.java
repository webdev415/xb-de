package p000;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class RunnableC0658OD implements Runnable {

    public final C0569MG f2011l;

    public final C2142oD f2012m;

    public RunnableC0658OD(C2142oD c2142oD, C0569MG c0569mg) {
        this.f2011l = c0569mg;
        this.f2012m = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f2012m.f6550d;
        if (interfaceC1707ex == null) {
            this.f2012m.mo349g().m9623L().m10616a("Failed to send app backgrounded");
            return;
        }
        try {
            AbstractC1085Xi.m4801j(this.f2011l);
            interfaceC1707ex.mo830w(this.f2011l);
            this.f2012m.m8849m0();
        } catch (RemoteException e) {
            this.f2012m.mo349g().m9618G().m10617b("Failed to send app backgrounded to the service", e);
        }
    }
}
