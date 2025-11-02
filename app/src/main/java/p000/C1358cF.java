package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1358cF implements Iterator {

    public int f3945l;

    public Iterator f3946m;

    public final AbstractC1118YE f3947n;

    public C1358cF(AbstractC1118YE abstractC1118YE) {
        this.f3947n = abstractC1118YE;
        this.f3945l = abstractC1118YE.f3322m;
    }

    public final Iterator m5852b() {
        if (this.f3946m == null) {
            this.f3946m = this.f3947n.f3326q.entrySet().iterator();
        }
        return this.f3946m;
    }

    @Override
    public final boolean hasNext() {
        int i = this.f3945l;
        return (i > 0 && i <= this.f3947n.f3322m) || m5852b().hasNext();
    }

    @Override
    public final Object next() {
        if (m5852b().hasNext()) {
            return (Map.Entry) m5852b().next();
        }
        Object[] objArr = this.f3947n.f3321l;
        int i = this.f3945l - 1;
        this.f3945l = i;
        return (C1960kF) objArr[i];
    }

    @Override
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
