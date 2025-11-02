package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.StrictMode;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class C0287GA implements InterfaceC0643Nz {

    public static final Map f863g = new C2453v1();

    public final SharedPreferences f864a;

    public final Runnable f865b;

    public final SharedPreferences.OnSharedPreferenceChangeListener f866c;

    public final Object f867d;

    public volatile Map f868e;

    public final List f869f;

    public C0287GA(SharedPreferences sharedPreferences, Runnable runnable) {
        SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences2, String str) {
                this.f1761a.m1364d(sharedPreferences2, str);
            }
        };
        this.f866c = onSharedPreferenceChangeListener;
        this.f867d = new Object();
        this.f869f = new ArrayList<>();
        this.f864a = sharedPreferences;
        this.f865b = runnable;
        sharedPreferences.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public static SharedPreferences m1361a(Context context, String str) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            if (!str.startsWith("direct_boot:")) {
                SharedPreferences sharedPreferencesM9606a = AbstractC2352st.m9606a(context, str, 0, AbstractC1983kt.f6041a);
                StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                return sharedPreferencesM9606a;
            }
            if (AbstractC0229Ez.m1159a()) {
                context = context.createDeviceProtectedStorageContext();
            }
            SharedPreferences sharedPreferencesM9606a2 = AbstractC2352st.m9606a(context, str.substring(12), 0, AbstractC1983kt.f6041a);
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return sharedPreferencesM9606a2;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static C0287GA m1362b(Context context, String str, Runnable runnable) {
        C0287GA c0287ga;
        if (!((!AbstractC0229Ez.m1159a() || str.startsWith("direct_boot:")) ? true : AbstractC0229Ez.m1161c(context))) {
            return null;
        }
        synchronized (C0287GA.class) {
            try {
                Map map = f863g;
                c0287ga = (C0287GA) map.get(str);
                if (c0287ga == null) {
                    c0287ga = new C0287GA(m1361a(context, str), runnable);
                    map.put(str, c0287ga);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return c0287ga;
    }

    public static synchronized void m1363c() {
        try {
            for (C0287GA c0287ga : f863g.values()) {
                c0287ga.f864a.unregisterOnSharedPreferenceChangeListener(c0287ga.f866c);
            }
            f863g.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public final void m1364d(SharedPreferences sharedPreferences, String str) {
        synchronized (this.f867d) {
            this.f868e = null;
            this.f865b.run();
        }
        synchronized (this) {
            try {
                Iterator it = this.f869f.iterator();
                if (it.hasNext()) {
                    AbstractC2524wh.m10586a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final Object mo1365g(String str) {
        Map<String, ?> map = this.f868e;
        if (map == null) {
            synchronized (this.f867d) {
                try {
                    map = this.f868e;
                    if (map == null) {
                        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                        try {
                            Map<String, ?> all = this.f864a.getAll();
                            this.f868e = all;
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            map = all;
                        } catch (Throwable th) {
                            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                            throw th;
                        }
                    }
                } finally {
                }
            }
        }
        if (map != null) {
            return map.get(str);
        }
        return null;
    }
}
