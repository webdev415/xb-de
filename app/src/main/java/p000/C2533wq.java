package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C2533wq implements Iterator {

    public int f7905l = 0;

    public final C2257qq f7906m;

    public C2533wq(C2257qq c2257qq) {
        this.f7906m = c2257qq;
    }

    @Override
    public final boolean hasNext() {
        return this.f7905l < this.f7906m.m9195u();
    }

    @Override
    public final Object next() {
        if (this.f7905l < this.f7906m.m9195u()) {
            C2257qq c2257qq = this.f7906m;
            int i = this.f7905l;
            this.f7905l = i + 1;
            return c2257qq.m9192r(i);
        }
        throw new NoSuchElementException("Out of bounds index: " + this.f7905l);
    }
}
