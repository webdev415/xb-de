package p000;

import android.os.Bundle;

/* loaded from: classes.dex */
public final class RunnableC1631dD implements Runnable {

    public final Bundle f5278l;

    public final C1162ZC f5279m;

    public final C1162ZC f5280n;

    public final long f5281o;

    public final C1070XC f5282p;

    public RunnableC1631dD(C1070XC c1070xc, Bundle bundle, C1162ZC c1162zc, C1162ZC c1162zc2, long j) {
        this.f5278l = bundle;
        this.f5279m = c1162zc;
        this.f5280n = c1162zc2;
        this.f5281o = j;
        this.f5282p = c1070xc;
    }

    @Override
    public final void run() {
        C1070XC.m4685J(this.f5282p, this.f5278l, this.f5279m, this.f5280n, this.f5281o);
    }
}
