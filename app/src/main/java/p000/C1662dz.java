package p000;

import android.content.Context;
import java.lang.Thread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes.dex */
public final class C1662dz extends AbstractC2508wA {

    public static final AtomicLong f5351l = new AtomicLong(Long.MIN_VALUE);

    public C1989kz f5352c;

    public C1989kz f5353d;

    public final PriorityBlockingQueue f5354e;

    public final BlockingQueue f5355f;

    public final Thread.UncaughtExceptionHandler f5356g;

    public final Thread.UncaughtExceptionHandler f5357h;

    public final Object f5358i;

    public final Semaphore f5359j;

    public volatile boolean f5360k;

    public C1662dz(C2266qz c2266qz) {
        super(c2266qz);
        this.f5358i = new Object();
        this.f5359j = new Semaphore(2);
        this.f5354e = new PriorityBlockingQueue();
        this.f5355f = new LinkedBlockingQueue();
        this.f5356g = new C1850hz(this, "Thread death: Uncaught exception on worker thread");
        this.f5357h = new C1850hz(this, "Thread death: Uncaught exception on network thread");
    }

    public final Future m7373A(Callable callable) {
        m10436p();
        AbstractC1085Xi.m4801j(callable);
        C2081mz c2081mz = new C2081mz(this, callable, true, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5352c) {
            c2081mz.run();
        } else {
            m7380z(c2081mz);
        }
        return c2081mz;
    }

    public final void m7374C(Runnable runnable) {
        m10436p();
        AbstractC1085Xi.m4801j(runnable);
        m7380z(new C2081mz(this, runnable, false, "Task exception on worker thread"));
    }

    public final void m7375G(Runnable runnable) {
        m10436p();
        AbstractC1085Xi.m4801j(runnable);
        m7380z(new C2081mz(this, runnable, true, "Task exception on worker thread"));
    }

    public final boolean m7376J() {
        return Thread.currentThread() == this.f5352c;
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final void mo353k() {
        if (Thread.currentThread() != this.f5353d) {
            throw new IllegalStateException("Call expected from network thread");
        }
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final void mo356n() {
        if (Thread.currentThread() != this.f5352c) {
            throw new IllegalStateException("Call expected from worker thread");
        }
    }

    @Override
    public final boolean mo357t() {
        return false;
    }

    public final Object m7377u(AtomicReference atomicReference, long j, String str, Runnable runnable) {
        synchronized (atomicReference) {
            mo354l().m7374C(runnable);
            try {
                atomicReference.wait(j);
            } catch (InterruptedException unused) {
                mo349g().m9623L().m10616a("Interrupted waiting for " + str);
                return null;
            }
        }
        Object obj = atomicReference.get();
        if (obj == null) {
            mo349g().m9623L().m10616a("Timed out waiting for " + str);
        }
        return obj;
    }

    public final Future m7378v(Callable callable) {
        m10436p();
        AbstractC1085Xi.m4801j(callable);
        C2081mz c2081mz = new C2081mz(this, callable, false, "Task exception on worker thread");
        if (Thread.currentThread() == this.f5352c) {
            if (!this.f5354e.isEmpty()) {
                mo349g().m9623L().m10616a("Callable skipped the worker queue.");
            }
            c2081mz.run();
        } else {
            m7380z(c2081mz);
        }
        return c2081mz;
    }

    public final void m7379x(Runnable runnable) {
        m10436p();
        AbstractC1085Xi.m4801j(runnable);
        C2081mz c2081mz = new C2081mz(this, runnable, false, "Task exception on network thread");
        synchronized (this.f5358i) {
            try {
                this.f5355f.add(c2081mz);
                C1989kz c1989kz = this.f5353d;
                if (c1989kz == null) {
                    C1989kz c1989kz2 = new C1989kz(this, "Measurement Network", this.f5355f);
                    this.f5353d = c1989kz2;
                    c1989kz2.setUncaughtExceptionHandler(this.f5357h);
                    this.f5353d.start();
                } else {
                    c1989kz.m8340a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m7380z(C2081mz c2081mz) {
        synchronized (this.f5358i) {
            try {
                this.f5354e.add(c2081mz);
                C1989kz c1989kz = this.f5352c;
                if (c1989kz == null) {
                    C1989kz c1989kz2 = new C1989kz(this, "Measurement Worker", this.f5354e);
                    this.f5352c = c1989kz2;
                    c1989kz2.setUncaughtExceptionHandler(this.f5356g);
                    this.f5352c.start();
                } else {
                    c1989kz.m8340a();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
