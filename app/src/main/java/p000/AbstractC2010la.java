package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public abstract class AbstractC2010la extends AbstractC2056ma implements InterfaceC2091n8 {

    public static final AtomicReferenceFieldUpdater f6087q = AtomicReferenceFieldUpdater.newUpdater(AbstractC2010la.class, Object.class, "_queue");

    public static final AtomicReferenceFieldUpdater f6088r = AtomicReferenceFieldUpdater.newUpdater(AbstractC2010la.class, Object.class, "_delayed");

    public static final AtomicIntegerFieldUpdater f6089s = AtomicIntegerFieldUpdater.newUpdater(AbstractC2010la.class, "_isCompleted");
    private volatile Object _delayed;
    private volatile int _isCompleted = 0;
    private volatile Object _queue;

    public static final class a extends AbstractC2668zn {
    }

    private final boolean m8385l0() {
        return f6089s.get(this) != 0;
    }

    @Override
    public final void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        mo4333j0(runnable);
    }

    @Override
    public long mo8268Z() {
        if (super.mo8268Z() == 0) {
            return 0L;
        }
        Object obj = f6087q.get(this);
        if (obj != null) {
            if (!(obj instanceof C1369cg)) {
                return obj == AbstractC2148oa.f6559b ? Long.MAX_VALUE : 0L;
            }
            if (!((C1369cg) obj).m5912g()) {
                return 0L;
            }
        }
        return Long.MAX_VALUE;
    }

    public final void m8386h0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6087q;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                if (AbstractC0506L.m2572a(f6087q, this, null, AbstractC2148oa.f6559b)) {
                    return;
                }
            } else if (obj instanceof C1369cg) {
                ((C1369cg) obj).m5909d();
                return;
            } else {
                if (obj == AbstractC2148oa.f6559b) {
                    return;
                }
                C1369cg c1369cg = new C1369cg(8, true);
                AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c1369cg.m5906a((Runnable) obj);
                if (AbstractC0506L.m2572a(f6087q, this, obj, c1369cg)) {
                    return;
                }
            }
        }
    }

    public final Runnable m8387i0() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6087q;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj == null) {
                return null;
            }
            if (obj instanceof C1369cg) {
                AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                C1369cg c1369cg = (C1369cg) obj;
                Object objM5915j = c1369cg.m5915j();
                if (objM5915j != C1369cg.f3977h) {
                    return (Runnable) objM5915j;
                }
                AbstractC0506L.m2572a(f6087q, this, obj, c1369cg.m5914i());
            } else {
                if (obj == AbstractC2148oa.f6559b) {
                    return null;
                }
                if (AbstractC0506L.m2572a(f6087q, this, obj, null)) {
                    AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                    return (Runnable) obj;
                }
            }
        }
    }

    public void mo4333j0(Runnable runnable) {
        if (m8388k0(runnable)) {
            m8460g0();
        } else {
            RunnableC0973V7.f2938t.mo4333j0(runnable);
        }
    }

    public final boolean m8388k0(Runnable runnable) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f6087q;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (m8385l0()) {
                return false;
            }
            if (obj == null) {
                if (AbstractC0506L.m2572a(f6087q, this, null, runnable)) {
                    return true;
                }
            } else if (obj instanceof C1369cg) {
                AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeTaskQueueCore<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }>{ kotlinx.coroutines.EventLoop_commonKt.Queue<java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }> }");
                C1369cg c1369cg = (C1369cg) obj;
                int iM5906a = c1369cg.m5906a(runnable);
                if (iM5906a == 0) {
                    return true;
                }
                if (iM5906a == 1) {
                    AbstractC0506L.m2572a(f6087q, this, obj, c1369cg.m5914i());
                } else if (iM5906a == 2) {
                    return false;
                }
            } else {
                if (obj == AbstractC2148oa.f6559b) {
                    return false;
                }
                C1369cg c1369cg2 = new C1369cg(8, true);
                AbstractC0116Ce.m474c(obj, "null cannot be cast to non-null type java.lang.Runnable{ kotlinx.coroutines.RunnableKt.Runnable }");
                c1369cg2.m5906a((Runnable) obj);
                c1369cg2.m5906a(runnable);
                if (AbstractC0506L.m2572a(f6087q, this, obj, c1369cg2)) {
                    return true;
                }
            }
        }
    }

    public boolean m8389m0() {
        if (!m8271d0()) {
            return false;
        }
        Object obj = f6087q.get(this);
        if (obj != null) {
            if (obj instanceof C1369cg) {
                return ((C1369cg) obj).m5912g();
            }
            if (obj != AbstractC2148oa.f6559b) {
                return false;
            }
        }
        return true;
    }

    public long m8390n0() {
        if (m8272e0()) {
            return 0L;
        }
        Runnable runnableM8387i0 = m8387i0();
        if (runnableM8387i0 == null) {
            return mo8268Z();
        }
        runnableM8387i0.run();
        return 0L;
    }

    public final void m8391o0() {
        AbstractC0644O.m3350a();
        System.nanoTime();
    }

    public final void m8392p0() {
        f6087q.set(this, null);
        f6088r.set(this, null);
    }

    public final void m8393q0(boolean z) {
        f6089s.set(this, z ? 1 : 0);
    }

    @Override
    public void shutdown() {
        C2576xn.f8026a.m10782b();
        m8393q0(true);
        m8386h0();
        while (m8390n0() <= 0) {
        }
        m8391o0();
    }
}
