package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

/* loaded from: classes.dex */
public abstract class AbstractC0745Q8 {

    public static Boolean f2205a;

    public static Boolean f2206b;

    public static Boolean f2207c;

    public static boolean m3633a() {
        int i = AbstractC0482Kc.f1572a;
        return "user".equals(Build.TYPE);
    }

    public static boolean m3634b(Context context) {
        return m3638f(context.getPackageManager());
    }

    public static boolean m3635c(Context context) {
        if (m3634b(context) && !AbstractC0993Vi.m4417f()) {
            return true;
        }
        if (m3636d(context)) {
            return !AbstractC0993Vi.m4418g() || AbstractC0993Vi.m4420i();
        }
        return false;
    }

    public static boolean m3636d(Context context) {
        if (f2206b == null) {
            boolean z = false;
            if (AbstractC0993Vi.m4416e() && context.getPackageManager().hasSystemFeature("cn.google")) {
                z = true;
            }
            f2206b = Boolean.valueOf(z);
        }
        return f2206b.booleanValue();
    }

    public static boolean m3637e(Context context) {
        if (f2207c == null) {
            boolean z = true;
            if (!context.getPackageManager().hasSystemFeature("android.hardware.type.iot") && !context.getPackageManager().hasSystemFeature("android.hardware.type.embedded")) {
                z = false;
            }
            f2207c = Boolean.valueOf(z);
        }
        return f2207c.booleanValue();
    }

    public static boolean m3638f(PackageManager packageManager) {
        if (f2205a == null) {
            boolean z = false;
            if (AbstractC0993Vi.m4415d() && packageManager.hasSystemFeature("android.hardware.type.watch")) {
                z = true;
            }
            f2205a = Boolean.valueOf(z);
        }
        return f2205a.booleanValue();
    }
}
