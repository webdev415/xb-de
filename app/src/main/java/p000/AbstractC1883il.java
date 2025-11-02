package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AbstractC1883il {

    public static class a extends RuntimeException {
        public a(String str, Parcel parcel) {
            super(str + " Parcel: pos=" + parcel.dataPosition() + " size=" + parcel.dataSize());
        }
    }

    public static Bundle m7976a(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        Bundle bundle = parcel.readBundle();
        parcel.setDataPosition(iDataPosition + iM7993r);
        return bundle;
    }

    public static int[] m7977b(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        int[] iArrCreateIntArray = parcel.createIntArray();
        parcel.setDataPosition(iDataPosition + iM7993r);
        return iArrCreateIntArray;
    }

    public static Parcelable m7978c(Parcel parcel, int i, Parcelable.Creator creator) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        Parcelable parcelable = (Parcelable) creator.createFromParcel(parcel);
        parcel.setDataPosition(iDataPosition + iM7993r);
        return parcelable;
    }

    public static String m7979d(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        String string = parcel.readString();
        parcel.setDataPosition(iDataPosition + iM7993r);
        return string;
    }

    public static ArrayList m7980e(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        ArrayList<String> arrayListCreateStringArrayList = parcel.createStringArrayList();
        parcel.setDataPosition(iDataPosition + iM7993r);
        return arrayListCreateStringArrayList;
    }

    public static Object[] m7981f(Parcel parcel, int i, Parcelable.Creator creator) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        Object[] objArrCreateTypedArray = parcel.createTypedArray(creator);
        parcel.setDataPosition(iDataPosition + iM7993r);
        return objArrCreateTypedArray;
    }

    public static void m7982g(Parcel parcel, int i) {
        if (parcel.dataPosition() == i) {
            return;
        }
        throw new a("Overread allowed size end=" + i, parcel);
    }

    public static int m7983h(int i) {
        return (char) i;
    }

    public static boolean m7984i(Parcel parcel, int i) {
        m7997v(parcel, i, 4);
        return parcel.readInt() != 0;
    }

    public static Boolean m7985j(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        if (iM7993r == 0) {
            return null;
        }
        m7996u(parcel, i, iM7993r, 4);
        return Boolean.valueOf(parcel.readInt() != 0);
    }

    public static Double m7986k(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        if (iM7993r == 0) {
            return null;
        }
        m7996u(parcel, i, iM7993r, 8);
        return Double.valueOf(parcel.readDouble());
    }

    public static Float m7987l(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        if (iM7993r == 0) {
            return null;
        }
        m7996u(parcel, i, iM7993r, 4);
        return Float.valueOf(parcel.readFloat());
    }

    public static int m7988m(Parcel parcel) {
        return parcel.readInt();
    }

    public static IBinder m7989n(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        int iDataPosition = parcel.dataPosition();
        if (iM7993r == 0) {
            return null;
        }
        IBinder strongBinder = parcel.readStrongBinder();
        parcel.setDataPosition(iDataPosition + iM7993r);
        return strongBinder;
    }

    public static int m7990o(Parcel parcel, int i) {
        m7997v(parcel, i, 4);
        return parcel.readInt();
    }

    public static long m7991p(Parcel parcel, int i) {
        m7997v(parcel, i, 8);
        return parcel.readLong();
    }

    public static Long m7992q(Parcel parcel, int i) {
        int iM7993r = m7993r(parcel, i);
        if (iM7993r == 0) {
            return null;
        }
        m7996u(parcel, i, iM7993r, 8);
        return Long.valueOf(parcel.readLong());
    }

    public static int m7993r(Parcel parcel, int i) {
        return (i & (-65536)) != -65536 ? (char) (i >> 16) : parcel.readInt();
    }

    public static void m7994s(Parcel parcel, int i) {
        parcel.setDataPosition(parcel.dataPosition() + m7993r(parcel, i));
    }

    public static int m7995t(Parcel parcel) {
        int iM7988m = m7988m(parcel);
        int iM7993r = m7993r(parcel, iM7988m);
        int iM7983h = m7983h(iM7988m);
        int iDataPosition = parcel.dataPosition();
        if (iM7983h != 20293) {
            throw new a("Expected object header. Got 0x".concat(String.valueOf(Integer.toHexString(iM7988m))), parcel);
        }
        int i = iM7993r + iDataPosition;
        if (i >= iDataPosition && i <= parcel.dataSize()) {
            return i;
        }
        throw new a("Size read is invalid start=" + iDataPosition + " end=" + i, parcel);
    }

    public static void m7996u(Parcel parcel, int i, int i2, int i3) {
        if (i2 == i3) {
            return;
        }
        throw new a("Expected size " + i3 + " got " + i2 + " (0x" + Integer.toHexString(i2) + ")", parcel);
    }

    public static void m7997v(Parcel parcel, int i, int i2) {
        int iM7993r = m7993r(parcel, i);
        if (iM7993r == i2) {
            return;
        }
        throw new a("Expected size " + i2 + " got " + iM7993r + " (0x" + Integer.toHexString(iM7993r) + ")", parcel);
    }
}
