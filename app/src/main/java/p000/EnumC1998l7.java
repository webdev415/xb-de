package p000;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* loaded from: classes.dex */
public abstract class EnumC1998l7 {

    public static final EnumC1998l7 f6053l;

    public static final EnumC1998l7 f6054m;

    public static final EnumC1998l7 f6055n;

    public static final EnumC1998l7 f6056o;

    public static final EnumC1998l7 f6057p;

    public static final EnumC1998l7 f6058q;

    public static final EnumC1998l7 f6059r;

    public static final EnumC1998l7 f6060s;

    public static final EnumC1998l7[] f6061t;

    public enum a extends EnumC1998l7 {
        public a(String str, int i) {
            super(str, i, null);
        }

        @Override
        public boolean mo8358c(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    }

    static {
        a aVar = new a("DATA_MASK_000", 0);
        f6053l = aVar;
        EnumC1998l7 enumC1998l7 = new EnumC1998l7("DATA_MASK_001", 1) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (i & 1) == 0;
            }
        };
        f6054m = enumC1998l7;
        EnumC1998l7 enumC1998l72 = new EnumC1998l7("DATA_MASK_010", 2) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return i2 % 3 == 0;
            }
        };
        f6055n = enumC1998l72;
        EnumC1998l7 enumC1998l73 = new EnumC1998l7("DATA_MASK_011", 3) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (i + i2) % 3 == 0;
            }
        };
        f6056o = enumC1998l73;
        EnumC1998l7 enumC1998l74 = new EnumC1998l7("DATA_MASK_100", 4) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (((i / 2) + (i2 / 3)) & 1) == 0;
            }
        };
        f6057p = enumC1998l74;
        EnumC1998l7 enumC1998l75 = new EnumC1998l7("DATA_MASK_101", 5) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (i * i2) % 6 == 0;
            }
        };
        f6058q = enumC1998l75;
        EnumC1998l7 enumC1998l76 = new EnumC1998l7("DATA_MASK_110", 6) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (i * i2) % 6 < 3;
            }
        };
        f6059r = enumC1998l76;
        EnumC1998l7 enumC1998l77 = new EnumC1998l7("DATA_MASK_111", 7) {
            {
                a aVar2 = null;
            }

            @Override
            public boolean mo8358c(int i, int i2) {
                return (((i + i2) + ((i * i2) % 3)) & 1) == 0;
            }
        };
        f6060s = enumC1998l77;
        f6061t = new EnumC1998l7[]{aVar, enumC1998l7, enumC1998l72, enumC1998l73, enumC1998l74, enumC1998l75, enumC1998l76, enumC1998l77};
    }

    public EnumC1998l7(String str, int i) {
    }

    public static EnumC1998l7 valueOf(String str) {
        return (EnumC1998l7) Enum.valueOf(EnumC1998l7.class, str);
    }

    public static EnumC1998l7[] values() {
        return (EnumC1998l7[]) f6061t.clone();
    }

    public abstract boolean mo8358c(int i, int i2);

    public final void m8359e(C0325H2 c0325h2, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (mo8358c(i2, i3)) {
                    c0325h2.m1492d(i3, i2);
                }
            }
        }
    }

    public EnumC1998l7(String str, int i, a aVar) {
        this(str, i);
    }
}
