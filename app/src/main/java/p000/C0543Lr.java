package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0543Lr implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        String strM7979d = null;
        C0175Dr c0175Dr = null;
        String strM7979d2 = null;
        long jM7991p = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 2) {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h == 3) {
                c0175Dr = (C0175Dr) AbstractC1883il.m7978c(parcel, iM7988m, C0175Dr.CREATOR);
            } else if (iM7983h == 4) {
                strM7979d2 = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h != 5) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0635Nr(strM7979d, c0175Dr, strM7979d2, jM7991p);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0635Nr[i];
    }
}
