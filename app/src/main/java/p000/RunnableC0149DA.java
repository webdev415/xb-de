package p000;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class RunnableC0149DA implements Runnable {

    public final InterfaceC2076mu f377l;

    public final AppMeasurementDynamiteService f378m;

    public RunnableC0149DA(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC2076mu interfaceC2076mu) {
        this.f377l = interfaceC2076mu;
        this.f378m = appMeasurementDynamiteService;
    }

    @Override
    public final void run() {
        this.f378m.f4032c.m9228J().m8861K(this.f377l);
    }
}
