package p000;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public abstract class AbstractC1675eB extends AbstractList implements InterfaceC1865iD {

    public boolean f5401l;

    public AbstractC1675eB(boolean z) {
        this.f5401l = z;
    }

    @Override
    public boolean addAll(int i, Collection collection) {
        m7403d();
        return super.addAll(i, collection);
    }

    @Override
    public final void mo7401b() {
        if (this.f5401l) {
            this.f5401l = false;
        }
    }

    @Override
    public final boolean mo7402c() {
        return this.f5401l;
    }

    @Override
    public void clear() {
        m7403d();
        super.clear();
    }

    public final void m7403d() {
        if (!this.f5401l) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int size = size();
        int iHashCode = 1;
        for (int i = 0; i < size; i++) {
            iHashCode = (iHashCode * 31) + get(i).hashCode();
        }
        return iHashCode;
    }

    @Override
    public abstract Object remove(int i);

    @Override
    public boolean remove(Object obj) {
        m7403d();
        int iIndexOf = indexOf(obj);
        if (iIndexOf == -1) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override
    public boolean removeAll(Collection collection) {
        m7403d();
        return super.removeAll(collection);
    }

    @Override
    public boolean retainAll(Collection collection) {
        m7403d();
        return super.retainAll(collection);
    }

    @Override
    public boolean addAll(Collection collection) {
        m7403d();
        return super.addAll(collection);
    }
}
