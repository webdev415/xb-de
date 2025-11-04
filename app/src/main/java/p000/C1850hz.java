package p000;

import java.lang.Thread;

public final class C1850hz implements Thread.UncaughtExceptionHandler {

    public final String f5778a;

    public final C1662dz f5779b;

    public C1850hz(C1662dz c1662dz, String str) {
        this.f5779b = c1662dz;
        AbstractC1085Xi.m4801j(str);
        this.f5778a = str;
    }

    @Override
    public final synchronized void uncaughtException(Thread thread, Throwable th) {
        this.f5779b.mo349g().m9618G().m10617b(this.f5778a, th);
    }
}
