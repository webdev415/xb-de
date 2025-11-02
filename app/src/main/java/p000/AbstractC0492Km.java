package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0492Km extends AbstractC0446Jm {
    public static Integer m2446f(String str) {
        AbstractC0116Ce.m476e(str, "<this>");
        return m2447g(str, 10);
    }

    public static final Integer m2447g(String str, int i) {
        boolean z;
        int i2;
        int i3;
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC2410u4.m9933a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i4 = 0;
        char cCharAt = str.charAt(0);
        int i5 = -2147483647;
        if (AbstractC0116Ce.m477f(cCharAt, 48) < 0) {
            i2 = 1;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                i5 = Integer.MIN_VALUE;
                z = true;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
            }
        } else {
            z = false;
            i2 = 0;
        }
        int i6 = -59652323;
        while (i2 < length) {
            int iM9934b = AbstractC2410u4.m9934b(str.charAt(i2), i);
            if (iM9934b < 0) {
                return null;
            }
            if ((i4 < i6 && (i6 != -59652323 || i4 < (i6 = i5 / i))) || (i3 = i4 * i) < i5 + iM9934b) {
                return null;
            }
            i4 = i3 - iM9934b;
            i2++;
        }
        return z ? Integer.valueOf(i4) : Integer.valueOf(-i4);
    }

    public static Long m2448h(String str) {
        AbstractC0116Ce.m476e(str, "<this>");
        return m2449i(str, 10);
    }

    public static final Long m2449i(String str, int i) {
        boolean z;
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC2410u4.m9933a(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        int i2 = 0;
        char cCharAt = str.charAt(0);
        long j = -9223372036854775807L;
        if (AbstractC0116Ce.m477f(cCharAt, 48) < 0) {
            z = true;
            if (length == 1) {
                return null;
            }
            if (cCharAt == '-') {
                j = Long.MIN_VALUE;
                i2 = 1;
            } else {
                if (cCharAt != '+') {
                    return null;
                }
                z = false;
                i2 = 1;
            }
        } else {
            z = false;
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        long j4 = -256204778801521550L;
        while (i2 < length) {
            int iM9934b = AbstractC2410u4.m9934b(str.charAt(i2), i);
            if (iM9934b < 0) {
                return null;
            }
            if (j3 < j4) {
                if (j4 == j2) {
                    j4 = j / i;
                    if (j3 < j4) {
                    }
                }
                return null;
            }
            long j5 = j3 * i;
            long j6 = iM9934b;
            if (j5 < j + j6) {
                return null;
            }
            j3 = j5 - j6;
            i2++;
            j2 = -256204778801521550L;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }
}
