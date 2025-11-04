package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class C2361t1 implements Iterator {

    public final Object[] f7136l;

    public int f7137m;

    public C2361t1(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "array");
        this.f7136l = objArr;
    }

    @Override
    public boolean hasNext() {
        return this.f7137m < this.f7136l.length;
    }

    @Override
    public Object next() {
        try {
            Object[] objArr = this.f7136l;
            int i = this.f7137m;
            this.f7137m = i + 1;
            return objArr[i];
        } catch (ArrayIndexOutOfBoundsException e) {
            this.f7137m--;
            throw new NoSuchElementException(e.getMessage());
        }
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
