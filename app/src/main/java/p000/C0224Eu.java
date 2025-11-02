package p000;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
public class C0224Eu {

    public static volatile C0224Eu f591j;

    public final String f592a;

    public final InterfaceC0557M4 f593b;

    public final ExecutorService f594c;

    public final C1012W0 f595d;

    public final List f596e;

    public int f597f;

    public boolean f598g;

    public String f599h;

    public volatile InterfaceC1984ku f600i;

    public abstract class a implements Runnable {

        public final long f601l;

        public final long f602m;

        public final boolean f603n;

        public a(C0224Eu c0224Eu) {
            this(true);
        }

        public abstract void mo794a();

        @Override
        public void run() {
            if (C0224Eu.this.f598g) {
                mo795b();
                return;
            }
            try {
                mo794a();
            } catch (Exception e) {
                C0224Eu.this.m1125n(e, false, this.f603n);
                mo795b();
            }
        }

        public a(boolean z) {
            this.f601l = C0224Eu.this.f593b.mo2815a();
            this.f602m = C0224Eu.this.f593b.mo2817c();
            this.f603n = z;
        }

        public void mo795b() {
        }
    }

    public class b implements Application.ActivityLifecycleCallbacks {
        public b() {
        }

        @Override
        public final void onActivityCreated(Activity activity, Bundle bundle) {
            C0224Eu.this.m1129r(new C1052Wv(this, bundle, activity));
        }

        @Override
        public final void onActivityDestroyed(Activity activity) {
            C0224Eu.this.m1129r(new C1800gw(this, activity));
        }

        @Override
        public final void onActivityPaused(Activity activity) {
            C0224Eu.this.m1129r(new C1144Yv(this, activity));
        }

        @Override
        public final void onActivityResumed(Activity activity) {
            C0224Eu.this.m1129r(new C1292aw(this, activity));
        }

        @Override
        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            BinderC1798gu binderC1798gu = new BinderC1798gu();
            C0224Eu.this.m1129r(new C1613cw(this, activity, binderC1798gu));
            Bundle bundleM7761P = binderC1798gu.m7761P(50L);
            if (bundleM7761P != null) {
                bundle.putAll(bundleM7761P);
            }
        }

        @Override
        public final void onActivityStarted(Activity activity) {
            C0224Eu.this.m1129r(new C0960Uv(this, activity));
        }

        @Override
        public final void onActivityStopped(Activity activity) {
            C0224Eu.this.m1129r(new C1706ew(this, activity));
        }
    }

    public C0224Eu(Context context, String str, String str2, String str3, Bundle bundle) {
        this.f592a = (str == null || !m1109C(str2, str3)) ? "FA" : str;
        this.f593b = C0835S7.m4014d();
        this.f594c = AbstractC0407It.m1723a().mo3711a(new ThreadFactoryC1705ev(this), 1);
        this.f595d = new C1012W0(this);
        this.f596e = new ArrayList<>();
        if (m1098A(context) && !m1114I()) {
            this.f599h = null;
            this.f598g = true;
            Log.w(this.f592a, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
            return;
        }
        if (m1109C(str2, str3)) {
            this.f599h = str2;
        } else {
            this.f599h = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.f592a, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.f592a, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        }
        m1129r(new C0500Ku(this, str2, str3, context, bundle));
        Application application = (Application) context.getApplicationContext();
        if (application == null) {
            Log.w(this.f592a, "Unable to register lifecycle notifications. Application null.");
        } else {
            application.registerActivityLifecycleCallbacks(new b());
        }
    }

    public static boolean m1098A(Context context) {
        return new C1756fz(context, C1756fz.m7682a(context)).m7683b("google_app_id") != null;
    }

    public static C0224Eu m1101g(Context context) {
        return m1102h(context, null, null, null, null);
    }

    public static C0224Eu m1102h(Context context, String str, String str2, String str3, Bundle bundle) {
        AbstractC1085Xi.m4801j(context);
        if (f591j == null) {
            synchronized (C0224Eu.class) {
                try {
                    if (f591j == null) {
                        f591j = new C0224Eu(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return f591j;
    }

    public final void m1108B(String str) {
        m1129r(new C2077mv(this, str));
    }

    public final boolean m1109C(String str, String str2) {
        return (str2 == null || str == null || m1114I()) ? false : true;
    }

    public final String m1110E() {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C2262qv(this, binderC1798gu));
        return binderC1798gu.m7763S(50L);
    }

    public final String m1111F() {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C2354sv(this, binderC1798gu));
        return binderC1798gu.m7763S(500L);
    }

    public final String m1112G() {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C2446uv(this, binderC1798gu));
        return binderC1798gu.m7763S(500L);
    }

    public final String m1113H() {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C1985kv(this, binderC1798gu));
        return binderC1798gu.m7763S(500L);
    }

    public final boolean m1114I() throws ClassNotFoundException {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, getClass().getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int m1115a(String str) {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C0179Dv(this, str, binderC1798gu));
        Integer num = (Integer) BinderC1798gu.m7760Q(binderC1798gu.m7761P(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long m1116b() {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C2170ov(this, binderC1798gu));
        Long lM7762R = binderC1798gu.m7762R(500L);
        if (lM7762R != null) {
            return lM7762R.longValue();
        }
        long jNextLong = new Random(System.nanoTime() ^ this.f593b.mo2815a()).nextLong();
        int i = this.f597f + 1;
        this.f597f = i;
        return jNextLong + i;
    }

    public final List m1117c(String str, String str2) {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C1051Wu(this, str, str2, binderC1798gu));
        List list = (List) BinderC1798gu.m7760Q(binderC1798gu.m7761P(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map m1118d(String str, String str2, boolean z) {
        BinderC1798gu binderC1798gu = new BinderC1798gu();
        m1129r(new C2630yv(this, str, str2, z, binderC1798gu));
        Bundle bundleM7761P = binderC1798gu.m7761P(5000L);
        if (bundleM7761P == null || bundleM7761P.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap map = new HashMap<>(bundleM7761P.size());
        for (String str3 : bundleM7761P.keySet()) {
            Object obj = bundleM7761P.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                map.put(str3, obj);
            }
        }
        return map;
    }

    public final InterfaceC1984ku m1119e(Context context, boolean z) {
        try {
            return AbstractBinderC1891iu.asInterface(DynamiteModule.m5949d(context, DynamiteModule.f4005e, ModuleDescriptor.MODULE_ID).m5957c("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.C1378a e) {
            m1125n(e, true, false);
            return null;
        }
    }

    public final void m1120i(int i, String str, Object obj, Object obj2, Object obj3) {
        m1129r(new C2538wv(this, false, 5, str, obj, null, null));
    }

    public final void m1121j(Activity activity, String str, String str2) {
        m1129r(new C1291av(this, activity, str, str2));
    }

    public final void m1122k(Intent intent) {
        m1129r(new C0731Pv(this, intent));
    }

    public final void m1123l(Bundle bundle) {
        m1129r(new C0913Tu(this, bundle));
    }

    public final void m1124m(Boolean bool) {
        m1129r(new C1143Yu(this, bool));
    }

    public final void m1125n(Exception exc, boolean z, boolean z2) {
        this.f598g |= z;
        if (z) {
            Log.w(this.f592a, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            m1120i(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.f592a, "Error with data collection. Data lost.", exc);
    }

    public final void m1126o(String str, Bundle bundle) {
        m1128q(null, str, bundle, false, true, null);
    }

    public final void m1127p(String str, String str2, Bundle bundle) {
        m1129r(new C0592Mu(this, str, str2, bundle));
    }

    public final void m1128q(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        m1129r(new C0822Rv(this, l, str, str2, bundle, z, z2));
    }

    public final void m1129r(a aVar) {
        this.f594c.execute(aVar);
    }

    public final C1012W0 m1130w() {
        return this.f595d;
    }

    public final void m1131y(String str) {
        m1129r(new C1846hv(this, str));
    }

    public final void m1132z(String str, String str2, Bundle bundle) {
        m1128q(str, str2, bundle, true, true, null);
    }
}
