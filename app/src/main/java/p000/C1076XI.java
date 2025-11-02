package p000;

import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;

public final class C1076XI extends AbstractC1838hn {

    public final Object f3218a = new Object();

    public final C1075XH f3219b = new C1075XH();

    public boolean f3220c;

    public volatile boolean f3221d;

    public Object f3222e;

    public Exception f3223f;

    @Override
    public final AbstractC1838hn mo4719a(Executor executor, InterfaceC0763Qh interfaceC0763Qh) {
        this.f3219b.m4717a(new C2449uy(executor, interfaceC0763Qh));
        m4733o();
        return this;
    }

    @Override
    public final AbstractC1838hn mo4720b(Executor executor, InterfaceC0808Rh interfaceC0808Rh) {
        this.f3219b.m4717a(new C0427JC(executor, interfaceC0808Rh));
        m4733o();
        return this;
    }

    @Override
    public final AbstractC1838hn mo4721c(Executor executor, InterfaceC0900Th interfaceC0900Th) {
        this.f3219b.m4717a(new C0659OE(executor, interfaceC0900Th));
        m4733o();
        return this;
    }

    @Override
    public final Exception mo4722d() {
        Exception exc;
        synchronized (this.f3218a) {
            exc = this.f3223f;
        }
        return exc;
    }

    @Override
    public final Object mo4723e() {
        Object obj;
        synchronized (this.f3218a) {
            try {
                m4730l();
                m4731m();
                Exception exc = this.f3223f;
                if (exc != null) {
                    throw new C1789gl(exc);
                }
                obj = this.f3222e;
            } catch (Throwable th) {
                throw th;
            }
        }
        return obj;
    }

    @Override
    public final boolean mo4724f() {
        return this.f3221d;
    }

    @Override
    public final boolean mo4725g() {
        boolean z;
        synchronized (this.f3218a) {
            z = this.f3220c;
        }
        return z;
    }

    @Override
    public final boolean mo4726h() {
        boolean z;
        synchronized (this.f3218a) {
            try {
                z = false;
                if (this.f3220c && !this.f3221d && this.f3223f == null) {
                    z = true;
                }
            } finally {
            }
        }
        return z;
    }

    public final void m4727i(Exception exc) {
        AbstractC1085Xi.m4802k(exc, "Exception must not be null");
        synchronized (this.f3218a) {
            m4732n();
            this.f3220c = true;
            this.f3223f = exc;
        }
        this.f3219b.m4718b(this);
    }

    public final void m4728j(Object obj) {
        synchronized (this.f3218a) {
            m4732n();
            this.f3220c = true;
            this.f3222e = obj;
        }
        this.f3219b.m4718b(this);
    }

    public final boolean m4729k(Object obj) {
        synchronized (this.f3218a) {
            try {
                if (this.f3220c) {
                    return false;
                }
                this.f3220c = true;
                this.f3222e = obj;
                this.f3219b.m4718b(this);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m4730l() {
        AbstractC1085Xi.m4805n(this.f3220c, "Task is not yet complete");
    }

    public final void m4731m() {
        if (this.f3221d) {
            throw new CancellationException("Task is already canceled.");
        }
    }

    public final void m4732n() {
        if (this.f3220c) {
            throw C0148D9.m629a(this);
        }
    }

    public final void m4733o() {
        synchronized (this.f3218a) {
            try {
                if (this.f3220c) {
                    this.f3219b.m4718b(this);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
