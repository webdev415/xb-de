package p000;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0525LI implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        boolean zM7984i = false;
        String strM7979d = null;
        IBinder iBinderM7989n = null;
        boolean zM7984i2 = false;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            int iM7983h = AbstractC1883il.m7983h(iM7988m);
            if (iM7983h == 1) {
                strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
            } else if (iM7983h == 2) {
                iBinderM7989n = AbstractC1883il.m7989n(parcel, iM7988m);
            } else if (iM7983h == 3) {
                zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
            } else if (iM7983h != 4) {
                AbstractC1883il.m7994s(parcel, iM7988m);
            } else {
                zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0111CI(strM7979d, iBinderM7989n, zM7984i, zM7984i2);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0111CI[i];
    }
}
