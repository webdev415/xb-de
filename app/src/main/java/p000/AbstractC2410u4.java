package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2410u4 {
    public static int m9933a(int i) {
        if (new C2659ze(2, 36).m11028k(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new C2659ze(2, 36));
    }

    public static final int m9934b(char c, int i) {
        return Character.digit((int) c, i);
    }

    public static final boolean m9935c(char c) {
        return Character.isWhitespace(c) || Character.isSpaceChar(c);
    }
}
