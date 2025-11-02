package p000;

import android.os.Bundle;
import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2511wD implements Runnable {

    public final AtomicReference f7810l;

    public final C0569MG f7811m;

    public final Bundle f7812n;

    public final C2142oD f7813o;

    public RunnableC2511wD(C2142oD c2142oD, AtomicReference atomicReference, C0569MG c0569mg, Bundle bundle) {
        this.f7810l = atomicReference;
        this.f7811m = c0569mg;
        this.f7812n = bundle;
        this.f7813o = c2142oD;
    }

    @Override
    public final void run() {
        AtomicReference atomicReference;
        InterfaceC1707ex interfaceC1707ex;
        synchronized (this.f7810l) {
            try {
                try {
                    interfaceC1707ex = this.f7813o.f6550d;
                } catch (RemoteException e) {
                    this.f7813o.mo349g().m9618G().m10617b("Failed to get trigger URIs; remote exception", e);
                    atomicReference = this.f7810l;
                }
                if (interfaceC1707ex == null) {
                    this.f7813o.mo349g().m9618G().m10616a("Failed to get trigger URIs; not connected to service");
                    return;
                }
                AbstractC1085Xi.m4801j(this.f7811m);
                this.f7810l.set(interfaceC1707ex.mo804H(this.f7811m, this.f7812n));
                this.f7813o.m8849m0();
                atomicReference = this.f7810l;
                atomicReference.notify();
            } finally {
                this.f7810l.notify();
            }
        }
    }
}
