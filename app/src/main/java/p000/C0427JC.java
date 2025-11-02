package p000;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class C0427JC implements InterfaceC2331sH {

    public final Executor f1305a;

    public final Object f1306b = new Object();

    public InterfaceC0808Rh f1307c;

    public C0427JC(Executor executor, InterfaceC0808Rh interfaceC0808Rh) {
        this.f1305a = executor;
        this.f1307c = interfaceC0808Rh;
    }

    @Override
    public final void mo1870a(AbstractC1838hn abstractC1838hn) {
        if (abstractC1838hn.mo4726h() || abstractC1838hn.mo4724f()) {
            return;
        }
        synchronized (this.f1306b) {
            try {
                if (this.f1307c == null) {
                    return;
                }
                this.f1305a.execute(new RunnableC0334HB(this, abstractC1838hn));
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
