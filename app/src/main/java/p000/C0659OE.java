package p000;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class C0659OE implements InterfaceC2331sH {

    public final Executor f2013a;

    public final Object f2014b = new Object();

    public InterfaceC0900Th f2015c;

    public C0659OE(Executor executor, InterfaceC0900Th interfaceC0900Th) {
        this.f2013a = executor;
        this.f2015c = interfaceC0900Th;
    }

    @Override
    public final void mo1870a(AbstractC1838hn abstractC1838hn) {
        if (abstractC1838hn.mo4726h()) {
            synchronized (this.f2014b) {
                try {
                    if (this.f2015c == null) {
                        return;
                    }
                    this.f2013a.execute(new RunnableC0474KD(this, abstractC1838hn));
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }
}
