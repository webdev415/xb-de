package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Level;

public final class C2254qn {

    public boolean f6737a;

    public AbstractC1791gn f6738b;

    public final List f6739c;

    public boolean f6740d;

    public final C2300rn f6741e;

    public final String f6742f;

    public C2254qn(C2300rn c2300rn, String str) {
        AbstractC0116Ce.m476e(c2300rn, "taskRunner");
        AbstractC0116Ce.m476e(str, "name");
        this.f6741e = c2300rn;
        this.f6742f = str;
        this.f6739c = new ArrayList<>();
    }

    public static void m9174j(C2254qn c2254qn, AbstractC1791gn abstractC1791gn, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        c2254qn.m9183i(abstractC1791gn, j);
    }

    public final void m9175a() {
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
        synchronized (this.f6741e) {
            try {
                if (m9176b()) {
                    this.f6741e.m9444h(this);
                }
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean m9176b() {
        AbstractC1791gn abstractC1791gn = this.f6738b;
        if (abstractC1791gn != null) {
            AbstractC0116Ce.m473b(abstractC1791gn);
            if (abstractC1791gn.m7745a()) {
                this.f6740d = true;
            }
        }
        boolean z = false;
        for (int size = this.f6739c.size() - 1; size >= 0; size--) {
            if (((AbstractC1791gn) this.f6739c.get(size)).m7745a()) {
                AbstractC1791gn abstractC1791gn2 = (AbstractC1791gn) this.f6739c.get(size);
                if (C2300rn.f6965j.m9450a().isLoggable(Level.FINE)) {
                    AbstractC2162on.m8980c(abstractC1791gn2, this, "canceled");
                }
                this.f6739c.remove(size);
                z = true;
            }
        }
        return z;
    }

    public final AbstractC1791gn m9177c() {
        return this.f6738b;
    }

    public final boolean m9178d() {
        return this.f6740d;
    }

    public final List m9179e() {
        return this.f6739c;
    }

    public final String m9180f() {
        return this.f6742f;
    }

    public final boolean m9181g() {
        return this.f6737a;
    }

    public final C2300rn m9182h() {
        return this.f6741e;
    }

    public final void m9183i(AbstractC1791gn abstractC1791gn, long j) {
        AbstractC0116Ce.m476e(abstractC1791gn, "task");
        synchronized (this.f6741e) {
            if (!this.f6737a) {
                if (m9184k(abstractC1791gn, j, false)) {
                    this.f6741e.m9444h(this);
                }
                C2116no c2116no = C2116no.f6480a;
            } else if (abstractC1791gn.m7745a()) {
                if (C2300rn.f6965j.m9450a().isLoggable(Level.FINE)) {
                    AbstractC2162on.m8980c(abstractC1791gn, this, "schedule canceled (queue is shutdown)");
                }
            } else {
                if (C2300rn.f6965j.m9450a().isLoggable(Level.FINE)) {
                    AbstractC2162on.m8980c(abstractC1791gn, this, "schedule failed (queue is shutdown)");
                }
                throw new RejectedExecutionException();
            }
        }
    }

    public final boolean m9184k(AbstractC1791gn abstractC1791gn, long j, boolean z) {
        StringBuilder sb;
        String str;
        AbstractC0116Ce.m476e(abstractC1791gn, "task");
        abstractC1791gn.m7749e(this);
        long jMo9448b = this.f6741e.m9443g().mo9448b();
        long j2 = jMo9448b + j;
        int iIndexOf = this.f6739c.indexOf(abstractC1791gn);
        if (iIndexOf != -1) {
            if (abstractC1791gn.m7747c() <= j2) {
                if (C2300rn.f6965j.m9450a().isLoggable(Level.FINE)) {
                    AbstractC2162on.m8980c(abstractC1791gn, this, "already scheduled");
                }
                return false;
            }
            this.f6739c.remove(iIndexOf);
        }
        abstractC1791gn.m7751g(j2);
        if (C2300rn.f6965j.m9450a().isLoggable(Level.FINE)) {
            if (z) {
                sb = new StringBuilder();
                str = "run again after ";
            } else {
                sb = new StringBuilder();
                str = "scheduled after ";
            }
            sb.append(str);
            sb.append(AbstractC2162on.m8979b(j2 - jMo9448b));
            AbstractC2162on.m8980c(abstractC1791gn, this, sb.toString());
        }
        Iterator it = this.f6739c.iterator();
        int size = 0;
        while (true) {
            if (!it.hasNext()) {
                size = -1;
                break;
            }
            if (((AbstractC1791gn) it.next()).m7747c() - jMo9448b > j) {
                break;
            }
            size++;
        }
        if (size == -1) {
            size = this.f6739c.size();
        }
        this.f6739c.add(size, abstractC1791gn);
        return size == 0;
    }

    public final void m9185l(AbstractC1791gn abstractC1791gn) {
        this.f6738b = abstractC1791gn;
    }

    public final void m9186m(boolean z) {
        this.f6740d = z;
    }

    public final void m9187n() {
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
        synchronized (this.f6741e) {
            try {
                this.f6737a = true;
                if (m9176b()) {
                    this.f6741e.m9444h(this);
                }
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String toString() {
        return this.f6742f;
    }
}
