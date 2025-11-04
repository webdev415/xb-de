package p000;

import android.os.Bundle;
import android.os.Parcel;
import java.util.List;

public abstract class AbstractBinderC1614cx extends AbstractBinderC2443us implements InterfaceC1707ex {
    public AbstractBinderC1614cx() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    @Override
    public final boolean mo7274O(int i, Parcel parcel, Parcel parcel2, int i2) {
        List listMo800B;
        switch (i) {
            case 1:
                C0635Nr c0635Nr = (C0635Nr) AbstractC2351ss.m9598a(parcel, C0635Nr.CREATOR);
                C0569MG c0569mg = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo827r(c0635Nr, c0569mg);
                parcel2.writeNoException();
                return true;
            case 2:
                C2053mG c2053mG = (C2053mG) AbstractC2351ss.m9598a(parcel, C2053mG.CREATOR);
                C0569MG c0569mg2 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo806J(c2053mG, c0569mg2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            default:
                return false;
            case 4:
                C0569MG c0569mg3 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo820i(c0569mg3);
                parcel2.writeNoException();
                return true;
            case 5:
                C0635Nr c0635Nr2 = (C0635Nr) AbstractC2351ss.m9598a(parcel, C0635Nr.CREATOR);
                String string = parcel.readString();
                String string2 = parcel.readString();
                AbstractC2351ss.m9603f(parcel);
                mo807K(c0635Nr2, string, string2);
                parcel2.writeNoException();
                return true;
            case 6:
                C0569MG c0569mg4 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo825p(c0569mg4);
                parcel2.writeNoException();
                return true;
            case 7:
                C0569MG c0569mg5 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                boolean zM9605h = AbstractC2351ss.m9605h(parcel);
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo800B(c0569mg5, zM9605h);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 9:
                C0635Nr c0635Nr3 = (C0635Nr) AbstractC2351ss.m9598a(parcel, C0635Nr.CREATOR);
                String string3 = parcel.readString();
                AbstractC2351ss.m9603f(parcel);
                byte[] bArrMo826q = mo826q(c0635Nr3, string3);
                parcel2.writeNoException();
                parcel2.writeByteArray(bArrMo826q);
                return true;
            case 10:
                long j = parcel.readLong();
                String string4 = parcel.readString();
                String string5 = parcel.readString();
                String string6 = parcel.readString();
                AbstractC2351ss.m9603f(parcel);
                mo832y(j, string4, string5, string6);
                parcel2.writeNoException();
                return true;
            case 11:
                C0569MG c0569mg6 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                String strMo819h = mo819h(c0569mg6);
                parcel2.writeNoException();
                parcel2.writeString(strMo819h);
                return true;
            case 12:
                C2303rq c2303rq = (C2303rq) AbstractC2351ss.m9598a(parcel, C2303rq.CREATOR);
                C0569MG c0569mg7 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo821j(c2303rq, c0569mg7);
                parcel2.writeNoException();
                return true;
            case 13:
                C2303rq c2303rq2 = (C2303rq) AbstractC2351ss.m9598a(parcel, C2303rq.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo802F(c2303rq2);
                parcel2.writeNoException();
                return true;
            case 14:
                String string7 = parcel.readString();
                String string8 = parcel.readString();
                boolean zM9605h2 = AbstractC2351ss.m9605h(parcel);
                C0569MG c0569mg8 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo831x(string7, string8, zM9605h2, c0569mg8);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 15:
                String string9 = parcel.readString();
                String string10 = parcel.readString();
                String string11 = parcel.readString();
                boolean zM9605h3 = AbstractC2351ss.m9605h(parcel);
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo833z(string9, string10, string11, zM9605h3);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 16:
                String string12 = parcel.readString();
                String string13 = parcel.readString();
                C0569MG c0569mg9 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo822k(string12, string13, c0569mg9);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 17:
                String string14 = parcel.readString();
                String string15 = parcel.readString();
                String string16 = parcel.readString();
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo799A(string14, string15, string16);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 18:
                C0569MG c0569mg10 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo801C(c0569mg10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                C0569MG c0569mg11 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo829v(bundle, c0569mg11);
                parcel2.writeNoException();
                return true;
            case 20:
                C0569MG c0569mg12 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo824n(c0569mg12);
                parcel2.writeNoException();
                return true;
            case 21:
                C0569MG c0569mg13 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                C0312Gq c0312GqMo828t = mo828t(c0569mg13);
                parcel2.writeNoException();
                AbstractC2351ss.m9604g(parcel2, c0312GqMo828t);
                return true;
            case 24:
                C0569MG c0569mg14 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                Bundle bundle2 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                listMo800B = mo804H(c0569mg14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(listMo800B);
                return true;
            case 25:
                C0569MG c0569mg15 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo805I(c0569mg15);
                parcel2.writeNoException();
                return true;
            case 26:
                C0569MG c0569mg16 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo803G(c0569mg16);
                parcel2.writeNoException();
                return true;
            case 27:
                C0569MG c0569mg17 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo830w(c0569mg17);
                parcel2.writeNoException();
                return true;
            case 28:
                Bundle bundle3 = (Bundle) AbstractC2351ss.m9598a(parcel, Bundle.CREATOR);
                C0569MG c0569mg18 = (C0569MG) AbstractC2351ss.m9598a(parcel, C0569MG.CREATOR);
                AbstractC2351ss.m9603f(parcel);
                mo823m(bundle3, c0569mg18);
                parcel2.writeNoException();
                return true;
        }
    }
}
