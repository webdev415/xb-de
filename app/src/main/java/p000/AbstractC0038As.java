package p000;

import android.util.Log;

/* loaded from: classes.dex */
public abstract class AbstractC0038As {

    public Object f91a;

    public boolean f92b = false;

    public final AbstractC2454v2 f93c;

    public AbstractC0038As(AbstractC2454v2 abstractC2454v2, Object obj) {
        this.f93c = abstractC2454v2;
        this.f91a = obj;
    }

    public abstract void mo161a(Object obj);

    public abstract void mo162b();

    public final void m163c() {
        Object obj;
        synchronized (this) {
            try {
                obj = this.f91a;
                if (this.f92b) {
                    Log.w("GmsClient", "Callback proxy " + toString() + " being reused. This is not safe.");
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (obj != null) {
            mo161a(obj);
        }
        synchronized (this) {
            this.f92b = true;
        }
        m165e();
    }

    public final void m164d() {
        synchronized (this) {
            this.f91a = null;
        }
    }

    public final void m165e() {
        m164d();
        synchronized (this.f93c.f7643r) {
            this.f93c.f7643r.remove(this);
        }
    }
}
