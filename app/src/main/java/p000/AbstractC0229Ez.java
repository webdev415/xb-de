package p000;

import android.content.Context;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbstractC0229Ez {

    public static UserManager f607a;

    public static volatile boolean f608b = !m1159a();

    public static boolean m1159a() {
        return true;
    }

    public static boolean m1160b(Context context) {
        return m1159a() && !m1162d(context);
    }

    public static boolean m1161c(Context context) {
        return !m1159a() || m1162d(context);
    }

    public static boolean m1162d(Context context) {
        if (f608b) {
            return true;
        }
        synchronized (AbstractC0229Ez.class) {
            try {
                if (f608b) {
                    return true;
                }
                boolean zM1163e = m1163e(context);
                if (zM1163e) {
                    f608b = zM1163e;
                }
                return zM1163e;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static boolean m1163e(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (f607a == null) {
                f607a = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = f607a;
            if (userManager == null) {
                return true;
            }
            try {
                if (userManager.isUserUnlocked()) {
                    break;
                }
                if (userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
            } catch (NullPointerException e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                f607a = null;
                i++;
            }
        }
        z = z2;
        if (z) {
            f607a = null;
        }
        return z;
    }
}
