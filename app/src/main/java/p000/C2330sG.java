package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C2330sG implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        int iM7990o = 0;
        String strM7979d = null;
        Long lM7992q = null;
        Float fM7987l = null;
        String strM7979d2 = null;
        String strM7979d3 = null;
        Double dM7986k = null;
        long jM7991p = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 1:
                    iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 2:
                    strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 3:
                    jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 4:
                    lM7992q = AbstractC1883il.m7992q(parcel, iM7988m);
                    break;
                case 5:
                    fM7987l = AbstractC1883il.m7987l(parcel, iM7988m);
                    break;
                case 6:
                    strM7979d2 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 7:
                    strM7979d3 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 8:
                    dM7986k = AbstractC1883il.m7986k(parcel, iM7988m);
                    break;
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C2053mG(iM7990o, strM7979d, jM7991p, lM7992q, fM7987l, strM7979d2, strM7979d3, dM7986k);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C2053mG[i];
    }
}
