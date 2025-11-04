package p000;

import java.util.Collection;
import java.util.Iterator;

public final class C2269r1 implements Collection {

    public final Object[] f6860l;

    public final boolean f6861m;

    public C2269r1(Object[] objArr, boolean z) {
        AbstractC0116Ce.m476e(objArr, "values");
        this.f6860l = objArr;
        this.f6861m = z;
    }

    @Override
    public boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean contains(Object obj) {
        return AbstractC0002A1.m4k(this.f6860l, obj);
    }

    @Override
    public boolean containsAll(Collection collection) {
        AbstractC0116Ce.m476e(collection, "elements");
        Collection collection2 = collection;
        if (collection2.isEmpty()) {
            return true;
        }
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public int m9254d() {
        return this.f6860l.length;
    }

    @Override
    public boolean isEmpty() {
        return this.f6860l.length == 0;
    }

    @Override
    public Iterator iterator() {
        return AbstractC2407u1.m9895a(this.f6860l);
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return m9254d();
    }

    @Override
    public final Object[] toArray() {
        return AbstractC1763g5.m7691a(this.f6860l, this.f6861m);
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "array");
        return AbstractC1623d5.m7301b(this, objArr);
    }
}
