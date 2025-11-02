package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0289GC implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        Bundle bundleM7976a = null;
        C1904j6 c1904j6 = null;
        int iM7990o = 0;
        C0618Na[] c0618NaArr = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                bundleM7976a = AbstractC1883il.m7976a(parcel, iM7988m);
            } else if (iM7983h == 2) {
                c0618NaArr = (C0618Na[]) AbstractC1883il.m7981f(parcel, iM7988m, C0618Na.CREATOR);
            } else if (iM7983h == 3) {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h != 4) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                c1904j6 = (C1904j6) AbstractC1883il.m7978c(parcel, iM7988m, C1904j6.CREATOR);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0242FB(bundleM7976a, c0618NaArr, iM7990o, c1904j6);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0242FB[i];
    }
}
