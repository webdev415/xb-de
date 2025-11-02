package p000;

import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class C2604yE {

    public final Context f8065a;

    public C2604yE(Context context) {
        AbstractC1085Xi.m4801j(context);
        this.f8065a = context;
    }

    public final int m10839a(final Intent intent, int i, final int i2) {
        final C2356sx c2356sxMo349g = C2266qz.m9214c(this.f8065a, null, null).mo349g();
        if (intent == null) {
            c2356sxMo349g.m9623L().m10616a("AppMeasurementService started with null intent");
            return 2;
        }
        String action = intent.getAction();
        c2356sxMo349g.m9622K().m10618c("Local AppMeasurementService called. startId, action", Integer.valueOf(i2), action);
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            m10843e(new Runnable() {
                @Override
                public final void run() {
                    this.f250l.m10842d(i2, c2356sxMo349g, intent);
                }
            });
        }
        return 2;
    }

    public final IBinder m10840b(Intent intent) {
        if (intent == null) {
            m10848j().m9618G().m10616a("onBind called with null intent");
            return null;
        }
        String action = intent.getAction();
        if ("com.google.android.gms.measurement.START".equals(action)) {
            return new BinderC0183Dz(C0200EF.m899o(this.f8065a));
        }
        m10848j().m9623L().m10617b("onBind received unknown action", action);
        return null;
    }

    public final void m10841c() {
        C2266qz.m9214c(this.f8065a, null, null).mo349g().m9622K().m10616a("Local AppMeasurementService is starting up");
    }

    public final void m10842d(int i, C2356sx c2356sx, Intent intent) {
        if (((InterfaceC0291GE) this.f8065a).mo1369e(i)) {
            c2356sx.m9622K().m10617b("Local AppMeasurementService processed last upload request. StartId", Integer.valueOf(i));
            m10848j().m9622K().m10616a("Completed wakeful intent.");
            ((InterfaceC0291GE) this.f8065a).mo1367a(intent);
        }
    }

    public final void m10843e(Runnable runnable) {
        C0200EF c0200efM899o = C0200EF.m899o(this.f8065a);
        c0200efM899o.mo354l().m7374C(new RunnableC0383IE(this, c0200efM899o, runnable));
    }

    public final void m10844f(C2356sx c2356sx, JobParameters jobParameters) {
        c2356sx.m9622K().m10616a("AppMeasurementJobService processed last upload request.");
        ((InterfaceC0291GE) this.f8065a).mo1368b(jobParameters, false);
    }

    public final boolean m10845g(final JobParameters jobParameters) {
        final C2356sx c2356sxMo349g = C2266qz.m9214c(this.f8065a, null, null).mo349g();
        String string = jobParameters.getExtras().getString("action");
        c2356sxMo349g.m9622K().m10617b("Local AppMeasurementJobService called. action", string);
        if (!"com.google.android.gms.measurement.UPLOAD".equals(string)) {
            return true;
        }
        m10843e(new Runnable() {
            @Override
            public final void run() {
                this.f476l.m10844f(c2356sxMo349g, jobParameters);
            }
        });
        return true;
    }

    public final void m10846h() {
        C2266qz.m9214c(this.f8065a, null, null).mo349g().m9622K().m10616a("Local AppMeasurementService is shutting down");
    }

    public final void m10847i(Intent intent) {
        if (intent == null) {
            m10848j().m9618G().m10616a("onRebind called with null intent");
        } else {
            m10848j().m9622K().m10617b("onRebind called. action", intent.getAction());
        }
    }

    public final C2356sx m10848j() {
        return C2266qz.m9214c(this.f8065a, null, null).mo349g();
    }

    public final boolean m10849k(Intent intent) {
        if (intent == null) {
            m10848j().m9618G().m10616a("onUnbind called with null intent");
            return true;
        }
        m10848j().m9622K().m10617b("onUnbind called for intent. action", intent.getAction());
        return true;
    }
}
