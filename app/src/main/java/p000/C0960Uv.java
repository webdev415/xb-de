package p000;

import android.app.Activity;
import p000.C0224Eu;

/* loaded from: classes.dex */
public final class C0960Uv extends C0224Eu.a {

    public final Activity f2890p;

    public final C0224Eu.b f2891q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0960Uv(C0224Eu.b bVar, Activity activity) {
        super(C0224Eu.this);
        this.f2890p = activity;
        this.f2891q = bVar;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivityStarted(BinderC0211Eh.m1041R(this.f2890p), this.f602m);
    }
}
