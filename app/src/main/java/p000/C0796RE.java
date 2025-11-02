package p000;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;

/* loaded from: classes.dex */
public final class C0796RE extends AbstractC0501Kv {

    public Handler f2361c;

    public boolean f2362d;

    public final C1820hF f2363e;

    public final C1633dF f2364f;

    public final C0888TE f2365g;

    public C0796RE(C2266qz c2266qz) {
        super(c2266qz);
        this.f2362d = true;
        this.f2363e = new C1820hF(this);
        this.f2364f = new C1633dF(this);
        this.f2365g = new C0888TE(this);
    }

    public static void m3776C(C0796RE c0796re, long j) {
        c0796re.mo356n();
        c0796re.m3782G();
        c0796re.mo349g().m9622K().m10617b("Activity paused, time", Long.valueOf(j));
        c0796re.f2365g.m4123b(j);
        if (c0796re.mo347e().m10811Z()) {
            c0796re.f2364f.m7314e(j);
        }
    }

    public static void m3778I(C0796RE c0796re, long j) {
        c0796re.mo356n();
        c0796re.m3782G();
        c0796re.mo349g().m9622K().m10617b("Activity resumed, time", Long.valueOf(j));
        if (!c0796re.mo347e().m10818t(AbstractC0818Rr.f2458O0) ? c0796re.mo347e().m10811Z() || c0796re.mo351i().f5570u.m8428b() : c0796re.mo347e().m10811Z() || c0796re.f2362d) {
            c0796re.f2364f.m7315f(j);
        }
        c0796re.f2365g.m4122a();
        C1820hF c1820hF = c0796re.f2363e;
        c1820hF.f5727a.mo356n();
        if (c1820hF.f5727a.f8058a.m9242p()) {
            c1820hF.m7819b(c1820hF.f5727a.mo345b().mo2815a(), false);
        }
    }

    @Override
    public final boolean mo2545A() {
        return false;
    }

    public final void m3779D(boolean z) {
        mo356n();
        this.f2362d = z;
    }

    public final boolean m3780E(boolean z, boolean z2, long j) {
        return this.f2364f.m7313d(z, z2, j);
    }

    public final boolean m3781F() {
        mo356n();
        return this.f2362d;
    }

    public final void m3782G() {
        mo356n();
        if (this.f2361c == null) {
            this.f2361c = new HandlerC1704eu(Looper.getMainLooper());
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
}
