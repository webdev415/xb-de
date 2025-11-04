package p000;

import android.util.SparseArray;

public final class C0150DB implements InterfaceC2381tc {

    public final C1913jF f379a;

    public final C1207aB f380b;

    public C0150DB(C1207aB c1207aB, C1913jF c1913jF) {
        this.f379a = c1913jF;
        this.f380b = c1207aB;
    }

    @Override
    public final void mo630a(Object obj) {
        this.f380b.mo356n();
        if (!this.f380b.mo347e().m10818t(AbstractC0818Rr.f2456N0)) {
            this.f380b.f3508i = false;
            this.f380b.m5131H0();
            this.f380b.mo349g().m9617F().m10617b("registerTriggerAsync ran. uri", this.f379a.f5937l);
        } else {
            m632c();
            this.f380b.f3508i = false;
            this.f380b.f3509j = 1;
            this.f380b.mo349g().m9617F().m10617b("Successfully registered trigger URI", this.f379a.f5937l);
            this.f380b.m5131H0();
        }
    }

    @Override
    public final void mo631b(Throwable th) {
        this.f380b.mo356n();
        this.f380b.f3508i = false;
        if (!this.f380b.mo347e().m10818t(AbstractC0818Rr.f2456N0)) {
            this.f380b.m5131H0();
            this.f380b.mo349g().m9618G().m10617b("registerTriggerAsync failed with throwable", th);
            return;
        }
        int iM5110E = (this.f380b.mo347e().m10818t(AbstractC0818Rr.f2452L0) ? C1207aB.m5110E(this.f380b, th) : 2) - 1;
        if (iM5110E == 0) {
            this.f380b.mo349g().m9623L().m10618c("registerTriggerAsync failed with retriable error. Will try later. App ID, throwable", C2356sx.m9613v(this.f380b.mo3784p().m7770F()), C2356sx.m9613v(th.toString()));
            this.f380b.f3509j = 1;
            this.f380b.m5122A0().add(this.f379a);
            return;
        }
        if (iM5110E != 1) {
            if (iM5110E != 2) {
                return;
            }
            this.f380b.mo349g().m9618G().m10618c("registerTriggerAsync failed. Dropping URI. App ID, Throwable", C2356sx.m9613v(this.f380b.mo3784p().m7770F()), th);
            m632c();
            this.f380b.f3509j = 1;
            this.f380b.m5131H0();
            return;
        }
        this.f380b.m5122A0().add(this.f379a);
        if (this.f380b.f3509j > 32) {
            this.f380b.f3509j = 1;
            this.f380b.mo349g().m9623L().m10618c("registerTriggerAsync failed. May try later. App ID, throwable", C2356sx.m9613v(this.f380b.mo3784p().m7770F()), C2356sx.m9613v(th.toString()));
            return;
        }
        this.f380b.mo349g().m9623L().m10619d("registerTriggerAsync failed. App ID, delay in seconds, throwable", C2356sx.m9613v(this.f380b.mo3784p().m7770F()), C2356sx.m9613v(String.valueOf(this.f380b.f3509j)), C2356sx.m9613v(th.toString()));
        C1207aB c1207aB = this.f380b;
        C1207aB.m5113T0(c1207aB, c1207aB.f3509j);
        this.f380b.f3509j <<= 1;
    }

    public final void m632c() {
        SparseArray sparseArrayM7665K = this.f380b.mo351i().m7665K();
        C1913jF c1913jF = this.f379a;
        sparseArrayM7665K.put(c1913jF.f5939n, Long.valueOf(c1913jF.f5938m));
        this.f380b.mo351i().m7677v(sparseArrayM7665K);
    }
}
