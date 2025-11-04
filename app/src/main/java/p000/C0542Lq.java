package p000;

import java.util.Iterator;

public final class C0542Lq implements Iterator {

    public final Iterator f1735l;

    public C0542Lq(Iterator it) {
        this.f1735l = it;
    }

    @Override
    public final boolean hasNext() {
        return this.f1735l.hasNext();
    }

    @Override
    public final Object next() {
        return new C1093Xq((String) this.f1735l.next());
    }
}
