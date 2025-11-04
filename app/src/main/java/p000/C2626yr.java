package p000;

import java.lang.ref.WeakReference;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class C2626yr extends Thread {

    public final WeakReference f8148l;

    public final long f8149m;

    public final CountDownLatch f8150n = new CountDownLatch(1);

    public boolean f8151o = false;

    public C2626yr(C2636z0 c2636z0, long j) {
        this.f8148l = new WeakReference(c2636z0);
        this.f8149m = j;
        start();
    }

    public final void m10969a() {
        C2636z0 c2636z0 = (C2636z0) this.f8148l.get();
        if (c2636z0 != null) {
            c2636z0.m10974c();
            this.f8151o = true;
        }
    }

    @Override
    public final void run() {
        try {
            if (this.f8150n.await(this.f8149m, TimeUnit.MILLISECONDS)) {
                return;
            }
            m10969a();
        } catch (InterruptedException unused) {
            m10969a();
        }
    }
}
