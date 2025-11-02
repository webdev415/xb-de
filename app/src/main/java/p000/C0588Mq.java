package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0588Mq implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        Bundle bundleM7976a = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            if (AbstractC1883il.m7983h(iM7988m) != 1) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                bundleM7976a = AbstractC1883il.m7976a(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0312Gq(bundleM7976a);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0312Gq[i];
    }
}
