package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class C0603N4 {

    public static final a f1903d = new a(null);

    public final Method f1904a;

    public final Method f1905b;

    public final Method f1906c;

    public static final class a {
        public a() {
        }

        public final C0603N4 m3291a() throws NoSuchMethodException, ClassNotFoundException, SecurityException {
            Method method;
            Method method2;
            Method method3 = null;
            try {
                Class<?> cls = Class.forName("dalvik.system.CloseGuard");
                Method method4 = cls.getMethod("get", null);
                method2 = cls.getMethod("open", String.class);
                method = cls.getMethod("warnIfOpen", null);
                method3 = method4;
            } catch (Exception unused) {
                method = null;
                method2 = null;
            }
            return new C0603N4(method3, method2, method);
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0603N4(Method method, Method method2, Method method3) {
        this.f1904a = method;
        this.f1905b = method2;
        this.f1906c = method3;
    }

    public final Object m3289a(String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(str, "closer");
        Method method = this.f1904a;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(null, null);
                Method method2 = this.f1905b;
                AbstractC0116Ce.m473b(method2);
                method2.invoke(objInvoke, str);
                return objInvoke;
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public final boolean m3290b(Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (obj != null) {
            try {
                Method method = this.f1906c;
                AbstractC0116Ce.m473b(method);
                method.invoke(obj, null);
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
