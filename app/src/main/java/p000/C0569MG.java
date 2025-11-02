package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.List;

public final class C0569MG extends AbstractC0552M {
    public static final Creator<C0569MG> CREATOR = new C0752QF();

    public final boolean f1770A;

    public final String f1771B;

    public final Boolean f1772C;

    public final long f1773D;

    public final List f1774E;

    public final String f1775F;

    public final String f1776G;

    public final String f1777H;

    public final String f1778I;

    public final boolean f1779J;

    public final long f1780K;

    public final int f1781L;

    public final String f1782M;

    public final int f1783N;

    public final long f1784O;

    public final String f1785P;

    public final String f1786Q;

    public final String f1787l;

    public final String f1788m;

    public final String f1789n;

    public final String f1790o;

    public final long f1791p;

    public final long f1792q;

    public final String f1793r;

    public final boolean f1794s;

    public final boolean f1795t;

    public final long f1796u;

    public final String f1797v;

    public final long f1798w;

    public final long f1799x;

    public final int f1800y;

    public final boolean f1801z;

    public C0569MG(String str, String str2, String str3, long j, String str4, long j2, long j3, String str5, boolean z, boolean z2, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11, boolean z5, long j7, int i2, String str12, int i3, long j8, String str13, String str14) {
        AbstractC1085Xi.m4795d(str);
        this.f1787l = str;
        this.f1788m = TextUtils.isEmpty(str2) ? null : str2;
        this.f1789n = str3;
        this.f1796u = j;
        this.f1790o = str4;
        this.f1791p = j2;
        this.f1792q = j3;
        this.f1793r = str5;
        this.f1794s = z;
        this.f1795t = z2;
        this.f1797v = str6;
        this.f1798w = j4;
        this.f1799x = j5;
        this.f1800y = i;
        this.f1801z = z3;
        this.f1770A = z4;
        this.f1771B = str7;
        this.f1772C = bool;
        this.f1773D = j6;
        this.f1774E = list;
        this.f1775F = null;
        this.f1776G = str9;
        this.f1777H = str10;
        this.f1778I = str11;
        this.f1779J = z5;
        this.f1780K = j7;
        this.f1781L = i2;
        this.f1782M = str12;
        this.f1783N = i3;
        this.f1784O = j8;
        this.f1785P = str13;
        this.f1786Q = str14;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 2, this.f1787l, false);
        AbstractC1929jl.m8194n(parcel, 3, this.f1788m, false);
        AbstractC1929jl.m8194n(parcel, 4, this.f1789n, false);
        AbstractC1929jl.m8194n(parcel, 5, this.f1790o, false);
        AbstractC1929jl.m8191k(parcel, 6, this.f1791p);
        AbstractC1929jl.m8191k(parcel, 7, this.f1792q);
        AbstractC1929jl.m8194n(parcel, 8, this.f1793r, false);
        AbstractC1929jl.m8183c(parcel, 9, this.f1794s);
        AbstractC1929jl.m8183c(parcel, 10, this.f1795t);
        AbstractC1929jl.m8191k(parcel, 11, this.f1796u);
        AbstractC1929jl.m8194n(parcel, 12, this.f1797v, false);
        AbstractC1929jl.m8191k(parcel, 13, this.f1798w);
        AbstractC1929jl.m8191k(parcel, 14, this.f1799x);
        AbstractC1929jl.m8189i(parcel, 15, this.f1800y);
        AbstractC1929jl.m8183c(parcel, 16, this.f1801z);
        AbstractC1929jl.m8183c(parcel, 18, this.f1770A);
        AbstractC1929jl.m8194n(parcel, 19, this.f1771B, false);
        AbstractC1929jl.m8184d(parcel, 21, this.f1772C, false);
        AbstractC1929jl.m8191k(parcel, 22, this.f1773D);
        AbstractC1929jl.m8195o(parcel, 23, this.f1774E, false);
        AbstractC1929jl.m8194n(parcel, 24, this.f1775F, false);
        AbstractC1929jl.m8194n(parcel, 25, this.f1776G, false);
        AbstractC1929jl.m8194n(parcel, 26, this.f1777H, false);
        AbstractC1929jl.m8194n(parcel, 27, this.f1778I, false);
        AbstractC1929jl.m8183c(parcel, 28, this.f1779J);
        AbstractC1929jl.m8191k(parcel, 29, this.f1780K);
        AbstractC1929jl.m8189i(parcel, 30, this.f1781L);
        AbstractC1929jl.m8194n(parcel, 31, this.f1782M, false);
        AbstractC1929jl.m8189i(parcel, 32, this.f1783N);
        AbstractC1929jl.m8191k(parcel, 34, this.f1784O);
        AbstractC1929jl.m8194n(parcel, 35, this.f1785P, false);
        AbstractC1929jl.m8194n(parcel, 36, this.f1786Q, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C0569MG(String str, String str2, String str3, String str4, long j, long j2, String str5, boolean z, boolean z2, long j3, String str6, long j4, long j5, int i, boolean z3, boolean z4, String str7, Boolean bool, long j6, List list, String str8, String str9, String str10, String str11, boolean z5, long j7, int i2, String str12, int i3, long j8, String str13, String str14) {
        this.f1787l = str;
        this.f1788m = str2;
        this.f1789n = str3;
        this.f1796u = j3;
        this.f1790o = str4;
        this.f1791p = j;
        this.f1792q = j2;
        this.f1793r = str5;
        this.f1794s = z;
        this.f1795t = z2;
        this.f1797v = str6;
        this.f1798w = j4;
        this.f1799x = j5;
        this.f1800y = i;
        this.f1801z = z3;
        this.f1770A = z4;
        this.f1771B = str7;
        this.f1772C = bool;
        this.f1773D = j6;
        this.f1774E = list;
        this.f1775F = str8;
        this.f1776G = str9;
        this.f1777H = str10;
        this.f1778I = str11;
        this.f1779J = z5;
        this.f1780K = j7;
        this.f1781L = i2;
        this.f1782M = str12;
        this.f1783N = i3;
        this.f1784O = j8;
        this.f1785P = str13;
        this.f1786Q = str14;
    }
}
