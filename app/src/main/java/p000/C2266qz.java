package p000;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C2266qz implements InterfaceC0241FA {

    public static volatile C2266qz f6823I;

    public volatile Boolean f6824A;

    public Boolean f6825B;

    public Boolean f6826C;

    public volatile boolean f6827D;

    public int f6828E;

    public int f6829F;

    public final long f6831H;

    public final Context f6832a;

    public final String f6833b;

    public final String f6834c;

    public final String f6835d;

    public final boolean f6836e;

    public final C1747fq f6837f;

    public final C2579xq f6838g;

    public final C1755fy f6839h;

    public final C2356sx f6840i;

    public final C1662dz f6841j;

    public final C0796RE f6842k;

    public final C2514wG f6843l;

    public final C2264qx f6844m;

    public final InterfaceC0557M4 f6845n;

    public final C1070XC f6846o;

    public final C1207aB f6847p;

    public final C1092Xp f6848q;

    public final C0611NC f6849r;

    public final String f6850s;

    public C2079mx f6851t;

    public C2142oD f6852u;

    public C0083Br f6853v;

    public C1801gx f6854w;

    public Boolean f6856y;

    public long f6857z;

    public boolean f6855x = false;

    public AtomicInteger f6830G = new AtomicInteger(0);

    public C2266qz(C0976VA c0976va) {
        Bundle bundle;
        boolean z = false;
        AbstractC1085Xi.m4801j(c0976va);
        C1747fq c1747fq = new C1747fq(c0976va.f2944a);
        this.f6837f = c1747fq;
        AbstractC0318Gw.f993a = c1747fq;
        Context context = c0976va.f2944a;
        this.f6832a = context;
        this.f6833b = c0976va.f2945b;
        this.f6834c = c0976va.f2946c;
        this.f6835d = c0976va.f2947d;
        this.f6836e = c0976va.f2951h;
        this.f6824A = c0976va.f2948e;
        this.f6850s = c0976va.f2953j;
        this.f6827D = true;
        C0086Bu c0086Bu = c0976va.f2950g;
        if (c0086Bu != null && (bundle = c0086Bu.f222r) != null) {
            Object obj = bundle.get("measurementEnabled");
            if (obj instanceof Boolean) {
                this.f6825B = (Boolean) obj;
            }
            Object obj2 = c0086Bu.f222r.get("measurementDeactivated");
            if (obj2 instanceof Boolean) {
                this.f6826C = (Boolean) obj2;
            }
        }
        AbstractC2001lA.m8365l(context);
        InterfaceC0557M4 interfaceC0557M4M4014d = C0835S7.m4014d();
        this.f6845n = interfaceC0557M4M4014d;
        Long l = c0976va.f2952i;
        this.f6831H = l != null ? l.longValue() : interfaceC0557M4M4014d.mo2815a();
        this.f6838g = new C2579xq(this);
        C1755fy c1755fy = new C1755fy(this);
        c1755fy.m10437q();
        this.f6839h = c1755fy;
        C2356sx c2356sx = new C2356sx(this);
        c2356sx.m10437q();
        this.f6840i = c2356sx;
        C2514wG c2514wG = new C2514wG(this);
        c2514wG.m10437q();
        this.f6843l = c2514wG;
        this.f6844m = new C2264qx(new C1308bB(c0976va, this));
        this.f6848q = new C1092Xp(this);
        C1070XC c1070xc = new C1070XC(this);
        c1070xc.m2547w();
        this.f6846o = c1070xc;
        C1207aB c1207aB = new C1207aB(this);
        c1207aB.m2547w();
        this.f6847p = c1207aB;
        C0796RE c0796re = new C0796RE(this);
        c0796re.m2547w();
        this.f6842k = c0796re;
        C0611NC c0611nc = new C0611NC(this);
        c0611nc.m10437q();
        this.f6849r = c0611nc;
        C1662dz c1662dz = new C1662dz(this);
        c1662dz.m10437q();
        this.f6841j = c1662dz;
        C0086Bu c0086Bu2 = c0976va.f2950g;
        if (c0086Bu2 != null && c0086Bu2.f217m != 0) {
            z = true;
        }
        boolean z2 = !z;
        if (context.getApplicationContext() instanceof Application) {
            m9226H().m5156V0(z2);
        } else {
            mo349g().m9623L().m10616a("Application context is not an Application");
        }
        c1662dz.m7374C(new RunnableC2358sz(this, c0976va));
    }

    public static C2266qz m9214c(Context context, C0086Bu c0086Bu, Long l) {
        Bundle bundle;
        if (c0086Bu != null && (c0086Bu.f220p == null || c0086Bu.f221q == null)) {
            c0086Bu = new C0086Bu(c0086Bu.f216l, c0086Bu.f217m, c0086Bu.f218n, c0086Bu.f219o, null, null, c0086Bu.f222r, null);
        }
        AbstractC1085Xi.m4801j(context);
        AbstractC1085Xi.m4801j(context.getApplicationContext());
        if (f6823I == null) {
            synchronized (C2266qz.class) {
                try {
                    if (f6823I == null) {
                        f6823I = new C2266qz(new C0976VA(context, c0086Bu, l));
                    }
                } finally {
                }
            }
        } else if (c0086Bu != null && (bundle = c0086Bu.f222r) != null && bundle.containsKey("dataCollectionDefaultEnabled")) {
            AbstractC1085Xi.m4801j(f6823I);
            f6823I.m9239m(c0086Bu.f222r.getBoolean("dataCollectionDefaultEnabled"));
        }
        AbstractC1085Xi.m4801j(f6823I);
        return f6823I;
    }

    public static void m9215h(AbstractC0501Kv abstractC0501Kv) {
        if (abstractC0501Kv == null) {
            throw new IllegalStateException("Component not created");
        }
        if (abstractC0501Kv.m2550z()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(abstractC0501Kv.getClass()));
    }

    public static void m9216i(C2266qz c2266qz, C0976VA c0976va) {
        c2266qz.mo354l().mo356n();
        C0083Br c0083Br = new C0083Br(c2266qz);
        c0083Br.m10437q();
        c2266qz.f6853v = c0083Br;
        C1801gx c1801gx = new C1801gx(c2266qz, c0976va.f2949f);
        c1801gx.m2547w();
        c2266qz.f6854w = c1801gx;
        C2079mx c2079mx = new C2079mx(c2266qz);
        c2079mx.m2547w();
        c2266qz.f6851t = c2079mx;
        C2142oD c2142oD = new C2142oD(c2266qz);
        c2142oD.m2547w();
        c2266qz.f6852u = c2142oD;
        c2266qz.f6843l.m10438r();
        c2266qz.f6839h.m10438r();
        c2266qz.f6854w.m2548x();
        c2266qz.mo349g().m9621J().m10617b("App measurement initialized, version", 102001L);
        c2266qz.mo349g().m9621J().m10616a("To enable debug logging run: adb shell setprop log.tag.FA VERBOSE");
        String strM7770F = c1801gx.m7770F();
        if (TextUtils.isEmpty(c2266qz.f6833b)) {
            if (c2266qz.m9230L().m10480E0(strM7770F, c2266qz.f6838g.m10809X())) {
                c2266qz.mo349g().m9621J().m10616a("Faster debug mode event logging enabled. To disable, run:\n  adb shell setprop debug.firebase.analytics.app .none.");
            } else {
                c2266qz.mo349g().m9621J().m10616a("To enable faster debug mode event logging run:\n  adb shell setprop debug.firebase.analytics.app " + strM7770F);
            }
        }
        c2266qz.mo349g().m9617F().m10616a("Debug-level message logging enabled");
        if (c2266qz.f6828E != c2266qz.f6830G.get()) {
            c2266qz.mo349g().m9618G().m10618c("Not all components initialized", Integer.valueOf(c2266qz.f6828E), Integer.valueOf(c2266qz.f6830G.get()));
        }
        c2266qz.f6855x = true;
    }

    public static void m9217j(AbstractC2508wA abstractC2508wA) {
        if (abstractC2508wA == null) {
            throw new IllegalStateException("Component not created");
        }
        if (abstractC2508wA.m10439s()) {
            return;
        }
        throw new IllegalStateException("Component not initialized: " + String.valueOf(abstractC2508wA.getClass()));
    }

    public static void m9218k(AbstractC2600yA abstractC2600yA) {
        if (abstractC2600yA == null) {
            throw new IllegalStateException("Component not created");
        }
    }

    public final C0083Br m9219A() {
        m9217j(this.f6853v);
        return this.f6853v;
    }

    public final C1801gx m9220B() {
        m9215h(this.f6854w);
        return this.f6854w;
    }

    public final C2079mx m9221C() {
        m9215h(this.f6851t);
        return this.f6851t;
    }

    public final C2264qx m9222D() {
        return this.f6844m;
    }

    public final C2356sx m9223E() {
        C2356sx c2356sx = this.f6840i;
        if (c2356sx == null || !c2356sx.m10439s()) {
            return null;
        }
        return this.f6840i;
    }

    public final C1755fy m9224F() {
        m9218k(this.f6839h);
        return this.f6839h;
    }

    public final C1662dz m9225G() {
        return this.f6841j;
    }

    public final C1207aB m9226H() {
        m9215h(this.f6847p);
        return this.f6847p;
    }

    public final C1070XC m9227I() {
        m9215h(this.f6846o);
        return this.f6846o;
    }

    public final C2142oD m9228J() {
        m9215h(this.f6852u);
        return this.f6852u;
    }

    public final C0796RE m9229K() {
        m9215h(this.f6842k);
        return this.f6842k;
    }

    public final C2514wG m9230L() {
        m9218k(this.f6843l);
        return this.f6843l;
    }

    public final String m9231M() {
        return this.f6833b;
    }

    public final String m9232N() {
        return this.f6834c;
    }

    public final String m9233O() {
        return this.f6835d;
    }

    public final String m9234P() {
        return this.f6850s;
    }

    public final void m9235Q() {
        throw new IllegalStateException("Unexpected call on client side");
    }

    public final void m9236R() {
        this.f6830G.incrementAndGet();
    }

    @Override
    public final Context mo344a() {
        return this.f6832a;
    }

    @Override
    public final InterfaceC0557M4 mo345b() {
        return this.f6845n;
    }

    @Override
    public final C1747fq mo346d() {
        return this.f6837f;
    }

    public final void m9237e(String str, int i, Throwable th, byte[] bArr, Map map) {
        if ((i != 200 && i != 204 && i != 304) || th != null) {
            mo349g().m9623L().m10618c("Network Request for Deferred Deep Link failed. response, exception", Integer.valueOf(i), th);
            return;
        }
        m9224F().f5571v.m8427a(true);
        if (bArr == null || bArr.length == 0) {
            mo349g().m9617F().m10616a("Deferred Deep Link response empty.");
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(new String(bArr));
            String strOptString = jSONObject.optString("deeplink", "");
            if (TextUtils.isEmpty(strOptString)) {
                mo349g().m9617F().m10616a("Deferred Deep Link is empty.");
                return;
            }
            String strOptString2 = jSONObject.optString("gclid", "");
            String strOptString3 = jSONObject.optString("gbraid", "");
            String strOptString4 = jSONObject.optString("gad_source", "");
            double dOptDouble = jSONObject.optDouble("timestamp", 0.0d);
            Bundle bundle = new Bundle();
            if (C0340HH.m1558a() && this.f6838g.m10818t(AbstractC0818Rr.f2468T0)) {
                if (!m9230L().m10489M0(strOptString)) {
                    mo349g().m9623L().m10619d("Deferred Deep Link validation failed. gclid, gbraid, deep link", strOptString2, strOptString3, strOptString);
                    return;
                }
                if (!TextUtils.isEmpty(strOptString3)) {
                    bundle.putString("gbraid", strOptString3);
                }
                if (!TextUtils.isEmpty(strOptString4)) {
                    bundle.putString("gad_source", strOptString4);
                }
            } else if (!m9230L().m10489M0(strOptString)) {
                mo349g().m9623L().m10618c("Deferred Deep Link validation failed. gclid, deep link", strOptString2, strOptString);
                return;
            }
            if (C0340HH.m1558a()) {
                this.f6838g.m10818t(AbstractC0818Rr.f2468T0);
            }
            bundle.putString("gclid", strOptString2);
            bundle.putString("_cis", "ddp");
            this.f6847p.m5166a1("auto", "_cmp", bundle);
            C2514wG c2514wGM9230L = m9230L();
            if (TextUtils.isEmpty(strOptString) || !c2514wGM9230L.m10511i0(strOptString, dOptDouble)) {
                return;
            }
            c2514wGM9230L.mo344a().sendBroadcast(new Intent("android.google.analytics.action.DEEPLINK_ACTION"));
        } catch (JSONException e) {
            mo349g().m9618G().m10617b("Failed to parse the Deferred Deep Link response. exception", e);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:64:0x015f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x01ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m9238f(C0086Bu r13) {
        /*
            Method dump skipped, instructions count: 1277
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2266qz.m9238f(Bu):void");
    }

    @Override
    public final C2356sx mo349g() {
        m9217j(this.f6840i);
        return this.f6840i;
    }

    @Override
    public final C1662dz mo354l() {
        m9217j(this.f6841j);
        return this.f6841j;
    }

    public final void m9239m(boolean z) {
        this.f6824A = Boolean.valueOf(z);
    }

    public final void m9240n() {
        this.f6828E++;
    }

    public final boolean m9241o() {
        return this.f6824A != null && this.f6824A.booleanValue();
    }

    public final boolean m9242p() {
        return m9250x() == 0;
    }

    public final boolean m9243q() {
        mo354l().mo356n();
        return this.f6827D;
    }

    public final boolean m9244r() {
        return TextUtils.isEmpty(this.f6833b);
    }

    public final boolean m9245s() {
        if (!this.f6855x) {
            throw new IllegalStateException("AppMeasurement is not initialized");
        }
        mo354l().mo356n();
        Boolean bool = this.f6856y;
        if (bool == null || this.f6857z == 0 || (bool != null && !bool.booleanValue() && Math.abs(this.f6845n.mo2817c() - this.f6857z) > 1000)) {
            this.f6857z = this.f6845n.mo2817c();
            boolean z = true;
            Boolean boolValueOf = Boolean.valueOf(m9230L().m10482F0("android.permission.INTERNET") && m9230L().m10482F0("android.permission.ACCESS_NETWORK_STATE") && (C2670zp.m11048a(this.f6832a).m10891d() || this.f6838g.m10819u() || (C2514wG.m10463d0(this.f6832a) && C2514wG.m10464e0(this.f6832a, false))));
            this.f6856y = boolValueOf;
            if (boolValueOf.booleanValue()) {
                if (!m9230L().m10513k0(m9220B().m7771G(), m9220B().m7769E()) && TextUtils.isEmpty(m9220B().m7769E())) {
                    z = false;
                }
                this.f6856y = Boolean.valueOf(z);
            }
        }
        return this.f6856y.booleanValue();
    }

    public final boolean m9246t() {
        return this.f6836e;
    }

    public final boolean m9247u() {
        mo354l().mo356n();
        m9217j(m9248v());
        String strM7770F = m9220B().m7770F();
        Pair pairM7676u = m9224F().m7676u(strM7770F);
        if (!this.f6838g.m10810Y() || ((Boolean) pairM7676u.second).booleanValue() || TextUtils.isEmpty((CharSequence) pairM7676u.first)) {
            mo349g().m9617F().m10616a("ADID unavailable to retrieve Deferred Deep Link. Skipping");
            return false;
        }
        if (!m9248v().m3310w()) {
            mo349g().m9623L().m10616a("Network is not available for Deferred Deep Link request. Skipping");
            return false;
        }
        StringBuilder sb = new StringBuilder();
        C2142oD c2142oDM9228J = m9228J();
        c2142oDM9228J.mo356n();
        c2142oDM9228J.m2546v();
        if (!c2142oDM9228J.m8885k0() || c2142oDM9228J.mo352j().m10484I0() >= 234200) {
            C0312Gq c0312GqM5181q0 = m9226H().m5181q0();
            Bundle bundle = c0312GqM5181q0 != null ? c0312GqM5181q0.f990l : null;
            if (bundle == null) {
                int i = this.f6829F;
                this.f6829F = i + 1;
                boolean z = i < 10;
                mo349g().m9617F().m10617b("Failed to retrieve DMA consent from the service, " + (z ? "Retrying." : "Skipping.") + " retryCount", Integer.valueOf(this.f6829F));
                return z;
            }
            C0425JA c0425jaM1845h = C0425JA.m1845h(bundle, 100);
            sb.append("&gcs=");
            sb.append(c0425jaM1845h.m1866y());
            C1981kr c1981krM8308c = C1981kr.m8308c(bundle, 100);
            sb.append("&dma=");
            sb.append(c1981krM8308c.m8314h() == Boolean.FALSE ? 0 : 1);
            if (!TextUtils.isEmpty(c1981krM8308c.m8315i())) {
                sb.append("&dma_cps=");
                sb.append(c1981krM8308c.m8315i());
            }
            int i2 = C1981kr.m8307b(bundle) == Boolean.TRUE ? 0 : 1;
            sb.append("&npa=");
            sb.append(i2);
            mo349g().m9622K().m10617b("Consent query parameters to Bow", sb);
        }
        C2514wG c2514wGM9230L = m9230L();
        m9220B();
        URL urlM10485J = c2514wGM9230L.m10485J(102001L, strM7770F, (String) pairM7676u.first, m9224F().f5572w.m9085a() - 1, sb.toString());
        if (urlM10485J != null) {
            C0611NC c0611ncM9248v = m9248v();
            InterfaceC0519LC interfaceC0519LC = new InterfaceC0519LC() {
                @Override
                public final void mo2649a(String str, int i3, Throwable th, byte[] bArr, Map map) {
                    this.f7611a.m9237e(str, i3, th, bArr, map);
                }
            };
            c0611ncM9248v.mo356n();
            c0611ncM9248v.m10436p();
            AbstractC1085Xi.m4801j(urlM10485J);
            AbstractC1085Xi.m4801j(interfaceC0519LC);
            c0611ncM9248v.mo354l().m7379x(new RunnableC0794RC(c0611ncM9248v, strM7770F, urlM10485J, null, null, interfaceC0519LC));
        }
        return false;
    }

    public final C0611NC m9248v() {
        m9217j(this.f6849r);
        return this.f6849r;
    }

    public final void m9249w(boolean z) {
        mo354l().mo356n();
        this.f6827D = z;
    }

    public final int m9250x() {
        mo354l().mo356n();
        if (this.f6838g.m10812a0()) {
            return 1;
        }
        Boolean bool = this.f6826C;
        if (bool != null && bool.booleanValue()) {
            return 2;
        }
        if (!m9243q()) {
            return 8;
        }
        Boolean boolM7670P = m9224F().m7670P();
        if (boolM7670P != null) {
            return boolM7670P.booleanValue() ? 0 : 3;
        }
        Boolean boolM10797G = this.f6838g.m10797G("firebase_analytics_collection_enabled");
        if (boolM10797G != null) {
            return boolM10797G.booleanValue() ? 0 : 4;
        }
        Boolean bool2 = this.f6825B;
        return bool2 != null ? bool2.booleanValue() ? 0 : 5 : (this.f6824A == null || this.f6824A.booleanValue()) ? 0 : 7;
    }

    public final C1092Xp m9251y() {
        C1092Xp c1092Xp = this.f6848q;
        if (c1092Xp != null) {
            return c1092Xp;
        }
        throw new IllegalStateException("Component not created");
    }

    public final C2579xq m9252z() {
        return this.f6838g;
    }
}
