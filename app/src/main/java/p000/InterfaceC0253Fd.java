package p000;

import android.accounts.Account;
import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface InterfaceC0253Fd extends IInterface {

    public static abstract class a extends AbstractBinderC2488vr implements InterfaceC0253Fd {
        public static InterfaceC0253Fd m1248P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IAccountAccessor");
            return iInterfaceQueryLocalInterface instanceof InterfaceC0253Fd ? (InterfaceC0253Fd) iInterfaceQueryLocalInterface : new C0938UI(iBinder);
        }
    }

    Account mo1247b();
}
