package p000;

import java.util.Objects;

/* loaded from: classes.dex */
public abstract class AbstractC0349Hh {
    public static boolean m1589a(Object obj, Object obj2) {
        return Objects.equals(obj, obj2);
    }

    public static int m1590b(Object... objArr) {
        return Objects.hash(objArr);
    }

    public static Object m1591c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }
}
