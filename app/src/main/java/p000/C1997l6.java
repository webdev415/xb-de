package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.util.Log;
import java.util.NoSuchElementException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class C1997l6 {

    public static final Object f6050b = new Object();

    public static volatile C1997l6 f6051c;

    public final ConcurrentHashMap f6052a = new ConcurrentHashMap();

    public static C1997l6 m8350b() {
        if (f6051c == null) {
            synchronized (f6050b) {
                try {
                    if (f6051c == null) {
                        f6051c = new C1997l6();
                    }
                } finally {
                }
            }
        }
        C1997l6 c1997l6 = f6051c;
        AbstractC1085Xi.m4801j(c1997l6);
        return c1997l6;
    }

    public static void m8351e(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException | NoSuchElementException unused) {
        }
    }

    public static boolean m8352g(ServiceConnection serviceConnection) {
        return !(serviceConnection instanceof InterfaceC0341HI);
    }

    public static final boolean m8353h(Context context, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        if (executor == null) {
            executor = null;
        }
        return (!AbstractC0993Vi.m4419h() || executor == null) ? context.bindService(intent, serviceConnection, i) : context.bindService(intent, i, executor, serviceConnection);
    }

    public boolean m8354a(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return m8357f(context, context.getClass().getName(), intent, serviceConnection, i, true, null);
    }

    public void m8355c(Context context, ServiceConnection serviceConnection) {
        if (!m8352g(serviceConnection) || !this.f6052a.containsKey(serviceConnection)) {
            m8351e(context, serviceConnection);
            return;
        }
        try {
            m8351e(context, (ServiceConnection) this.f6052a.get(serviceConnection));
        } finally {
            this.f6052a.remove(serviceConnection);
        }
    }

    public final boolean m8356d(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, Executor executor) {
        return m8357f(context, str, intent, serviceConnection, 4225, true, executor);
    }

    public final boolean m8357f(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z, Executor executor) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            String packageName = component.getPackageName();
            "com.google.android.gms".equals(packageName);
            try {
                if ((C2670zp.m11048a(context).m10889b(packageName, 0).flags & 2097152) != 0) {
                    Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
                    return false;
                }
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (!m8352g(serviceConnection)) {
            return m8353h(context, intent, serviceConnection, i, executor);
        }
        ServiceConnection serviceConnection2 = (ServiceConnection) this.f6052a.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnection2 != null && serviceConnection != serviceConnection2) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zM8353h = m8353h(context, intent, serviceConnection, i, executor);
            if (zM8353h) {
                return zM8353h;
            }
            return false;
        } finally {
            this.f6052a.remove(serviceConnection, serviceConnection);
        }
    }
}
