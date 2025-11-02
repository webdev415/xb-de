package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p000.InterfaceC0667Od;

/* loaded from: classes.dex */
public final class C0983VH extends AbstractC0954Up implements IInterface {
    public C0983VH(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final InterfaceC0667Od m4383Q(InterfaceC0667Od interfaceC0667Od, String str, int i, InterfaceC0667Od interfaceC0667Od2) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(i);
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od2);
        Parcel parcelM4293O = m4293O(2, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }

    public final InterfaceC0667Od m4384R(InterfaceC0667Od interfaceC0667Od, String str, int i, InterfaceC0667Od interfaceC0667Od2) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(i);
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od2);
        Parcel parcelM4293O = m4293O(3, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }
}
