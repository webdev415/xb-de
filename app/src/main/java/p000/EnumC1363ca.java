package p000;

/* loaded from: classes.dex */
public enum EnumC1363ca {
    L(1),
    M(0),
    Q(3),
    H(2);


    public static final EnumC1363ca[] f3954q;

    public final int f3956l;

    static {
        EnumC1363ca enumC1363ca = L;
        EnumC1363ca enumC1363ca2 = M;
        EnumC1363ca enumC1363ca3 = Q;
        f3954q = new EnumC1363ca[]{enumC1363ca2, enumC1363ca, H, enumC1363ca3};
    }

    EnumC1363ca(int i) {
        this.f3956l = i;
    }

    public static EnumC1363ca m5856c(int i) {
        if (i >= 0) {
            EnumC1363ca[] enumC1363caArr = f3954q;
            if (i < enumC1363caArr.length) {
                return enumC1363caArr[i];
            }
        }
        throw new IllegalArgumentException();
    }

    public int m5857e() {
        return this.f3956l;
    }
}
