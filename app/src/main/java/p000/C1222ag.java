package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class C1222ag {

    public static final AtomicReferenceFieldUpdater f3541l = AtomicReferenceFieldUpdater.newUpdater(C1222ag.class, Object.class, "_next");

    public static final AtomicReferenceFieldUpdater f3542m = AtomicReferenceFieldUpdater.newUpdater(C1222ag.class, Object.class, "_prev");

    public static final AtomicReferenceFieldUpdater f3543n = AtomicReferenceFieldUpdater.newUpdater(C1222ag.class, Object.class, "_removedRef");
    private volatile Object _next = this;
    private volatile Object _prev = this;
    private volatile Object _removedRef;

    public static abstract class a extends AbstractC0416J1 {

        public final C1222ag f3544b;

        public C1222ag f3545c;

        public a(C1222ag c1222ag) {
            this.f3544b = c1222ag;
        }

        @Override
        public void mo1780b(C1222ag c1222ag, Object obj) {
            boolean z = obj == null;
            C1222ag c1222ag2 = z ? this.f3544b : this.f3545c;
            if (c1222ag2 != null && AbstractC0506L.m2572a(C1222ag.f3541l, c1222ag, this, c1222ag2) && z) {
                C1222ag c1222ag3 = this.f3544b;
                C1222ag c1222ag4 = this.f3545c;
                AbstractC0116Ce.m473b(c1222ag4);
                c1222ag3.m5271m(c1222ag4);
            }
        }
    }

    public final boolean m5268i(C1222ag c1222ag) {
        f3542m.lazySet(c1222ag, this);
        f3541l.lazySet(c1222ag, this);
        while (m5272o() == this) {
            if (AbstractC0506L.m2572a(f3541l, this, this, c1222ag)) {
                c1222ag.m5271m(this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0042, code lost:
    
        if (p000.AbstractC0506L.m2572a(r4, r3, r2, ((p000.C2665zk) r5).f8267a) != false) goto L26;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C1222ag m5269k(AbstractC1084Xh r9) {
        /*
            r8 = this;
        L0:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r0 = p000.C1222ag.f3542m
            java.lang.Object r0 = r0.get(r8)
            ag r0 = (p000.C1222ag) r0
            r1 = 0
            r2 = r0
        La:
            r3 = r1
        Lb:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = p000.C1222ag.f3541l
            java.lang.Object r5 = r4.get(r2)
            if (r5 != r8) goto L20
            if (r0 != r2) goto L16
            return r2
        L16:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = p000.C1222ag.f3542m
            boolean r0 = p000.AbstractC0506L.m2572a(r1, r8, r0, r2)
            if (r0 != 0) goto L1f
            goto L0
        L1f:
            return r2
        L20:
            boolean r6 = r8.mo4952r()
            if (r6 == 0) goto L27
            return r1
        L27:
            if (r5 != r9) goto L2a
            return r2
        L2a:
            boolean r6 = r5 instanceof p000.AbstractC1084Xh
            if (r6 == 0) goto L34
            Xh r5 = (p000.AbstractC1084Xh) r5
            r5.mo1779a(r2)
            goto L0
        L34:
            boolean r6 = r5 instanceof p000.C2665zk
            if (r6 == 0) goto L50
            if (r3 == 0) goto L47
            zk r5 = (p000.C2665zk) r5
            ag r5 = r5.f8267a
            boolean r2 = p000.AbstractC0506L.m2572a(r4, r3, r2, r5)
            if (r2 != 0) goto L45
            goto L0
        L45:
            r2 = r3
            goto La
        L47:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = p000.C1222ag.f3542m
            java.lang.Object r2 = r4.get(r2)
            ag r2 = (p000.C1222ag) r2
            goto Lb
        L50:
            java.lang.String r3 = "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }"
            p000.AbstractC0116Ce.m474c(r5, r3)
            r3 = r5
            ag r3 = (p000.C1222ag) r3
            r7 = r3
            r3 = r2
            r2 = r7
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1222ag.m5269k(Xh):ag");
    }

    public final C1222ag m5270l(C1222ag c1222ag) {
        while (c1222ag.mo4952r()) {
            c1222ag = (C1222ag) f3542m.get(c1222ag);
        }
        return c1222ag;
    }

    public final void m5271m(C1222ag c1222ag) {
        C1222ag c1222ag2;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3542m;
        do {
            c1222ag2 = (C1222ag) atomicReferenceFieldUpdater.get(c1222ag);
            if (m5272o() != c1222ag) {
                return;
            }
        } while (!AbstractC0506L.m2572a(f3542m, c1222ag, c1222ag2, this));
        if (mo4952r()) {
            c1222ag.m5269k(null);
        }
    }

    public final Object m5272o() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3541l;
        while (true) {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (!(obj instanceof AbstractC1084Xh)) {
                return obj;
            }
            ((AbstractC1084Xh) obj).mo1779a(this);
        }
    }

    public final C1222ag m5273p() {
        return AbstractC1174Zf.m5040b(m5272o());
    }

    public final C1222ag m5274q() {
        C1222ag c1222agM5269k = m5269k(null);
        return c1222agM5269k == null ? m5270l((C1222ag) f3542m.get(this)) : c1222agM5269k;
    }

    public boolean mo4952r() {
        return m5272o() instanceof C2665zk;
    }

    public boolean m5275s() {
        return m5276t() == null;
    }

    public final C1222ag m5276t() {
        Object objM5272o;
        C1222ag c1222ag;
        do {
            objM5272o = m5272o();
            if (objM5272o instanceof C2665zk) {
                return ((C2665zk) objM5272o).f8267a;
            }
            if (objM5272o == this) {
                return (C1222ag) objM5272o;
            }
            AbstractC0116Ce.m474c(objM5272o, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode{ kotlinx.coroutines.internal.LockFreeLinkedListKt.Node }");
            c1222ag = (C1222ag) objM5272o;
        } while (!AbstractC0506L.m2572a(f3541l, this, objM5272o, c1222ag.m5277u()));
        c1222ag.m5269k(null);
        return null;
    }

    public String toString() {
        return new AbstractC2250qj(this) {
            @Override
            public Object get() {
                return AbstractC2505w7.m10433a(this.f1655m);
            }
        } + '@' + AbstractC2505w7.m10434b(this);
    }

    public final C2665zk m5277u() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3543n;
        C2665zk c2665zk = (C2665zk) atomicReferenceFieldUpdater.get(this);
        if (c2665zk != null) {
            return c2665zk;
        }
        C2665zk c2665zk2 = new C2665zk(this);
        atomicReferenceFieldUpdater.lazySet(this, c2665zk2);
        return c2665zk2;
    }

    public final int m5278v(C1222ag c1222ag, C1222ag c1222ag2, a aVar) {
        f3542m.lazySet(c1222ag, this);
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3541l;
        atomicReferenceFieldUpdater.lazySet(c1222ag, c1222ag2);
        aVar.f3545c = c1222ag2;
        if (AbstractC0506L.m2572a(atomicReferenceFieldUpdater, this, c1222ag2, aVar)) {
            return aVar.mo1779a(this) == null ? 1 : 2;
        }
        return 0;
    }
}
