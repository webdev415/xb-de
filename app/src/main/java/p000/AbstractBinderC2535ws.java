package p000;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public abstract class AbstractBinderC2535ws extends AbstractBinderC2443us implements InterfaceC2627ys {
    public static InterfaceC2627ys m10614P(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC2627ys ? (InterfaceC2627ys) iInterfaceQueryLocalInterface : new C0452Js(iBinder);
    }
}
