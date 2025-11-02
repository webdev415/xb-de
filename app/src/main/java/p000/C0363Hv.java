package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;

public final class C0363Hv extends AbstractC0771Qp {

    public final IBinder f1107g;

    public final AbstractC2454v2 f1108h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0363Hv(AbstractC2454v2 abstractC2454v2, int i, IBinder iBinder, Bundle bundle) {
        super(abstractC2454v2, i, bundle);
        this.f1108h = abstractC2454v2;
        this.f1107g = iBinder;
    }

    @Override
    public final void mo1621f(C1717f6 c1717f6) {
        if (this.f1108h.f7647v != null) {
            this.f1108h.f7647v.mo8241b(c1717f6);
        }
        this.f1108h.m10306y(c1717f6);
    }

    @Override
    public final boolean mo1622g() throws RemoteException {
        String str;
        String interfaceDescriptor;
        try {
            IBinder iBinder = this.f1107g;
            AbstractC1085Xi.m4801j(iBinder);
            interfaceDescriptor = iBinder.getInterfaceDescriptor();
        } catch (RemoteException unused) {
            str = "service probably died";
        }
        if (!this.f1108h.mo10242r().equals(interfaceDescriptor)) {
            str = "service descriptor mismatch: " + this.f1108h.mo10242r() + " vs. " + interfaceDescriptor;
            Log.w("GmsClient", str);
            return false;
        }
        IInterface iInterfaceMo10240d = this.f1108h.mo10240d(this.f1107g);
        if (iInterfaceMo10240d == null || !(AbstractC2454v2.m10275T(this.f1108h, 2, 4, iInterfaceMo10240d) || AbstractC2454v2.m10275T(this.f1108h, 3, 4, iInterfaceMo10240d))) {
            return false;
        }
        this.f1108h.f7651z = null;
        AbstractC2454v2 abstractC2454v2 = this.f1108h;
        Bundle bundleM10294j = abstractC2454v2.m10294j();
        if (abstractC2454v2.f7646u == null) {
            return true;
        }
        this.f1108h.f7646u.mo8242c(bundleM10294j);
        return true;
    }
}
