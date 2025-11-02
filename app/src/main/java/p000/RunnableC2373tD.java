package p000;

import android.os.Bundle;
import android.os.RemoteException;

public final class RunnableC2373tD implements Runnable {

    public final String f7192l;

    public final String f7193m;

    public final C0569MG f7194n;

    public final boolean f7195o;

    public final InterfaceC2076mu f7196p;

    public final C2142oD f7197q;

    public RunnableC2373tD(C2142oD c2142oD, String str, String str2, C0569MG c0569mg, boolean z, InterfaceC2076mu interfaceC2076mu) {
        this.f7192l = str;
        this.f7193m = str2;
        this.f7194n = c0569mg;
        this.f7195o = z;
        this.f7196p = interfaceC2076mu;
        this.f7197q = c2142oD;
    }

    @Override
    public final void run() {
        Bundle bundle = new Bundle();
        try {
            try {
                InterfaceC1707ex interfaceC1707ex = this.f7197q.f6550d;
                if (interfaceC1707ex == null) {
                    this.f7197q.mo349g().m9618G().m10618c("Failed to get user properties; not connected to service", this.f7192l, this.f7193m);
                } else {
                    AbstractC1085Xi.m4801j(this.f7194n);
                    bundle = C2514wG.m10448G(interfaceC1707ex.mo831x(this.f7192l, this.f7193m, this.f7195o, this.f7194n));
                    this.f7197q.m8849m0();
                }
            } catch (RemoteException e) {
                this.f7197q.mo349g().m9618G().m10618c("Failed to get user properties; remote exception", this.f7192l, e);
            }
        } finally {
            this.f7197q.mo352j().m10498S(this.f7196p, bundle);
        }
    }
}
