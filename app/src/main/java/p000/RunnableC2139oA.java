package p000;

/* loaded from: classes.dex */
public final class RunnableC2139oA implements Runnable {

    public final C2053mG f6541l;

    public final C0569MG f6542m;

    public final BinderC0183Dz f6543n;

    public RunnableC2139oA(BinderC0183Dz binderC0183Dz, C2053mG c2053mG, C0569MG c0569mg) {
        this.f6541l = c2053mG;
        this.f6542m = c0569mg;
        this.f6543n = binderC0183Dz;
    }

    @Override
    public final void run() {
        this.f6543n.f441c.m968z0();
        if (this.f6541l.m8448d() == null) {
            this.f6543n.f441c.m962w(this.f6541l.f6158m, this.f6542m);
        } else {
            this.f6543n.f441c.m916I(this.f6541l, this.f6542m);
        }
    }
}
