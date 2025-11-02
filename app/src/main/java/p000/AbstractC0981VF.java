package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0981VF {
    public static void m4375a(byte b, byte b2, byte b3, byte b4, char[] cArr, int i) throws C1771gD {
        if (m4379e(b2) || (((b << 28) + (b2 + 112)) >> 30) != 0 || m4379e(b3) || m4379e(b4)) {
            throw C1771gD.m7704c();
        }
        int i2 = ((b & 7) << 18) | ((b2 & 63) << 12) | ((b3 & 63) << 6) | (b4 & 63);
        cArr[i] = (char) ((i2 >>> 10) + 55232);
        cArr[i + 1] = (char) ((i2 & 1023) + 56320);
    }

    public static void m4376b(byte b, byte b2, byte b3, char[] cArr, int i) throws C1771gD {
        if (m4379e(b2) || ((b == -32 && b2 < -96) || ((b == -19 && b2 >= -96) || m4379e(b3)))) {
            throw C1771gD.m7704c();
        }
        cArr[i] = (char) (((b & 15) << 12) | ((b2 & 63) << 6) | (b3 & 63));
    }

    public static void m4377c(byte b, byte b2, char[] cArr, int i) throws C1771gD {
        if (b < -62 || m4379e(b2)) {
            throw C1771gD.m7704c();
        }
        cArr[i] = (char) (((b & 31) << 6) | (b2 & 63));
    }

    public static void m4378d(byte b, char[] cArr, int i) {
        cArr[i] = (char) b;
    }

    public static boolean m4379e(byte b) {
        return b > -65;
    }
}
