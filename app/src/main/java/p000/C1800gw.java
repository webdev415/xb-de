package p000;

import android.app.Activity;
import p000.C0224Eu;

public final class C1800gw extends C0224Eu.a {

    public final Activity f5652p;

    public final C0224Eu.b f5653q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1800gw(C0224Eu.b bVar, Activity activity) {
        super(C0224Eu.this);
        this.f5652p = activity;
        this.f5653q = bVar;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivityDestroyed(BinderC0211Eh.m1041R(this.f5652p), this.f602m);
    }
}
