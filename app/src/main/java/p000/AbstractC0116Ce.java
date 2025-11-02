package p000;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbstractC0116Ce {
    public static boolean m472a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static void m473b(Object obj) {
        if (obj == null) {
            m482k();
        }
    }

    public static void m474c(Object obj, String str) {
        if (obj == null) {
            m483l(str);
        }
    }

    public static void m475d(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) m479h(new NullPointerException(str + " must not be null")));
    }

    public static void m476e(Object obj, String str) {
        if (obj == null) {
            m484m(str);
        }
    }

    public static int m477f(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static String m478g(String str) {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        String name = AbstractC0116Ce.class.getName();
        int i = 0;
        while (!stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        while (stackTrace[i].getClassName().equals(name)) {
            i++;
        }
        StackTraceElement stackTraceElement = stackTrace[i];
        return "Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str;
    }

    public static Throwable m479h(Throwable th) {
        return m480i(th, AbstractC0116Ce.class.getName());
    }

    public static Throwable m480i(Throwable th, String str) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        th.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return th;
    }

    public static String m481j(String str, Object obj) {
        return str + obj;
    }

    public static void m482k() {
        throw ((NullPointerException) m479h(new NullPointerException()));
    }

    public static void m483l(String str) {
        throw ((NullPointerException) m479h(new NullPointerException(str)));
    }

    public static void m484m(String str) {
        throw ((NullPointerException) m479h(new NullPointerException(m478g(str))));
    }

    public static void m485n(String str) {
        throw ((C2024lo) m479h(new C2024lo(str)));
    }

    public static void m486o(String str) {
        m485n("lateinit property " + str + " has not been initialized");
    }
}
