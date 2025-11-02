package p000;

public final class RunnableC1955kA implements Runnable {

    public final C0635Nr f5973l;

    public final String f5974m;

    public final BinderC0183Dz f5975n;

    public RunnableC1955kA(BinderC0183Dz binderC0183Dz, C0635Nr c0635Nr, String str) {
        this.f5973l = c0635Nr;
        this.f5974m = str;
        this.f5975n = binderC0183Dz;
    }

    @Override
    public final void run() {
        this.f5975n.f441c.m968z0();
        this.f5975n.f441c.m905B(this.f5973l, this.f5974m);
    }
}
