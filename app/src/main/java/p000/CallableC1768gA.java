package p000;

import java.util.concurrent.Callable;

/* loaded from: classes.dex */
public final class CallableC1768gA implements Callable {

    public final C0569MG f5599a;

    public final BinderC0183Dz f5600b;

    public CallableC1768gA(BinderC0183Dz binderC0183Dz, C0569MG c0569mg) {
        this.f5599a = c0569mg;
        this.f5600b = binderC0183Dz;
    }

    @Override
    public final Object call() {
        this.f5600b.f441c.m968z0();
        return new C0312Gq(this.f5600b.f441c.m935f(this.f5599a.f1787l));
    }
}
