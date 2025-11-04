package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C1913jF extends AbstractC0552M {
    public static final Creator<C1913jF> CREATOR = new C2191pF();

    public final String f5937l;

    public final long f5938m;

    public final int f5939n;

    public C1913jF(String str, long j, int i) {
        this.f5937l = str;
        this.f5938m = j;
        this.f5939n = i;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 1, this.f5937l, false);
        AbstractC1929jl.m8191k(parcel, 2, this.f5938m);
        AbstractC1929jl.m8189i(parcel, 3, this.f5939n);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
