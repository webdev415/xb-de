package p000;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import java.util.HashMap;

public final class C2467vF extends AbstractC2283rF {
    public C2467vF(C0200EF c0200ef) {
        super(c0200ef);
    }

    private final String m10332w(String str) throws Throwable {
        String strM3227R = mo3247r().m3227R(str);
        if (TextUtils.isEmpty(strM3227R)) {
            return (String) AbstractC0818Rr.f2530r.m4296a(null);
        }
        Uri uri = Uri.parse((String) AbstractC0818Rr.f2530r.m4296a(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strM3227R + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
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
    public final /* bridge */ C2145oG mo3244o() {
        return super.mo3244o();
    }

    @Override
    public final /* bridge */ C0846SI mo3245p() {
        return super.mo3245p();
    }

    @Override
    public final /* bridge */ C0496Kq mo3246q() {
        return super.mo3246q();
    }

    @Override
    public final /* bridge */ C0596My mo3247r() {
        return super.mo3247r();
    }

    @Override
    public final /* bridge */ C2420uE mo3248s() {
        return super.mo3248s();
    }

    @Override
    public final /* bridge */ C2467vF mo3249t() {
        return super.mo3249t();
    }

    public final String m10333u(C2403ty c2403ty) {
        Uri.Builder builder = new Uri.Builder();
        String strM9858q = c2403ty.m9858q();
        if (TextUtils.isEmpty(strM9858q)) {
            strM9858q = c2403ty.m9844j();
        }
        builder.scheme((String) AbstractC0818Rr.f2496f.m4296a(null)).encodedAuthority((String) AbstractC0818Rr.f2499g.m4296a(null)).path("config/app/" + strM9858q).appendQueryParameter("platform", "android").appendQueryParameter("gmp_version", "102001").appendQueryParameter("runtime_version", "0");
        return builder.build().toString();
    }

    public final C2605yF m10334v(String str) {
        C2403ty c2403tyM2488L0;
        if (C2470vI.m10339a() && mo347e().m10818t(AbstractC0818Rr.f2543x0)) {
            mo352j();
            if (C2514wG.m10450H0(str)) {
                mo349g().m9622K().m10616a("sgtm feature flag enabled.");
                C2403ty c2403tyM2488L02 = mo3246q().m2488L0(str);
                if (c2403tyM2488L02 == null) {
                    return new C2605yF(m10332w(str), EnumC0016AF.GOOGLE_ANALYTICS);
                }
                String strM9850m = c2403tyM2488L02.m9850m();
                C0548Lw c0548LwM3221L = mo3247r().m3221L(str);
                if (c0548LwM3221L == null || (c2403tyM2488L0 = mo3246q().m2488L0(str)) == null || ((!c0548LwM3221L.m2758Z() || c0548LwM3221L.m2748P().m3716j() != 100) && !mo352j().m10480E0(str, c2403tyM2488L0.m9868v()) && (TextUtils.isEmpty(strM9850m) || strM9850m.hashCode() % 100 >= c0548LwM3221L.m2748P().m3716j()))) {
                    return new C2605yF(m10332w(str), EnumC0016AF.GOOGLE_ANALYTICS);
                }
                C2605yF c2605yF = null;
                if (c2403tyM2488L02.m9791C()) {
                    mo349g().m9622K().m10616a("sgtm upload enabled in manifest.");
                    C0548Lw c0548LwM3221L2 = mo3247r().m3221L(c2403tyM2488L02.m9848l());
                    if (c0548LwM3221L2 != null && c0548LwM3221L2.m2758Z()) {
                        String strM3715J = c0548LwM3221L2.m2748P().m3715J();
                        if (!TextUtils.isEmpty(strM3715J)) {
                            String strM3714I = c0548LwM3221L2.m2748P().m3714I();
                            mo349g().m9622K().m10618c("sgtm configured with upload_url, server_info", strM3715J, TextUtils.isEmpty(strM3714I) ? "Y" : "N");
                            if (TextUtils.isEmpty(strM3714I)) {
                                c2605yF = new C2605yF(strM3715J, EnumC0016AF.SGTM);
                            } else {
                                HashMap map = new HashMap<>();
                                map.put("x-sgtm-server-info", strM3714I);
                                if (!TextUtils.isEmpty(c2403tyM2488L02.m9868v())) {
                                    map.put("x-gtm-server-preview", c2403tyM2488L02.m9868v());
                                }
                                c2605yF = new C2605yF(strM3715J, map, EnumC0016AF.SGTM);
                            }
                        }
                    }
                }
                if (c2605yF != null) {
                    return c2605yF;
                }
            }
        }
        return new C2605yF(m10332w(str), EnumC0016AF.GOOGLE_ANALYTICS);
    }
}
