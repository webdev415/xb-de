package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0362Hu implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        long jM7991p = 0;
        long jM7991p2 = 0;
        boolean zM7984i = false;
        String strM7979d = null;
        String strM7979d2 = null;
        String strM7979d3 = null;
        Bundle bundleM7976a = null;
        String strM7979d4 = null;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 1:
                    jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 2:
                    jM7991p2 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 3:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 4:
                    strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 5:
                    strM7979d2 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 6:
                    strM7979d3 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 7:
                    bundleM7976a = AbstractC1883il.m7976a(parcel, iM7988m);
                    break;
                case 8:
                    strM7979d4 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0086Bu(jM7991p, jM7991p2, zM7984i, strM7979d, strM7979d2, strM7979d3, bundleM7976a, strM7979d4);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0086Bu[i];
    }
}
