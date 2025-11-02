package p000;

import java.util.Iterator;

/* loaded from: classes.dex */
public final class C0677On implements InterfaceC0031Al {

    public final InterfaceC0031Al f2056a;

    public final InterfaceC0986Vb f2057b;

    public static final class a implements Iterator {

        public final Iterator f2058l;

        public a() {
            this.f2058l = C0677On.this.f2056a.iterator();
        }

        @Override
        public boolean hasNext() {
            return this.f2058l.hasNext();
        }

        @Override
        public Object next() {
            return C0677On.this.f2057b.mo15n(this.f2058l.next());
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C0677On(InterfaceC0031Al interfaceC0031Al, InterfaceC0986Vb interfaceC0986Vb) {
        AbstractC0116Ce.m476e(interfaceC0031Al, "sequence");
        AbstractC0116Ce.m476e(interfaceC0986Vb, "transformer");
        this.f2056a = interfaceC0031Al;
        this.f2057b = interfaceC0986Vb;
    }

    @Override
    public Iterator iterator() {
        return new a();
    }
}
