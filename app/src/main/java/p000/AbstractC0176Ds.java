package p000;

import android.os.BadParcelableException;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class AbstractC0176Ds {

    public static final ClassLoader f436a = AbstractC0176Ds.class.getClassLoader();

    public static Parcelable m789a(Parcel parcel, Parcelable.Creator creator) {
        if (parcel.readInt() == 0) {
            return null;
        }
        return (Parcelable) creator.createFromParcel(parcel);
    }

    public static void m790b(Parcel parcel) {
        int iDataAvail = parcel.dataAvail();
        if (iDataAvail <= 0) {
            return;
        }
        throw new BadParcelableException("Parcel data not fully consumed, unread size: " + iDataAvail);
    }

    public static void m791c(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcelable.writeToParcel(parcel, 0);
        }
    }

    public static void m792d(Parcel parcel, IInterface iInterface) {
        parcel.writeStrongBinder(iInterface == null ? null : iInterface.asBinder());
    }

    public static boolean m793e(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
