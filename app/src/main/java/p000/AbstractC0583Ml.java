package p000;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractC0583Ml {

    public class a extends b {

        public final Set f1849l;

        public final Set f1850m;

        public class C2693a extends AbstractC0138D {

            public final Iterator f1851n;

            public final Iterator f1852o;

            public C2693a() {
                this.f1851n = a.this.f1849l.iterator();
                this.f1852o = a.this.f1850m.iterator();
            }

            @Override
            public Object mo588b() {
                if (this.f1851n.hasNext()) {
                    return this.f1851n.next();
                }
                while (this.f1852o.hasNext()) {
                    Object next = this.f1852o.next();
                    if (!a.this.f1849l.contains(next)) {
                        return next;
                    }
                }
                return m589c();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Set set, Set set2) {
            super(null);
            this.f1849l = set;
            this.f1850m = set2;
        }

        @Override
        public boolean contains(Object obj) {
            return this.f1849l.contains(obj) || this.f1850m.contains(obj);
        }

        @Override
        public AbstractC2209po iterator() {
            return new C2693a();
        }

        @Override
        public boolean isEmpty() {
            return this.f1849l.isEmpty() && this.f1850m.isEmpty();
        }

        @Override
        public int size() {
            int size = this.f1849l.size();
            Iterator it = this.f1850m.iterator();
            while (it.hasNext()) {
                if (!this.f1849l.contains(it.next())) {
                    size++;
                }
            }
            return size;
        }
    }

    public static abstract class b extends AbstractSet {
        public b() {
        }

        @Override
        public final boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final void clear() {
            throw new UnsupportedOperationException();
        }

        public abstract AbstractC2209po iterator();

        @Override
        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public final boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        public b(a aVar) {
            this();
        }
    }

    public static boolean m2913a(Set set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    public static int m2914b(Set set) {
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            Object next = it.next();
            i = ~(~(i + (next != null ? next.hashCode() : 0)));
        }
        return i;
    }

    public static b m2915c(Set set, Set set2) {
        AbstractC1131Yi.m4974j(set, "set1");
        AbstractC1131Yi.m4974j(set2, "set2");
        return new a(set, set2);
    }
}
