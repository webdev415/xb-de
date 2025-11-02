package p000;

import android.os.RemoteException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2603yD implements Runnable {

    public final AtomicReference f8062l;

    public final C0569MG f8063m;

    public final C2142oD f8064n;

    public RunnableC2603yD(C2142oD c2142oD, AtomicReference atomicReference, C0569MG c0569mg) {
        this.f8062l = atomicReference;
        this.f8063m = c0569mg;
        this.f8064n = c2142oD;
    }

    @Override
    public final void run() {
        AtomicReference atomicReference;
        synchronized (this.f8062l) {
            try {
                try {
                } catch (RemoteException e) {
                    this.f8064n.mo349g().m9618G().m10617b("Failed to get app instance id", e);
                    atomicReference = this.f8062l;
                }
                if (!this.f8064n.mo351i().m7667M().m1852B()) {
                    this.f8064n.mo349g().m9624M().m10616a("Analytics storage consent denied; will not get app instance id");
                    this.f8064n.mo3786r().m5164Z0(null);
                    this.f8064n.mo351i().f5558i.m10621b(null);
                    this.f8062l.set(null);
                    return;
                }
                InterfaceC1707ex interfaceC1707ex = this.f8064n.f6550d;
                if (interfaceC1707ex == null) {
                    this.f8064n.mo349g().m9618G().m10616a("Failed to get app instance id");
                    return;
                }
                AbstractC1085Xi.m4801j(this.f8063m);
                this.f8062l.set(interfaceC1707ex.mo819h(this.f8063m));
                String str = (String) this.f8062l.get();
                if (str != null) {
                    this.f8064n.mo3786r().m5164Z0(str);
                    this.f8064n.mo351i().f5558i.m10621b(str);
                }
                this.f8064n.m8849m0();
                atomicReference = this.f8062l;
                atomicReference.notify();
            } finally {
                this.f8062l.notify();
            }
        }
    }
}
