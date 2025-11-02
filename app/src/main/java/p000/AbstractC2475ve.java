package p000;

import android.content.Context;

/* loaded from: classes.dex */
public abstract class AbstractC2475ve {

    public static Context f7674a;

    public static Boolean f7675b;

    public static synchronized boolean m10353a(Context context) {
        Boolean boolValueOf;
        Boolean bool;
        Context applicationContext = context.getApplicationContext();
        Context context2 = f7674a;
        if (context2 != null && (bool = f7675b) != null && context2 == applicationContext) {
            return bool.booleanValue();
        }
        f7675b = null;
        if (!AbstractC0993Vi.m4418g()) {
            try {
                context.getClassLoader().loadClass("com.google.android.instantapps.supervisor.InstantAppsRuntime");
                f7675b = Boolean.TRUE;
            } catch (ClassNotFoundException unused) {
                boolValueOf = Boolean.FALSE;
            }
            f7674a = applicationContext;
            return f7675b.booleanValue();
        }
        boolValueOf = Boolean.valueOf(applicationContext.getPackageManager().isInstantApp());
        f7675b = boolValueOf;
        f7674a = applicationContext;
        return f7675b.booleanValue();
    }
}
