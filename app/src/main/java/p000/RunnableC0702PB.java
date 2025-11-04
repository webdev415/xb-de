package p000;

public final class RunnableC0702PB implements Runnable {

    public final long f2096l;

    public final C1207aB f2097m;

    public RunnableC0702PB(C1207aB c1207aB, long j) {
        this.f2096l = j;
        this.f2097m = c1207aB;
    }

    @Override
    public final void run() {
        this.f2097m.mo351i().f5562m.m9086b(this.f2096l);
        this.f2097m.mo349g().m9617F().m10617b("Session timeout duration set", Long.valueOf(this.f2096l));
    }
}
