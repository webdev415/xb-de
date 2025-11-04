package p000;

import android.os.RemoteException;
import android.text.TextUtils;

public final class RunnableC1678eE implements Runnable {

    public final boolean f5408l;

    public final C0569MG f5409m;

    public final boolean f5410n;

    public final C0635Nr f5411o;

    public final String f5412p;

    public final C2142oD f5413q;

    public RunnableC1678eE(C2142oD c2142oD, boolean z, C0569MG c0569mg, boolean z2, C0635Nr c0635Nr, String str) {
        this.f5408l = z;
        this.f5409m = c0569mg;
        this.f5410n = z2;
        this.f5411o = c0635Nr;
        this.f5412p = str;
        this.f5413q = c2142oD;
    }

    @Override
    public final void run() throws Throwable {
        InterfaceC1707ex interfaceC1707ex = this.f5413q.f6550d;
        if (interfaceC1707ex == null) {
            this.f5413q.mo349g().m9618G().m10616a("Discarding data. Failed to send event to service");
            return;
        }
        if (this.f5408l) {
            AbstractC1085Xi.m4801j(this.f5409m);
            this.f5413q.m8866P(interfaceC1707ex, this.f5410n ? null : this.f5411o, this.f5409m);
        } else {
            try {
                if (TextUtils.isEmpty(this.f5412p)) {
                    AbstractC1085Xi.m4801j(this.f5409m);
                    interfaceC1707ex.mo827r(this.f5411o, this.f5409m);
                } else {
                    interfaceC1707ex.mo807K(this.f5411o, this.f5412p, this.f5413q.mo349g().m9626O());
                }
            } catch (RemoteException e) {
                this.f5413q.mo349g().m9618G().m10617b("Failed to send event to the service", e);
            }
        }
        this.f5413q.m8849m0();
    }
}
