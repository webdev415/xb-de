package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class AbstractC2167os implements IInterface {

    public final IBinder f6590c;

    public final String f6591d;

    public AbstractC2167os(IBinder iBinder, String str) {
        this.f6590c = iBinder;
        this.f6591d = str;
    }

    public final Parcel m8982O() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f6591d);
        return parcelObtain;
    }

    public final Parcel m8983P(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f6590c.transact(i, parcel, parcelObtain, 0);
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

    public final void m8984Q(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            this.f6590c.transact(i, parcel, parcelObtain, 0);
            parcelObtain.readException();
        } finally {
            parcel.recycle();
            parcelObtain.recycle();
        }
    }

    @Override
    public IBinder asBinder() {
        return this.f6590c;
    }
}
