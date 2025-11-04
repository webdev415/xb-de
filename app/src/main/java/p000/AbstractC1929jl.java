package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

public abstract class AbstractC1929jl {
    public static int m8181a(Parcel parcel) {
        return m8197q(parcel, 20293);
    }

    public static void m8182b(Parcel parcel, int i) {
        m8198r(parcel, i);
    }

    public static void m8183c(Parcel parcel, int i, boolean z) {
        m8199s(parcel, i, 4);
        parcel.writeInt(z ? 1 : 0);
    }

    public static void m8184d(Parcel parcel, int i, Boolean bool, boolean z) {
        if (bool != null) {
            m8199s(parcel, i, 4);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        } else if (z) {
            m8199s(parcel, i, 0);
        }
    }

    public static void m8185e(Parcel parcel, int i, Bundle bundle, boolean z) {
        if (bundle == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcel.writeBundle(bundle);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8186f(Parcel parcel, int i, Double d, boolean z) {
        if (d != null) {
            m8199s(parcel, i, 8);
            parcel.writeDouble(d.doubleValue());
        } else if (z) {
            m8199s(parcel, i, 0);
        }
    }

    public static void m8187g(Parcel parcel, int i, Float f, boolean z) {
        if (f != null) {
            m8199s(parcel, i, 4);
            parcel.writeFloat(f.floatValue());
        } else if (z) {
            m8199s(parcel, i, 0);
        }
    }

    public static void m8188h(Parcel parcel, int i, IBinder iBinder, boolean z) {
        if (iBinder == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcel.writeStrongBinder(iBinder);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8189i(Parcel parcel, int i, int i2) {
        m8199s(parcel, i, 4);
        parcel.writeInt(i2);
    }

    public static void m8190j(Parcel parcel, int i, int[] iArr, boolean z) {
        if (iArr == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcel.writeIntArray(iArr);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8191k(Parcel parcel, int i, long j) {
        m8199s(parcel, i, 8);
        parcel.writeLong(j);
    }

    public static void m8192l(Parcel parcel, int i, Long l, boolean z) {
        if (l != null) {
            m8199s(parcel, i, 8);
            parcel.writeLong(l.longValue());
        } else if (z) {
            m8199s(parcel, i, 0);
        }
    }

    public static void m8193m(Parcel parcel, int i, Parcelable parcelable, int i2, boolean z) {
        if (parcelable == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcelable.writeToParcel(parcel, i2);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8194n(Parcel parcel, int i, String str, boolean z) {
        if (str == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcel.writeString(str);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8195o(Parcel parcel, int i, List list, boolean z) {
        if (list == null) {
            if (z) {
                m8199s(parcel, i, 0);
            }
        } else {
            int iM8197q = m8197q(parcel, i);
            parcel.writeStringList(list);
            m8198r(parcel, iM8197q);
        }
    }

    public static void m8196p(Parcel parcel, int i, Parcelable[] parcelableArr, int i2, boolean z) {
        if (parcelableArr == null) {
            if (z) {
                m8199s(parcel, i, 0);
                return;
            }
            return;
        }
        int iM8197q = m8197q(parcel, i);
        parcel.writeInt(parcelableArr.length);
        for (Parcelable parcelable : parcelableArr) {
            if (parcelable == null) {
                parcel.writeInt(0);
            } else {
                m8200t(parcel, parcelable, i2);
            }
        }
        m8198r(parcel, iM8197q);
    }

    public static int m8197q(Parcel parcel, int i) {
        parcel.writeInt(i | (-65536));
        parcel.writeInt(0);
        return parcel.dataPosition();
    }

    public static void m8198r(Parcel parcel, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.setDataPosition(i - 4);
        parcel.writeInt(iDataPosition - i);
        parcel.setDataPosition(iDataPosition);
    }

    public static void m8199s(Parcel parcel, int i, int i2) {
        parcel.writeInt(i | (i2 << 16));
    }

    public static void m8200t(Parcel parcel, Parcelable parcelable, int i) {
        int iDataPosition = parcel.dataPosition();
        parcel.writeInt(1);
        int iDataPosition2 = parcel.dataPosition();
        parcelable.writeToParcel(parcel, i);
        int iDataPosition3 = parcel.dataPosition();
        parcel.setDataPosition(iDataPosition);
        parcel.writeInt(iDataPosition3 - iDataPosition2);
        parcel.setDataPosition(iDataPosition3);
    }
}
