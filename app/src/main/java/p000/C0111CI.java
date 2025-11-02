package p000;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;

/* loaded from: classes.dex */
public final class C0111CI extends AbstractC0552M {
    public static final Creator<C0111CI> CREATOR = new C0525LI();

    public final String f256l;

    public final AbstractBinderC0195EA f257m;

    public final boolean f258n;

    public final boolean f259o;

    public C0111CI(String str, IBinder iBinder, boolean z, boolean z2) {
        this.f256l = str;
        BinderC0380IB binderC0380IB = null;
        if (iBinder != null) {
            try {
                InterfaceC0667Od interfaceC0667OdMo886d = AbstractBinderC1917jJ.m8129P(iBinder).mo886d();
                byte[] bArr = interfaceC0667OdMo886d == null ? null : (byte[]) BinderC0211Eh.m1040Q(interfaceC0667OdMo886d);
                if (bArr != null) {
                    binderC0380IB = new BinderC0380IB(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e);
            }
        }
        this.f257m = binderC0380IB;
        this.f258n = z;
        this.f259o = z2;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        String str = this.f256l;
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8194n(parcel, 1, str, false);
        AbstractBinderC0195EA abstractBinderC0195EA = this.f257m;
        if (abstractBinderC0195EA == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            abstractBinderC0195EA = null;
        }
        AbstractC1929jl.m8188h(parcel, 2, abstractBinderC0195EA, false);
        AbstractC1929jl.m8183c(parcel, 3, this.f258n);
        AbstractC1929jl.m8183c(parcel, 4, this.f259o);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }

    public C0111CI(String str, AbstractBinderC0195EA abstractBinderC0195EA, boolean z, boolean z2) {
        this.f256l = str;
        this.f257m = abstractBinderC0195EA;
        this.f258n = z;
        this.f259o = z2;
    }
}
