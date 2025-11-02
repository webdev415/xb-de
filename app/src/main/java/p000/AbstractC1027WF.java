package p000;

public abstract class AbstractC1027WF {

    public static final int[] f3046a;

    static {
        int[] iArr = new int[EnumC0333HA.values().length];
        f3046a = iArr;
        try {
            iArr[EnumC0333HA.POLICY.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3046a[EnumC0333HA.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f3046a[EnumC0333HA.DENIED.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3046a[EnumC0333HA.UNINITIALIZED.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
    }
}
