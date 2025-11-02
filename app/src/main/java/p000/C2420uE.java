package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Pair;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import p000.C2636z0;

public final class C2420uE extends AbstractC2513wF {

    public final Map f7388d;

    public final C2219py f7389e;

    public final C2219py f7390f;

    public final C2219py f7391g;

    public final C2219py f7392h;

    public final C2219py f7393i;

    public final C2219py f7394j;

    public C2420uE(C0200EF c0200ef) {
        super(c0200ef);
        this.f7388d = new HashMap<>();
        C1755fy c1755fyMo351i = mo351i();
        Objects.requireNonNull(c1755fyMo351i);
        this.f7389e = new C2219py(c1755fyMo351i, "last_delete_stale", 0L);
        C1755fy c1755fyMo351i2 = mo351i();
        Objects.requireNonNull(c1755fyMo351i2);
        this.f7390f = new C2219py(c1755fyMo351i2, "last_delete_stale_batch", 0L);
        C1755fy c1755fyMo351i3 = mo351i();
        Objects.requireNonNull(c1755fyMo351i3);
        this.f7391g = new C2219py(c1755fyMo351i3, "backoff", 0L);
        C1755fy c1755fyMo351i4 = mo351i();
        Objects.requireNonNull(c1755fyMo351i4);
        this.f7392h = new C2219py(c1755fyMo351i4, "last_upload", 0L);
        C1755fy c1755fyMo351i5 = mo351i();
        Objects.requireNonNull(c1755fyMo351i5);
        this.f7393i = new C2219py(c1755fyMo351i5, "last_upload_attempt", 0L);
        C1755fy c1755fyMo351i6 = mo351i();
        Objects.requireNonNull(c1755fyMo351i6);
        this.f7394j = new C2219py(c1755fyMo351i6, "midnight_offset", 0L);
    }

    private final Pair m9996y(String str) {
        C0015AE c0015ae;
        C2636z0.a aVarM10972a;
        mo356n();
        long jMo2817c = mo345b().mo2817c();
        C0015AE c0015ae2 = (C0015AE) this.f7388d.get(str);
        if (c0015ae2 != null && jMo2817c < c0015ae2.f50c) {
            return new Pair(c0015ae2.f48a, Boolean.valueOf(c0015ae2.f49b));
        }
        C2636z0.m10973b(true);
        long jM10795E = mo347e().m10795E(str) + jMo2817c;
        try {
            try {
                aVarM10972a = C2636z0.m10972a(mo344a());
            } catch (PackageManager.NameNotFoundException unused) {
                if (c0015ae2 != null && jMo2817c < c0015ae2.f50c + mo347e().m10793C(str, AbstractC0818Rr.f2487c)) {
                    return new Pair(c0015ae2.f48a, Boolean.valueOf(c0015ae2.f49b));
                }
                aVarM10972a = null;
            }
        } catch (Exception e) {
            mo349g().m9617F().m10617b("Unable to get advertising id", e);
            c0015ae = new C0015AE("", false, jM10795E);
        }
        if (aVarM10972a == null) {
            return new Pair("00000000-0000-0000-0000-000000000000", Boolean.FALSE);
        }
        String strM10979a = aVarM10972a.m10979a();
        c0015ae = strM10979a != null ? new C0015AE(strM10979a, aVarM10972a.m10980b(), jM10795E) : new C0015AE("", aVarM10972a.m10980b(), jM10795E);
        this.f7388d.put(str, c0015ae);
        C2636z0.m10973b(false);
        return new Pair(c0015ae.f48a, Boolean.valueOf(c0015ae.f49b));
    }

    public final String m9997A(String str, boolean z) throws NoSuchAlgorithmException {
        mo356n();
        String str2 = z ? (String) m9996y(str).first : "00000000-0000-0000-0000-000000000000";
        MessageDigest messageDigestM10458V0 = C2514wG.m10458V0();
        if (messageDigestM10458V0 == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestM10458V0.digest(str2.getBytes())));
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

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final Pair m9998z(String str, C0425JA c0425ja) {
        return c0425ja.m1851A() ? m9996y(str) : new Pair("", Boolean.FALSE);
    }
}
