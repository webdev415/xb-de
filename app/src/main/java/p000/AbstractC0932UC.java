package p000;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class AbstractC0932UC {

    public static final Charset f2839a;

    public static final byte[] f2840b;

    static {
        Charset.forName("US-ASCII");
        f2839a = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        byte[] bArr = new byte[0];
        f2840b = bArr;
        ByteBuffer.wrap(bArr);
        AbstractC1023WB.m4466c(bArr, 0, bArr.length, false);
    }

    public static int m4205a(int i, byte[] bArr, int i2, int i3) {
        for (int i4 = i2; i4 < i2 + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public static int m4206b(long j) {
        return (int) (j ^ (j >>> 32));
    }

    public static int m4207c(boolean z) {
        return z ? 1231 : 1237;
    }

    public static int m4208d(byte[] bArr) {
        int length = bArr.length;
        int iM4205a = m4205a(length, bArr, 0, length);
        if (iM4205a == 0) {
            return 1;
        }
        return iM4205a;
    }

    public static Object m4209e(Object obj) {
        obj.getClass();
        return obj;
    }

    public static Object m4210f(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static boolean m4211g(InterfaceC1912jE interfaceC1912jE) {
        return false;
    }
}
