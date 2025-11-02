package p000;

import java.lang.reflect.Array;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class C0050B3 {

    public final byte[][] f117a;

    public final int f118b;

    public final int f119c;

    public C0050B3(int i, int i2) {
        this.f117a = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, i2, i);
        this.f118b = i;
        this.f119c = i2;
    }

    public void m189a(byte b) {
        for (byte[] bArr : this.f117a) {
            Arrays.fill(bArr, b);
        }
    }

    public byte m190b(int i, int i2) {
        return this.f117a[i2][i];
    }

    public byte[][] m191c() {
        return this.f117a;
    }

    public int m192d() {
        return this.f119c;
    }

    public int m193e() {
        return this.f118b;
    }

    public void m194f(int i, int i2, int i3) {
        this.f117a[i2][i] = (byte) i3;
    }

    public void m195g(int i, int i2, boolean z) {
        this.f117a[i2][i] = z ? (byte) 1 : (byte) 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f118b * 2 * this.f119c) + 2);
        for (int i = 0; i < this.f119c; i++) {
            byte[] bArr = this.f117a[i];
            for (int i2 = 0; i2 < this.f118b; i2++) {
                byte b = bArr[i2];
                sb.append(b != 0 ? b != 1 ? "  " : " 1" : " 0");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
