package p000;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractBinderC2488vr extends Binder implements IInterface {
    public AbstractBinderC2488vr(String str) {
        attachInterface(this, str);
    }

    public boolean mo7861O(int i, Parcel parcel, Parcel parcel2, int i2) {
        return false;
    }

    @Override
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return mo7861O(i, parcel, parcel2, i2);
    }

    @Override
    public final IBinder asBinder() {
        return this;
    }
}
