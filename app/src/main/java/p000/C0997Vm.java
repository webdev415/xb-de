package p000;

/* loaded from: classes.dex */
public class C0997Vm {

    public static final C0997Vm[] f2989i;

    public static C0997Vm[] f2990j;

    public final boolean f2991a;

    public final int f2992b;

    public final int f2993c;

    public final int f2994d;

    public final int f2995e;

    public final int f2996f;

    public final int f2997g;

    public final int f2998h;

    static {
        C0997Vm[] c0997VmArr = {new C0997Vm(false, 3, 5, 8, 8, 1), new C0997Vm(false, 5, 7, 10, 10, 1), new C0997Vm(true, 5, 7, 16, 6, 1), new C0997Vm(false, 8, 10, 12, 12, 1), new C0997Vm(true, 10, 11, 14, 6, 2), new C0997Vm(false, 12, 12, 14, 14, 1), new C0997Vm(true, 16, 14, 24, 10, 1), new C0997Vm(false, 18, 14, 16, 16, 1), new C0997Vm(false, 22, 18, 18, 18, 1), new C0997Vm(true, 22, 18, 16, 10, 2), new C0997Vm(false, 30, 20, 20, 20, 1), new C0997Vm(true, 32, 24, 16, 14, 2), new C0997Vm(false, 36, 24, 22, 22, 1), new C0997Vm(false, 44, 28, 24, 24, 1), new C0997Vm(true, 49, 28, 22, 14, 2), new C0997Vm(false, 62, 36, 14, 14, 4), new C0997Vm(false, 86, 42, 16, 16, 4), new C0997Vm(false, 114, 48, 18, 18, 4), new C0997Vm(false, 144, 56, 20, 20, 4), new C0997Vm(false, 174, 68, 22, 22, 4), new C0997Vm(false, 204, 84, 24, 24, 4, 102, 42), new C0997Vm(false, 280, 112, 14, 14, 16, 140, 56), new C0997Vm(false, 368, 144, 16, 16, 16, 92, 36), new C0997Vm(false, 456, 192, 18, 18, 16, 114, 48), new C0997Vm(false, 576, 224, 20, 20, 16, 144, 56), new C0997Vm(false, 696, 272, 22, 22, 16, 174, 68), new C0997Vm(false, 816, 336, 24, 24, 16, 136, 56), new C0997Vm(false, 1050, 408, 18, 18, 36, 175, 68), new C0997Vm(false, 1304, 496, 20, 20, 36, 163, 62), new C2090n7()};
        f2989i = c0997VmArr;
        f2990j = c0997VmArr;
    }

    public C0997Vm(boolean z, int i, int i2, int i3, int i4, int i5) {
        this(z, i, i2, i3, i4, i5, i, i2);
    }

    public static C0997Vm m4424l(int i, EnumC1043Wm enumC1043Wm, AbstractC0882T8 abstractC0882T8, AbstractC0882T8 abstractC0882T82, boolean z) {
        for (C0997Vm c0997Vm : f2990j) {
            if (!(enumC1043Wm == EnumC1043Wm.FORCE_SQUARE && c0997Vm.f2991a) && ((enumC1043Wm != EnumC1043Wm.FORCE_RECTANGLE || c0997Vm.f2991a) && i <= c0997Vm.f2992b)) {
                return c0997Vm;
            }
        }
        if (z) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i)));
        }
        return null;
    }

    public final int m4425a() {
        return this.f2992b;
    }

    public int mo4426b(int i) {
        return this.f2997g;
    }

    public final int m4427c() {
        return this.f2993c;
    }

    public final int m4428d(int i) {
        return this.f2998h;
    }

    public final int m4429e() {
        int i = this.f2996f;
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
            if (i != 2 && i != 4) {
                if (i == 16) {
                    return 4;
                }
                if (i == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i2;
    }

    public int mo4430f() {
        return this.f2992b / this.f2997g;
    }

    public final int m4431g() {
        return m4435k() * this.f2995e;
    }

    public final int m4432h() {
        return m4429e() * this.f2994d;
    }

    public final int m4433i() {
        return m4431g() + (m4435k() << 1);
    }

    public final int m4434j() {
        return m4432h() + (m4429e() << 1);
    }

    public final int m4435k() {
        int i = this.f2996f;
        if (i == 1 || i == 2) {
            return 1;
        }
        if (i == 4) {
            return 2;
        }
        if (i == 16) {
            return 4;
        }
        if (i == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2991a ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.f2994d);
        sb.append('x');
        sb.append(this.f2995e);
        sb.append(", symbol size ");
        sb.append(m4434j());
        sb.append('x');
        sb.append(m4433i());
        sb.append(", symbol data size ");
        sb.append(m4432h());
        sb.append('x');
        sb.append(m4431g());
        sb.append(", codewords ");
        sb.append(this.f2992b);
        sb.append('+');
        sb.append(this.f2993c);
        return sb.toString();
    }

    public C0997Vm(boolean z, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        this.f2991a = z;
        this.f2992b = i;
        this.f2993c = i2;
        this.f2994d = i3;
        this.f2995e = i4;
        this.f2996f = i5;
        this.f2997g = i6;
        this.f2998h = i7;
    }
}
