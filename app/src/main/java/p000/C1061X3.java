package p000;

import android.os.Handler;
import android.os.HandlerThread;

public class C1061X3 {

    public static C1061X3 f3163e;

    public Handler f3164a;

    public HandlerThread f3165b;

    public int f3166c = 0;

    public final Object f3167d = new Object();

    public static C1061X3 m4619d() {
        if (f3163e == null) {
            f3163e = new C1061X3();
        }
        return f3163e;
    }

    public final void m4620a() {
        synchronized (this.f3167d) {
            try {
                if (this.f3164a == null) {
                    if (this.f3166c <= 0) {
                        throw new IllegalStateException("CameraThread is not open");
                    }
                    HandlerThread handlerThread = new HandlerThread("CameraThread");
                    this.f3165b = handlerThread;
                    handlerThread.start();
                    this.f3164a = new Handler(this.f3165b.getLooper());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m4621b() {
        synchronized (this.f3167d) {
            try {
                int i = this.f3166c - 1;
                this.f3166c = i;
                if (i == 0) {
                    m4624f();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m4622c(Runnable runnable) {
        synchronized (this.f3167d) {
            m4620a();
            this.f3164a.post(runnable);
        }
    }

    public void m4623e(Runnable runnable) {
        synchronized (this.f3167d) {
            this.f3166c++;
            m4622c(runnable);
        }
    }

    public final void m4624f() {
        synchronized (this.f3167d) {
            this.f3165b.quit();
            this.f3165b = null;
            this.f3164a = null;
        }
    }
}
