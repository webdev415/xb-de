package p000;

public abstract class AbstractC1784gg {

    public final int f5636a;

    public final int f5637b;

    public AbstractC1784gg(int i, int i2) {
        this.f5636a = i;
        this.f5637b = i2;
    }

    public final int m7736a() {
        return this.f5637b;
    }

    public abstract byte[] mo1969b();

    public abstract byte[] mo1970c(int i, byte[] bArr);

    public final int m7737d() {
        return this.f5636a;
    }

    public AbstractC1784gg mo1971e() {
        return new C0438Je(this);
    }

    public boolean mo1972f() {
        return false;
    }

    public AbstractC1784gg mo1973g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f5636a;
        byte[] bArrMo1970c = new byte[i];
        StringBuilder sb = new StringBuilder(this.f5637b * (i + 1));
        for (int i2 = 0; i2 < this.f5637b; i2++) {
            bArrMo1970c = mo1970c(i2, bArrMo1970c);
            for (int i3 = 0; i3 < this.f5636a; i3++) {
                int i4 = bArrMo1970c[i3] & 255;
                sb.append(i4 < 64 ? '#' : i4 < 128 ? '+' : i4 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
