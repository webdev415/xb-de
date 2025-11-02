package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class C0855Si {

    public static final class a {

        public static final a f2647a = new a();

        public static final Method f2648b;

        public static final Method f2649c;

        static {
            Method method;
            Method method2;
            Method[] methods = Throwable.class.getMethods();
            AbstractC0116Ce.m475d(methods, "throwableMethods");
            int length = methods.length;
            int i = 0;
            int i2 = 0;
            while (true) {
                method = null;
                if (i2 >= length) {
                    method2 = null;
                    break;
                }
                method2 = methods[i2];
                if (AbstractC0116Ce.m472a(method2.getName(), "addSuppressed")) {
                    Class<?>[] parameterTypes = method2.getParameterTypes();
                    AbstractC0116Ce.m475d(parameterTypes, "it.parameterTypes");
                    if (AbstractC0116Ce.m472a(AbstractC0002A1.m11r(parameterTypes), Throwable.class)) {
                        break;
                    }
                }
                i2++;
            }
            f2648b = method2;
            int length2 = methods.length;
            while (true) {
                if (i >= length2) {
                    break;
                }
                Method method3 = methods[i];
                if (AbstractC0116Ce.m472a(method3.getName(), "getSuppressed")) {
                    method = method3;
                    break;
                }
                i++;
            }
            f2649c = method;
        }
    }

    public void mo3420a(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(th, "cause");
        AbstractC0116Ce.m476e(th2, "exception");
        Method method = a.f2648b;
        if (method != null) {
            method.invoke(th, th2);
        }
    }

    public AbstractC0994Vj mo3562b() {
        return new C0480Ka();
    }
}
