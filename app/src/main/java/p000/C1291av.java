package p000;

import android.app.Activity;
import p000.C0224Eu;

public final class C1291av extends C0224Eu.a {

    public final Activity f3806p;

    public final String f3807q;

    public final String f3808r;

    public final C0224Eu f3809s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1291av(C0224Eu c0224Eu, Activity activity, String str, String str2) {
        super(c0224Eu);
        this.f3806p = activity;
        this.f3807q = str;
        this.f3808r = str2;
        this.f3809s = c0224Eu;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f3809s.f600i)).setCurrentScreen(BinderC0211Eh.m1041R(this.f3806p), this.f3807q, this.f3808r, this.f601l);
    }
}
