package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;

/* loaded from: classes.dex */
public abstract class AbstractC0184E extends AbstractC2543x implements List {

    public static final a f444l = new a(null);

    public static final class a {
        public a() {
        }

        public final void m834a(int i, int i2) {
            if (i < 0 || i >= i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void m835b(int i, int i2) {
            if (i < 0 || i > i2) {
                throw new IndexOutOfBoundsException("index: " + i + ", size: " + i2);
            }
        }

        public final void m836c(int i, int i2, int i3) {
            if (i < 0 || i2 > i3) {
                throw new IndexOutOfBoundsException("fromIndex: " + i + ", toIndex: " + i2 + ", size: " + i3);
            }
            if (i <= i2) {
                return;
            }
            throw new IllegalArgumentException("fromIndex: " + i + " > toIndex: " + i2);
        }

        public final boolean m837d(Collection collection, Collection collection2) {
            AbstractC0116Ce.m476e(collection, "c");
            AbstractC0116Ce.m476e(collection2, "other");
            if (collection.size() != collection2.size()) {
                return false;
            }
            Iterator it = collection2.iterator();
            Iterator it2 = collection.iterator();
            while (it2.hasNext()) {
                if (!AbstractC0116Ce.m472a(it2.next(), it.next())) {
                    return false;
                }
            }
            return true;
        }

        public final int m838e(Collection collection) {
            AbstractC0116Ce.m476e(collection, "c");
            Iterator it = collection.iterator();
            int iHashCode = 1;
            while (it.hasNext()) {
                Object next = it.next();
                iHashCode = (iHashCode * 31) + (next != null ? next.hashCode() : 0);
            }
            return iHashCode;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public class b implements Iterator {

        public int f445l;

        public b() {
        }

        public final int m839b() {
            return this.f445l;
        }

        public final void m840c(int i) {
            this.f445l = i;
        }

        @Override
        public boolean hasNext() {
            return this.f445l < AbstractC0184E.this.size();
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            AbstractC0184E abstractC0184E = AbstractC0184E.this;
            int i = this.f445l;
            this.f445l = i + 1;
            return abstractC0184E.get(i);
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public class c extends b implements ListIterator {
        public c(int i) {
            super();
            AbstractC0184E.f444l.m835b(i, AbstractC0184E.this.size());
            m840c(i);
        }

        @Override
        public void add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override
        public boolean hasPrevious() {
            return m839b() > 0;
        }

        @Override
        public int nextIndex() {
            return m839b();
        }

        @Override
        public Object previous() {
            if (!hasPrevious()) {
                throw new NoSuchElementException();
            }
            AbstractC0184E abstractC0184E = AbstractC0184E.this;
            m840c(m839b() - 1);
            return abstractC0184E.get(m839b());
        }

        @Override
        public int previousIndex() {
            return m839b() - 1;
        }

        @Override
        public void set(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public static final class d extends AbstractC0184E implements RandomAccess {

        public final AbstractC0184E f448m;

        public final int f449n;

        public int f450o;

        public d(AbstractC0184E abstractC0184E, int i, int i2) {
            AbstractC0116Ce.m476e(abstractC0184E, "list");
            this.f448m = abstractC0184E;
            this.f449n = i;
            AbstractC0184E.f444l.m836c(i, i2, abstractC0184E.size());
            this.f450o = i2 - i;
        }

        @Override
        public int mo841d() {
            return this.f450o;
        }

        @Override
        public Object get(int i) {
            AbstractC0184E.f444l.m834a(i, this.f450o);
            return this.f448m.get(this.f449n + i);
        }
    }

    @Override
    public void add(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            return f444l.m837d(this, (Collection) obj);
        }
        return false;
    }

    @Override
    public abstract Object get(int i);

    @Override
    public int hashCode() {
        return f444l.m838e(this);
    }

    @Override
    public int indexOf(Object obj) {
        Iterator it = iterator();
        int i = 0;
        while (it.hasNext()) {
            if (AbstractC0116Ce.m472a(it.next(), obj)) {
                return i;
            }
            i++;
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new b();
    }

    @Override
    public int lastIndexOf(Object obj) {
        ListIterator listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (AbstractC0116Ce.m472a(listIterator.previous(), obj)) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override
    public ListIterator listIterator() {
        return new c(0);
    }

    @Override
    public Object remove(int i) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public Object set(int i, Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override
    public List subList(int i, int i2) {
        return new d(this, i, i2);
    }

    @Override
    public ListIterator listIterator(int i) {
        return new c(i);
    }
}
