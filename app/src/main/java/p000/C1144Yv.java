package p000;

import android.app.Activity;
import p000.C0224Eu;

public final class C1144Yv extends C0224Eu.a {

    public final Activity f3367p;

    public final C0224Eu.b f3368q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1144Yv(C0224Eu.b bVar, Activity activity) {
        super(C0224Eu.this);
        this.f3367p = activity;
        this.f3368q = bVar;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivityPaused(BinderC0211Eh.m1041R(this.f3367p), this.f602m);
    }
}
