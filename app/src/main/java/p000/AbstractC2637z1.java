package p000;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractC2637z1 extends AbstractC2591y1 {
    public static List m10981c(Object[] objArr) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        List listM181a = AbstractC0048B1.m181a(objArr);
        AbstractC0116Ce.m475d(listM181a, "asList(this)");
        return listM181a;
    }

    public static byte[] m10982d(byte[] bArr, byte[] bArr2, int i, int i2, int i3) {
        AbstractC0116Ce.m476e(bArr, "<this>");
        AbstractC0116Ce.m476e(bArr2, "destination");
        System.arraycopy(bArr, i2, bArr2, i, i3 - i2);
        return bArr2;
    }

    public static final Object[] m10983e(Object[] objArr, Object[] objArr2, int i, int i2, int i3) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        AbstractC0116Ce.m476e(objArr2, "destination");
        System.arraycopy(objArr, i2, objArr2, i, i3 - i2);
        return objArr2;
    }

    public static byte[] m10984f(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = bArr.length;
        }
        return m10982d(bArr, bArr2, i, i2, i3);
    }

    public static Object[] m10985g(Object[] objArr, Object[] objArr2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i = 0;
        }
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = objArr.length;
        }
        return m10983e(objArr, objArr2, i, i2, i3);
    }

    public static byte[] m10986h(byte[] bArr, int i, int i2) {
        AbstractC0116Ce.m476e(bArr, "<this>");
        AbstractC2545x1.m10625b(i2, bArr.length);
        byte[] bArrCopyOfRange = Arrays.copyOfRange(bArr, i, i2);
        AbstractC0116Ce.m475d(bArrCopyOfRange, "copyOfRange(this, fromIndex, toIndex)");
        return bArrCopyOfRange;
    }

    public static void m10987i(Object[] objArr, Object obj, int i, int i2) {
        AbstractC0116Ce.m476e(objArr, "<this>");
        Arrays.fill(objArr, i, i2, obj);
    }

    public static void m10988j(Object[] objArr, Object obj, int i, int i2, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = objArr.length;
        }
        m10987i(objArr, obj, i, i2);
    }
}
