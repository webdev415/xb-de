package p000;

import android.content.ComponentName;

/* loaded from: classes.dex */
public final class RunnableC2143oE implements Runnable {

    public final ComponentName f6556l;

    public final ServiceConnectionC1959kE f6557m;

    public RunnableC2143oE(ServiceConnectionC1959kE serviceConnectionC1959kE, ComponentName componentName) {
        this.f6556l = componentName;
        this.f6557m = serviceConnectionC1959kE;
    }

    @Override
    public final void run() {
        C2142oD.m8846R(this.f6557m.f5995c, this.f6556l);
    }
}
