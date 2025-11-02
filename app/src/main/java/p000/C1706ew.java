package p000;

import android.app.Activity;
import p000.C0224Eu;

/* loaded from: classes.dex */
public final class C1706ew extends C0224Eu.a {

    public final Activity f5473p;

    public final C0224Eu.b f5474q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1706ew(C0224Eu.b bVar, Activity activity) {
        super(C0224Eu.this);
        this.f5473p = activity;
        this.f5474q = bVar;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivityStopped(BinderC0211Eh.m1041R(this.f5473p), this.f602m);
    }
}
