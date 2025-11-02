package p000;

import java.lang.reflect.Array;

/* loaded from: classes.dex */
public abstract class AbstractC2110ni {

    public static final float[][] f6466a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, AbstractC2156oi.f6578b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = AbstractC2156oi.f6578b;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i == i4) {
                        f += 1.0f;
                        i3 >>= 1;
                    }
                }
                f6466a[i2][7 - i5] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }

    public static int m8787a(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j2 = j << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j = j2 | i3;
            }
        }
        return (int) j;
    }

    public static int m8788b(int[] iArr) {
        int iM10357d = AbstractC2477vg.m10357d(iArr);
        float[] fArr = new float[8];
        if (iM10357d > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / iM10357d;
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = f6466a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = AbstractC2156oi.f6578b[i3];
                f = f2;
            }
            i3++;
        }
    }

    public static int m8789c(int[] iArr) {
        int iM8787a = m8787a(iArr);
        if (AbstractC2156oi.m8964a(iM8787a) == -1) {
            return -1;
        }
        return iM8787a;
    }

    public static int m8790d(int[] iArr) {
        int iM8789c = m8789c(m8791e(iArr));
        return iM8789c != -1 ? iM8789c : m8788b(iArr);
    }

    public static int[] m8791e(int[] iArr) {
        float fM10357d = AbstractC2477vg.m10357d(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            float f = (fM10357d / 34.0f) + ((i3 * fM10357d) / 17.0f);
            int i4 = iArr[i2];
            if (i + i4 <= f) {
                i += i4;
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }
}
