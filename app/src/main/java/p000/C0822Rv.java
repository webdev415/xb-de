package p000;

import android.os.Bundle;
import p000.C0224Eu;

public final class C0822Rv extends C0224Eu.a {

    public final Long f2555p;

    public final String f2556q;

    public final String f2557r;

    public final Bundle f2558s;

    public final boolean f2559t;

    public final boolean f2560u;

    public final C0224Eu f2561v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0822Rv(C0224Eu c0224Eu, Long l, String str, String str2, Bundle bundle, boolean z, boolean z2) {
        super(c0224Eu);
        this.f2555p = l;
        this.f2556q = str;
        this.f2557r = str2;
        this.f2558s = bundle;
        this.f2559t = z;
        this.f2560u = z2;
        this.f2561v = c0224Eu;
    }

    @Override
    public final void mo794a() {
        Long l = this.f2555p;
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f2561v.f600i)).logEvent(this.f2556q, this.f2557r, this.f2558s, this.f2559t, this.f2560u, l == null ? this.f601l : l.longValue());
    }
}
