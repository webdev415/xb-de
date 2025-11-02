package p000;

public final class C2656zb {

    public static final int[][] f8249c = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    public final EnumC1363ca f8250a;

    public final byte f8251b;

    public C2656zb(int i) {
        this.f8250a = EnumC1363ca.m5856c((i >> 3) & 3);
        this.f8251b = (byte) (i & 7);
    }

    public static C2656zb m11004a(int i, int i2) {
        C2656zb c2656zbM11005b = m11005b(i, i2);
        return c2656zbM11005b != null ? c2656zbM11005b : m11005b(i ^ 21522, i2 ^ 21522);
    }

    public static C2656zb m11005b(int i, int i2) {
        int iM11006e;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f8249c) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new C2656zb(iArr[1]);
            }
            int iM11006e2 = m11006e(i, i5);
            if (iM11006e2 < i3) {
                i4 = iArr[1];
                i3 = iM11006e2;
            }
            if (i != i2 && (iM11006e = m11006e(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iM11006e;
            }
        }
        if (i3 <= 3) {
            return new C2656zb(i4);
        }
        return null;
    }

    public static int m11006e(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public byte m11007c() {
        return this.f8251b;
    }

    public EnumC1363ca m11008d() {
        return this.f8250a;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2656zb)) {
            return false;
        }
        C2656zb c2656zb = (C2656zb) obj;
        return this.f8250a == c2656zb.f8250a && this.f8251b == c2656zb.f8251b;
    }

    public int hashCode() {
        return (this.f8250a.ordinal() << 3) | this.f8251b;
    }
}
