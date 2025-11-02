package p000;

import android.os.RemoteException;

/* loaded from: classes.dex */
public final class RunnableC0566MD implements Runnable {

    public final C1162ZC f1764l;

    public final C2142oD f1765m;

    public RunnableC0566MD(C2142oD c2142oD, C1162ZC c1162zc) {
        this.f1764l = c1162zc;
        this.f1765m = c2142oD;
    }

    @Override
    public final void run() {
        InterfaceC1707ex interfaceC1707ex = this.f1765m.f6550d;
        if (interfaceC1707ex == null) {
            this.f1765m.mo349g().m9618G().m10616a("Failed to send current screen to service");
            return;
        }
        try {
            C1162ZC c1162zc = this.f1764l;
            if (c1162zc == null) {
                interfaceC1707ex.mo832y(0L, null, null, this.f1765m.mo344a().getPackageName());
            } else {
                interfaceC1707ex.mo832y(c1162zc.f3423c, c1162zc.f3421a, c1162zc.f3422b, this.f1765m.mo344a().getPackageName());
            }
            this.f1765m.m8849m0();
        } catch (RemoteException e) {
            this.f1765m.mo349g().m9618G().m10617b("Failed to send current screen to the service", e);
        }
    }
}
