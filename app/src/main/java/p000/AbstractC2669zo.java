package p000;

import android.os.Looper;

public abstract class AbstractC2669zo {
    public static void m11047a() {
        if (Looper.getMainLooper() != Looper.myLooper()) {
            throw new IllegalStateException("Must be called from the main thread.");
        }
    }
}
