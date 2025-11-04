package p000;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class C0125Cn {

    public boolean f307a;

    public long f308b;

    public long f309c;

    public static final b f306e = new b(null);

    public static final C0125Cn f305d = new a();

    public static final class b {
        public b() {
        }

        public b(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0125Cn mo433a() {
        this.f307a = false;
        return this;
    }

    public C0125Cn mo434b() {
        this.f309c = 0L;
        return this;
    }

    public long mo435c() {
        if (this.f307a) {
            return this.f308b;
        }
        throw new IllegalStateException("No deadline".toString());
    }

    public C0125Cn mo436d(long j) {
        this.f307a = true;
        this.f308b = j;
        return this;
    }

    public boolean mo437e() {
        return this.f307a;
    }

    public void mo438f() throws InterruptedIOException {
        if (Thread.interrupted()) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("interrupted");
        }
        if (this.f307a && this.f308b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public C0125Cn mo439g(long j, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(timeUnit, "unit");
        if (j >= 0) {
            this.f309c = timeUnit.toNanos(j);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j).toString());
    }

    public long m509h() {
        return this.f309c;
    }

    public static final class a extends C0125Cn {
        @Override
        public C0125Cn mo439g(long j, TimeUnit timeUnit) {
            AbstractC0116Ce.m476e(timeUnit, "unit");
            return this;
        }

        @Override
        public void mo438f() {
        }

        @Override
        public C0125Cn mo436d(long j) {
            return this;
        }
    }
}
