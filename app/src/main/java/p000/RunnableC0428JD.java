package p000;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class RunnableC0428JD implements Runnable {

    public final InterfaceC2076mu f1308l;

    public final AppMeasurementDynamiteService f1309m;

    public RunnableC0428JD(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC2076mu interfaceC2076mu) {
        this.f1308l = interfaceC2076mu;
        this.f1309m = appMeasurementDynamiteService;
    }

    @Override
    public final void run() {
        this.f1309m.f4032c.m9230L().m10503V(this.f1308l, this.f1309m.f4032c.m9241o());
    }
}
