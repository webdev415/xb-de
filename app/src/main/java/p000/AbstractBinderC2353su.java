package p000;

import android.os.Bundle;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class AbstractBinderC2353su extends AbstractBinderC2443us implements InterfaceC2076mu {
    public AbstractBinderC2353su() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override
    public final boolean mo7274O(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
        AbstractC2351ss.m9603f(parcel);
        mo7764f(bundle);
        parcel2.writeNoException();
        return true;
    }
}
