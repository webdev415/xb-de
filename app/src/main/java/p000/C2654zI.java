package p000;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import java.util.HashMap;
import java.util.concurrent.Executor;

public final class C2654zI extends AbstractC0298Gc {

    public final HashMap f8241f = new HashMap<>();

    public final Context f8242g;

    public volatile Handler f8243h;

    public final C0937UH f8244i;

    public final C1997l6 f8245j;

    public final long f8246k;

    public final long f8247l;

    public volatile Executor f8248m;

    public C2654zI(Context context, Looper looper, Executor executor) {
        C0937UH c0937uh = new C0937UH(this, null);
        this.f8244i = c0937uh;
        this.f8242g = context.getApplicationContext();
        this.f8243h = new HandlerC2680zz(looper, c0937uh);
        this.f8245j = C1997l6.m8350b();
        this.f8246k = 5000L;
        this.f8247l = 300000L;
        this.f8248m = executor;
    }

    @Override
    public final void mo1379c(C0660OF c0660of, ServiceConnection serviceConnection, String str) {
        AbstractC1085Xi.m4802k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f8241f) {
            try {
                ServiceConnectionC0431JG serviceConnectionC0431JG = (ServiceConnectionC0431JG) this.f8241f.get(c0660of);
                if (serviceConnectionC0431JG == null) {
                    throw new IllegalStateException("Nonexistent connection status for service config: " + c0660of.toString());
                }
                if (!serviceConnectionC0431JG.m1893h(serviceConnection)) {
                    throw new IllegalStateException("Trying to unbind a GmsServiceConnection  that was not bound before.  config=" + c0660of.toString());
                }
                serviceConnectionC0431JG.m1891f(serviceConnection, str);
                if (serviceConnectionC0431JG.m1894i()) {
                    this.f8243h.sendMessageDelayed(this.f8243h.obtainMessage(0, c0660of), this.f8246k);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final boolean mo1381e(C0660OF c0660of, ServiceConnection serviceConnection, String str, Executor executor) {
        boolean zM1895j;
        AbstractC1085Xi.m4802k(serviceConnection, "ServiceConnection must not be null");
        synchronized (this.f8241f) {
            try {
                ServiceConnectionC0431JG serviceConnectionC0431JG = (ServiceConnectionC0431JG) this.f8241f.get(c0660of);
                if (executor == null) {
                    executor = this.f8248m;
                }
                if (serviceConnectionC0431JG == null) {
                    serviceConnectionC0431JG = new ServiceConnectionC0431JG(this, c0660of);
                    serviceConnectionC0431JG.m1889d(serviceConnection, serviceConnection, str);
                    serviceConnectionC0431JG.m1890e(str, executor);
                    this.f8241f.put(c0660of, serviceConnectionC0431JG);
                } else {
                    this.f8243h.removeMessages(0, c0660of);
                    if (serviceConnectionC0431JG.m1893h(serviceConnection)) {
                        throw new IllegalStateException("Trying to bind a GmsServiceConnection that was already connected before.  config=" + c0660of.toString());
                    }
                    serviceConnectionC0431JG.m1889d(serviceConnection, serviceConnection, str);
                    int iM1886a = serviceConnectionC0431JG.m1886a();
                    if (iM1886a == 1) {
                        serviceConnection.onServiceConnected(serviceConnectionC0431JG.m1887b(), serviceConnectionC0431JG.m1888c());
                    } else if (iM1886a == 2) {
                        serviceConnectionC0431JG.m1890e(str, executor);
                    }
                }
                zM1895j = serviceConnectionC0431JG.m1895j();
            } catch (Throwable th) {
                throw th;
            }
        }
        return zM1895j;
    }
}
