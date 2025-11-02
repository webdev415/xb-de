package p000;

public abstract class AbstractC2157oj {
    public static final int m8966a(int i, int i2, int i3) {
        return m8968c(m8968c(i, i3) - m8968c(i2, i3), i3);
    }

    public static final int m8967b(int i, int i2, int i3) {
        if (i3 > 0) {
            return i >= i2 ? i2 : i2 - m8966a(i2, i, i3);
        }
        if (i3 < 0) {
            return i <= i2 ? i2 : i2 + m8966a(i, i2, -i3);
        }
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int m8968c(int i, int i2) {
        int i3 = i % i2;
        return i3 >= 0 ? i3 : i3 + i2;
    }
}
