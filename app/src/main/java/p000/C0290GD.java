package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C0290GD implements Parcelable.Creator {
    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        C1087Xk c1087Xk = null;
        int[] iArrM7977b = null;
        int[] iArrM7977b2 = null;
        boolean zM7984i = false;
        boolean zM7984i2 = false;
        int iM7990o = 0;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 1:
                    c1087Xk = (C1087Xk) AbstractC1883il.m7978c(parcel, iM7988m, C1087Xk.CREATOR);
                    break;
                case 2:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 3:
                    zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 4:
                    iArrM7977b = AbstractC1883il.m7977b(parcel, iM7988m);
                    break;
                case 5:
                    iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 6:
                    iArrM7977b2 = AbstractC1883il.m7977b(parcel, iM7988m);
                    break;
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C1904j6(c1087Xk, zM7984i, zM7984i2, iArrM7977b, iM7990o, iArrM7977b2);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C1904j6[i];
    }
}
