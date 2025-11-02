package p000;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* loaded from: classes.dex */
public final class ServiceConnectionC0044Ay implements ServiceConnection {

    public final String f99a;

    public final C0136Cy f100b;

    public ServiceConnectionC0044Ay(C0136Cy c0136Cy, String str) {
        this.f100b = c0136Cy;
        this.f99a = str;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f100b.f326a.mo349g().m9623L().m10616a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            InterfaceC2627ys interfaceC2627ysM10614P = AbstractBinderC2535ws.m10614P(iBinder);
            if (interfaceC2627ysM10614P == null) {
                this.f100b.f326a.mo349g().m9623L().m10616a("Install Referrer Service implementation was not found");
            } else {
                this.f100b.f326a.mo349g().m9622K().m10616a("Install Referrer Service connected");
                this.f100b.f326a.mo354l().m7374C(new RunnableC0320Gy(this, interfaceC2627ysM10614P, this));
            }
        } catch (RuntimeException e) {
            this.f100b.f326a.mo349g().m9623L().m10617b("Exception occurred while calling Install Referrer API", e);
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f100b.f326a.mo349g().m9622K().m10616a("Install Referrer Service disconnected");
    }
}
