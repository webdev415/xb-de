package p000;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class C1070XC extends AbstractC0501Kv {

    public volatile C1162ZC f3199c;

    public volatile C1162ZC f3200d;

    public C1162ZC f3201e;

    public final Map f3202f;

    public Activity f3203g;

    public volatile boolean f3204h;

    public volatile C1162ZC f3205i;

    public C1162ZC f3206j;

    public boolean f3207k;

    public final Object f3208l;

    public C1070XC(C2266qz c2266qz) {
        super(c2266qz);
        this.f3208l = new Object();
        this.f3202f = new ConcurrentHashMap();
    }

    public static void m4685J(C1070XC c1070xc, Bundle bundle, C1162ZC c1162zc, C1162ZC c1162zc2, long j) {
        if (bundle != null) {
            bundle.remove("screen_name");
            bundle.remove("screen_class");
        }
        c1070xc.m4696N(c1162zc, c1162zc2, j, true, c1070xc.mo352j().m10481F(null, "screen_view", bundle, null, false));
    }

    @Override
    public final boolean mo2545A() {
        return false;
    }

    public final String m4689B(Class cls, String str) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            return str;
        }
        String[] strArrSplit = canonicalName.split("\\.");
        String str2 = strArrSplit.length > 0 ? strArrSplit[strArrSplit.length - 1] : "";
        return str2.length() > mo347e().m10816r(null, false) ? str2.substring(0, mo347e().m10816r(null, false)) : str2;
    }

    public final C1162ZC m4690D(boolean z) {
        m2546v();
        mo356n();
        if (!z) {
            return this.f3201e;
        }
        C1162ZC c1162zc = this.f3201e;
        return c1162zc != null ? c1162zc : this.f3206j;
    }

    public final void m4691E(Activity activity) {
        synchronized (this.f3208l) {
            try {
                if (activity == this.f3203g) {
                    this.f3203g = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (mo347e().m10811Z()) {
            this.f3202f.remove(activity);
        }
    }

    public final void m4692F(Activity activity, Bundle bundle) {
        Bundle bundle2;
        if (!mo347e().m10811Z() || bundle == null || (bundle2 = bundle.getBundle("com.google.app_measurement.screen_service")) == null) {
            return;
        }
        this.f3202f.put(activity, new C1162ZC(bundle2.getString("name"), bundle2.getString("referrer_name"), bundle2.getLong("id")));
    }

    public final void m4693G(Activity activity, String str, String str2) {
        if (!mo347e().m10811Z()) {
            mo349g().m9624M().m10616a("setCurrentScreen cannot be called while screen reporting is disabled.");
            return;
        }
        C1162ZC c1162zc = this.f3199c;
        if (c1162zc == null) {
            mo349g().m9624M().m10616a("setCurrentScreen cannot be called while no activity active");
            return;
        }
        if (this.f3202f.get(activity) == null) {
            mo349g().m9624M().m10616a("setCurrentScreen must be called with an activity in the activity lifecycle");
            return;
        }
        if (str2 == null) {
            str2 = m4689B(activity.getClass(), "Activity");
        }
        boolean zEquals = Objects.equals(c1162zc.f3422b, str2);
        boolean zEquals2 = Objects.equals(c1162zc.f3421a, str);
        if (zEquals && zEquals2) {
            mo349g().m9624M().m10616a("setCurrentScreen cannot be called with the same class and name");
            return;
        }
        if (str != null && (str.length() <= 0 || str.length() > mo347e().m10816r(null, false))) {
            mo349g().m9624M().m10617b("Invalid screen name length in setCurrentScreen. Length", Integer.valueOf(str.length()));
            return;
        }
        if (str2 != null && (str2.length() <= 0 || str2.length() > mo347e().m10816r(null, false))) {
            mo349g().m9624M().m10617b("Invalid class name length in setCurrentScreen. Length", Integer.valueOf(str2.length()));
            return;
        }
        mo349g().m9622K().m10618c("Setting current screen to name, class", str == null ? "null" : str, str2);
        C1162ZC c1162zc2 = new C1162ZC(str, str2, mo352j().m10497R0());
        this.f3202f.put(activity, c1162zc2);
        m4694H(activity, c1162zc2, true);
    }

    public final void m4694H(Activity activity, C1162ZC c1162zc, boolean z) {
        C1162ZC c1162zc2;
        C1162ZC c1162zc3 = this.f3199c == null ? this.f3200d : this.f3199c;
        if (c1162zc.f3422b == null) {
            c1162zc2 = new C1162ZC(c1162zc.f3421a, activity != null ? m4689B(activity.getClass(), "Activity") : null, c1162zc.f3423c, c1162zc.f3425e, c1162zc.f3426f);
        } else {
            c1162zc2 = c1162zc;
        }
        this.f3200d = this.f3199c;
        this.f3199c = c1162zc2;
        mo354l().m7374C(new RunnableC1310bD(this, c1162zc2, c1162zc3, mo345b().mo2817c(), z));
    }

    public final void m4695I(Bundle bundle, long j) {
        String str;
        synchronized (this.f3208l) {
            try {
                if (!this.f3207k) {
                    mo349g().m9624M().m10616a("Cannot log screen view event when the app is in the background.");
                    return;
                }
                String strM4689B = null;
                if (bundle != null) {
                    String string = bundle.getString("screen_name");
                    if (string != null && (string.length() <= 0 || string.length() > mo347e().m10816r(null, false))) {
                        mo349g().m9624M().m10617b("Invalid screen name length for screen view. Length", Integer.valueOf(string.length()));
                        return;
                    }
                    String string2 = bundle.getString("screen_class");
                    if (string2 != null && (string2.length() <= 0 || string2.length() > mo347e().m10816r(null, false))) {
                        mo349g().m9624M().m10617b("Invalid screen class length for screen view. Length", Integer.valueOf(string2.length()));
                        return;
                    } else {
                        str = string;
                        strM4689B = string2;
                    }
                } else {
                    str = null;
                }
                if (strM4689B == null) {
                    Activity activity = this.f3203g;
                    strM4689B = activity != null ? m4689B(activity.getClass(), "Activity") : "Activity";
                }
                String str2 = strM4689B;
                C1162ZC c1162zc = this.f3199c;
                if (this.f3204h && c1162zc != null) {
                    this.f3204h = false;
                    boolean zEquals = Objects.equals(c1162zc.f3422b, str2);
                    boolean zEquals2 = Objects.equals(c1162zc.f3421a, str);
                    if (zEquals && zEquals2) {
                        mo349g().m9624M().m10616a("Ignoring call to log screen view event with duplicate parameters.");
                        return;
                    }
                }
                mo349g().m9622K().m10618c("Logging screen view with name, class", str == null ? "null" : str, str2 == null ? "null" : str2);
                C1162ZC c1162zc2 = this.f3199c == null ? this.f3200d : this.f3199c;
                C1162ZC c1162zc3 = new C1162ZC(str, str2, mo352j().m10497R0(), true, j);
                this.f3199c = c1162zc3;
                this.f3200d = c1162zc2;
                this.f3205i = c1162zc3;
                mo354l().m7374C(new RunnableC1631dD(this, bundle, c1162zc3, c1162zc2, mo345b().mo2817c()));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:50:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m4696N(C1162ZC r16, C1162ZC r17, long r18, boolean r20, Bundle r21) {
        /*
            r15 = this;
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r15.mo356n()
            r6 = 0
            r7 = 1
            if (r2 == 0) goto L2f
            long r8 = r2.f3423c
            long r10 = r1.f3423c
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 != 0) goto L2f
            java.lang.String r8 = r2.f3422b
            java.lang.String r9 = r1.f3422b
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 == 0) goto L2f
            java.lang.String r8 = r2.f3421a
            java.lang.String r9 = r1.f3421a
            boolean r8 = java.util.Objects.equals(r8, r9)
            if (r8 != 0) goto L2d
            goto L2f
        L2d:
            r8 = r6
            goto L30
        L2f:
            r8 = r7
        L30:
            if (r20 == 0) goto L37
            ZC r9 = r0.f3201e
            if (r9 == 0) goto L37
            r6 = r7
        L37:
            if (r8 == 0) goto Lba
            android.os.Bundle r8 = new android.os.Bundle
            if (r5 == 0) goto L42
            r8.<init>(r5)
        L40:
            r14 = r8
            goto L46
        L42:
            r8.<init>()
            goto L40
        L46:
            p000.C2514wG.m10459Y(r1, r14, r7)
            if (r2 == 0) goto L64
            java.lang.String r5 = r2.f3421a
            if (r5 == 0) goto L54
            java.lang.String r8 = "_pn"
            r14.putString(r8, r5)
        L54:
            java.lang.String r5 = r2.f3422b
            if (r5 == 0) goto L5d
            java.lang.String r8 = "_pc"
            r14.putString(r8, r5)
        L5d:
            java.lang.String r5 = "_pi"
            long r8 = r2.f3423c
            r14.putLong(r5, r8)
        L64:
            r8 = 0
            if (r6 == 0) goto L7d
            RE r2 = r15.mo3789u()
            dF r2 = r2.f2364f
            long r10 = r2.m7311a(r3)
            int r2 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r2 <= 0) goto L7d
            wG r2 = r15.mo352j()
            r2.m10488M(r14, r10)
        L7d:
            xq r2 = r15.mo347e()
            boolean r2 = r2.m10811Z()
            if (r2 != 0) goto L8e
            java.lang.String r2 = "_mst"
            r10 = 1
            r14.putLong(r2, r10)
        L8e:
            boolean r2 = r1.f3425e
            if (r2 == 0) goto L96
            java.lang.String r2 = "app"
        L94:
            r10 = r2
            goto L99
        L96:
            java.lang.String r2 = "auto"
            goto L94
        L99:
            M4 r2 = r15.mo345b()
            long r11 = r2.mo2815a()
            boolean r2 = r1.f3425e
            r20 = r11
            if (r2 == 0) goto Laf
            long r11 = r1.f3426f
            int r2 = (r11 > r8 ? 1 : (r11 == r8 ? 0 : -1))
            if (r2 == 0) goto Laf
            r12 = r11
            goto Lb1
        Laf:
            r12 = r20
        Lb1:
            aB r9 = r15.mo3786r()
            java.lang.String r11 = "_vs"
            r9.m5151S(r10, r11, r12, r14)
        Lba:
            if (r6 == 0) goto Lc1
            ZC r2 = r0.f3201e
            r15.m4697O(r2, r7, r3)
        Lc1:
            r0.f3201e = r1
            boolean r2 = r1.f3425e
            if (r2 == 0) goto Lc9
            r0.f3206j = r1
        Lc9:
            oD r2 = r15.mo3788t()
            r2.m8867Q(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1070XC.m4696N(ZC, ZC, long, boolean, android.os.Bundle):void");
    }

    public final void m4697O(C1162ZC c1162zc, boolean z, long j) {
        mo3783o().m4848v(mo345b().mo2817c());
        if (!mo3789u().m3780E(c1162zc != null && c1162zc.f3424d, z, j) || c1162zc == null) {
            return;
        }
        c1162zc.f3424d = false;
    }

    public final C1162ZC m4698P() {
        return this.f3199c;
    }

    public final void m4699Q(Activity activity) {
        synchronized (this.f3208l) {
            this.f3207k = false;
            this.f3204h = true;
        }
        long jMo2817c = mo345b().mo2817c();
        if (!mo347e().m10811Z()) {
            this.f3199c = null;
            mo354l().m7374C(new RunnableC1724fD(this, jMo2817c));
        } else {
            C1162ZC c1162zcM4702T = m4702T(activity);
            this.f3200d = this.f3199c;
            this.f3199c = null;
            mo354l().m7374C(new RunnableC2004lD(this, c1162zcM4702T, jMo2817c));
        }
    }

    public final void m4700R(Activity activity, Bundle bundle) {
        C1162ZC c1162zc;
        if (!mo347e().m10811Z() || bundle == null || (c1162zc = (C1162ZC) this.f3202f.get(activity)) == null) {
            return;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putLong("id", c1162zc.f3423c);
        bundle2.putString("name", c1162zc.f3421a);
        bundle2.putString("referrer_name", c1162zc.f3422b);
        bundle.putBundle("com.google.app_measurement.screen_service", bundle2);
    }

    public final void m4701S(Activity activity) {
        synchronized (this.f3208l) {
            this.f3207k = true;
            if (activity != this.f3203g) {
                synchronized (this.f3208l) {
                    this.f3203g = activity;
                    this.f3204h = false;
                }
                if (mo347e().m10811Z()) {
                    this.f3205i = null;
                    mo354l().m7374C(new RunnableC1911jD(this));
                }
            }
        }
        if (!mo347e().m10811Z()) {
            this.f3199c = this.f3205i;
            mo354l().m7374C(new RunnableC1818hD(this));
        } else {
            m4694H(activity, m4702T(activity), false);
            C1092Xp c1092XpMo3783o = mo3783o();
            c1092XpMo3783o.mo354l().m7374C(new RunnableC0776Qu(c1092XpMo3783o, c1092XpMo3783o.mo345b().mo2817c()));
        }
    }

    public final C1162ZC m4702T(Activity activity) {
        AbstractC1085Xi.m4801j(activity);
        C1162ZC c1162zc = (C1162ZC) this.f3202f.get(activity);
        if (c1162zc == null) {
            C1162ZC c1162zc2 = new C1162ZC(null, m4689B(activity.getClass(), "Activity"), mo352j().m10497R0());
            this.f3202f.put(activity, c1162zc2);
            c1162zc = c1162zc2;
        }
        return this.f3205i != null ? this.f3205i : c1162zc;
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
