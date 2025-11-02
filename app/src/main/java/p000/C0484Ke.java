package p000;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* loaded from: classes.dex */
public final class C0484Ke extends AbstractC1173Ze {

    public static final AtomicIntegerFieldUpdater f1577q = AtomicIntegerFieldUpdater.newUpdater(C0484Ke.class, "_invoked");
    private volatile int _invoked;

    public final InterfaceC0986Vb f1578p;

    public C0484Ke(InterfaceC0986Vb interfaceC0986Vb) {
        this.f1578p = interfaceC0986Vb;
    }

    @Override
    public /* bridge */ Object mo15n(Object obj) {
        mo16w((Throwable) obj);
        return C2116no.f6480a;
    }

    @Override
    public void mo16w(Throwable th) {
        if (f1577q.compareAndSet(this, 0, 1)) {
            this.f1578p.mo15n(th);
        }
    }
}
