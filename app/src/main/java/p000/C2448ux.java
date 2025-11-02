package p000;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import p000.AbstractC2454v2;

/* loaded from: classes.dex */
public final class C2448ux extends AbstractC2454v2 {
    public C2448ux(Context context, Looper looper, a aVar, b bVar) {
        super(context, looper, 93, aVar, bVar, null);
    }

    @Override
    public final IInterface mo10240d(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
        return iInterfaceQueryLocalInterface instanceof InterfaceC1707ex ? (InterfaceC1707ex) iInterfaceQueryLocalInterface : new C1894ix(iBinder);
    }

    @Override
    public final int mo10241n() {
        return 12451000;
    }

    @Override
    public final String mo10242r() {
        return "com.google.android.gms.measurement.internal.IMeasurementService";
    }

    @Override
    public final String mo10243s() {
        return "com.google.android.gms.measurement.START";
    }
}
