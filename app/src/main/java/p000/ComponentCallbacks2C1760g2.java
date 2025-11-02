package p000;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class ComponentCallbacks2C1760g2 implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    public static final ComponentCallbacks2C1760g2 f5578e = new ComponentCallbacks2C1760g2();

    public final AtomicBoolean f5579a = new AtomicBoolean();

    public final AtomicBoolean f5580b = new AtomicBoolean();

    public final ArrayList f5581c = new ArrayList<>();

    public boolean f5582d = false;

    public interface a {
        void mo5884a(boolean z);
    }

    public static ComponentCallbacks2C1760g2 m7686b() {
        return f5578e;
    }

    public static void m7687c(Application application) {
        ComponentCallbacks2C1760g2 componentCallbacks2C1760g2 = f5578e;
        synchronized (componentCallbacks2C1760g2) {
            try {
                if (!componentCallbacks2C1760g2.f5582d) {
                    application.registerActivityLifecycleCallbacks(componentCallbacks2C1760g2);
                    application.registerComponentCallbacks(componentCallbacks2C1760g2);
                    componentCallbacks2C1760g2.f5582d = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void m7688a(a aVar) {
        synchronized (f5578e) {
            this.f5581c.add(aVar);
        }
    }

    public boolean m7689d() {
        return this.f5579a.get();
    }

    public final void m7690e(boolean z) {
        synchronized (f5578e) {
            try {
                Iterator it = this.f5581c.iterator();
                while (it.hasNext()) {
                    ((a) it.next()).mo5884a(z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        AtomicBoolean atomicBoolean = this.f5580b;
        boolean zCompareAndSet = this.f5579a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m7690e(false);
        }
    }

    @Override
    public final void onActivityResumed(Activity activity) {
        AtomicBoolean atomicBoolean = this.f5580b;
        boolean zCompareAndSet = this.f5579a.compareAndSet(true, false);
        atomicBoolean.set(true);
        if (zCompareAndSet) {
            m7690e(false);
        }
    }

    @Override
    public final void onTrimMemory(int i) {
        if (i == 20 && this.f5579a.compareAndSet(false, true)) {
            this.f5580b.set(true);
            m7690e(true);
        }
    }

    @Override
    public final void onLowMemory() {
    }

    @Override
    public final void onActivityDestroyed(Activity activity) {
    }

    @Override
    public final void onActivityPaused(Activity activity) {
    }

    @Override
    public final void onActivityStarted(Activity activity) {
    }

    @Override
    public final void onActivityStopped(Activity activity) {
    }

    @Override
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }
}
