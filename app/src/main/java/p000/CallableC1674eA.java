package p000;

import java.util.concurrent.Callable;

public final class CallableC1674eA implements Callable {

    public final String f5397a;

    public final String f5398b;

    public final String f5399c;

    public final BinderC0183Dz f5400d;

    public CallableC1674eA(BinderC0183Dz binderC0183Dz, String str, String str2, String str3) {
        this.f5397a = str;
        this.f5398b = str2;
        this.f5399c = str3;
        this.f5400d = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f5400d.f441c.m968z0();
        return this.f5400d.f441c.m946l0().m2491N(this.f5397a, this.f5398b, this.f5399c);
    }
}
