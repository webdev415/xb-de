package p000;

import android.os.Bundle;
import android.text.TextUtils;

public final class C0843SF implements InterfaceC2422uG {

    public final C0200EF f2613a;

    public C0843SF(C0200EF c0200ef) {
        this.f2613a = c0200ef;
    }

    @Override
    public final void mo4024l(String str, String str2, Bundle bundle) {
        if (!TextUtils.isEmpty(str)) {
            this.f2613a.mo354l().m7374C(new RunnableC1119YF(this, str, str2, bundle));
        } else if (this.f2613a.f498l != null) {
            this.f2613a.f498l.mo349g().m9618G().m10617b("AppId not known when logging event", str2);
        }
    }
}
