package p000;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;

public final class C0481Kb implements Parcelable {
    public static final Creator<C0481Kb> CREATOR = new a();

    public ArrayList f1567l;

    public ArrayList f1568m;

    public C1666e2[] f1569n;

    public String f1570o;

    public int f1571p;

    public static class a implements Creator {
        @Override
        public C0481Kb createFromParcel(Parcel parcel) {
            return new C0481Kb(parcel);
        }

        @Override
        public C0481Kb[] newArray(int i) {
            return new C0481Kb[i];
        }
    }

    public C0481Kb(Parcel parcel) {
        this.f1570o = null;
        this.f1567l = parcel.createTypedArrayList(FragmentState.CREATOR);
        this.f1568m = parcel.createStringArrayList();
        this.f1569n = (C1666e2[]) parcel.createTypedArray(C1666e2.CREATOR);
        this.f1570o = parcel.readString();
        this.f1571p = parcel.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f1567l);
        parcel.writeStringList(this.f1568m);
        parcel.writeTypedArray(this.f1569n, i);
        parcel.writeString(this.f1570o);
        parcel.writeInt(this.f1571p);
    }
}
