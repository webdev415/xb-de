package p000;

import java.util.concurrent.locks.LockSupport;

public abstract class AbstractC2056ma extends AbstractC1964ka {
    public abstract Thread mo3473f0();

    public final void m8460g0() {
        Thread threadMo3473f0 = mo3473f0();
        if (Thread.currentThread() != threadMo3473f0) {
            AbstractC0644O.m3350a();
            LockSupport.unpark(threadMo3473f0);
        }
    }
}
