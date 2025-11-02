package p000;

import android.os.Parcel;
import android.os.Parcelable;
import p000.AbstractC0257Fh;

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

    public String m3314d() {
        return this.f1926l;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C0618Na) {
            C0618Na c0618Na = (C0618Na) obj;
            if (((m3314d() != null && m3314d().equals(c0618Na.m3314d())) || (m3314d() == null && c0618Na.m3314d() == null)) && m3315f() == c0618Na.m3315f()) {
                return true;
            }
        }
        return false;
    }

    public long m3315f() {
        long j = this.f1928n;
        return j == -1 ? this.f1927m : j;
    }

    public final int hashCode() {
        return AbstractC0257Fh.m1256b(m3314d(), Long.valueOf(m3315f()));
    }

    public final String toString() {
        AbstractC0257Fh.a aVarM1257c = AbstractC0257Fh.m1257c(this);
        aVarM1257c.m1258a("name", m3314d());
        aVarM1257c.m1258a("version", Long.valueOf(m3315f()));
        return aVarM1257c.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 1, m3314d(), false);
        AbstractC1929jl.m8189i(parcel, 2, this.f1927m);
        AbstractC1929jl.m8191k(parcel, 3, m3315f());
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
