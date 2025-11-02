package p000;

import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractC1807h2 {

    public static HandlerThread f5674a;

    public static ExecutorService f5675b;

    static {
        HandlerThread handlerThread = new HandlerThread("BackgroundHandler", 1);
        f5674a = handlerThread;
        handlerThread.start();
        f5675b = Executors.newCachedThreadPool();
    }

    public static void m7778a(Runnable runnable) {
        f5675b.execute(runnable);
    }
}
