package p000;

import android.os.IBinder;
import android.os.IInterface;

public abstract class AbstractBinderC2349sq extends AbstractBinderC2488vr implements InterfaceC2487vq {
    public static InterfaceC2487vq m9597P(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2487vq ? (InterfaceC2487vq) iInterfaceQueryLocalInterface : new C2211pq(iBinder);
    }
}
