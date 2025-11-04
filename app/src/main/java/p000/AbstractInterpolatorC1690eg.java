package p000;

import android.view.animation.Interpolator;

public abstract class AbstractInterpolatorC1690eg implements Interpolator {

    public final float[] f5424a;

    public final float f5425b;

    public AbstractInterpolatorC1690eg(float[] fArr) {
        this.f5424a = fArr;
        this.f5425b = 1.0f / (fArr.length - 1);
    }

    @Override
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        float[] fArr = this.f5424a;
        int iMin = Math.min((int) ((fArr.length - 1) * f), fArr.length - 2);
        float f2 = this.f5425b;
        float f3 = (f - (iMin * f2)) / f2;
        float[] fArr2 = this.f5424a;
        float f4 = fArr2[iMin];
        return f4 + (f3 * (fArr2[iMin + 1] - f4));
    }
}
