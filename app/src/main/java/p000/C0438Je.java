package p000;

/* loaded from: classes.dex */
public final class C0438Je extends AbstractC1784gg {

    public final AbstractC1784gg f1363c;

    public C0438Je(AbstractC1784gg abstractC1784gg) {
        super(abstractC1784gg.m7737d(), abstractC1784gg.m7736a());
        this.f1363c = abstractC1784gg;
    }

    @Override
    public byte[] mo1969b() {
        byte[] bArrMo1969b = this.f1363c.mo1969b();
        int iM7737d = m7737d() * m7736a();
        byte[] bArr = new byte[iM7737d];
        for (int i = 0; i < iM7737d; i++) {
            bArr[i] = (byte) (255 - (bArrMo1969b[i] & 255));
        }
        return bArr;
    }

    @Override
    public byte[] mo1970c(int i, byte[] bArr) {
        byte[] bArrMo1970c = this.f1363c.mo1970c(i, bArr);
        int iM7737d = m7737d();
        for (int i2 = 0; i2 < iM7737d; i2++) {
            bArrMo1970c[i2] = (byte) (255 - (bArrMo1970c[i2] & 255));
        }
        return bArrMo1970c;
    }

    @Override
    public AbstractC1784gg mo1971e() {
        return this.f1363c;
    }

    @Override
    public boolean mo1972f() {
        return this.f1363c.mo1972f();
    }

    @Override
    public AbstractC1784gg mo1973g() {
        return new C0438Je(this.f1363c.mo1973g());
    }
}
