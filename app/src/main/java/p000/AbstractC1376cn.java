package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1376cn {
    public static final int m5940a(String str, int i, int i2, int i3) {
        return (int) AbstractC1229an.m5304c(str, i, i2, i3);
    }

    public static final long m5941b(String str, long j, long j2, long j3) {
        String strM5305d = AbstractC1229an.m5305d(str);
        if (strM5305d == null) {
            return j;
        }
        Long lM2448h = AbstractC0492Km.m2448h(strM5305d);
        if (lM2448h == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + strM5305d + '\'').toString());
        }
        long jLongValue = lM2448h.longValue();
        if (j2 <= jLongValue && jLongValue <= j3) {
            return jLongValue;
        }
        throw new IllegalStateException(("System property '" + str + "' should be in range " + j2 + ".." + j3 + ", but is '" + jLongValue + '\'').toString());
    }

    public static final String m5942c(String str, String str2) {
        String strM5305d = AbstractC1229an.m5305d(str);
        return strM5305d == null ? str2 : strM5305d;
    }

    public static final boolean m5943d(String str, boolean z) {
        String strM5305d = AbstractC1229an.m5305d(str);
        return strM5305d != null ? Boolean.parseBoolean(strM5305d) : z;
    }

    public static int m5944e(String str, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 1;
        }
        if ((i4 & 8) != 0) {
            i3 = Integer.MAX_VALUE;
        }
        return AbstractC1229an.m5303b(str, i, i2, i3);
    }

    public static long m5945f(String str, long j, long j2, long j3, int i, Object obj) {
        if ((i & 4) != 0) {
            j2 = 1;
        }
        long j4 = j2;
        if ((i & 8) != 0) {
            j3 = Long.MAX_VALUE;
        }
        return AbstractC1229an.m5304c(str, j, j4, j3);
    }
}
