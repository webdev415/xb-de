package p000;

import android.os.IBinder;
import android.os.Parcel;

/* loaded from: classes.dex */
public final class C2211pq extends AbstractC0954Up implements InterfaceC2487vq {
    public C2211pq(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IGoogleCertificatesApi");
    }

    @Override
    public final boolean mo9081e() {
        Parcel parcelM4293O = m4293O(7, m4294P());
        boolean zM793e = AbstractC0176Ds.m793e(parcelM4293O);
        parcelM4293O.recycle();
        return zM793e;
    }

    @Override
    public final C2377tH mo9082g(C0797RF c0797rf) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m791c(parcelM4294P, c0797rf);
        Parcel parcelM4293O = m4293O(8, parcelM4294P);
        C2377tH c2377tH = (C2377tH) AbstractC0176Ds.m789a(parcelM4293O, C2377tH.CREATOR);
        parcelM4293O.recycle();
        return c2377tH;
    }

    @Override
    public final boolean mo9083o(C0111CI c0111ci, InterfaceC0667Od interfaceC0667Od) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m791c(parcelM4294P, c0111ci);
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        Parcel parcelM4293O = m4293O(5, parcelM4294P);
        boolean zM793e = AbstractC0176Ds.m793e(parcelM4293O);
        parcelM4293O.recycle();
        return zM793e;
    }

    @Override
    public final C2377tH mo9084u(C0797RF c0797rf) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m791c(parcelM4294P, c0797rf);
        Parcel parcelM4293O = m4293O(6, parcelM4294P);
        C2377tH c2377tH = (C2377tH) AbstractC0176Ds.m789a(parcelM4293O, C2377tH.CREATOR);
        parcelM4293O.recycle();
        return c2377tH;
    }
}
