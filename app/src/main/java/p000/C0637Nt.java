package p000;

import android.text.TextUtils;

public final class C0637Nt {

    public final EnumC0333HA f1978a;

    public C0637Nt(EnumC0333HA enumC0333HA) {
        this.f1978a = enumC0333HA;
    }

    public static C0637Nt m3340a(String str) {
        return new C0637Nt((TextUtils.isEmpty(str) || str.length() > 1) ? EnumC0333HA.UNINITIALIZED : C0425JA.m1842e(str.charAt(0)));
    }

    public final EnumC0333HA m3341b() {
        return this.f1978a;
    }

    public final String m3342c() {
        return String.valueOf(C0425JA.m1839a(this.f1978a));
    }
}
