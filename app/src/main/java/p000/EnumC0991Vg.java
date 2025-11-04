package p000;

public enum EnumC0991Vg {
    TERMINATOR(new int[]{0, 0, 0}, 0),
    NUMERIC(new int[]{10, 12, 14}, 1),
    ALPHANUMERIC(new int[]{9, 11, 13}, 2),
    STRUCTURED_APPEND(new int[]{0, 0, 0}, 3),
    BYTE(new int[]{8, 16, 16}, 4),
    ECI(new int[]{0, 0, 0}, 7),
    KANJI(new int[]{8, 10, 12}, 8),
    FNC1_FIRST_POSITION(new int[]{0, 0, 0}, 5),
    FNC1_SECOND_POSITION(new int[]{0, 0, 0}, 9),
    HANZI(new int[]{8, 10, 12}, 13);


    public final int[] f2981l;

    public final int f2982m;

    EnumC0991Vg(int[] iArr, int i) {
        this.f2981l = iArr;
        this.f2982m = i;
    }

    public static EnumC0991Vg m4405c(int i) {
        if (i == 0) {
            return TERMINATOR;
        }
        if (i == 1) {
            return NUMERIC;
        }
        if (i == 2) {
            return ALPHANUMERIC;
        }
        if (i == 3) {
            return STRUCTURED_APPEND;
        }
        if (i == 4) {
            return BYTE;
        }
        if (i == 5) {
            return FNC1_FIRST_POSITION;
        }
        if (i == 7) {
            return ECI;
        }
        if (i == 8) {
            return KANJI;
        }
        if (i == 9) {
            return FNC1_SECOND_POSITION;
        }
        if (i == 13) {
            return HANZI;
        }
        throw new IllegalArgumentException();
    }

    public int m4406e() {
        return this.f2982m;
    }

    public int m4407g(C0126Co c0126Co) {
        int iM519j = c0126Co.m519j();
        return this.f2981l[iM519j <= 9 ? (char) 0 : iM519j <= 26 ? (char) 1 : (char) 2];
    }
}
