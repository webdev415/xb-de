package p000;

public final class C2601yB extends C0564MB {

    public final int f8059p;

    public final int f8060q;

    public C2601yB(byte[] bArr, int i, int i2) {
        super(bArr);
        AbstractC2233qB.m9105h(i, i + i2, bArr.length);
        this.f8059p = i;
        this.f8060q = i2;
    }

    @Override
    public final byte mo2839d(int i) {
        int iMo2843s = mo2843s();
        if (((iMo2843s - (i + 1)) | i) >= 0) {
            return this.f1762o[this.f8059p + i];
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        }
        throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + iMo2843s);
    }

    @Override
    public final byte mo2842r(int i) {
        return this.f1762o[this.f8059p + i];
    }

    @Override
    public final int mo2843s() {
        return this.f8060q;
    }

    @Override
    public final int mo2845w() {
        return this.f8059p;
    }
}
