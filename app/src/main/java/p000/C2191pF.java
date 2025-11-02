package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C2191pF implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        String strM7979d = null;
        long jM7991p = 0;
        int iM7990o = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h == 2) {
                jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
            } else if (iM7983h != 3) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C1913jF(strM7979d, jM7991p, iM7990o);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C1913jF[i];
    }
}
