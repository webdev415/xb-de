package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2141oC implements Runnable {

    public final AtomicReference f6547l;

    public final C1207aB f6548m;

    public RunnableC2141oC(C1207aB c1207aB, AtomicReference atomicReference) {
        this.f6547l = atomicReference;
        this.f6548m = c1207aB;
    }

    @Override
    public final void run() {
        synchronized (this.f6547l) {
            try {
                try {
                    this.f6547l.set(Long.valueOf(this.f6548m.mo347e().m10793C(this.f6548m.mo3784p().m7770F(), AbstractC0818Rr.f2459P)));
                } finally {
                    this.f6547l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
