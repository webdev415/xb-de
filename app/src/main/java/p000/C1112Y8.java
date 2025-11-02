package p000;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p000.C1694ek;

/* loaded from: classes.dex */
public final class C1112Y8 {

    public Runnable f3312c;

    public ExecutorService f3313d;

    public int f3310a = 64;

    public int f3311b = 5;

    public final ArrayDeque f3314e = new ArrayDeque();

    public final ArrayDeque f3315f = new ArrayDeque();

    public final ArrayDeque f3316g = new ArrayDeque();

    public final void m4874a(C1694ek.a aVar) {
        C1694ek.a aVarM4877d;
        AbstractC0116Ce.m476e(aVar, "call");
        synchronized (this) {
            try {
                this.f3314e.add(aVar);
                if (!aVar.m7455b().m7445r() && (aVarM4877d = m4877d(aVar.m7457d())) != null) {
                    aVar.m7458e(aVarM4877d);
                }
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        m4881h();
    }

    public final synchronized void m4875b(C1694ek c1694ek) {
        AbstractC0116Ce.m476e(c1694ek, "call");
        this.f3316g.add(c1694ek);
    }

    public final synchronized ExecutorService m4876c() {
        ExecutorService executorService;
        try {
            if (this.f3313d == null) {
                this.f3313d = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), AbstractC2623yo.m10913I(AbstractC2623yo.f8135i + " Dispatcher", false));
            }
            executorService = this.f3313d;
            AbstractC0116Ce.m473b(executorService);
        } catch (Throwable th) {
            throw th;
        }
        return executorService;
    }

    public final C1694ek.a m4877d(String str) {
        Iterator it = this.f3315f.iterator();
        while (it.hasNext()) {
            C1694ek.a aVar = (C1694ek.a) it.next();
            if (AbstractC0116Ce.m472a(aVar.m7457d(), str)) {
                return aVar;
            }
        }
        Iterator it2 = this.f3314e.iterator();
        while (it2.hasNext()) {
            C1694ek.a aVar2 = (C1694ek.a) it2.next();
            if (AbstractC0116Ce.m472a(aVar2.m7457d(), str)) {
                return aVar2;
            }
        }
        return null;
    }

    public final void m4878e(Deque deque, Object obj) {
        Runnable runnable;
        synchronized (this) {
            if (!deque.remove(obj)) {
                throw new AssertionError("Call wasn't in-flight!");
            }
            runnable = this.f3312c;
            C2116no c2116no = C2116no.f6480a;
        }
        if (m4881h() || runnable == null) {
            return;
        }
        runnable.run();
    }

    public final void m4879f(C1694ek.a aVar) {
        AbstractC0116Ce.m476e(aVar, "call");
        aVar.m7456c().decrementAndGet();
        m4878e(this.f3315f, aVar);
    }

    public final void m4880g(C1694ek c1694ek) {
        AbstractC0116Ce.m476e(c1694ek, "call");
        m4878e(this.f3316g, c1694ek);
    }

    public final boolean m4881h() {
        int i;
        boolean z;
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
        ArrayList arrayList = new ArrayList<>();
        synchronized (this) {
            try {
                Iterator it = this.f3314e.iterator();
                AbstractC0116Ce.m475d(it, "readyAsyncCalls.iterator()");
                while (it.hasNext()) {
                    C1694ek.a aVar = (C1694ek.a) it.next();
                    if (this.f3315f.size() >= this.f3310a) {
                        break;
                    }
                    if (aVar.m7456c().get() < this.f3311b) {
                        it.remove();
                        aVar.m7456c().incrementAndGet();
                        AbstractC0116Ce.m475d(aVar, "asyncCall");
                        arrayList.add(aVar);
                        this.f3315f.add(aVar);
                    }
                }
                z = m4882i() > 0;
                C2116no c2116no = C2116no.f6480a;
            } catch (Throwable th) {
                throw th;
            }
        }
        int size = arrayList.size();
        for (i = 0; i < size; i++) {
            ((C1694ek.a) arrayList.get(i)).m7454a(m4876c());
        }
        return z;
    }

    public final synchronized int m4882i() {
        return this.f3315f.size() + this.f3316g.size();
    }

    public final void m4883j(int i) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.f3310a = i;
            C2116no c2116no = C2116no.f6480a;
        }
        m4881h();
    }

    public final void m4884k(int i) {
        if (!(i >= 1)) {
            throw new IllegalArgumentException(("max < 1: " + i).toString());
        }
        synchronized (this) {
            this.f3311b = i;
            C2116no c2116no = C2116no.f6480a;
        }
        m4881h();
    }
}
