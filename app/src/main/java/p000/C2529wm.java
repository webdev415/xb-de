package p000;

import java.net.ProtocolException;

/* loaded from: classes.dex */
public final class C2529wm {

    public static final a f7894d = new a(null);

    public final EnumC2342sj f7895a;

    public final int f7896b;

    public final String f7897c;

    public static final class a {
        public a() {
        }

        public final C2529wm m10597a(String str) throws ProtocolException, NumberFormatException {
            EnumC2342sj enumC2342sj;
            int i;
            String strSubstring;
            AbstractC0116Ce.m476e(str, "statusLine");
            if (AbstractC0538Lm.m2731w(str, "HTTP/1.", false, 2, null)) {
                i = 9;
                if (str.length() < 9 || str.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                int iCharAt = str.charAt(7) - '0';
                if (iCharAt == 0) {
                    enumC2342sj = EnumC2342sj.HTTP_1_0;
                } else {
                    if (iCharAt != 1) {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    enumC2342sj = EnumC2342sj.HTTP_1_1;
                }
            } else {
                if (!AbstractC0538Lm.m2731w(str, "ICY ", false, 2, null)) {
                    throw new ProtocolException("Unexpected status line: " + str);
                }
                enumC2342sj = EnumC2342sj.HTTP_1_0;
                i = 4;
            }
            int i2 = i + 3;
            if (str.length() < i2) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
            try {
                String strSubstring2 = str.substring(i, i2);
                AbstractC0116Ce.m475d(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                int i3 = Integer.parseInt(strSubstring2);
                if (str.length() <= i2) {
                    strSubstring = "";
                } else {
                    if (str.charAt(i2) != ' ') {
                        throw new ProtocolException("Unexpected status line: " + str);
                    }
                    strSubstring = str.substring(i + 4);
                    AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                }
                return new C2529wm(enumC2342sj, i3, strSubstring);
            } catch (NumberFormatException unused) {
                throw new ProtocolException("Unexpected status line: " + str);
            }
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C2529wm(EnumC2342sj enumC2342sj, int i, String str) {
        AbstractC0116Ce.m476e(enumC2342sj, "protocol");
        AbstractC0116Ce.m476e(str, "message");
        this.f7895a = enumC2342sj;
        this.f7896b = i;
        this.f7897c = str;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f7895a == EnumC2342sj.HTTP_1_0 ? "HTTP/1.0" : "HTTP/1.1");
        sb.append(' ');
        sb.append(this.f7896b);
        sb.append(' ');
        sb.append(this.f7897c);
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
