package p000;

import java.util.NoSuchElementException;

public abstract class AbstractC0092C extends AbstractC2255qo {

    public final int f229l;

    public int f230m;

    public AbstractC0092C(int i, int i2) {
        AbstractC1131Yi.m4975k(i2, i);
        this.f229l = i;
        this.f230m = i2;
    }

    public abstract Object mo363b(int i);

    @Override
    public final boolean hasNext() {
        return this.f230m < this.f229l;
    }

    @Override
    public final boolean hasPrevious() {
        return this.f230m > 0;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.f230m;
        this.f230m = i + 1;
        return mo363b(i);
    }

    @Override
    public final int nextIndex() {
        return this.f230m;
    }

    @Override
    public final Object previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.f230m - 1;
        this.f230m = i;
        return mo363b(i);
    }

    @Override
    public final int previousIndex() {
        return this.f230m - 1;
    }
}
