package p000;

import android.util.Log;

public final class C2554xA extends AbstractC2001lA {
    public C2554xA(C0057BA c0057ba, String str, Double d, boolean z) {
        super(c0057ba, str, d);
    }

    @Override
    public final Double mo8369c(Object obj) {
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if (obj instanceof String) {
            try {
                return Double.valueOf(Double.parseDouble((String) obj));
            } catch (NumberFormatException unused) {
            }
        }
        Log.e("PhenotypeFlag", "Invalid double value for " + super.m8373k() + ": " + String.valueOf(obj));
        return null;
    }
}
