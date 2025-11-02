package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C0635Nr extends AbstractC0552M {
    public static final Creator<C0635Nr> CREATOR = new C0543Lr();

    public final String f1974l;

    public final C0175Dr f1975m;

    public final String f1976n;

    public final long f1977o;

    public C0635Nr(String str, C0175Dr c0175Dr, String str2, long j) {
        this.f1974l = str;
        this.f1975m = c0175Dr;
        this.f1976n = str2;
        this.f1977o = j;
    }

    public final String toString() {
        return "origin=" + this.f1976n + ",name=" + this.f1974l + ",params=" + String.valueOf(this.f1975m);
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 2, this.f1974l, false);
        AbstractC1929jl.m8193m(parcel, 3, this.f1975m, i, false);
        AbstractC1929jl.m8194n(parcel, 4, this.f1976n, false);
        AbstractC1929jl.m8191k(parcel, 5, this.f1977o);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C0635Nr(C0635Nr c0635Nr, long j) {
        AbstractC1085Xi.m4801j(c0635Nr);
        this.f1974l = c0635Nr.f1974l;
        this.f1975m = c0635Nr.f1975m;
        this.f1976n = c0635Nr.f1976n;
        this.f1977o = j;
    }
}
