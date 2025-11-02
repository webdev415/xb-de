package p000;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes.dex */
public interface InterfaceC0667Od extends IInterface {

    public static abstract class a extends AbstractBinderC2488vr implements InterfaceC0667Od {
        public a() {
            super("com.google.android.gms.dynamic.IObjectWrapper");
        }

        public static InterfaceC0667Od m3418P(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamic.IObjectWrapper");
            return iInterfaceQueryLocalInterface instanceof InterfaceC0667Od ? (InterfaceC0667Od) iInterfaceQueryLocalInterface : new C2350sr(iBinder);
        }
    }
}
