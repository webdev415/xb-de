package p000;

import android.app.Activity;
import android.os.Bundle;
import p000.C0224Eu;

public final class C1052Wv extends C0224Eu.a {

    public final Bundle f3157p;

    public final Activity f3158q;

    public final C0224Eu.b f3159r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1052Wv(C0224Eu.b bVar, Bundle bundle, Activity activity) {
        super(C0224Eu.this);
        this.f3157p = bundle;
        this.f3158q = activity;
        this.f3159r = bVar;
    }

    @Override
    public final void mo794a() {
        Bundle bundle;
        if (this.f3157p != null) {
            bundle = new Bundle();
            if (this.f3157p.containsKey("com.google.app_measurement.screen_service")) {
                Object obj = this.f3157p.get("com.google.app_measurement.screen_service");
                if (obj instanceof Bundle) {
                    bundle.putBundle("com.google.app_measurement.screen_service", (Bundle) obj);
                }
            }
        } else {
            bundle = null;
        }
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivityCreated(BinderC0211Eh.m1041R(this.f3158q), bundle, this.f602m);
    }
}
