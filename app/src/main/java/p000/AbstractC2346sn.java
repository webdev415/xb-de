package p000;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public abstract class AbstractC2346sn {
    public static Object m9590a(AbstractC1838hn abstractC1838hn) throws InterruptedException {
        AbstractC1085Xi.m4799h();
        AbstractC1085Xi.m4797f();
        AbstractC1085Xi.m4802k(abstractC1838hn, "Task must not be null");
        if (abstractC1838hn.mo4725g()) {
            return m9594e(abstractC1838hn);
        }
        C1980kq c1980kq = new C1980kq(null);
        m9595f(abstractC1838hn, c1980kq);
        c1980kq.m8305d();
        return m9594e(abstractC1838hn);
    }

    public static Object m9591b(AbstractC1838hn abstractC1838hn, long j, TimeUnit timeUnit) throws TimeoutException {
        AbstractC1085Xi.m4799h();
        AbstractC1085Xi.m4797f();
        AbstractC1085Xi.m4802k(abstractC1838hn, "Task must not be null");
        AbstractC1085Xi.m4802k(timeUnit, "TimeUnit must not be null");
        if (abstractC1838hn.mo4725g()) {
            return m9594e(abstractC1838hn);
        }
        C1980kq c1980kq = new C1980kq(null);
        m9595f(abstractC1838hn, c1980kq);
        if (c1980kq.m8306e(j, timeUnit)) {
            return m9594e(abstractC1838hn);
        }
        throw new TimeoutException("Timed out waiting for Task");
    }

    public static AbstractC1838hn m9592c(Executor executor, Callable callable) {
        AbstractC1085Xi.m4802k(executor, "Executor must not be null");
        AbstractC1085Xi.m4802k(callable, "Callback must not be null");
        C1076XI c1076xi = new C1076XI();
        executor.execute(new RunnableC1871iJ(c1076xi, callable));
        return c1076xi;
    }

    public static AbstractC1838hn m9593d(Object obj) {
        C1076XI c1076xi = new C1076XI();
        c1076xi.m4728j(obj);
        return c1076xi;
    }

    public static Object m9594e(AbstractC1838hn abstractC1838hn) throws ExecutionException {
        if (abstractC1838hn.mo4726h()) {
            return abstractC1838hn.mo4723e();
        }
        if (abstractC1838hn.mo4724f()) {
            throw new CancellationException("Task is already canceled");
        }
        throw new ExecutionException(abstractC1838hn.mo4722d());
    }

    public static void m9595f(AbstractC1838hn abstractC1838hn, InterfaceC2165oq interfaceC2165oq) {
        Executor executor = AbstractC2069mn.f6257b;
        abstractC1838hn.mo4721c(executor, interfaceC2165oq);
        abstractC1838hn.mo4720b(executor, interfaceC2165oq);
        abstractC1838hn.mo4719a(executor, interfaceC2165oq);
    }
}
