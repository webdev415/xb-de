package p000;

import java.util.Iterator;

public final class C2046m9 implements InterfaceC0031Al, InterfaceC2092n9 {

    public final InterfaceC0031Al f6141a;

    public final int f6142b;

    public static final class a implements Iterator {

        public final Iterator f6143l;

        public int f6144m;

        public a(C2046m9 c2046m9) {
            this.f6143l = c2046m9.f6141a.iterator();
            this.f6144m = c2046m9.f6142b;
        }

        public final void m8447b() {
            while (this.f6144m > 0 && this.f6143l.hasNext()) {
                this.f6143l.next();
                this.f6144m--;
            }
        }

        @Override
        public boolean hasNext() {
            m8447b();
            return this.f6143l.hasNext();
        }

        @Override
        public Object next() {
            m8447b();
            return this.f6143l.next();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2046m9(InterfaceC0031Al interfaceC0031Al, int i) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "sequence");
        this.f6141a = interfaceC0031Al;
        this.f6142b = i;
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("count must be non-negative, but was " + i + '.').toString());
    }

    @Override
    public InterfaceC0031Al mo8446a(int i) {
        int i2 = this.f6142b + i;
        return i2 < 0 ? new C2046m9(this, i) : new C2046m9(this.f6141a, i2);
    }

    @Override
    public Iterator iterator() {
        return new a(this);
    }
}
