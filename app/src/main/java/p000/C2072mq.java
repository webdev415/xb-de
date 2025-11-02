package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C2072mq implements Iterator {

    public final Iterator f6258l;

    public final Iterator f6259m;

    public C2072mq(C2257qq c2257qq, Iterator it, Iterator it2) {
        this.f6258l = it;
        this.f6259m = it2;
    }

    @Override
    public final boolean hasNext() {
        if (this.f6258l.hasNext()) {
            return true;
        }
        return this.f6259m.hasNext();
    }

    @Override
    public final Object next() {
        if (this.f6258l.hasNext()) {
            return new C1093Xq(((Integer) this.f6258l.next()).toString());
        }
        if (this.f6259m.hasNext()) {
            return new C1093Xq((String) this.f6259m.next());
        }
        throw new NoSuchElementException();
    }
}
