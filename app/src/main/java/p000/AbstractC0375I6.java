package p000;

import java.util.Collection;
import java.util.ServiceLoader;

public abstract class AbstractC0375I6 {

    public static final Collection f1132a = AbstractC0261Fl.m1280j(AbstractC0169Dl.m731a(ServiceLoader.load(InterfaceC0329H6.class, InterfaceC0329H6.class.getClassLoader()).iterator()));

    public static final Collection m1675a() {
        return f1132a;
    }

    public static final void m1676b(Throwable th) {
        Thread threadCurrentThread = Thread.currentThread();
        threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, th);
    }
}
