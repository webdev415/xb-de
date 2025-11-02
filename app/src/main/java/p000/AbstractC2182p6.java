package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2182p6 {

    public static final int[] f6629a = new int[0];

    public static final long[] f6630b = new long[0];

    public static final Object[] f6631c = new Object[0];

    public static int m9032a(int[] iArr, int i, int i2) {
        int i3 = i - 1;
        int i4 = 0;
        while (i4 <= i3) {
            int i5 = (i4 + i3) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i2) {
                i4 = i5 + 1;
            } else {
                if (i6 <= i2) {
                    return i5;
                }
                i3 = i5 - 1;
            }
        }
        return ~i4;
    }

    public static boolean m9033b(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static int m9034c(int i) {
        for (int i2 = 4; i2 < 32; i2++) {
            int i3 = (1 << i2) - 12;
            if (i <= i3) {
                return i3;
            }
        }
        return i;
    }

    public static int m9035d(int i) {
        return m9034c(i * 4) / 4;
    }
}
