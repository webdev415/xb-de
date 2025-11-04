package p000;

import java.lang.reflect.InvocationTargetException;

public abstract class AbstractC0467K6 {
    public static final void m2289a(InterfaceC0191E6 interfaceC0191E6, Throwable th) {
        try {
            InterfaceC0329H6 interfaceC0329H6 = (InterfaceC0329H6) interfaceC0191E6.mo855b(InterfaceC0329H6.f1018b);
            if (interfaceC0329H6 != null) {
                interfaceC0329H6.mo1511g(interfaceC0191E6, th);
            } else {
                AbstractC0421J6.m1821a(interfaceC0191E6, th);
            }
        } catch (Throwable th2) {
            AbstractC0421J6.m1821a(interfaceC0191E6, m2290b(th, th2));
        }
    }

    public static final Throwable m2290b(Throwable th, Throwable th2) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (th == th2) {
            return th;
        }
        RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
        AbstractC2241qa.m9151a(runtimeException, th);
        return runtimeException;
    }
}
