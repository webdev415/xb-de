package p000;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import p000.C0425JA;

public final class C1207aB extends AbstractC0501Kv {

    public C2602yC f3502c;

    public InterfaceC0792RA f3503d;

    public final Set f3504e;

    public boolean f3505f;

    public final AtomicReference f3506g;

    public final Object f3507h;

    public boolean f3508i;

    public int f3509j;

    public AbstractC1795gr f3510k;

    public PriorityQueue f3511l;

    public boolean f3512m;

    public C0425JA f3513n;

    public final AtomicLong f3514o;

    public long f3515p;

    public final C0065BI f3516q;

    public boolean f3517r;

    public AbstractC1795gr f3518s;

    public SharedPreferences.OnSharedPreferenceChangeListener f3519t;

    public AbstractC1795gr f3520u;

    public final InterfaceC2422uG f3521v;

    public C1207aB(C2266qz c2266qz) {
        super(c2266qz);
        this.f3504e = new CopyOnWriteArraySet();
        this.f3507h = new Object();
        this.f3508i = false;
        this.f3509j = 1;
        this.f3517r = true;
        this.f3521v = new C1864iC(this);
        this.f3506g = new AtomicReference();
        this.f3513n = C0425JA.f1295c;
        this.f3515p = -1L;
        this.f3514o = new AtomicLong(0L);
        this.f3516q = new C0065BI(c2266qz);
    }

    public static int m5108C(String str) {
        AbstractC1085Xi.m4795d(str);
        return 25;
    }

    public static int m5110E(C1207aB c1207aB, Throwable th) {
        String message = th.getMessage();
        c1207aB.f3512m = false;
        if (message == null) {
            return 2;
        }
        if (!(th instanceof IllegalStateException) && !message.contains("garbage collected") && !th.getClass().getSimpleName().equals("ServiceUnavailableException")) {
            return (!(th instanceof SecurityException) || message.endsWith("READ_DEVICE_CONFIG")) ? 2 : 3;
        }
        if (message.contains("Background")) {
            c1207aB.f3512m = true;
        }
        return 1;
    }

    public static void m5113T0(C1207aB c1207aB, int i) {
        if (c1207aB.f3510k == null) {
            c1207aB.f3510k = new C0058BB(c1207aB, c1207aB.f8058a);
        }
        c1207aB.f3510k.m7757b(i * 1000);
    }

    public static void m5114U0(C1207aB c1207aB, Bundle bundle) {
        c1207aB.mo356n();
        c1207aB.m2546v();
        AbstractC1085Xi.m4801j(bundle);
        String string = bundle.getString("name");
        String string2 = bundle.getString("origin");
        AbstractC1085Xi.m4795d(string);
        AbstractC1085Xi.m4795d(string2);
        AbstractC1085Xi.m4801j(bundle.get("value"));
        if (!c1207aB.f8058a.m9242p()) {
            c1207aB.mo349g().m9622K().m10616a("Conditional property not set since app measurement is disabled");
            return;
        }
        C2053mG c2053mG = new C2053mG(string, bundle.getLong("triggered_timestamp"), bundle.get("value"), string2);
        try {
            C0635Nr c0635NrM10486K = c1207aB.mo352j().m10486K(bundle.getString("app_id"), bundle.getString("triggered_event_name"), bundle.getBundle("triggered_event_params"), string2, 0L, true, true);
            c1207aB.mo3788t().m8859I(new C2303rq(bundle.getString("app_id"), string2, c2053mG, bundle.getLong("creation_timestamp"), false, bundle.getString("trigger_event_name"), c1207aB.mo352j().m10486K(bundle.getString("app_id"), bundle.getString("timed_out_event_name"), bundle.getBundle("timed_out_event_params"), string2, 0L, true, true), bundle.getLong("trigger_timeout"), c0635NrM10486K, bundle.getLong("time_to_live"), c1207aB.mo352j().m10486K(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), string2, 0L, true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public static void m5117k0(C1207aB c1207aB, Bundle bundle) {
        c1207aB.mo356n();
        c1207aB.m2546v();
        AbstractC1085Xi.m4801j(bundle);
        String strM4795d = AbstractC1085Xi.m4795d(bundle.getString("name"));
        if (!c1207aB.f8058a.m9242p()) {
            c1207aB.mo349g().m9622K().m10616a("Conditional property not cleared since app measurement is disabled");
            return;
        }
        try {
            c1207aB.mo3788t().m8859I(new C2303rq(bundle.getString("app_id"), "", new C2053mG(strM4795d, 0L, null, ""), bundle.getLong("creation_timestamp"), bundle.getBoolean("active"), bundle.getString("trigger_event_name"), null, bundle.getLong("trigger_timeout"), null, bundle.getLong("time_to_live"), c1207aB.mo352j().m10486K(bundle.getString("app_id"), bundle.getString("expired_event_name"), bundle.getBundle("expired_event_params"), "", bundle.getLong("creation_timestamp"), true, true)));
        } catch (IllegalArgumentException unused) {
        }
    }

    public static void m5119m0(C1207aB c1207aB, C0425JA c0425ja, long j, boolean z, boolean z2) {
        c1207aB.mo356n();
        c1207aB.m2546v();
        C0425JA c0425jaM7667M = c1207aB.mo351i().m7667M();
        if (j <= c1207aB.f3515p && C0425JA.m1848l(c0425jaM7667M.m1854b(), c0425ja.m1854b())) {
            c1207aB.mo349g().m9621J().m10617b("Dropped out-of-date consent setting, proposed settings", c0425ja);
            return;
        }
        if (!c1207aB.mo351i().m7656B(c0425ja)) {
            c1207aB.mo349g().m9621J().m10617b("Lower precedence consent source ignored, proposed source", Integer.valueOf(c0425ja.m1854b()));
            return;
        }
        c1207aB.mo349g().m9622K().m10617b("Setting storage consent(FE)", c0425ja);
        c1207aB.f3515p = j;
        if (c1207aB.mo3788t().m8884j0()) {
            c1207aB.mo3788t().m8887p0(z);
        } else {
            c1207aB.mo3788t().m8869U(z);
        }
        if (z2) {
            c1207aB.mo3788t().m8855E(new AtomicReference());
        }
    }

    public static void m5120n0(C1207aB c1207aB, C0425JA c0425ja, C0425JA c0425ja2) {
        if (C0798RG.m3790a() && c1207aB.mo347e().m10818t(AbstractC0818Rr.f2489c1)) {
            return;
        }
        C0425JA.a aVar = C0425JA.a.ANALYTICS_STORAGE;
        C0425JA.a aVar2 = C0425JA.a.AD_STORAGE;
        boolean zM1857n = c0425ja.m1857n(c0425ja2, aVar, aVar2);
        boolean zM1860s = c0425ja.m1860s(c0425ja2, aVar, aVar2);
        if (zM1857n || zM1860s) {
            c1207aB.mo3784p().m7773I();
        }
    }

    @Override
    public final boolean mo2545A() {
        return false;
    }

    public final PriorityQueue m5122A0() {
        if (this.f3511l == null) {
            this.f3511l = new PriorityQueue(Comparator.comparing(new Function() {
                @Override
                public final Object apply(Object obj) {
                    return Long.valueOf(((C1913jF) obj).f5938m);
                }
            }, new Comparator() {
                @Override
                public final int compare(Object obj, Object obj2) {
                    return Long.compare(((Long) obj).longValue(), ((Long) obj2).longValue());
                }
            }));
        }
        return this.f3511l;
    }

    public final void m5123B0() {
        mo356n();
        m2546v();
        if (mo347e().m10818t(AbstractC0818Rr.f2507i1)) {
            C2142oD c2142oDMo3788t = mo3788t();
            c2142oDMo3788t.mo356n();
            c2142oDMo3788t.m2546v();
            if (c2142oDMo3788t.m8885k0() && c2142oDMo3788t.mo352j().m10484I0() < 242600) {
                return;
            }
            mo3788t().m8872X();
        }
    }

    public final void m5124C0() {
        mo356n();
        m2546v();
        if (this.f8058a.m9245s()) {
            Boolean boolM10797G = mo347e().m10797G("google_analytics_deferred_deep_link_enabled");
            if (boolM10797G != null && boolM10797G.booleanValue()) {
                mo349g().m9617F().m10616a("Deferred Deep Link feature enabled.");
                mo354l().m7374C(new Runnable() {
                    @Override
                    public final void run() {
                        this.f6908l.m5127F0();
                    }
                });
            }
            mo3788t().m8873Y();
            this.f3517r = false;
            String strM7671Q = mo351i().m7671Q();
            if (TextUtils.isEmpty(strM7671Q)) {
                return;
            }
            mo348f().m10436p();
            if (strM7671Q.equals(Build.VERSION.RELEASE)) {
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("_po", strM7671Q);
            m5166a1("auto", "_ou", bundle);
        }
    }

    public final void m5125D0() {
        if (!(mo344a().getApplicationContext() instanceof Application) || this.f3502c == null) {
            return;
        }
        ((Application) mo344a().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.f3502c);
    }

    public final void m5126E0() {
        if (C1963kI.m8253a() && mo347e().m10818t(AbstractC0818Rr.f2446I0)) {
            if (mo354l().m7376J()) {
                mo349g().m9618G().m10616a("Cannot get trigger URIs from analytics worker thread");
                return;
            }
            if (C1747fq.m7654a()) {
                mo349g().m9618G().m10616a("Cannot get trigger URIs from main thread");
                return;
            }
            m2546v();
            mo349g().m9622K().m10616a("Getting trigger URIs (FE)");
            final AtomicReference atomicReference = new AtomicReference();
            mo354l().m7377u(atomicReference, 5000L, "get trigger URIs", new Runnable() {
                @Override
                public final void run() {
                    this.f5933l.m5168c0(atomicReference);
                }
            });
            final List list = (List) atomicReference.get();
            if (list == null) {
                mo349g().m9618G().m10616a("Timed out waiting for get trigger URIs");
            } else {
                mo354l().m7374C(new Runnable() {
                    @Override
                    public final void run() {
                        this.f5724l.m5167b0(list);
                    }
                });
            }
        }
    }

    public final void m5127F0() {
        mo356n();
        if (mo351i().f5571v.m8428b()) {
            mo349g().m9617F().m10616a("Deferred Deep Link already retrieved. Not fetching again.");
            return;
        }
        long jM9085a = mo351i().f5572w.m9085a();
        mo351i().f5572w.m9086b(1 + jM9085a);
        if (jM9085a >= 5) {
            mo349g().m9623L().m10616a("Permanently failed to retrieve Deferred Deep Link. Reached maximum retries.");
            mo351i().f5571v.m8427a(true);
        } else {
            if (this.f3518s == null) {
                this.f3518s = new C1208aC(this, this.f8058a);
            }
            this.f3518s.m7757b(0L);
        }
    }

    public final ArrayList m5128G(String str, String str2) {
        if (mo354l().m7376J()) {
            mo349g().m9618G().m10616a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        }
        if (C1747fq.m7654a()) {
            mo349g().m9618G().m10616a("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        this.f8058a.mo354l().m7377u(atomicReference, 5000L, "get conditional user properties", new RunnableC1770gC(this, atomicReference, null, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return C2514wG.m10471t0(list);
        }
        mo349g().m9618G().m10617b("Timed out waiting for get conditional user properties", null);
        return new ArrayList<>();
    }

    public final void m5129G0() {
        mo356n();
        mo349g().m9617F().m10616a("Handle tcf update.");
        C1726fF c1726fFM7571d = C1726fF.m7571d(mo351i().m7662H());
        mo349g().m9622K().m10617b("Tcf preferences read", c1726fFM7571d);
        if (mo351i().m7657C(c1726fFM7571d)) {
            Bundle bundleM7573b = c1726fFM7571d.m7573b();
            mo349g().m9622K().m10617b("Consent generated from Tcf", bundleM7573b);
            if (bundleM7573b != Bundle.EMPTY) {
                m5141N(bundleM7573b, -30, mo345b().mo2815a());
            }
            Bundle bundle = new Bundle();
            bundle.putString("_tcfd", c1726fFM7571d.m7574e());
            m5166a1("auto", "_tcf", bundle);
        }
    }

    public final Map m5130H(String str, String str2, boolean z) {
        C2540wx c2540wxM9618G;
        String str3;
        if (mo354l().m7376J()) {
            c2540wxM9618G = mo349g().m9618G();
            str3 = "Cannot get user properties from analytics worker thread";
        } else {
            if (!C1747fq.m7654a()) {
                AtomicReference atomicReference = new AtomicReference();
                this.f8058a.mo354l().m7377u(atomicReference, 5000L, "get user properties", new RunnableC1676eC(this, atomicReference, null, str, str2, z));
                List<C2053mG> list = (List) atomicReference.get();
                if (list == null) {
                    mo349g().m9618G().m10617b("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                    return Collections.emptyMap();
                }
                C2453v1 c2453v1 = new C2453v1(list.size());
                for (C2053mG c2053mG : list) {
                    Object objM8448d = c2053mG.m8448d();
                    if (objM8448d != null) {
                        c2453v1.put(c2053mG.f6158m, objM8448d);
                    }
                }
                return c2453v1;
            }
            c2540wxM9618G = mo349g().m9618G();
            str3 = "Cannot get user properties from main thread";
        }
        c2540wxM9618G.m10616a(str3);
        return Collections.emptyMap();
    }

    public final void m5131H0() {
        C1913jF c1913jF;
        AbstractC0578Mg abstractC0578MgM10499S0;
        mo356n();
        this.f3512m = false;
        if (m5122A0().isEmpty() || this.f3508i || (c1913jF = (C1913jF) m5122A0().poll()) == null || (abstractC0578MgM10499S0 = mo352j().m10499S0()) == null) {
            return;
        }
        this.f3508i = true;
        mo349g().m9622K().m10617b("Registering trigger URI", c1913jF.f5937l);
        InterfaceFutureC0852Sf interfaceFutureC0852SfMo2869c = abstractC0578MgM10499S0.mo2869c(Uri.parse(c1913jF.f5937l));
        if (interfaceFutureC0852SfMo2869c == null) {
            this.f3508i = false;
            m5122A0().add(c1913jF);
            return;
        }
        if (!mo347e().m10818t(AbstractC0818Rr.f2456N0)) {
            SparseArray sparseArrayM7665K = mo351i().m7665K();
            sparseArrayM7665K.put(c1913jF.f5939n, Long.valueOf(c1913jF.f5938m));
            mo351i().m7677v(sparseArrayM7665K);
        }
        AbstractC2427uc.m10008a(interfaceFutureC0852SfMo2869c, new C0150DB(this, c1913jF), new ExecutorC2555xB(this));
    }

    public final void m5132I(long j) {
        m5164Z0(null);
        mo354l().m7374C(new RunnableC1115YB(this, j));
    }

    public final void m5133I0() {
        mo356n();
        mo349g().m9617F().m10616a("Register tcfPrefChangeListener.");
        if (this.f3519t == null) {
            this.f3520u = new C0610NB(this, this.f8058a);
            this.f3519t = new SharedPreferences.OnSharedPreferenceChangeListener() {
                @Override
                public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String str) {
                    this.f7657a.m5138L(sharedPreferences, str);
                }
            };
        }
        mo351i().m7662H().registerOnSharedPreferenceChangeListener(this.f3519t);
    }

    public final void m5134J(long j, boolean z) {
        mo356n();
        m2546v();
        mo349g().m9617F().m10616a("Resetting analytics data (FE)");
        C0796RE c0796reMo3789u = mo3789u();
        c0796reMo3789u.mo356n();
        c0796reMo3789u.f2364f.m7312b();
        mo3784p().m7773I();
        boolean zM9242p = this.f8058a.m9242p();
        C1755fy c1755fyMo351i = mo351i();
        c1755fyMo351i.f5556g.m9086b(j);
        if (!TextUtils.isEmpty(c1755fyMo351i.mo351i().f5573x.m10620a())) {
            c1755fyMo351i.f5573x.m10621b(null);
        }
        c1755fyMo351i.f5567r.m9086b(0L);
        c1755fyMo351i.f5568s.m9086b(0L);
        if (!c1755fyMo351i.mo347e().m10812a0()) {
            c1755fyMo351i.m7661G(!zM9242p);
        }
        c1755fyMo351i.f5574y.m10621b(null);
        c1755fyMo351i.f5575z.m9086b(0L);
        c1755fyMo351i.f5551A.m8226b(null);
        if (z) {
            mo3788t().m8878d0();
        }
        mo3789u().f2363e.m7818a();
        this.f3517r = !zM9242p;
    }

    public final boolean m5135J0() {
        return this.f3512m;
    }

    public final void m5136K(Intent intent) {
        if (C2470vI.m10339a() && mo347e().m10818t(AbstractC0818Rr.f2545y0)) {
            Uri data = intent.getData();
            if (data == null) {
                mo349g().m9621J().m10616a("Activity intent has no data. Preview Mode was not enabled.");
                return;
            }
            String queryParameter = data.getQueryParameter("sgtm_debug_enable");
            if (queryParameter == null || !queryParameter.equals("1")) {
                mo349g().m9621J().m10616a("Preview Mode was not enabled.");
                mo347e().m10803N(null);
                return;
            }
            String queryParameter2 = data.getQueryParameter("sgtm_preview_key");
            if (TextUtils.isEmpty(queryParameter2)) {
                return;
            }
            mo349g().m9621J().m10617b("Preview Mode was enabled. Using the sgtmPreviewKey: ", queryParameter2);
            mo347e().m10803N(queryParameter2);
        }
    }

    public final void m5137K0() {
        mo356n();
        String strM10620a = mo351i().f5564o.m10620a();
        if (strM10620a != null) {
            if ("unset".equals(strM10620a)) {
                m5161Y("app", "_npa", null, mo345b().mo2815a());
            } else {
                m5161Y("app", "_npa", Long.valueOf("true".equals(strM10620a) ? 1L : 0L), mo345b().mo2815a());
            }
        }
        if (!this.f8058a.m9242p() || !this.f3517r) {
            mo349g().m9617F().m10616a("Updating Scion state (FE)");
            mo3788t().m8880f0();
        } else {
            mo349g().m9617F().m10616a("Recording app launch after enabling measurement for the first time (FE)");
            m5124C0();
            mo3789u().f2363e.m7818a();
            mo354l().m7374C(new RunnableC0426JB(this));
        }
    }

    public final void m5138L(SharedPreferences sharedPreferences, String str) {
        if ("IABTCF_TCString".equals(str)) {
            mo349g().m9622K().m10616a("IABTCF_TCString change picked up in listener.");
            ((AbstractC1795gr) AbstractC1085Xi.m4801j(this.f3520u)).m7757b(500L);
        }
    }

    public final void m5139M(Bundle bundle) {
        Bundle bundleM5177g1 = bundle.isEmpty() ? bundle : m5177g1(bundle);
        mo351i().f5551A.m8226b(bundleM5177g1);
        if (!bundle.isEmpty() || mo347e().m10818t(AbstractC0818Rr.f2513k1)) {
            mo3788t().m8854C(bundleM5177g1);
        }
    }

    public final void m5140M0(long j) {
        m5134J(j, true);
    }

    public final void m5141N(Bundle bundle, int i, long j) {
        m2546v();
        String strM1841d = C0425JA.m1841d(bundle);
        if (strM1841d != null) {
            mo349g().m9624M().m10617b("Ignoring invalid consent setting", strM1841d);
            mo349g().m9624M().m10616a("Valid consent values are 'granted', 'denied'");
        }
        boolean zM7376J = mo354l().m7376J();
        C0425JA c0425jaM1845h = C0425JA.m1845h(bundle, i);
        if (c0425jaM1845h.m1853C()) {
            m5176g0(c0425jaM1845h, j, zM7376J);
        }
        C1981kr c1981krM8308c = C1981kr.m8308c(bundle, i);
        if (c1981krM8308c.m8317k()) {
            m5170d0(c1981krM8308c, zM7376J);
        }
        Boolean boolM8307b = C1981kr.m8307b(bundle);
        if (boolM8307b != null) {
            m5163Z(i == -30 ? "tcf" : "app", "allow_personalized_ads", boolM8307b.toString(), false);
        }
    }

    public final void m5142N0(Bundle bundle) {
        if (!bundle.isEmpty()) {
            bundle = m5177g1(bundle);
        }
        mo351i().f5551A.m8226b(bundle);
        C2142oD c2142oDMo3788t = mo3788t();
        c2142oDMo3788t.mo356n();
        c2142oDMo3788t.m2546v();
        if (c2142oDMo3788t.m8885k0() && c2142oDMo3788t.mo352j().m10484I0() < 243100) {
            return;
        }
        mo3788t().m8886o0(bundle);
    }

    public final void m5143O(Bundle bundle, long j) {
        if (TextUtils.isEmpty(mo3784p().m7771G())) {
            m5141N(bundle, 0, j);
        } else {
            mo349g().m9624M().m10616a("Using developer consent only; google app id found");
        }
    }

    public final void m5144O0(Bundle bundle, long j) {
        AbstractC1085Xi.m4801j(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            mo349g().m9623L().m10616a("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        AbstractC1085Xi.m4801j(bundle2);
        AbstractC0011AA.m66a(bundle2, "app_id", String.class, null);
        AbstractC0011AA.m66a(bundle2, "origin", String.class, null);
        AbstractC0011AA.m66a(bundle2, "name", String.class, null);
        AbstractC0011AA.m66a(bundle2, "value", Object.class, null);
        AbstractC0011AA.m66a(bundle2, "trigger_event_name", String.class, null);
        AbstractC0011AA.m66a(bundle2, "trigger_timeout", Long.class, 0L);
        AbstractC0011AA.m66a(bundle2, "timed_out_event_name", String.class, null);
        AbstractC0011AA.m66a(bundle2, "timed_out_event_params", Bundle.class, null);
        AbstractC0011AA.m66a(bundle2, "triggered_event_name", String.class, null);
        AbstractC0011AA.m66a(bundle2, "triggered_event_params", Bundle.class, null);
        AbstractC0011AA.m66a(bundle2, "time_to_live", Long.class, 0L);
        AbstractC0011AA.m66a(bundle2, "expired_event_name", String.class, null);
        AbstractC0011AA.m66a(bundle2, "expired_event_params", Bundle.class, null);
        AbstractC1085Xi.m4795d(bundle2.getString("name"));
        AbstractC1085Xi.m4795d(bundle2.getString("origin"));
        AbstractC1085Xi.m4801j(bundle2.get("value"));
        bundle2.putLong("creation_timestamp", j);
        String string = bundle2.getString("name");
        Object obj = bundle2.get("value");
        if (mo352j().m10517r0(string) != 0) {
            mo349g().m9618G().m10617b("Invalid conditional user property name", mo350h().m9213g(string));
            return;
        }
        if (mo352j().m10522w(string, obj) != 0) {
            mo349g().m9618G().m10618c("Invalid conditional user property value", mo350h().m9213g(string), obj);
            return;
        }
        Object objM10476A0 = mo352j().m10476A0(string, obj);
        if (objM10476A0 == null) {
            mo349g().m9618G().m10618c("Unable to normalize conditional user property value", mo350h().m9213g(string), obj);
            return;
        }
        AbstractC0011AA.m67b(bundle2, objM10476A0);
        long j2 = bundle2.getLong("trigger_timeout");
        if (!TextUtils.isEmpty(bundle2.getString("trigger_event_name")) && (j2 > 15552000000L || j2 < 1)) {
            mo349g().m9618G().m10618c("Invalid conditional user property timeout", mo350h().m9213g(string), Long.valueOf(j2));
            return;
        }
        long j3 = bundle2.getLong("time_to_live");
        if (j3 > 15552000000L || j3 < 1) {
            mo349g().m9618G().m10618c("Invalid conditional user property time to live", mo350h().m9213g(string), Long.valueOf(j3));
        } else {
            mo354l().m7374C(new RunnableC1630dC(this, bundle2));
        }
    }

    public final void m5145P(Boolean bool) {
        m2546v();
        mo354l().m7374C(new RunnableC2234qC(this, bool));
    }

    public final void m5146P0(String str) {
        if (mo3784p().m7774K(str)) {
            mo3784p().m7773I();
        }
    }

    public final void m5147Q(Boolean bool, boolean z) {
        mo356n();
        m2546v();
        mo349g().m9617F().m10617b("Setting app measurement enabled (FE)", bool);
        mo351i().m7678w(bool);
        if (z) {
            mo351i().m7659E(bool);
        }
        if (this.f8058a.m9243q() || !(bool == null || bool.booleanValue())) {
            m5137K0();
        }
    }

    public final void m5148Q0(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) {
        mo354l().m7374C(new RunnableC0885TB(this, str, str2, j, C2514wG.m10446D(bundle), z, z2, z3, str3));
    }

    public final void m5149R(final String str, long j) {
        if (str != null && TextUtils.isEmpty(str)) {
            this.f8058a.mo349g().m9623L().m10616a("User ID must be non-empty or null");
        } else {
            mo354l().m7374C(new Runnable() {
                @Override
                public final void run() {
                    this.f7190l.m5146P0(str);
                }
            });
            m5165a0(null, "_id", str, true, j);
        }
    }

    public final void m5150R0(String str, String str2, Bundle bundle) {
        m5159X(str, str2, bundle, true, true, mo345b().mo2815a());
    }

    public final void m5151S(String str, String str2, long j, Bundle bundle) {
        mo356n();
        m5153T(str, str2, j, bundle, true, this.f3503d == null || C2514wG.m10452J0(str2), true, null);
    }

    public final void m5152S0(InterfaceC1068XA interfaceC1068XA) {
        m2546v();
        AbstractC1085Xi.m4801j(interfaceC1068XA);
        if (this.f3504e.remove(interfaceC1068XA)) {
            return;
        }
        mo349g().m9623L().m10616a("OnEventListener had not been registered");
    }

    public final void m5153T(String str, String str2, long j, Bundle bundle, boolean z, boolean z2, boolean z3, String str3) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str4;
        ArrayList arrayList;
        long j2;
        int i;
        Object obj;
        int length;
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(bundle);
        mo356n();
        m2546v();
        if (!this.f8058a.m9242p()) {
            mo349g().m9617F().m10616a("Event not sent since app measurement is disabled");
            return;
        }
        List listM7772H = mo3784p().m7772H();
        if (listM7772H != null && !listM7772H.contains(str2)) {
            mo349g().m9617F().m10618c("Dropping non-safelisted event. event name, origin", str2, str);
            return;
        }
        if (!this.f3505f) {
            this.f3505f = true;
            try {
                try {
                    (!this.f8058a.m9246t() ? Class.forName("com.google.android.gms.tagmanager.TagManagerService", true, mo344a().getClassLoader()) : Class.forName("com.google.android.gms.tagmanager.TagManagerService")).getDeclaredMethod("initialize", Context.class).invoke(null, mo344a());
                } catch (Exception e) {
                    mo349g().m9623L().m10617b("Failed to invoke Tag Manager's initialize() method", e);
                }
            } catch (ClassNotFoundException unused) {
                mo349g().m9621J().m10616a("Tag Manager is not found and thus will not be used");
            }
        }
        if ("_cmp".equals(str2) && bundle.containsKey("gclid")) {
            m5161Y("auto", "_lgclid", bundle.getString("gclid"), mo345b().mo2815a());
        }
        if (z && C2514wG.m10455N0(str2)) {
            mo352j().m10490N(bundle, mo351i().f5551A.m8225a());
        }
        if (!z3 && !"_iap".equals(str2)) {
            C2514wG c2514wGM9230L = this.f8058a.m9230L();
            int i2 = 2;
            if (c2514wGM9230L.m10478C0("event", str2)) {
                if (!c2514wGM9230L.m10516p0("event", AbstractC0701PA.f2092a, AbstractC0701PA.f2093b, str2)) {
                    i2 = 13;
                } else if (c2514wGM9230L.m10512j0("event", 40, str2)) {
                    i2 = 0;
                }
            }
            if (i2 != 0) {
                mo349g().m9619H().m10617b("Invalid public event name. Event will not be logged (FE)", mo350h().m9209b(str2));
                this.f8058a.m9230L();
                String strM10451I = C2514wG.m10451I(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.f8058a.m9230L();
                C2514wG.m10460Z(this.f3521v, i2, "_ev", strM10451I, length);
                return;
            }
        }
        C1162ZC c1162zcM4690D = mo3787s().m4690D(false);
        if (c1162zcM4690D != null && !bundle.containsKey("_sc")) {
            c1162zcM4690D.f3424d = true;
        }
        C2514wG.m10459Y(c1162zcM4690D, bundle, z && !z3);
        boolean zEquals = "am".equals(str);
        boolean zM10452J0 = C2514wG.m10452J0(str2);
        if (z && this.f3503d != null && !zM10452J0 && !zEquals) {
            mo349g().m9617F().m10618c("Passing event to registered event handler (FE)", mo350h().m9209b(str2), mo350h().m9208a(bundle));
            AbstractC1085Xi.m4801j(this.f3503d);
            this.f3503d.mo3772a(str, str2, bundle, j);
            return;
        }
        if (this.f8058a.m9245s()) {
            int iM10521v = mo352j().m10521v(str2);
            if (iM10521v != 0) {
                mo349g().m9619H().m10617b("Invalid event name. Event will not be logged (FE)", mo350h().m9209b(str2));
                mo352j();
                String strM10451I2 = C2514wG.m10451I(str2, 40, true);
                length = str2 != null ? str2.length() : 0;
                this.f8058a.m9230L();
                C2514wG.m10462a0(this.f3521v, str3, iM10521v, "_ev", strM10451I2, length);
                return;
            }
            String str5 = "_o";
            Bundle bundleM10481F = mo352j().m10481F(str3, str2, bundle, AbstractC1669e5.m7388b("_o", "_sn", "_sc", "_si"), z3);
            AbstractC1085Xi.m4801j(bundleM10481F);
            if (mo3787s().m4690D(false) != null && "_ae".equals(str2)) {
                C1633dF c1633dF = mo3789u().f2364f;
                long jMo2817c = c1633dF.f5286d.mo345b().mo2817c();
                long j3 = jMo2817c - c1633dF.f5284b;
                c1633dF.f5284b = jMo2817c;
                if (j3 > 0) {
                    mo352j().m10488M(bundleM10481F, j3);
                }
            }
            if (!"auto".equals(str) && "_ssr".equals(str2)) {
                C2514wG c2514wGMo352j = mo352j();
                String string = bundleM10481F.getString("_ffr");
                if (AbstractC0124Cm.m508a(string)) {
                    string = null;
                } else if (string != null) {
                    string = string.trim();
                }
                if (Objects.equals(string, c2514wGMo352j.mo351i().f5573x.m10620a())) {
                    c2514wGMo352j.mo349g().m9617F().m10616a("Not logging duplicate session_start_with_rollout event");
                    return;
                }
                c2514wGMo352j.mo351i().f5573x.m10621b(string);
            } else if ("_ae".equals(str2)) {
                String strM10620a = mo352j().mo351i().f5573x.m10620a();
                if (!TextUtils.isEmpty(strM10620a)) {
                    bundleM10481F.putString("_ffr", strM10620a);
                }
            }
            ArrayList arrayList2 = new ArrayList<>();
            arrayList2.add(bundleM10481F);
            boolean zM3781F = mo347e().m10818t(AbstractC0818Rr.f2458O0) ? mo3789u().m3781F() : mo351i().f5570u.m8428b();
            if (mo351i().f5567r.m9085a() > 0 && mo351i().m7681z(j) && zM3781F) {
                mo349g().m9622K().m10616a("Current session is expired, remove the session number, ID, and engagement time");
                arrayList = arrayList2;
                j2 = 0;
                str4 = "_ae";
                m5161Y("auto", "_sid", null, mo345b().mo2815a());
                m5161Y("auto", "_sno", null, mo345b().mo2815a());
                m5161Y("auto", "_se", null, mo345b().mo2815a());
                mo351i().f5568s.m9086b(0L);
            } else {
                str4 = "_ae";
                arrayList = arrayList2;
                j2 = 0;
            }
            if (bundleM10481F.getLong("extend_session", j2) == 1) {
                mo349g().m9622K().m10616a("EXTEND_SESSION param attached: initiate a new session or extend the current active session");
                i = 1;
                this.f8058a.m9229K().f2363e.m7819b(j, true);
            } else {
                i = 1;
            }
            ArrayList arrayList3 = new ArrayList<>(bundleM10481F.keySet());
            Collections.sort(arrayList3);
            int size = arrayList3.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj2 = arrayList3.get(i3);
                i3 += i;
                String str6 = (String) obj2;
                if (str6 != null) {
                    mo352j();
                    Bundle[] bundleArrM10473x0 = C2514wG.m10473x0(bundleM10481F.get(str6));
                    if (bundleArrM10473x0 != null) {
                        bundleM10481F.putParcelableArray(str6, bundleArrM10473x0);
                    }
                }
                i = 1;
            }
            int i4 = 0;
            while (i4 < arrayList.size()) {
                ArrayList arrayList4 = arrayList;
                Bundle bundleM10479E = (Bundle) arrayList4.get(i4);
                String str7 = i4 != 0 ? "_ep" : str2;
                bundleM10479E.putString(str5, str);
                if (z2) {
                    obj = null;
                    bundleM10479E = mo352j().m10479E(bundleM10479E, null);
                } else {
                    obj = null;
                }
                Bundle bundle2 = bundleM10479E;
                String str8 = str5;
                mo3788t().m8860J(new C0635Nr(str7, new C0175Dr(bundle2), str, j), str3);
                if (!zEquals) {
                    Iterator it = this.f3504e.iterator();
                    while (it.hasNext()) {
                        ((InterfaceC1068XA) it.next()).mo4683a(str, str2, new Bundle(bundle2), j);
                    }
                }
                i4++;
                arrayList = arrayList4;
                str5 = str8;
            }
            if (mo3787s().m4690D(false) == null || !str4.equals(str2)) {
                return;
            }
            mo3789u().m3780E(true, true, mo345b().mo2817c());
        }
    }

    public final void m5154U(String str, String str2, long j, Object obj) {
        mo354l().m7374C(new RunnableC0793RB(this, str, str2, obj, j));
    }

    public final void m5155V(String str, String str2, Bundle bundle) {
        long jMo2815a = mo345b().mo2815a();
        AbstractC1085Xi.m4795d(str);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", str);
        bundle2.putLong("creation_timestamp", jMo2815a);
        if (str2 != null) {
            bundle2.putString("expired_event_name", str2);
            bundle2.putBundle("expired_event_params", bundle);
        }
        mo354l().m7374C(new RunnableC1309bC(this, bundle2));
    }

    public final void m5156V0(boolean z) {
        if (mo344a().getApplicationContext() instanceof Application) {
            Application application = (Application) mo344a().getApplicationContext();
            if (this.f3502c == null) {
                this.f3502c = new C2602yC(this);
            }
            if (z) {
                application.unregisterActivityLifecycleCallbacks(this.f3502c);
                application.registerActivityLifecycleCallbacks(this.f3502c);
                mo349g().m9622K().m10616a("Registered activity lifecycle callback");
            }
        }
    }

    public final void m5157W(String str, String str2, Bundle bundle, String str3) {
        mo355m();
        m5148Q0(str, str2, mo345b().mo2815a(), bundle, false, true, true, str3);
    }

    public final void m5158W0(long j) {
        mo354l().m7374C(new RunnableC0702PB(this, j));
    }

    public final void m5159X(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (Objects.equals(str2, "screen_view")) {
            mo3787s().m4695I(bundle2, j);
        } else {
            m5148Q0(str3, str2, j, bundle2, z2, !z2 || this.f3503d == null || C2514wG.m10452J0(str2), z, null);
        }
    }

    public final void m5160X0(Bundle bundle) {
        m5144O0(bundle, mo345b().mo2815a());
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0051  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5161Y(String r10, String r11, Object r12, long r13) {
        /*
            r9 = this;
            p000.AbstractC1085Xi.m4795d(r10)
            p000.AbstractC1085Xi.m4795d(r11)
            r9.mo356n()
            r9.m2546v()
            java.lang.String r0 = "allow_personalized_ads"
            boolean r0 = r0.equals(r11)
            if (r0 == 0) goto L6e
            boolean r0 = r12 instanceof java.lang.String
            java.lang.String r1 = "_npa"
            if (r0 == 0) goto L51
            r0 = r12
            java.lang.String r0 = (java.lang.String) r0
            boolean r2 = android.text.TextUtils.isEmpty(r0)
            if (r2 != 0) goto L51
            java.util.Locale r11 = java.util.Locale.ENGLISH
            java.lang.String r11 = r0.toLowerCase(r11)
            java.lang.String r12 = "false"
            boolean r11 = r12.equals(r11)
            r2 = 1
            if (r11 == 0) goto L35
            r4 = r2
            goto L37
        L35:
            r4 = 0
        L37:
            java.lang.Long r11 = java.lang.Long.valueOf(r4)
            fy r0 = r9.mo351i()
            wy r0 = r0.f5564o
            long r4 = r11.longValue()
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 != 0) goto L4b
            java.lang.String r12 = "true"
        L4b:
            r0.m10621b(r12)
            r12 = r11
        L4f:
            r11 = r1
            goto L5f
        L51:
            if (r12 != 0) goto L5f
            fy r11 = r9.mo351i()
            wy r11 = r11.f5564o
            java.lang.String r0 = "unset"
            r11.m10621b(r0)
            goto L4f
        L5f:
            sx r0 = r9.mo349g()
            wx r0 = r0.m9622K()
            java.lang.String r1 = "Setting user property(FE)"
            java.lang.String r2 = "non_personalized_ads(_npa)"
            r0.m10618c(r1, r2, r12)
        L6e:
            r4 = r11
            r7 = r12
            qz r11 = r9.f8058a
            boolean r11 = r11.m9242p()
            if (r11 != 0) goto L86
            sx r10 = r9.mo349g()
            wx r10 = r10.m9622K()
            java.lang.String r11 = "User property not set since app measurement is disabled"
            r10.m10616a(r11)
            return
        L86:
            qz r11 = r9.f8058a
            boolean r11 = r11.m9245s()
            if (r11 != 0) goto L8f
            return
        L8f:
            mG r11 = new mG
            r3 = r11
            r5 = r13
            r8 = r10
            r3.<init>(r4, r5, r7, r8)
            oD r10 = r9.mo3788t()
            r10.m8868T(r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1207aB.m5161Y(java.lang.String, java.lang.String, java.lang.Object, long):void");
    }

    public final void m5162Y0(final Bundle bundle, final long j) {
        mo354l().m7375G(new Runnable() {
            @Override
            public final void run() {
                this.f6073l.m5143O(bundle, j);
            }
        });
    }

    public final void m5163Z(String str, String str2, Object obj, boolean z) {
        m5165a0(str, str2, obj, z, mo345b().mo2815a());
    }

    public final void m5164Z0(String str) {
        this.f3506g.set(str);
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m5165a0(String r7, String r8, Object r9, boolean r10, long r11) {
        /*
            r6 = this;
            if (r7 != 0) goto L4
            java.lang.String r7 = "app"
        L4:
            r1 = r7
            r7 = 0
            r0 = 24
            if (r10 == 0) goto L13
            wG r10 = r6.mo352j()
            int r10 = r10.m10517r0(r8)
            goto L35
        L13:
            wG r10 = r6.mo352j()
            java.lang.String r2 = "user property"
            boolean r3 = r10.m10478C0(r2, r8)
            r4 = 6
            if (r3 != 0) goto L22
        L20:
            r10 = r4
            goto L35
        L22:
            java.lang.String[] r3 = p000.AbstractC0884TA.f2726a
            boolean r3 = r10.m10515o0(r2, r3, r8)
            if (r3 != 0) goto L2d
            r10 = 15
            goto L35
        L2d:
            boolean r10 = r10.m10512j0(r2, r0, r8)
            if (r10 != 0) goto L34
            goto L20
        L34:
            r10 = r7
        L35:
            java.lang.String r2 = "_ev"
            r3 = 1
            if (r10 == 0) goto L52
            r6.mo352j()
            java.lang.String r9 = p000.C2514wG.m10451I(r8, r0, r3)
            if (r8 == 0) goto L47
            int r7 = r8.length()
        L47:
            qz r8 = r6.f8058a
            r8.m9230L()
            uG r8 = r6.f3521v
            p000.C2514wG.m10460Z(r8, r10, r2, r9, r7)
            return
        L52:
            if (r9 == 0) goto L91
            wG r10 = r6.mo352j()
            int r10 = r10.m10522w(r8, r9)
            if (r10 == 0) goto L80
            r6.mo352j()
            java.lang.String r8 = p000.C2514wG.m10451I(r8, r0, r3)
            boolean r11 = r9 instanceof java.lang.String
            if (r11 != 0) goto L6d
            boolean r11 = r9 instanceof java.lang.CharSequence
            if (r11 == 0) goto L75
        L6d:
            java.lang.String r7 = java.lang.String.valueOf(r9)
            int r7 = r7.length()
        L75:
            qz r9 = r6.f8058a
            r9.m9230L()
            uG r9 = r6.f3521v
            p000.C2514wG.m10460Z(r9, r10, r2, r8, r7)
            return
        L80:
            wG r7 = r6.mo352j()
            java.lang.Object r5 = r7.m10476A0(r8, r9)
            if (r5 == 0) goto L90
            r0 = r6
            r2 = r8
            r3 = r11
            r0.m5154U(r1, r2, r3, r5)
        L90:
            return
        L91:
            r5 = 0
            r0 = r6
            r2 = r8
            r3 = r11
            r0.m5154U(r1, r2, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1207aB.m5165a0(java.lang.String, java.lang.String, java.lang.Object, boolean, long):void");
    }

    public final void m5166a1(String str, String str2, Bundle bundle) {
        mo356n();
        m5151S(str, str2, mo345b().mo2815a(), bundle);
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    public final void m5167b0(List list) {
        mo356n();
        if (Build.VERSION.SDK_INT >= 30) {
            SparseArray sparseArrayM7665K = mo351i().m7665K();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                C1913jF c1913jF = (C1913jF) it.next();
                if (!sparseArrayM7665K.contains(c1913jF.f5939n) || ((Long) sparseArrayM7665K.get(c1913jF.f5939n)).longValue() < c1913jF.f5938m) {
                    m5122A0().add(c1913jF);
                }
            }
            m5131H0();
        }
    }

    public final void m5168c0(AtomicReference atomicReference) {
        Bundle bundleM8225a = mo351i().f5565p.m8225a();
        C2142oD c2142oDMo3788t = mo3788t();
        if (bundleM8225a == null) {
            bundleM8225a = new Bundle();
        }
        c2142oDMo3788t.m8856F(atomicReference, bundleM8225a);
    }

    public final void m5169c1(boolean z) {
        m2546v();
        mo354l().m7374C(new RunnableC0518LB(this, z));
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    public final void m5170d0(C1981kr c1981kr, boolean z) {
        RunnableC2510wC runnableC2510wC = new RunnableC2510wC(this, c1981kr);
        if (!z) {
            mo354l().m7374C(runnableC2510wC);
        } else {
            mo356n();
            runnableC2510wC.run();
        }
    }

    public final void m5171d1(Bundle bundle) {
        final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
        mo354l().m7374C(new Runnable() {
            @Override
            public final void run() {
                this.f6303l.m5139M(bundle2);
            }
        });
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    public final void m5172e0(InterfaceC2076mu interfaceC2076mu) {
        mo354l().m7374C(new RunnableC2003lC(this, interfaceC2076mu));
    }

    public final void m5173e1(Bundle bundle, long j) {
        m5141N(bundle, -20, j);
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    public final void m5174f0(C0425JA c0425ja) {
        mo356n();
        boolean z = (c0425ja.m1852B() && c0425ja.m1851A()) || mo3788t().m8883i0();
        if (z != this.f8058a.m9243q()) {
            this.f8058a.m9249w(z);
            Boolean boolM7669O = mo351i().m7669O();
            if (!z || boolM7669O == null || boolM7669O.booleanValue()) {
                m5147Q(Boolean.valueOf(z), false);
            }
        }
    }

    public final void m5175f1(Bundle bundle) {
        if (mo347e().m10818t(AbstractC0818Rr.f2519m1)) {
            final Bundle bundle2 = bundle == null ? new Bundle() : new Bundle(bundle);
            mo354l().m7374C(new Runnable() {
                @Override
                public final void run() {
                    this.f6635l.m5142N0(bundle2);
                }
            });
        }
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    public final void m5176g0(C0425JA c0425ja, long j, boolean z) {
        C0425JA c0425ja2;
        boolean z2;
        boolean zM1862u;
        boolean z3;
        C0425JA c0425jaM1859r = c0425ja;
        m2546v();
        int iM1854b = c0425ja.m1854b();
        if (C0247FG.m1217a() && mo347e().m10818t(AbstractC0818Rr.f2478Y0)) {
            if (iM1854b != -10) {
                EnumC0333HA enumC0333HAM1861t = c0425ja.m1861t();
                EnumC0333HA enumC0333HA = EnumC0333HA.UNINITIALIZED;
                if (enumC0333HAM1861t == enumC0333HA && c0425ja.m1863v() == enumC0333HA) {
                    mo349g().m9624M().m10616a("Ignoring empty consent settings");
                    return;
                }
            }
        } else if (iM1854b != -10 && c0425ja.m1864w() == null && c0425ja.m1865x() == null) {
            mo349g().m9624M().m10616a("Discarding empty consent settings");
            return;
        }
        synchronized (this.f3507h) {
            try {
                c0425ja2 = this.f3513n;
                z2 = false;
                if (C0425JA.m1848l(iM1854b, c0425ja2.m1854b())) {
                    zM1862u = c0425ja.m1862u(this.f3513n);
                    if (c0425ja.m1852B() && !this.f3513n.m1852B()) {
                        z2 = true;
                    }
                    c0425jaM1859r = c0425ja.m1859r(this.f3513n);
                    this.f3513n = c0425jaM1859r;
                    z3 = z2;
                    z2 = true;
                } else {
                    zM1862u = false;
                    z3 = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (!z2) {
            mo349g().m9621J().m10617b("Ignoring lower-priority consent settings, proposed settings", c0425jaM1859r);
            return;
        }
        long andIncrement = this.f3514o.getAndIncrement();
        if (zM1862u) {
            m5164Z0(null);
            RunnableC2418uC runnableC2418uC = new RunnableC2418uC(this, c0425jaM1859r, j, andIncrement, z3, c0425ja2);
            if (!z) {
                mo354l().m7375G(runnableC2418uC);
                return;
            } else {
                mo356n();
                runnableC2418uC.run();
                return;
            }
        }
        RunnableC0013AC runnableC0013AC = new RunnableC0013AC(this, c0425jaM1859r, andIncrement, z3, c0425ja2);
        if (z) {
            mo356n();
            runnableC0013AC.run();
        } else if (iM1854b == 30 || iM1854b == -10) {
            mo354l().m7375G(runnableC0013AC);
        } else {
            mo354l().m7374C(runnableC0013AC);
        }
    }

    public final Bundle m5177g1(Bundle bundle) {
        Bundle bundleM8225a = mo351i().f5551A.m8225a();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (obj != null && !(obj instanceof String) && !(obj instanceof Long) && !(obj instanceof Double)) {
                mo352j();
                if (C2514wG.m10467h0(obj)) {
                    mo352j();
                    C2514wG.m10460Z(this.f3521v, 27, null, null, 0);
                }
                mo349g().m9624M().m10618c("Invalid default event parameter type. Name, value", str, obj);
            } else if (C2514wG.m10452J0(str)) {
                mo349g().m9624M().m10617b("Invalid default event parameter name. Name", str);
            } else if (obj == null) {
                bundleM8225a.remove(str);
            } else if (mo352j().m10514l0("param", str, mo347e().m10816r(null, false), obj)) {
                mo352j().m10491O(bundleM8225a, str, obj);
            }
        }
        mo352j();
        if (C2514wG.m10466g0(bundleM8225a, mo347e().m10801K())) {
            mo352j();
            C2514wG.m10460Z(this.f3521v, 26, null, null, 0);
            mo349g().m9624M().m10616a("Too many default event parameters set. Discarding beyond event parameter limit");
        }
        return bundleM8225a;
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    public final void m5178h0(InterfaceC0792RA interfaceC0792RA) {
        InterfaceC0792RA interfaceC0792RA2;
        mo356n();
        m2546v();
        if (interfaceC0792RA != null && interfaceC0792RA != (interfaceC0792RA2 = this.f3503d)) {
            AbstractC1085Xi.m4805n(interfaceC0792RA2 == null, "EventInterceptor already set.");
        }
        this.f3503d = interfaceC0792RA;
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    public final void m5179i0(InterfaceC1068XA interfaceC1068XA) {
        m2546v();
        AbstractC1085Xi.m4801j(interfaceC1068XA);
        if (this.f3504e.add(interfaceC1068XA)) {
            return;
        }
        mo349g().m9623L().m10616a("OnEventListener already registered");
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

    public final Application.ActivityLifecycleCallbacks m5180p0() {
        return this.f3502c;
    }

    @Override
    public final /* bridge */ C2079mx mo3785q() {
        return super.mo3785q();
    }

    public final C0312Gq m5181q0() {
        mo356n();
        return mo3788t().m8870V();
    }

    @Override
    public final /* bridge */ C1207aB mo3786r() {
        return super.mo3786r();
    }

    public final Boolean m5182r0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) mo354l().m7377u(atomicReference, 15000L, "boolean test flag value", new RunnableC2647zB(this, atomicReference));
    }

    @Override
    public final /* bridge */ C1070XC mo3787s() {
        return super.mo3787s();
    }

    public final Double m5183s0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) mo354l().m7377u(atomicReference, 15000L, "double test flag value", new RunnableC2326sC(this, atomicReference));
    }

    @Override
    public final /* bridge */ C2142oD mo3788t() {
        return super.mo3788t();
    }

    public final Integer m5184t0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) mo354l().m7377u(atomicReference, 15000L, "int test flag value", new RunnableC2049mC(this, atomicReference));
    }

    @Override
    public final /* bridge */ C0796RE mo3789u() {
        return super.mo3789u();
    }

    public final Long m5185u0() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) mo354l().m7377u(atomicReference, 15000L, "long test flag value", new RunnableC2141oC(this, atomicReference));
    }

    public final String m5186v0() {
        return (String) this.f3506g.get();
    }

    public final String m5187w0() {
        C1162ZC c1162zcM4698P = this.f8058a.m9227I().m4698P();
        if (c1162zcM4698P != null) {
            return c1162zcM4698P.f3422b;
        }
        return null;
    }

    public final String m5188x0() {
        C1162ZC c1162zcM4698P = this.f8058a.m9227I().m4698P();
        if (c1162zcM4698P != null) {
            return c1162zcM4698P.f3421a;
        }
        return null;
    }

    public final String m5189y0() {
        if (this.f8058a.m9231M() != null) {
            return this.f8058a.m9231M();
        }
        try {
            return new C1756fz(mo344a(), this.f8058a.m9234P()).m7683b("google_app_id");
        } catch (IllegalStateException e) {
            this.f8058a.mo349g().m9618G().m10617b("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final String m5190z0() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) mo354l().m7377u(atomicReference, 15000L, "String test flag value", new RunnableC0977VB(this, atomicReference));
    }
}
