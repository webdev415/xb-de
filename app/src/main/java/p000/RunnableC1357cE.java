package p000;

import android.os.RemoteException;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class RunnableC1357cE implements Runnable {

    public final boolean f3939l = true;

    public final C0569MG f3940m;

    public final boolean f3941n;

    public final C2303rq f3942o;

    public final C2303rq f3943p;

    public final C2142oD f3944q;

    public RunnableC1357cE(C2142oD c2142oD, boolean z, C0569MG c0569mg, boolean z2, C2303rq c2303rq, C2303rq c2303rq2) {
        this.f3940m = c0569mg;
        this.f3941n = z2;
        this.f3942o = c2303rq;
        this.f3943p = c2303rq2;
        this.f3944q = c2142oD;
    }

    @Override
    public final void run() throws Throwable {
        InterfaceC1707ex interfaceC1707ex = this.f3944q.f6550d;
        if (interfaceC1707ex == null) {
            this.f3944q.mo349g().m9618G().m10616a("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.f3939l) {
            AbstractC1085Xi.m4801j(this.f3940m);
            this.f3944q.m8866P(interfaceC1707ex, this.f3941n ? null : this.f3942o, this.f3940m);
        } else {
            try {
                if (TextUtils.isEmpty(this.f3943p.f6976l)) {
                    AbstractC1085Xi.m4801j(this.f3940m);
                    interfaceC1707ex.mo821j(this.f3942o, this.f3940m);
                } else {
                    interfaceC1707ex.mo802F(this.f3942o);
                }
            } catch (RemoteException e) {
                this.f3944q.mo349g().m9618G().m10617b("Failed to send conditional user property to the service", e);
            }
        }
        this.f3944q.m8849m0();
    }
}
