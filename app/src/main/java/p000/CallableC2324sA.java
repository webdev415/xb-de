package p000;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class CallableC2324sA implements Callable {

    public final String f7024a;

    public final BinderC0183Dz f7025b;

    public CallableC2324sA(BinderC0183Dz binderC0183Dz, String str) {
        this.f7024a = str;
        this.f7025b = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f7025b.f441c.m968z0();
        return this.f7025b.f441c.m946l0().m2509X0(this.f7024a);
    }
}
