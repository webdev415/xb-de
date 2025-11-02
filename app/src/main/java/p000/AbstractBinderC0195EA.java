package p000;

import android.os.RemoteException;
import android.util.Log;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class AbstractBinderC0195EA extends AbstractBinderC1917jJ {

    public final int f467c;

    public AbstractBinderC0195EA(byte[] bArr) {
        AbstractC1085Xi.m4792a(bArr.length == 25);
        this.f467c = Arrays.hashCode(bArr);
    }

    public static byte[] m883Q(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError(e);
        }
    }

    public abstract byte[] mo884R();

    @Override
    public final int mo885c() {
        return this.f467c;
    }

    @Override
    public final InterfaceC0667Od mo886d() {
        return BinderC0211Eh.m1041R(mo884R());
    }

    public final boolean equals(Object obj) {
        InterfaceC0667Od interfaceC0667OdMo886d;
        if (obj != null && (obj instanceof InterfaceC1333bq)) {
            try {
                InterfaceC1333bq interfaceC1333bq = (InterfaceC1333bq) obj;
                if (interfaceC1333bq.mo885c() == this.f467c && (interfaceC0667OdMo886d = interfaceC1333bq.mo886d()) != null) {
                    return Arrays.equals(mo884R(), (byte[]) BinderC0211Eh.m1040Q(interfaceC0667OdMo886d));
                }
                return false;
            } catch (RemoteException e) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f467c;
    }
}
