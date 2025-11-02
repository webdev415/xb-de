package p000;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class C0752QF implements Parcelable.Creator {
    @Override
    public final Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        String strM7979d = null;
        String strM7979d2 = null;
        String strM7979d3 = null;
        String strM7979d4 = null;
        String strM7979d5 = null;
        String strM7979d6 = null;
        String strM7979d7 = null;
        Boolean boolM7985j = null;
        ArrayList arrayListM7980e = null;
        String strM7979d8 = null;
        String strM7979d9 = null;
        String strM7979d10 = null;
        long jM7991p = 0;
        long jM7991p2 = 0;
        long jM7991p3 = 0;
        long jM7991p4 = 0;
        long jM7991p5 = 0;
        long jM7991p6 = 0;
        long jM7991p7 = 0;
        boolean zM7984i = true;
        boolean zM7984i2 = true;
        boolean zM7984i3 = false;
        int iM7990o = 0;
        boolean zM7984i4 = false;
        boolean zM7984i5 = false;
        int iM7990o2 = 0;
        long jM7991p8 = -2147483648L;
        String strM7979d11 = "";
        String strM7979d12 = strM7979d11;
        String strM7979d13 = strM7979d12;
        String strM7979d14 = strM7979d13;
        int iM7990o3 = 100;
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
                    strM7979d3 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 5:
                    strM7979d4 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 6:
                    jM7991p = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 7:
                    jM7991p2 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 8:
                    strM7979d5 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 9:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 10:
                    zM7984i3 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 11:
                    jM7991p8 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 12:
                    strM7979d6 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 13:
                    jM7991p3 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 14:
                    jM7991p4 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 15:
                    iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 16:
                    zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 17:
                case 20:
                case 33:
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
                case 18:
                    zM7984i4 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 19:
                    strM7979d7 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 21:
                    boolM7985j = AbstractC1883il.m7985j(parcel, iM7988m);
                    break;
                case 22:
                    jM7991p5 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 23:
                    arrayListM7980e = AbstractC1883il.m7980e(parcel, iM7988m);
                    break;
                case 24:
                    strM7979d8 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 25:
                    strM7979d11 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 26:
                    strM7979d12 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 27:
                    strM7979d9 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 28:
                    zM7984i5 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 29:
                    jM7991p6 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 30:
                    iM7990o3 = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 31:
                    strM7979d13 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 32:
                    iM7990o2 = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 34:
                    jM7991p7 = AbstractC1883il.m7991p(parcel, iM7988m);
                    break;
                case 35:
                    strM7979d10 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 36:
                    strM7979d14 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0569MG(strM7979d, strM7979d2, strM7979d3, strM7979d4, jM7991p, jM7991p2, strM7979d5, zM7984i, zM7984i3, jM7991p8, strM7979d6, jM7991p3, jM7991p4, iM7990o, zM7984i2, zM7984i4, strM7979d7, boolM7985j, jM7991p5, arrayListM7980e, strM7979d8, strM7979d11, strM7979d12, strM7979d9, zM7984i5, jM7991p6, iM7990o3, strM7979d13, iM7990o2, jM7991p7, strM7979d10, strM7979d14);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0569MG[i];
    }
}
