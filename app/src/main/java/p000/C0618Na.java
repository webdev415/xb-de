package p000;

import android.os.Parcel;

public class C0618Na extends AbstractC0552M {
    public static final Creator<C0618Na> CREATOR = new C2673zs();

    public final String f1926l;

    public final int f1927m;

    public final long f1928n;

    public C0618Na(String str, int i, long j) {
        this.f1926l = str;
        this.f1927m = i;
        this.f1928n = j;
    }

    public String getName() {
        return this.f1926l;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0618Na) {
            C0618Na c0618Na = (C0618Na) obj;
            if (((getName() != null && getName().equals(c0618Na.getName())) || (getName() == null && c0618Na.getName() == null)) && getVersion() == c0618Na.getVersion()) {
                return true;
            }
        }
        return false;
    }

    public long getVersion() {
        long j = this.f1928n;
        return j == -1 ? this.f1927m : j;
    }

    public final int hashCode() {
        return AbstractC0257Fh.m1256b(getName(), Long.valueOf(getVersion()));
    }

    public final String toString() {
        AbstractC0257Fh.a aVarM1257c = AbstractC0257Fh.m1257c(this);
        aVarM1257c.m1258a("name", getName());
        aVarM1257c.m1258a("version", getVersion());
        return aVarM1257c.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 1, getName(), false);
        AbstractC1929jl.m8189i(parcel, 2, this.f1927m);
        AbstractC1929jl.m8191k(parcel, 3, getVersion());
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
