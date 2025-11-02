package p000;

import android.util.Log;

/* loaded from: classes.dex */
public final class C2370tA extends AbstractC2001lA {
    public C2370tA(C0057BA c0057ba, String str, Long l, boolean z) {
        super(c0057ba, str, l);
    }

    @Override
    public final Long mo8369c(Object obj) {
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof String) {
            try {
                return Long.valueOf(Long.parseLong((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        Log.e("PhenotypeFlag", "Invalid long value for " + super.m8373k() + ": " + String.valueOf(obj));
        return null;
    }
}
