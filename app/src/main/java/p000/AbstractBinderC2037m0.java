package p000;

import android.accounts.Account;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import p000.InterfaceC0253Fd;

public abstract class AbstractBinderC2037m0 extends InterfaceC0253Fd.a {
    public static Account m8431Q(InterfaceC0253Fd interfaceC0253Fd) {
        Account accountMo1247b = null;
        if (interfaceC0253Fd != null) {
            long jClearCallingIdentity = Binder.clearCallingIdentity();
            try {
                try {
                    accountMo1247b = interfaceC0253Fd.mo1247b();
                } catch (RemoteException unused) {
                    Log.w("AccountAccessor", "Remote account accessor probably died");
                }
            } finally {
                Binder.restoreCallingIdentity(jClearCallingIdentity);
            }
        }
        return accountMo1247b;
    }
}
