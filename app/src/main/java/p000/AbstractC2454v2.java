package p000;

import android.accounts.Account;
import android.app.PendingIntent;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes.dex */
public abstract class AbstractC2454v2 {

    public boolean f7623A;

    public volatile C0242FB f7624B;

    public AtomicInteger f7625C;

    public int f7626a;

    public long f7627b;

    public long f7628c;

    public int f7629d;

    public long f7630e;

    public volatile String f7631f;

    public C0755QI f7632g;

    public final Context f7633h;

    public final Looper f7634i;

    public final AbstractC0298Gc f7635j;

    public final C0390Ic f7636k;

    public final Handler f7637l;

    public final Object f7638m;

    public final Object f7639n;

    public InterfaceC0483Kd f7640o;

    public c f7641p;

    public IInterface f7642q;

    public final ArrayList f7643r;

    public ServiceConnectionC0638Nu f7644s;

    public int f7645t;

    public final a f7646u;

    public final b f7647v;

    public final int f7648w;

    public final String f7649x;

    public volatile String f7650y;

    public C1717f6 f7651z;

    public static final C0618Na[] f7622E = new C0618Na[0];

    public static final String[] f7621D = {"service_esmobile", "service_googleme"};

    public interface a {
        void mo8240a(int i);

        void mo8242c(Bundle bundle);
    }

    public interface b {
        void mo8241b(C1717f6 c1717f6);
    }

    public interface c {
        void mo10308a(C1717f6 c1717f6);
    }

    public class d implements c {
        public d() {
        }

        @Override
        public final void mo10308a(C1717f6 c1717f6) {
            if (c1717f6.m7551h()) {
                AbstractC2454v2 abstractC2454v2 = AbstractC2454v2.this;
                abstractC2454v2.m10298o(null, abstractC2454v2.m10299p());
            } else if (AbstractC2454v2.this.f7647v != null) {
                AbstractC2454v2.this.f7647v.mo8241b(c1717f6);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public AbstractC2454v2(Context context, Looper looper, int i, a aVar, b bVar, String str) {
        AbstractC0298Gc abstractC0298GcM1377a = AbstractC0298Gc.m1377a(context);
        C0390Ic c0390IcM1692b = C0390Ic.m1692b();
        AbstractC1085Xi.m4801j(aVar);
        AbstractC1085Xi.m4801j(bVar);
        this(context, looper, abstractC0298GcM1377a, c0390IcM1692b, i, aVar, bVar, str);
    }

    public static /* bridge */ void m10272P(AbstractC2454v2 abstractC2454v2, C0242FB c0242fb) {
        abstractC2454v2.f7624B = c0242fb;
        if (abstractC2454v2.m10282F()) {
            C1904j6 c1904j6 = c0242fb.f654o;
            C1041Wk.m4536a().m4537b(c1904j6 == null ? null : c1904j6.m8104k());
        }
    }

    public static /* bridge */ void m10273Q(AbstractC2454v2 abstractC2454v2, int i) {
        int i2;
        int i3;
        synchronized (abstractC2454v2.f7638m) {
            i2 = abstractC2454v2.f7645t;
        }
        if (i2 == 3) {
            abstractC2454v2.f7623A = true;
            i3 = 5;
        } else {
            i3 = 4;
        }
        Handler handler = abstractC2454v2.f7637l;
        handler.sendMessage(handler.obtainMessage(i3, abstractC2454v2.f7625C.get(), 16));
    }

    public static /* bridge */ boolean m10275T(AbstractC2454v2 abstractC2454v2, int i, int i2, IInterface iInterface) {
        synchronized (abstractC2454v2.f7638m) {
            try {
                if (abstractC2454v2.f7645t != i) {
                    return false;
                }
                abstractC2454v2.m10285V(i2, iInterface);
                return true;
            } finally {
            }
        }
    }

    public static /* bridge */ boolean m10276U(AbstractC2454v2 abstractC2454v2) throws ClassNotFoundException {
        if (abstractC2454v2.f7623A || TextUtils.isEmpty(abstractC2454v2.mo10242r()) || TextUtils.isEmpty(abstractC2454v2.m10297m())) {
            return false;
        }
        try {
            Class.forName(abstractC2454v2.mo10242r());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public void m10277A(int i, IBinder iBinder, Bundle bundle, int i2) {
        this.f7637l.sendMessage(this.f7637l.obtainMessage(1, i2, -1, new C0363Hv(this, i, iBinder, bundle)));
    }

    public boolean m10278B() {
        return false;
    }

    public boolean m10279C() {
        return false;
    }

    public void m10280D(int i) {
        this.f7637l.sendMessage(this.f7637l.obtainMessage(6, this.f7625C.get(), i));
    }

    public void m10281E(c cVar, int i, PendingIntent pendingIntent) {
        AbstractC1085Xi.m4802k(cVar, "Connection progress callbacks cannot be null.");
        this.f7641p = cVar;
        this.f7637l.sendMessage(this.f7637l.obtainMessage(3, this.f7625C.get(), i, pendingIntent));
    }

    public boolean m10282F() {
        return false;
    }

    public final String m10283K() {
        String str = this.f7649x;
        return str == null ? this.f7633h.getClass().getName() : str;
    }

    public final void m10284R(int i, Bundle bundle, int i2) {
        this.f7637l.sendMessage(this.f7637l.obtainMessage(7, i2, -1, new C1053Ww(this, i, null)));
    }

    public final void m10285V(int i, IInterface iInterface) {
        C0755QI c0755qi;
        AbstractC1085Xi.m4792a((i == 4) == (iInterface != null));
        synchronized (this.f7638m) {
            try {
                this.f7645t = i;
                this.f7642q = iInterface;
                if (i == 1) {
                    ServiceConnectionC0638Nu serviceConnectionC0638Nu = this.f7644s;
                    if (serviceConnectionC0638Nu != null) {
                        AbstractC0298Gc abstractC0298Gc = this.f7635j;
                        String strM3647b = this.f7632g.m3647b();
                        AbstractC1085Xi.m4801j(strM3647b);
                        abstractC0298Gc.m1380d(strM3647b, this.f7632g.m3646a(), 4225, serviceConnectionC0638Nu, m10283K(), this.f7632g.m3648c());
                        this.f7644s = null;
                    }
                } else if (i == 2 || i == 3) {
                    ServiceConnectionC0638Nu serviceConnectionC0638Nu2 = this.f7644s;
                    if (serviceConnectionC0638Nu2 != null && (c0755qi = this.f7632g) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + c0755qi.m3647b() + " on " + c0755qi.m3646a());
                        AbstractC0298Gc abstractC0298Gc2 = this.f7635j;
                        String strM3647b2 = this.f7632g.m3647b();
                        AbstractC1085Xi.m4801j(strM3647b2);
                        abstractC0298Gc2.m1380d(strM3647b2, this.f7632g.m3646a(), 4225, serviceConnectionC0638Nu2, m10283K(), this.f7632g.m3648c());
                        this.f7625C.incrementAndGet();
                    }
                    ServiceConnectionC0638Nu serviceConnectionC0638Nu3 = new ServiceConnectionC0638Nu(this, this.f7625C.get());
                    this.f7644s = serviceConnectionC0638Nu3;
                    C0755QI c0755qi2 = (this.f7645t != 3 || m10297m() == null) ? new C0755QI(m10301t(), mo10243s(), false, 4225, m10302u()) : new C0755QI(m10295k().getPackageName(), m10297m(), true, 4225, false);
                    this.f7632g = c0755qi2;
                    if (c0755qi2.m3648c() && mo10241n() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f7632g.m3647b())));
                    }
                    AbstractC0298Gc abstractC0298Gc3 = this.f7635j;
                    String strM3647b3 = this.f7632g.m3647b();
                    AbstractC1085Xi.m4801j(strM3647b3);
                    if (!abstractC0298Gc3.mo1381e(new C0660OF(strM3647b3, this.f7632g.m3646a(), 4225, this.f7632g.m3648c()), serviceConnectionC0638Nu3, m10283K(), m10293i())) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f7632g.m3647b() + " on " + this.f7632g.m3646a());
                        m10284R(16, null, this.f7625C.get());
                    }
                } else if (i == 4) {
                    AbstractC1085Xi.m4801j(iInterface);
                    m10305x(iInterface);
                }
            } finally {
            }
        }
    }

    public void m10286a() throws PackageManager.NameNotFoundException {
        int iM1694c = this.f7636k.m1694c(this.f7633h, mo10241n());
        if (iM1694c == 0) {
            m10288c(new d());
        } else {
            m10285V(1, null);
            m10281E(new d(), iM1694c, null);
        }
    }

    public final void m10287b() {
        if (!m10303v()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    public void m10288c(c cVar) {
        AbstractC1085Xi.m4802k(cVar, "Connection progress callbacks cannot be null.");
        this.f7641p = cVar;
        m10285V(2, null);
    }

    public abstract IInterface mo10240d(IBinder iBinder);

    public void m10289e() {
        this.f7625C.incrementAndGet();
        synchronized (this.f7643r) {
            try {
                int size = this.f7643r.size();
                for (int i = 0; i < size; i++) {
                    ((AbstractC0038As) this.f7643r.get(i)).m164d();
                }
                this.f7643r.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f7639n) {
            this.f7640o = null;
        }
        m10285V(1, null);
    }

    public boolean m10290f() {
        return false;
    }

    public Account m10291g() {
        return null;
    }

    public C0618Na[] m10292h() {
        return f7622E;
    }

    public Executor m10293i() {
        return null;
    }

    public Bundle m10294j() {
        return null;
    }

    public final Context m10295k() {
        return this.f7633h;
    }

    public Bundle m10296l() {
        return new Bundle();
    }

    public String m10297m() {
        return null;
    }

    public abstract int mo10241n();

    public void m10298o(InterfaceC0253Fd interfaceC0253Fd, Set set) {
        Bundle bundleM10296l = m10296l();
        String str = this.f7650y;
        int i = C0390Ic.f1153a;
        Scope[] scopeArr = C0114Cc.f262z;
        Bundle bundle = new Bundle();
        int i2 = this.f7648w;
        C0618Na[] c0618NaArr = C0114Cc.f261A;
        C0114Cc c0114Cc = new C0114Cc(6, i2, i, null, null, scopeArr, bundle, null, c0618NaArr, c0618NaArr, true, 0, false, str);
        c0114Cc.f266o = this.f7633h.getPackageName();
        c0114Cc.f269r = bundleM10296l;
        if (set != null) {
            c0114Cc.f268q = (Scope[]) set.toArray(new Scope[0]);
        }
        if (m10279C()) {
            Account accountM10291g = m10291g();
            if (accountM10291g == null) {
                accountM10291g = new Account("<<default account>>", "com.google");
            }
            c0114Cc.f270s = accountM10291g;
            if (interfaceC0253Fd != null) {
                c0114Cc.f267p = interfaceC0253Fd.asBinder();
            }
        } else if (m10278B()) {
            c0114Cc.f270s = m10291g();
        }
        c0114Cc.f271t = f7622E;
        c0114Cc.f272u = m10292h();
        if (m10282F()) {
            c0114Cc.f275x = true;
        }
        try {
            synchronized (this.f7639n) {
                try {
                    InterfaceC0483Kd interfaceC0483Kd = this.f7640o;
                    if (interfaceC0483Kd != null) {
                        interfaceC0483Kd.mo2374M(new BinderC0453Jt(this, this.f7625C.get()), c0114Cc);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m10280D(3);
        } catch (RemoteException e2) {
            e = e2;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m10277A(8, null, null, this.f7625C.get());
        } catch (SecurityException e3) {
            throw e3;
        } catch (RuntimeException e4) {
            e = e4;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            m10277A(8, null, null, this.f7625C.get());
        }
    }

    public Set m10299p() {
        return Collections.emptySet();
    }

    public final IInterface m10300q() {
        IInterface iInterface;
        synchronized (this.f7638m) {
            try {
                if (this.f7645t == 5) {
                    throw new DeadObjectException();
                }
                m10287b();
                iInterface = this.f7642q;
                AbstractC1085Xi.m4802k(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String mo10242r();

    public abstract String mo10243s();

    public String m10301t() {
        return "com.google.android.gms";
    }

    public boolean m10302u() {
        return mo10241n() >= 211700000;
    }

    public boolean m10303v() {
        boolean z;
        synchronized (this.f7638m) {
            z = this.f7645t == 4;
        }
        return z;
    }

    public boolean m10304w() {
        boolean z;
        synchronized (this.f7638m) {
            int i = this.f7645t;
            z = true;
            if (i != 2 && i != 3) {
                z = false;
            }
        }
        return z;
    }

    public void m10305x(IInterface iInterface) {
        this.f7628c = System.currentTimeMillis();
    }

    public void m10306y(C1717f6 c1717f6) {
        this.f7629d = c1717f6.m7548d();
        this.f7630e = System.currentTimeMillis();
    }

    public void m10307z(int i) {
        this.f7626a = i;
        this.f7627b = System.currentTimeMillis();
    }

    public AbstractC2454v2(Context context, Looper looper, AbstractC0298Gc abstractC0298Gc, C0390Ic c0390Ic, int i, a aVar, b bVar, String str) {
        this.f7631f = null;
        this.f7638m = new Object();
        this.f7639n = new Object();
        this.f7643r = new ArrayList<>();
        this.f7645t = 1;
        this.f7651z = null;
        this.f7623A = false;
        this.f7624B = null;
        this.f7625C = new AtomicInteger(0);
        AbstractC1085Xi.m4802k(context, "Context must not be null");
        this.f7633h = context;
        AbstractC1085Xi.m4802k(looper, "Looper must not be null");
        this.f7634i = looper;
        AbstractC1085Xi.m4802k(abstractC0298Gc, "Supervisor must not be null");
        this.f7635j = abstractC0298Gc;
        AbstractC1085Xi.m4802k(c0390Ic, "API availability must not be null");
        this.f7636k = c0390Ic;
        this.f7637l = new HandlerC2258qr(this, looper);
        this.f7648w = i;
        this.f7646u = aVar;
        this.f7647v = bVar;
        this.f7649x = str;
    }
}
