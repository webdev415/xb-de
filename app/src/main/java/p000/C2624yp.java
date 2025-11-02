package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class C2624yp {

    public static final AtomicReferenceFieldUpdater f8139b = AtomicReferenceFieldUpdater.newUpdater(C2624yp.class, Object.class, "lastScheduledTask");

    public static final AtomicIntegerFieldUpdater f8140c = AtomicIntegerFieldUpdater.newUpdater(C2624yp.class, "producerIndex");

    public static final AtomicIntegerFieldUpdater f8141d = AtomicIntegerFieldUpdater.newUpdater(C2624yp.class, "consumerIndex");

    public static final AtomicIntegerFieldUpdater f8142e = AtomicIntegerFieldUpdater.newUpdater(C2624yp.class, "blockingTasksInBuffer");

    public final AtomicReferenceArray f8143a = new AtomicReferenceArray(128);
    private volatile int blockingTasksInBuffer;
    private volatile int consumerIndex;
    private volatile Object lastScheduledTask;
    private volatile int producerIndex;

    public final AbstractRunnableC1744fn m10952a(AbstractRunnableC1744fn abstractRunnableC1744fn, boolean z) {
        if (z) {
            return m10953b(abstractRunnableC1744fn);
        }
        AbstractRunnableC1744fn abstractRunnableC1744fn2 = (AbstractRunnableC1744fn) f8139b.getAndSet(this, abstractRunnableC1744fn);
        if (abstractRunnableC1744fn2 == null) {
            return null;
        }
        return m10953b(abstractRunnableC1744fn2);
    }

    public final AbstractRunnableC1744fn m10953b(AbstractRunnableC1744fn abstractRunnableC1744fn) {
        if (m10955d() == 127) {
            return abstractRunnableC1744fn;
        }
        if (abstractRunnableC1744fn.f5548m.mo8202a() == 1) {
            f8142e.incrementAndGet(this);
        }
        int i = f8140c.get(this) & 127;
        while (this.f8143a.get(i) != null) {
            Thread.yield();
        }
        this.f8143a.lazySet(i, abstractRunnableC1744fn);
        f8140c.incrementAndGet(this);
        return null;
    }

    public final void m10954c(AbstractRunnableC1744fn abstractRunnableC1744fn) {
        if (abstractRunnableC1744fn == null || abstractRunnableC1744fn.f5548m.mo8202a() != 1) {
            return;
        }
        f8142e.decrementAndGet(this);
    }

    public final int m10955d() {
        return f8140c.get(this) - f8141d.get(this);
    }

    public final int m10956e() {
        return f8139b.get(this) != null ? m10955d() + 1 : m10955d();
    }

    public final void m10957f(C0252Fc c0252Fc) {
        AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) f8139b.getAndSet(this, null);
        if (abstractRunnableC1744fn != null) {
            c0252Fc.m5667a(abstractRunnableC1744fn);
        }
        while (m10961j(c0252Fc)) {
        }
    }

    public final AbstractRunnableC1744fn m10958g() {
        AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) f8139b.getAndSet(this, null);
        return abstractRunnableC1744fn == null ? m10960i() : abstractRunnableC1744fn;
    }

    public final AbstractRunnableC1744fn m10959h() {
        return m10962k(true);
    }

    public final AbstractRunnableC1744fn m10960i() {
        AbstractRunnableC1744fn abstractRunnableC1744fn;
        while (true) {
            AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f8141d;
            int i = atomicIntegerFieldUpdater.get(this);
            if (i - f8140c.get(this) == 0) {
                return null;
            }
            int i2 = i & 127;
            if (atomicIntegerFieldUpdater.compareAndSet(this, i, i + 1) && (abstractRunnableC1744fn = (AbstractRunnableC1744fn) this.f8143a.getAndSet(i2, null)) != null) {
                m10954c(abstractRunnableC1744fn);
                return abstractRunnableC1744fn;
            }
        }
    }

    public final boolean m10961j(C0252Fc c0252Fc) {
        AbstractRunnableC1744fn abstractRunnableC1744fnM10960i = m10960i();
        if (abstractRunnableC1744fnM10960i == null) {
            return false;
        }
        c0252Fc.m5667a(abstractRunnableC1744fnM10960i);
        return true;
    }

    public final AbstractRunnableC1744fn m10962k(boolean z) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AbstractRunnableC1744fn abstractRunnableC1744fn;
        do {
            atomicReferenceFieldUpdater = f8139b;
            abstractRunnableC1744fn = (AbstractRunnableC1744fn) atomicReferenceFieldUpdater.get(this);
            if (abstractRunnableC1744fn != null) {
                if ((abstractRunnableC1744fn.f5548m.mo8202a() == 1) == z) {
                }
            }
            int i = f8141d.get(this);
            int i2 = f8140c.get(this);
            while (i != i2) {
                if (z && f8142e.get(this) == 0) {
                    return null;
                }
                i2--;
                AbstractRunnableC1744fn abstractRunnableC1744fnM10964m = m10964m(i2, z);
                if (abstractRunnableC1744fnM10964m != null) {
                    return abstractRunnableC1744fnM10964m;
                }
            }
            return null;
        } while (!AbstractC0506L.m2572a(atomicReferenceFieldUpdater, this, abstractRunnableC1744fn, null));
        return abstractRunnableC1744fn;
    }

    public final AbstractRunnableC1744fn m10963l(int i) {
        int i2 = f8141d.get(this);
        int i3 = f8140c.get(this);
        boolean z = i == 1;
        while (i2 != i3) {
            if (z && f8142e.get(this) == 0) {
                return null;
            }
            int i4 = i2 + 1;
            AbstractRunnableC1744fn abstractRunnableC1744fnM10964m = m10964m(i2, z);
            if (abstractRunnableC1744fnM10964m != null) {
                return abstractRunnableC1744fnM10964m;
            }
            i2 = i4;
        }
        return null;
    }

    public final AbstractRunnableC1744fn m10964m(int i, boolean z) {
        int i2 = i & 127;
        AbstractRunnableC1744fn abstractRunnableC1744fn = (AbstractRunnableC1744fn) this.f8143a.get(i2);
        if (abstractRunnableC1744fn != null) {
            if ((abstractRunnableC1744fn.f5548m.mo8202a() == 1) == z && AbstractC2578xp.m10784a(this.f8143a, i2, abstractRunnableC1744fn, null)) {
                if (z) {
                    f8142e.decrementAndGet(this);
                }
                return abstractRunnableC1744fn;
            }
        }
        return null;
    }

    public final long m10965n(int i, C2205pk c2205pk) {
        AbstractRunnableC1744fn abstractRunnableC1744fnM10960i = i == 3 ? m10960i() : m10963l(i);
        if (abstractRunnableC1744fnM10960i == null) {
            return m10966o(i, c2205pk);
        }
        c2205pk.f6647l = abstractRunnableC1744fnM10960i;
        return -1L;
    }

    public final long m10966o(int i, C2205pk c2205pk) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater;
        AbstractRunnableC1744fn abstractRunnableC1744fn;
        do {
            atomicReferenceFieldUpdater = f8139b;
            abstractRunnableC1744fn = (AbstractRunnableC1744fn) atomicReferenceFieldUpdater.get(this);
            if (abstractRunnableC1744fn == null) {
                return -2L;
            }
            if (((abstractRunnableC1744fn.f5548m.mo8202a() != 1 ? 2 : 1) & i) == 0) {
                return -2L;
            }
            long jMo8177a = AbstractC2392tn.f7262f.mo8177a() - abstractRunnableC1744fn.f5547l;
            long j = AbstractC2392tn.f7258b;
            if (jMo8177a < j) {
                return j - jMo8177a;
            }
        } while (!AbstractC0506L.m2572a(atomicReferenceFieldUpdater, this, abstractRunnableC1744fn, null));
        c2205pk.f6647l = abstractRunnableC1744fn;
        return -1L;
    }
}
