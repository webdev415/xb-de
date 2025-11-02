package p000;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;

public final class C0938UI extends AbstractC0954Up implements InterfaceC0253Fd {
    public C0938UI(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    @Override
    public final Account mo1247b() {
        Parcel parcelM4293O = m4293O(2, m4294P());
        Account account = (Account) AbstractC0176Ds.m789a(parcelM4293O, Account.CREATOR);
        parcelM4293O.recycle();
        return account;
    }
}
