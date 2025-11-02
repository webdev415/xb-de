package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

public final class C0452Js extends AbstractC2167os implements InterfaceC2627ys {
    public C0452Js(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    @Override
    public final Bundle mo2170f(Bundle bundle) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        Parcel parcelM8983P = m8983P(1, parcelM8982O);
        Bundle bundle2 = (Bundle) AbstractC2351ss.m9598a(parcelM8983P, Bundle.CREATOR);
        parcelM8983P.recycle();
        return bundle2;
    }
}
