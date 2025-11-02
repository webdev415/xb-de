package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1121YH implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        boolean zM7984i = false;
        int iM7990o = 0;
        String strM7979d = null;
        int iM7990o2 = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
            } else if (iM7983h == 2) {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h == 3) {
                iM7990o2 = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h != 4) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C2377tH(zM7984i, strM7979d, iM7990o2, iM7990o);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C2377tH[i];
    }
}
