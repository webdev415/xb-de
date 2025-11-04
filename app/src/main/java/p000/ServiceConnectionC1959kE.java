package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import p000.AbstractC2454v2;

public final class ServiceConnectionC1959kE implements ServiceConnection, AbstractC2454v2.a, AbstractC2454v2.b {

    public volatile boolean f5993a;

    public volatile C2448ux f5994b;

    public final C2142oD f5995c;

    public ServiceConnectionC1959kE(C2142oD c2142oD) {
        this.f5995c = c2142oD;
    }

    @Override
    public final void mo8240a(int i) {
        AbstractC1085Xi.m4794c("MeasurementServiceConnection.onConnectionSuspended");
        this.f5995c.mo349g().m9617F().m10616a("Service connection suspended");
        this.f5995c.mo354l().m7374C(new RunnableC2282rE(this));
    }

    @Override
    public final void mo8241b(C1717f6 c1717f6) {
        AbstractC1085Xi.m4794c("MeasurementServiceConnection.onConnectionFailed");
        C2356sx c2356sxM9223E = this.f5995c.f8058a.m9223E();
        if (c2356sxM9223E != null) {
            c2356sxM9223E.m9623L().m10617b("Service connection failed", c1717f6);
        }
        synchronized (this) {
            this.f5993a = false;
            this.f5994b = null;
        }
        this.f5995c.mo354l().m7374C(new RunnableC2512wE(this));
    }

    @Override
    public final void mo8242c(Bundle bundle) {
        AbstractC1085Xi.m4794c("MeasurementServiceConnection.onConnected");
        synchronized (this) {
            try {
                AbstractC1085Xi.m4801j(this.f5994b);
                this.f5995c.mo354l().m7374C(new RunnableC2328sE(this, (InterfaceC1707ex) this.f5994b.m10300q()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f5994b = null;
                this.f5993a = false;
            }
        }
    }

    public final void m8243d() {
        this.f5995c.mo356n();
        Context contextMo344a = this.f5995c.mo344a();
        synchronized (this) {
            try {
                if (this.f5993a) {
                    this.f5995c.mo349g().m9622K().m10616a("Connection attempt already in progress");
                    return;
                }
                if (this.f5994b != null && (this.f5994b.m10304w() || this.f5994b.m10303v())) {
                    this.f5995c.mo349g().m9622K().m10616a("Already awaiting connection attempt");
                    return;
                }
                this.f5994b = new C2448ux(contextMo344a, Looper.getMainLooper(), this, this);
                this.f5995c.mo349g().m9622K().m10616a("Connecting to remote service");
                this.f5993a = true;
                AbstractC1085Xi.m4801j(this.f5994b);
                this.f5994b.m10286a();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8244e(Intent intent) {
        this.f5995c.mo356n();
        Context contextMo344a = this.f5995c.mo344a();
        C1997l6 c1997l6M8350b = C1997l6.m8350b();
        synchronized (this) {
            try {
                if (this.f5993a) {
                    this.f5995c.mo349g().m9622K().m10616a("Connection attempt already in progress");
                    return;
                }
                this.f5995c.mo349g().m9622K().m10616a("Using local app measurement service");
                this.f5993a = true;
                c1997l6M8350b.m8354a(contextMo344a, intent, this.f5995c.f6549c, 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void m8245g() {
        if (this.f5994b != null && (this.f5994b.m10303v() || this.f5994b.m10304w())) {
            this.f5994b.m10289e();
        }
        this.f5994b = null;
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        AbstractC1085Xi.m4794c("MeasurementServiceConnection.onServiceConnected");
        synchronized (this) {
            if (iBinder == null) {
                this.f5993a = false;
                this.f5995c.mo349g().m9618G().m10616a("Service connected with null binder");
                return;
            }
            InterfaceC1707ex c1894ix = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    c1894ix = iInterfaceQueryLocalInterface instanceof InterfaceC1707ex ? (InterfaceC1707ex) iInterfaceQueryLocalInterface : new C1894ix(iBinder);
                    this.f5995c.mo349g().m9622K().m10616a("Bound to IMeasurementService interface");
                } else {
                    this.f5995c.mo349g().m9618G().m10617b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f5995c.mo349g().m9618G().m10616a("Service connect failed to get IMeasurementService");
            }
            if (c1894ix == null) {
                this.f5993a = false;
                try {
                    C1997l6.m8350b().m8355c(this.f5995c.mo344a(), this.f5995c.f6549c);
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f5995c.mo354l().m7374C(new RunnableC2190pE(this, c1894ix));
            }
        }
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
        AbstractC1085Xi.m4794c("MeasurementServiceConnection.onServiceDisconnected");
        this.f5995c.mo349g().m9617F().m10616a("Service disconnected");
        this.f5995c.mo354l().m7374C(new RunnableC2143oE(this, componentName));
    }
}
