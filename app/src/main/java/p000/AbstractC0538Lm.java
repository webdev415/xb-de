package p000;

import java.util.Collection;
import java.util.Iterator;

public abstract class AbstractC0538Lm extends AbstractC0492Km {
    public static final boolean m2718j(String str, String str2, boolean z) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "suffix");
        return !z ? str.endsWith(str2) : m2722n(str, str.length() - str2.length(), str2, 0, str2.length(), true);
    }

    public static boolean m2719k(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2718j(str, str2, z);
    }

    public static boolean m2720l(String str, String str2, boolean z) {
        return str == null ? str2 == null : !z ? str.equals(str2) : str.equalsIgnoreCase(str2);
    }

    public static final boolean m2721m(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        if (charSequence.length() != 0) {
            Iterable iterableM2922F = AbstractC0584Mm.m2922F(charSequence);
            if (!(iterableM2922F instanceof Collection) || !((Collection) iterableM2922F).isEmpty()) {
                Iterator it = iterableM2922F.iterator();
                while (it.hasNext()) {
                    if (!AbstractC2410u4.m9935c(charSequence.charAt(((AbstractC2521we) it).mo10565b()))) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static final boolean m2722n(String str, int i, String str2, int i2, int i3, boolean z) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "other");
        return !z ? str.regionMatches(i, str2, i2, i3) : str.regionMatches(z, i, str2, i2, i3);
    }

    public static String m2723o(CharSequence charSequence, int i) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("Count 'n' must be non-negative, but was " + i + '.').toString());
        }
        if (i == 0) {
            return "";
        }
        if (i == 1) {
            return charSequence.toString();
        }
        int length = charSequence.length();
        if (length == 0) {
            return "";
        }
        if (length == 1) {
            char cCharAt = charSequence.charAt(0);
            char[] cArr = new char[i];
            for (int i2 = 0; i2 < i; i2++) {
                cArr[i2] = cCharAt;
            }
            return new String(cArr);
        }
        StringBuilder sb = new StringBuilder(charSequence.length() * i);
        AbstractC2521we abstractC2521weM10719h = new C2659ze(1, i).iterator();
        while (abstractC2521weM10719h.hasNext()) {
            abstractC2521weM10719h.mo10565b();
            sb.append(charSequence);
        }
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "{\n                    va…tring()\n                }");
        return string;
    }

    public static final String m2724p(String str, char c, char c2, boolean z) {
        String string;
        String str2;
        AbstractC0116Ce.m476e(str, "<this>");
        if (z) {
            StringBuilder sb = new StringBuilder(str.length());
            for (int i = 0; i < str.length(); i++) {
                char cCharAt = str.charAt(i);
                if (AbstractC2456v4.m10313d(cCharAt, c, z)) {
                    cCharAt = c2;
                }
                sb.append(cCharAt);
            }
            string = sb.toString();
            str2 = "StringBuilder(capacity).…builderAction).toString()";
        } else {
            string = str.replace(c, c2);
            str2 = "this as java.lang.String…replace(oldChar, newChar)";
        }
        AbstractC0116Ce.m475d(string, str2);
        return string;
    }

    public static final String m2725q(String str, String str2, String str3, boolean z) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "oldValue");
        AbstractC0116Ce.m476e(str3, "newValue");
        int i = 0;
        int iM2925I = AbstractC0584Mm.m2925I(str, str2, 0, z);
        if (iM2925I < 0) {
            return str;
        }
        int length = str2.length();
        int iM4981b = AbstractC1132Yj.m4981b(length, 1);
        int length2 = (str.length() - length) + str3.length();
        if (length2 < 0) {
            throw new OutOfMemoryError();
        }
        StringBuilder sb = new StringBuilder(length2);
        do {
            sb.append((CharSequence) str, i, iM2925I);
            sb.append(str3);
            i = iM2925I + length;
            if (iM2925I >= str.length()) {
                break;
            }
            iM2925I = AbstractC0584Mm.m2925I(str, str2, iM2925I + iM4981b, z);
        } while (iM2925I > 0);
        sb.append((CharSequence) str, i, str.length());
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "stringBuilder.append(this, i, length).toString()");
        return string;
    }

    public static String m2726r(String str, char c, char c2, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m2724p(str, c, c2, z);
    }

    public static String m2727s(String str, String str2, String str3, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return m2725q(str, str2, str3, z);
    }

    public static boolean m2728t(String str, String str2, int i, boolean z) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "prefix");
        return !z ? str.startsWith(str2, i) : m2722n(str, i, str2, 0, str2.length(), z);
    }

    public static boolean m2729u(String str, String str2, boolean z) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "prefix");
        return !z ? str.startsWith(str2) : m2722n(str, 0, str2, 0, str2.length(), z);
    }

    public static boolean m2730v(String str, String str2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2728t(str, str2, i, z);
    }

    public static boolean m2731w(String str, String str2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2729u(str, str2, z);
    }
}
