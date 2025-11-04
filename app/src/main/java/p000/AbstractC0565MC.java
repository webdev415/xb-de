package p000;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractC0565MC {

    public static String f1763a = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static C1957kC m2846a(Class cls) {
        String str;
        ClassLoader classLoader = AbstractC0565MC.class.getClassLoader();
        if (cls.equals(C1957kC.class)) {
            str = f1763a;
        } else {
            if (!cls.getPackage().equals(AbstractC0565MC.class.getPackage())) {
                throw new IllegalArgumentException(cls.getName());
            }
            str = String.format("%s.BlazeGenerated%sLoader", cls.getPackage().getName(), cls.getSimpleName());
        }
        try {
            try {
                try {
                    AbstractC2524wh.m10586a(Class.forName(str, true, classLoader).getConstructor(null).newInstance(null));
                    throw null;
                } catch (InstantiationException e) {
                    throw new IllegalStateException(e);
                } catch (NoSuchMethodException e2) {
                    throw new IllegalStateException(e2);
                }
            } catch (IllegalAccessException e3) {
                throw new IllegalStateException(e3);
            } catch (InvocationTargetException e4) {
                throw new IllegalStateException(e4);
            }
        } catch (ClassNotFoundException unused) {
            Iterator it = ServiceLoader.load(AbstractC0565MC.class, classLoader).iterator();
            ArrayList arrayList = new ArrayList<>();
            while (it.hasNext()) {
                try {
                    AbstractC2524wh.m10586a(it.next());
                    throw null;
                } catch (ServiceConfigurationError e5) {
                    Logger.getLogger(AbstractC1355cC.class.getName()).logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load " + cls.getSimpleName(), (Throwable) e5);
                }
            }
            if (arrayList.size() == 1) {
                return (C1957kC) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (C1957kC) cls.getMethod("combine", Collection.class).invoke(null, arrayList);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException(e6);
            } catch (NoSuchMethodException e7) {
                throw new IllegalStateException(e7);
            } catch (InvocationTargetException e8) {
                throw new IllegalStateException(e8);
            }
        }
    }
}
