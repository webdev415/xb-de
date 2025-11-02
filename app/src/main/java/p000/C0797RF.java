package p000;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import p000.InterfaceC0667Od;

/* loaded from: classes.dex */
public final class C0797RF extends AbstractC0552M {
    public static final Creator<C0797RF> CREATOR = new C0615NG();

    public final String f2366l;

    public final boolean f2367m;

    public final boolean f2368n;

    public final Context f2369o;

    public final boolean f2370p;

    public final boolean f2371q;

    public C0797RF(String str, boolean z, boolean z2, IBinder iBinder, boolean z3, boolean z4) {
        this.f2366l = str;
        this.f2367m = z;
        this.f2368n = z2;
        this.f2369o = (Context) BinderC0211Eh.m1040Q(InterfaceC0667Od.a.m3418P(iBinder));
        this.f2370p = z3;
        this.f2371q = z4;
    }

    /* JADX WARN: Type inference failed for: r5v5, types: [Od, android.os.IBinder] */
    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f2366l;
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 1, str, false);
        AbstractC1929jl.m8183c(parcel, 2, this.f2367m);
        AbstractC1929jl.m8183c(parcel, 3, this.f2368n);
        AbstractC1929jl.m8188h(parcel, 4, BinderC0211Eh.m1041R(this.f2369o), false);
        AbstractC1929jl.m8183c(parcel, 5, this.f2370p);
        AbstractC1929jl.m8183c(parcel, 6, this.f2371q);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
