package p000;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import p000.InterfaceC0253Fd;

/* loaded from: classes.dex */
public class C0114Cc extends AbstractC0552M {

    public final int f263l;

    public final int f264m;

    public final int f265n;

    public String f266o;

    public IBinder f267p;

    public Scope[] f268q;

    public Bundle f269r;

    public Account f270s;

    public C0618Na[] f271t;

    public C0618Na[] f272u;

    public final boolean f273v;

    public final int f274w;

    public boolean f275x;

    public final String f276y;
    public static final Creator<C0114Cc> CREATOR = new C0475KE();

    public static final Scope[] f262z = new Scope[0];

    public static final C0618Na[] f261A = new C0618Na[0];

    public C0114Cc(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account, C0618Na[] c0618NaArr, C0618Na[] c0618NaArr2, boolean z, int i4, boolean z2, String str2) {
        scopeArr = scopeArr == null ? f262z : scopeArr;
        bundle = bundle == null ? new Bundle() : bundle;
        c0618NaArr = c0618NaArr == null ? f261A : c0618NaArr;
        c0618NaArr2 = c0618NaArr2 == null ? f261A : c0618NaArr2;
        this.f263l = i;
        this.f264m = i2;
        this.f265n = i3;
        if ("com.google.android.gms".equals(str)) {
            this.f266o = "com.google.android.gms";
        } else {
            this.f266o = str;
        }
        if (i < 2) {
            this.f270s = iBinder != null ? AbstractBinderC2037m0.m8431Q(InterfaceC0253Fd.a.m1248P(iBinder)) : null;
        } else {
            this.f267p = iBinder;
            this.f270s = account;
        }
        this.f268q = scopeArr;
        this.f269r = bundle;
        this.f271t = c0618NaArr;
        this.f272u = c0618NaArr2;
        this.f273v = z;
        this.f274w = i4;
        this.f275x = z2;
        this.f276y = str2;
    }

    public final String m442d() {
        return this.f276y;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        C0475KE.m2318a(this, parcel, i);
    }
}
