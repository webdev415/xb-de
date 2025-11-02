package p000;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class C2471va extends AbstractC2425ua implements InterfaceC2091n8 {

    public final Executor f7664o;

    public C2471va(Executor executor) {
        this.f7664o = executor;
        AbstractC1155Z5.m5019a(m10345X());
    }

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        try {
            Executor executorM10345X = m10345X();
            AbstractC0644O.m3350a();
            executorM10345X.execute(runnable);
        } catch (RejectedExecutionException e) {
            AbstractC0644O.m3350a();
            m10344W(interfaceC0191E6, e);
            C1158Z8.m5024b().mo1351T(interfaceC0191E6, runnable);
        }
    }

    public final void m10344W(InterfaceC0191E6 interfaceC0191E6, RejectedExecutionException rejectedExecutionException) {
        AbstractC1736ff.m7584c(interfaceC0191E6, AbstractC2195pa.m9058a("The task was rejected", rejectedExecutionException));
    }

    public Executor m10345X() {
        return this.f7664o;
    }

    @Override
    public void close() {
        Executor executorM10345X = m10345X();
        ExecutorService executorService = executorM10345X instanceof ExecutorService ? (ExecutorService) executorM10345X : null;
        if (executorService != null) {
            executorService.shutdown();
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C2471va) && ((C2471va) obj).m10345X() == m10345X();
    }

    public int hashCode() {
        return System.identityHashCode(m10345X());
    }

    @Override
    public String toString() {
        return m10345X().toString();
    }
}
