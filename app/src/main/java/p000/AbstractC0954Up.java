package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public abstract class AbstractC0954Up implements IInterface {

    public final IBinder f2880c;

    public final String f2881d;

    public AbstractC0954Up(IBinder iBinder, String str) {
        this.f2880c = iBinder;
        this.f2881d = str;
    }

    public final Parcel m4293O(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f2880c.transact(i, parcel, parcelObtain, 0);
                parcelObtain.readException();
                return parcelObtain;
            } catch (RuntimeException e) {
                parcelObtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    public final Parcel m4294P() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f2881d);
        return parcelObtain;
    }

    @Override
    public final IBinder asBinder() {
        return this.f2880c;
    }
}
