package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class C1654dr implements Iterator {

    public int f5343l = 0;

    public final C1093Xq f5344m;

    public C1654dr(C1093Xq c1093Xq) {
        this.f5344m = c1093Xq;
    }

    @Override
    public final boolean hasNext() {
        return this.f5343l < this.f5344m.f3292l.length();
    }

    @Override
    public final Object next() {
        if (this.f5343l >= this.f5344m.f3292l.length()) {
            throw new NoSuchElementException();
        }
        int i = this.f5343l;
        this.f5343l = i + 1;
        return new C1093Xq(String.valueOf(i));
    }
}
