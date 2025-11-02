package p000;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class C0545Lt extends AbstractC0908Tp implements InterfaceC0409Iv {
    public C0545Lt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    @Override
    public final boolean mo1724D(boolean z) {
        Parcel parcelM4183O = m4183O();
        AbstractC0130Cs.m528a(parcelM4183O, true);
        Parcel parcelM4184P = m4184P(2, parcelM4183O);
        boolean zM529b = AbstractC0130Cs.m529b(parcelM4184P);
        parcelM4184P.recycle();
        return zM529b;
    }

    @Override
    public final String mo1725c() {
        Parcel parcelM4184P = m4184P(1, m4183O());
        String string = parcelM4184P.readString();
        parcelM4184P.recycle();
        return string;
    }
}
