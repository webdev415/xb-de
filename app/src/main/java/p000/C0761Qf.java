package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

public final class C0761Qf extends AbstractC0283G6 implements InterfaceC2091n8 {

    public static final AtomicIntegerFieldUpdater f2247s = AtomicIntegerFieldUpdater.newUpdater(C0761Qf.class, "runningWorkers");

    public final AbstractC0283G6 f2248n;

    public final int f2249o;

    public final InterfaceC2091n8 f2250p;

    public final C1323bg f2251q;

    public final Object f2252r;
    private volatile int runningWorkers;

    public final class a implements Runnable {

        public Runnable f2253l;

        public a(Runnable runnable) {
            this.f2253l = runnable;
        }

        @Override
        public void run() {
            int i = 0;
            while (true) {
                try {
                    this.f2253l.run();
                } catch (Throwable th) {
                    AbstractC0467K6.m2289a(C0608N9.f1911l, th);
                }
                Runnable runnableM3670Y = C0761Qf.this.m3670Y();
                if (runnableM3670Y == null) {
                    return;
                }
                this.f2253l = runnableM3670Y;
                i++;
                if (i >= 16 && C0761Qf.this.f2248n.mo1352U(C0761Qf.this)) {
                    C0761Qf.this.f2248n.mo1351T(C0761Qf.this, this);
                    return;
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public C0761Qf(AbstractC0283G6 abstractC0283G6, int i) {
        this.f2248n = abstractC0283G6;
        this.f2249o = i;
        InterfaceC2091n8 interfaceC2091n8 = abstractC0283G6 instanceof InterfaceC2091n8 ? (InterfaceC2091n8) abstractC0283G6 : null;
        this.f2250p = interfaceC2091n8 == null ? AbstractC1019W7.m4449a() : interfaceC2091n8;
        this.f2251q = new C1323bg(false);
        this.f2252r = new Object();
    }

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        Runnable runnableM3670Y;
        this.f2251q.m5667a(runnable);
        if (f2247s.get(this) >= this.f2249o || !m3671Z() || (runnableM3670Y = m3670Y()) == null) {
            return;
        }
        this.f2248n.mo1351T(this, new a(runnableM3670Y));
    }

    public final Runnable m3670Y() {
        while (true) {
            Runnable runnable = (Runnable) this.f2251q.m5670d();
            if (runnable != null) {
                return runnable;
            }
            synchronized (this.f2252r) {
                AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2247s;
                atomicIntegerFieldUpdater.decrementAndGet(this);
                if (this.f2251q.m5669c() == 0) {
                    return null;
                }
                atomicIntegerFieldUpdater.incrementAndGet(this);
            }
        }
    }

    public final boolean m3671Z() {
        synchronized (this.f2252r) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f2247s;
            if (atomicIntegerFieldUpdater.get(this) >= this.f2249o) {
                return false;
            }
            atomicIntegerFieldUpdater.incrementAndGet(this);
            return true;
        }
    }
}
