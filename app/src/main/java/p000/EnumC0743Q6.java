package p000;

/* loaded from: classes.dex */
public enum EnumC0743Q6 {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public class a {

        public static final int[] f2203a;

        static {
            int[] iArr = new int[EnumC0743Q6.values().length];
            try {
                iArr[EnumC0743Q6.DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[EnumC0743Q6.ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[EnumC0743Q6.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[EnumC0743Q6.LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f2203a = iArr;
        }
    }

    public final void m3630e(InterfaceC1920jc interfaceC1920jc, Object obj, InterfaceC2458v6 interfaceC2458v6) {
        int i = a.f2203a[ordinal()];
        if (i == 1) {
            AbstractC1622d4.m7299d(interfaceC1920jc, obj, interfaceC2458v6, null, 4, null);
            return;
        }
        if (i == 2) {
            AbstractC2596y6.m10835a(interfaceC1920jc, obj, interfaceC2458v6);
        } else if (i == 3) {
            AbstractC1932jo.m8204a(interfaceC1920jc, obj, interfaceC2458v6);
        } else if (i != 4) {
            throw new C2155oh();
        }
    }

    public final boolean m3631g() {
        return this == LAZY;
    }
}
