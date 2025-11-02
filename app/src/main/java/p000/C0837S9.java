package p000;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class C0837S9 implements Set, Serializable {

    public static final C0837S9 f2606l = new C0837S9();

    @Override
    public /* bridge */ boolean add(Object obj) {
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
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m4015d((Void) obj);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        AbstractC0116Ce.m476e(collection, "elements");
        return collection.isEmpty();
    }

    public boolean m4015d(Void r2) {
        AbstractC0116Ce.m476e(r2, "element");
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof Set) && ((Set) obj).isEmpty();
    }

    public int m4016f() {
        return 0;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public Iterator iterator() {
        return C0700P9.f2091l;
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
        return m4016f();
    }

    @Override
    public Object[] toArray() {
        return AbstractC1623d5.m7300a(this);
    }

    public String toString() {
        return "[]";
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "array");
        return AbstractC1623d5.m7301b(this, objArr);
    }
}
