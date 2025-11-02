package p000;

import java.util.NoSuchElementException;

public final class C2140oB extends AbstractC2325sB {

    public int f6544l = 0;

    public final int f6545m;

    public final AbstractC2233qB f6546n;

    public C2140oB(AbstractC2233qB abstractC2233qB) {
        this.f6546n = abstractC2233qB;
        this.f6545m = abstractC2233qB.mo2843s();
    }

    @Override
    public final byte mo416a() {
        int i = this.f6544l;
        if (i >= this.f6545m) {
            throw new NoSuchElementException();
        }
        this.f6544l = i + 1;
        return this.f6546n.mo2842r(i);
    }

    @Override
    public final boolean hasNext() {
        return this.f6544l < this.f6545m;
    }
}
