package p000;

public abstract class AbstractC1889ir {

    public static final int[] f5830a;

    static {
        int[] iArr = new int[EnumC0333HA.values().length];
        f5830a = iArr;
        try {
            iArr[EnumC0333HA.UNINITIALIZED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f5830a[EnumC0333HA.POLICY.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f5830a[EnumC0333HA.DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f5830a[EnumC0333HA.GRANTED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
