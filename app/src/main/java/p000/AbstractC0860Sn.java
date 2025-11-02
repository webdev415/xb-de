package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0860Sn {
    public static Object m4073a(Object obj, int i) {
        if (obj != null && !m4075c(obj, i)) {
            m4078f(obj, "kotlin.jvm.functions.Function" + i);
        }
        return obj;
    }

    public static int m4074b(Object obj) {
        if (obj instanceof InterfaceC2335sc) {
            return ((InterfaceC2335sc) obj).mo133e();
        }
        if (obj instanceof InterfaceC0894Tb) {
            return 0;
        }
        if (obj instanceof InterfaceC0986Vb) {
            return 1;
        }
        return obj instanceof InterfaceC1920jc ? 2 : -1;
    }

    public static boolean m4075c(Object obj, int i) {
        return (obj instanceof InterfaceC1733fc) && m4074b(obj) == i;
    }

    public static Throwable m4076d(Throwable th) {
        return AbstractC0116Ce.m480i(th, AbstractC0860Sn.class.getName());
    }

    public static ClassCastException m4077e(ClassCastException classCastException) {
        throw ((ClassCastException) m4076d(classCastException));
    }

    public static void m4078f(Object obj, String str) {
        m4079g((obj == null ? "null" : obj.getClass().getName()) + " cannot be cast to " + str);
    }

    public static void m4079g(String str) {
        throw m4077e(new ClassCastException(str));
    }
}
