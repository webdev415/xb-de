package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import p000.C0410Iw;
import p000.C0425JA;
import p000.C0502Kw;
import p000.C0548Lw;

/* loaded from: classes.dex */
public final class C0596My extends AbstractC2513wF implements InterfaceC0220Eq {

    public final Map f1867d;

    public final Map f1868e;

    public final Map f1869f;

    public final Map f1870g;

    public final Map f1871h;

    public final Map f1872i;

    public final AbstractC1737fg f1873j;

    public final InterfaceC0800RI f1874k;

    public final Map f1875l;

    public final Map f1876m;

    public final Map f1877n;

    public C0596My(C0200EF c0200ef) {
        super(c0200ef);
        this.f1867d = new C2453v1();
        this.f1868e = new C2453v1();
        this.f1869f = new C2453v1();
        this.f1870g = new C2453v1();
        this.f1871h = new C2453v1();
        this.f1875l = new C2453v1();
        this.f1876m = new C2453v1();
        this.f1877n = new C2453v1();
        this.f1872i = new C2453v1();
        this.f1873j = new C1101Xy(this, 20);
        this.f1874k = new C1009Vy(this);
    }

    public static C2534wr m3210B(C0596My c0596My, String str) throws Throwable {
        c0596My.m10440u();
        AbstractC1085Xi.m4795d(str);
        if (!c0596My.m3233X(str)) {
            return null;
        }
        if (!c0596My.f1871h.containsKey(str) || c0596My.f1871h.get(str) == null) {
            c0596My.m3243h0(str);
        } else {
            c0596My.m3216G(str, (C0548Lw) c0596My.f1871h.get(str));
        }
        return (C2534wr) c0596My.f1873j.m7592h().get(str);
    }

    public static C0425JA.a m3211E(C0410Iw.e eVar) {
        int i = AbstractC1193Zy.f3479b[eVar.ordinal()];
        if (i == 1) {
            return C0425JA.a.AD_STORAGE;
        }
        if (i == 2) {
            return C0425JA.a.ANALYTICS_STORAGE;
        }
        if (i == 3) {
            return C0425JA.a.AD_USER_DATA;
        }
        if (i != 4) {
            return null;
        }
        return C0425JA.a.AD_PERSONALIZATION;
    }

    public static Map m3212z(C0548Lw c0548Lw) {
        C2453v1 c2453v1 = new C2453v1();
        if (c0548Lw != null) {
            for (C0732Pw c0732Pw : c0548Lw.m2754V()) {
                c2453v1.put(c0732Pw.m3593H(), c0732Pw.m3594I());
            }
        }
        return c2453v1;
    }

    public final C0548Lw m3213C(String str, byte[] bArr) {
        if (bArr == null) {
            return C0548Lw.m2743O();
        }
        try {
            C0548Lw c0548Lw = (C0548Lw) ((AbstractC0703PC) ((C0548Lw.a) C2145oG.m8894P(C0548Lw.m2741M(), bArr)).m3526o());
            mo349g().m9622K().m10618c("Parsed config. version, gmp_app_id", c0548Lw.m2759a0() ? Long.valueOf(c0548Lw.m2746K()) : null, c0548Lw.m2757Y() ? c0548Lw.m2749Q() : null);
            return c0548Lw;
        } catch (C1771gD e) {
            e = e;
            mo349g().m9623L().m10618c("Unable to merge remote config. appId", C2356sx.m9613v(str), e);
            return C0548Lw.m2743O();
        } catch (RuntimeException e2) {
            e = e2;
            mo349g().m9623L().m10618c("Unable to merge remote config. appId", C2356sx.m9613v(str), e);
            return C0548Lw.m2743O();
        }
    }

    public final EnumC0333HA m3214D(String str, C0425JA.a aVar) {
        mo356n();
        m3243h0(str);
        C0410Iw c0410IwM3219J = m3219J(str);
        if (c0410IwM3219J == null) {
            return EnumC0333HA.UNINITIALIZED;
        }
        for (C0410Iw.b bVar : c0410IwM3219J.m1731L()) {
            if (m3211E(bVar.m1736I()) == aVar) {
                int i = AbstractC1193Zy.f3480c[bVar.m1735H().ordinal()];
                return i != 1 ? i != 2 ? EnumC0333HA.UNINITIALIZED : EnumC0333HA.GRANTED : EnumC0333HA.DENIED;
            }
        }
        return EnumC0333HA.UNINITIALIZED;
    }

    public final void m3215F(String str, C0548Lw.a aVar) {
        HashSet hashSet = new HashSet();
        C2453v1 c2453v1 = new C2453v1();
        C2453v1 c2453v12 = new C2453v1();
        C2453v1 c2453v13 = new C2453v1();
        if (aVar != null) {
            Iterator it = aVar.m2767z().iterator();
            while (it.hasNext()) {
                hashSet.add(((C0456Jw) it.next()).m2174H());
            }
            for (int i = 0; i < aVar.m2761t(); i++) {
                C0502Kw.a aVarM2562u = (C0502Kw.a) aVar.m2762u(i).m3517y();
                if (aVarM2562u.m2563v().isEmpty()) {
                    mo349g().m9623L().m10616a("EventConfig contained null event name");
                } else {
                    String strM2563v = aVarM2562u.m2563v();
                    String strM3492b = AbstractC0701PA.m3492b(aVarM2562u.m2563v());
                    if (!TextUtils.isEmpty(strM3492b)) {
                        aVarM2562u = aVarM2562u.m2562u(strM3492b);
                        aVar.m2763v(i, aVarM2562u);
                    }
                    if (aVarM2562u.m2566y() && aVarM2562u.m2564w()) {
                        c2453v1.put(strM2563v, Boolean.TRUE);
                    }
                    if (aVarM2562u.m2567z() && aVarM2562u.m2565x()) {
                        c2453v12.put(aVarM2562u.m2563v(), Boolean.TRUE);
                    }
                    if (aVarM2562u.m2560A()) {
                        if (aVarM2562u.m2561t() < 2 || aVarM2562u.m2561t() > 65535) {
                            mo349g().m9623L().m10618c("Invalid sampling rate. Event name, sample rate", aVarM2562u.m2563v(), Integer.valueOf(aVarM2562u.m2561t()));
                        } else {
                            c2453v13.put(aVarM2562u.m2563v(), Integer.valueOf(aVarM2562u.m2561t()));
                        }
                    }
                }
            }
        }
        this.f1868e.put(str, hashSet);
        this.f1869f.put(str, c2453v1);
        this.f1870g.put(str, c2453v12);
        this.f1872i.put(str, c2453v13);
    }

    public final void m3216G(final String str, C0548Lw c0548Lw) {
        if (c0548Lw.m2760j() == 0) {
            this.f1873j.m7589e(str);
            return;
        }
        mo349g().m9622K().m10617b("EES programs found", Integer.valueOf(c0548Lw.m2760j()));
        C0504Ky c0504Ky = (C0504Ky) c0548Lw.m2753U().get(0);
        try {
            C2534wr c2534wr = new C2534wr();
            c2534wr.m10608b("internal.remoteConfig", new Callable() {
                @Override
                public final Object call() {
                    return new C0382ID("internal.remoteConfig", new C1341bz(this.f1985a, str));
                }
            });
            c2534wr.m10608b("internal.appMetadata", new Callable() {
                @Override
                public final Object call() {
                    final C0596My c0596My = this.f2797a;
                    final String str2 = str;
                    return new C1168ZI("internal.appMetadata", new Callable() {
                        @Override
                        public final Object call() {
                            C0596My c0596My2 = c0596My;
                            String str3 = str2;
                            C2403ty c2403tyM2488L0 = c0596My2.mo3246q().m2488L0(str3);
                            HashMap map = new HashMap<>();
                            map.put("platform", "android");
                            map.put("package_name", str3);
                            map.put("gmp_version", 102001L);
                            if (c2403tyM2488L0 != null) {
                                String strM9854o = c2403tyM2488L0.m9854o();
                                if (strM9854o != null) {
                                    map.put("app_version", strM9854o);
                                }
                                map.put("app_version_int", Long.valueOf(c2403tyM2488L0.m9820U()));
                                map.put("dynamite_version", Long.valueOf(c2403tyM2488L0.m9869v0()));
                            }
                            return map;
                        }
                    });
                }
            });
            c2534wr.m10608b("internal.logger", new Callable() {
                @Override
                public final Object call() {
                    return new C1029WH(this.f2563a.f1874k);
                }
            });
            c2534wr.m10609c(c0504Ky);
            this.f1873j.m7588d(str, c2534wr);
            mo349g().m9622K().m10618c("EES program loaded for appId, activities", str, Integer.valueOf(c0504Ky.m2570G().m1756j()));
            Iterator it = c0504Ky.m2570G().m1755I().iterator();
            while (it.hasNext()) {
                mo349g().m9622K().m10617b("EES program activity", ((C0458Jy) it.next()).m2214H());
            }
        } catch (C0222Es unused) {
            mo349g().m9618G().m10617b("Failed to load EES program. appId", str);
        }
    }

    public final boolean m3217H(String str, byte[] bArr, String str2, String str3) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        C0548Lw.a aVar = (C0548Lw.a) m3213C(str, bArr).m3517y();
        if (aVar == null) {
            return false;
        }
        m3215F(str, aVar);
        m3216G(str, (C0548Lw) ((AbstractC0703PC) aVar.m3526o()));
        this.f1871h.put(str, (C0548Lw) ((AbstractC0703PC) aVar.m3526o()));
        this.f1875l.put(str, aVar.m2765x());
        this.f1876m.put(str, str2);
        this.f1877n.put(str, str3);
        this.f1867d.put(str, m3212z((C0548Lw) ((AbstractC0703PC) aVar.m3526o())));
        mo3246q().m2506W(str, new ArrayList<>(aVar.m2766y()));
        try {
            aVar.m2764w();
            bArr = ((C0548Lw) ((AbstractC0703PC) aVar.m3526o())).m4464i();
        } catch (RuntimeException e) {
            mo349g().m9623L().m10618c("Unable to serialize reduced-size config. Storing full config instead. appId", C2356sx.m9613v(str), e);
        }
        C0496Kq c0496KqMo3246q = mo3246q();
        AbstractC1085Xi.m4795d(str);
        c0496KqMo3246q.mo356n();
        c0496KqMo3246q.m10440u();
        ContentValues contentValues = new ContentValues();
        contentValues.put("remote_config", bArr);
        contentValues.put("config_last_modified_time", str2);
        contentValues.put("e_tag", str3);
        try {
            if (c0496KqMo3246q.m2467B().update("apps", contentValues, "app_id = ?", new String[]{str}) == 0) {
                c0496KqMo3246q.mo349g().m9618G().m10617b("Failed to update remote config (got 0). appId", C2356sx.m9613v(str));
            }
        } catch (SQLiteException e2) {
            c0496KqMo3246q.mo349g().m9618G().m10618c("Error storing remote config. appId", C2356sx.m9613v(str), e2);
        }
        this.f1871h.put(str, (C0548Lw) ((AbstractC0703PC) aVar.m3526o()));
        return true;
    }

    public final int m3218I(String str, String str2) throws Throwable {
        Integer num;
        mo356n();
        m3243h0(str);
        Map map = (Map) this.f1872i.get(str);
        if (map == null || (num = (Integer) map.get(str2)) == null) {
            return 1;
        }
        return num.intValue();
    }

    public final C0410Iw m3219J(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        C0548Lw c0548LwM3221L = m3221L(str);
        if (c0548LwM3221L == null || !c0548LwM3221L.m2756X()) {
            return null;
        }
        return c0548LwM3221L.m2747L();
    }

    public final C0425JA.a m3220K(String str, C0425JA.a aVar) {
        mo356n();
        m3243h0(str);
        C0410Iw c0410IwM3219J = m3219J(str);
        if (c0410IwM3219J == null) {
            return null;
        }
        for (C0410Iw.c cVar : c0410IwM3219J.m1730K()) {
            if (aVar == m3211E(cVar.m1739I())) {
                return m3211E(cVar.m1738H());
            }
        }
        return null;
    }

    public final C0548Lw m3221L(String str) {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        m3243h0(str);
        return (C0548Lw) this.f1871h.get(str);
    }

    public final boolean m3222M(String str, String str2) throws Throwable {
        Boolean bool;
        mo356n();
        m3243h0(str);
        if ("ecommerce_purchase".equals(str2) || "purchase".equals(str2) || "refund".equals(str2)) {
            return true;
        }
        Map map = (Map) this.f1870g.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final boolean m3223N(String str, C0425JA.a aVar) throws Throwable {
        mo356n();
        m3243h0(str);
        C0410Iw c0410IwM3219J = m3219J(str);
        if (c0410IwM3219J == null) {
            return false;
        }
        Iterator it = c0410IwM3219J.m1729J().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            C0410Iw.b bVar = (C0410Iw.b) it.next();
            if (aVar == m3211E(bVar.m1736I())) {
                if (bVar.m1735H() == C0410Iw.d.GRANTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public final String m3224O(String str) {
        mo356n();
        return (String) this.f1877n.get(str);
    }

    public final boolean m3225P(String str, String str2) throws Throwable {
        Boolean bool;
        mo356n();
        m3243h0(str);
        if (m3234Y(str) && C2514wG.m10452J0(str2)) {
            return true;
        }
        if (m3236a0(str) && C2514wG.m10454L0(str2)) {
            return true;
        }
        Map map = (Map) this.f1869f.get(str);
        if (map == null || (bool = (Boolean) map.get(str2)) == null) {
            return false;
        }
        return bool.booleanValue();
    }

    public final String m3226Q(String str) {
        mo356n();
        return (String) this.f1876m.get(str);
    }

    public final String m3227R(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        return (String) this.f1875l.get(str);
    }

    public final Set m3228S(String str) {
        mo356n();
        m3243h0(str);
        return (Set) this.f1868e.get(str);
    }

    public final SortedSet m3229T(String str) {
        mo356n();
        m3243h0(str);
        TreeSet treeSet = new TreeSet();
        C0410Iw c0410IwM3219J = m3219J(str);
        if (c0410IwM3219J == null) {
            return treeSet;
        }
        Iterator it = c0410IwM3219J.m1728I().iterator();
        while (it.hasNext()) {
            treeSet.add(((C0410Iw.f) it.next()).m1746H());
        }
        return treeSet;
    }

    public final void m3230U(String str) {
        mo356n();
        this.f1876m.put(str, null);
    }

    public final void m3231V(String str) {
        mo356n();
        this.f1871h.remove(str);
    }

    public final boolean m3232W(String str) {
        mo356n();
        C0548Lw c0548LwM3221L = m3221L(str);
        if (c0548LwM3221L == null) {
            return false;
        }
        return c0548LwM3221L.m2755W();
    }

    public final boolean m3233X(String str) {
        C0548Lw c0548Lw;
        return (TextUtils.isEmpty(str) || (c0548Lw = (C0548Lw) this.f1871h.get(str)) == null || c0548Lw.m2760j() == 0) ? false : true;
    }

    public final boolean m3234Y(String str) {
        return "1".equals(mo1096c(str, "measurement.upload.blacklist_internal"));
    }

    public final boolean m3235Z(String str) {
        mo356n();
        m3243h0(str);
        C0410Iw c0410IwM3219J = m3219J(str);
        return c0410IwM3219J == null || !c0410IwM3219J.m1733N() || c0410IwM3219J.m1732M();
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    public final boolean m3236a0(String str) {
        return "1".equals(mo1096c(str, "measurement.upload.blacklist_public"));
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    public final boolean m3237b0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        return this.f1868e.get(str) != null && ((Set) this.f1868e.get(str)).contains("app_instance_id");
    }

    @Override
    public final String mo1096c(String str, String str2) throws Throwable {
        mo356n();
        m3243h0(str);
        Map map = (Map) this.f1867d.get(str);
        if (map != null) {
            return (String) map.get(str2);
        }
        return null;
    }

    public final boolean m3238c0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        if (this.f1868e.get(str) != null) {
            return ((Set) this.f1868e.get(str)).contains("device_model") || ((Set) this.f1868e.get(str)).contains("device_info");
        }
        return false;
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    public final boolean m3239d0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        return this.f1868e.get(str) != null && ((Set) this.f1868e.get(str)).contains("enhanced_user_id");
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    public final boolean m3240e0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        return this.f1868e.get(str) != null && ((Set) this.f1868e.get(str)).contains("google_signals");
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    public final boolean m3241f0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        if (this.f1868e.get(str) != null) {
            return ((Set) this.f1868e.get(str)).contains("os_version") || ((Set) this.f1868e.get(str)).contains("device_info");
        }
        return false;
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    public final boolean m3242g0(String str) throws Throwable {
        mo356n();
        m3243h0(str);
        return this.f1868e.get(str) != null && ((Set) this.f1868e.get(str)).contains("user_id");
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    public final void m3243h0(String str) throws Throwable {
        m10440u();
        mo356n();
        AbstractC1085Xi.m4795d(str);
        if (this.f1871h.get(str) == null) {
            C0680Oq c0680OqM2494O0 = mo3246q().m2494O0(str);
            if (c0680OqM2494O0 != null) {
                C0548Lw.a aVar = (C0548Lw.a) m3213C(str, c0680OqM2494O0.f2061a).m3517y();
                m3215F(str, aVar);
                this.f1867d.put(str, m3212z((C0548Lw) ((AbstractC0703PC) aVar.m3526o())));
                this.f1871h.put(str, (C0548Lw) ((AbstractC0703PC) aVar.m3526o()));
                m3216G(str, (C0548Lw) ((AbstractC0703PC) aVar.m3526o()));
                this.f1875l.put(str, aVar.m2765x());
                this.f1876m.put(str, c0680OqM2494O0.f2062b);
                this.f1877n.put(str, c0680OqM2494O0.f2063c);
                return;
            }
            this.f1867d.put(str, null);
            this.f1869f.put(str, null);
            this.f1868e.put(str, null);
            this.f1870g.put(str, null);
            this.f1871h.put(str, null);
            this.f1875l.put(str, null);
            this.f1876m.put(str, null);
            this.f1877n.put(str, null);
            this.f1872i.put(str, null);
        }
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

    public final long m3250y(String str) throws Throwable {
        String strMo1096c = mo1096c(str, "measurement.account.time_zone_offset_minutes");
        if (TextUtils.isEmpty(strMo1096c)) {
            return 0L;
        }
        try {
            return Long.parseLong(strMo1096c);
        } catch (NumberFormatException e) {
            mo349g().m9623L().m10618c("Unable to parse timezone offset. appId", C2356sx.m9613v(str), e);
            return 0L;
        }
    }
}
