package p000;

import android.os.Build;
import java.lang.Thread;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public final class C0599N0 extends AbstractC2635z implements InterfaceC0329H6 {
    private volatile Object _preHandler;

    public C0599N0() {
        super(InterfaceC0329H6.f1018b);
        this._preHandler = this;
    }

    public final Method m3251T() {
        Object obj = this._preHandler;
        if (obj != this) {
            return (Method) obj;
        }
        Method method = null;
        try {
            Method declaredMethod = Thread.class.getDeclaredMethod("getUncaughtExceptionPreHandler", null);
            if (Modifier.isPublic(declaredMethod.getModifiers())) {
                if (Modifier.isStatic(declaredMethod.getModifiers())) {
                    method = declaredMethod;
                }
            }
        } catch (Throwable unused) {
        }
        this._preHandler = method;
        return method;
    }

    @Override
    public void mo1511g(InterfaceC0191E6 interfaceC0191E6, Throwable th) {
        int i = Build.VERSION.SDK_INT;
        if (26 > i || i >= 28) {
            return;
        }
        Method methodM3251T = m3251T();
        Object objInvoke = methodM3251T != null ? methodM3251T.invoke(null, null) : null;
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = objInvoke instanceof Thread.UncaughtExceptionHandler ? (Thread.UncaughtExceptionHandler) objInvoke : null;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(Thread.currentThread(), th);
        }
    }
}
