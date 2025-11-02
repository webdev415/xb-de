package p000;

import android.content.Context;
import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1092Xp extends AbstractC1191Zw {

    public final Map f3289b;

    public final Map f3290c;

    public long f3291d;

    public C1092Xp(C2266qz c2266qz) {
        super(c2266qz);
        this.f3290c = new C2453v1();
        this.f3289b = new C2453v1();
    }

    public static void m4843A(C1092Xp c1092Xp, String str, long j) {
        c1092Xp.mo356n();
        AbstractC1085Xi.m4795d(str);
        if (c1092Xp.f3290c.isEmpty()) {
            c1092Xp.f3291d = j;
        }
        Integer num = (Integer) c1092Xp.f3290c.get(str);
        if (num != null) {
            c1092Xp.f3290c.put(str, Integer.valueOf(num.intValue() + 1));
        } else if (c1092Xp.f3290c.size() >= 100) {
            c1092Xp.mo349g().m9623L().m10616a("Too many ads visible");
        } else {
            c1092Xp.f3290c.put(str, 1);
            c1092Xp.f3289b.put(str, Long.valueOf(j));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m4844B(long j) {
        Iterator it = this.f3289b.keySet().iterator();
        while (it.hasNext()) {
            this.f3289b.put((String) it.next(), Long.valueOf(j));
        }
        if (this.f3289b.isEmpty()) {
            return;
        }
        this.f3291d = j;
    }

    public static void m4845D(C1092Xp c1092Xp, String str, long j) {
        c1092Xp.mo356n();
        AbstractC1085Xi.m4795d(str);
        Integer num = (Integer) c1092Xp.f3290c.get(str);
        if (num == null) {
            c1092Xp.mo349g().m9618G().m10617b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        C1162ZC c1162zcM4690D = c1092Xp.mo3787s().m4690D(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            c1092Xp.f3290c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        c1092Xp.f3290c.remove(str);
        Long l = (Long) c1092Xp.f3289b.get(str);
        if (l == null) {
            c1092Xp.mo349g().m9618G().m10616a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            c1092Xp.f3289b.remove(str);
            c1092Xp.m4851y(str, jLongValue, c1162zcM4690D);
        }
        if (c1092Xp.f3290c.isEmpty()) {
            long j2 = c1092Xp.f3291d;
            if (j2 == 0) {
                c1092Xp.mo349g().m9618G().m10616a("First ad exposure time was never set");
            } else {
                c1092Xp.m4849w(j - j2, c1162zcM4690D);
                c1092Xp.f3291d = 0L;
            }
        }
    }

    public final void m4847C(String str, long j) {
        if (str == null || str.length() == 0) {
            mo349g().m9618G().m10616a("Ad unit id must be a non-empty string");
        } else {
            mo354l().m7374C(new RunnableC2073mr(this, str, j));
        }
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final /* bridge */ C1092Xp mo3783o() {
        return super.mo3783o();
    }

    @Override
    public final /* bridge */ C1801gx mo3784p() {
        return super.mo3784p();
    }

    @Override
    public final /* bridge */ C2079mx mo3785q() {
        return super.mo3785q();
    }

    @Override
    public final /* bridge */ C1207aB mo3786r() {
        return super.mo3786r();
    }

    @Override
    public final /* bridge */ C1070XC mo3787s() {
        return super.mo3787s();
    }

    @Override
    public final /* bridge */ C2142oD mo3788t() {
        return super.mo3788t();
    }

    @Override
    public final /* bridge */ C0796RE mo3789u() {
        return super.mo3789u();
    }

    public final void m4848v(long j) {
        C1162ZC c1162zcM4690D = mo3787s().m4690D(false);
        for (String str : this.f3289b.keySet()) {
            m4851y(str, j - ((Long) this.f3289b.get(str)).longValue(), c1162zcM4690D);
        }
        if (!this.f3289b.isEmpty()) {
            m4849w(j - this.f3291d, c1162zcM4690D);
        }
        m4844B(j);
    }

    public final void m4849w(long j, C1162ZC c1162zc) {
        if (c1162zc == null) {
            mo349g().m9622K().m10616a("Not logging ad exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo349g().m9622K().m10617b("Not logging ad exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putLong("_xt", j);
        C2514wG.m10459Y(c1162zc, bundle, true);
        mo3786r().m5166a1("am", "_xa", bundle);
    }

    public final void m4850x(String str, long j) {
        if (str == null || str.length() == 0) {
            mo349g().m9618G().m10616a("Ad unit id must be a non-empty string");
        } else {
            mo354l().m7374C(new RunnableC0268Fs(this, str, j));
        }
    }

    public final void m4851y(String str, long j, C1162ZC c1162zc) {
        if (c1162zc == null) {
            mo349g().m9622K().m10616a("Not logging ad unit exposure. No active activity");
            return;
        }
        if (j < 1000) {
            mo349g().m9622K().m10617b("Not logging ad unit exposure. Less than 1000 ms. exposure", Long.valueOf(j));
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("_ai", str);
        bundle.putLong("_xt", j);
        C2514wG.m10459Y(c1162zc, bundle, true);
        mo3786r().m5166a1("am", "_xu", bundle);
    }
}
