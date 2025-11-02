package p000;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

/* loaded from: classes.dex */
public final class C2573xk extends AbstractC1367ce {

    public static final C2573xk f8021q = new C2573xk(AbstractC1080Xd.m4758s(), AbstractC1786gi.m7740c());

    public final transient AbstractC1080Xd f8022p;

    public C2573xk(AbstractC1080Xd abstractC1080Xd, Comparator comparator) {
        super(comparator);
        this.f8022p = abstractC1080Xd;
    }

    @Override
    public AbstractC1367ce mo5893A() {
        Comparator comparatorReverseOrder = Collections.reverseOrder(this.f3972n);
        return isEmpty() ? AbstractC1367ce.m5888C(comparatorReverseOrder) : new C2573xk(this.f8022p.mo4763t(), comparatorReverseOrder);
    }

    @Override
    public AbstractC1367ce mo5897F(Object obj, boolean z) {
        return m10771P(0, m10772Q(obj, z));
    }

    @Override
    public AbstractC1367ce mo5900I(Object obj, boolean z, Object obj2, boolean z2) {
        return mo5903L(obj, z).mo5897F(obj2, z2);
    }

    @Override
    public AbstractC1367ce mo5903L(Object obj, boolean z) {
        return m10771P(m10774S(obj, z), size());
    }

    @Override
    public AbstractC2209po descendingIterator() {
        return this.f8022p.mo4763t().iterator();
    }

    public C2573xk m10771P(int i, int i2) {
        return (i == 0 && i2 == size()) ? this : i < i2 ? new C2573xk(this.f8022p.subList(i, i2), this.f3972n) : AbstractC1367ce.m5888C(this.f3972n);
    }

    public int m10772Q(Object obj, boolean z) {
        int iBinarySearch = Collections.binarySearch(this.f8022p, AbstractC1131Yi.m4973i(obj), comparator());
        return iBinarySearch >= 0 ? z ? iBinarySearch + 1 : iBinarySearch : ~iBinarySearch;
    }

    @Override
    public AbstractC2209po iterator() {
        return this.f8022p.iterator();
    }

    public int m10774S(Object obj, boolean z) {
        int iBinarySearch = Collections.binarySearch(this.f8022p, AbstractC1131Yi.m4973i(obj), comparator());
        return iBinarySearch >= 0 ? z ? iBinarySearch : iBinarySearch + 1 : ~iBinarySearch;
    }

    public final int m10775T(Object obj) {
        return Collections.binarySearch(this.f8022p, obj, m10776U());
    }

    public Comparator m10776U() {
        return this.f3972n;
    }

    @Override
    public Object ceiling(Object obj) {
        int iM10774S = m10774S(obj, true);
        if (iM10774S == size()) {
            return null;
        }
        return this.f8022p.get(iM10774S);
    }

    @Override
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return m10775T(obj) >= 0;
        } catch (ClassCastException unused) {
            return false;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override
    public boolean containsAll(Collection collection) {
        if (collection instanceof InterfaceC1832hh) {
            collection = ((InterfaceC1832hh) collection).m7842n();
        }
        if (!AbstractC2114nm.m8796b(comparator(), collection) || collection.size() <= 1) {
            return super.containsAll(collection);
        }
        AbstractC2209po it = iterator();
        Iterator it2 = collection.iterator();
        if (!it.hasNext()) {
            return false;
        }
        Object next = it2.next();
        Object next2 = it.next();
        while (true) {
            try {
                int iM5904M = m5904M(next2, next);
                if (iM5904M < 0) {
                    if (!it.hasNext()) {
                        return false;
                    }
                    next2 = it.next();
                } else if (iM5904M == 0) {
                    if (!it2.hasNext()) {
                        return true;
                    }
                    next = it2.next();
                } else if (iM5904M > 0) {
                    break;
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override
    public int mo4493d(Object[] objArr, int i) {
        return this.f8022p.mo4493d(objArr, i);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Set)) {
            return false;
        }
        Set set = (Set) obj;
        if (size() != set.size()) {
            return false;
        }
        if (isEmpty()) {
            return true;
        }
        if (!AbstractC2114nm.m8796b(this.f3972n, set)) {
            return containsAll(set);
        }
        Iterator it = set.iterator();
        try {
            AbstractC2209po it2 = iterator();
            while (it2.hasNext()) {
                Object next = it2.next();
                Object next2 = it.next();
                if (next2 == null || m5904M(next, next2) != 0) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NoSuchElementException unused) {
            return false;
        }
    }

    @Override
    public Object[] mo4494f() {
        return this.f8022p.mo4494f();
    }

    @Override
    public Object first() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f8022p.get(0);
    }

    @Override
    public Object floor(Object obj) {
        int iM10772Q = m10772Q(obj, true) - 1;
        if (iM10772Q == -1) {
            return null;
        }
        return this.f8022p.get(iM10772Q);
    }

    @Override
    public int mo4495g() {
        return this.f8022p.mo4495g();
    }

    @Override
    public int mo4496h() {
        return this.f8022p.mo4496h();
    }

    @Override
    public Object higher(Object obj) {
        int iM10774S = m10774S(obj, false);
        if (iM10774S == size()) {
            return null;
        }
        return this.f8022p.get(iM10774S);
    }

    @Override
    public boolean mo4497i() {
        return this.f8022p.mo4497i();
    }

    @Override
    public Object last() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.f8022p.get(size() - 1);
    }

    @Override
    public Object lower(Object obj) {
        int iM10772Q = m10772Q(obj, false) - 1;
        if (iM10772Q == -1) {
            return null;
        }
        return this.f8022p.get(iM10772Q);
    }

    @Override
    public int size() {
        return this.f8022p.size();
    }
}
