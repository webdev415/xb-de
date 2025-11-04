package p000;

import android.os.IBinder;
import android.os.IInterface;

public abstract class AbstractBinderC0684Ou extends AbstractBinderC2442ur implements InterfaceC0409Iv {
    public static InterfaceC0409Iv m3444O(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC0409Iv ? (InterfaceC0409Iv) iInterfaceQueryLocalInterface : new C0545Lt(iBinder);
    }
}
