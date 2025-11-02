package p000;

import android.util.Base64;

/* loaded from: classes.dex */
public abstract class AbstractC2362t2 {
    public static String m9664a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return Base64.encodeToString(bArr, 11);
    }
}
