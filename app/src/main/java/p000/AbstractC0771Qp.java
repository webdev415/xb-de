package p000;

import android.app.PendingIntent;
import android.os.Bundle;

public abstract class AbstractC0771Qp extends AbstractC0038As {

    public final int f2296d;

    public final Bundle f2297e;

    public final AbstractC2454v2 f2298f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AbstractC0771Qp(AbstractC2454v2 abstractC2454v2, int i, Bundle bundle) {
        super(abstractC2454v2, Boolean.TRUE);
        this.f2298f = abstractC2454v2;
        this.f2296d = i;
        this.f2297e = bundle;
    }

    @Override
    public final /* bridge */ void mo161a(Object obj) {
        if (this.f2296d != 0) {
            this.f2298f.m10285V(1, null);
            Bundle bundle = this.f2297e;
            mo1621f(new C1717f6(this.f2296d, bundle != null ? (PendingIntent) bundle.getParcelable("pendingIntent") : null));
        } else {
            if (mo1622g()) {
                return;
            }
            this.f2298f.m10285V(1, null);
            mo1621f(new C1717f6(8, null));
        }
    }

    public abstract void mo1621f(C1717f6 c1717f6);

    public abstract boolean mo1622g();

    @Override
    public final void mo162b() {
    }
}
