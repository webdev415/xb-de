package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class AbstractC2521we implements Iterator {
    public abstract int mo10565b();

    @Override
    public /* bridge */ Object next() {
        return Integer.valueOf(mo10565b());
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
