package p000;

import p000.C2078mw;
import p000.C2171ow;

/* loaded from: classes.dex */
public abstract class AbstractC0617NI {

    public static final int[] f1924a;

    public static final int[] f1925b;

    static {
        int[] iArr = new int[C2078mw.b.values().length];
        f1925b = iArr;
        try {
            iArr[C2078mw.b.LESS_THAN.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f1925b[C2078mw.b.GREATER_THAN.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f1925b[C2078mw.b.EQUAL.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f1925b[C2078mw.b.BETWEEN.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[C2171ow.b.values().length];
        f1924a = iArr2;
        try {
            iArr2[C2171ow.b.REGEXP.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f1924a[C2171ow.b.BEGINS_WITH.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f1924a[C2171ow.b.ENDS_WITH.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f1924a[C2171ow.b.PARTIAL.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        try {
            f1924a[C2171ow.b.EXACT.ordinal()] = 5;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f1924a[C2171ow.b.IN_LIST.ordinal()] = 6;
        } catch (NoSuchFieldError unused10) {
        }
    }
}
