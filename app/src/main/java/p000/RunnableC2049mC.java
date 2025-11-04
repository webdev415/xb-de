package p000;

import java.util.concurrent.atomic.AtomicReference;

public final class RunnableC2049mC implements Runnable {

    public final AtomicReference f6148l;

    public final C1207aB f6149m;

    public RunnableC2049mC(C1207aB c1207aB, AtomicReference atomicReference) {
        this.f6148l = atomicReference;
        this.f6149m = c1207aB;
    }

    @Override
    public final void run() {
        synchronized (this.f6148l) {
            try {
                try {
                    this.f6148l.set(Integer.valueOf(this.f6149m.mo347e().m10823y(this.f6149m.mo3784p().m7770F(), AbstractC0818Rr.f2461Q)));
                } finally {
                    this.f6148l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
