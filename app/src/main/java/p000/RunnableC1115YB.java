package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC1115YB implements Runnable {

    public final long f3317l;

    public final C1207aB f3318m;

    public RunnableC1115YB(C1207aB c1207aB, long j) {
        this.f3317l = j;
        this.f3318m = c1207aB;
    }

    @Override
    public final void run() {
        this.f3318m.m5140M0(this.f3317l);
        this.f3318m.mo3788t().m8855E(new AtomicReference());
    }
}
