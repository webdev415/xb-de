package p000;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import p000.C0224Eu;

public final class C0500Ku extends C0224Eu.a {

    public final String f1635p;

    public final String f1636q;

    public final Context f1637r;

    public final Bundle f1638s;

    public final C0224Eu f1639t;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0500Ku(C0224Eu c0224Eu, String str, String str2, Context context, Bundle bundle) {
        super(c0224Eu);
        this.f1635p = str;
        this.f1636q = str2;
        this.f1637r = context;
        this.f1638s = bundle;
        this.f1639t = c0224Eu;
    }

    @Override
    public final void mo794a() {
        String str;
        String str2;
        String str3;
        try {
            if (this.f1639t.m1109C(this.f1635p, this.f1636q)) {
                str3 = this.f1636q;
                str2 = this.f1635p;
                str = this.f1639t.f592a;
            } else {
                str = null;
                str2 = null;
                str3 = null;
            }
            AbstractC1085Xi.m4801j(this.f1637r);
            C0224Eu c0224Eu = this.f1639t;
            c0224Eu.f600i = c0224Eu.m1119e(this.f1637r, true);
            if (this.f1639t.f600i == null) {
                Log.w(this.f1639t.f592a, "Failed to connect to measurement client.");
                return;
            }
            int iM5947a = DynamiteModule.m5947a(this.f1637r, ModuleDescriptor.MODULE_ID);
            ((InterfaceC1984ku) AbstractC1085Xi.m4801j(this.f1639t.f600i)).initialize(BinderC0211Eh.m1041R(this.f1637r), new C0086Bu(102001L, Math.max(iM5947a, r0), DynamiteModule.m5948b(this.f1637r, ModuleDescriptor.MODULE_ID) < iM5947a, str, str2, str3, this.f1638s, C1756fz.m7682a(this.f1637r)), this.f601l);
        } catch (Exception e) {
            this.f1639t.m1125n(e, true, false);
        }
    }
}
