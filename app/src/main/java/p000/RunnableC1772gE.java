package p000;

import android.os.RemoteException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class RunnableC1772gE implements Runnable {

    public final String f5611l;

    public final String f5612m;

    public final C0569MG f5613n;

    public final InterfaceC2076mu f5614o;

    public final C2142oD f5615p;

    public RunnableC1772gE(C2142oD c2142oD, String str, String str2, C0569MG c0569mg, InterfaceC2076mu interfaceC2076mu) {
        this.f5611l = str;
        this.f5612m = str2;
        this.f5613n = c0569mg;
        this.f5614o = interfaceC2076mu;
        this.f5615p = c2142oD;
    }

    @Override
    public final void run() {
        ArrayList arrayList = new ArrayList<>();
        try {
            try {
                InterfaceC1707ex interfaceC1707ex = this.f5615p.f6550d;
                if (interfaceC1707ex == null) {
                    this.f5615p.mo349g().m9618G().m10618c("Failed to get conditional properties; not connected to service", this.f5611l, this.f5612m);
                } else {
                    AbstractC1085Xi.m4801j(this.f5613n);
                    arrayList = C2514wG.m10471t0(interfaceC1707ex.mo822k(this.f5611l, this.f5612m, this.f5613n));
                    this.f5615p.m8849m0();
                }
            } catch (RemoteException e) {
                this.f5615p.mo349g().m9618G().m10619d("Failed to get conditional properties; remote exception", this.f5611l, this.f5612m, e);
            }
        } finally {
            this.f5615p.mo352j().m10501U(this.f5614o, arrayList);
        }
    }
}
