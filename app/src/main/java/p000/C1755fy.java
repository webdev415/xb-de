package p000;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import p000.C0425JA;
import p000.C2636z0;

/* loaded from: classes.dex */
public final class C1755fy extends AbstractC2508wA {

    public static final Pair f5550B = new Pair("", 0L);

    public final C1942jy f5551A;

    public SharedPreferences f5552c;

    public Object f5553d;

    public SharedPreferences f5554e;

    public C2126ny f5555f;

    public final C2219py f5556g;

    public final C2219py f5557h;

    public final C2541wy f5558i;

    public String f5559j;

    public boolean f5560k;

    public long f5561l;

    public final C2219py f5562m;

    public final C2034ly f5563n;

    public final C2541wy f5564o;

    public final C1942jy f5565p;

    public final C2034ly f5566q;

    public final C2219py f5567r;

    public final C2219py f5568s;

    public boolean f5569t;

    public C2034ly f5570u;

    public C2034ly f5571v;

    public C2219py f5572w;

    public final C2541wy f5573x;

    public final C2541wy f5574y;

    public final C2219py f5575z;

    public C1755fy(C2266qz c2266qz) {
        super(c2266qz);
        this.f5553d = new Object();
        this.f5562m = new C2219py(this, "session_timeout", 1800000L);
        this.f5563n = new C2034ly(this, "start_new_session", true);
        this.f5567r = new C2219py(this, "last_pause_time", 0L);
        this.f5568s = new C2219py(this, "session_id", 0L);
        this.f5564o = new C2541wy(this, "non_personalized_ads", null);
        this.f5565p = new C1942jy(this, "last_received_uri_timestamps_by_source", null);
        this.f5566q = new C2034ly(this, "allow_remote_dynamite", false);
        this.f5556g = new C2219py(this, "first_open_time", 0L);
        this.f5557h = new C2219py(this, "app_install_time", 0L);
        this.f5558i = new C2541wy(this, "app_instance_id", null);
        this.f5570u = new C2034ly(this, "app_backgrounded", false);
        this.f5571v = new C2034ly(this, "deep_link_retrieval_complete", false);
        this.f5572w = new C2219py(this, "deep_link_retrieval_attempts", 0L);
        this.f5573x = new C2541wy(this, "firebase_feature_rollouts", null);
        this.f5574y = new C2541wy(this, "deferred_attribution_cache", null);
        this.f5575z = new C2219py(this, "deferred_attribution_cache_timestamp", 0L);
        this.f5551A = new C1942jy(this, "default_event_parameters", null);
    }

    public final boolean m7655A(C1981kr c1981kr) {
        mo356n();
        if (!C0425JA.m1848l(c1981kr.m8311a(), m7666L().m8311a())) {
            return false;
        }
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putString("dma_consent_settings", c1981kr.m8316j());
        editorEdit.apply();
        return true;
    }

    public final boolean m7656B(C0425JA c0425ja) {
        mo356n();
        int iM1854b = c0425ja.m1854b();
        if (!m7680y(iM1854b)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putString("consent_settings", c0425ja.m1867z());
        editorEdit.putInt("consent_source", iM1854b);
        editorEdit.apply();
        return true;
    }

    public final boolean m7657C(C1726fF c1726fF) {
        mo356n();
        String string = m7664J().getString("stored_tcf_param", "");
        String strM7575g = c1726fF.m7575g();
        if (strM7575g.equals(string)) {
            return false;
        }
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putString("stored_tcf_param", strM7575g);
        editorEdit.apply();
        return true;
    }

    public final boolean m7658D() {
        SharedPreferences sharedPreferences = this.f5552c;
        if (sharedPreferences == null) {
            return false;
        }
        return sharedPreferences.contains("deferred_analytics_collection");
    }

    public final void m7659E(Boolean bool) {
        mo356n();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled_from_api", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled_from_api");
        }
        editorEdit.apply();
    }

    public final void m7660F(String str) {
        mo356n();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putString("admob_app_id", str);
        editorEdit.apply();
    }

    public final void m7661G(boolean z) {
        mo356n();
        mo349g().m9622K().m10617b("App measurement setting deferred collection", Boolean.valueOf(z));
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putBoolean("deferred_analytics_collection", z);
        editorEdit.apply();
    }

    public final SharedPreferences m7662H() {
        mo356n();
        m10436p();
        if (this.f5554e == null) {
            synchronized (this.f5553d) {
                try {
                    if (this.f5554e == null) {
                        String str = mo344a().getPackageName() + "_preferences";
                        mo349g().m9622K().m10617b("Default prefs file", str);
                        this.f5554e = mo344a().getSharedPreferences(str, 0);
                    }
                } finally {
                }
            }
        }
        return this.f5554e;
    }

    public final void m7663I(String str) {
        mo356n();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putString("gmp_app_id", str);
        editorEdit.apply();
    }

    public final SharedPreferences m7664J() {
        mo356n();
        m10436p();
        AbstractC1085Xi.m4801j(this.f5552c);
        return this.f5552c;
    }

    public final SparseArray m7665K() {
        Bundle bundleM8225a = this.f5565p.m8225a();
        if (bundleM8225a == null) {
            return new SparseArray();
        }
        int[] intArray = bundleM8225a.getIntArray("uriSources");
        long[] longArray = bundleM8225a.getLongArray("uriTimestamps");
        if (intArray == null || longArray == null) {
            return new SparseArray();
        }
        if (intArray.length != longArray.length) {
            mo349g().m9618G().m10616a("Trigger URI source and timestamp array lengths do not match");
            return new SparseArray();
        }
        SparseArray sparseArray = new SparseArray();
        for (int i = 0; i < intArray.length; i++) {
            sparseArray.put(intArray[i], Long.valueOf(longArray[i]));
        }
        return sparseArray;
    }

    public final C1981kr m7666L() {
        mo356n();
        return C1981kr.m8309d(m7664J().getString("dma_consent_settings", null));
    }

    public final C0425JA m7667M() {
        mo356n();
        return C0425JA.m1846i(m7664J().getString("consent_settings", "G1"), m7664J().getInt("consent_source", 100));
    }

    public final Boolean m7668N() {
        mo356n();
        if (m7664J().contains("use_service")) {
            return Boolean.valueOf(m7664J().getBoolean("use_service", false));
        }
        return null;
    }

    public final Boolean m7669O() {
        mo356n();
        if (m7664J().contains("measurement_enabled_from_api")) {
            return Boolean.valueOf(m7664J().getBoolean("measurement_enabled_from_api", true));
        }
        return null;
    }

    public final Boolean m7670P() {
        mo356n();
        if (m7664J().contains("measurement_enabled")) {
            return Boolean.valueOf(m7664J().getBoolean("measurement_enabled", true));
        }
        return null;
    }

    public final String m7671Q() {
        mo356n();
        String string = m7664J().getString("previous_os_version", null);
        mo348f().m10436p();
        String str = Build.VERSION.RELEASE;
        if (!TextUtils.isEmpty(str) && !str.equals(string)) {
            SharedPreferences.Editor editorEdit = m7664J().edit();
            editorEdit.putString("previous_os_version", str);
            editorEdit.apply();
        }
        return string;
    }

    public final String m7672R() {
        mo356n();
        return m7664J().getString("admob_app_id", null);
    }

    public final String m7673S() {
        mo356n();
        return m7664J().getString("gmp_app_id", null);
    }

    public final void m7674T() {
        mo356n();
        Boolean boolM7670P = m7670P();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.clear();
        editorEdit.apply();
        if (boolM7670P != null) {
            m7678w(boolM7670P);
        }
    }

    @Override
    public final void mo7675o() {
        SharedPreferences sharedPreferences = mo344a().getSharedPreferences("com.google.android.gms.measurement.prefs", 0);
        this.f5552c = sharedPreferences;
        boolean z = sharedPreferences.getBoolean("has_been_opened", false);
        this.f5569t = z;
        if (!z) {
            SharedPreferences.Editor editorEdit = this.f5552c.edit();
            editorEdit.putBoolean("has_been_opened", true);
            editorEdit.apply();
        }
        this.f5555f = new C2126ny(this, "health_monitor", Math.max(0L, ((Long) AbstractC0818Rr.f2490d.m4296a(null)).longValue()));
    }

    @Override
    public final boolean mo357t() {
        return true;
    }

    public final Pair m7676u(String str) {
        mo356n();
        if (!m7667M().m1856m(C0425JA.a.AD_STORAGE)) {
            return new Pair("", Boolean.FALSE);
        }
        long jMo2817c = mo345b().mo2817c();
        if (this.f5559j != null && jMo2817c < this.f5561l) {
            return new Pair(this.f5559j, Boolean.valueOf(this.f5560k));
        }
        this.f5561l = jMo2817c + mo347e().m10795E(str);
        C2636z0.m10973b(true);
        try {
            C2636z0.a aVarM10972a = C2636z0.m10972a(mo344a());
            this.f5559j = "";
            String strM10979a = aVarM10972a.m10979a();
            if (strM10979a != null) {
                this.f5559j = strM10979a;
            }
            this.f5560k = aVarM10972a.m10980b();
        } catch (Exception e) {
            mo349g().m9617F().m10617b("Unable to get advertising id", e);
            this.f5559j = "";
        }
        C2636z0.m10973b(false);
        return new Pair(this.f5559j, Boolean.valueOf(this.f5560k));
    }

    public final void m7677v(SparseArray sparseArray) {
        if (sparseArray == null) {
            this.f5565p.m8226b(null);
            return;
        }
        int[] iArr = new int[sparseArray.size()];
        long[] jArr = new long[sparseArray.size()];
        for (int i = 0; i < sparseArray.size(); i++) {
            iArr[i] = sparseArray.keyAt(i);
            jArr[i] = ((Long) sparseArray.valueAt(i)).longValue();
        }
        Bundle bundle = new Bundle();
        bundle.putIntArray("uriSources", iArr);
        bundle.putLongArray("uriTimestamps", jArr);
        this.f5565p.m8226b(bundle);
    }

    public final void m7678w(Boolean bool) {
        mo356n();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        if (bool != null) {
            editorEdit.putBoolean("measurement_enabled", bool.booleanValue());
        } else {
            editorEdit.remove("measurement_enabled");
        }
        editorEdit.apply();
    }

    public final void m7679x(boolean z) {
        mo356n();
        SharedPreferences.Editor editorEdit = m7664J().edit();
        editorEdit.putBoolean("use_service", z);
        editorEdit.apply();
    }

    public final boolean m7680y(int i) {
        return C0425JA.m1848l(i, m7664J().getInt("consent_source", 100));
    }

    public final boolean m7681z(long j) {
        return j - this.f5562m.m9085a() > this.f5567r.m9085a();
    }
}
