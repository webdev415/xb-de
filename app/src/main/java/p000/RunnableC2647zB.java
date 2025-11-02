package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC2647zB implements Runnable {

    public final AtomicReference f8179l;

    public final C1207aB f8180m;

    public RunnableC2647zB(C1207aB c1207aB, AtomicReference atomicReference) {
        this.f8179l = atomicReference;
        this.f8180m = c1207aB;
    }

    @Override
    public final void run() {
        synchronized (this.f8179l) {
            try {
                try {
                    this.f8179l.set(Boolean.valueOf(this.f8180m.mo347e().m10804O(this.f8180m.mo3784p().m7770F())));
                } finally {
                    this.f8179l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
