package p000;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import p000.ScheduledFutureC0055B8;

public class ScheduledExecutorServiceC0009A8 implements ScheduledExecutorService {

    public final ExecutorService f37l;

    public final ScheduledExecutorService f38m;

    public ScheduledExecutorServiceC0009A8(ExecutorService executorService, ScheduledExecutorService scheduledExecutorService) {
        this.f37l = executorService;
        this.f38m = scheduledExecutorService;
    }

    public static void m49m(Runnable runnable, ScheduledFutureC0055B8.b bVar) {
        try {
            runnable.run();
            bVar.set(null);
        } catch (Exception e) {
            bVar.mo214a(e);
        }
    }

    public static void m50p(Callable callable, ScheduledFutureC0055B8.b bVar) {
        try {
            bVar.set(callable.call());
        } catch (Exception e) {
            bVar.mo214a(e);
        }
    }

    public static void m51s(Runnable runnable, ScheduledFutureC0055B8.b bVar) throws Exception {
        try {
            runnable.run();
        } catch (Exception e) {
            bVar.mo214a(e);
            throw e;
        }
    }

    public static void m52x(Runnable runnable, ScheduledFutureC0055B8.b bVar) {
        try {
            runnable.run();
        } catch (Exception e) {
            bVar.mo214a(e);
        }
    }

    @Override
    public boolean awaitTermination(long j, TimeUnit timeUnit) {
        return this.f37l.awaitTermination(j, timeUnit);
    }

    @Override
    public void execute(Runnable runnable) {
        this.f37l.execute(runnable);
    }

    @Override
    public List invokeAll(Collection collection) {
        return this.f37l.invokeAll(collection);
    }

    @Override
    public Object invokeAny(Collection collection) {
        return this.f37l.invokeAny(collection);
    }

    @Override
    public boolean isShutdown() {
        return this.f37l.isShutdown();
    }

    @Override
    public boolean isTerminated() {
        return this.f37l.isTerminated();
    }

    public final void m53n(final Runnable runnable, final ScheduledFutureC0055B8.b bVar) {
        this.f37l.execute(new Runnable() {
            @Override
            public final void run() {
                ScheduledExecutorServiceC0009A8.m49m(runnable, bVar);
            }
        });
    }

    public final ScheduledFuture m54o(final Runnable runnable, long j, TimeUnit timeUnit, final ScheduledFutureC0055B8.b bVar) {
        return this.f38m.schedule(new Runnable() {
            @Override
            public final void run() {
                this.f7654l.m53n(runnable, bVar);
            }
        }, j, timeUnit);
    }

    public final Future m55q(final Callable callable, final ScheduledFutureC0055B8.b bVar) {
        return this.f37l.submit(new Runnable() {
            @Override
            public final void run() {
                ScheduledExecutorServiceC0009A8.m50p(callable, bVar);
            }
        });
    }

    public final ScheduledFuture m56r(final Callable callable, long j, TimeUnit timeUnit, final ScheduledFutureC0055B8.b bVar) {
        return this.f38m.schedule(new Callable() {
            @Override
            public final Object call() {
                return this.f7804a.m55q(callable, bVar);
            }
        }, j, timeUnit);
    }

    @Override
    public ScheduledFuture schedule(final Runnable runnable, final long j, final TimeUnit timeUnit) {
        return new ScheduledFutureC0055B8(new ScheduledFutureC0055B8.c() {
            @Override
            public final ScheduledFuture mo215a(ScheduledFutureC0055B8.b bVar) {
                return this.f6537a.m54o(runnable, j, timeUnit, bVar);
            }
        });
    }

    @Override
    public ScheduledFuture scheduleAtFixedRate(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        return new ScheduledFutureC0055B8(new ScheduledFutureC0055B8.c() {
            @Override
            public final ScheduledFuture mo215a(ScheduledFutureC0055B8.b bVar) {
                return this.f6903a.m58u(runnable, j, j2, timeUnit, bVar);
            }
        });
    }

    @Override
    public ScheduledFuture scheduleWithFixedDelay(final Runnable runnable, final long j, final long j2, final TimeUnit timeUnit) {
        return new ScheduledFutureC0055B8(new ScheduledFutureC0055B8.c() {
            @Override
            public final ScheduledFuture mo215a(ScheduledFutureC0055B8.b bVar) {
                return this.f7018a.m60w(runnable, j, j2, timeUnit, bVar);
            }
        });
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override
    public List shutdownNow() {
        throw new UnsupportedOperationException("Shutting down is not allowed.");
    }

    @Override
    public Future submit(Runnable runnable) {
        return this.f37l.submit(runnable);
    }

    public final void m57t(final Runnable runnable, final ScheduledFutureC0055B8.b bVar) {
        this.f37l.execute(new Runnable() {
            @Override
            public final void run() throws Exception {
                ScheduledExecutorServiceC0009A8.m51s(runnable, bVar);
            }
        });
    }

    public final ScheduledFuture m58u(final Runnable runnable, long j, long j2, TimeUnit timeUnit, final ScheduledFutureC0055B8.b bVar) {
        return this.f38m.scheduleAtFixedRate(new Runnable() {
            @Override
            public final void run() {
                this.f7372l.m57t(runnable, bVar);
            }
        }, j, j2, timeUnit);
    }

    public final void m59v(final Runnable runnable, final ScheduledFutureC0055B8.b bVar) {
        this.f37l.execute(new Runnable() {
            @Override
            public final void run() {
                ScheduledExecutorServiceC0009A8.m52x(runnable, bVar);
            }
        });
    }

    public final ScheduledFuture m60w(final Runnable runnable, long j, long j2, TimeUnit timeUnit, final ScheduledFutureC0055B8.b bVar) {
        return this.f38m.scheduleWithFixedDelay(new Runnable() {
            @Override
            public final void run() {
                this.f7942l.m59v(runnable, bVar);
            }
        }, j, j2, timeUnit);
    }

    @Override
    public List invokeAll(Collection collection, long j, TimeUnit timeUnit) {
        return this.f37l.invokeAll(collection, j, timeUnit);
    }

    @Override
    public Object invokeAny(Collection collection, long j, TimeUnit timeUnit) {
        return this.f37l.invokeAny(collection, j, timeUnit);
    }

    @Override
    public ScheduledFuture schedule(final Callable callable, final long j, final TimeUnit timeUnit) {
        return new ScheduledFutureC0055B8(new ScheduledFutureC0055B8.c() {
            @Override
            public final ScheduledFuture mo215a(ScheduledFutureC0055B8.b bVar) {
                return this.f7186a.m56r(callable, j, timeUnit, bVar);
            }
        });
    }

    @Override
    public Future submit(Runnable runnable, Object obj) {
        return this.f37l.submit(runnable, obj);
    }

    @Override
    public Future submit(Callable callable) {
        return this.f37l.submit(callable);
    }
}
