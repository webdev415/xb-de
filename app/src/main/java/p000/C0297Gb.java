package p000;

import java.lang.reflect.InvocationTargetException;
import p000.AbstractComponentCallbacksC0159Db;

/* loaded from: classes.dex */
public class C0297Gb {

    public static final C0950Ul f938a = new C0950Ul();

    public static boolean m1373b(ClassLoader classLoader, String str) {
        try {
            return AbstractComponentCallbacksC0159Db.class.isAssignableFrom(m1374c(classLoader, str));
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static Class m1374c(ClassLoader classLoader, String str) throws ClassNotFoundException {
        C0950Ul c0950Ul = f938a;
        Class cls = (Class) c0950Ul.get(str);
        if (cls != null) {
            return cls;
        }
        Class<?> cls2 = Class.forName(str, false, classLoader);
        c0950Ul.put(str, cls2);
        return cls2;
    }

    public static Class m1375d(ClassLoader classLoader, String str) {
        try {
            return m1374c(classLoader, str);
        } catch (ClassCastException e) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": make sure class is a valid subclass of Fragment", e);
        } catch (ClassNotFoundException e2) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": make sure class name exists", e2);
        }
    }

    public AbstractComponentCallbacksC0159Db mo1376a(ClassLoader classLoader, String str) {
        try {
            AbstractC2524wh.m10586a(m1375d(classLoader, str).getConstructor(null).newInstance(null));
            return null;
        } catch (IllegalAccessException e) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new AbstractComponentCallbacksC0159Db.a("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
