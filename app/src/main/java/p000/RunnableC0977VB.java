package p000;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class RunnableC0977VB implements Runnable {

    public final AtomicReference f2954l;

    public final C1207aB f2955m;

    public RunnableC0977VB(C1207aB c1207aB, AtomicReference atomicReference) {
        this.f2954l = atomicReference;
        this.f2955m = c1207aB;
    }

    @Override
    public final void run() {
        synchronized (this.f2954l) {
            try {
                try {
                    this.f2954l.set(this.f2955m.mo347e().m10799I(this.f2955m.mo3784p().m7770F()));
                } finally {
                    this.f2954l.notify();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
