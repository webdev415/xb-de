package p000;

import android.app.Activity;
import p000.C0224Eu;

/* loaded from: classes.dex */
public final class C1613cw extends C0224Eu.a {

    public final Activity f5263p;

    public final BinderC1798gu f5264q;

    public final C0224Eu.b f5265r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1613cw(C0224Eu.b bVar, Activity activity, BinderC1798gu binderC1798gu) {
        super(C0224Eu.this);
        this.f5263p = activity;
        this.f5264q = binderC1798gu;
        this.f5265r = bVar;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(C0224Eu.this.f600i)).onActivitySaveInstanceState(BinderC0211Eh.m1041R(this.f5263p), this.f5264q, this.f602m);
    }
}
