package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C2673zs implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        long jM7991p = -1;
        int iM7990o = 0;
        String strM7979d = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h == 2) {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h != 3) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0618Na(strM7979d, iM7990o, jM7991p);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0618Na[i];
    }
}
