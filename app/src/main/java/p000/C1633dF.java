package p000;

import android.os.Bundle;

public final class C1633dF {

    public long f5283a;

    public long f5284b;

    public final AbstractC1795gr f5285c;

    public final C0796RE f5286d;

    public C1633dF(C0796RE c0796re) {
        this.f5286d = c0796re;
        this.f5285c = new C1312bF(this, c0796re.f8058a);
        long jMo2817c = c0796re.mo345b().mo2817c();
        this.f5283a = jMo2817c;
        this.f5284b = jMo2817c;
    }

    public static void m7310c(C1633dF c1633dF) {
        c1633dF.f5286d.mo356n();
        c1633dF.m7313d(false, false, c1633dF.f5286d.mo345b().mo2817c());
        c1633dF.f5286d.mo3783o().m4848v(c1633dF.f5286d.mo345b().mo2817c());
    }

    public final long m7311a(long j) {
        long j2 = j - this.f5284b;
        this.f5284b = j;
        return j2;
    }

    public final void m7312b() {
        this.f5285c.m7756a();
        this.f5283a = this.f5286d.mo347e().m10818t(AbstractC0818Rr.f2501g1) ? this.f5286d.mo345b().mo2817c() : 0L;
        this.f5284b = this.f5283a;
    }

    public final boolean m7313d(boolean z, boolean z2, long j) {
        this.f5286d.mo356n();
        this.f5286d.m2546v();
        if (this.f5286d.f8058a.m9242p()) {
            this.f5286d.mo351i().f5567r.m9086b(this.f5286d.mo345b().mo2815a());
        }
        long jM7311a = j - this.f5283a;
        if (!z && jM7311a < 1000) {
            this.f5286d.mo349g().m9622K().m10617b("Screen exposed for less than 1000 ms. Event not sent. time", Long.valueOf(jM7311a));
            return false;
        }
        if (!z2) {
            jM7311a = m7311a(j);
        }
        this.f5286d.mo349g().m9622K().m10617b("Recording user engagement, ms", Long.valueOf(jM7311a));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", jM7311a);
        C2514wG.m10459Y(this.f5286d.mo3787s().m4690D(!this.f5286d.mo347e().m10811Z()), bundle, true);
        if (!z2) {
            this.f5286d.mo3786r().m5166a1("auto", "_e", bundle);
        }
        this.f5283a = j;
        this.f5285c.m7756a();
        this.f5285c.m7757b(((Long) AbstractC0818Rr.f2491d0.m4296a(null)).longValue());
        return true;
    }

    public final void m7314e(long j) {
        this.f5285c.m7756a();
    }

    public final void m7315f(long j) {
        this.f5286d.mo356n();
        this.f5285c.m7756a();
        this.f5283a = j;
        this.f5284b = j;
    }
}
