package p000;

public final class RunnableC0334HB implements Runnable {

    public final AbstractC1838hn f1032l;

    public final C0427JC f1033m;

    public RunnableC0334HB(C0427JC c0427jc, AbstractC1838hn abstractC1838hn) {
        this.f1033m = c0427jc;
        this.f1032l = abstractC1838hn;
    }

    @Override
    public final void run() {
        synchronized (this.f1033m.f1306b) {
            try {
                C0427JC c0427jc = this.f1033m;
                if (c0427jc.f1307c != null) {
                    c0427jc.f1307c.mo3822c((Exception) AbstractC1085Xi.m4801j(this.f1032l.mo4722d()));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
