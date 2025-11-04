package p000;

import android.app.Activity;
import android.app.SharedElementCallback;
import android.os.Build;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.HashSet;

public abstract class AbstractC2129o0 extends AbstractC2320s6 {

    public static class a {
        public static void m8828a(Object obj) {
            ((SharedElementCallback.OnSharedElementsReadyListener) obj).onSharedElementsReady();
        }

        public static void m8829b(Activity activity, String[] strArr, int i) {
            activity.requestPermissions(strArr, i);
        }

        public static boolean m8830c(Activity activity, String str) {
            return activity.shouldShowRequestPermissionRationale(str);
        }
    }

    public interface b {
    }

    public interface c {
        void mo5378a(int i);
    }

    public static b m8826i() {
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void m8827j(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException("Permission request for permissions " + Arrays.toString(strArr) + " must not contain null or empty values");
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (activity instanceof c) {
            ((c) activity).mo5378a(i);
        }
        a.m8829b(activity, strArr, i);
    }
}
