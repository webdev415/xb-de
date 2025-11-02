package p000;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C2212pr implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        PendingIntent pendingIntent = null;
        int iM7990o = 0;
        int iM7990o2 = 0;
        String strM7979d = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h == 2) {
                iM7990o2 = AbstractC1883il.m7990o(parcel, iM7988m);
            } else if (iM7983h == 3) {
                pendingIntent = (PendingIntent) AbstractC1883il.m7978c(parcel, iM7988m, PendingIntent.CREATOR);
            } else if (iM7983h != 4) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C1717f6(iM7990o, iM7990o2, pendingIntent, strM7979d);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C1717f6[i];
    }
}
