package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractBinderC1917jJ extends AbstractBinderC2488vr implements InterfaceC1333bq {
    public AbstractBinderC1917jJ() {
        super("com.google.android.gms.common.internal.ICertData");
    }

    public static InterfaceC1333bq m8129P(IBinder iBinder) {
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ICertData");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1333bq ? (InterfaceC1333bq) iInterfaceQueryLocalInterface : new C1362cJ(iBinder);
    }

    @Override
    public final boolean mo7861O(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            InterfaceC0667Od interfaceC0667OdMo886d = mo886d();
            parcel2.writeNoException();
            AbstractC0176Ds.m792d(parcel2, interfaceC0667OdMo886d);
        } else {
            if (i != 2) {
                return false;
            }
            int iMo885c = mo885c();
            parcel2.writeNoException();
            parcel2.writeInt(iMo885c);
        }
        return true;
    }
}
