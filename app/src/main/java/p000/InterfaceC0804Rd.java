package p000;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;

public interface InterfaceC0804Rd extends IInterface {

    public static final String f2394a = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', '.');

    public static abstract class a extends Binder implements InterfaceC0804Rd {

        public static class C2698a implements InterfaceC0804Rd {

            public IBinder f2395c;

            public C2698a(IBinder iBinder) {
                this.f2395c = iBinder;
            }

            @Override
            public IBinder asBinder() {
                return this.f2395c;
            }
        }

        public static InterfaceC0804Rd m3820O(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(InterfaceC0804Rd.f2394a);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof InterfaceC0804Rd)) ? new C2698a(iBinder) : (InterfaceC0804Rd) iInterfaceQueryLocalInterface;
        }
    }
}
