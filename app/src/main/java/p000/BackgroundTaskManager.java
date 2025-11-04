package p000;

import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class AbstractC1807h2 {

    public static HandlerThread handlerThread;

    public static ExecutorService executorService;

    static {
        handlerThread = new HandlerThread("BackgroundHandler", 1);
        handlerThread.start();
        executorService = Executors.newCachedThreadPool();
    }

    public static void m7778a(Runnable runnable) {
        executorService.execute(runnable);
    }
}
