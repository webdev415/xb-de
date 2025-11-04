package p000;

import java.util.Iterator;
import java.util.Map;

public final class C2237qF implements Iterator {

    public int f6712l;

    public boolean f6713m;

    public Iterator f6714n;

    public final AbstractC1118YE f6715o;

    public C2237qF(AbstractC1118YE abstractC1118YE) {
        this.f6715o = abstractC1118YE;
        this.f6712l = -1;
    }

    public final Iterator m9148b() {
        if (this.f6714n == null) {
            this.f6714n = this.f6715o.f3323n.entrySet().iterator();
        }
        return this.f6714n;
    }

    @Override
    public final boolean hasNext() {
        return this.f6712l + 1 < this.f6715o.f3322m || (!this.f6715o.f3323n.isEmpty() && m9148b().hasNext());
    }

    @Override
    public final Object next() {
        this.f6713m = true;
        int i = this.f6712l + 1;
        this.f6712l = i;
        return i < this.f6715o.f3322m ? (C1960kF) this.f6715o.f3321l[this.f6712l] : (Map.Entry) m9148b().next();
    }

    @Override
    public final void remove() {
        if (!this.f6713m) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.f6713m = false;
        this.f6715o.m4919q();
        if (this.f6712l >= this.f6715o.f3322m) {
            m9148b().remove();
            return;
        }
        AbstractC1118YE abstractC1118YE = this.f6715o;
        int i = this.f6712l;
        this.f6712l = i - 1;
        abstractC1118YE.m4914h(i);
    }
}
