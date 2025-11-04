package p000;

import android.text.TextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import p000.AbstractC0263Fn;
import p000.AbstractC2383te;
import p000.C2242qb;

public class C2149ob implements InterfaceC2196pb {

    public static final Object f6560m = new Object();

    public static final ThreadFactory f6561n = new a();

    public final C1364cb f6562a;

    public final C1965kb f6563b;

    public final C0534Li f6564c;

    public final C0034Ao f6565d;

    public final C0117Cf f6566e;

    public final C1040Wj f6567f;

    public final Object f6568g;

    public final ExecutorService f6569h;

    public final Executor f6570i;

    public String f6571j;

    public Set f6572k;

    public final List f6573l;

    public class a implements ThreadFactory {

        public final AtomicInteger f6574a = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", Integer.valueOf(this.f6574a.getAndIncrement())));
        }
    }

    public static class b {

        public static final int[] f6575a;

        public static final int[] f6576b;

        static {
            int[] iArr = new int[AbstractC0263Fn.b.values().length];
            f6576b = iArr;
            try {
                iArr[AbstractC0263Fn.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f6576b[AbstractC0263Fn.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f6576b[AbstractC0263Fn.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[AbstractC2383te.b.values().length];
            f6575a = iArr2;
            try {
                iArr2[AbstractC2383te.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f6575a[AbstractC2383te.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public C2149ob(final C1364cb c1364cb, InterfaceC2388tj interfaceC2388tj, ExecutorService executorService, Executor executor) {
        this(executorService, executor, c1364cb, new C1965kb(c1364cb.m5872j(), interfaceC2388tj), new C0534Li(c1364cb), C0034Ao.m143c(), new C0117Cf(new InterfaceC2388tj() {
            @Override
            public final Object get() {
                return C2149ob.m8938v(c1364cb);
            }
        }), new C1040Wj());
    }

    public static C2149ob m8936n() {
        return m8937o(C1364cb.m5864k());
    }

    public static C2149ob m8937o(C1364cb c1364cb) {
        AbstractC1085Xi.m4793b(c1364cb != null, "Null is not a valid value of FirebaseApp.");
        return (C2149ob) c1364cb.m5871i(InterfaceC2196pb.class);
    }

    public static C0942Ud m8938v(C1364cb c1364cb) {
        return new C0942Ud(c1364cb);
    }

    public final void m8939A(AbstractC0580Mi abstractC0580Mi) {
        synchronized (this.f6568g) {
            try {
                Iterator it = this.f6573l.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC2483vm) it.next()).mo240a(abstractC0580Mi)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void m8940B(String str) {
        this.f6571j = str;
    }

    public final synchronized void m8941C(AbstractC0580Mi abstractC0580Mi, AbstractC0580Mi abstractC0580Mi2) {
        if (this.f6572k.size() != 0 && !TextUtils.equals(abstractC0580Mi.mo2888d(), abstractC0580Mi2.mo2888d())) {
            Iterator it = this.f6572k.iterator();
            if (it.hasNext()) {
                AbstractC2524wh.m10586a(it.next());
                abstractC0580Mi2.mo2888d();
                throw null;
            }
        }
    }

    public final AbstractC1838hn m8942d() {
        C1885in c1885in = new C1885in();
        m8943e(new C0068Bc(c1885in));
        return c1885in.m7999a();
    }

    public final void m8943e(InterfaceC2483vm interfaceC2483vm) {
        synchronized (this.f6568g) {
            this.f6573l.add(interfaceC2483vm);
        }
    }

    public final void m8956t(boolean z) {
        AbstractC0580Mi abstractC0580MiM8960y;
        Exception iOException;
        AbstractC0580Mi abstractC0580MiM8952p = m8952p();
        try {
            if (abstractC0580MiM8952p.m2893i() || abstractC0580MiM8952p.m2896l()) {
                abstractC0580MiM8960y = m8960y(abstractC0580MiM8952p);
            } else {
                if (!z && !this.f6565d.m150f(abstractC0580MiM8952p)) {
                    return;
                }
                abstractC0580MiM8960y = m8946h(abstractC0580MiM8952p);
            }
            m8955s(abstractC0580MiM8960y);
            m8941C(abstractC0580MiM8952p, abstractC0580MiM8960y);
            if (abstractC0580MiM8960y.m2895k()) {
                m8940B(abstractC0580MiM8960y.mo2888d());
            }
            if (abstractC0580MiM8960y.m2893i()) {
                iOException = new C2242qb(C2242qb.a.BAD_CONFIG);
            } else {
                if (!abstractC0580MiM8960y.m2894j()) {
                    m8939A(abstractC0580MiM8960y);
                    return;
                }
                iOException = new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.");
            }
            m8961z(iOException);
        } catch (C2242qb e) {
            m8961z(e);
        }
    }

    public final void m8945g(final boolean z) {
        AbstractC0580Mi abstractC0580MiM8953q = m8953q();
        if (z) {
            abstractC0580MiM8953q = abstractC0580MiM8953q.m2900p();
        }
        m8939A(abstractC0580MiM8953q);
        this.f6570i.execute(new Runnable() {
            @Override
            public final void run() {
                this.f6309l.m8956t(z);
            }
        });
    }

    public final AbstractC0580Mi m8946h(AbstractC0580Mi abstractC0580Mi) throws C2242qb {
        AbstractC0263Fn abstractC0263FnM8284e = this.f6563b.m8284e(m8947i(), abstractC0580Mi.mo2888d(), m8954r(), abstractC0580Mi.mo2890f());
        int i = b.f6576b[abstractC0263FnM8284e.mo1283b().ordinal()];
        if (i == 1) {
            return abstractC0580Mi.m2899o(abstractC0263FnM8284e.mo1284c(), abstractC0263FnM8284e.mo1285d(), this.f6565d.m148b());
        }
        if (i == 2) {
            return abstractC0580Mi.m2901q("BAD CONFIG");
        }
        if (i != 3) {
            throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
        }
        m8940B(null);
        return abstractC0580Mi.m2902r();
    }

    public String m8947i() {
        return this.f6562a.m5874m().m9539b();
    }

    public String m8948j() {
        return this.f6562a.m5874m().m9540c();
    }

    public final synchronized String m8949k() {
        return this.f6571j;
    }

    public AbstractC1838hn m8950l() {
        m8958w();
        String strM8949k = m8949k();
        if (strM8949k != null) {
            return AbstractC2346sn.m9593d(strM8949k);
        }
        AbstractC1838hn abstractC1838hnM8942d = m8942d();
        this.f6569h.execute(new Runnable() {
            @Override
            public final void run() {
                this.f6174l.m8957u();
            }
        });
        return abstractC1838hnM8942d;
    }

    public final C0942Ud m8951m() {
        return (C0942Ud) this.f6566e.get();
    }

    /* JADX WARN: Finally extract failed */
    public final AbstractC0580Mi m8952p() {
        AbstractC0580Mi abstractC0580MiM2706d;
        synchronized (f6560m) {
            try {
                C1018W6 c1018w6M4447a = C1018W6.m4447a(this.f6562a.m5872j(), "generatefid.lock");
                try {
                    abstractC0580MiM2706d = this.f6564c.m2706d();
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                } catch (Throwable th) {
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return abstractC0580MiM2706d;
    }

    /* JADX WARN: Finally extract failed */
    public final AbstractC0580Mi m8953q() {
        AbstractC0580Mi abstractC0580MiM2706d;
        synchronized (f6560m) {
            try {
                C1018W6 c1018w6M4447a = C1018W6.m4447a(this.f6562a.m5872j(), "generatefid.lock");
                try {
                    abstractC0580MiM2706d = this.f6564c.m2706d();
                    if (abstractC0580MiM2706d.m2894j()) {
                        abstractC0580MiM2706d = this.f6564c.m2704b(abstractC0580MiM2706d.m2904t(m8959x(abstractC0580MiM2706d)));
                    }
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                } catch (Throwable th) {
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return abstractC0580MiM2706d;
    }

    public String m8954r() {
        return this.f6562a.m5874m().m9542e();
    }

    /* JADX WARN: Finally extract failed */
    public final void m8955s(AbstractC0580Mi abstractC0580Mi) {
        synchronized (f6560m) {
            try {
                C1018W6 c1018w6M4447a = C1018W6.m4447a(this.f6562a.m5872j(), "generatefid.lock");
                try {
                    this.f6564c.m2704b(abstractC0580Mi);
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                } catch (Throwable th) {
                    if (c1018w6M4447a != null) {
                        c1018w6M4447a.m4448b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void m8957u() {
        m8945g(false);
    }

    public final void m8958w() {
        AbstractC1085Xi.m4796e(m8948j(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC1085Xi.m4796e(m8954r(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC1085Xi.m4796e(m8947i(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC1085Xi.m4793b(C0034Ao.m146h(m8948j()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        AbstractC1085Xi.m4793b(C0034Ao.m145g(m8947i()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public final String m8959x(AbstractC0580Mi abstractC0580Mi) {
        if ((!this.f6562a.m5873l().equals("CHIME_ANDROID_SDK") && !this.f6562a.m5878t()) || !abstractC0580Mi.m2897m()) {
            return this.f6567f.m4535a();
        }
        String strM4257f = m8951m().m4257f();
        return TextUtils.isEmpty(strM4257f) ? this.f6567f.m4535a() : strM4257f;
    }

    public final AbstractC0580Mi m8960y(AbstractC0580Mi abstractC0580Mi) throws C2242qb {
        AbstractC2383te abstractC2383teM8283d = this.f6563b.m8283d(m8947i(), abstractC0580Mi.mo2888d(), m8954r(), m8948j(), (abstractC0580Mi.mo2888d() == null || abstractC0580Mi.mo2888d().length() != 11) ? null : m8951m().m4260i());
        int i = b.f6575a[abstractC2383teM8283d.mo3973e().ordinal()];
        if (i == 1) {
            return abstractC0580Mi.m2903s(abstractC2383teM8283d.mo3971c(), abstractC2383teM8283d.mo3972d(), this.f6565d.m148b(), abstractC2383teM8283d.mo3970b().mo1284c(), abstractC2383teM8283d.mo3970b().mo1285d());
        }
        if (i == 2) {
            return abstractC0580Mi.m2901q("BAD CONFIG");
        }
        throw new C2242qb("Firebase Installations Service is unavailable. Please try again later.", C2242qb.a.UNAVAILABLE);
    }

    public final void m8961z(Exception exc) {
        synchronized (this.f6568g) {
            try {
                Iterator it = this.f6573l.iterator();
                while (it.hasNext()) {
                    if (((InterfaceC2483vm) it.next()).mo241b(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public C2149ob(ExecutorService executorService, Executor executor, C1364cb c1364cb, C1965kb c1965kb, C0534Li c0534Li, C0034Ao c0034Ao, C0117Cf c0117Cf, C1040Wj c1040Wj) {
        this.f6568g = new Object();
        this.f6572k = new HashSet();
        this.f6573l = new ArrayList<>();
        this.f6562a = c1364cb;
        this.f6563b = c1965kb;
        this.f6564c = c0534Li;
        this.f6565d = c0034Ao;
        this.f6566e = c0117Cf;
        this.f6567f = c1040Wj;
        this.f6569h = executorService;
        this.f6570i = executor;
    }
}
