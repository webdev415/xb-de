package p000;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.LockSupport;

public final class ExecutorC0513L6 implements Executor, Closeable {

    public static final a f1662s = new a(null);

    public static final AtomicLongFieldUpdater f1663t = AtomicLongFieldUpdater.newUpdater(ExecutorC0513L6.class, "parkedWorkersStack");

    public static final AtomicLongFieldUpdater f1664u = AtomicLongFieldUpdater.newUpdater(ExecutorC0513L6.class, "controlState");

    public static final AtomicIntegerFieldUpdater f1665v = AtomicIntegerFieldUpdater.newUpdater(ExecutorC0513L6.class, "_isTerminated");

    public static final C0951Um f1666w = new C0951Um("NOT_IN_STACK");
    private volatile int _isTerminated;
    private volatile long controlState;

    public final int f1667l;

    public final int f1668m;

    public final long f1669n;

    public final String f1670o;

    public final C0252Fc f1671p;
    private volatile long parkedWorkersStack;

    public final C0252Fc f1672q;

    public final C0306Gk f1673r;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public class b {

        public static final int[] f1674a;

        static {
            int[] iArr = new int[d.values().length];
            try {
                iArr[d.PARKING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[d.BLOCKING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[d.CPU_ACQUIRED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[d.DORMANT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[d.TERMINATED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            f1674a = iArr;
        }
    }

    public final class c extends Thread {

        public static final AtomicIntegerFieldUpdater f1675t = AtomicIntegerFieldUpdater.newUpdater(c.class, "workerCtl");
        private volatile int indexInArray;

        public final C2624yp f1676l;

        public final C2205pk f1677m;

        public d f1678n;
        private volatile Object nextParkedWorker;

        public long f1679o;

        public long f1680p;

        public int f1681q;

        public boolean f1682r;
        private volatile int workerCtl;

        public c() {
            setDaemon(true);
            this.f1676l = new C2624yp();
            this.f1677m = new C2205pk();
            this.f1678n = d.DORMANT;
            this.nextParkedWorker = ExecutorC0513L6.f1666w;
            this.f1681q = AbstractC0994Vj.f2984l.mo1661b();
        }

        public static final AtomicIntegerFieldUpdater m2608j() {
            return f1675t;
        }

        public final void m2609b(int i) {
            if (i == 0) {
                return;
            }
            ExecutorC0513L6.f1664u.addAndGet(ExecutorC0513L6.this, -2097152L);
            if (this.f1678n != d.TERMINATED) {
                this.f1678n = d.DORMANT;
            }
        }

        public final void m2610c(int i) {
            if (i != 0 && m2627u(d.BLOCKING)) {
                ExecutorC0513L6.this.m2594E();
            }
        }

        public final void m2611d(AbstractRunnableC1744fn abstractRunnableC1744fn) {
            int iMo8202a = abstractRunnableC1744fn.f5548m.mo8202a();
            m2617k(iMo8202a);
            m2610c(iMo8202a);
            ExecutorC0513L6.this.m2591A(abstractRunnableC1744fn);
            m2609b(iMo8202a);
        }

        public final AbstractRunnableC1744fn m2612e(boolean z) {
            AbstractRunnableC1744fn abstractRunnableC1744fnM2621o;
            AbstractRunnableC1744fn abstractRunnableC1744fnM2621o2;
            if (z) {
                boolean z2 = m2619m(ExecutorC0513L6.this.f1667l * 2) == 0;
                if (z2 && (abstractRunnableC1744fnM2621o2 = m2621o()) != null) {
                    return abstractRunnableC1744fnM2621o2;
                }
                AbstractRunnableC1744fn abstractRunnableC1744fnM10958g = this.f1676l.m10958g();
                if (abstractRunnableC1744fnM10958g != null) {
                    return abstractRunnableC1744fnM10958g;
                }
                if (!z2 && (abstractRunnableC1744fnM2621o = m2621o()) != null) {
                    return abstractRunnableC1744fnM2621o;
                }
            } else {
                AbstractRunnableC1744fn abstractRunnableC1744fnM2621o3 = m2621o();
                if (abstractRunnableC1744fnM2621o3 != null) {
                    return abstractRunnableC1744fnM2621o3;
                }
            }
            return m2628v(3);
        }

        public final AbstractRunnableC1744fn m2613f() {
            AbstractRunnableC1744fn abstractRunnableC1744fnM10959h = this.f1676l.m10959h();
            if (abstractRunnableC1744fnM10959h != null) {
                return abstractRunnableC1744fnM10959h;
            }
            AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) ExecutorC0513L6.this.f1672q.m5670d();
            return abstractRunnableC1744fn == null ? m2628v(1) : abstractRunnableC1744fn;
        }

        public final AbstractRunnableC1744fn m2614g(boolean z) {
            return m2625s() ? m2612e(z) : m2613f();
        }

        public final int m2615h() {
            return this.indexInArray;
        }

        public final Object m2616i() {
            return this.nextParkedWorker;
        }

        public final void m2617k(int i) {
            this.f1679o = 0L;
            if (this.f1678n == d.PARKING) {
                this.f1678n = d.BLOCKING;
            }
        }

        public final boolean m2618l() {
            return this.nextParkedWorker != ExecutorC0513L6.f1666w;
        }

        public final int m2619m(int i) {
            int i2 = this.f1681q;
            int i3 = i2 ^ (i2 << 13);
            int i4 = i3 ^ (i3 >> 17);
            int i5 = i4 ^ (i4 << 5);
            this.f1681q = i5;
            int i6 = i - 1;
            return (i6 & i) == 0 ? i5 & i6 : (i5 & Integer.MAX_VALUE) % i;
        }

        public final void m2620n() {
            if (this.f1679o == 0) {
                this.f1679o = System.nanoTime() + ExecutorC0513L6.this.f1669n;
            }
            LockSupport.parkNanos(ExecutorC0513L6.this.f1669n);
            if (System.nanoTime() - this.f1679o >= 0) {
                this.f1679o = 0L;
                m2629w();
            }
        }

        public final AbstractRunnableC1744fn m2621o() {
            C0252Fc c0252Fc;
            if (m2619m(2) == 0) {
                AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) ExecutorC0513L6.this.f1671p.m5670d();
                if (abstractRunnableC1744fn != null) {
                    return abstractRunnableC1744fn;
                }
                c0252Fc = ExecutorC0513L6.this.f1672q;
            } else {
                AbstractRunnableC1744fn abstractRunnableC1744fn2 = (AbstractRunnableC1744fn) ExecutorC0513L6.this.f1672q.m5670d();
                if (abstractRunnableC1744fn2 != null) {
                    return abstractRunnableC1744fn2;
                }
                c0252Fc = ExecutorC0513L6.this.f1671p;
            }
            return (AbstractRunnableC1744fn) c0252Fc.m5670d();
        }

        public final void m2622p() {
            loop0: while (true) {
                boolean z = false;
                while (!ExecutorC0513L6.this.isTerminated() && this.f1678n != d.TERMINATED) {
                    AbstractRunnableC1744fn abstractRunnableC1744fnM2614g = m2614g(this.f1682r);
                    if (abstractRunnableC1744fnM2614g != null) {
                        this.f1680p = 0L;
                        m2611d(abstractRunnableC1744fnM2614g);
                    } else {
                        this.f1682r = false;
                        if (this.f1680p == 0) {
                            m2626t();
                        } else if (z) {
                            m2627u(d.PARKING);
                            Thread.interrupted();
                            LockSupport.parkNanos(this.f1680p);
                            this.f1680p = 0L;
                        } else {
                            z = true;
                        }
                    }
                }
                break loop0;
            }
            m2627u(d.TERMINATED);
        }

        public final void m2623q(int i) {
            StringBuilder sb = new StringBuilder();
            sb.append(ExecutorC0513L6.this.f1670o);
            sb.append("-worker-");
            sb.append(i == 0 ? "TERMINATED" : String.valueOf(i));
            setName(sb.toString());
            this.indexInArray = i;
        }

        public final void m2624r(Object obj) {
            this.nextParkedWorker = obj;
        }

        @Override
        public void run() {
            m2622p();
        }

        public final boolean m2625s() {
            long j;
            if (this.f1678n == d.CPU_ACQUIRED) {
                return true;
            }
            ExecutorC0513L6 executorC0513L6 = ExecutorC0513L6.this;
            AtomicLongFieldUpdater atomicLongFieldUpdater = ExecutorC0513L6.f1664u;
            do {
                j = atomicLongFieldUpdater.get(executorC0513L6);
                if (((int) ((9223367638808264704L & j) >> 42)) == 0) {
                    return false;
                }
            } while (!ExecutorC0513L6.f1664u.compareAndSet(executorC0513L6, j, j - 4398046511104L));
            this.f1678n = d.CPU_ACQUIRED;
            return true;
        }

        public final void m2626t() {
            if (!m2618l()) {
                ExecutorC0513L6.this.m2605w(this);
                return;
            }
            f1675t.set(this, -1);
            while (m2618l() && f1675t.get(this) == -1 && !ExecutorC0513L6.this.isTerminated() && this.f1678n != d.TERMINATED) {
                m2627u(d.PARKING);
                Thread.interrupted();
                m2620n();
            }
        }

        public final boolean m2627u(d dVar) {
            d dVar2 = this.f1678n;
            boolean z = dVar2 == d.CPU_ACQUIRED;
            if (z) {
                ExecutorC0513L6.f1664u.addAndGet(ExecutorC0513L6.this, 4398046511104L);
            }
            if (dVar2 != dVar) {
                this.f1678n = dVar;
            }
            return z;
        }

        public final AbstractRunnableC1744fn m2628v(int i) {
            int i2 = (int) (ExecutorC0513L6.f1664u.get(ExecutorC0513L6.this) & 2097151);
            if (i2 < 2) {
                return null;
            }
            int iM2619m = m2619m(i2);
            ExecutorC0513L6 executorC0513L6 = ExecutorC0513L6.this;
            long jMin = Long.MAX_VALUE;
            for (int i3 = 0; i3 < i2; i3++) {
                iM2619m++;
                if (iM2619m > i2) {
                    iM2619m = 1;
                }
                c cVar = (c) executorC0513L6.f1673r.m1404b(iM2619m);
                if (cVar != null && cVar != this) {
                    long jM10965n = cVar.f1676l.m10965n(i, this.f1677m);
                    if (jM10965n == -1) {
                        C2205pk c2205pk = this.f1677m;
                        AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) c2205pk.f6647l;
                        c2205pk.f6647l = null;
                        return abstractRunnableC1744fn;
                    }
                    if (jM10965n > 0) {
                        jMin = Math.min(jMin, jM10965n);
                    }
                }
            }
            if (jMin == Long.MAX_VALUE) {
                jMin = 0;
            }
            this.f1680p = jMin;
            return null;
        }

        public final void m2629w() {
            ExecutorC0513L6 executorC0513L6 = ExecutorC0513L6.this;
            synchronized (executorC0513L6.f1673r) {
                try {
                    if (executorC0513L6.isTerminated()) {
                        return;
                    }
                    if (((int) (ExecutorC0513L6.f1664u.get(executorC0513L6) & 2097151)) <= executorC0513L6.f1667l) {
                        return;
                    }
                    if (f1675t.compareAndSet(this, -1, 1)) {
                        int i = this.indexInArray;
                        m2623q(0);
                        executorC0513L6.m2606z(this, i, 0);
                        int andDecrement = (int) (ExecutorC0513L6.f1664u.getAndDecrement(executorC0513L6) & 2097151);
                        if (andDecrement != i) {
                            Object objM1404b = executorC0513L6.f1673r.m1404b(andDecrement);
                            AbstractC0116Ce.m473b(objM1404b);
                            c cVar = (c) objM1404b;
                            executorC0513L6.f1673r.m1405c(i, cVar);
                            cVar.m2623q(i);
                            executorC0513L6.m2606z(cVar, andDecrement, i);
                        }
                        executorC0513L6.f1673r.m1405c(andDecrement, null);
                        C2116no c2116no = C2116no.f6480a;
                        this.f1678n = d.TERMINATED;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public c(ExecutorC0513L6 executorC0513L6, int i) {
            this();
            m2623q(i);
        }
    }

    public enum d {
        CPU_ACQUIRED,
        BLOCKING,
        PARKING,
        DORMANT,
        TERMINATED
    }

    public ExecutorC0513L6(int i, int i2, long j, String str) {
        this.f1667l = i;
        this.f1668m = i2;
        this.f1669n = j;
        this.f1670o = str;
        if (i < 1) {
            throw new IllegalArgumentException(("Core pool size " + i + " should be at least 1").toString());
        }
        if (i2 < i) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should be greater than or equals to core pool size " + i).toString());
        }
        if (i2 > 2097150) {
            throw new IllegalArgumentException(("Max pool size " + i2 + " should not exceed maximal supported number of threads 2097150").toString());
        }
        if (j <= 0) {
            throw new IllegalArgumentException(("Idle worker keep alive time " + j + " must be positive").toString());
        }
        this.f1671p = new C0252Fc();
        this.f1672q = new C0252Fc();
        this.f1673r = new C0306Gk((i + 1) * 2);
        this.controlState = i << 42;
        this._isTerminated = 0;
    }

    public static boolean m2588S(ExecutorC0513L6 executorC0513L6, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            j = f1664u.get(executorC0513L6);
        }
        return executorC0513L6.m2596J(j);
    }

    public static void m2590l(ExecutorC0513L6 executorC0513L6, Runnable runnable, InterfaceC1931jn interfaceC1931jn, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            interfaceC1931jn = AbstractC2392tn.f7263g;
        }
        if ((i & 4) != 0) {
            z = false;
        }
        executorC0513L6.m2602k(runnable, interfaceC1931jn, z);
    }

    public final void m2591A(AbstractRunnableC1744fn abstractRunnableC1744fn) {
        try {
            abstractRunnableC1744fn.run();
        } finally {
            try {
            } finally {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m2592B(long r8) throws InterruptedException {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicIntegerFieldUpdater r0 = p000.ExecutorC0513L6.f1665v
            r1 = 0
            r2 = 1
            boolean r0 = r0.compareAndSet(r7, r1, r2)
            if (r0 != 0) goto Lb
            return
        Lb:
            L6$c r0 = r7.m2601j()
            Gk r1 = r7.f1673r
            monitor-enter(r1)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r3 = m2589a()     // Catch: java.lang.Throwable -> L87
            long r3 = r3.get(r7)     // Catch: java.lang.Throwable -> L87
            r5 = 2097151(0x1fffff, double:1.0361303E-317)
            long r3 = r3 & r5
            int r3 = (int) r3
            monitor-exit(r1)
            if (r2 > r3) goto L49
            r1 = r2
        L23:
            Gk r4 = r7.f1673r
            java.lang.Object r4 = r4.m1404b(r1)
            p000.AbstractC0116Ce.m473b(r4)
            L6$c r4 = (p000.ExecutorC0513L6.c) r4
            if (r4 == r0) goto L44
        L30:
            boolean r5 = r4.isAlive()
            if (r5 == 0) goto L3d
            java.util.concurrent.locks.LockSupport.unpark(r4)
            r4.join(r8)
            goto L30
        L3d:
            yp r4 = r4.f1676l
            Fc r5 = r7.f1672q
            r4.m10957f(r5)
        L44:
            if (r1 == r3) goto L49
            int r1 = r1 + 1
            goto L23
        L49:
            Fc r8 = r7.f1672q
            r8.m5668b()
            Fc r8 = r7.f1671p
            r8.m5668b()
        L53:
            if (r0 == 0) goto L5b
            fn r8 = r0.m2614g(r2)
            if (r8 != 0) goto L83
        L5b:
            Fc r8 = r7.f1671p
            java.lang.Object r8 = r8.m5670d()
            fn r8 = (p000.AbstractRunnableC1744fn) r8
            if (r8 != 0) goto L83
            Fc r8 = r7.f1672q
            java.lang.Object r8 = r8.m5670d()
            fn r8 = (p000.AbstractRunnableC1744fn) r8
            if (r8 != 0) goto L83
            if (r0 == 0) goto L76
            L6$d r8 = p000.ExecutorC0513L6.d.TERMINATED
            r0.m2627u(r8)
        L76:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = p000.ExecutorC0513L6.f1663t
            r0 = 0
            r8.set(r7, r0)
            java.util.concurrent.atomic.AtomicLongFieldUpdater r8 = p000.ExecutorC0513L6.f1664u
            r8.set(r7, r0)
            return
        L83:
            r7.m2591A(r8)
            goto L53
        L87:
            r8 = move-exception
            monitor-exit(r1)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.ExecutorC0513L6.m2592B(long):void");
    }

    public final void m2593C(long j, boolean z) {
        if (z || m2597T() || m2596J(j)) {
            return;
        }
        m2597T();
    }

    public final void m2594E() {
        if (m2597T() || m2588S(this, 0L, 1, null)) {
            return;
        }
        m2597T();
    }

    public final AbstractRunnableC1744fn m2595I(c cVar, AbstractRunnableC1744fn abstractRunnableC1744fn, boolean z) {
        if (cVar == null || cVar.f1678n == d.TERMINATED) {
            return abstractRunnableC1744fn;
        }
        if (abstractRunnableC1744fn.f5548m.mo8202a() == 0 && cVar.f1678n == d.BLOCKING) {
            return abstractRunnableC1744fn;
        }
        cVar.f1682r = true;
        return cVar.f1676l.m10952a(abstractRunnableC1744fn, z);
    }

    public final boolean m2596J(long j) {
        if (AbstractC1132Yj.m4981b(((int) (2097151 & j)) - ((int) ((j & 4398044413952L) >> 21)), 0) < this.f1667l) {
            int iM2599g = m2599g();
            if (iM2599g == 1 && this.f1667l > 1) {
                m2599g();
            }
            if (iM2599g > 0) {
                return true;
            }
        }
        return false;
    }

    public final boolean m2597T() {
        c cVarM2604u;
        do {
            cVarM2604u = m2604u();
            if (cVarM2604u == null) {
                return false;
            }
        } while (!c.m2608j().compareAndSet(cVarM2604u, -1, 0));
        LockSupport.unpark(cVarM2604u);
        return true;
    }

    public final boolean m2598b(AbstractRunnableC1744fn abstractRunnableC1744fn) {
        return (abstractRunnableC1744fn.f5548m.mo8202a() == 1 ? this.f1672q : this.f1671p).m5667a(abstractRunnableC1744fn);
    }

    @Override
    public void close() throws InterruptedException {
        m2592B(10000L);
    }

    @Override
    public void execute(Runnable runnable) {
        m2590l(this, runnable, null, false, 6, null);
    }

    public final int m2599g() {
        synchronized (this.f1673r) {
            try {
                if (isTerminated()) {
                    return -1;
                }
                AtomicLongFieldUpdater atomicLongFieldUpdater = f1664u;
                long j = atomicLongFieldUpdater.get(this);
                int i = (int) (j & 2097151);
                int iM4981b = AbstractC1132Yj.m4981b(i - ((int) ((j & 4398044413952L) >> 21)), 0);
                if (iM4981b >= this.f1667l) {
                    return 0;
                }
                if (i >= this.f1668m) {
                    return 0;
                }
                int i2 = ((int) (f1664u.get(this) & 2097151)) + 1;
                if (i2 <= 0 || this.f1673r.m1404b(i2) != null) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                c cVar = new c(this, i2);
                this.f1673r.m1405c(i2, cVar);
                if (i2 != ((int) (2097151 & atomicLongFieldUpdater.incrementAndGet(this)))) {
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                int i3 = iM4981b + 1;
                cVar.start();
                return i3;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final AbstractRunnableC1744fn m2600i(Runnable runnable, InterfaceC1931jn interfaceC1931jn) {
        long jMo8177a = AbstractC2392tn.f7262f.mo8177a();
        if (!(runnable instanceof AbstractRunnableC1744fn)) {
            return new C2115nn(runnable, jMo8177a, interfaceC1931jn);
        }
        AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) runnable;
        abstractRunnableC1744fn.f5547l = jMo8177a;
        abstractRunnableC1744fn.f5548m = interfaceC1931jn;
        return abstractRunnableC1744fn;
    }

    public final boolean isTerminated() {
        return f1665v.get(this) != 0;
    }

    public final c m2601j() {
        Thread threadCurrentThread = Thread.currentThread();
        c cVar = threadCurrentThread instanceof c ? (c) threadCurrentThread : null;
        if (cVar == null || !AbstractC0116Ce.m472a(ExecutorC0513L6.this, this)) {
            return null;
        }
        return cVar;
    }

    public final void m2602k(Runnable runnable, InterfaceC1931jn interfaceC1931jn, boolean z) {
        AbstractC0644O.m3350a();
        AbstractRunnableC1744fn abstractRunnableC1744fnM2600i = m2600i(runnable, interfaceC1931jn);
        boolean z2 = false;
        boolean z3 = abstractRunnableC1744fnM2600i.f5548m.mo8202a() == 1;
        long jAddAndGet = z3 ? f1664u.addAndGet(this, 2097152L) : 0L;
        c cVarM2601j = m2601j();
        AbstractRunnableC1744fn abstractRunnableC1744fnM2595I = m2595I(cVarM2601j, abstractRunnableC1744fnM2600i, z);
        if (abstractRunnableC1744fnM2595I != null && !m2598b(abstractRunnableC1744fnM2595I)) {
            throw new RejectedExecutionException(this.f1670o + " was terminated");
        }
        if (z && cVarM2601j != null) {
            z2 = true;
        }
        if (z3) {
            m2593C(jAddAndGet, z2);
        } else {
            if (z2) {
                return;
            }
            m2594E();
        }
    }

    public final int m2603p(c cVar) {
        int iM2615h;
        do {
            Object objM2616i = cVar.m2616i();
            if (objM2616i == f1666w) {
                return -1;
            }
            if (objM2616i == null) {
                return 0;
            }
            cVar = (c) objM2616i;
            iM2615h = cVar.m2615h();
        } while (iM2615h == 0);
        return iM2615h;
    }

    public String toString() {
        StringBuilder sb;
        char c2;
        ArrayList arrayList = new ArrayList<>();
        int iM1403a = this.f1673r.m1403a();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 1; i6 < iM1403a; i6++) {
            c cVar = (c) this.f1673r.m1404b(i6);
            if (cVar != null) {
                int iM10956e = cVar.f1676l.m10956e();
                int i7 = b.f1674a[cVar.f1678n.ordinal()];
                if (i7 != 1) {
                    if (i7 == 2) {
                        i2++;
                        sb = new StringBuilder();
                        sb.append(iM10956e);
                        c2 = 'b';
                    } else if (i7 == 3) {
                        i++;
                        sb = new StringBuilder();
                        sb.append(iM10956e);
                        c2 = 'c';
                    } else if (i7 == 4) {
                        i4++;
                        if (iM10956e > 0) {
                            sb = new StringBuilder();
                            sb.append(iM10956e);
                            c2 = 'd';
                        }
                    } else if (i7 == 5) {
                        i5++;
                    }
                    sb.append(c2);
                    arrayList.add(sb.toString());
                } else {
                    i3++;
                }
            }
        }
        long j = f1664u.get(this);
        return this.f1670o + '@' + AbstractC2505w7.m10434b(this) + "[Pool Size {core = " + this.f1667l + ", max = " + this.f1668m + "}, Worker States {CPU = " + i + ", blocking = " + i2 + ", parked = " + i3 + ", dormant = " + i4 + ", terminated = " + i5 + "}, running workers queues = " + arrayList + ", global CPU queue size = " + this.f1671p.m5669c() + ", global blocking queue size = " + this.f1672q.m5669c() + ", Control State {created workers= " + ((int) (2097151 & j)) + ", blocking tasks = " + ((int) ((4398044413952L & j) >> 21)) + ", CPUs acquired = " + (this.f1667l - ((int) ((9223367638808264704L & j) >> 42))) + "}]";
    }

    public final c m2604u() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1663t;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            c cVar = (c) this.f1673r.m1404b((int) (2097151 & j));
            if (cVar == null) {
                return null;
            }
            long j2 = (2097152 + j) & (-2097152);
            int iM2603p = m2603p(cVar);
            if (iM2603p >= 0 && f1663t.compareAndSet(this, j, iM2603p | j2)) {
                cVar.m2624r(f1666w);
                return cVar;
            }
        }
    }

    public final boolean m2605w(c cVar) {
        long j;
        int iM2615h;
        if (cVar.m2616i() != f1666w) {
            return false;
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1663t;
        do {
            j = atomicLongFieldUpdater.get(this);
            iM2615h = cVar.m2615h();
            cVar.m2624r(this.f1673r.m1404b((int) (2097151 & j)));
        } while (!f1663t.compareAndSet(this, j, ((2097152 + j) & (-2097152)) | iM2615h));
        return true;
    }

    public final void m2606z(c cVar, int i, int i2) {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f1663t;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            int iM2603p = (int) (2097151 & j);
            long j2 = (2097152 + j) & (-2097152);
            if (iM2603p == i) {
                iM2603p = i2 == 0 ? m2603p(cVar) : i2;
            }
            if (iM2603p >= 0 && f1663t.compareAndSet(this, j, j2 | iM2603p)) {
                return;
            }
        }
    }
}
