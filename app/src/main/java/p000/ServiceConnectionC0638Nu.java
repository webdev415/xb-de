package p000;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;

public final class ServiceConnectionC0638Nu implements ServiceConnection {

    public final int f1979a;

    public final AbstractC2454v2 f1980b;

    public ServiceConnectionC0638Nu(AbstractC2454v2 abstractC2454v2, int i) {
        this.f1980b = abstractC2454v2;
        this.f1979a = i;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC2454v2 abstractC2454v2 = this.f1980b;
        if (iBinder == null) {
            AbstractC2454v2.m10273Q(abstractC2454v2, 16);
            return;
        }
        synchronized (abstractC2454v2.f7639n) {
            try {
                AbstractC2454v2 abstractC2454v22 = this.f1980b;
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGmsServiceBroker");
                abstractC2454v22.f7640o = (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0483Kd)) ? new C2026lq(iBinder) : (InterfaceC0483Kd) iInterfaceQueryLocalInterface;
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f1980b.m10284R(0, null, this.f1979a);
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f1980b.f7639n) {
            this.f1980b.f7640o = null;
        }
        AbstractC2454v2 abstractC2454v2 = this.f1980b;
        int i = this.f1979a;
        Handler handler = abstractC2454v2.f7637l;
        handler.sendMessage(handler.obtainMessage(6, i, 1));
    }
}
