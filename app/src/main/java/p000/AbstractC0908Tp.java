package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class AbstractC0908Tp implements IInterface {

    public final IBinder f2783c;

    public final String f2784d = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";

    public AbstractC0908Tp(IBinder iBinder, String str) {
        this.f2783c = iBinder;
    }

    public final Parcel m4183O() {
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(this.f2784d);
        return parcelObtain;
    }

    public final Parcel m4184P(int i, Parcel parcel) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            try {
                this.f2783c.transact(i, parcel, parcelObtain, 0);
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

    @Override
    public final IBinder asBinder() {
        return this.f2783c;
    }
}
