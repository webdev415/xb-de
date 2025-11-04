package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0242FB extends AbstractC0552M {
    public static final Creator<C0242FB> CREATOR = new C0289GC();

    public Bundle f651l;

    public C0618Na[] f652m;

    public int f653n;

    public C1904j6 f654o;

    public C0242FB(Bundle bundle, C0618Na[] c0618NaArr, int i, C1904j6 c1904j6) {
        this.f651l = bundle;
        this.f652m = c0618NaArr;
        this.f653n = i;
        this.f654o = c1904j6;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8185e(parcel, 1, this.f651l, false);
        AbstractC1929jl.m8196p(parcel, 2, this.f652m, i, false);
        AbstractC1929jl.m8189i(parcel, 3, this.f653n);
        AbstractC1929jl.m8193m(parcel, 4, this.f654o, i, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
