package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public class C1323bg {

    public static final AtomicReferenceFieldUpdater f3874a = AtomicReferenceFieldUpdater.newUpdater(C1323bg.class, Object.class, "_cur");
    private volatile Object _cur;

    public C1323bg(boolean z) {
        this._cur = new C1369cg(8, z);
    }

    public final boolean m5667a(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3874a;
        while (true) {
            C1369cg c1369cg = (C1369cg) atomicReferenceFieldUpdater.get(this);
            int iM5906a = c1369cg.m5906a(obj);
            if (iM5906a == 0) {
                return true;
            }
            if (iM5906a == 1) {
                AbstractC0506L.m2572a(f3874a, this, c1369cg, c1369cg.m5914i());
            } else if (iM5906a == 2) {
                return false;
            }
        }
    }

    public final void m5668b() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3874a;
        while (true) {
            C1369cg c1369cg = (C1369cg) atomicReferenceFieldUpdater.get(this);
            if (c1369cg.m5909d()) {
                return;
            } else {
                AbstractC0506L.m2572a(f3874a, this, c1369cg, c1369cg.m5914i());
            }
        }
    }

    public final int m5669c() {
        return ((C1369cg) f3874a.get(this)).m5911f();
    }

    public final Object m5670d() {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f3874a;
        while (true) {
            C1369cg c1369cg = (C1369cg) atomicReferenceFieldUpdater.get(this);
            Object objM5915j = c1369cg.m5915j();
            if (objM5915j != C1369cg.f3977h) {
                return objM5915j;
            }
            AbstractC0506L.m2572a(f3874a, this, c1369cg, c1369cg.m5914i());
        }
    }
}
