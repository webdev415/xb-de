package p000;

import android.app.Activity;
import android.app.Application;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

public final class C2602yC implements Application.ActivityLifecycleCallbacks {

    public final C1207aB f8061a;

    public C2602yC(C1207aB c1207aB) {
        this.f8061a = c1207aB;
    }

    public static void m10838a(C2602yC c2602yC, boolean z, Uri uri, String str, String str2) {
        Bundle bundleM10477C;
        Uri uri2;
        boolean z2;
        c2602yC.f8061a.mo356n();
        try {
            C2514wG c2514wGMo352j = c2602yC.f8061a.mo352j();
            boolean z3 = C0340HH.m1558a() && c2602yC.f8061a.mo347e().m10818t(AbstractC0818Rr.f2468T0);
            if (TextUtils.isEmpty(str2)) {
                bundleM10477C = null;
            } else if (str2.contains("gclid") || ((z3 && str2.contains("gbraid")) || str2.contains("utm_campaign") || str2.contains("utm_source") || str2.contains("utm_medium") || str2.contains("utm_id") || str2.contains("dclid") || str2.contains("srsltid") || str2.contains("sfmc_id"))) {
                bundleM10477C = c2514wGMo352j.m10477C(Uri.parse("https://google.com/search?" + str2), z3);
                if (bundleM10477C != null) {
                    bundleM10477C.putString("_cis", "referrer");
                }
            } else {
                c2514wGMo352j.mo349g().m9617F().m10616a("Activity created with data 'referrer' without required params");
                bundleM10477C = null;
            }
            if (z) {
                C2514wG c2514wGMo352j2 = c2602yC.f8061a.mo352j();
                if (C0340HH.m1558a() && c2602yC.f8061a.mo347e().m10818t(AbstractC0818Rr.f2468T0)) {
                    uri2 = uri;
                    z2 = true;
                } else {
                    uri2 = uri;
                    z2 = false;
                }
                Bundle bundleM10477C2 = c2514wGMo352j2.m10477C(uri2, z2);
                if (bundleM10477C2 != null) {
                    bundleM10477C2.putString("_cis", "intent");
                    if (!bundleM10477C2.containsKey("gclid") && bundleM10477C != null && bundleM10477C.containsKey("gclid")) {
                        bundleM10477C2.putString("_cer", String.format("gclid=%s", bundleM10477C.getString("gclid")));
                    }
                    c2602yC.f8061a.m5166a1(str, "_cmp", bundleM10477C2);
                    c2602yC.f8061a.f3516q.m234b(str, bundleM10477C2);
                }
            }
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            c2602yC.f8061a.mo349g().m9617F().m10617b("Activity created with referrer", str2);
            if (c2602yC.f8061a.mo347e().m10818t(AbstractC0818Rr.f2529q0)) {
                if (bundleM10477C != null) {
                    c2602yC.f8061a.m5166a1(str, "_cmp", bundleM10477C);
                    c2602yC.f8061a.f3516q.m234b(str, bundleM10477C);
                } else {
                    c2602yC.f8061a.mo349g().m9617F().m10617b("Referrer does not contain valid parameters", str2);
                }
                c2602yC.f8061a.m5163Z("auto", "_ldl", null, true);
                return;
            }
            if (!str2.contains("gclid") || (!str2.contains("utm_campaign") && !str2.contains("utm_source") && !str2.contains("utm_medium") && !str2.contains("utm_term") && !str2.contains("utm_content"))) {
                c2602yC.f8061a.mo349g().m9617F().m10616a("Activity created with data 'referrer' without required params");
            } else {
                if (TextUtils.isEmpty(str2)) {
                    return;
                }
                c2602yC.f8061a.m5163Z("auto", "_ldl", str2, true);
            }
        } catch (RuntimeException e) {
            c2602yC.f8061a.mo349g().m9618G().m10617b("Throwable caught in handleReferrerForOnActivityCreated", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0049  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onActivityCreated(Activity r9, Bundle r10) {
        /*
            r8 = this;
            aB r0 = r8.f8061a     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            sx r0 = r0.mo349g()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            wx r0 = r0.m9622K()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            java.lang.String r1 = "onActivityCreated"
            r0.m10616a(r1)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            android.content.Intent r0 = r9.getIntent()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r0 != 0) goto L1f
        L15:
            aB r0 = r8.f8061a
            XC r0 = r0.mo3787s()
            r0.m4692F(r9, r10)
            return
        L1f:
            android.net.Uri r1 = r0.getData()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r1 == 0) goto L32
            boolean r2 = r1.isHierarchical()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r2 == 0) goto L32
        L2b:
            r5 = r1
            goto L4b
        L2d:
            r0 = move-exception
            goto L94
        L30:
            r0 = move-exception
            goto L84
        L32:
            android.os.Bundle r1 = r0.getExtras()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r1 == 0) goto L49
            java.lang.String r2 = "com.android.vending.referral_url"
            java.lang.String r1 = r1.getString(r2)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r2 != 0) goto L49
            android.net.Uri r1 = android.net.Uri.parse(r1)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            goto L2b
        L49:
            r1 = 0
            goto L2b
        L4b:
            if (r5 == 0) goto L15
            boolean r1 = r5.isHierarchical()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r1 != 0) goto L54
            goto L15
        L54:
            aB r1 = r8.f8061a     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            r1.mo352j()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            boolean r0 = p000.C2514wG.m10465f0(r0)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r0 == 0) goto L63
            java.lang.String r0 = "gs"
        L61:
            r6 = r0
            goto L66
        L63:
            java.lang.String r0 = "auto"
            goto L61
        L66:
            java.lang.String r0 = "referrer"
            java.lang.String r7 = r5.getQueryParameter(r0)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            if (r10 != 0) goto L71
            r0 = 1
        L6f:
            r4 = r0
            goto L73
        L71:
            r0 = 0
            goto L6f
        L73:
            aB r0 = r8.f8061a     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            dz r0 = r0.mo354l()     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            EC r1 = new EC     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            r2 = r1
            r3 = r8
            r2.<init>(r3, r4, r5, r6, r7)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            r0.m7374C(r1)     // Catch: java.lang.Throwable -> L2d java.lang.RuntimeException -> L30
            goto L15
        L84:
            aB r1 = r8.f8061a     // Catch: java.lang.Throwable -> L2d
            sx r1 = r1.mo349g()     // Catch: java.lang.Throwable -> L2d
            wx r1 = r1.m9618G()     // Catch: java.lang.Throwable -> L2d
            java.lang.String r2 = "Throwable caught in onActivityCreated"
            r1.m10617b(r2, r0)     // Catch: java.lang.Throwable -> L2d
            goto L15
        L94:
            aB r1 = r8.f8061a
            XC r1 = r1.mo3787s()
            r1.m4692F(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2602yC.onActivityCreated(android.app.Activity, android.os.Bundle):void");
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
        this.f8061a.mo3787s().m4691E(activity);
    }

    @Override
    public final void onActivityPaused(Activity activity) {
        this.f8061a.mo3787s().m4699Q(activity);
        C0796RE c0796reMo3789u = this.f8061a.mo3789u();
        c0796reMo3789u.mo354l().m7374C(new RunnableC0980VE(c0796reMo3789u, c0796reMo3789u.mo345b().mo2817c()));
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        C0796RE c0796reMo3789u = this.f8061a.mo3789u();
        c0796reMo3789u.mo354l().m7374C(new RunnableC0751QE(c0796reMo3789u, c0796reMo3789u.mo345b().mo2817c()));
        this.f8061a.mo3787s().m4701S(activity);
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.f8061a.mo3787s().m4700R(activity, bundle);
    }

    @Override
    public final void onActivityStarted(Activity activity) {
    }

    @Override
    public final void onActivityStopped(Activity activity) {
    }
}
