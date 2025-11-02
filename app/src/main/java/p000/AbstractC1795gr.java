package p000;

import android.os.Handler;

/* loaded from: classes.dex */
public abstract class AbstractC1795gr {

    public static volatile Handler f5646d;

    public final InterfaceC0241FA f5647a;

    public final Runnable f5648b;

    public volatile long f5649c;

    public AbstractC1795gr(InterfaceC0241FA interfaceC0241FA) {
        AbstractC1085Xi.m4801j(interfaceC0241FA);
        this.f5647a = interfaceC0241FA;
        this.f5648b = new RunnableC1701er(this, interfaceC0241FA);
    }

    public final void m7756a() {
        this.f5649c = 0L;
        m7759f().removeCallbacks(this.f5648b);
    }

    public final void m7757b(long j) {
        m7756a();
        if (j >= 0) {
            this.f5649c = this.f5647a.mo345b().mo2815a();
            if (m7759f().postDelayed(this.f5648b, j)) {
                return;
            }
            this.f5647a.mo349g().m9618G().m10617b("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    public abstract void mo222d();

    public final boolean m7758e() {
        return this.f5649c != 0;
    }

    public final Handler m7759f() {
        Handler handler;
        if (f5646d != null) {
            return f5646d;
        }
        synchronized (AbstractC1795gr.class) {
            try {
                if (f5646d == null) {
                    f5646d = new HandlerC1704eu(this.f5647a.mo344a().getMainLooper());
                }
                handler = f5646d;
            } catch (Throwable th) {
                throw th;
            }
        }
        return handler;
    }
}
