package p000;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class C1334br implements Iterator {

    public int f3888l = 0;

    public final C1093Xq f3889m;

    public C1334br(C1093Xq c1093Xq) {
        this.f3889m = c1093Xq;
    }

    @Override
    public final boolean hasNext() {
        return this.f3888l < this.f3889m.f3292l.length();
    }

    @Override
    public final Object next() {
        if (this.f3888l >= this.f3889m.f3292l.length()) {
            throw new NoSuchElementException();
        }
        String str = this.f3889m.f3292l;
        int i = this.f3888l;
        this.f3888l = i + 1;
        return new C1093Xq(String.valueOf(str.charAt(i)));
    }
}
