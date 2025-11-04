package p000;

public abstract class AbstractC0987Vc {
    public static int m4388a(int i, double d) {
        int iMax = Math.max(i, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        if (iMax <= ((int) (d * iHighestOneBit))) {
            return iHighestOneBit;
        }
        int i2 = iHighestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    public static int m4389b(int i) {
        return (int) (Integer.rotateLeft((int) (i * (-862048943)), 15) * 461845907);
    }

    public static int m4390c(Object obj) {
        return m4389b(obj == null ? 0 : obj.hashCode());
    }
}
