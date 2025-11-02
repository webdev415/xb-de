package p000;

import java.util.Locale;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public abstract class AbstractC0460K implements InterfaceFutureC0852Sf {

    public static final boolean f1472o = Boolean.parseBoolean(System.getProperty("guava.concurrent.generate_cancellation_cause", "false"));

    public static final Logger f1473p = Logger.getLogger(AbstractC0460K.class.getName());

    public static final b f1474q;

    public static final Object f1475r;

    public volatile Object f1476l;

    public volatile e f1477m;

    public volatile h f1478n;

    public static abstract class b {
        public b() {
        }

        public abstract boolean mo2231a(AbstractC0460K abstractC0460K, e eVar, e eVar2);

        public abstract boolean mo2232b(AbstractC0460K abstractC0460K, Object obj, Object obj2);

        public abstract boolean mo2233c(AbstractC0460K abstractC0460K, h hVar, h hVar2);

        public abstract void mo2234d(h hVar, h hVar2);

        public abstract void mo2235e(h hVar, Thread thread);
    }

    public static final class c {

        public static final c f1479c;

        public static final c f1480d;

        public final boolean f1481a;

        public final Throwable f1482b;

        static {
            if (AbstractC0460K.f1472o) {
                f1480d = null;
                f1479c = null;
            } else {
                f1480d = new c(false, null);
                f1479c = new c(true, null);
            }
        }

        public c(boolean z, Throwable th) {
            this.f1481a = z;
            this.f1482b = th;
        }
    }

    public static final class d {

        public static final d f1483b = new d(new a("Failure occurred while trying to finish a future."));

        public final Throwable f1484a;

        public class a extends Throwable {
            public a(String str) {
                super(str);
            }

            @Override
            public synchronized Throwable fillInStackTrace() {
                return this;
            }
        }

        public d(Throwable th) {
            this.f1484a = (Throwable) AbstractC0460K.m2217i(th);
        }
    }

    public static final class e {

        public static final e f1485d = new e(null, null);

        public final Runnable f1486a;

        public final Executor f1487b;

        public e f1488c;

        public e(Runnable runnable, Executor executor) {
            this.f1486a = runnable;
            this.f1487b = executor;
        }
    }

    public static final class f extends b {

        public final AtomicReferenceFieldUpdater f1489a;

        public final AtomicReferenceFieldUpdater f1490b;

        public final AtomicReferenceFieldUpdater f1491c;

        public final AtomicReferenceFieldUpdater f1492d;

        public final AtomicReferenceFieldUpdater f1493e;

        public f(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater3, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater4, AtomicReferenceFieldUpdater atomicReferenceFieldUpdater5) {
            super();
            this.f1489a = atomicReferenceFieldUpdater;
            this.f1490b = atomicReferenceFieldUpdater2;
            this.f1491c = atomicReferenceFieldUpdater3;
            this.f1492d = atomicReferenceFieldUpdater4;
            this.f1493e = atomicReferenceFieldUpdater5;
        }

        @Override
        public boolean mo2231a(AbstractC0460K abstractC0460K, e eVar, e eVar2) {
            return AbstractC0506L.m2572a(this.f1492d, abstractC0460K, eVar, eVar2);
        }

        @Override
        public boolean mo2232b(AbstractC0460K abstractC0460K, Object obj, Object obj2) {
            return AbstractC0506L.m2572a(this.f1493e, abstractC0460K, obj, obj2);
        }

        @Override
        public boolean mo2233c(AbstractC0460K abstractC0460K, h hVar, h hVar2) {
            return AbstractC0506L.m2572a(this.f1491c, abstractC0460K, hVar, hVar2);
        }

        @Override
        public void mo2234d(h hVar, h hVar2) {
            this.f1490b.lazySet(hVar, hVar2);
        }

        @Override
        public void mo2235e(h hVar, Thread thread) {
            this.f1489a.lazySet(hVar, thread);
        }
    }

    public static final class g extends b {
        public g() {
            super();
        }

        @Override
        public boolean mo2231a(AbstractC0460K abstractC0460K, e eVar, e eVar2) {
            synchronized (abstractC0460K) {
                try {
                    if (abstractC0460K.f1477m != eVar) {
                        return false;
                    }
                    abstractC0460K.f1477m = eVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public boolean mo2232b(AbstractC0460K abstractC0460K, Object obj, Object obj2) {
            synchronized (abstractC0460K) {
                try {
                    if (abstractC0460K.f1476l != obj) {
                        return false;
                    }
                    abstractC0460K.f1476l = obj2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public boolean mo2233c(AbstractC0460K abstractC0460K, h hVar, h hVar2) {
            synchronized (abstractC0460K) {
                try {
                    if (abstractC0460K.f1478n != hVar) {
                        return false;
                    }
                    abstractC0460K.f1478n = hVar2;
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override
        public void mo2234d(h hVar, h hVar2) {
            hVar.f1496b = hVar2;
        }

        @Override
        public void mo2235e(h hVar, Thread thread) {
            hVar.f1495a = thread;
        }
    }

    public static final class h {

        public static final h f1494c = new h(false);

        public volatile Thread f1495a;

        public volatile h f1496b;

        public h() {
            AbstractC0460K.f1474q.mo2235e(this, Thread.currentThread());
        }

        public void m2236a(h hVar) {
            AbstractC0460K.f1474q.mo2234d(this, hVar);
        }

        public void m2237b() {
            Thread thread = this.f1495a;
            if (thread != null) {
                this.f1495a = null;
                LockSupport.unpark(thread);
            }
        }

        public h(boolean z) {
        }
    }

    static {
        b gVar;
        try {
            gVar = new f(AtomicReferenceFieldUpdater.newUpdater(h.class, Thread.class, "a"), AtomicReferenceFieldUpdater.newUpdater(h.class, h.class, "b"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0460K.class, h.class, "n"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0460K.class, e.class, "m"), AtomicReferenceFieldUpdater.newUpdater(AbstractC0460K.class, Object.class, "l"));
            th = null;
        } catch (Throwable th) {
            th = th;
            gVar = new g();
        }
        f1474q = gVar;
        if (th != null) {
            f1473p.log(Level.SEVERE, "SafeAtomicHelper is broken!", th);
        }
        f1475r = new Object();
    }

    public static CancellationException m2216h(String str, Throwable th) {
        CancellationException cancellationException = new CancellationException(str);
        cancellationException.initCause(th);
        return cancellationException;
    }

    public static Object m2217i(Object obj) {
        obj.getClass();
        return obj;
    }

    public static void m2218k(AbstractC0460K abstractC0460K) {
        abstractC0460K.m2227q();
        abstractC0460K.mo212g();
        e eVarM2223j = abstractC0460K.m2223j(null);
        while (eVarM2223j != null) {
            e eVar = eVarM2223j.f1488c;
            m2219l(eVarM2223j.f1486a, eVarM2223j.f1487b);
            eVarM2223j = eVar;
        }
    }

    public static void m2219l(Runnable runnable, Executor executor) {
        try {
            executor.execute(runnable);
        } catch (RuntimeException e2) {
            f1473p.log(Level.SEVERE, "RuntimeException while executing runnable " + runnable + " with executor " + executor, (Throwable) e2);
        }
    }

    public static Object m2220n(Future future) {
        Object obj;
        boolean z = false;
        while (true) {
            try {
                obj = future.get();
                break;
            } catch (InterruptedException unused) {
                z = true;
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
        return obj;
    }

    @Override
    public final void mo2221c(Runnable runnable, Executor executor) {
        m2217i(runnable);
        m2217i(executor);
        e eVar = this.f1477m;
        if (eVar != e.f1485d) {
            e eVar2 = new e(runnable, executor);
            do {
                eVar2.f1488c = eVar;
                if (f1474q.mo2231a(this, eVar, eVar2)) {
                    return;
                } else {
                    eVar = this.f1477m;
                }
            } while (eVar != e.f1485d);
        }
        m2219l(runnable, executor);
    }

    @Override
    public final boolean cancel(boolean z) {
        Object obj = this.f1476l;
        if (obj == null) {
            if (f1474q.mo2232b(this, obj, f1472o ? new c(z, new CancellationException("Future.cancel() was called.")) : z ? c.f1479c : c.f1480d)) {
                if (z) {
                    m2225o();
                }
                m2218k(this);
                return true;
            }
        }
        return false;
    }

    public final void m2222e(StringBuilder sb) {
        String str = "]";
        try {
            Object objM2220n = m2220n(this);
            sb.append("SUCCESS, result=[");
            sb.append(m2229u(objM2220n));
            sb.append("]");
        } catch (CancellationException unused) {
            str = "CANCELLED";
            sb.append(str);
        } catch (RuntimeException e2) {
            sb.append("UNKNOWN, cause=[");
            sb.append(e2.getClass());
            str = " thrown from get()]";
            sb.append(str);
        } catch (ExecutionException e3) {
            sb.append("FAILURE, cause=[");
            sb.append(e3.getCause());
            sb.append(str);
        }
    }

    @Override
    public final Object get() throws InterruptedException {
        Object obj;
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj2 = this.f1476l;
        if (obj2 != null) {
            return m2224m(obj2);
        }
        h hVar = this.f1478n;
        if (hVar != h.f1494c) {
            h hVar2 = new h();
            do {
                hVar2.m2236a(hVar);
                if (f1474q.mo2233c(this, hVar, hVar2)) {
                    do {
                        LockSupport.park(this);
                        if (Thread.interrupted()) {
                            m2228r(hVar2);
                            throw new InterruptedException();
                        }
                        obj = this.f1476l;
                    } while (!(obj != null));
                    return m2224m(obj);
                }
                hVar = this.f1478n;
            } while (hVar != h.f1494c);
        }
        return m2224m(this.f1476l);
    }

    @Override
    public final boolean isCancelled() {
        return this.f1476l instanceof c;
    }

    @Override
    public final boolean isDone() {
        return this.f1476l != null;
    }

    public final e m2223j(e eVar) {
        e eVar2;
        do {
            eVar2 = this.f1477m;
        } while (!f1474q.mo2231a(this, eVar2, e.f1485d));
        e eVar3 = eVar;
        e eVar4 = eVar2;
        while (eVar4 != null) {
            e eVar5 = eVar4.f1488c;
            eVar4.f1488c = eVar3;
            eVar3 = eVar4;
            eVar4 = eVar5;
        }
        return eVar3;
    }

    public final Object m2224m(Object obj) throws ExecutionException {
        if (obj instanceof c) {
            throw m2216h("Task was cancelled.", ((c) obj).f1482b);
        }
        if (obj instanceof d) {
            throw new ExecutionException(((d) obj).f1484a);
        }
        if (obj == f1475r) {
            return null;
        }
        return obj;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public String mo2226p() {
        if (!(this instanceof ScheduledFuture)) {
            return null;
        }
        return "remaining delay=[" + ((ScheduledFuture) this).getDelay(TimeUnit.MILLISECONDS) + " ms]";
    }

    public final void m2227q() {
        h hVar;
        do {
            hVar = this.f1478n;
        } while (!f1474q.mo2233c(this, hVar, h.f1494c));
        while (hVar != null) {
            hVar.m2237b();
            hVar = hVar.f1496b;
        }
    }

    public final void m2228r(h hVar) {
        hVar.f1495a = null;
        while (true) {
            h hVar2 = this.f1478n;
            if (hVar2 == h.f1494c) {
                return;
            }
            h hVar3 = null;
            while (hVar2 != null) {
                h hVar4 = hVar2.f1496b;
                if (hVar2.f1495a != null) {
                    hVar3 = hVar2;
                } else if (hVar3 != null) {
                    hVar3.f1496b = hVar4;
                    if (hVar3.f1495a == null) {
                        break;
                    }
                } else if (!f1474q.mo2233c(this, hVar2, hVar4)) {
                    break;
                }
                hVar2 = hVar4;
            }
            return;
        }
    }

    public boolean mo1594s(Object obj) {
        if (obj == null) {
            obj = f1475r;
        }
        if (!f1474q.mo2232b(this, null, obj)) {
            return false;
        }
        m2218k(this);
        return true;
    }

    public boolean mo1595t(Throwable th) {
        if (!f1474q.mo2232b(this, null, new d((Throwable) m2217i(th)))) {
            return false;
        }
        m2218k(this);
        return true;
    }

    public String toString() {
        String strMo2226p;
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("[status=");
        if (!isCancelled()) {
            if (isDone()) {
                m2222e(sb);
            } else {
                try {
                    strMo2226p = mo2226p();
                } catch (RuntimeException e2) {
                    strMo2226p = "Exception thrown from implementation: " + e2.getClass();
                }
                if (strMo2226p == null || strMo2226p.isEmpty()) {
                    str = isDone() ? "CANCELLED" : "PENDING";
                    m2222e(sb);
                } else {
                    sb.append("PENDING, info=[");
                    sb.append(strMo2226p);
                    sb.append("]");
                }
            }
            sb.append("]");
            return sb.toString();
        }
        sb.append(str);
        sb.append("]");
        return sb.toString();
    }

    public final String m2229u(Object obj) {
        return obj == this ? "this future" : String.valueOf(obj);
    }

    public final boolean m2230v() {
        Object obj = this.f1476l;
        return (obj instanceof c) && ((c) obj).f1481a;
    }

    @Override
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        if (Thread.interrupted()) {
            throw new InterruptedException();
        }
        Object obj = this.f1476l;
        if (obj != null) {
            return m2224m(obj);
        }
        long jNanoTime = nanos > 0 ? System.nanoTime() + nanos : 0L;
        if (nanos >= 1000) {
            h hVar = this.f1478n;
            if (hVar != h.f1494c) {
                h hVar2 = new h();
                do {
                    hVar2.m2236a(hVar);
                    if (f1474q.mo2233c(this, hVar, hVar2)) {
                        do {
                            LockSupport.parkNanos(this, nanos);
                            if (Thread.interrupted()) {
                                m2228r(hVar2);
                                throw new InterruptedException();
                            }
                            Object obj2 = this.f1476l;
                            if (obj2 != null) {
                                return m2224m(obj2);
                            }
                            nanos = jNanoTime - System.nanoTime();
                        } while (nanos >= 1000);
                        m2228r(hVar2);
                    } else {
                        hVar = this.f1478n;
                    }
                } while (hVar != h.f1494c);
            }
            return m2224m(this.f1476l);
        }
        while (nanos > 0) {
            Object obj3 = this.f1476l;
            if (obj3 != null) {
                return m2224m(obj3);
            }
            if (Thread.interrupted()) {
                throw new InterruptedException();
            }
            nanos = jNanoTime - System.nanoTime();
        }
        String string = toString();
        String string2 = timeUnit.toString();
        Locale locale = Locale.ROOT;
        String lowerCase = string2.toLowerCase(locale);
        String str = "Waited " + j + " " + timeUnit.toString().toLowerCase(locale);
        if (nanos + 1000 < 0) {
            String str2 = str + " (plus ";
            long j2 = -nanos;
            long jConvert = timeUnit.convert(j2, TimeUnit.NANOSECONDS);
            long nanos2 = j2 - timeUnit.toNanos(jConvert);
            boolean z = jConvert == 0 || nanos2 > 1000;
            if (jConvert > 0) {
                String str3 = str2 + jConvert + " " + lowerCase;
                if (z) {
                    str3 = str3 + ",";
                }
                str2 = str3 + " ";
            }
            if (z) {
                str2 = str2 + nanos2 + " nanoseconds ";
            }
            str = str2 + "delay)";
        }
        if (isDone()) {
            throw new TimeoutException(str + " but future completed as timeout expired");
        }
        throw new TimeoutException(str + " for " + string);
    }

    public void mo212g() {
    }

    public void m2225o() {
    }
}
