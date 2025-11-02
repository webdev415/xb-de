package p000;

/* loaded from: classes.dex */
public abstract class AbstractC0930UA implements InterfaceC1819hE {
    public abstract Object clone();

    public abstract AbstractC0930UA mo3520e(byte[] bArr, int i, int i2);

    public abstract AbstractC0930UA mo3521f(byte[] bArr, int i, int i2, C1957kC c1957kC);

    @Override
    public final InterfaceC1819hE mo4200l(byte[] bArr, C1957kC c1957kC) {
        return mo3521f(bArr, 0, bArr.length, c1957kC);
    }

    @Override
    public final InterfaceC1819hE mo4201p(byte[] bArr) {
        return mo3520e(bArr, 0, bArr.length);
    }
}
