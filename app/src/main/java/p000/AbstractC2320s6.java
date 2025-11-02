package p000;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import java.io.File;

public abstract class AbstractC2320s6 {

    public static final Object f7014a = new Object();

    public static class a {
        public static File m9513a(Context context) {
            return context.getCodeCacheDir();
        }

        public static Drawable m9514b(Context context, int i) {
            return context.getDrawable(i);
        }

        public static File m9515c(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    public static class b {
        public static Context m9516a(Context context) {
            return context.createDeviceProtectedStorageContext();
        }

        public static File m9517b(Context context) {
            return context.getDataDir();
        }

        public static boolean m9518c(Context context) {
            return context.isDeviceProtectedStorage();
        }
    }

    public static class c {
        public static Intent m9519a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            return ((i & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i & 1) : context.registerReceiver(broadcastReceiver, intentFilter, AbstractC2320s6.m9510f(context), handler);
        }

        public static ComponentName m9520b(Context context, Intent intent) {
            return context.startForegroundService(intent);
        }
    }

    public static class d {
        public static Intent m9521a(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
            return context.registerReceiver(broadcastReceiver, intentFilter, str, handler, i);
        }
    }

    public static int m9505a(Context context, String str) {
        AbstractC0349Hh.m1591c(str, "permission must be non-null");
        return (Build.VERSION.SDK_INT >= 33 || !TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) ? context.checkPermission(str, Process.myPid(), Process.myUid()) : C2662zh.m11034b(context).m11035a() ? 0 : -1;
    }

    public static Context m9506b(Context context) {
        return b.m9516a(context);
    }

    public static Drawable m9507c(Context context, int i) {
        return a.m9514b(context, i);
    }

    public static File[] m9508d(Context context) {
        return context.getExternalCacheDirs();
    }

    public static File[] m9509e(Context context, String str) {
        return context.getExternalFilesDirs(str);
    }

    public static String m9510f(Context context) {
        String str = context.getPackageName() + ".DYNAMIC_RECEIVER_NOT_EXPORTED_PERMISSION";
        if (AbstractC0488Ki.m2382b(context, str) == 0) {
            return str;
        }
        throw new RuntimeException("Permission " + str + " is required by your application to receive broadcasts, please add it to your manifest");
    }

    public static Intent m9511g(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return m9512h(context, broadcastReceiver, intentFilter, null, null, i);
    }

    public static Intent m9512h(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        int i2 = i & 1;
        if (i2 != 0 && (i & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_VISIBLE_TO_INSTANT_APPS and RECEIVER_NOT_EXPORTED");
        }
        if (i2 != 0) {
            i |= 2;
        }
        int i3 = i;
        int i4 = i3 & 2;
        if (i4 == 0 && (i3 & 4) == 0) {
            throw new IllegalArgumentException("One of either RECEIVER_EXPORTED or RECEIVER_NOT_EXPORTED is required");
        }
        if (i4 != 0 && (i3 & 4) != 0) {
            throw new IllegalArgumentException("Cannot specify both RECEIVER_EXPORTED and RECEIVER_NOT_EXPORTED");
        }
        int i5 = Build.VERSION.SDK_INT;
        return i5 >= 33 ? d.m9521a(context, broadcastReceiver, intentFilter, str, handler, i3) : i5 >= 26 ? c.m9519a(context, broadcastReceiver, intentFilter, str, handler, i3) : ((i3 & 4) == 0 || str != null) ? context.registerReceiver(broadcastReceiver, intentFilter, str, handler) : context.registerReceiver(broadcastReceiver, intentFilter, m9510f(context), handler);
    }
}
