package p000;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class C2053mG extends AbstractC0552M {
    public static final Creator<C2053mG> CREATOR = new C2330sG();

    public final int f6157l;

    public final String f6158m;

    public final long f6159n;

    public final Long f6160o;

    public final String f6161p;

    public final String f6162q;

    public final Double f6163r;

    public C2053mG(int i, String str, long j, Long l, Float f, String str2, String str3, Double d) {
        this.f6157l = i;
        this.f6158m = str;
        this.f6159n = j;
        this.f6160o = l;
        if (i == 1) {
            this.f6163r = f != null ? Double.valueOf(f.doubleValue()) : null;
        } else {
            this.f6163r = d;
        }
        this.f6161p = str2;
        this.f6162q = str3;
    }

    public final Object m8448d() {
        Long l = this.f6160o;
        if (l != null) {
            return l;
        }
        Double d = this.f6163r;
        if (d != null) {
            return d;
        }
        String str = this.f6161p;
        if (str != null) {
            return str;
        }
        return null;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8189i(parcel, 1, this.f6157l);
        AbstractC1929jl.m8194n(parcel, 2, this.f6158m, false);
        AbstractC1929jl.m8191k(parcel, 3, this.f6159n);
        AbstractC1929jl.m8192l(parcel, 4, this.f6160o, false);
        AbstractC1929jl.m8187g(parcel, 5, null, false);
        AbstractC1929jl.m8194n(parcel, 6, this.f6161p, false);
        AbstractC1929jl.m8194n(parcel, 7, this.f6162q, false);
        AbstractC1929jl.m8186f(parcel, 8, this.f6163r, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C2053mG(String str, long j, Object obj, String str2) {
        AbstractC1085Xi.m4795d(str);
        this.f6157l = 2;
        this.f6158m = str;
        this.f6159n = j;
        this.f6162q = str2;
        if (obj == null) {
            this.f6160o = null;
            this.f6163r = null;
            this.f6161p = null;
            return;
        }
        if (obj instanceof Long) {
            this.f6160o = (Long) obj;
            this.f6163r = null;
            this.f6161p = null;
        } else if (obj instanceof String) {
            this.f6160o = null;
            this.f6163r = null;
            this.f6161p = (String) obj;
        } else {
            if (!(obj instanceof Double)) {
                throw new IllegalArgumentException("User attribute given of un-supported type");
            }
            this.f6160o = null;
            this.f6163r = (Double) obj;
            this.f6161p = null;
        }
    }

    public C2053mG(C2238qG c2238qG) {
        this(c2238qG.f6718c, c2238qG.f6719d, c2238qG.f6720e, c2238qG.f6717b);
    }
}
