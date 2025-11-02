package p000;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class C2636z0 {

    public ServiceConnectionC0739Q2 f8165a;

    public InterfaceC0409Iv f8166b;

    public boolean f8167c;

    public final Object f8168d = new Object();

    public C2626yr f8169e;

    public final Context f8170f;

    public final long f8171g;

    public static final class a {

        public final String f8172a;

        public final boolean f8173b;

        public a(String str, boolean z) {
            this.f8172a = str;
            this.f8173b = z;
        }

        public String m10979a() {
            return this.f8172a;
        }

        public boolean m10980b() {
            return this.f8173b;
        }

        public String toString() {
            String str = this.f8172a;
            boolean z = this.f8173b;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 7);
            sb.append("{");
            sb.append(str);
            sb.append("}");
            sb.append(z);
            return sb.toString();
        }
    }

    public C2636z0(Context context, long j, boolean z, boolean z2) {
        Context applicationContext;
        AbstractC1085Xi.m4801j(context);
        if (z && (applicationContext = context.getApplicationContext()) != null) {
            context = applicationContext;
        }
        this.f8170f = context;
        this.f8167c = false;
        this.f8171g = j;
    }

    public static a m10972a(Context context) {
        C2636z0 c2636z0 = new C2636z0(context, -1L, true, false);
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            c2636z0.m10975d(false);
            a aVarM10977f = c2636z0.m10977f(-1);
            c2636z0.m10976e(aVarM10977f, true, 0.0f, SystemClock.elapsedRealtime() - jElapsedRealtime, "", null);
            return aVarM10977f;
        } finally {
        }
    }

    public final void m10974c() {
        AbstractC1085Xi.m4800i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f8170f == null || this.f8165a == null) {
                    return;
                }
                try {
                    if (this.f8167c) {
                        C1997l6.m8350b().m8355c(this.f8170f, this.f8165a);
                    }
                } catch (Throwable th) {
                    Log.i("AdvertisingIdClient", "AdvertisingIdClient unbindService failed.", th);
                }
                this.f8167c = false;
                this.f8166b = null;
                this.f8165a = null;
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m10975d(boolean z) {
        AbstractC1085Xi.m4800i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (this.f8167c) {
                    m10974c();
                }
                Context context = this.f8170f;
                try {
                    context.getPackageManager().getPackageInfo("com.android.vending", 0);
                    int iM1694c = C0390Ic.m1692b().m1694c(context, 12451000);
                    if (iM1694c != 0 && iM1694c != 2) {
                        throw new IOException("Google Play services not available");
                    }
                    ServiceConnectionC0739Q2 serviceConnectionC0739Q2 = new ServiceConnectionC0739Q2();
                    Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
                    intent.setPackage("com.google.android.gms");
                    try {
                        if (!C1997l6.m8350b().m8354a(context, intent, serviceConnectionC0739Q2, 1)) {
                            throw new IOException("Connection failure");
                        }
                        this.f8165a = serviceConnectionC0739Q2;
                        try {
                            this.f8166b = AbstractBinderC0684Ou.m3444O(serviceConnectionC0739Q2.m3625a(10000L, TimeUnit.MILLISECONDS));
                            this.f8167c = true;
                            if (z) {
                                m10978g();
                            }
                        } catch (InterruptedException unused) {
                            throw new IOException("Interrupted exception");
                        } catch (Throwable th) {
                            throw new IOException(th);
                        }
                    } finally {
                        IOException iOException = new IOException(th);
                    }
                } catch (PackageManager.NameNotFoundException unused2) {
                    throw new C0436Jc(9);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final boolean m10976e(a aVar, boolean z, float f, long j, String str, Throwable th) {
        if (Math.random() > 0.0d) {
            return false;
        }
        HashMap map = new HashMap<>();
        map.put("app_context", "1");
        if (aVar != null) {
            map.put("limit_ad_tracking", true != aVar.m10980b() ? "0" : "1");
            String strM10979a = aVar.m10979a();
            if (strM10979a != null) {
                map.put("ad_id_size", Integer.toString(strM10979a.length()));
            }
        }
        if (th != null) {
            map.put("error", th.getClass().getName());
        }
        map.put("tag", "AdvertisingIdClient");
        map.put("time_spent", Long.toString(j));
        new C1138Yp(this, map).start();
        return true;
    }

    public final a m10977f(int i) {
        a aVar;
        AbstractC1085Xi.m4800i("Calling this from your main thread can lead to deadlock");
        synchronized (this) {
            try {
                if (!this.f8167c) {
                    synchronized (this.f8168d) {
                        C2626yr c2626yr = this.f8169e;
                        if (c2626yr == null || !c2626yr.f8151o) {
                            throw new IOException("AdvertisingIdClient is not connected.");
                        }
                    }
                    try {
                        m10975d(false);
                        if (!this.f8167c) {
                            throw new IOException("AdvertisingIdClient cannot reconnect.");
                        }
                    } catch (Exception e) {
                        throw new IOException("AdvertisingIdClient cannot reconnect.", e);
                    }
                }
                AbstractC1085Xi.m4801j(this.f8165a);
                AbstractC1085Xi.m4801j(this.f8166b);
                try {
                    aVar = new a(this.f8166b.mo1725c(), this.f8166b.mo1724D(true));
                } catch (RemoteException e2) {
                    Log.i("AdvertisingIdClient", "GMS remote exception ", e2);
                    throw new IOException("Remote exception");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        m10978g();
        return aVar;
    }

    public final void finalize() throws Throwable {
        m10974c();
        super.finalize();
    }

    public final void m10978g() {
        synchronized (this.f8168d) {
            C2626yr c2626yr = this.f8169e;
            if (c2626yr != null) {
                c2626yr.f8150n.countDown();
                try {
                    this.f8169e.join();
                } catch (InterruptedException unused) {
                }
            }
            long j = this.f8171g;
            if (j > 0) {
                this.f8169e = new C2626yr(this, j);
            }
        }
    }

    public static void m10973b(boolean z) {
    }
}
