package p000;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: classes.dex */
public abstract class AbstractC0416J1 extends AbstractC1084Xh {

    public static final AtomicReferenceFieldUpdater f1254a = AtomicReferenceFieldUpdater.newUpdater(AbstractC0416J1.class, Object.class, "_consensus");
    private volatile Object _consensus = AbstractC0370I1.f1113a;

    @Override
    public final Object mo1779a(Object obj) {
        Object objM1781c = f1254a.get(this);
        if (objM1781c == AbstractC0370I1.f1113a) {
            objM1781c = m1781c(mo1782d(obj));
        }
        mo1780b(obj, objM1781c);
        return objM1781c;
    }

    public abstract void mo1780b(Object obj, Object obj2);

    public final Object m1781c(Object obj) {
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = f1254a;
        Object obj2 = atomicReferenceFieldUpdater.get(this);
        Object obj3 = AbstractC0370I1.f1113a;
        return obj2 != obj3 ? obj2 : AbstractC0506L.m2572a(atomicReferenceFieldUpdater, this, obj3, obj) ? obj : atomicReferenceFieldUpdater.get(this);
    }

    public abstract Object mo1782d(Object obj);
}
