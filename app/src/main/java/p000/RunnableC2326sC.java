package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2326sC implements Runnable {

    public final AtomicReference f7026l;

    public final C1207aB f7027m;

    public RunnableC2326sC(C1207aB c1207aB, AtomicReference atomicReference) {
        this.f7026l = atomicReference;
        this.f7027m = c1207aB;
    }

    @Override
    public final void run() {
        synchronized (this.f7026l) {
            try {
                try {
                    this.f7026l.set(Double.valueOf(this.f7027m.mo347e().m10813o(this.f7027m.mo3784p().m7770F(), AbstractC0818Rr.f2463R)));
                } finally {
                    this.f7026l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
