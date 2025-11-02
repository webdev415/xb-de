package p000;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class AbstractC2343sk {
    public static Object m9587a(Class cls, Object obj, String str, Class[] clsArr, Object[] objArr) throws NoSuchMethodException, SecurityException {
        try {
            Method declaredMethod = cls.getDeclaredMethod(str, clsArr);
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            e = e;
            e.printStackTrace();
            return null;
        } catch (IllegalArgumentException e2) {
            e = e2;
            e.printStackTrace();
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        } catch (SecurityException e3) {
            e = e3;
            e.printStackTrace();
            return null;
        } catch (InvocationTargetException e4) {
            e = e4;
            e.printStackTrace();
            return null;
        }
    }

    public static Object m9588b(Class cls, String str) {
        try {
            return cls.getDeclaredField(str).get(cls);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
            return null;
        }
    }
}
