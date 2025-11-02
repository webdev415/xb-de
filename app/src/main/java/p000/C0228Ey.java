package p000;

import android.content.Context;
import android.content.Intent;

/* loaded from: classes.dex */
public final class C0228Ey {

    public final a f606a;

    public interface a {
        void mo1158a(Context context, Intent intent);
    }

    public C0228Ey(a aVar) {
        AbstractC1085Xi.m4801j(aVar);
        this.f606a = aVar;
    }

    public final void m1157a(Context context, Intent intent) {
        C2356sx c2356sxMo349g = C2266qz.m9214c(context, null, null).mo349g();
        if (intent == null) {
            c2356sxMo349g.m9623L().m10616a("Receiver called with null intent");
            return;
        }
        String action = intent.getAction();
        c2356sxMo349g.m9622K().m10617b("Local receiver got", action);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(action)) {
            if ("com.android.vending.INSTALL_REFERRER".equals(action)) {
                c2356sxMo349g.m9623L().m10616a("Install Referrer Broadcasts are deprecated");
            }
        } else {
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            c2356sxMo349g.m9622K().m10616a("Starting wakeful intent.");
            this.f606a.mo1158a(context, className);
        }
    }
}
