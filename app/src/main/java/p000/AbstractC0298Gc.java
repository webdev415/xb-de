package p000;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.HandlerThread;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public abstract class AbstractC0298Gc {

    public static final Object f939a = new Object();

    public static C2654zI f940b = null;

    public static HandlerThread f941c = null;

    public static Executor f942d = null;

    public static boolean f943e = false;

    public static AbstractC0298Gc m1377a(Context context) {
        synchronized (f939a) {
            try {
                if (f940b == null) {
                    f940b = new C2654zI(context.getApplicationContext(), f943e ? m1378b().getLooper() : context.getMainLooper(), f942d);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return f940b;
    }

    public static HandlerThread m1378b() {
        synchronized (f939a) {
            try {
                HandlerThread handlerThread = f941c;
                if (handlerThread != null) {
                    return handlerThread;
                }
                HandlerThread handlerThread2 = new HandlerThread("GoogleApiHandler", 9);
                f941c = handlerThread2;
                handlerThread2.start();
                return f941c;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public abstract void mo1379c(C0660OF c0660of, ServiceConnection serviceConnection, String str);

    public final void m1380d(String str, String str2, int i, ServiceConnection serviceConnection, String str3, boolean z) {
        mo1379c(new C0660OF(str, str2, 4225, z), serviceConnection, str3);
    }

    public abstract boolean mo1381e(C0660OF c0660of, ServiceConnection serviceConnection, String str, Executor executor);
}
