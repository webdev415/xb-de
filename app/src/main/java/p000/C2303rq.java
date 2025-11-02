package p000;

import android.os.Parcel;
import android.os.Parcelable;

public final class C2303rq extends AbstractC0552M {
    public static final Creator<C2303rq> CREATOR = new C2118nq();

    public String f6976l;

    public String f6977m;

    public C2053mG f6978n;

    public long f6979o;

    public boolean f6980p;

    public String f6981q;

    public C0635Nr f6982r;

    public long f6983s;

    public C0635Nr f6984t;

    public long f6985u;

    public C0635Nr f6986v;

    public C2303rq(String str, String str2, C2053mG c2053mG, long j, boolean z, String str3, C0635Nr c0635Nr, long j2, C0635Nr c0635Nr2, long j3, C0635Nr c0635Nr3) {
        this.f6976l = str;
        this.f6977m = str2;
        this.f6978n = c2053mG;
        this.f6979o = j;
        this.f6980p = z;
        this.f6981q = str3;
        this.f6982r = c0635Nr;
        this.f6983s = j2;
        this.f6984t = c0635Nr2;
        this.f6985u = j3;
        this.f6986v = c0635Nr3;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 2, this.f6976l, false);
        AbstractC1929jl.m8194n(parcel, 3, this.f6977m, false);
        AbstractC1929jl.m8193m(parcel, 4, this.f6978n, i, false);
        AbstractC1929jl.m8191k(parcel, 5, this.f6979o);
        AbstractC1929jl.m8183c(parcel, 6, this.f6980p);
        AbstractC1929jl.m8194n(parcel, 7, this.f6981q, false);
        AbstractC1929jl.m8193m(parcel, 8, this.f6982r, i, false);
        AbstractC1929jl.m8191k(parcel, 9, this.f6983s);
        AbstractC1929jl.m8193m(parcel, 10, this.f6984t, i, false);
        AbstractC1929jl.m8191k(parcel, 11, this.f6985u);
        AbstractC1929jl.m8193m(parcel, 12, this.f6986v, i, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C2303rq(C2303rq c2303rq) {
        AbstractC1085Xi.m4801j(c2303rq);
        this.f6976l = c2303rq.f6976l;
        this.f6977m = c2303rq.f6977m;
        this.f6978n = c2303rq.f6978n;
        this.f6979o = c2303rq.f6979o;
        this.f6980p = c2303rq.f6980p;
        this.f6981q = c2303rq.f6981q;
        this.f6982r = c2303rq.f6982r;
        this.f6983s = c2303rq.f6983s;
        this.f6984t = c2303rq.f6984t;
        this.f6985u = c2303rq.f6985u;
        this.f6986v = c2303rq.f6986v;
    }
}
