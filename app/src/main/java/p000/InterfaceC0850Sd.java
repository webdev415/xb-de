package p000;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p000.InterfaceC0804Rd;

public interface InterfaceC0850Sd extends IInterface {

    public static final String f2645b = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportService".replace('$', '.');

    void mo4054E(InterfaceC0804Rd interfaceC0804Rd);

    public static abstract class a extends Binder implements InterfaceC0850Sd {
        public a() {
            attachInterface(this, InterfaceC0850Sd.f2645b);
        }

        @Override
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            String str = InterfaceC0850Sd.f2645b;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            mo4054E(InterfaceC0804Rd.a.m3820O(parcel.readStrongBinder()));
            return true;
        }

        @Override
        public IBinder asBinder() {
            return this;
        }
    }
}
