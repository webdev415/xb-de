package p000;

import java.nio.charset.Charset;

public final class C2502w4 {

    public static final C2502w4 f7788a = new C2502w4();

    public static final Charset f7789b;

    public static final Charset f7790c;

    public static final Charset f7791d;

    public static final Charset f7792e;

    public static final Charset f7793f;

    public static final Charset f7794g;

    public static volatile Charset f7795h;

    public static volatile Charset f7796i;

    static {
        Charset charsetForName = Charset.forName("UTF-8");
        AbstractC0116Ce.m475d(charsetForName, "forName(\"UTF-8\")");
        f7789b = charsetForName;
        Charset charsetForName2 = Charset.forName("UTF-16");
        AbstractC0116Ce.m475d(charsetForName2, "forName(\"UTF-16\")");
        f7790c = charsetForName2;
        Charset charsetForName3 = Charset.forName("UTF-16BE");
        AbstractC0116Ce.m475d(charsetForName3, "forName(\"UTF-16BE\")");
        f7791d = charsetForName3;
        Charset charsetForName4 = Charset.forName("UTF-16LE");
        AbstractC0116Ce.m475d(charsetForName4, "forName(\"UTF-16LE\")");
        f7792e = charsetForName4;
        Charset charsetForName5 = Charset.forName("US-ASCII");
        AbstractC0116Ce.m475d(charsetForName5, "forName(\"US-ASCII\")");
        f7793f = charsetForName5;
        Charset charsetForName6 = Charset.forName("ISO-8859-1");
        AbstractC0116Ce.m475d(charsetForName6, "forName(\"ISO-8859-1\")");
        f7794g = charsetForName6;
    }

    public final Charset m10430a() {
        Charset charset = f7796i;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32BE");
        AbstractC0116Ce.m475d(charsetForName, "forName(\"UTF-32BE\")");
        f7796i = charsetForName;
        return charsetForName;
    }

    public final Charset m10431b() {
        Charset charset = f7795h;
        if (charset != null) {
            return charset;
        }
        Charset charsetForName = Charset.forName("UTF-32LE");
        AbstractC0116Ce.m475d(charsetForName, "forName(\"UTF-32LE\")");
        f7795h = charsetForName;
        return charsetForName;
    }
}
