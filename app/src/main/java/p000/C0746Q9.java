package p000;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public final class C0746Q9 implements List, Serializable, RandomAccess {

    public static final C0746Q9 f2208l = new C0746Q9();

    @Override
    public /* bridge */ void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Void) {
            return m3639d((Void) obj);
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection collection) {
        AbstractC0116Ce.m476e(collection, "elements");
        return collection.isEmpty();
    }

    public boolean m3639d(Void r2) {
        AbstractC0116Ce.m476e(r2, "element");
        return false;
    }

    @Override
    public boolean equals(Object obj) {
        return (obj instanceof List) && ((List) obj).isEmpty();
    }

    @Override
    public Void get(int i) {
        throw new IndexOutOfBoundsException("Empty list doesn't contain element at index " + i + '.');
    }

    public int m3641g() {
        return 0;
    }

    public int m3642h(Void r2) {
        AbstractC0116Ce.m476e(r2, "element");
        return -1;
    }

    @Override
    public int hashCode() {
        return 1;
    }

    public int m3643i(Void r2) {
        AbstractC0116Ce.m476e(r2, "element");
        return -1;
    }

    @Override
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Void) {
            return m3642h((Void) obj);
        }
        return -1;
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
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Void) {
            return m3643i((Void) obj);
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return C0700P9.f2091l;
    }

    @Override
    public /* bridge */ Object remove(int i) {
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
    public /* bridge */ Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public final /* bridge */ int size() {
        return m3641g();
    }

    @Override
    public List subList(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return this;
        }
        throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2);
    }

    @Override
    public Object[] toArray() {
        return AbstractC1623d5.m7300a(this);
    }

    public String toString() {
        return "[]";
    }

    @Override
    public /* bridge */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public ListIterator listIterator(int i) {
        if (i == 0) {
            return C0700P9.f2091l;
        }
        throw new IndexOutOfBoundsException("Index: " + i);
    }

    @Override
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object[] toArray(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "array");
        return AbstractC1623d5.m7301b(this, objArr);
    }
}
