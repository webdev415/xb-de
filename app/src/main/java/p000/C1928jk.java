package p000;

public final class C1928jk extends AbstractC0536Lk {

    public final String f5961m;

    public final long f5962n;

    public final InterfaceC2547x3 f5963o;

    public C1928jk(String str, long j, InterfaceC2547x3 interfaceC2547x3) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        this.f5961m = str;
        this.f5962n = j;
        this.f5963o = interfaceC2547x3;
    }

    @Override
    public long mo2711i() {
        return this.f5962n;
    }

    @Override
    public C0716Pg mo2712j() {
        String str = this.f5961m;
        if (str != null) {
            return C0716Pg.f2145g.m3572b(str);
        }
        return null;
    }

    @Override
    public InterfaceC2547x3 mo2713k() {
        return this.f5963o;
    }
}
