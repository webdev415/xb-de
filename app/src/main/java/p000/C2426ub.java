package p000;

import android.graphics.Rect;
import android.util.Log;

/* loaded from: classes.dex */
public class C2426ub extends AbstractC1647dj {

    public static final String f7400b = "ub";

    @Override
    public float mo7327c(C1180Zl c1180Zl, C1180Zl c1180Zl2) {
        if (c1180Zl.f3463l <= 0 || c1180Zl.f3464m <= 0) {
            return 0.0f;
        }
        C1180Zl c1180ZlM5070h = c1180Zl.m5070h(c1180Zl2);
        float fPow = (c1180ZlM5070h.f3463l * 1.0f) / c1180Zl.f3463l;
        if (fPow > 1.0f) {
            fPow = (float) Math.pow(1.0f / fPow, 1.1d);
        }
        float f = ((c1180Zl2.f3463l * 1.0f) / c1180ZlM5070h.f3463l) * ((c1180Zl2.f3464m * 1.0f) / c1180ZlM5070h.f3464m);
        return fPow * (((1.0f / f) / f) / f);
    }

    @Override
    public Rect mo7328d(C1180Zl c1180Zl, C1180Zl c1180Zl2) {
        C1180Zl c1180ZlM5070h = c1180Zl.m5070h(c1180Zl2);
        Log.i(f7400b, "Preview: " + c1180Zl + "; Scaled: " + c1180ZlM5070h + "; Want: " + c1180Zl2);
        int i = (c1180ZlM5070h.f3463l - c1180Zl2.f3463l) / 2;
        int i2 = (c1180ZlM5070h.f3464m - c1180Zl2.f3464m) / 2;
        return new Rect(-i, -i2, c1180ZlM5070h.f3463l - i, c1180ZlM5070h.f3464m - i2);
    }
}
