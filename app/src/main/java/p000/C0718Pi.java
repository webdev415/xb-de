package p000;

public final class C0718Pi extends AbstractC1784gg {

    public final byte[] f2150c;

    public final int f2151d;

    public final int f2152e;

    public final int f2153f;

    public final int f2154g;

    public C0718Pi(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, boolean z) {
        super(i5, i6);
        if (i3 + i5 > i || i4 + i6 > i2) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.f2150c = bArr;
        this.f2151d = i;
        this.f2152e = i2;
        this.f2153f = i3;
        this.f2154g = i4;
        if (z) {
            m3574h(i5, i6);
        }
    }

    @Override
    public byte[] mo1969b() {
        int iM7737d = m7737d();
        int iM7736a = m7736a();
        int i = this.f2151d;
        if (iM7737d == i && iM7736a == this.f2152e) {
            return this.f2150c;
        }
        int i2 = iM7737d * iM7736a;
        byte[] bArr = new byte[i2];
        int i3 = (this.f2154g * i) + this.f2153f;
        if (iM7737d == i) {
            System.arraycopy(this.f2150c, i3, bArr, 0, i2);
            return bArr;
        }
        for (int i4 = 0; i4 < iM7736a; i4++) {
            System.arraycopy(this.f2150c, i3, bArr, i4 * iM7737d, iM7737d);
            i3 += this.f2151d;
        }
        return bArr;
    }

    @Override
    public byte[] mo1970c(int i, byte[] bArr) {
        if (i < 0 || i >= m7736a()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i)));
        }
        int iM7737d = m7737d();
        if (bArr == null || bArr.length < iM7737d) {
            bArr = new byte[iM7737d];
        }
        System.arraycopy(this.f2150c, ((i + this.f2154g) * this.f2151d) + this.f2153f, bArr, 0, iM7737d);
        return bArr;
    }

    public final void m3574h(int i, int i2) {
        byte[] bArr = this.f2150c;
        int i3 = (this.f2154g * this.f2151d) + this.f2153f;
        int i4 = 0;
        while (i4 < i2) {
            int i5 = (i / 2) + i3;
            int i6 = (i3 + i) - 1;
            int i7 = i3;
            while (i7 < i5) {
                byte b = bArr[i7];
                bArr[i7] = bArr[i6];
                bArr[i6] = b;
                i7++;
                i6--;
            }
            i4++;
            i3 += this.f2151d;
        }
    }
}
