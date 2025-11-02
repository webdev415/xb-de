package p000;

/* loaded from: classes.dex */
public final class RunnableC2004lD implements Runnable {

    public final C1162ZC f6078l;

    public final long f6079m;

    public final C1070XC f6080n;

    public RunnableC2004lD(C1070XC c1070xc, C1162ZC c1162zc, long j) {
        this.f6078l = c1162zc;
        this.f6079m = j;
        this.f6080n = c1070xc;
    }

    @Override
    public final void run() {
        this.f6080n.m4697O(this.f6078l, false, this.f6079m);
        C1070XC c1070xc = this.f6080n;
        c1070xc.f3201e = null;
        c1070xc.mo3788t().m8867Q(null);
    }
}
