package p000;

import android.os.Parcel;

public final class C0635Nr extends AbstractC0552M {
    public static final Creator<C0635Nr> CREATOR = new C0543Lr();

    public final String name;

    public final C0175Dr params;

    public final String origin;

    public final long f1977o;

    public C0635Nr(String str, C0175Dr c0175Dr, String str2, long j) {
        this.name = str;
        this.params = c0175Dr;
        this.origin = str2;
        this.f1977o = j;
    }

    public final String toString() {
        return "origin=" + this.origin + ",name=" + this.name + ",params=" + this.params;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 2, this.name, false);
        AbstractC1929jl.m8193m(parcel, 3, this.params, i, false);
        AbstractC1929jl.m8194n(parcel, 4, this.origin, false);
        AbstractC1929jl.m8191k(parcel, 5, this.f1977o);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C0635Nr(C0635Nr c0635Nr, long j) {
        AbstractC1085Xi.m4801j(c0635Nr);
        this.name = c0635Nr.name;
        this.params = c0635Nr.params;
        this.origin = c0635Nr.origin;
        this.f1977o = j;
    }
}
