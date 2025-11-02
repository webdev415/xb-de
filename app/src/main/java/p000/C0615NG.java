package p000;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0615NG implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        boolean zM7984i = false;
        boolean zM7984i2 = false;
        boolean zM7984i3 = false;
        boolean zM7984i4 = false;
        String strM7979d = null;
        IBinder iBinderM7989n = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 1:
                    strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 2:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 3:
                    zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 4:
                    iBinderM7989n = AbstractC1883il.m7989n(parcel, iM7988m);
                    break;
                case 5:
                    zM7984i3 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 6:
                    zM7984i4 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0797RF(strM7979d, zM7984i, zM7984i2, iBinderM7989n, zM7984i3, zM7984i4);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0797RF[i];
    }
}
