package p000;

import android.os.Parcel;
import android.os.Parcelable;

public class C1904j6 extends AbstractC0552M {
    public static final Creator<C1904j6> CREATOR = new C0290GD();

    public final C1087Xk f5897l;

    public final boolean f5898m;

    public final boolean f5899n;

    public final int[] f5900o;

    public final int f5901p;

    public final int[] f5902q;

    public C1904j6(C1087Xk c1087Xk, boolean z, boolean z2, int[] iArr, int i, int[] iArr2) {
        this.f5897l = c1087Xk;
        this.f5898m = z;
        this.f5899n = z2;
        this.f5900o = iArr;
        this.f5901p = i;
        this.f5902q = iArr2;
    }

    public int m8099d() {
        return this.f5901p;
    }

    public int[] m8100f() {
        return this.f5900o;
    }

    public int[] m8101g() {
        return this.f5902q;
    }

    public boolean m8102h() {
        return this.f5898m;
    }

    public boolean m8103i() {
        return this.f5899n;
    }

    public final C1087Xk m8104k() {
        return this.f5897l;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8193m(parcel, 1, this.f5897l, i, false);
        AbstractC1929jl.m8183c(parcel, 2, m8102h());
        AbstractC1929jl.m8183c(parcel, 3, m8103i());
        AbstractC1929jl.m8190j(parcel, 4, m8100f(), false);
        AbstractC1929jl.m8189i(parcel, 5, m8099d());
        AbstractC1929jl.m8190j(parcel, 6, m8101g(), false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
