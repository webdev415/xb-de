package p000;

public abstract class AbstractC0254Fe extends AbstractC0300Ge {
    public static int m1249a(int i, int i2, int i3) {
        AbstractC1131Yi.m4970f(i2 <= i3, "min (%s) must be less than or equal to max (%s)", i2, i3);
        return Math.min(Math.max(i, i2), i3);
    }
}
