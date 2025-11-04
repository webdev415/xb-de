package p000;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

public final class C0725Pp implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        String strM7979d = null;
        int iM7990o = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h != 2) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new Scope(iM7990o, strM7979d);
    }

    @Override
    public final Object[] newArray(int i) {
        return new Scope[i];
    }
}
