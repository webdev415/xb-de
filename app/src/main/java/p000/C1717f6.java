package p000;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import p000.AbstractC0257Fh;

/* loaded from: classes.dex */
public final class C1717f6 extends AbstractC0552M {

    public final int f5481l;

    public final int f5482m;

    public final PendingIntent f5483n;

    public final String f5484o;

    public static final C1717f6 f5480p = new C1717f6(0);
    public static final Creator<C1717f6> CREATOR = new C2212pr();

    public C1717f6(int i) {
        this(i, null, null);
    }

    public static String m7547i(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case 0:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case 4:
                return "SIGN_IN_REQUIRED";
            case 5:
                return "INVALID_ACCOUNT";
            case 6:
                return "RESOLUTION_REQUIRED";
            case 7:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return "UNKNOWN_ERROR_CODE(" + i + ")";
                }
        }
    }

    public int m7548d() {
        return this.f5482m;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1717f6)) {
            return false;
        }
        C1717f6 c1717f6 = (C1717f6) obj;
        return this.f5482m == c1717f6.f5482m && AbstractC0257Fh.m1255a(this.f5483n, c1717f6.f5483n) && AbstractC0257Fh.m1255a(this.f5484o, c1717f6.f5484o);
    }

    public String m7549f() {
        return this.f5484o;
    }

    public PendingIntent m7550g() {
        return this.f5483n;
    }

    public boolean m7551h() {
        return this.f5482m == 0;
    }

    public int hashCode() {
        return AbstractC0257Fh.m1256b(Integer.valueOf(this.f5482m), this.f5483n, this.f5484o);
    }

    public String toString() {
        AbstractC0257Fh.a aVarM1257c = AbstractC0257Fh.m1257c(this);
        aVarM1257c.m1258a("statusCode", m7547i(this.f5482m));
        aVarM1257c.m1258a("resolution", this.f5483n);
        aVarM1257c.m1258a("message", this.f5484o);
        return aVarM1257c.toString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        int i2 = this.f5481l;
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8189i(parcel, 1, i2);
        AbstractC1929jl.m8189i(parcel, 2, m7548d());
        AbstractC1929jl.m8193m(parcel, 3, m7550g(), i, false);
        AbstractC1929jl.m8194n(parcel, 4, m7549f(), false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C1717f6(int i, int i2, PendingIntent pendingIntent, String str) {
        this.f5481l = i;
        this.f5482m = i2;
        this.f5483n = pendingIntent;
        this.f5484o = str;
    }

    public C1717f6(int i, PendingIntent pendingIntent) {
        this(i, pendingIntent, null);
    }

    public C1717f6(int i, PendingIntent pendingIntent, String str) {
        this(1, i, pendingIntent, str);
    }
}
