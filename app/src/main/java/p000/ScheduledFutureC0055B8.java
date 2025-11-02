package p000;

import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ScheduledFutureC0055B8 extends AbstractC0460K implements ScheduledFuture {

    public final ScheduledFuture f137s;

    public class a implements b {
        public a() {
        }

        @Override
        public void mo214a(Throwable th) {
            ScheduledFutureC0055B8.this.mo1595t(th);
        }

        @Override
        public void set(Object obj) {
            ScheduledFutureC0055B8.this.mo1594s(obj);
        }
    }

    public interface b {
        void mo214a(Throwable th);

        void set(Object obj);
    }

    public interface c {
        ScheduledFuture mo215a(b bVar);
    }

    public ScheduledFutureC0055B8(c cVar) {
        this.f137s = cVar.mo215a(new a());
    }

    @Override
    public void mo212g() {
        this.f137s.cancel(m2230v());
    }

    @Override
    public long getDelay(TimeUnit timeUnit) {
        return this.f137s.getDelay(timeUnit);
    }

    @Override
    public int compareTo(Delayed delayed) {
        return this.f137s.compareTo(delayed);
    }
}
