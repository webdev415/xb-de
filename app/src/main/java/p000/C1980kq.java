package p000;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class C1980kq implements InterfaceC2165oq {

    public final CountDownLatch f6033a = new CountDownLatch(1);

    public C1980kq(AbstractC1794gq abstractC1794gq) {
    }

    @Override
    public final void mo4160a(Object obj) {
        this.f6033a.countDown();
    }

    @Override
    public final void mo3672b() {
        this.f6033a.countDown();
    }

    @Override
    public final void mo3822c(Exception exc) {
        this.f6033a.countDown();
    }

    public final void m8305d() throws InterruptedException {
        this.f6033a.await();
    }

    public final boolean m8306e(long j, TimeUnit timeUnit) {
        return this.f6033a.await(j, timeUnit);
    }
}
