package p000;

/* loaded from: classes.dex */
public final class RunnableC1701er implements Runnable {

    public final InterfaceC0241FA f5468l;

    public final AbstractC1795gr f5469m;

    public RunnableC1701er(AbstractC1795gr abstractC1795gr, InterfaceC0241FA interfaceC0241FA) {
        this.f5468l = interfaceC0241FA;
        this.f5469m = abstractC1795gr;
    }

    @Override
    public final void run() {
        this.f5468l.mo346d();
        if (C1747fq.m7654a()) {
            this.f5468l.mo354l().m7374C(this);
            return;
        }
        boolean zM7758e = this.f5469m.m7758e();
        this.f5469m.f5649c = 0L;
        if (zM7758e) {
            this.f5469m.mo222d();
        }
    }
}
