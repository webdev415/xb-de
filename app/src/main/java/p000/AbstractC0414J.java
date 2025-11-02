package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0414J extends AbstractC0946Uh {

    public final int[] f1248b;

    public final int[] f1251e;

    public final int[] f1252f;

    public final int[] f1247a = new int[4];

    public final float[] f1249c = new float[4];

    public final float[] f1250d = new float[4];

    public AbstractC0414J() {
        int[] iArr = new int[8];
        this.f1248b = iArr;
        this.f1251e = new int[iArr.length / 2];
        this.f1252f = new int[iArr.length / 2];
    }

    public static void m1763i(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    public static void m1764p(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    public static boolean m1765q(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
                if (i3 < i) {
                    i = i3;
                }
            }
            if (i2 < i * 10) {
                return true;
            }
        }
        return false;
    }

    public static int m1766r(int[] iArr, int[][] iArr2) throws C2340sh {
        for (int i = 0; i < iArr2.length; i++) {
            if (AbstractC0946Uh.m4263f(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw C2340sh.m9579a();
    }

    public final int[] m1767j() {
        return this.f1248b;
    }

    public final int[] m1768k() {
        return this.f1247a;
    }

    public final int[] m1769l() {
        return this.f1252f;
    }

    public final float[] m1770m() {
        return this.f1250d;
    }

    public final int[] m1771n() {
        return this.f1251e;
    }

    public final float[] m1772o() {
        return this.f1249c;
    }
}
