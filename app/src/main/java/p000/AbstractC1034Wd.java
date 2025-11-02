package p000;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;

public abstract class AbstractC1034Wd extends AbstractCollection implements Serializable {

    public static final Object[] f3062l = new Object[0];

    public static abstract class a {
        public static int m4498a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int iHighestOneBit = i + (i >> 1) + 1;
            if (iHighestOneBit < i2) {
                iHighestOneBit = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (iHighestOneBit < 0) {
                return Integer.MAX_VALUE;
            }
            return iHighestOneBit;
        }
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

    @Override
    public abstract boolean contains(Object obj);

    public abstract int mo4493d(Object[] objArr, int i);

    public Object[] mo4494f() {
        return null;
    }

    public int mo4495g() {
        throw new UnsupportedOperationException();
    }

    public int mo4496h() {
        throw new UnsupportedOperationException();
    }

    public abstract boolean mo4497i();

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

    @Override
    public final Object[] toArray() {
        return toArray(f3062l);
    }

    @Override
    public final Object[] toArray(Object[] objArr) {
        AbstractC1131Yi.m4973i(objArr);
        int size = size();
        if (objArr.length < size) {
            Object[] objArrMo4494f = mo4494f();
            if (objArrMo4494f != null) {
                return AbstractC0809Ri.m3823a(objArrMo4494f, mo4496h(), mo4495g(), objArr);
            }
            objArr = AbstractC0165Dh.m712d(objArr, size);
        } else if (objArr.length > size) {
            objArr[size] = null;
        }
        mo4493d(objArr, 0);
        return objArr;
    }
}
