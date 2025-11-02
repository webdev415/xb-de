package p000;

import android.util.Log;

/* loaded from: classes.dex */
public final class C2278rA extends AbstractC2001lA {
    public C2278rA(C0057BA c0057ba, String str, Boolean bool, boolean z) {
        super(c0057ba, str, bool);
    }

    @Override
    public final Object mo8369c(Object obj) {
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (AbstractC1803gz.f5670c.matcher(str).matches()) {
                return Boolean.TRUE;
            }
            if (AbstractC1803gz.f5671d.matcher(str).matches()) {
                return Boolean.FALSE;
            }
        }
        Log.e("PhenotypeFlag", "Invalid boolean value for " + super.m8373k() + ": " + String.valueOf(obj));
        return null;
    }
}
