package p000;

/* loaded from: classes.dex */
public final class C0996Vl extends AbstractC0217En {

    public final short f2987c;

    public final short f2988d;

    public C0996Vl(AbstractC0217En abstractC0217En, int i, int i2) {
        super(abstractC0217En);
        this.f2987c = (short) i;
        this.f2988d = (short) i2;
    }

    @Override
    public void mo848c(C0233F2 c0233f2, byte[] bArr) {
        c0233f2.m1185c(this.f2987c, this.f2988d);
    }

    public String toString() {
        short s = this.f2987c;
        short s2 = this.f2988d;
        return "<" + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f2988d)).substring(1) + '>';
    }
}
