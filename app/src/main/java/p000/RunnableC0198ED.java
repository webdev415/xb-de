package p000;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class RunnableC0198ED implements Runnable {

    public final C0569MG f473l;

    public final InterfaceC2076mu f474m;

    public final C2142oD f475n;

    public RunnableC0198ED(C2142oD c2142oD, C0569MG c0569mg, InterfaceC2076mu interfaceC2076mu) {
        this.f473l = c0569mg;
        this.f474m = interfaceC2076mu;
        this.f475n = c2142oD;
    }

    @Override
    public final void run() {
        String strMo819h = null;
        try {
            try {
                if (this.f475n.mo351i().m7667M().m1852B()) {
                    InterfaceC1707ex interfaceC1707ex = this.f475n.f6550d;
                    if (interfaceC1707ex == null) {
                        this.f475n.mo349g().m9618G().m10616a("Failed to get app instance id");
                    } else {
                        AbstractC1085Xi.m4801j(this.f473l);
                        strMo819h = interfaceC1707ex.mo819h(this.f473l);
                        if (strMo819h != null) {
                            this.f475n.mo3786r().m5164Z0(strMo819h);
                            this.f475n.mo351i().f5558i.m10621b(strMo819h);
                        }
                        this.f475n.m8849m0();
                    }
                } else {
                    this.f475n.mo349g().m9624M().m10616a("Analytics storage consent denied; will not get app instance id");
                    this.f475n.mo3786r().m5164Z0(null);
                    this.f475n.mo351i().f5558i.m10621b(null);
                }
            } catch (RemoteException e) {
                this.f475n.mo349g().m9618G().m10617b("Failed to get app instance id", e);
            }
        } finally {
            this.f475n.mo352j().m10500T(this.f474m, null);
        }
    }
}
