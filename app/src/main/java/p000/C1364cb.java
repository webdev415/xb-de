package p000;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.google.firebase.FirebaseCommonRegistrar;
import com.google.firebase.components.ComponentDiscoveryService;
import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.provider.FirebaseInitProvider;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p000.C1063X5;
import p000.ComponentCallbacks2C1760g2;

/* loaded from: classes.dex */
public class C1364cb {

    public static final Object f3957k = new Object();

    public static final Map f3958l = new C2453v1();

    public final Context f3959a;

    public final String f3960b;

    public final C2334sb f3961c;

    public final C1063X5 f3962d;

    public final C0117Cf f3965g;

    public final InterfaceC2388tj f3966h;

    public final AtomicBoolean f3963e = new AtomicBoolean(false);

    public final AtomicBoolean f3964f = new AtomicBoolean();

    public final List f3967i = new CopyOnWriteArrayList();

    public final List f3968j = new CopyOnWriteArrayList();

    public interface a {
        void mo5659a(boolean z);
    }

    public static class b implements ComponentCallbacks2C1760g2.a {

        public static AtomicReference f3969a = new AtomicReference();

        public static void m5883c(Context context) {
            if (AbstractC0993Vi.m4412a() && (context.getApplicationContext() instanceof Application)) {
                Application application = (Application) context.getApplicationContext();
                if (f3969a.get() == null) {
                    b bVar = new b();
                    if (AbstractC1639db.m7321a(f3969a, null, bVar)) {
                        ComponentCallbacks2C1760g2.m7687c(application);
                        ComponentCallbacks2C1760g2.m7686b().m7688a(bVar);
                    }
                }
            }
        }

        @Override
        public void mo5884a(boolean z) {
            synchronized (C1364cb.f3957k) {
                try {
                    Iterator it = new ArrayList<>(C1364cb.f3958l.values()).iterator();
                    while (it.hasNext()) {
                        C1364cb c1364cb = (C1364cb) it.next();
                        if (c1364cb.f3963e.get()) {
                            c1364cb.m5881x(z);
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public static class c extends BroadcastReceiver {

        public static AtomicReference f3970b = new AtomicReference();

        public final Context f3971a;

        public c(Context context) {
            this.f3971a = context;
        }

        public static void m5886b(Context context) {
            if (f3970b.get() == null) {
                c cVar = new c(context);
                if (AbstractC1639db.m7321a(f3970b, null, cVar)) {
                    context.registerReceiver(cVar, new IntentFilter("android.intent.action.USER_UNLOCKED"));
                }
            }
        }

        public void m5887c() {
            this.f3971a.unregisterReceiver(this);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            synchronized (C1364cb.f3957k) {
                try {
                    Iterator it = C1364cb.f3958l.values().iterator();
                    while (it.hasNext()) {
                        ((C1364cb) it.next()).m5876o();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            m5887c();
        }
    }

    public C1364cb(final Context context, String str, C2334sb c2334sb) {
        this.f3959a = (Context) AbstractC1085Xi.m4801j(context);
        this.f3960b = AbstractC1085Xi.m4795d(str);
        this.f3961c = (C2334sb) AbstractC1085Xi.m4801j(c2334sb);
        AbstractC2391tm abstractC2391tmM6009b = FirebaseInitProvider.m6009b();
        AbstractC2380tb.m9702b("Firebase");
        AbstractC2380tb.m9702b("ComponentDiscovery");
        List listM2822b = C0558M5.m2819c(context, ComponentDiscoveryService.class).m2822b();
        AbstractC2380tb.m9701a();
        AbstractC2380tb.m9702b("Runtime");
        C1063X5.b bVarM4650g = C1063X5.m4632k(EnumC1698eo.INSTANCE).m4648d(listM2822b).m4647c(new FirebaseCommonRegistrar()).m4647c(new ExecutorsRegistrar()).m4646b(C0420J5.m1802s(context, Context.class, new Class[0])).m4646b(C0420J5.m1802s(this, C1364cb.class, new Class[0])).m4646b(C0420J5.m1802s(c2334sb, C2334sb.class, new Class[0])).m4650g(new C0742Q5());
        if (AbstractC2485vo.m10404a(context) && FirebaseInitProvider.m6010c()) {
            bVarM4650g.m4646b(C0420J5.m1802s(abstractC2391tmM6009b, AbstractC2391tm.class, new Class[0]));
        }
        C1063X5 c1063x5M4649e = bVarM4650g.m4649e();
        this.f3962d = c1063x5M4649e;
        AbstractC2380tb.m9701a();
        this.f3965g = new C0117Cf(new InterfaceC2388tj() {
            @Override
            public final Object get() {
                return this.f3537a.m5879u(context);
            }
        });
        this.f3966h = c1063x5M4649e.mo2284c(C1351c8.class);
        m5869g(new a() {
            @Override
            public final void mo5659a(boolean z) {
                this.f3872a.m5880v(z);
            }
        });
        AbstractC2380tb.m9701a();
    }

    public static C1364cb m5864k() {
        C1364cb c1364cb;
        synchronized (f3957k) {
            try {
                c1364cb = (C1364cb) f3958l.get("[DEFAULT]");
                if (c1364cb == null) {
                    throw new IllegalStateException("Default FirebaseApp is not initialized in this process " + AbstractC1740fj.m7604a() + ". Make sure to call FirebaseApp.initializeApp(Context) first.");
                }
                ((C1351c8) c1364cb.f3966h.get()).m5753k();
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1364cb;
    }

    public static C1364cb m5865p(Context context) {
        synchronized (f3957k) {
            try {
                if (f3958l.containsKey("[DEFAULT]")) {
                    return m5864k();
                }
                C2334sb c2334sbM9538a = C2334sb.m9538a(context);
                if (c2334sbM9538a == null) {
                    Log.w("FirebaseApp", "Default FirebaseApp failed to initialize because no default options were found. This usually means that com.google.gms:google-services was not applied to your gradle project.");
                    return null;
                }
                return m5866q(context, c2334sbM9538a);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static C1364cb m5866q(Context context, C2334sb c2334sb) {
        return m5867r(context, c2334sb, "[DEFAULT]");
    }

    public static C1364cb m5867r(Context context, C2334sb c2334sb, String str) {
        C1364cb c1364cb;
        b.m5883c(context);
        String strM5868w = m5868w(str);
        if (context.getApplicationContext() != null) {
            context = context.getApplicationContext();
        }
        synchronized (f3957k) {
            Map map = f3958l;
            AbstractC1085Xi.m4805n(!map.containsKey(strM5868w), "FirebaseApp name " + strM5868w + " already exists!");
            AbstractC1085Xi.m4802k(context, "Application context cannot be null.");
            c1364cb = new C1364cb(context, strM5868w, c2334sb);
            map.put(strM5868w, c1364cb);
        }
        c1364cb.m5876o();
        return c1364cb;
    }

    public static String m5868w(String str) {
        return str.trim();
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1364cb) {
            return this.f3960b.equals(((C1364cb) obj).m5873l());
        }
        return false;
    }

    public void m5869g(a aVar) {
        m5870h();
        if (this.f3963e.get() && ComponentCallbacks2C1760g2.m7686b().m7689d()) {
            aVar.mo5659a(true);
        }
        this.f3967i.add(aVar);
    }

    public final void m5870h() {
        AbstractC1085Xi.m4805n(!this.f3964f.get(), "FirebaseApp was deleted");
    }

    public int hashCode() {
        return this.f3960b.hashCode();
    }

    public Object m5871i(Class cls) {
        m5870h();
        return this.f3962d.mo2282a(cls);
    }

    public Context m5872j() {
        m5870h();
        return this.f3959a;
    }

    public String m5873l() {
        m5870h();
        return this.f3960b;
    }

    public C2334sb m5874m() {
        m5870h();
        return this.f3961c;
    }

    public String m5875n() {
        return AbstractC2362t2.m9664a(m5873l().getBytes(Charset.defaultCharset())) + "+" + AbstractC2362t2.m9664a(m5874m().m9540c().getBytes(Charset.defaultCharset()));
    }

    public final void m5876o() {
        if (!AbstractC2485vo.m10404a(this.f3959a)) {
            Log.i("FirebaseApp", "Device in Direct Boot Mode: postponing initialization of Firebase APIs for app " + m5873l());
            c.m5886b(this.f3959a);
            return;
        }
        Log.i("FirebaseApp", "Device unlocked: initializing all Firebase APIs for app " + m5873l());
        this.f3962d.m4638n(m5878t());
        ((C1351c8) this.f3966h.get()).m5753k();
    }

    public boolean m5877s() {
        m5870h();
        return ((C1905j7) this.f3965g.get()).m8106b();
    }

    public boolean m5878t() {
        return "[DEFAULT]".equals(m5873l());
    }

    public String toString() {
        return AbstractC0257Fh.m1257c(this).m1258a("name", this.f3960b).m1258a("options", this.f3961c).toString();
    }

    public final C1905j7 m5879u(Context context) {
        return new C1905j7(context, m5875n(), (InterfaceC2526wj) this.f3962d.mo2282a(InterfaceC2526wj.class));
    }

    public final void m5880v(boolean z) {
        if (z) {
            return;
        }
        ((C1351c8) this.f3966h.get()).m5753k();
    }

    public final void m5881x(boolean z) {
        Log.d("FirebaseApp", "Notifying background state change listeners.");
        Iterator it = this.f3967i.iterator();
        while (it.hasNext()) {
            ((a) it.next()).mo5659a(z);
        }
    }
}
