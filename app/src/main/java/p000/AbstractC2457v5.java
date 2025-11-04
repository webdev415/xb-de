package p000;

import java.util.Arrays;

public abstract class AbstractC2457v5 {
    public static Object m10314a(int i) {
        if (i >= 2 && i <= 1073741824 && Integer.highestOneBit(i) == i) {
            return i <= 256 ? new byte[i] : i <= 65536 ? new short[i] : new int[i];
        }
        StringBuilder sb = new StringBuilder(52);
        sb.append("must be power of 2 between 2^1 and 2^30: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    public static int m10315b(int i, int i2) {
        return i & (~i2);
    }

    public static int m10316c(int i, int i2) {
        return i & i2;
    }

    public static int m10317d(int i, int i2, int i3) {
        return (i & (~i3)) | (i2 & i3);
    }

    public static int m10318e(int i) {
        return (i < 32 ? 4 : 2) * (i + 1);
    }

    public static int m10319f(Object obj, Object obj2, int i, Object obj3, int[] iArr, Object[] objArr, Object[] objArr2) {
        int i2;
        int i3;
        int iM4390c = AbstractC0987Vc.m4390c(obj);
        int i4 = iM4390c & i;
        int iM10321h = m10321h(obj3, i4);
        if (iM10321h == 0) {
            return -1;
        }
        int iM10315b = m10315b(iM4390c, i);
        int i5 = -1;
        while (true) {
            i2 = iM10321h - 1;
            i3 = iArr[i2];
            if (m10315b(i3, i) == iM10315b && AbstractC0303Gh.m1398a(obj, objArr[i2]) && (objArr2 == null || AbstractC0303Gh.m1398a(obj2, objArr2[i2]))) {
                break;
            }
            int iM10316c = m10316c(i3, i);
            if (iM10316c == 0) {
                return -1;
            }
            i5 = i2;
            iM10321h = iM10316c;
        }
        int iM10316c2 = m10316c(i3, i);
        if (i5 == -1) {
            m10322i(obj3, i4, iM10316c2);
        } else {
            iArr[i5] = m10317d(iArr[i5], iM10316c2, i);
        }
        return i2;
    }

    public static void m10320g(Object obj) {
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
    }

    public static int m10321h(Object obj, int i) {
        return obj instanceof byte[] ? ((byte[]) obj)[i] & 255 : obj instanceof short[] ? ((short[]) obj)[i] & 65535 : ((int[]) obj)[i];
    }

    public static void m10322i(Object obj, int i, int i2) {
        if (obj instanceof byte[]) {
            ((byte[]) obj)[i] = (byte) i2;
        } else if (obj instanceof short[]) {
            ((short[]) obj)[i] = (short) i2;
        } else {
            ((int[]) obj)[i] = i2;
        }
    }

    public static int m10323j(int i) {
        return Math.max(4, AbstractC0987Vc.m4388a(i + 1, 1.0d));
    }
}
