package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C2235qD implements Iterator {

    public Iterator f6693l;

    public C2235qD(Iterator it) {
        this.f6693l = it;
    }

    @Override
    public final boolean hasNext() {
        return this.f6693l.hasNext();
    }

    @Override
    public final Object next() {
        Map.Entry entry = (Map.Entry) this.f6693l.next();
        entry.getValue();
        return entry;
    }

    @Override
    public final void remove() {
        this.f6693l.remove();
    }
}
