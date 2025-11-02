package p000;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;

/* loaded from: classes.dex */
public final class C0475KE implements Parcelable.Creator {
    public static void m2318a(C0114Cc c0114Cc, Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8189i(parcel, 1, c0114Cc.f263l);
        AbstractC1929jl.m8189i(parcel, 2, c0114Cc.f264m);
        AbstractC1929jl.m8189i(parcel, 3, c0114Cc.f265n);
        AbstractC1929jl.m8194n(parcel, 4, c0114Cc.f266o, false);
        AbstractC1929jl.m8188h(parcel, 5, c0114Cc.f267p, false);
        AbstractC1929jl.m8196p(parcel, 6, c0114Cc.f268q, i, false);
        AbstractC1929jl.m8185e(parcel, 7, c0114Cc.f269r, false);
        AbstractC1929jl.m8193m(parcel, 8, c0114Cc.f270s, i, false);
        AbstractC1929jl.m8196p(parcel, 10, c0114Cc.f271t, i, false);
        AbstractC1929jl.m8196p(parcel, 11, c0114Cc.f272u, i, false);
        AbstractC1929jl.m8183c(parcel, 12, c0114Cc.f273v);
        AbstractC1929jl.m8189i(parcel, 13, c0114Cc.f274w);
        AbstractC1929jl.m8183c(parcel, 14, c0114Cc.f275x);
        AbstractC1929jl.m8194n(parcel, 15, c0114Cc.m442d(), false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    @Override
    public final /* bridge */ Object createFromParcel(Parcel parcel) {
        int iM7995t = AbstractC1883il.m7995t(parcel);
        Scope[] scopeArr = C0114Cc.f262z;
        Bundle bundle = new Bundle();
        C0618Na[] c0618NaArr = C0114Cc.f261A;
        C0618Na[] c0618NaArr2 = c0618NaArr;
        String strM7979d = null;
        IBinder iBinderM7989n = null;
        Account account = null;
        String strM7979d2 = null;
        int iM7990o = 0;
        int iM7990o2 = 0;
        int iM7990o3 = 0;
        boolean zM7984i = false;
        int iM7990o4 = 0;
        boolean zM7984i2 = false;
        while (parcel.dataPosition() < iM7995t) {
            int iM7988m = AbstractC1883il.m7988m(parcel);
            switch (AbstractC1883il.m7983h(iM7988m)) {
                case 1:
                    iM7990o = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 2:
                    iM7990o2 = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 3:
                    iM7990o3 = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 4:
                    strM7979d = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
                case 5:
                    iBinderM7989n = AbstractC1883il.m7989n(parcel, iM7988m);
                    break;
                case 6:
                    scopeArr = (Scope[]) AbstractC1883il.m7981f(parcel, iM7988m, Scope.CREATOR);
                    break;
                case 7:
                    bundle = AbstractC1883il.m7976a(parcel, iM7988m);
                    break;
                case 8:
                    account = (Account) AbstractC1883il.m7978c(parcel, iM7988m, Account.CREATOR);
                    break;
                case 9:
                default:
                    AbstractC1883il.m7994s(parcel, iM7988m);
                    break;
                case 10:
                    c0618NaArr = (C0618Na[]) AbstractC1883il.m7981f(parcel, iM7988m, C0618Na.CREATOR);
                    break;
                case 11:
                    c0618NaArr2 = (C0618Na[]) AbstractC1883il.m7981f(parcel, iM7988m, C0618Na.CREATOR);
                    break;
                case 12:
                    zM7984i = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 13:
                    iM7990o4 = AbstractC1883il.m7990o(parcel, iM7988m);
                    break;
                case 14:
                    zM7984i2 = AbstractC1883il.m7984i(parcel, iM7988m);
                    break;
                case 15:
                    strM7979d2 = AbstractC1883il.m7979d(parcel, iM7988m);
                    break;
            }
        }
        AbstractC1883il.m7982g(parcel, iM7995t);
        return new C0114Cc(iM7990o, iM7990o2, iM7990o3, strM7979d, iBinderM7989n, scopeArr, bundle, account, c0618NaArr, c0618NaArr2, zM7984i, iM7990o4, zM7984i2, strM7979d2);
    }

    @Override
    public final Object[] newArray(int i) {
        return new C0114Cc[i];
    }
}
