package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class C2300rn {

    public static final Logger f6964i;

    public int f6966a;

    public boolean f6967b;

    public long f6968c;

    public final List f6969d;

    public final List f6970e;

    public final Runnable f6971f;

    public final a f6972g;

    public static final b f6965j = new b(null);

    public static final C2300rn f6963h = new C2300rn(new c(AbstractC2623yo.m10913I(AbstractC2623yo.f8135i + " TaskRunner", true)));

    public interface a {
        void mo9447a(C2300rn c2300rn);

        long mo9448b();

        void mo9449c(C2300rn c2300rn, long j);

        void execute(Runnable runnable);
    }

    public static final class b {
        public b() {
        }

        public final Logger m9450a() {
            return C2300rn.f6964i;
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class c implements a {

        public final ThreadPoolExecutor f6973a;

        public c(ThreadFactory threadFactory) {
            AbstractC0116Ce.m476e(threadFactory, "threadFactory");
            this.f6973a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), threadFactory);
        }

        @Override
        public void mo9447a(C2300rn c2300rn) {
            AbstractC0116Ce.m476e(c2300rn, "taskRunner");
            c2300rn.notify();
        }

        @Override
        public long mo9448b() {
            return System.nanoTime();
        }

        @Override
        public void mo9449c(C2300rn c2300rn, long j) throws InterruptedException {
            AbstractC0116Ce.m476e(c2300rn, "taskRunner");
            long j2 = j / 1000000;
            long j3 = j - (1000000 * j2);
            if (j2 > 0 || j > 0) {
                c2300rn.wait(j2, (int) j3);
            }
        }

        @Override
        public void execute(Runnable runnable) {
            AbstractC0116Ce.m476e(runnable, "runnable");
            this.f6973a.execute(runnable);
        }
    }

    public static final class d implements Runnable {
        public d() {
        }

        @Override
        public void run() {
            AbstractC1791gn abstractC1791gnM9440d;
            long jMo9448b;
            while (true) {
                synchronized (C2300rn.this) {
                    abstractC1791gnM9440d = C2300rn.this.m9440d();
                }
                if (abstractC1791gnM9440d == null) {
                    return;
                }
                C2254qn c2254qnM7748d = abstractC1791gnM9440d.m7748d();
                AbstractC0116Ce.m473b(c2254qnM7748d);
                boolean zIsLoggable = C2300rn.f6965j.m9450a().isLoggable(Level.FINE);
                if (zIsLoggable) {
                    jMo9448b = c2254qnM7748d.m9182h().m9443g().mo9448b();
                    AbstractC2162on.m8980c(abstractC1791gnM9440d, c2254qnM7748d, "starting");
                } else {
                    jMo9448b = -1;
                }
                try {
                    try {
                        C2300rn.this.m9446j(abstractC1791gnM9440d);
                        C2116no c2116no = C2116no.f6480a;
                        if (zIsLoggable) {
                            AbstractC2162on.m8980c(abstractC1791gnM9440d, c2254qnM7748d, "finished run in " + AbstractC2162on.m8979b(c2254qnM7748d.m9182h().m9443g().mo9448b() - jMo9448b));
                        }
                    } finally {
                    }
                } catch (Throwable th) {
                    if (zIsLoggable) {
                        AbstractC2162on.m8980c(abstractC1791gnM9440d, c2254qnM7748d, "failed a run in " + AbstractC2162on.m8979b(c2254qnM7748d.m9182h().m9443g().mo9448b() - jMo9448b));
                    }
                    throw th;
                }
            }
        }
    }

    static {
        Logger logger = Logger.getLogger(C2300rn.class.getName());
        AbstractC0116Ce.m475d(logger, "Logger.getLogger(TaskRunner::class.java.name)");
        f6964i = logger;
    }

    public C2300rn(a aVar) {
        AbstractC0116Ce.m476e(aVar, "backend");
        this.f6972g = aVar;
        this.f6966a = 10000;
        this.f6969d = new ArrayList<>();
        this.f6970e = new ArrayList<>();
        this.f6971f = new d();
    }

    public final void m9439c(AbstractC1791gn abstractC1791gn, long j) {
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        C2254qn c2254qnM7748d = abstractC1791gn.m7748d();
        AbstractC0116Ce.m473b(c2254qnM7748d);
        if (!(c2254qnM7748d.m9177c() == abstractC1791gn)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        boolean zM9178d = c2254qnM7748d.m9178d();
        c2254qnM7748d.m9186m(false);
        c2254qnM7748d.m9185l(null);
        this.f6969d.remove(c2254qnM7748d);
        if (j != -1 && !zM9178d && !c2254qnM7748d.m9181g()) {
            c2254qnM7748d.m9184k(abstractC1791gn, j, true);
        }
        if (!c2254qnM7748d.m9179e().isEmpty()) {
            this.f6970e.add(c2254qnM7748d);
        }
    }

    public final AbstractC1791gn m9440d() {
        boolean z;
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        while (!this.f6970e.isEmpty()) {
            long jMo9448b = this.f6972g.mo9448b();
            Iterator it = this.f6970e.iterator();
            long jMin = Long.MAX_VALUE;
            AbstractC1791gn abstractC1791gn = null;
            while (true) {
                if (!it.hasNext()) {
                    z = false;
                    break;
                }
                AbstractC1791gn abstractC1791gn2 = (AbstractC1791gn) ((C2254qn) it.next()).m9179e().get(0);
                long jMax = Math.max(0L, abstractC1791gn2.m7747c() - jMo9448b);
                if (jMax > 0) {
                    jMin = Math.min(jMax, jMin);
                } else {
                    if (abstractC1791gn != null) {
                        z = true;
                        break;
                    }
                    abstractC1791gn = abstractC1791gn2;
                }
            }
            if (abstractC1791gn != null) {
                m9441e(abstractC1791gn);
                if (z || (!this.f6967b && (!this.f6970e.isEmpty()))) {
                    this.f6972g.execute(this.f6971f);
                }
                return abstractC1791gn;
            }
            if (this.f6967b) {
                if (jMin < this.f6968c - jMo9448b) {
                    this.f6972g.mo9447a(this);
                }
                return null;
            }
            this.f6967b = true;
            this.f6968c = jMo9448b + jMin;
            try {
                try {
                    this.f6972g.mo9449c(this, jMin);
                } catch (InterruptedException unused) {
                    m9442f();
                }
            } finally {
                this.f6967b = false;
            }
        }
        return null;
    }

    public final void m9441e(AbstractC1791gn abstractC1791gn) {
        if (!AbstractC2623yo.f8134h || Thread.holdsLock(this)) {
            abstractC1791gn.m7751g(-1L);
            C2254qn c2254qnM7748d = abstractC1791gn.m7748d();
            AbstractC0116Ce.m473b(c2254qnM7748d);
            c2254qnM7748d.m9179e().remove(abstractC1791gn);
            this.f6970e.remove(c2254qnM7748d);
            c2254qnM7748d.m9185l(abstractC1791gn);
            this.f6969d.add(c2254qnM7748d);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(this);
        throw new AssertionError(sb.toString());
    }

    public final void m9442f() {
        for (int size = this.f6969d.size() - 1; size >= 0; size--) {
            ((C2254qn) this.f6969d.get(size)).m9176b();
        }
        for (int size2 = this.f6970e.size() - 1; size2 >= 0; size2--) {
            C2254qn c2254qn = (C2254qn) this.f6970e.get(size2);
            c2254qn.m9176b();
            if (c2254qn.m9179e().isEmpty()) {
                this.f6970e.remove(size2);
            }
        }
    }

    public final a m9443g() {
        return this.f6972g;
    }

    public final void m9444h(C2254qn c2254qn) {
        AbstractC0116Ce.m476e(c2254qn, "taskQueue");
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        if (c2254qn.m9177c() == null) {
            if (!c2254qn.m9179e().isEmpty()) {
                AbstractC2623yo.m10926a(this.f6970e, c2254qn);
            } else {
                this.f6970e.remove(c2254qn);
            }
        }
        if (this.f6967b) {
            this.f6972g.mo9447a(this);
        } else {
            this.f6972g.execute(this.f6971f);
        }
    }

    public final C2254qn m9445i() {
        int i;
        synchronized (this) {
            i = this.f6966a;
            this.f6966a = i + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append('Q');
        sb.append(i);
        return new C2254qn(this, sb.toString());
    }

    public final void m9446j(AbstractC1791gn abstractC1791gn) {
        if (AbstractC2623yo.f8134h && Thread.holdsLock(this)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST NOT hold lock on ");
            sb.append(this);
            throw new AssertionError(sb.toString());
        }
        Thread threadCurrentThread2 = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread2, "currentThread");
        String name = threadCurrentThread2.getName();
        threadCurrentThread2.setName(abstractC1791gn.m7746b());
        try {
            long jMo7750f = abstractC1791gn.mo7750f();
            synchronized (this) {
                m9439c(abstractC1791gn, jMo7750f);
                C2116no c2116no = C2116no.f6480a;
            }
            threadCurrentThread2.setName(name);
        } catch (Throwable th) {
            synchronized (this) {
                m9439c(abstractC1791gn, -1L);
                C2116no c2116no2 = C2116no.f6480a;
                threadCurrentThread2.setName(name);
                throw th;
            }
        }
    }
}
