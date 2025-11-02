package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0628Nk extends AbstractC2408u2 {
    public AbstractC0628Nk(InterfaceC2458v6 interfaceC2458v6) {
        super(interfaceC2458v6);
        if (interfaceC2458v6 != null && interfaceC2458v6.mo197f() != C0608N9.f1911l) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext".toString());
        }
    }

    @Override
    public InterfaceC0191E6 mo197f() {
        return C0608N9.f1911l;
    }
}
