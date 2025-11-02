package p000;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.NavigableSet;

/* loaded from: classes.dex */
public abstract class AbstractC1367ce extends AbstractC1642de implements NavigableSet, InterfaceC2068mm {

    public final transient Comparator f3972n;

    public transient AbstractC1367ce f3973o;

    public AbstractC1367ce(Comparator comparator) {
        this.f3972n = comparator;
    }

    public static C2573xk m5888C(Comparator comparator) {
        return AbstractC1786gi.m7740c().equals(comparator) ? C2573xk.f8021q : new C2573xk(AbstractC1080Xd.m4758s(), comparator);
    }

    public static int m5889N(Comparator comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    public static AbstractC1367ce m5890x(Comparator comparator, int i, Object... objArr) {
        if (i == 0) {
            return m5888C(comparator);
        }
        AbstractC0165Dh.m711c(objArr, i);
        Arrays.sort(objArr, 0, i, comparator);
        int i2 = 1;
        for (int i3 = 1; i3 < i; i3++) {
            Object obj = objArr[i3];
            if (comparator.compare(obj, objArr[i2 - 1]) != 0) {
                objArr[i2] = obj;
                i2++;
            }
        }
        Arrays.fill(objArr, i2, i, (Object) null);
        if (i2 < objArr.length / 2) {
            objArr = Arrays.copyOf(objArr, i2);
        }
        return new C2573xk(AbstractC1080Xd.m4757o(objArr, i2), comparator);
    }

    public static AbstractC1367ce m5891y(Comparator comparator, Iterable iterable) {
        AbstractC1131Yi.m4973i(comparator);
        if (AbstractC2114nm.m8796b(comparator, iterable) && (iterable instanceof AbstractC1367ce)) {
            AbstractC1367ce abstractC1367ce = (AbstractC1367ce) iterable;
            if (!abstractC1367ce.mo4497i()) {
                return abstractC1367ce;
            }
        }
        Object[] objArrM2866b = AbstractC0576Me.m2866b(iterable);
        return m5890x(comparator, objArrM2866b.length, objArrM2866b);
    }

    public static AbstractC1367ce m5892z(Comparator comparator, Collection collection) {
        return m5891y(comparator, collection);
    }

    public abstract AbstractC1367ce mo5893A();

    @Override
    public AbstractC1367ce descendingSet() {
        AbstractC1367ce abstractC1367ce = this.f3973o;
        if (abstractC1367ce != null) {
            return abstractC1367ce;
        }
        AbstractC1367ce abstractC1367ceMo5893A = mo5893A();
        this.f3973o = abstractC1367ceMo5893A;
        abstractC1367ceMo5893A.f3973o = this;
        return abstractC1367ceMo5893A;
    }

    @Override
    public AbstractC1367ce headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override
    public AbstractC1367ce headSet(Object obj, boolean z) {
        return mo5897F(AbstractC1131Yi.m4973i(obj), z);
    }

    public abstract AbstractC1367ce mo5897F(Object obj, boolean z);

    @Override
    public AbstractC1367ce subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override
    public AbstractC1367ce subSet(Object obj, boolean z, Object obj2, boolean z2) {
        AbstractC1131Yi.m4973i(obj);
        AbstractC1131Yi.m4973i(obj2);
        AbstractC1131Yi.m4968d(this.f3972n.compare(obj, obj2) <= 0);
        return mo5900I(obj, z, obj2, z2);
    }

    public abstract AbstractC1367ce mo5900I(Object obj, boolean z, Object obj2, boolean z2);

    @Override
    public AbstractC1367ce tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override
    public AbstractC1367ce tailSet(Object obj, boolean z) {
        return mo5903L(AbstractC1131Yi.m4973i(obj), z);
    }

    public abstract AbstractC1367ce mo5903L(Object obj, boolean z);

    public int m5904M(Object obj, Object obj2) {
        return m5889N(this.f3972n, obj, obj2);
    }

    @Override
    public Comparator comparator() {
        return this.f3972n;
    }

    @Override
    public final Object pollFirst() {
        throw new UnsupportedOperationException();
    }

    @Override
    public final Object pollLast() {
        throw new UnsupportedOperationException();
    }
}
