package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C2377tH extends AbstractC0552M {
    public static final Creator<C2377tH> CREATOR = new C1121YH();

    public final boolean f7203l;

    public final String f7204m;

    public final int f7205n;

    public final int f7206o;

    public C2377tH(boolean z, String str, int i, int i2) {
        this.f7203l = z;
        this.f7204m = str;
        this.f7205n = AbstractC1730fJ.m7580a(i) - 1;
        this.f7206o = AbstractC0683Ot.m3443a(i2) - 1;
    }

    public final String m9689d() {
        return this.f7204m;
    }

    public final boolean m9690f() {
        return this.f7203l;
    }

    public final int m9691g() {
        return AbstractC0683Ot.m3443a(this.f7206o);
    }

    public final int m9692h() {
        return AbstractC1730fJ.m7580a(this.f7205n);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8183c(parcel, 1, this.f7203l);
        AbstractC1929jl.m8194n(parcel, 2, this.f7204m, false);
        AbstractC1929jl.m8189i(parcel, 3, this.f7205n);
        AbstractC1929jl.m8189i(parcel, 4, this.f7206o);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
