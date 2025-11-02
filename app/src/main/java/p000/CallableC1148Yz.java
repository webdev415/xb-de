package p000;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class CallableC1148Yz implements Callable {

    public final String f3375a;

    public final String f3376b;

    public final String f3377c;

    public final BinderC0183Dz f3378d;

    public CallableC1148Yz(BinderC0183Dz binderC0183Dz, String str, String str2, String str3) {
        this.f3375a = str;
        this.f3376b = str2;
        this.f3377c = str3;
        this.f3378d = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f3378d.f441c.m968z0();
        return this.f3378d.f441c.m946l0().m2491N(this.f3375a, this.f3376b, this.f3377c);
    }
}
