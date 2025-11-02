package p000;

import android.content.Context;
import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbstractC0880T6 {

    public static final String[] f2711a = {"android.", "com.android.", "dalvik.", "java.", "javax."};

    public static boolean m4117a(Context context, Throwable th) {
        try {
            AbstractC1085Xi.m4801j(context);
            AbstractC1085Xi.m4801j(th);
            return false;
        } catch (Exception e) {
            Log.e("CrashUtils", "Error adding exception to DropBox!", e);
            return false;
        }
    }
}
