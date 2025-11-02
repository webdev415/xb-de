package p000;

/* loaded from: classes.dex */
public final class C1839ho extends AbstractC0283G6 {

    public static final C1839ho f5770n = new C1839ho();

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        AbstractC2524wh.m10586a(interfaceC0191E6.mo855b(AbstractC0265Fp.f682m));
        throw new UnsupportedOperationException("Dispatchers.Unconfined.dispatch function can only be used by the yield function. If you wrap Unconfined dispatcher in your code, make sure you properly delegate isDispatchNeeded and dispatch calls.");
    }

    @Override
    public boolean mo1352U(InterfaceC0191E6 interfaceC0191E6) {
        return false;
    }

    @Override
    public String toString() {
        return "Dispatchers.Unconfined";
    }
}
