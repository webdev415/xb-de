package p000;

import android.os.Bundle;

public final class C0136Cy {

    public final C2266qz f326a;

    public C0136Cy(C0200EF c0200ef) {
        this.f326a = c0200ef.m958t0();
    }

    public final Bundle m585a(String str, InterfaceC2627ys interfaceC2627ys) {
        this.f326a.mo354l().mo356n();
        if (interfaceC2627ys == null) {
            this.f326a.mo349g().m9623L().m10616a("Attempting to use Install Referrer Service while it is not initialized");
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("package_name", str);
        try {
            Bundle bundleMo2170f = interfaceC2627ys.mo2170f(bundle);
            if (bundleMo2170f != null) {
                return bundleMo2170f;
            }
            this.f326a.mo349g().m9618G().m10616a("Install Referrer Service returned a null response");
            return null;
        } catch (Exception e) {
            this.f326a.mo349g().m9618G().m10617b("Exception occurred while retrieving the Install Referrer", e.getMessage());
            return null;
        }
    }

    public final boolean m586b() {
        try {
            C2617yi c2617yiM11048a = C2670zp.m11048a(this.f326a.mo344a());
            if (c2617yiM11048a != null) {
                return c2617yiM11048a.m10890c("com.android.vending", 128).versionCode >= 80837300;
            }
            this.f326a.mo349g().m9622K().m10616a("Failed to get PackageManager for Install Referrer Play Store compatibility check");
            return false;
        } catch (Exception e) {
            this.f326a.mo349g().m9622K().m10617b("Failed to retrieve Play Store version for Install Referrer", e);
            return false;
        }
    }
}
