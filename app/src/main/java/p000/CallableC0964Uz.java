package p000;

import java.util.concurrent.Callable;

public final class CallableC0964Uz implements Callable {

    public final String f2899a;

    public final String f2900b;

    public final String f2901c;

    public final BinderC0183Dz f2902d;

    public CallableC0964Uz(BinderC0183Dz binderC0183Dz, String str, String str2, String str3) {
        this.f2899a = str;
        this.f2900b = str2;
        this.f2901c = str3;
        this.f2902d = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f2902d.f441c.m968z0();
        return this.f2902d.f441c.m946l0().m2472D0(this.f2899a, this.f2900b, this.f2901c);
    }
}
