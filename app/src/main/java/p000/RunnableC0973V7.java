package p000;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

public final class RunnableC0973V7 extends AbstractC2010la implements Runnable {
    private static volatile Thread _thread;
    private static volatile int debugStatus;

    public static final RunnableC0973V7 f2938t;

    public static final long f2939u;

    static {
        Long l;
        RunnableC0973V7 runnableC0973V7 = new RunnableC0973V7();
        f2938t = runnableC0973V7;
        AbstractC1964ka.m8264b0(runnableC0973V7, false, 1, null);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        try {
            l = Long.getLong("kotlinx.coroutines.DefaultExecutor.keepAlive", 1000L);
        } catch (SecurityException unused) {
            l = 1000L;
        }
        f2939u = timeUnit.toNanos(l.longValue());
    }

    @Override
    public Thread mo3473f0() {
        Thread thread = _thread;
        return thread == null ? m4335s0() : thread;
    }

    @Override
    public void mo4333j0(Runnable runnable) {
        if (m4336t0()) {
            m4339w0();
        }
        super.mo4333j0(runnable);
    }

    public final synchronized void m4334r0() {
        if (m4337u0()) {
            debugStatus = 3;
            m8392p0();
            AbstractC0116Ce.m474c(this, "null cannot be cast to non-null type java.lang.Object");
            notifyAll();
        }
    }

    @Override
    public void run() {
        boolean zM8389m0;
        C2576xn.f8026a.m10783c(this);
        AbstractC0644O.m3350a();
        try {
            if (!m4338v0()) {
                if (zM8389m0) {
                    return;
                } else {
                    return;
                }
            }
            long j = Long.MAX_VALUE;
            while (true) {
                Thread.interrupted();
                long jM8390n0 = m8390n0();
                if (jM8390n0 == Long.MAX_VALUE) {
                    AbstractC0644O.m3350a();
                    long jNanoTime = System.nanoTime();
                    if (j == Long.MAX_VALUE) {
                        j = f2939u + jNanoTime;
                    }
                    long j2 = j - jNanoTime;
                    if (j2 <= 0) {
                        _thread = null;
                        m4334r0();
                        AbstractC0644O.m3350a();
                        if (m8389m0()) {
                            return;
                        }
                        mo3473f0();
                        return;
                    }
                    jM8390n0 = AbstractC1132Yj.m4983d(jM8390n0, j2);
                } else {
                    j = Long.MAX_VALUE;
                }
                if (jM8390n0 > 0) {
                    if (m4337u0()) {
                        _thread = null;
                        m4334r0();
                        AbstractC0644O.m3350a();
                        if (m8389m0()) {
                            return;
                        }
                        mo3473f0();
                        return;
                    }
                    AbstractC0644O.m3350a();
                    LockSupport.parkNanos(this, jM8390n0);
                }
            }
        } finally {
            _thread = null;
            m4334r0();
            AbstractC0644O.m3350a();
            if (!m8389m0()) {
                mo3473f0();
            }
        }
    }

    public final synchronized Thread m4335s0() {
        Thread thread;
        thread = _thread;
        if (thread == null) {
            thread = new Thread(this, "kotlinx.coroutines.DefaultExecutor");
            _thread = thread;
            thread.setDaemon(true);
            thread.start();
        }
        return thread;
    }

    @Override
    public void shutdown() {
        debugStatus = 4;
        super.shutdown();
    }

    public final boolean m4336t0() {
        return debugStatus == 4;
    }

    public final boolean m4337u0() {
        int i = debugStatus;
        return i == 2 || i == 3;
    }

    public final synchronized boolean m4338v0() {
        if (m4337u0()) {
            return false;
        }
        debugStatus = 1;
        AbstractC0116Ce.m474c(this, "null cannot be cast to non-null type java.lang.Object");
        notifyAll();
        return true;
    }

    public final void m4339w0() {
        throw new RejectedExecutionException("DefaultExecutor was shut down. This error indicates that Dispatchers.shutdown() was invoked prior to completion of exiting coroutines, leaving coroutines in incomplete state. Please refer to Dispatchers.shutdown documentation for more details");
    }
}
