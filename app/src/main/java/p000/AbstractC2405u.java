package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public abstract class AbstractC2405u implements Parcelable {

    public final Parcelable f7339l;

    public static final AbstractC2405u f7338m = new a();
    public static final Creator<AbstractC2405u> CREATOR = new b();

    public static class a extends AbstractC2405u {
        public a() {
            super((a) null);
        }
    }

    public static class b implements ClassLoaderCreator {
        @Override
        public AbstractC2405u createFromParcel(Parcel parcel) {
            return createFromParcel(parcel, null);
        }

        @Override
        public AbstractC2405u createFromParcel(Parcel parcel, ClassLoader classLoader) {
            if (parcel.readParcelable(classLoader) == null) {
                return AbstractC2405u.f7338m;
            }
            throw new IllegalStateException("superState must be null");
        }

        @Override
        public AbstractC2405u[] newArray(int i) {
            return new AbstractC2405u[i];
        }
    }

    public AbstractC2405u() {
        this.f7339l = null;
    }

    public final Parcelable m9878a() {
        return this.f7339l;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7339l, i);
    }

    public AbstractC2405u(a aVar) {
        this();
    }

    public AbstractC2405u(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.f7339l = parcelable == null ? f7338m : parcelable;
    }

    public AbstractC2405u(Parcelable parcelable) {
        if (parcelable == null) {
            throw new IllegalArgumentException("superState must not be null");
        }
        this.f7339l = parcelable == f7338m ? null : parcelable;
    }
}
