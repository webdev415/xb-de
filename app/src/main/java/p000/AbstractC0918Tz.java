package p000;

import android.os.Binder;

public abstract class AbstractC0918Tz {
    public static Object m4186a(InterfaceC0826Rz interfaceC0826Rz) {
        try {
            return interfaceC0826Rz.mo1461a();
        } catch (SecurityException unused) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                return interfaceC0826Rz.mo1461a();
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }
}
