package p000;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public abstract class AbstractC2430uf {

    public static boolean f7511a = false;

    public static Method f7512b = null;

    public static boolean f7513c = false;

    public static Field f7514d;

    public interface a {
        boolean mo5318d(KeyEvent keyEvent);
    }

    public static boolean m10090a(ActionBar actionBar, KeyEvent keyEvent) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (!f7511a) {
            try {
                f7512b = actionBar.getClass().getMethod("onMenuKeyEvent", KeyEvent.class);
            } catch (NoSuchMethodException unused) {
            }
            f7511a = true;
        }
        Method method = f7512b;
        if (method != null) {
            try {
                Object objInvoke = method.invoke(actionBar, keyEvent);
                if (objInvoke == null) {
                    return false;
                }
                return ((Boolean) objInvoke).booleanValue();
            } catch (IllegalAccessException | InvocationTargetException unused2) {
            }
        }
        return false;
    }

    public static boolean m10091b(Activity activity, KeyEvent keyEvent) {
        activity.onUserInteraction();
        Window window = activity.getWindow();
        if (window.hasFeature(8)) {
            ActionBar actionBar = activity.getActionBar();
            if (keyEvent.getKeyCode() == 82 && actionBar != null && m10090a(actionBar, keyEvent)) {
                return true;
            }
        }
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (AbstractC0448Jo.m2074c(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(activity, decorView != null ? decorView.getKeyDispatcherState() : null, activity);
    }

    public static boolean m10092c(Dialog dialog, KeyEvent keyEvent) throws NoSuchFieldException, SecurityException {
        DialogInterface.OnKeyListener onKeyListenerM10095f = m10095f(dialog);
        if (onKeyListenerM10095f != null && onKeyListenerM10095f.onKey(dialog, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        Window window = dialog.getWindow();
        if (window.superDispatchKeyEvent(keyEvent)) {
            return true;
        }
        View decorView = window.getDecorView();
        if (AbstractC0448Jo.m2074c(decorView, keyEvent)) {
            return true;
        }
        return keyEvent.dispatch(dialog, decorView != null ? decorView.getKeyDispatcherState() : null, dialog);
    }

    public static boolean m10093d(View view, KeyEvent keyEvent) {
        return AbstractC0448Jo.m2075d(view, keyEvent);
    }

    public static boolean m10094e(a aVar, View view, Window.Callback callback, KeyEvent keyEvent) {
        if (aVar == null) {
            return false;
        }
        return Build.VERSION.SDK_INT >= 28 ? aVar.mo5318d(keyEvent) : callback instanceof Activity ? m10091b((Activity) callback, keyEvent) : callback instanceof Dialog ? m10092c((Dialog) callback, keyEvent) : (view != null && AbstractC0448Jo.m2074c(view, keyEvent)) || aVar.mo5318d(keyEvent);
    }

    public static DialogInterface.OnKeyListener m10095f(Dialog dialog) throws NoSuchFieldException, SecurityException {
        if (!f7513c) {
            try {
                Field declaredField = Dialog.class.getDeclaredField("mOnKeyListener");
                f7514d = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
            }
            f7513c = true;
        }
        Field field = f7514d;
        if (field == null) {
            return null;
        }
        try {
            return (DialogInterface.OnKeyListener) field.get(dialog);
        } catch (IllegalAccessException unused2) {
            return null;
        }
    }
}
