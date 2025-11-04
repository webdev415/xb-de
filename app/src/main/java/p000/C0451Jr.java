package p000;

import java.util.Iterator;

public final class C0451Jr implements Iterator {

    public Iterator f1462l;

    public final C0175Dr f1463m;

    public C0451Jr(C0175Dr c0175Dr) {
        this.f1463m = c0175Dr;
        this.f1462l = c0175Dr.f435l.keySet().iterator();
    }

    @Override
    public final boolean hasNext() {
        return this.f1462l.hasNext();
    }

    @Override
    public final Object next() {
        return (String) this.f1462l.next();
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException("Remove not supported");
    }
}
