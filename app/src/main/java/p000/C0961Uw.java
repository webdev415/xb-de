package p000;

/* loaded from: classes.dex */
public final class C0961Uw {

    public static final Object f2892g = new Object();

    public final String f2893a;

    public final InterfaceC0823Rw f2894b;

    public final Object f2895c;

    public final Object f2896d;

    public volatile Object f2897e;

    public volatile Object f2898f;

    public C0961Uw(String str, Object obj, Object obj2, InterfaceC0823Rw interfaceC0823Rw, boolean z) {
        this.f2896d = new Object();
        this.f2897e = null;
        this.f2898f = null;
        this.f2893a = str;
        this.f2895c = obj;
        this.f2894b = interfaceC0823Rw;
    }

    public final Object m4296a(Object obj) {
        synchronized (this.f2896d) {
        }
        if (obj != null) {
            return obj;
        }
        if (AbstractC0318Gw.f993a == null) {
            return this.f2895c;
        }
        synchronized (f2892g) {
            try {
                if (C1747fq.m7654a()) {
                    return this.f2898f == null ? this.f2895c : this.f2898f;
                }
                try {
                    for (C0961Uw c0961Uw : AbstractC0818Rr.f2481a) {
                        if (C1747fq.m7654a()) {
                            throw new IllegalStateException("Refreshing flag cache must be done on a worker thread.");
                        }
                        Object objMo168a = null;
                        try {
                            InterfaceC0823Rw interfaceC0823Rw = c0961Uw.f2894b;
                            if (interfaceC0823Rw != null) {
                                objMo168a = interfaceC0823Rw.mo168a();
                            }
                        } catch (IllegalStateException unused) {
                        }
                        synchronized (f2892g) {
                            c0961Uw.f2898f = objMo168a;
                        }
                    }
                } catch (SecurityException unused2) {
                }
                InterfaceC0823Rw interfaceC0823Rw2 = this.f2894b;
                if (interfaceC0823Rw2 == null) {
                    return this.f2895c;
                }
                try {
                    return interfaceC0823Rw2.mo168a();
                } catch (IllegalStateException unused3) {
                    return this.f2895c;
                } catch (SecurityException unused4) {
                    return this.f2895c;
                }
            } finally {
            }
        }
    }

    public final String m4297b() {
        return this.f2893a;
    }
}
