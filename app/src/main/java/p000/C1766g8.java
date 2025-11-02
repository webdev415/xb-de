package p000;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public class C1766g8 extends AbstractC2023ln {

    public final Object f5592a = new Object();

    public final ExecutorService f5593b = Executors.newFixedThreadPool(4, new a());

    public volatile Handler f5594c;

    public class a implements ThreadFactory {

        public final AtomicInteger f5595a = new AtomicInteger(0);

        public a() {
        }

        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("arch_disk_io_" + this.f5595a.getAndIncrement());
            return thread;
        }
    }

    public static class b {
        public static Handler m7700a(Looper looper) {
            return Handler.createAsync(looper);
        }
    }

    public static Handler m7696d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.m7700a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused) {
            return new Handler(looper);
        } catch (InvocationTargetException unused2) {
            return new Handler(looper);
        }
    }

    @Override
    public void mo7697a(Runnable runnable) {
        this.f5593b.execute(runnable);
    }

    @Override
    public boolean mo7698b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    @Override
    public void mo7699c(Runnable runnable) {
        if (this.f5594c == null) {
            synchronized (this.f5592a) {
                try {
                    if (this.f5594c == null) {
                        this.f5594c = m7696d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.f5594c.post(runnable);
    }
}
