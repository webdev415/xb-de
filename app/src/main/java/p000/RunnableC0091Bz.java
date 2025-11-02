package p000;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* loaded from: classes.dex */
public final class RunnableC0091Bz implements Runnable {

    public final InterfaceC2076mu f225l;

    public final C0635Nr f226m;

    public final String f227n;

    public final AppMeasurementDynamiteService f228o;

    public RunnableC0091Bz(AppMeasurementDynamiteService appMeasurementDynamiteService, InterfaceC2076mu interfaceC2076mu, C0635Nr c0635Nr, String str) {
        this.f225l = interfaceC2076mu;
        this.f226m = c0635Nr;
        this.f227n = str;
        this.f228o = appMeasurementDynamiteService;
    }

    @Override
    public final void run() {
        this.f228o.f4032c.m9228J().m8864N(this.f225l, this.f226m, this.f227n);
    }
}
