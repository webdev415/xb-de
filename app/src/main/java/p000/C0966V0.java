package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class C0966V0 {

    public static volatile C0966V0 f2903d;

    public static final Object f2904e = new Object();

    public final Context f2907c;

    public final Set f2906b = new HashSet();

    public final Map f2905a = new HashMap<>();

    public C0966V0(Context context) {
        this.f2907c = context.getApplicationContext();
    }

    public static C0966V0 m4303d(Context context) {
        if (f2903d == null) {
            synchronized (f2904e) {
                try {
                    if (f2903d == null) {
                        f2903d = new C0966V0(context);
                    }
                } finally {
                }
            }
        }
        return f2903d;
    }

    public void m4304a() {
        try {
            try {
                AbstractC0539Ln.m2732a("Startup");
                m4305b(this.f2907c.getPackageManager().getProviderInfo(new ComponentName(this.f2907c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e) {
                throw new C2345sm(e);
            }
        } finally {
            AbstractC0539Ln.m2733b();
        }
    }

    public void m4305b(Bundle bundle) throws ClassNotFoundException {
        String string = this.f2907c.getString(AbstractC0673Oj.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (InterfaceC2014le.class.isAssignableFrom(cls)) {
                            this.f2906b.add(cls);
                        }
                    }
                }
                Iterator it = this.f2906b.iterator();
                while (it.hasNext()) {
                    m4306c((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e) {
                throw new C2345sm(e);
            }
        }
    }

    public final Object m4306c(Class cls, Set set) {
        Object objMo5448b;
        if (AbstractC0539Ln.m2735d()) {
            try {
                AbstractC0539Ln.m2732a(cls.getSimpleName());
            } catch (Throwable th) {
                AbstractC0539Ln.m2733b();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f2905a.containsKey(cls)) {
            objMo5448b = this.f2905a.get(cls);
        } else {
            set.add(cls);
            try {
                InterfaceC2014le interfaceC2014le = (InterfaceC2014le) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listMo5447a = interfaceC2014le.mo5447a();
                if (!listMo5447a.isEmpty()) {
                    for (Class cls2 : listMo5447a) {
                        if (!this.f2905a.containsKey(cls2)) {
                            m4306c(cls2, set);
                        }
                    }
                }
                objMo5448b = interfaceC2014le.mo5448b(this.f2907c);
                set.remove(cls);
                this.f2905a.put(cls, objMo5448b);
            } catch (Throwable th2) {
                throw new C2345sm(th2);
            }
        }
        AbstractC0539Ln.m2733b();
        return objMo5448b;
    }
}
