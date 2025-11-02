package p000;

import p000.C0550Ly;

/* loaded from: classes.dex */
public abstract class AbstractC0045Az {

    public static final int[] f101a;

    static {
        int[] iArr = new int[C0550Ly.b.values().length];
        f101a = iArr;
        try {
            iArr[C0550Ly.b.STRING.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f101a[C0550Ly.b.NUMBER.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f101a[C0550Ly.b.BOOLEAN.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f101a[C0550Ly.b.STATEMENT.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f101a[C0550Ly.b.UNKNOWN.ordinal()] = 5;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
