package p000;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractC2543x implements Collection {

    public static final class a extends AbstractC0025Af implements InterfaceC0986Vb {
        public a() {
            super(1);
        }

        @Override
        public final CharSequence mo15n(Object obj) {
            return obj == AbstractC2543x.this ? "(this Collection)" : String.valueOf(obj);
        }
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
        if (isEmpty()) {
            return false;
        }
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (AbstractC0116Ce.m472a(it.next(), obj)) {
                return true;
            }
        }
        return false;
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

    public abstract int mo841d();

    @Override
    public boolean isEmpty() {
        return size() == 0;
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
        return mo841d();
    }

    @Override
    public Object[] toArray() {
        return AbstractC1623d5.m7300a(this);
    }

    public String toString() {
        return AbstractC2181p5.m9030y(this, ", ", "[", "]", 0, null, new a(), 24, null);
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "array");
        return AbstractC1623d5.m7301b(this, objArr);
    }
}
