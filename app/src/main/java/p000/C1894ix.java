package p000;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class C1894ix extends AbstractC2167os implements InterfaceC1707ex {
    public C1894ix(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override
    public final List mo799A(String str, String str2, String str3) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        parcelM8982O.writeString(str3);
        Parcel parcelM8983P = m8983P(17, parcelM8982O);
        ArrayList arrayListCreateTypedArrayList = parcelM8983P.createTypedArrayList(C2303rq.CREATOR);
        parcelM8983P.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override
    public final void mo801C(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(18, parcelM8982O);
    }

    @Override
    public final void mo802F(C2303rq c2303rq) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c2303rq);
        m8984Q(13, parcelM8982O);
    }

    @Override
    public final void mo803G(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(26, parcelM8982O);
    }

    @Override
    public final List mo804H(C0569MG c0569mg, Bundle bundle) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        Parcel parcelM8983P = m8983P(24, parcelM8982O);
        ArrayList arrayListCreateTypedArrayList = parcelM8983P.createTypedArrayList(C1913jF.CREATOR);
        parcelM8983P.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override
    public final void mo805I(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(25, parcelM8982O);
    }

    @Override
    public final void mo806J(C2053mG c2053mG, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c2053mG);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(2, parcelM8982O);
    }

    @Override
    public final void mo807K(C0635Nr c0635Nr, String str, String str2) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0635Nr);
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        m8984Q(5, parcelM8982O);
    }

    @Override
    public final String mo819h(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        Parcel parcelM8983P = m8983P(11, parcelM8982O);
        String string = parcelM8983P.readString();
        parcelM8983P.recycle();
        return string;
    }

    @Override
    public final void mo820i(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(4, parcelM8982O);
    }

    @Override
    public final void mo821j(C2303rq c2303rq, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c2303rq);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(12, parcelM8982O);
    }

    @Override
    public final List mo822k(String str, String str2, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        Parcel parcelM8983P = m8983P(16, parcelM8982O);
        ArrayList arrayListCreateTypedArrayList = parcelM8983P.createTypedArrayList(C2303rq.CREATOR);
        parcelM8983P.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override
    public final void mo823m(Bundle bundle, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(28, parcelM8982O);
    }

    @Override
    public final void mo824n(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(20, parcelM8982O);
    }

    @Override
    public final void mo825p(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(6, parcelM8982O);
    }

    @Override
    public final byte[] mo826q(C0635Nr c0635Nr, String str) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0635Nr);
        parcelM8982O.writeString(str);
        Parcel parcelM8983P = m8983P(9, parcelM8982O);
        byte[] bArrCreateByteArray = parcelM8983P.createByteArray();
        parcelM8983P.recycle();
        return bArrCreateByteArray;
    }

    @Override
    public final void mo827r(C0635Nr c0635Nr, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0635Nr);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(1, parcelM8982O);
    }

    @Override
    public final C0312Gq mo828t(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        Parcel parcelM8983P = m8983P(21, parcelM8982O);
        C0312Gq c0312Gq = (C0312Gq) AbstractC2351ss.m9598a(parcelM8983P, C0312Gq.CREATOR);
        parcelM8983P.recycle();
        return c0312Gq;
    }

    @Override
    public final void mo829v(Bundle bundle, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, bundle);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(19, parcelM8982O);
    }

    @Override
    public final void mo830w(C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        m8984Q(27, parcelM8982O);
    }

    @Override
    public final List mo831x(String str, String str2, boolean z, C0569MG c0569mg) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        AbstractC2351ss.m9602e(parcelM8982O, z);
        AbstractC2351ss.m9601d(parcelM8982O, c0569mg);
        Parcel parcelM8983P = m8983P(14, parcelM8982O);
        ArrayList arrayListCreateTypedArrayList = parcelM8983P.createTypedArrayList(C2053mG.CREATOR);
        parcelM8983P.recycle();
        return arrayListCreateTypedArrayList;
    }

    @Override
    public final void mo832y(long j, String str, String str2, String str3) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeLong(j);
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        parcelM8982O.writeString(str3);
        m8984Q(10, parcelM8982O);
    }

    @Override
    public final List mo833z(String str, String str2, String str3, boolean z) {
        Parcel parcelM8982O = m8982O();
        parcelM8982O.writeString(str);
        parcelM8982O.writeString(str2);
        parcelM8982O.writeString(str3);
        AbstractC2351ss.m9602e(parcelM8982O, z);
        Parcel parcelM8983P = m8983P(15, parcelM8982O);
        ArrayList arrayListCreateTypedArrayList = parcelM8983P.createTypedArrayList(C2053mG.CREATOR);
        parcelM8983P.recycle();
        return arrayListCreateTypedArrayList;
    }
}
