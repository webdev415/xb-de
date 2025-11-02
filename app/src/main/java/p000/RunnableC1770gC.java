package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC1770gC implements Runnable {

    public final AtomicReference f5606l;

    public final String f5607m = null;

    public final String f5608n;

    public final String f5609o;

    public final C1207aB f5610p;

    public RunnableC1770gC(C1207aB c1207aB, AtomicReference atomicReference, String str, String str2, String str3) {
        this.f5606l = atomicReference;
        this.f5608n = str2;
        this.f5609o = str3;
        this.f5610p = c1207aB;
    }

    @Override
    public final void run() {
        this.f5610p.f8058a.m9228J().m8857G(this.f5606l, null, this.f5608n, this.f5609o);
    }
}
