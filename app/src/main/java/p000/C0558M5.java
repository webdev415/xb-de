package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.components.ComponentRegistrar;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class C0558M5 {

    public final Object f1752a;

    public final c f1753b;

    public static class b implements c {

        public final Class f1754a;

        public b(Class cls) {
            this.f1754a = cls;
        }

        public final Bundle m2824b(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) this.f1754a), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f1754a + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override
        public List mo2823a(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleM2824b = m2824b(context);
            if (bundleM2824b == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList<>();
            for (String str : bundleM2824b.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleM2824b.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    public interface c {
        List mo2823a(Object obj);
    }

    public C0558M5(Object obj, c cVar) {
        this.f1752a = obj;
        this.f1753b = cVar;
    }

    public static C0558M5 m2819c(Context context, Class cls) {
        return new C0558M5(context, new b(cls));
    }

    public static ComponentRegistrar m2820d(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new C0346He(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e) {
            throw new C0346He(String.format("Could not instantiate %s.", str), e);
        } catch (InstantiationException e2) {
            throw new C0346He(String.format("Could not instantiate %s.", str), e2);
        } catch (NoSuchMethodException e3) {
            throw new C0346He(String.format("Could not instantiate %s", str), e3);
        } catch (InvocationTargetException e4) {
            throw new C0346He(String.format("Could not instantiate %s", str), e4);
        }
    }

    public List m2822b() {
        ArrayList arrayList = new ArrayList<>();
        for (final String str : this.f1753b.mo2823a(this.f1752a)) {
            arrayList.add(new InterfaceC2388tj() {
                @Override
                public final Object get() {
                    return C0558M5.m2820d(str);
                }
            });
        }
        return arrayList;
    }
}
