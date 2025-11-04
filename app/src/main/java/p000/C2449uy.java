package p000;

import java.util.concurrent.Executor;

public final class C2449uy implements InterfaceC2331sH {

    public final Executor f7608a;

    public final Object f7609b = new Object();

    public InterfaceC0763Qh f7610c;

    public C2449uy(Executor executor, InterfaceC0763Qh interfaceC0763Qh) {
        this.f7608a = executor;
        this.f7610c = interfaceC0763Qh;
    }

    @Override
    public final void mo1870a(AbstractC1838hn abstractC1838hn) {
        if (abstractC1838hn.mo4724f()) {
            synchronized (this.f7609b) {
                try {
                    if (this.f7610c == null) {
                        return;
                    }
                    this.f7608a.execute(new RunnableC1293ax(this));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
