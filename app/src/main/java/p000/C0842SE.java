package p000;

/* loaded from: classes.dex */
public final class C0842SE implements InterfaceC1725fE {

    public final InterfaceC1912jE f2609a;

    public final String f2610b;

    public final Object[] f2611c;

    public final int f2612d;

    public C0842SE(InterfaceC1912jE interfaceC1912jE, String str, Object[] objArr) {
        this.f2609a = interfaceC1912jE;
        this.f2610b = str;
        this.f2611c = objArr;
        char cCharAt = str.charAt(0);
        if (cCharAt < 55296) {
            this.f2612d = cCharAt;
            return;
        }
        int i = cCharAt & 8191;
        int i2 = 13;
        int i3 = 1;
        while (true) {
            int i4 = i3 + 1;
            char cCharAt2 = str.charAt(i3);
            if (cCharAt2 < 55296) {
                this.f2612d = i | (cCharAt2 << i2);
                return;
            } else {
                i |= (cCharAt2 & 8191) << i2;
                i2 += 13;
                i3 = i4;
            }
        }
    }

    @Override
    public final InterfaceC1912jE mo4019a() {
        return this.f2609a;
    }

    @Override
    public final EnumC0153DE mo4020b() {
        int i = this.f2612d;
        return (i & 1) != 0 ? EnumC0153DE.PROTO2 : (i & 4) == 4 ? EnumC0153DE.EDITIONS : EnumC0153DE.PROTO3;
    }

    @Override
    public final boolean mo4021c() {
        return (this.f2612d & 2) == 2;
    }

    public final String m4022d() {
        return this.f2610b;
    }

    public final Object[] m4023e() {
        return this.f2611c;
    }
}
