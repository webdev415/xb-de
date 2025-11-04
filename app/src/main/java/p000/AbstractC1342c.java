package p000;

public abstract class AbstractC1342c {
    public static final boolean m5684a(byte[] bArr, int i, byte[] bArr2, int i2, int i3) {
        AbstractC0116Ce.m476e(bArr, "a");
        AbstractC0116Ce.m476e(bArr2, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (bArr[i4 + i] != bArr2[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void m5685b(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int m5686c(int i) {
        return ((i & 255) << 24) | (((0xFF000000) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final short m5687d(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final String m5688e(byte b) {
        return new String(new char[]{AbstractC0142D3.m608f()[(b >> 4) & 15], AbstractC0142D3.m608f()[b & 15]});
    }

    public static final String m5689f(int i) {
        int i2 = 0;
        if (i == 0) {
            return "0";
        }
        char[] cArr = {AbstractC0142D3.m608f()[(i >> 28) & 15], AbstractC0142D3.m608f()[(i >> 24) & 15], AbstractC0142D3.m608f()[(i >> 20) & 15], AbstractC0142D3.m608f()[(i >> 16) & 15], AbstractC0142D3.m608f()[(i >> 12) & 15], AbstractC0142D3.m608f()[(i >> 8) & 15], AbstractC0142D3.m608f()[(i >> 4) & 15], AbstractC0142D3.m608f()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return new String(cArr, i2, 8 - i2);
    }
}
