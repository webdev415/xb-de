package p000;

import java.util.concurrent.Callable;

public final class CallableC1206aA implements Callable {

    public final String f3498a;

    public final String f3499b;

    public final String f3500c;

    public final BinderC0183Dz f3501d;

    public CallableC1206aA(BinderC0183Dz binderC0183Dz, String str, String str2, String str3) {
        this.f3498a = str;
        this.f3499b = str2;
        this.f3500c = str3;
        this.f3501d = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f3501d.f441c.m968z0();
        return this.f3501d.f441c.m946l0().m2472D0(this.f3498a, this.f3499b, this.f3500c);
    }
}
