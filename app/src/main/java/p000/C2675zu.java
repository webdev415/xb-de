package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class C2675zu extends AbstractC2167os implements InterfaceC2491vu {
    public C2675zu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    @Override
    public final int mo10407a() {
        Parcel parcelM8983P = m8983P(2, m8982O());
        int i = parcelM8983P.readInt();
        parcelM8983P.recycle();
        return i;
    }

    @Override
    public final void mo10408s(String str, String str2, Bundle bundle, long j) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        parcelM8982O.writeLong(j);
        m8984Q(1, parcelM8982O);
    }
}
