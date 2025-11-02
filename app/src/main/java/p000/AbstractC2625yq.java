package p000;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbstractC2625yq {

    public static final Object f8144a = new Object();

    public static boolean f8145b;

    public static String f8146c;

    public static int f8147d;

    public static int m10967a(Context context) {
        m10968b(context);
        return f8147d;
    }

    public static void m10968b(Context context) {
        Bundle bundle;
        synchronized (f8144a) {
            try {
                if (f8145b) {
                    return;
                }
                f8145b = true;
                try {
                    bundle = C2670zp.m11048a(context).m10889b(context.getPackageName(), 128).metaData;
                } catch (PackageManager.NameNotFoundException e) {
                    Log.wtf("MetadataValueReader", "This should never happen.", e);
                }
                if (bundle == null) {
                    return;
                }
                f8146c = bundle.getString("com.google.app.id");
                f8147d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
