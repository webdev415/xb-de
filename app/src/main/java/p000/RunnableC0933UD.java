package p000;

import android.os.RemoteException;

public final class RunnableC0933UD implements Runnable {

    public final C0635Nr f2841l;

    public final String f2842m;

    public final InterfaceC2076mu f2843n;

    public final C2142oD f2844o;

    public RunnableC0933UD(C2142oD c2142oD, C0635Nr c0635Nr, String str, InterfaceC2076mu interfaceC2076mu) {
        this.f2841l = c0635Nr;
        this.f2842m = str;
        this.f2843n = interfaceC2076mu;
        this.f2844o = c2142oD;
    }

    @Override
    public final void run() {
        byte[] bArrMo826q = null;
        try {
            try {
                InterfaceC1707ex interfaceC1707ex = this.f2844o.f6550d;
                if (interfaceC1707ex == null) {
                    this.f2844o.mo349g().m9618G().m10616a("Discarding data. Failed to send event to service to bundle");
                } else {
                    bArrMo826q = interfaceC1707ex.mo826q(this.f2841l, this.f2842m);
                    this.f2844o.m8849m0();
                }
            } catch (RemoteException e) {
                this.f2844o.mo349g().m9618G().m10617b("Failed to send event to the service to bundle", e);
            }
        } finally {
            this.f2844o.mo352j().m10504W(this.f2843n, bArrMo826q);
        }
    }
}
