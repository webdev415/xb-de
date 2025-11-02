package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.lang.reflect.InvocationTargetException;

/* loaded from: classes.dex */
public final class C2579xq extends AbstractC2600yA {

    public Boolean f8034b;

    public String f8035c;

    public InterfaceC0220Eq f8036d;

    public Boolean f8037e;

    public C2579xq(C2266qz c2266qz) {
        super(c2266qz);
        this.f8036d = new InterfaceC0220Eq() {
            @Override
            public final String mo1096c(String str, String str2) {
                return null;
            }
        };
    }

    public static long m10785M() {
        return ((Long) AbstractC0818Rr.f2493e.m4296a(null)).longValue();
    }

    public static long m10786R() {
        return ((Long) AbstractC0818Rr.f2441G.m4296a(null)).longValue();
    }

    public static long m10787S() {
        return ((Integer) AbstractC0818Rr.f2514l.m4296a(null)).intValue();
    }

    public static long m10788T() {
        return ((Long) AbstractC0818Rr.f2439F.m4296a(null)).longValue();
    }

    public static long m10789U() {
        return ((Long) AbstractC0818Rr.f2429A.m4296a(null)).longValue();
    }

    private final String m10790c(String str, String str2) {
        C2540wx c2540wxM9618G;
        String str3;
        try {
            String str4 = (String) Class.forName("android.os.SystemProperties").getMethod("get", String.class, String.class).invoke(null, str, str2);
            AbstractC1085Xi.m4801j(str4);
            return str4;
        } catch (ClassNotFoundException e) {
            e = e;
            c2540wxM9618G = mo349g().m9618G();
            str3 = "Could not find SystemProperties class";
            c2540wxM9618G.m10617b(str3, e);
            return str2;
        } catch (IllegalAccessException e2) {
            e = e2;
            c2540wxM9618G = mo349g().m9618G();
            str3 = "Could not access SystemProperties.get()";
            c2540wxM9618G.m10617b(str3, e);
            return str2;
        } catch (NoSuchMethodException e3) {
            e = e3;
            c2540wxM9618G = mo349g().m9618G();
            str3 = "Could not find SystemProperties.get() method";
            c2540wxM9618G.m10617b(str3, e);
            return str2;
        } catch (InvocationTargetException e4) {
            e = e4;
            c2540wxM9618G = mo349g().m9618G();
            str3 = "SystemProperties.get() threw an exception";
            c2540wxM9618G.m10617b(str3, e);
            return str2;
        }
    }

    public final int m10791A() {
        return (C0891TH.m4129a() && mo347e().m10800J(null, AbstractC0818Rr.f2440F0) && mo352j().m10510c0(231100000, true)) ? 35 : 0;
    }

    public final int m10792B(String str) {
        return m10823y(str, AbstractC0818Rr.f2526p);
    }

    public final long m10793C(String str, C0961Uw c0961Uw) {
        if (!TextUtils.isEmpty(str)) {
            String strMo1096c = this.f8036d.mo1096c(str, c0961Uw.m4297b());
            if (!TextUtils.isEmpty(strMo1096c)) {
                try {
                    return ((Long) c0961Uw.m4296a(Long.valueOf(Long.parseLong(strMo1096c)))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Long) c0961Uw.m4296a(null)).longValue();
    }

    public final EnumC0333HA m10794D(String str, boolean z) {
        Object obj;
        AbstractC1085Xi.m4795d(str);
        Bundle bundleM10821w = m10821w();
        if (bundleM10821w == null) {
            mo349g().m9618G().m10616a("Failed to load metadata: Metadata bundle is null");
            obj = null;
        } else {
            obj = bundleM10821w.get(str);
        }
        if (obj == null) {
            return EnumC0333HA.UNINITIALIZED;
        }
        if (Boolean.TRUE.equals(obj)) {
            return EnumC0333HA.GRANTED;
        }
        if (Boolean.FALSE.equals(obj)) {
            return EnumC0333HA.DENIED;
        }
        if (z && "eu_consent_policy".equals(obj)) {
            return EnumC0333HA.POLICY;
        }
        mo349g().m9623L().m10617b("Invalid manifest metadata for", str);
        return EnumC0333HA.UNINITIALIZED;
    }

    public final long m10795E(String str) {
        return m10793C(str, AbstractC0818Rr.f2484b);
    }

    public final String m10796F(String str, C0961Uw c0961Uw) {
        return (String) c0961Uw.m4296a(TextUtils.isEmpty(str) ? null : this.f8036d.mo1096c(str, c0961Uw.m4297b()));
    }

    public final Boolean m10797G(String str) {
        AbstractC1085Xi.m4795d(str);
        Bundle bundleM10821w = m10821w();
        if (bundleM10821w == null) {
            mo349g().m9618G().m10616a("Failed to load metadata: Metadata bundle is null");
            return null;
        }
        if (bundleM10821w.containsKey(str)) {
            return Boolean.valueOf(bundleM10821w.getBoolean(str));
        }
        return null;
    }

    public final boolean m10798H(String str, C0961Uw c0961Uw) {
        return m10800J(str, c0961Uw);
    }

    public final String m10799I(String str) {
        return m10796F(str, AbstractC0818Rr.f2457O);
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0007  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m10800J(String r4, C0961Uw r5) {
        /*
            r3 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L12
        L7:
            java.lang.Object r4 = r5.m4296a(r1)
        Lb:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L12:
            Eq r0 = r3.f8036d
            java.lang.String r2 = r5.m4297b()
            java.lang.String r4 = r0.mo1096c(r4, r2)
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L23
            goto L7
        L23:
            java.lang.String r0 = "1"
            boolean r4 = r0.equals(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = r5.m4296a(r4)
            goto Lb
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2579xq.m10800J(java.lang.String, Uw):boolean");
    }

    public final int m10801K() {
        return mo352j().m10510c0(201500000, true) ? 100 : 25;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x002b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.util.List m10802L(String r4) throws android.content.res.Resources.NotFoundException {
        /*
            r3 = this;
            p000.AbstractC1085Xi.m4795d(r4)
            android.os.Bundle r0 = r3.m10821w()
            r1 = 0
            if (r0 != 0) goto L19
            sx r4 = r3.mo349g()
            wx r4 = r4.m9618G()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.m10616a(r0)
        L17:
            r4 = r1
            goto L28
        L19:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L20
            goto L17
        L20:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L28:
            if (r4 != 0) goto L2b
            return r1
        L2b:
            android.content.Context r0 = r3.mo344a()     // Catch: android.content.res.Resources.NotFoundException -> L43
            android.content.res.Resources r0 = r0.getResources()     // Catch: android.content.res.Resources.NotFoundException -> L43
            int r4 = r4.intValue()     // Catch: android.content.res.Resources.NotFoundException -> L43
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            if (r4 != 0) goto L3e
            return r1
        L3e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch: android.content.res.Resources.NotFoundException -> L43
            return r4
        L43:
            r4 = move-exception
            sx r0 = r3.mo349g()
            wx r0 = r0.m9618G()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.m10617b(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2579xq.m10802L(java.lang.String):java.util.List");
    }

    public final void m10803N(String str) {
        this.f8035c = str;
    }

    public final boolean m10804O(String str) {
        return m10800J(str, AbstractC0818Rr.f2455N);
    }

    public final boolean m10805P(String str) {
        return "1".equals(this.f8036d.mo1096c(str, "gaia_collection_enabled"));
    }

    public final boolean m10806Q(String str) {
        return "1".equals(this.f8036d.mo1096c(str, "measurement.event_sampling_enabled"));
    }

    public final String m10807V() {
        return m10790c("debug.firebase.analytics.app", "");
    }

    public final String m10808W() {
        return m10790c("debug.deferred.deeplink", "");
    }

    public final String m10809X() {
        return this.f8035c;
    }

    public final boolean m10810Y() {
        Boolean boolM10797G = m10797G("google_analytics_adid_collection_enabled");
        return boolM10797G == null || boolM10797G.booleanValue();
    }

    public final boolean m10811Z() {
        Boolean boolM10797G = m10797G("google_analytics_automatic_screen_reporting_enabled");
        return boolM10797G == null || boolM10797G.booleanValue();
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    public final boolean m10812a0() {
        Boolean boolM10797G = m10797G("firebase_analytics_collection_deactivated");
        return boolM10797G != null && boolM10797G.booleanValue();
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

    public final double m10813o(String str, C0961Uw c0961Uw) {
        if (!TextUtils.isEmpty(str)) {
            String strMo1096c = this.f8036d.mo1096c(str, c0961Uw.m4297b());
            if (!TextUtils.isEmpty(strMo1096c)) {
                try {
                    return ((Double) c0961Uw.m4296a(Double.valueOf(Double.parseDouble(strMo1096c)))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Double) c0961Uw.m4296a(null)).doubleValue();
    }

    public final int m10814p(String str) {
        return m10815q(str, AbstractC0818Rr.f2449K, 500, 2000);
    }

    public final int m10815q(String str, C0961Uw c0961Uw, int i, int i2) {
        return Math.max(Math.min(m10823y(str, c0961Uw), i2), i);
    }

    public final int m10816r(String str, boolean z) {
        if (!C0845SH.m4025a() || !mo347e().m10800J(null, AbstractC0818Rr.f2472V0)) {
            return 100;
        }
        if (z) {
            return m10815q(str, AbstractC0818Rr.f2469U, 100, 500);
        }
        return 500;
    }

    public final void m10817s(InterfaceC0220Eq interfaceC0220Eq) {
        this.f8036d = interfaceC0220Eq;
    }

    public final boolean m10818t(C0961Uw c0961Uw) {
        return m10800J(null, c0961Uw);
    }

    public final boolean m10819u() {
        if (this.f8034b == null) {
            Boolean boolM10797G = m10797G("app_measurement_lite");
            this.f8034b = boolM10797G;
            if (boolM10797G == null) {
                this.f8034b = Boolean.FALSE;
            }
        }
        return this.f8034b.booleanValue() || !this.f8058a.m9246t();
    }

    public final boolean m10820v() {
        if (this.f8037e == null) {
            synchronized (this) {
                try {
                    if (this.f8037e == null) {
                        ApplicationInfo applicationInfo = mo344a().getApplicationInfo();
                        String strM7604a = AbstractC1740fj.m7604a();
                        if (applicationInfo != null) {
                            String str = applicationInfo.processName;
                            this.f8037e = Boolean.valueOf(str != null && str.equals(strM7604a));
                        }
                        if (this.f8037e == null) {
                            this.f8037e = Boolean.TRUE;
                            mo349g().m9618G().m10616a("My process not in the list of running processes");
                        }
                    }
                } finally {
                }
            }
        }
        return this.f8037e.booleanValue();
    }

    public final Bundle m10821w() {
        try {
            if (mo344a().getPackageManager() == null) {
                mo349g().m9618G().m10616a("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfoM10889b = C2670zp.m11048a(mo344a()).m10889b(mo344a().getPackageName(), 128);
            if (applicationInfoM10889b != null) {
                return applicationInfoM10889b.metaData;
            }
            mo349g().m9618G().m10616a("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            mo349g().m9618G().m10617b("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final int m10822x(String str) {
        return m10815q(str, AbstractC0818Rr.f2451L, 25, 100);
    }

    public final int m10823y(String str, C0961Uw c0961Uw) {
        if (!TextUtils.isEmpty(str)) {
            String strMo1096c = this.f8036d.mo1096c(str, c0961Uw.m4297b());
            if (!TextUtils.isEmpty(strMo1096c)) {
                try {
                    return ((Integer) c0961Uw.m4296a(Integer.valueOf(Integer.parseInt(strMo1096c)))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return ((Integer) c0961Uw.m4296a(null)).intValue();
    }

    public final int m10824z(String str, boolean z) {
        return Math.max(m10816r(str, z), 256);
    }
}
