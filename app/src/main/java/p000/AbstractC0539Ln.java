package p000;

import android.os.Trace;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class AbstractC0539Ln {

    public static long f1732a;

    public static Method f1733b;

    public static void m2732a(String str) {
        AbstractC0585Mn.m2963a(str);
    }

    public static void m2733b() {
        AbstractC0585Mn.m2964b();
    }

    public static void m2734c(String str, Exception exc) {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = exc.getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw ((RuntimeException) cause);
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static boolean m2735d() {
        try {
            if (f1733b == null) {
                return Trace.isEnabled();
            }
        } catch (NoClassDefFoundError | NoSuchMethodError unused) {
        }
        return m2736e();
    }

    public static boolean m2736e() {
        try {
            if (f1733b == null) {
                f1732a = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                f1733b = Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            return ((Boolean) f1733b.invoke(null, Long.valueOf(f1732a))).booleanValue();
        } catch (Exception e) {
            m2734c("isTagEnabled", e);
            return false;
        }
    }
}
