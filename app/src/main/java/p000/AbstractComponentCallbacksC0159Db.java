package p000;

import android.content.ComponentCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractComponentCallbacksC0159Db implements ComponentCallbacks, View.OnCreateContextMenuListener, InterfaceC0623Nf, InterfaceC0724Po, InterfaceC2067ml {

    public static final Object f391a = new Object();

    public static class a extends RuntimeException {
        public a(String str, Exception exc) {
            super(str, exc);
        }
    }

    public interface b {
    }

    public static AbstractComponentCallbacksC0159Db m694a(Context context, String str, Bundle bundle) {
        try {
            AbstractC2524wh.m10586a(C0297Gb.m1375d(context.getClassLoader(), str).getConstructor(null).newInstance(null));
            if (bundle == null) {
                return null;
            }
            throw null;
        } catch (IllegalAccessException e) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e);
        } catch (InstantiationException e2) {
            throw new a("Unable to instantiate fragment " + str + ": make sure class name exists, is public, and has an empty constructor that is public", e2);
        } catch (NoSuchMethodException e3) {
            throw new a("Unable to instantiate fragment " + str + ": could not find Fragment constructor", e3);
        } catch (InvocationTargetException e4) {
            throw new a("Unable to instantiate fragment " + str + ": calling Fragment constructor caused an exception", e4);
        }
    }
}
