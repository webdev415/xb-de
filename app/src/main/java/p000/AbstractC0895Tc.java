package p000;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.view.Choreographer;
import java.lang.reflect.InvocationTargetException;
import p000.AbstractC0674Ok;

public abstract class AbstractC0895Tc {

    public static final AbstractC0849Sc f2753a;
    private static volatile Choreographer choreographer;

    static {
        Object objM3431a;
        try {
            AbstractC0674Ok.a aVar = AbstractC0674Ok.f2054l;
            objM3431a = AbstractC0674Ok.m3431a(new C0803Rc(m4136a(Looper.getMainLooper(), true), null, 2, null));
        } catch (Throwable th) {
            AbstractC0674Ok.a aVar2 = AbstractC0674Ok.f2054l;
            objM3431a = AbstractC0674Ok.m3431a(AbstractC0766Qk.m3695a(th));
        }
        f2753a = (AbstractC0849Sc) (AbstractC0674Ok.m3433c(objM3431a) ? null : objM3431a);
    }

    public static final Handler m4136a(Looper looper, boolean z) throws IllegalAccessException, NoSuchMethodException, InstantiationException, SecurityException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance;
        if (!z) {
            return new Handler(looper);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            objNewInstance = Handler.class.getDeclaredMethod("createAsync", Looper.class).invoke(null, looper);
            AbstractC0116Ce.m474c(objNewInstance, "null cannot be cast to non-null type android.os.Handler");
        } else {
            try {
                objNewInstance = Handler.class.getDeclaredConstructor(Looper.class, Handler.Callback.class, Boolean.TYPE).newInstance(looper, null, Boolean.TRUE);
            } catch (NoSuchMethodException unused) {
                return new Handler(looper);
            }
        }
        return (Handler) objNewInstance;
    }
}
