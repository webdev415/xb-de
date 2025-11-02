package p000;

import android.os.Looper;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class AbstractC1085Xi {
    public static void m4792a(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void m4793b(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void m4794c(String str) {
        if (!AbstractC2304rr.m9452a()) {
            throw new IllegalStateException(str);
        }
    }

    public static String m4795d(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Given String is empty or null");
        }
        return str;
    }

    public static String m4796e(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
        return str;
    }

    public static void m4797f() {
        m4798g("Must not be called on GoogleApiHandler thread.");
    }

    public static void m4798g(String str) {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper != null) {
            String name = looperMyLooper.getThread().getName();
            if (name == "GoogleApiHandler" || (name != null && name.equals("GoogleApiHandler"))) {
                throw new IllegalStateException(str);
            }
        }
    }

    public static void m4799h() {
        m4800i("Must not be called on the main application thread");
    }

    public static void m4800i(String str) {
        if (AbstractC2304rr.m9452a()) {
            throw new IllegalStateException(str);
        }
    }

    public static Object m4801j(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("null reference");
    }

    public static Object m4802k(Object obj, Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(String.valueOf(obj2));
    }

    public static int m4803l(int i) {
        if (i != 0) {
            return i;
        }
        throw new IllegalArgumentException("Given Integer is zero");
    }

    public static void m4804m(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void m4805n(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
