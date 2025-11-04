package p000;

import android.os.Process;
import android.os.StrictMode;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public class ThreadFactoryC1304b7 implements ThreadFactory {

    public static final ThreadFactory f3848e = Executors.defaultThreadFactory();

    public final AtomicLong f3849a = new AtomicLong();

    public final String f3850b;

    public final int f3851c;

    public final StrictMode.ThreadPolicy f3852d;

    public ThreadFactoryC1304b7(String str, int i, StrictMode.ThreadPolicy threadPolicy) {
        this.f3850b = str;
        this.f3851c = i;
        this.f3852d = threadPolicy;
    }

    public final void m5646b(Runnable runnable) throws SecurityException, IllegalArgumentException {
        Process.setThreadPriority(this.f3851c);
        StrictMode.ThreadPolicy threadPolicy = this.f3852d;
        if (threadPolicy != null) {
            StrictMode.setThreadPolicy(threadPolicy);
        }
        runnable.run();
    }

    @Override
    public Thread newThread(final Runnable runnable) {
        Thread threadNewThread = f3848e.newThread(new Runnable() {
            @Override
            public final void run() throws SecurityException, IllegalArgumentException {
                this.f3491l.m5646b(runnable);
            }
        });
        threadNewThread.setName(String.format(Locale.ROOT, "%s Thread #%d", this.f3850b, Long.valueOf(this.f3849a.getAndIncrement())));
        return threadNewThread;
    }
}
