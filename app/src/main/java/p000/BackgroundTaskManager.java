package p000;

import android.os.HandlerThread;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Utility class to manage background threading tasks.
 */
public abstract class BackgroundTaskManager {

    // Static thread pool and handler thread for background tasks
    private static HandlerThread handlerThread;
    private static ExecutorService executorService;

    static {
        // Initialize HandlerThread for background processing
        handlerThread = new HandlerThread("BackgroundHandler", 1);
        handlerThread.start();

        // Initialize ExecutorService for cached thread pool
        executorService = Executors.newCachedThreadPool();
    }

    /**
     * Submit a runnable task to be executed in the background thread pool.
     *
     * @param runnable The task to be executed
     */
    public static void submitBackgroundTask(Runnable runnable) {
        if (runnable != null) {
            executorService.execute(runnable);
        } else {
            System.err.println("Runnable task is null and cannot be executed.");
        }
    }

    /**
     * Cleanup resources used by the background task manager.
     * Shut down the executor service and stop the handler thread.
     */
    public static void cleanup() {
        if (executorService != null && !executorService.isShutdown()) {
            executorService.shutdown();
        }
        if (handlerThread != null && handlerThread.isAlive()) {
            handlerThread.quitSafely();
        }
    }
}

