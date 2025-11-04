package p000;

import p000.InterfaceC0191E6;
import p000.InterfaceC2550x6;

public abstract class AbstractC0283G6 extends AbstractC2635z implements InterfaceC2550x6 {

    public static final a f856m = new a(null);

    public static final class a extends AbstractC0000A {

        public static final class C2688a extends AbstractC0025Af implements InterfaceC0986Vb {

            public static final C2688a f857m = new C2688a();

            public C2688a() {
                super(1);
            }

            @Override
            public final AbstractC0283G6 mo15n(InterfaceC0191E6.b bVar) {
                if (bVar instanceof AbstractC0283G6) {
                    return (AbstractC0283G6) bVar;
                }
                return null;
            }
        }

        public a() {
            super(InterfaceC2550x6.f7940a, C2688a.f857m);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public AbstractC0283G6() {
        super(InterfaceC2550x6.f7940a);
    }

    @Override
    public InterfaceC0191E6 mo852B(c cVar) {
        return InterfaceC2550x6.a.m10629b(this, cVar);
    }

    @Override
    public final void mo1349J(InterfaceC2458v6 interfaceC2458v6) {
        AbstractC0116Ce.m474c(interfaceC2458v6, "null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<*>");
        ((C0928U8) interfaceC2458v6).m4198n();
    }

    @Override
    public final InterfaceC2458v6 mo1350S(InterfaceC2458v6 interfaceC2458v6) {
        return new C0928U8(this, interfaceC2458v6);
    }

    public abstract void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable);

    public boolean mo1352U(InterfaceC0191E6 interfaceC0191E6) {
        return true;
    }

    public AbstractC0283G6 mo1353V(int i) {
        AbstractC0806Rf.m3821a(i);
        return new C0761Qf(this, i);
    }

    @Override
    public InterfaceC0191E6.b mo855b(c cVar) {
        return InterfaceC2550x6.a.m10628a(this, cVar);
    }

    public String toString() {
        return AbstractC2505w7.m10433a(this) + '@' + AbstractC2505w7.m10434b(this);
    }
}
