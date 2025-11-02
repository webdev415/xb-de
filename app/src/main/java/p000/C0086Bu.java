package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0086Bu extends AbstractC0552M {
    public static final Creator<C0086Bu> CREATOR = new C0362Hu();

    public final long f216l;

    public final long f217m;

    public final boolean f218n;

    public final String f219o;

    public final String f220p;

    public final String f221q;

    public final Bundle f222r;

    public final String f223s;

    public C0086Bu(long j, long j2, boolean z, String str, String str2, String str3, Bundle bundle, String str4) {
        this.f216l = j;
        this.f217m = j2;
        this.f218n = z;
        this.f219o = str;
        this.f220p = str2;
        this.f221q = str3;
        this.f222r = bundle;
        this.f223s = str4;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8191k(parcel, 1, this.f216l);
        AbstractC1929jl.m8191k(parcel, 2, this.f217m);
        AbstractC1929jl.m8183c(parcel, 3, this.f218n);
        AbstractC1929jl.m8194n(parcel, 4, this.f219o, false);
        AbstractC1929jl.m8194n(parcel, 5, this.f220p, false);
        AbstractC1929jl.m8194n(parcel, 6, this.f221q, false);
        AbstractC1929jl.m8185e(parcel, 7, this.f222r, false);
        AbstractC1929jl.m8194n(parcel, 8, this.f223s, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
