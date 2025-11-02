package p000;

import android.util.Log;

public class C1316bJ {

    public static final C1316bJ f3863e = new C1316bJ(true, 3, 1, null, null);

    public final boolean f3864a;

    public final String f3865b;

    public final Throwable f3866c;

    public final int f3867d;

    public C1316bJ(boolean z, int i, int i2, String str, Throwable th) {
        this.f3864a = z;
        this.f3867d = i;
        this.f3865b = str;
        this.f3866c = th;
    }

    public static C1316bJ m5651b() {
        return f3863e;
    }

    public static C1316bJ m5652c(String str) {
        return new C1316bJ(false, 1, 5, str, null);
    }

    public static C1316bJ m5653d(String str, Throwable th) {
        return new C1316bJ(false, 1, 5, str, th);
    }

    public static C1316bJ m5654f(int i) {
        return new C1316bJ(true, i, 1, null, null);
    }

    public static C1316bJ m5655g(int i, int i2, String str, Throwable th) {
        return new C1316bJ(false, i, i2, str, th);
    }

    public String mo4132a() {
        return this.f3865b;
    }

    public final void m5656e() {
        if (this.f3864a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f3866c != null) {
            Log.d("GoogleCertificatesRslt", mo4132a(), this.f3866c);
        } else {
            Log.d("GoogleCertificatesRslt", mo4132a());
        }
    }
}
