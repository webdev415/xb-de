package p000;

public final class RunnableC1310bD implements Runnable {

    public final C1162ZC f3857l;

    public final C1162ZC f3858m;

    public final long f3859n;

    public final boolean f3860o;

    public final C1070XC f3861p;

    public RunnableC1310bD(C1070XC c1070xc, C1162ZC c1162zc, C1162ZC c1162zc2, long j, boolean z) {
        this.f3857l = c1162zc;
        this.f3858m = c1162zc2;
        this.f3859n = j;
        this.f3860o = z;
        this.f3861p = c1070xc;
    }

    @Override
    public final void run() {
        this.f3861p.m4696N(this.f3857l, this.f3858m, this.f3859n, this.f3860o, null);
    }
}
