package p000;

import android.content.Intent;
import p000.C0224Eu;

/* loaded from: classes.dex */
public final class C0731Pv extends C0224Eu.a {

    public final Intent f2181p;

    public final C0224Eu f2182q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0731Pv(C0224Eu c0224Eu, Intent intent) {
        super(c0224Eu);
        this.f2181p = intent;
        this.f2182q = c0224Eu;
    }

    @Override
    public final void mo794a() {
        ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f2182q.f600i)).setSgtmDebugInfo(this.f2181p);
    }
}
