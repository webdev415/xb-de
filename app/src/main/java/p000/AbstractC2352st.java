package p000;

import android.content.Context;
import android.content.SharedPreferences;

public abstract class AbstractC2352st {

    public static final ThreadLocal f7081a = new C2628yt();

    public static SharedPreferences m9606a(Context context, String str, int i, AbstractC1844ht abstractC1844ht) {
        SharedPreferencesC2260qt sharedPreferencesC2260qt = AbstractC0911Ts.m4185a().mo4854b(str, abstractC1844ht, EnumC1336bt.SHARED_PREFS_TYPE).equals("") ? new SharedPreferencesC2260qt() : null;
        if (sharedPreferencesC2260qt != null) {
            return sharedPreferencesC2260qt;
        }
        ThreadLocal threadLocal = f7081a;
        AbstractC1131Yi.m4968d(((Boolean) threadLocal.get()).booleanValue());
        threadLocal.set(Boolean.FALSE);
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
            threadLocal.set(Boolean.TRUE);
            return sharedPreferences;
        } catch (Throwable th) {
            f7081a.set(Boolean.TRUE);
            throw th;
        }
    }
}
