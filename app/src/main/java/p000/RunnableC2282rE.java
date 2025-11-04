package p000;

import android.content.ComponentName;

public final class RunnableC2282rE implements Runnable {

    public final ServiceConnectionC1959kE f6911l;

    public RunnableC2282rE(ServiceConnectionC1959kE serviceConnectionC1959kE) {
        this.f6911l = serviceConnectionC1959kE;
    }

    @Override
    public final void run() {
        C2142oD.m8846R(this.f6911l.f5995c, new ComponentName(this.f6911l.f5995c.mo344a(), "com.google.android.gms.measurement.AppMeasurementService"));
    }
}
