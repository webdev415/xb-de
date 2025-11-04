package p000;

public final class RunnableC1164ZE implements Runnable {

    public long f3428l;

    public long f3429m;

    public final C0888TE f3430n;

    public RunnableC1164ZE(C0888TE c0888te, long j, long j2) {
        this.f3430n = c0888te;
        this.f3428l = j;
        this.f3429m = j2;
    }

    @Override
    public final void run() {
        this.f3430n.f2738b.mo354l().m7374C(new Runnable() {
            @Override
            public final void run() {
                RunnableC1164ZE runnableC1164ZE = this.f3211l;
                C0888TE c0888te = runnableC1164ZE.f3430n;
                long j = runnableC1164ZE.f3428l;
                long j2 = runnableC1164ZE.f3429m;
                c0888te.f2738b.mo356n();
                c0888te.f2738b.mo349g().m9617F().m10616a("Application going to the background");
                c0888te.f2738b.mo351i().f5570u.m8427a(true);
                c0888te.f2738b.m3779D(true);
                if (!c0888te.f2738b.mo347e().m10811Z()) {
                    if (c0888te.f2738b.mo347e().m10818t(AbstractC0818Rr.f2460P0)) {
                        c0888te.f2738b.m3780E(false, false, j2);
                        c0888te.f2738b.f2364f.m7314e(j2);
                    } else {
                        c0888te.f2738b.f2364f.m7314e(j2);
                        c0888te.f2738b.m3780E(false, false, j2);
                    }
                }
                c0888te.f2738b.mo349g().m9621J().m10617b("Application backgrounded at: timestamp_millis", Long.valueOf(j));
                if (c0888te.f2738b.mo347e().m10818t(AbstractC0818Rr.f2507i1)) {
                    c0888te.f2738b.mo3786r().m5123B0();
                }
            }
        });
    }
}
