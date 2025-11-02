package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2477vg {
    public static float m10354a(float f, float f2, float f3, float f4) {
        double d = f - f3;
        double d2 = f2 - f4;
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public static float m10355b(int i, int i2, int i3, int i4) {
        double d = i - i3;
        double d2 = i2 - i4;
        return (float) Math.sqrt((d * d) + (d2 * d2));
    }

    public static int m10356c(float f) {
        return (int) (f + (f < 0.0f ? -0.5f : 0.5f));
    }

    public static int m10357d(int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += i2;
        }
        return i;
    }
}
