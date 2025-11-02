package p000;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p000.InterfaceC0667Od;

/* loaded from: classes.dex */
public final class C2193pH extends AbstractC0954Up implements IInterface {
    public C2193pH(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int m9049Q() {
        Parcel parcelM4293O = m4293O(6, m4294P());
        int i = parcelM4293O.readInt();
        parcelM4293O.recycle();
        return i;
    }

    public final int m9050R(InterfaceC0667Od interfaceC0667Od, String str, boolean z) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(z ? 1 : 0);
        Parcel parcelM4293O = m4293O(3, parcelM4294P);
        int i = parcelM4293O.readInt();
        parcelM4293O.recycle();
        return i;
    }

    public final int m9051S(InterfaceC0667Od interfaceC0667Od, String str, boolean z) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(z ? 1 : 0);
        Parcel parcelM4293O = m4293O(5, parcelM4294P);
        int i = parcelM4293O.readInt();
        parcelM4293O.recycle();
        return i;
    }

    public final InterfaceC0667Od m9052T(InterfaceC0667Od interfaceC0667Od, String str, int i) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(i);
        Parcel parcelM4293O = m4293O(2, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }

    public final InterfaceC0667Od m9053U(InterfaceC0667Od interfaceC0667Od, String str, int i, InterfaceC0667Od interfaceC0667Od2) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(i);
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od2);
        Parcel parcelM4293O = m4293O(8, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }

    public final InterfaceC0667Od m9054V(InterfaceC0667Od interfaceC0667Od, String str, int i) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(i);
        Parcel parcelM4293O = m4293O(4, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }

    public final InterfaceC0667Od m9055W(InterfaceC0667Od interfaceC0667Od, String str, boolean z, long j) {
        Parcel parcelM4294P = m4294P();
        AbstractC0176Ds.m792d(parcelM4294P, interfaceC0667Od);
        parcelM4294P.writeString(str);
        parcelM4294P.writeInt(z ? 1 : 0);
        parcelM4294P.writeLong(j);
        Parcel parcelM4293O = m4293O(7, parcelM4294P);
        InterfaceC0667Od interfaceC0667OdM3418P = InterfaceC0667Od.a.m3418P(parcelM4293O.readStrongBinder());
        parcelM4293O.recycle();
        return interfaceC0667OdM3418P;
    }
}
