package p000;

import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

public final class C1102Xz implements InterfaceC0643Nz {

    public static C1102Xz f3294c;

    public final Context f3295a;

    public final ContentObserver f3296b;

    public C1102Xz() {
        this.f3295a = null;
        this.f3296b = null;
    }

    public static C1102Xz m4859a(Context context) {
        C1102Xz c1102Xz;
        synchronized (C1102Xz.class) {
            try {
                if (f3294c == null) {
                    f3294c = AbstractC0488Ki.m2382b(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new C1102Xz(context) : new C1102Xz();
                }
                c1102Xz = f3294c;
            } catch (Throwable th) {
                throw th;
            }
        }
        return c1102Xz;
    }

    public static synchronized void m4860b() {
        Context context;
        try {
            C1102Xz c1102Xz = f3294c;
            if (c1102Xz != null && (context = c1102Xz.f3295a) != null && c1102Xz.f3296b != null) {
                context.getContentResolver().unregisterContentObserver(f3294c.f3296b);
            }
            f3294c = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final String m4861c(String str) {
        return AbstractC1295az.m5572a(this.f3295a.getContentResolver(), str, null);
    }

    @Override
    public final String mo1365g(final String str) {
        Context context = this.f3295a;
        if (context != null && !AbstractC0229Ez.m1160b(context)) {
            try {
                return (String) AbstractC0918Tz.m4186a(new InterfaceC0826Rz() {
                    @Override
                    public final Object mo1461a() {
                        return this.f3013a.m4861c(str);
                    }
                });
            } catch (IllegalStateException | NullPointerException | SecurityException e) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + str, e);
            }
        }
        return null;
    }

    public C1102Xz(Context context) {
        this.f3295a = context;
        C1307bA c1307bA = new C1307bA(this, null);
        this.f3296b = c1307bA;
        context.getContentResolver().registerContentObserver(AbstractC1803gz.f5668a, true, c1307bA);
    }
}
