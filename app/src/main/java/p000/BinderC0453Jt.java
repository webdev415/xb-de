package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

public final class BinderC0453Jt extends AbstractBinderC1841hq {

    public AbstractC2454v2 f1464c;

    public final int f1465d;

    public BinderC0453Jt(AbstractC2454v2 abstractC2454v2, int i) {
        this.f1464c = abstractC2454v2;
        this.f1465d = i;
    }

    @Override
    public final void mo1966L(int i, IBinder iBinder, C0242FB c0242fb) {
        AbstractC2454v2 abstractC2454v2 = this.f1464c;
        AbstractC1085Xi.m4802k(abstractC2454v2, "onPostInitCompleteWithConnectionInfo can be called only once per call togetRemoteService");
        AbstractC1085Xi.m4801j(c0242fb);
        AbstractC2454v2.m10272P(abstractC2454v2, c0242fb);
        mo1967N(i, iBinder, c0242fb.f651l);
    }

    @Override
    public final void mo1967N(int i, IBinder iBinder, Bundle bundle) {
        AbstractC1085Xi.m4802k(this.f1464c, "onPostInitComplete can be called only once per call to getRemoteService");
        this.f1464c.m10277A(i, iBinder, bundle, this.f1465d);
        this.f1464c = null;
    }

    @Override
    public final void mo1968l(int i, Bundle bundle) {
        Log.wtf("GmsClient", "received deprecated onAccountValidationComplete callback, ignoring", new Exception());
    }
}
