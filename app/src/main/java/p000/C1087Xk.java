package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class C1087Xk extends AbstractC0552M {
    public static final Creator<C1087Xk> CREATOR = new C0266Fq();

    public final int f3255l;

    public final boolean f3256m;

    public final boolean f3257n;

    public final int f3258o;

    public final int f3259p;

    public C1087Xk(int i, boolean z, boolean z2, int i2, int i3) {
        this.f3255l = i;
        this.f3256m = z;
        this.f3257n = z2;
        this.f3258o = i2;
        this.f3259p = i3;
    }

    public int m4807d() {
        return this.f3258o;
    }

    public int m4808f() {
        return this.f3259p;
    }

    public boolean m4809g() {
        return this.f3256m;
    }

    public boolean m4810h() {
        return this.f3257n;
    }

    public int m4811i() {
        return this.f3255l;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8189i(parcel, 1, m4811i());
        AbstractC1929jl.m8183c(parcel, 2, m4809g());
        AbstractC1929jl.m8183c(parcel, 3, m4810h());
        AbstractC1929jl.m8189i(parcel, 4, m4807d());
        AbstractC1929jl.m8189i(parcel, 5, m4808f());
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
