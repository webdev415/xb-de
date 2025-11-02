package p000;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.UserManager;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class AbstractC0482Kc {

    public static final int f1572a = 12451000;

    public static boolean f1574c = false;

    public static boolean f1575d = false;

    public static final AtomicBoolean f1573b = new AtomicBoolean();

    public static final AtomicBoolean f1576e = new AtomicBoolean();

    public static int m2367a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo("com.google.android.gms", 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            Log.w("GooglePlayServicesUtil", "Google Play services is missing.");
            return 0;
        }
    }

    public static boolean m2368b(Context context) {
        if (!f1575d) {
            try {
                try {
                    PackageInfo packageInfoM10890c = C2670zp.m11048a(context).m10890c("com.google.android.gms", 64);
                    C0528Lc.m2656a(context);
                    if (packageInfoM10890c == null || C0528Lc.m2658e(packageInfoM10890c, false) || !C0528Lc.m2658e(packageInfoM10890c, true)) {
                        f1574c = false;
                    } else {
                        f1574c = true;
                    }
                } catch (PackageManager.NameNotFoundException e) {
                    Log.w("GooglePlayServicesUtil", "Cannot find Google Play services package name.", e);
                }
                f1575d = true;
            } catch (Throwable th) {
                f1575d = true;
                throw th;
            }
        }
        return f1574c || !AbstractC0745Q8.m3633a();
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00a4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int m2369c(Context r10, int r11) throws PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 286
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0482Kc.m2369c(android.content.Context, int):int");
    }

    public static boolean m2370d(Context context, int i) {
        if (i == 18) {
            return true;
        }
        if (i == 1) {
            return m2373g(context, "com.google.android.gms");
        }
        return false;
    }

    public static boolean m2371e(Context context) {
        if (!AbstractC0993Vi.m4413b()) {
            return false;
        }
        Object systemService = context.getSystemService("user");
        AbstractC1085Xi.m4801j(systemService);
        Bundle applicationRestrictions = ((UserManager) systemService).getApplicationRestrictions(context.getPackageName());
        return applicationRestrictions != null && "true".equals(applicationRestrictions.getString("restricted_profile"));
    }

    public static boolean m2372f(Context context, int i, String str) {
        return AbstractC1792go.m7753b(context, i, str);
    }

    public static boolean m2373g(Context context, String str) throws PackageManager.NameNotFoundException {
        ApplicationInfo applicationInfo;
        boolean zEquals = str.equals("com.google.android.gms");
        if (AbstractC0993Vi.m4416e()) {
            try {
                Iterator<PackageInstaller.SessionInfo> it = context.getPackageManager().getPackageInstaller().getAllSessions().iterator();
                while (it.hasNext()) {
                    if (str.equals(it.next().getAppPackageName())) {
                        return true;
                    }
                }
            } catch (Exception unused) {
                return false;
            }
        }
        try {
            applicationInfo = context.getPackageManager().getApplicationInfo(str, 8192);
        } catch (PackageManager.NameNotFoundException unused2) {
        }
        return zEquals ? applicationInfo.enabled : applicationInfo.enabled && !m2371e(context);
    }
}
