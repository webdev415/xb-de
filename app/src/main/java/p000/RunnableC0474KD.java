package p000;

public final class RunnableC0474KD implements Runnable {

    public final AbstractC1838hn f1554l;

    public final C0659OE f1555m;

    public RunnableC0474KD(C0659OE c0659oe, AbstractC1838hn abstractC1838hn) {
        this.f1555m = c0659oe;
        this.f1554l = abstractC1838hn;
    }

    @Override
    public final void run() {
        synchronized (this.f1555m.f2014b) {
            try {
                C0659OE c0659oe = this.f1555m;
                if (c0659oe.f2015c != null) {
                    c0659oe.f2015c.mo4160a(this.f1554l.mo4723e());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
