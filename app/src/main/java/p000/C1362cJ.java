package p000;

import android.os.IBinder;
import android.os.Parcel;
import p000.InterfaceC0667Od;

public final class C1362cJ extends AbstractC0954Up implements InterfaceC1333bq {
    public C1362cJ(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    @Override
    public final int mo885c() {
        Parcel parcelM4293O = m4293O(2, m4294P());
        int i = parcelM4293O.readInt();
        parcelM4293O.recycle();
        return i;
    }

    @Override
    public final InterfaceC0667Od mo886d() {
        Parcel parcelM4293O = m4293O(1, m4294P());
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }
}
