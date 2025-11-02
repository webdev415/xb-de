package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1177Zi {
    public static void m5049a(boolean z, String str) {
        if (!z) {
            throw new IllegalArgumentException(str);
        }
    }

    public static Object m5050b(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object m5051c(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static void m5052d(boolean z, String str) {
        if (!z) {
            throw new IllegalStateException(str);
        }
    }
}
