package p000;

public abstract class AbstractC0672Oi extends Thread {

    public String f2052l = null;

    public int f2053m = 0;

    public static void m3426a(byte[] bArr, int i, int i2) {
        byte bM10590d = C2525wi.m10587c().m10590d();
        if (bM10590d >= 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr[i3] = (byte) (bArr[i3] ^ bM10590d);
            }
        }
    }

    public static void m3427b(byte[] bArr, int i, int i2) {
        byte bM10590d = C2525wi.m10587c().m10590d();
        if (bM10590d >= 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                bArr[i3] = (byte) (bArr[i3] ^ bM10590d);
            }
        }
    }

    public int m3428c() {
        return this.f2053m;
    }

    public void m3429d(int i) {
        this.f2053m = i;
    }

    public void m3430e(String str) {
        this.f2052l = str;
    }
}
