package p000;

import android.os.Parcel;

/* loaded from: classes.dex */
public abstract class AbstractC0130Cs {

    public static final ClassLoader f322a = AbstractC0130Cs.class.getClassLoader();

    public static void m528a(Parcel parcel, boolean z) {
        parcel.writeInt(1);
    }

    public static boolean m529b(Parcel parcel) {
        return parcel.readInt() != 0;
    }
}
