package p000;

/* loaded from: classes.dex */
public final class C2224q2 {

    public final byte[] f6674a;

    public int f6675b = 0;

    public C2224q2(int i) {
        this.f6674a = new byte[i];
    }

    public void m9096a(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f6675b;
            this.f6675b = i3 + 1;
            m9098c(i3, z);
        }
    }

    public byte[] m9097b(int i) {
        int length = this.f6674a.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.f6674a[i2 / i];
        }
        return bArr;
    }

    public final void m9098c(int i, boolean z) {
        this.f6674a[i] = z ? (byte) 1 : (byte) 0;
    }
}
