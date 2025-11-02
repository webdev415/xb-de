package p000;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class C0716Pg {

    public final String f2146a;

    public final String f2147b;

    public final String f2148c;

    public final String[] f2149d;

    public static final a f2145g = new a(null);

    public static final Pattern f2143e = Pattern.compile("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");

    public static final Pattern f2144f = Pattern.compile(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public static final class a {
        public a() {
        }

        public final C0716Pg m3571a(String str) {
            AbstractC0116Ce.m476e(str, "$this$toMediaType");
            Matcher matcher = C0716Pg.f2143e.matcher(str);
            if (!matcher.lookingAt()) {
                throw new IllegalArgumentException(("No subtype found for: \"" + str + '\"').toString());
            }
            String strGroup = matcher.group(1);
            AbstractC0116Ce.m475d(strGroup, "typeSubtype.group(1)");
            Locale locale = Locale.US;
            AbstractC0116Ce.m475d(locale, "Locale.US");
            if (strGroup == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase = strGroup.toLowerCase(locale);
            AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            String strGroup2 = matcher.group(2);
            AbstractC0116Ce.m475d(strGroup2, "typeSubtype.group(2)");
            AbstractC0116Ce.m475d(locale, "Locale.US");
            if (strGroup2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String lowerCase2 = strGroup2.toLowerCase(locale);
            AbstractC0116Ce.m475d(lowerCase2, "(this as java.lang.String).toLowerCase(locale)");
            ArrayList arrayList = new ArrayList<>();
            Matcher matcher2 = C0716Pg.f2144f.matcher(str);
            for (int iEnd = matcher.end(); iEnd < str.length(); iEnd = matcher2.end()) {
                matcher2.region(iEnd, str.length());
                if (!matcher2.lookingAt()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("Parameter is not formatted correctly: \"");
                    String strSubstring = str.substring(iEnd);
                    AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.String).substring(startIndex)");
                    sb.append(strSubstring);
                    sb.append("\" for: \"");
                    sb.append(str);
                    sb.append('\"');
                    throw new IllegalArgumentException(sb.toString().toString());
                }
                String strGroup3 = matcher2.group(1);
                if (strGroup3 != null) {
                    String strGroup4 = matcher2.group(2);
                    if (strGroup4 == null) {
                        strGroup4 = matcher2.group(3);
                    } else if (AbstractC0538Lm.m2731w(strGroup4, "'", false, 2, null) && AbstractC0538Lm.m2719k(strGroup4, "'", false, 2, null) && strGroup4.length() > 2) {
                        strGroup4 = strGroup4.substring(1, strGroup4.length() - 1);
                        AbstractC0116Ce.m475d(strGroup4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    }
                    arrayList.add(strGroup3);
                    arrayList.add(strGroup4);
                }
            }
            Object[] array = arrayList.toArray(new String[0]);
            if (array != null) {
                return new C0716Pg(str, lowerCase, lowerCase2, (String[]) array, null);
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
        }

        public final C0716Pg m3572b(String str) {
            AbstractC0116Ce.m476e(str, "$this$toMediaTypeOrNull");
            try {
                return m3571a(str);
            } catch (IllegalArgumentException unused) {
                return null;
            }
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0716Pg(String str, String str2, String str3, String[] strArr) {
        this.f2146a = str;
        this.f2147b = str2;
        this.f2148c = str3;
        this.f2149d = strArr;
    }

    public static Charset m3566d(C0716Pg c0716Pg, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return c0716Pg.m3569c(charset);
    }

    public static final C0716Pg m3567e(String str) {
        return f2145g.m3571a(str);
    }

    public static final C0716Pg m3568g(String str) {
        return f2145g.m3572b(str);
    }

    public final Charset m3569c(Charset charset) {
        String strM3570f = m3570f("charset");
        if (strM3570f == null) {
            return charset;
        }
        try {
            return Charset.forName(strM3570f);
        } catch (IllegalArgumentException unused) {
            return charset;
        }
    }

    public boolean equals(Object obj) {
        return (obj instanceof C0716Pg) && AbstractC0116Ce.m472a(((C0716Pg) obj).f2146a, this.f2146a);
    }

    public final String m3570f(String str) {
        AbstractC0116Ce.m476e(str, "name");
        C2567xe c2567xeM4986g = AbstractC1132Yj.m4986g(AbstractC0002A1.m7n(this.f2149d), 2);
        int iM10716d = c2567xeM4986g.m10716d();
        int iM10717f = c2567xeM4986g.m10717f();
        int iM10718g = c2567xeM4986g.m10718g();
        if (iM10718g >= 0) {
            if (iM10716d > iM10717f) {
                return null;
            }
        } else if (iM10716d < iM10717f) {
            return null;
        }
        while (!AbstractC0538Lm.m2720l(this.f2149d[iM10716d], str, true)) {
            if (iM10716d == iM10717f) {
                return null;
            }
            iM10716d += iM10718g;
        }
        return this.f2149d[iM10716d + 1];
    }

    public int hashCode() {
        return this.f2146a.hashCode();
    }

    public String toString() {
        return this.f2146a;
    }

    public C0716Pg(String str, String str2, String str3, String[] strArr, AbstractC0881T7 abstractC0881T7) {
        this(str, str2, str3, strArr);
    }
}
