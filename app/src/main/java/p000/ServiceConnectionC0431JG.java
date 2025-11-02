package p000;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

public final class ServiceConnectionC0431JG implements ServiceConnection, InterfaceC0341HI {

    public final Map f1313a = new HashMap<>();

    public int f1314b = 2;

    public boolean f1315c;

    public IBinder f1316d;

    public final C0660OF f1317e;

    public ComponentName f1318f;

    public final C2654zI f1319g;

    public ServiceConnectionC0431JG(C2654zI c2654zI, C0660OF c0660of) {
        this.f1319g = c2654zI;
        this.f1317e = c0660of;
    }

    public final int m1886a() {
        return this.f1314b;
    }

    public final ComponentName m1887b() {
        return this.f1318f;
    }

    public final IBinder m1888c() {
        return this.f1316d;
    }

    public final void m1889d(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f1313a.put(serviceConnection, serviceConnection2);
    }

    public final void m1890e(String str, Executor executor) {
        this.f1314b = 3;
        StrictMode.VmPolicy vmPolicy = StrictMode.getVmPolicy();
        if (AbstractC0993Vi.m4421j()) {
            StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder(vmPolicy).permitUnsafeIntentLaunch().build());
        }
        try {
            C2654zI c2654zI = this.f1319g;
            boolean zM8356d = c2654zI.f8245j.m8356d(c2654zI.f8242g, str, this.f1317e.m3390b(c2654zI.f8242g), this, 4225, executor);
            this.f1315c = zM8356d;
            if (zM8356d) {
                this.f1319g.f8243h.sendMessageDelayed(this.f1319g.f8243h.obtainMessage(1, this.f1317e), this.f1319g.f8247l);
            } else {
                this.f1314b = 2;
                try {
                    C2654zI c2654zI2 = this.f1319g;
                    c2654zI2.f8245j.m8355c(c2654zI2.f8242g, this);
                } catch (IllegalArgumentException unused) {
                }
            }
            StrictMode.setVmPolicy(vmPolicy);
        } catch (Throwable th) {
            StrictMode.setVmPolicy(vmPolicy);
            throw th;
        }
    }

    public final void m1891f(ServiceConnection serviceConnection, String str) {
        this.f1313a.remove(serviceConnection);
    }

    public final void m1892g(String str) {
        this.f1319g.f8243h.removeMessages(1, this.f1317e);
        C2654zI c2654zI = this.f1319g;
        c2654zI.f8245j.m8355c(c2654zI.f8242g, this);
        this.f1315c = false;
        this.f1314b = 2;
    }

    public final boolean m1893h(ServiceConnection serviceConnection) {
        return this.f1313a.containsKey(serviceConnection);
    }

    public final boolean m1894i() {
        return this.f1313a.isEmpty();
    }

    public final boolean m1895j() {
        return this.f1315c;
    }

    @Override
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f1319g.f8241f) {
            try {
                this.f1319g.f8243h.removeMessages(1, this.f1317e);
                this.f1316d = iBinder;
                this.f1318f = componentName;
                Iterator it = this.f1313a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f1314b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1319g.f8241f) {
            try {
                this.f1319g.f8243h.removeMessages(1, this.f1317e);
                this.f1316d = null;
                this.f1318f = componentName;
                Iterator it = this.f1313a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f1314b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
