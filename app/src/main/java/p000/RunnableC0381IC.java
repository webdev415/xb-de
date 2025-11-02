package p000;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class RunnableC0381IC implements Runnable {

    public final InterfaceC2076mu f1138l;

    public final String f1139m;

    public final String f1140n;

    public final boolean f1141o;

    public final AppMeasurementDynamiteService f1142p;

    public RunnableC0381IC(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC2076mu interfaceC2076mu, String str, String str2, boolean z) {
        this.f1138l = interfaceC2076mu;
        this.f1139m = str;
        this.f1140n = str2;
        this.f1141o = z;
        this.f1142p = appMeasurementDynamiteService;
    }

    @Override
    public final void run() {
        this.f1142p.f4032c.m9228J().m8863M(this.f1138l, this.f1139m, this.f1140n, this.f1141o);
    }
}
