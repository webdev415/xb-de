package p000;

/* JADX WARN: Enum visitor error
jadx.core.utils.exceptions.JadxRuntimeException: Init of enum field 'p' uses external variables
	at jadx.core.dex.visitors.EnumVisitor.createEnumFieldByConstructor(EnumVisitor.java:451)
	at jadx.core.dex.visitors.EnumVisitor.processEnumFieldByRegister(EnumVisitor.java:395)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromFilledArray(EnumVisitor.java:324)
	at jadx.core.dex.visitors.EnumVisitor.extractEnumFieldsFromInsn(EnumVisitor.java:262)
	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:151)
	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
 */
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
public class EnumC1634dG {

    public static final EnumC1634dG f5287A;

    public static final EnumC1634dG f5288B;

    public static final EnumC1634dG f5289C;

    public static final EnumC1634dG f5290D;

    public static final EnumC1634dG f5291E;

    public static final EnumC1634dG[] f5292F;

    public static final EnumC1634dG f5293n;

    public static final EnumC1634dG f5294o;

    public static final EnumC1634dG f5295p;

    public static final EnumC1634dG f5296q;

    public static final EnumC1634dG f5297r;

    public static final EnumC1634dG f5298s;

    public static final EnumC1634dG f5299t;

    public static final EnumC1634dG f5300u;

    public static final EnumC1634dG f5301v;

    public static final EnumC1634dG f5302w;

    public static final EnumC1634dG f5303x;

    public static final EnumC1634dG f5304y;

    public static final EnumC1634dG f5305z;

    public final EnumC2560xG f5306l;

    public final int f5307m;

    static {
        EnumC1634dG enumC1634dG = new EnumC1634dG("DOUBLE", 0, EnumC2560xG.DOUBLE, 1);
        f5293n = enumC1634dG;
        EnumC1634dG enumC1634dG2 = new EnumC1634dG("FLOAT", 1, EnumC2560xG.FLOAT, 5);
        f5294o = enumC1634dG2;
        EnumC2560xG enumC2560xG = EnumC2560xG.LONG;
        EnumC1634dG enumC1634dG3 = new EnumC1634dG("INT64", 2, enumC2560xG, 0);
        f5295p = enumC1634dG3;
        EnumC1634dG enumC1634dG4 = new EnumC1634dG("UINT64", 3, enumC2560xG, 0);
        f5296q = enumC1634dG4;
        EnumC2560xG enumC2560xG2 = EnumC2560xG.INT;
        EnumC1634dG enumC1634dG5 = new EnumC1634dG("INT32", 4, enumC2560xG2, 0);
        f5297r = enumC1634dG5;
        EnumC1634dG enumC1634dG6 = new EnumC1634dG("FIXED64", 5, enumC2560xG, 1);
        f5298s = enumC1634dG6;
        EnumC1634dG enumC1634dG7 = new EnumC1634dG("FIXED32", 6, enumC2560xG2, 5);
        f5299t = enumC1634dG7;
        EnumC1634dG enumC1634dG8 = new EnumC1634dG("BOOL", 7, EnumC2560xG.BOOLEAN, 0);
        f5300u = enumC1634dG8;
        int i = 2;
        C1914jG c1914jG = new C1914jG("STRING", EnumC2560xG.STRING);
        f5301v = c1914jG;
        EnumC2560xG enumC2560xG3 = EnumC2560xG.MESSAGE;
        C2099nG c2099nG = new C2099nG("GROUP", enumC2560xG3);
        f5302w = c2099nG;
        C2284rG c2284rG = new C2284rG("MESSAGE", enumC2560xG3);
        f5303x = c2284rG;
        C2468vG c2468vG = new C2468vG("BYTES", EnumC2560xG.BYTE_STRING);
        f5304y = c2468vG;
        EnumC1634dG enumC1634dG9 = new EnumC1634dG("UINT32", 12, enumC2560xG2, 0);
        f5305z = enumC1634dG9;
        EnumC1634dG enumC1634dG10 = new EnumC1634dG("ENUM", 13, EnumC2560xG.ENUM, 0);
        f5287A = enumC1634dG10;
        EnumC1634dG enumC1634dG11 = new EnumC1634dG("SFIXED32", 14, enumC2560xG2, 5);
        f5288B = enumC1634dG11;
        EnumC1634dG enumC1634dG12 = new EnumC1634dG("SFIXED64", 15, enumC2560xG, 1);
        f5289C = enumC1634dG12;
        EnumC1634dG enumC1634dG13 = new EnumC1634dG("SINT32", 16, enumC2560xG2, 0);
        f5290D = enumC1634dG13;
        EnumC1634dG enumC1634dG14 = new EnumC1634dG("SINT64", 17, enumC2560xG, 0);
        f5291E = enumC1634dG14;
        f5292F = new EnumC1634dG[]{enumC1634dG, enumC1634dG2, enumC1634dG3, enumC1634dG4, enumC1634dG5, enumC1634dG6, enumC1634dG7, enumC1634dG8, c1914jG, c2099nG, c2284rG, c2468vG, enumC1634dG9, enumC1634dG10, enumC1634dG11, enumC1634dG12, enumC1634dG13, enumC1634dG14};
    }

    public EnumC1634dG(String str, int i, EnumC2560xG enumC2560xG, int i2) {
        this.f5306l = enumC2560xG;
        this.f5307m = i2;
    }

    public static EnumC1634dG[] values() {
        return (EnumC1634dG[]) f5292F.clone();
    }

    public final EnumC2560xG m7316c() {
        return this.f5306l;
    }
}
