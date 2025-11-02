package p000;

/* loaded from: classes.dex */
public final class C0931UB extends AbstractC1023WB {

    public final byte[] f2833c;

    public int f2834d;

    public int f2835e;

    public int f2836f;

    public int f2837g;

    public int f2838h;

    public C0931UB(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.f2838h = Integer.MAX_VALUE;
        this.f2833c = bArr;
        this.f2834d = i2 + i;
        this.f2836f = i;
        this.f2837g = i;
    }

    @Override
    public final int mo4202a(int i) throws C1771gD {
        if (i < 0) {
            throw C1771gD.m7705d();
        }
        int iMo4203d = i + mo4203d();
        if (iMo4203d < 0) {
            throw C1771gD.m7706e();
        }
        int i2 = this.f2838h;
        if (iMo4203d > i2) {
            throw C1771gD.m7708g();
        }
        this.f2838h = iMo4203d;
        m4204f();
        return i2;
    }

    @Override
    public final int mo4203d() {
        return this.f2836f - this.f2837g;
    }

    public final void m4204f() {
        int i = this.f2834d + this.f2835e;
        this.f2834d = i;
        int i2 = i - this.f2837g;
        int i3 = this.f2838h;
        if (i2 <= i3) {
            this.f2835e = 0;
            return;
        }
        int i4 = i2 - i3;
        this.f2835e = i4;
        this.f2834d = i - i4;
    }
}
