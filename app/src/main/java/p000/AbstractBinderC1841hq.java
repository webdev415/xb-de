package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class AbstractBinderC1841hq extends AbstractBinderC2488vr implements InterfaceC0437Jd {
    public AbstractBinderC1841hq() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override
    public final boolean mo7861O(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            int i3 = parcel.readInt();
            IBinder strongBinder = parcel.readStrongBinder();
            Bundle bundle = (Bundle) AbstractC0176Ds.m789a(parcel, Bundle.CREATOR);
            AbstractC0176Ds.m790b(parcel);
            mo1967N(i3, strongBinder, bundle);
        } else if (i == 2) {
            int i4 = parcel.readInt();
            Bundle bundle2 = (Bundle) AbstractC0176Ds.m789a(parcel, Bundle.CREATOR);
            AbstractC0176Ds.m790b(parcel);
            mo1968l(i4, bundle2);
        } else {
            if (i != 3) {
                return false;
            }
            int i5 = parcel.readInt();
            IBinder strongBinder2 = parcel.readStrongBinder();
            C0242FB c0242fb = (C0242FB) AbstractC0176Ds.m789a(parcel, C0242FB.CREATOR);
            AbstractC0176Ds.m790b(parcel);
            mo1966L(i5, strongBinder2, c0242fb);
        }
        parcel2.writeNoException();
        return true;
    }
}
