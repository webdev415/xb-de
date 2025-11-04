package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;

public abstract class AbstractC1792go {
    public static boolean m7752a(Context context, int i) throws PackageManager.NameNotFoundException {
        if (!m7753b(context, i, "com.google.android.gms")) {
            return false;
        }
        try {
            return C0528Lc.m2656a(context).m2659b(context.getPackageManager().getPackageInfo("com.google.android.gms", 64));
        } catch (PackageManager.NameNotFoundException unused) {
            if (!Log.isLoggable("UidVerifier", 3)) {
                return false;
            }
            Log.d("UidVerifier", "Package manager can't find google play services package, defaulting to false");
            return false;
        }
    }

    public static boolean m7753b(Context context, int i, String str) {
        return C2670zp.m11048a(context).m10892e(i, str);
    }
}
