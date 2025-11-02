package p000;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public final class C1369cg {

    public static final a f3974e = new a(null);

    public static final AtomicReferenceFieldUpdater f3975f = AtomicReferenceFieldUpdater.newUpdater(C1369cg.class, Object.class, "_next");

    public static final AtomicLongFieldUpdater f3976g = AtomicLongFieldUpdater.newUpdater(C1369cg.class, "_state");

    public static final C0951Um f3977h = new C0951Um("REMOVE_FROZEN");
    private volatile Object _next;
    private volatile long _state;

    public final int f3978a;

    public final boolean f3979b;

    public final int f3980c;

    public final AtomicReferenceArray f3981d;

    public static final class a {
        public a() {
        }

        public final int m5917a(long j) {
            return (j & 2305843009213693952L) != 0 ? 2 : 1;
        }

        public final long m5918b(long j, int i) {
            return m5920d(j, 1073741823L) | i;
        }

        public final long m5919c(long j, int i) {
            return m5920d(j, 1152921503533105152L) | (i << 30);
        }

        public final long m5920d(long j, long j2) {
            return j & (~j2);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b {

        public final int f3982a;

        public b(int i) {
            this.f3982a = i;
        }
    }

    public C1369cg(int i, boolean z) {
        this.f3978a = i;
        this.f3979b = z;
        int i2 = i - 1;
        this.f3980c = i2;
        this.f3981d = new AtomicReferenceArray(i);
        if (i2 > 1073741823) {
            throw new IllegalStateException("Check failed.".toString());
        }
        if ((i & i2) != 0) {
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
    
        return 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m5906a(Object r13) {
        /*
            r12 = this;
            java.util.concurrent.atomic.AtomicLongFieldUpdater r0 = p000.C1369cg.f3976g
        L2:
            long r3 = r0.get(r12)
            r1 = 3458764513820540928(0x3000000000000000, double:1.727233711018889E-77)
            long r1 = r1 & r3
            r7 = 0
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L16
            cg$a r13 = p000.C1369cg.f3974e
            int r13 = r13.m5917a(r3)
            return r13
        L16:
            r1 = 1073741823(0x3fffffff, double:5.304989472E-315)
            long r1 = r1 & r3
            int r1 = (int) r1
            r5 = 1152921503533105152(0xfffffffc0000000, double:1.2882296003504729E-231)
            long r5 = r5 & r3
            r2 = 30
            long r5 = r5 >> r2
            int r9 = (int) r5
            int r10 = r12.f3980c
            int r2 = r9 + 2
            r2 = r2 & r10
            r5 = r1 & r10
            r6 = 1
            if (r2 != r5) goto L30
            return r6
        L30:
            boolean r2 = r12.f3979b
            r5 = 1073741823(0x3fffffff, float:1.9999999)
            if (r2 != 0) goto L4f
            java.util.concurrent.atomic.AtomicReferenceArray r2 = r12.f3981d
            r11 = r9 & r10
            java.lang.Object r2 = r2.get(r11)
            if (r2 == 0) goto L4f
            int r2 = r12.f3978a
            r3 = 1024(0x400, float:1.435E-42)
            if (r2 < r3) goto L4e
            int r9 = r9 - r1
            r1 = r9 & r5
            int r2 = r2 >> 1
            if (r1 <= r2) goto L2
        L4e:
            return r6
        L4f:
            int r1 = r9 + 1
            r1 = r1 & r5
            java.util.concurrent.atomic.AtomicLongFieldUpdater r2 = p000.C1369cg.f3976g
            cg$a r5 = p000.C1369cg.f3974e
            long r5 = r5.m5919c(r3, r1)
            r1 = r2
            r2 = r12
            boolean r1 = r1.compareAndSet(r2, r3, r5)
            if (r1 == 0) goto L2
            java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f3981d
            r1 = r9 & r10
            r0.set(r1, r13)
            r0 = r12
        L6a:
            java.util.concurrent.atomic.AtomicLongFieldUpdater r1 = p000.C1369cg.f3976g
            long r1 = r1.get(r0)
            r3 = 1152921504606846976(0x1000000000000000, double:1.2882297539194267E-231)
            long r1 = r1 & r3
            int r1 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r1 == 0) goto L81
            cg r0 = r0.m5914i()
            cg r0 = r0.m5910e(r9, r13)
            if (r0 != 0) goto L6a
        L81:
            r13 = 0
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1369cg.m5906a(java.lang.Object):int");
    }

    public final C1369cg m5907b(long j) {
        C1369cg c1369cg = new C1369cg(this.f3978a * 2, this.f3979b);
        int i = (int) (1073741823 & j);
        int i2 = (int) ((1152921503533105152L & j) >> 30);
        while (true) {
            int i3 = this.f3980c;
            if ((i & i3) == (i2 & i3)) {
                f3976g.set(c1369cg, f3974e.m5920d(j, 1152921504606846976L));
                return c1369cg;
            }
            Object bVar = this.f3981d.get(i3 & i);
            if (bVar == null) {
                bVar = new b(i);
            }
            c1369cg.f3981d.set(c1369cg.f3980c & i, bVar);
            i++;
        }
    }

    public final C1369cg m5908c(long j) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3975f;
        while (true) {
            C1369cg c1369cg = (C1369cg) atomicReferenceFieldUpdater.get(this);
            if (c1369cg != null) {
                return c1369cg;
            }
            AbstractC0506L.m2572a(f3975f, this, null, m5907b(j));
        }
    }

    public final boolean m5909d() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3976g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 2305843009213693952L) != 0) {
                return true;
            }
            if ((1152921504606846976L & j) != 0) {
                return false;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j | 2305843009213693952L));
        return true;
    }

    public final C1369cg m5910e(int i, Object obj) {
        Object obj2 = this.f3981d.get(this.f3980c & i);
        if (!(obj2 instanceof b) || ((b) obj2).f3982a != i) {
            return null;
        }
        this.f3981d.set(i & this.f3980c, obj);
        return this;
    }

    public final int m5911f() {
        long j = f3976g.get(this);
        return (((int) ((j & 1152921503533105152L) >> 30)) - ((int) (1073741823 & j))) & 1073741823;
    }

    public final boolean m5912g() {
        long j = f3976g.get(this);
        return ((int) (1073741823 & j)) == ((int) ((j & 1152921503533105152L) >> 30));
    }

    public final long m5913h() {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3976g;
        do {
            j = atomicLongFieldUpdater.get(this);
            if ((j & 1152921504606846976L) != 0) {
                return j;
            }
            j2 = j | 1152921504606846976L;
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, j2));
        return j2;
    }

    public final C1369cg m5914i() {
        return m5908c(m5913h());
    }

    public final Object m5915j() {
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3976g;
        while (true) {
            long j = atomicLongFieldUpdater.get(this);
            if ((1152921504606846976L & j) != 0) {
                return f3977h;
            }
            int i = (int) (1073741823 & j);
            int i2 = this.f3980c;
            if ((((int) ((1152921503533105152L & j) >> 30)) & i2) == (i & i2)) {
                return null;
            }
            Object obj = this.f3981d.get(i2 & i);
            if (obj == null) {
                if (this.f3979b) {
                    return null;
                }
            } else {
                if (obj instanceof b) {
                    return null;
                }
                int i3 = (i + 1) & 1073741823;
                if (f3976g.compareAndSet(this, j, f3974e.m5918b(j, i3))) {
                    this.f3981d.set(this.f3980c & i, null);
                    return obj;
                }
                if (this.f3979b) {
                    C1369cg c1369cgM5916k = this;
                    do {
                        c1369cgM5916k = c1369cgM5916k.m5916k(i, i3);
                    } while (c1369cgM5916k != null);
                    return obj;
                }
            }
        }
    }

    public final C1369cg m5916k(int i, int i2) {
        long j;
        int i3;
        AtomicLongFieldUpdater atomicLongFieldUpdater = f3976g;
        do {
            j = atomicLongFieldUpdater.get(this);
            i3 = (int) (1073741823 & j);
            if ((1152921504606846976L & j) != 0) {
                return m5914i();
            }
        } while (!f3976g.compareAndSet(this, j, f3974e.m5918b(j, i2)));
        this.f3981d.set(this.f3980c & i3, null);
        return null;
    }
}
