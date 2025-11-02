package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C2118nq implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        String strM7979d = null;
        String strM7979d2 = null;
        C2053mG c2053mG = null;
        String strM7979d3 = null;
        C0635Nr c0635Nr = null;
        C0635Nr c0635Nr2 = null;
        C0635Nr c0635Nr3 = null;
        long jM7991p = 0;
        long jM7991p2 = 0;
        long jM7991p3 = 0;
        boolean zM7984i = false;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 2:
                    strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 3:
                    strM7979d2 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 4:
                    c2053mG = (C2053mG) AbstractC1883il.m7978c(parcel, iM7988m, C2053mG.CREATOR);
                    break;
                case 5:
                    jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 6:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 7:
                    strM7979d3 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 8:
                    c0635Nr = (C0635Nr) AbstractC1883il.m7978c(parcel, iM7988m, C0635Nr.CREATOR);
                    break;
                case 9:
                    jM7991p2 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 10:
                    c0635Nr2 = (C0635Nr) AbstractC1883il.m7978c(parcel, iM7988m, C0635Nr.CREATOR);
                    break;
                case 11:
                    jM7991p3 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 12:
                    c0635Nr3 = (C0635Nr) AbstractC1883il.m7978c(parcel, iM7988m, C0635Nr.CREATOR);
                    break;
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C2303rq(strM7979d, strM7979d2, c2053mG, jM7991p, zM7984i, strM7979d3, c0635Nr, jM7991p2, c0635Nr2, jM7991p3, c0635Nr3);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C2303rq[i];
    }
}
