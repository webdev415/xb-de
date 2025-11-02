package p000;

import android.app.AppOpsManager;
import android.content.Context;
import android.os.Binder;
import android.os.Build;

public abstract class AbstractC1058X0 {

    public static class a {
        public static <T> T m4611a(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        public static int m4612b(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOp(str, str2);
        }

        public static int m4613c(AppOpsManager appOpsManager, String str, String str2) {
            return appOpsManager.noteProxyOpNoThrow(str, str2);
        }

        public static String m4614d(String str) {
            return AppOpsManager.permissionToOp(str);
        }
    }

    public static class b {
        public static int m4615a(AppOpsManager appOpsManager, String str, int i, String str2) {
            if (appOpsManager == null) {
                return 1;
            }
            return appOpsManager.checkOpNoThrow(str, i, str2);
        }

        public static String m4616b(Context context) {
            return context.getOpPackageName();
        }

        public static AppOpsManager m4617c(Context context) {
            return (AppOpsManager) context.getSystemService(AppOpsManager.class);
        }
    }

    public static int m4608a(Context context, int i, String str, String str2) {
        if (Build.VERSION.SDK_INT < 29) {
            return m4609b(context, str, str2);
        }
        AppOpsManager appOpsManagerM4617c = b.m4617c(context);
        int iM4615a = b.m4615a(appOpsManagerM4617c, str, Binder.getCallingUid(), str2);
        return iM4615a != 0 ? iM4615a : b.m4615a(appOpsManagerM4617c, str, i, b.m4616b(context));
    }

    public static int m4609b(Context context, String str, String str2) {
        return a.m4613c((AppOpsManager) a.m4611a(context, AppOpsManager.class), str, str2);
    }

    public static String m4610c(String str) {
        return a.m4614d(str);
    }
}
