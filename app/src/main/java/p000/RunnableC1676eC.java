package p000;

import java.util.concurrent.atomic.AtomicReference;

public final class RunnableC1676eC implements Runnable {

    public final AtomicReference f5402l;

    public final String f5403m = null;

    public final String f5404n;

    public final String f5405o;

    public final boolean f5406p;

    public final C1207aB f5407q;

    public RunnableC1676eC(C1207aB c1207aB, AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        this.f5402l = atomicReference;
        this.f5404n = str2;
        this.f5405o = str3;
        this.f5406p = z;
        this.f5407q = c1207aB;
    }

    @Override
    public final void run() {
        this.f5407q.f8058a.m9228J().m8858H(this.f5402l, null, this.f5404n, this.f5405o, this.f5406p);
    }
}
