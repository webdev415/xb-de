package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0266Fq implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        int iM7990o = 0;
        boolean zM7984i = false;
        boolean zM7984i2 = false;
        int iM7990o2 = 0;
        int iM7990o3 = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h == 2) {
                zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
            } else if (iM7983h == 3) {
                zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
            } else if (iM7983h == 4) {
                iM7990o2 = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h != 5) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                iM7990o3 = AbstractC1883il.m7990o(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C1087Xk(iM7990o, zM7984i, zM7984i2, iM7990o2, iM7990o3);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C1087Xk[i];
    }
}
