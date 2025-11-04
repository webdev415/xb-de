package p000;

import p000.C0410Iw;

public abstract class AbstractC1193Zy {

    public static final int[] f3478a;

    public static final int[] f3479b;

    public static final int[] f3480c;

    static {
        int[] iArr = new int[C0410Iw.d.values().length];
        f3480c = iArr;
        try {
            iArr[C0410Iw.d.DENIED.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f3480c[C0410Iw.d.GRANTED.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        int[] iArr2 = new int[C0410Iw.e.values().length];
        f3479b = iArr2;
        try {
            iArr2[C0410Iw.e.AD_STORAGE.ordinal()] = 1;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f3479b[C0410Iw.e.ANALYTICS_STORAGE.ordinal()] = 2;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f3479b[C0410Iw.e.AD_USER_DATA.ordinal()] = 3;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f3479b[C0410Iw.e.AD_PERSONALIZATION.ordinal()] = 4;
        } catch (NoSuchFieldError unused6) {
        }
        int[] iArr3 = new int[EnumC0019AI.values().length];
        f3478a = iArr3;
        try {
            iArr3[EnumC0019AI.DEBUG.ordinal()] = 1;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f3478a[EnumC0019AI.ERROR.ordinal()] = 2;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f3478a[EnumC0019AI.WARN.ordinal()] = 3;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f3478a[EnumC0019AI.VERBOSE.ordinal()] = 4;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
