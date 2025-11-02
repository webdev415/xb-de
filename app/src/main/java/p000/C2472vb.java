package p000;

import android.graphics.Rect;

public class C2472vb extends AbstractC1647dj {
    public static float m10346e(float f) {
        return f < 1.0f ? 1.0f / f : f;
    }

    @Override
    public float mo7327c(C1180Zl c1180Zl, C1180Zl c1180Zl2) {
        int i = c1180Zl.f3463l;
        if (i <= 0 || c1180Zl.f3464m <= 0) {
            return 0.0f;
        }
        float fM10346e = (1.0f / m10346e((i * 1.0f) / c1180Zl2.f3463l)) / m10346e((c1180Zl.f3464m * 1.0f) / c1180Zl2.f3464m);
        float fM10346e2 = m10346e(((c1180Zl.f3463l * 1.0f) / c1180Zl.f3464m) / ((c1180Zl2.f3463l * 1.0f) / c1180Zl2.f3464m));
        return fM10346e * (((1.0f / fM10346e2) / fM10346e2) / fM10346e2);
    }

    @Override
    public Rect mo7328d(C1180Zl c1180Zl, C1180Zl c1180Zl2) {
        return new Rect(0, 0, c1180Zl2.f3463l, c1180Zl2.f3464m);
    }
}
