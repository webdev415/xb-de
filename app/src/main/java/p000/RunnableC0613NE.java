package p000;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

public final class RunnableC0613NE implements Runnable {

    public final InterfaceC2076mu f1918l;

    public final String f1919m;

    public final String f1920n;

    public final AppMeasurementDynamiteService f1921o;

    public RunnableC0613NE(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC2076mu interfaceC2076mu, String str, String str2) {
        this.f1918l = interfaceC2076mu;
        this.f1919m = str;
        this.f1920n = str2;
        this.f1921o = appMeasurementDynamiteService;
    }

    @Override
    public final void run() {
        this.f1921o.f4032c.m9228J().m8862L(this.f1918l, this.f1919m, this.f1920n);
    }
}
