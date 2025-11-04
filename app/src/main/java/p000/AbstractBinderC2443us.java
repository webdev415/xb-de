package p000;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public abstract class AbstractBinderC2443us extends Binder implements IInterface {
    public AbstractBinderC2443us(String str) {
        attachInterface(this, str);
    }

    public abstract boolean mo7274O(int i, Parcel parcel, Parcel parcel2, int i2);

    @Override
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean zOnTransact;
        if (i > 16777215) {
            zOnTransact = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            zOnTransact = false;
        }
        if (zOnTransact) {
            return true;
        }
        return mo7274O(i, parcel, parcel2, i2);
    }

    @Override
    public IBinder asBinder() {
        return this;
    }
}
