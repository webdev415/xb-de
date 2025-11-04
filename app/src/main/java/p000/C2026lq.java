package p000;

import android.os.IBinder;
import android.os.Parcel;

public final class C2026lq implements InterfaceC0483Kd {

    public final IBinder f6106c;

    public C2026lq(IBinder iBinder) {
        this.f6106c = iBinder;
    }

    @Override
    public final void mo2374M(InterfaceC0437Jd interfaceC0437Jd, C0114Cc c0114Cc) {
        Parcel parcelObtain = Parcel.obtain();
        Parcel parcelObtain2 = Parcel.obtain();
        try {
            parcelObtain.writeInterfaceToken("com.google.android.gms.common.internal.IGmsServiceBroker");
            parcelObtain.writeStrongBinder(interfaceC0437Jd != null ? interfaceC0437Jd.asBinder() : null);
            if (c0114Cc != null) {
                parcelObtain.writeInt(1);
                C0475KE.m2318a(c0114Cc, parcelObtain, 0);
            } else {
                parcelObtain.writeInt(0);
            }
            this.f6106c.transact(46, parcelObtain, parcelObtain2, 0);
            parcelObtain2.readException();
            parcelObtain2.recycle();
            parcelObtain.recycle();
        } catch (Throwable th) {
            parcelObtain2.recycle();
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override
    public final IBinder asBinder() {
        return this.f6106c;
    }
}
