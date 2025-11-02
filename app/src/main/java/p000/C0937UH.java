package p000;

import android.content.ComponentName;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* loaded from: classes.dex */
public final class C0937UH implements Handler.Callback {

    public final C2654zI f2847a;

    public C0937UH(C2654zI c2654zI, AbstractC2146oH abstractC2146oH) {
        this.f2847a = c2654zI;
    }

    @Override
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            synchronized (this.f2847a.f8241f) {
                try {
                    C0660OF c0660of = (C0660OF) message.obj;
                    ServiceConnectionC0431JG serviceConnectionC0431JG = (ServiceConnectionC0431JG) this.f2847a.f8241f.get(c0660of);
                    if (serviceConnectionC0431JG != null && serviceConnectionC0431JG.m1894i()) {
                        if (serviceConnectionC0431JG.m1895j()) {
                            serviceConnectionC0431JG.m1892g("GmsClientSupervisor");
                        }
                        this.f2847a.f8241f.remove(c0660of);
                    }
                } finally {
                }
            }
            return true;
        }
        if (i != 1) {
            return false;
        }
        synchronized (this.f2847a.f8241f) {
            try {
                C0660OF c0660of2 = (C0660OF) message.obj;
                ServiceConnectionC0431JG serviceConnectionC0431JG2 = (ServiceConnectionC0431JG) this.f2847a.f8241f.get(c0660of2);
                if (serviceConnectionC0431JG2 != null && serviceConnectionC0431JG2.m1886a() == 3) {
                    Log.e("GmsClientSupervisor", "Timeout waiting for ServiceConnection callback " + String.valueOf(c0660of2), new Exception());
                    ComponentName componentNameM1887b = serviceConnectionC0431JG2.m1887b();
                    if (componentNameM1887b == null) {
                        componentNameM1887b = c0660of2.m3389a();
                    }
                    if (componentNameM1887b == null) {
                        String strM3391c = c0660of2.m3391c();
                        AbstractC1085Xi.m4801j(strM3391c);
                        componentNameM1887b = new ComponentName(strM3391c, "unknown");
                    }
                    serviceConnectionC0431JG2.onServiceDisconnected(componentNameM1887b);
                }
            } finally {
            }
        }
        return true;
    }
}
