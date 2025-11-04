package p000;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'n' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
public final class EnumC1958kD {

    public static final EnumC1958kD f5981m;

    public static final EnumC1958kD f5982n;

    public static final EnumC1958kD f5983o;

    public static final EnumC1958kD f5984p;

    public static final EnumC1958kD f5985q;

    public static final EnumC1958kD f5986r;

    public static final EnumC1958kD f5987s;

    public static final EnumC1958kD f5988t;

    public static final EnumC1958kD f5989u;

    public static final EnumC1958kD f5990v;

    public static final EnumC1958kD[] f5991w;

    public final Class f5992l;

    static {
        EnumC1958kD enumC1958kD = new EnumC1958kD("VOID", 0, Void.class, Void.class, null);
        f5981m = enumC1958kD;
        Class cls = Integer.TYPE;
        EnumC1958kD enumC1958kD2 = new EnumC1958kD("INT", 1, cls, Integer.class, 0);
        f5982n = enumC1958kD2;
        EnumC1958kD enumC1958kD3 = new EnumC1958kD("LONG", 2, Long.TYPE, Long.class, 0L);
        f5983o = enumC1958kD3;
        EnumC1958kD enumC1958kD4 = new EnumC1958kD("FLOAT", 3, Float.TYPE, Float.class, Float.valueOf(0.0f));
        f5984p = enumC1958kD4;
        EnumC1958kD enumC1958kD5 = new EnumC1958kD("DOUBLE", 4, Double.TYPE, Double.class, Double.valueOf(0.0d));
        f5985q = enumC1958kD5;
        EnumC1958kD enumC1958kD6 = new EnumC1958kD("BOOLEAN", 5, Boolean.TYPE, Boolean.class, Boolean.FALSE);
        f5986r = enumC1958kD6;
        EnumC1958kD enumC1958kD7 = new EnumC1958kD("STRING", 6, String.class, String.class, "");
        f5987s = enumC1958kD7;
        EnumC1958kD enumC1958kD8 = new EnumC1958kD("BYTE_STRING", 7, AbstractC2233qB.class, AbstractC2233qB.class, AbstractC2233qB.f6688m);
        f5988t = enumC1958kD8;
        EnumC1958kD enumC1958kD9 = new EnumC1958kD("ENUM", 8, cls, Integer.class, null);
        f5989u = enumC1958kD9;
        EnumC1958kD enumC1958kD10 = new EnumC1958kD("MESSAGE", 9, Object.class, Object.class, null);
        f5990v = enumC1958kD10;
        f5991w = new EnumC1958kD[]{enumC1958kD, enumC1958kD2, enumC1958kD3, enumC1958kD4, enumC1958kD5, enumC1958kD6, enumC1958kD7, enumC1958kD8, enumC1958kD9, enumC1958kD10};
    }

    public EnumC1958kD(String str, int i, Class cls, Class cls2, Object obj) {
        this.f5992l = cls2;
    }

    public static EnumC1958kD[] values() {
        return (EnumC1958kD[]) f5991w.clone();
    }

    public final Class m8238c() {
        return this.f5992l;
    }
}
