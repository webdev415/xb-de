package p000;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

public abstract class AbstractC2108ng {

    public b f6446a;

    public c f6447b;

    public e f6448c;

    public final class a implements Iterator {

        public final int f6449l;

        public int f6450m;

        public int f6451n;

        public boolean f6452o = false;

        public a(int i) {
            this.f6449l = i;
            this.f6450m = AbstractC2108ng.this.mo8773d();
        }

        @Override
        public boolean hasNext() {
            return this.f6451n < this.f6450m;
        }

        @Override
        public Object next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            Object objMo8771b = AbstractC2108ng.this.mo8771b(this.f6451n, this.f6449l);
            this.f6451n++;
            this.f6452o = true;
            return objMo8771b;
        }

        @Override
        public void remove() {
            if (!this.f6452o) {
                throw new IllegalStateException();
            }
            int i = this.f6451n - 1;
            this.f6451n = i;
            this.f6450m--;
            this.f6452o = false;
            AbstractC2108ng.this.mo8777h(i);
        }
    }

    public final class b implements Set {
        public b() {
        }

        @Override
        public boolean addAll(Collection collection) {
            int iMo8773d = AbstractC2108ng.this.mo8773d();
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                AbstractC2108ng.this.mo8776g(entry.getKey(), entry.getValue());
            }
            return iMo8773d != AbstractC2108ng.this.mo8773d();
        }

        @Override
        public void clear() {
            AbstractC2108ng.this.mo8770a();
        }

        @Override
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int iMo8774e = AbstractC2108ng.this.mo8774e(entry.getKey());
            if (iMo8774e < 0) {
                return false;
            }
            return AbstractC2182p6.m9033b(AbstractC2108ng.this.mo8771b(iMo8774e, 1), entry.getValue());
        }

        @Override
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean add(Map.Entry entry) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean equals(Object obj) {
            return AbstractC2108ng.m8767k(this, obj);
        }

        @Override
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo8773d = AbstractC2108ng.this.mo8773d() - 1; iMo8773d >= 0; iMo8773d--) {
                Object objMo8771b = AbstractC2108ng.this.mo8771b(iMo8773d, 0);
                Object objMo8771b2 = AbstractC2108ng.this.mo8771b(iMo8773d, 1);
                iHashCode += (objMo8771b == null ? 0 : objMo8771b.hashCode()) ^ (objMo8771b2 == null ? 0 : objMo8771b2.hashCode());
            }
            return iHashCode;
        }

        @Override
        public boolean isEmpty() {
            return AbstractC2108ng.this.mo8773d() == 0;
        }

        @Override
        public Iterator iterator() {
            return AbstractC2108ng.this.new d();
        }

        @Override
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public int size() {
            return AbstractC2108ng.this.mo8773d();
        }

        @Override
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override
        public Object[] toArray(Object[] objArr) {
            throw new UnsupportedOperationException();
        }
    }

    public final class c implements Set {
        public c() {
        }

        @Override
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            AbstractC2108ng.this.mo8770a();
        }

        @Override
        public boolean contains(Object obj) {
            return AbstractC2108ng.this.mo8774e(obj) >= 0;
        }

        @Override
        public boolean containsAll(Collection collection) {
            return AbstractC2108ng.m8766j(AbstractC2108ng.this.mo8772c(), collection);
        }

        @Override
        public boolean equals(Object obj) {
            return AbstractC2108ng.m8767k(this, obj);
        }

        @Override
        public int hashCode() {
            int iHashCode = 0;
            for (int iMo8773d = AbstractC2108ng.this.mo8773d() - 1; iMo8773d >= 0; iMo8773d--) {
                Object objMo8771b = AbstractC2108ng.this.mo8771b(iMo8773d, 0);
                iHashCode += objMo8771b == null ? 0 : objMo8771b.hashCode();
            }
            return iHashCode;
        }

        @Override
        public boolean isEmpty() {
            return AbstractC2108ng.this.mo8773d() == 0;
        }

        @Override
        public Iterator iterator() {
            return AbstractC2108ng.this.new a(0);
        }

        @Override
        public boolean remove(Object obj) {
            int iMo8774e = AbstractC2108ng.this.mo8774e(obj);
            if (iMo8774e < 0) {
                return false;
            }
            AbstractC2108ng.this.mo8777h(iMo8774e);
            return true;
        }

        @Override
        public boolean removeAll(Collection collection) {
            return AbstractC2108ng.m8768o(AbstractC2108ng.this.mo8772c(), collection);
        }

        @Override
        public boolean retainAll(Collection collection) {
            return AbstractC2108ng.m8769p(AbstractC2108ng.this.mo8772c(), collection);
        }

        @Override
        public int size() {
            return AbstractC2108ng.this.mo8773d();
        }

        @Override
        public Object[] toArray() {
            return AbstractC2108ng.this.m8782q(0);
        }

        @Override
        public Object[] toArray(Object[] objArr) {
            return AbstractC2108ng.this.m8783r(objArr, 0);
        }
    }

    public final class d implements Iterator, Map.Entry {

        public int f6456l;

        public boolean f6458n = false;

        public int f6457m = -1;

        public d() {
            this.f6456l = AbstractC2108ng.this.mo8773d() - 1;
        }

        @Override
        public Map.Entry next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f6457m++;
            this.f6458n = true;
            return this;
        }

        @Override
        public boolean equals(Object obj) {
            if (!this.f6458n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return AbstractC2182p6.m9033b(entry.getKey(), AbstractC2108ng.this.mo8771b(this.f6457m, 0)) && AbstractC2182p6.m9033b(entry.getValue(), AbstractC2108ng.this.mo8771b(this.f6457m, 1));
        }

        @Override
        public Object getKey() {
            if (this.f6458n) {
                return AbstractC2108ng.this.mo8771b(this.f6457m, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public Object getValue() {
            if (this.f6458n) {
                return AbstractC2108ng.this.mo8771b(this.f6457m, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override
        public boolean hasNext() {
            return this.f6457m < this.f6456l;
        }

        @Override
        public int hashCode() {
            if (!this.f6458n) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object objMo8771b = AbstractC2108ng.this.mo8771b(this.f6457m, 0);
            Object objMo8771b2 = AbstractC2108ng.this.mo8771b(this.f6457m, 1);
            return (objMo8771b == null ? 0 : objMo8771b.hashCode()) ^ (objMo8771b2 != null ? objMo8771b2.hashCode() : 0);
        }

        @Override
        public void remove() {
            if (!this.f6458n) {
                throw new IllegalStateException();
            }
            AbstractC2108ng.this.mo8777h(this.f6457m);
            this.f6457m--;
            this.f6456l--;
            this.f6458n = false;
        }

        @Override
        public Object setValue(Object obj) {
            if (this.f6458n) {
                return AbstractC2108ng.this.mo8778i(this.f6457m, obj);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    public final class e implements Collection {
        public e() {
        }

        @Override
        public boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void clear() {
            AbstractC2108ng.this.mo8770a();
        }

        @Override
        public boolean contains(Object obj) {
            return AbstractC2108ng.this.mo8775f(obj) >= 0;
        }

        @Override
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean isEmpty() {
            return AbstractC2108ng.this.mo8773d() == 0;
        }

        @Override
        public Iterator iterator() {
            return AbstractC2108ng.this.new a(1);
        }

        @Override
        public boolean remove(Object obj) {
            int iMo8775f = AbstractC2108ng.this.mo8775f(obj);
            if (iMo8775f < 0) {
                return false;
            }
            AbstractC2108ng.this.mo8777h(iMo8775f);
            return true;
        }

        @Override
        public boolean removeAll(Collection collection) {
            int iMo8773d = AbstractC2108ng.this.mo8773d();
            int i = 0;
            boolean z = false;
            while (i < iMo8773d) {
                if (collection.contains(AbstractC2108ng.this.mo8771b(i, 1))) {
                    AbstractC2108ng.this.mo8777h(i);
                    i--;
                    iMo8773d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override
        public boolean retainAll(Collection collection) {
            int iMo8773d = AbstractC2108ng.this.mo8773d();
            int i = 0;
            boolean z = false;
            while (i < iMo8773d) {
                if (!collection.contains(AbstractC2108ng.this.mo8771b(i, 1))) {
                    AbstractC2108ng.this.mo8777h(i);
                    i--;
                    iMo8773d--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        @Override
        public int size() {
            return AbstractC2108ng.this.mo8773d();
        }

        @Override
        public Object[] toArray() {
            return AbstractC2108ng.this.m8782q(1);
        }

        @Override
        public Object[] toArray(Object[] objArr) {
            return AbstractC2108ng.this.m8783r(objArr, 1);
        }
    }

    public static boolean m8766j(Map map, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    public static boolean m8767k(Set set, Object obj) {
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

    public static boolean m8768o(Map map, Collection collection) {
        int size = map.size();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    public static boolean m8769p(Map map, Collection collection) {
        int size = map.size();
        Iterator it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    public abstract void mo8770a();

    public abstract Object mo8771b(int i, int i2);

    public abstract Map mo8772c();

    public abstract int mo8773d();

    public abstract int mo8774e(Object obj);

    public abstract int mo8775f(Object obj);

    public abstract void mo8776g(Object obj, Object obj2);

    public abstract void mo8777h(int i);

    public abstract Object mo8778i(int i, Object obj);

    public Set m8779l() {
        if (this.f6446a == null) {
            this.f6446a = new b();
        }
        return this.f6446a;
    }

    public Set m8780m() {
        if (this.f6447b == null) {
            this.f6447b = new c();
        }
        return this.f6447b;
    }

    public Collection m8781n() {
        if (this.f6448c == null) {
            this.f6448c = new e();
        }
        return this.f6448c;
    }

    public Object[] m8782q(int i) {
        int iMo8773d = mo8773d();
        Object[] objArr = new Object[iMo8773d];
        for (int i2 = 0; i2 < iMo8773d; i2++) {
            objArr[i2] = mo8771b(i2, i);
        }
        return objArr;
    }

    public Object[] m8783r(Object[] objArr, int i) {
        int iMo8773d = mo8773d();
        if (objArr.length < iMo8773d) {
            objArr = (Object[]) Array.newInstance(objArr.getClass().getComponentType(), iMo8773d);
        }
        for (int i2 = 0; i2 < iMo8773d; i2++) {
            objArr[i2] = mo8771b(i2, i);
        }
        if (objArr.length > iMo8773d) {
            objArr[iMo8773d] = null;
        }
        return objArr;
    }
}
