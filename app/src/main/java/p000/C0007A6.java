package p000;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class C0007A6 {

    public final String f15a;

    public final String f16b;

    public final long f17c;

    public final String f18d;

    public final String f19e;

    public final boolean f20f;

    public final boolean f21g;

    public final boolean f22h;

    public final boolean f23i;

    public static final a f14n = new a(null);

    public static final Pattern f10j = Pattern.compile("(\\d{2,4})[^\\d]*");

    public static final Pattern f11k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    public static final Pattern f12l = Pattern.compile("(\\d{1,2})[^\\d]*");

    public static final Pattern f13m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public static final class a {
        public a() {
        }

        public final int m28a(String str, int i, int i2, boolean z) {
            while (i < i2) {
                char cCharAt = str.charAt(i);
                if (((cCharAt < ' ' && cCharAt != '\t') || cCharAt >= 127 || ('0' <= cCharAt && '9' >= cCharAt) || (('a' <= cCharAt && 'z' >= cCharAt) || (('A' <= cCharAt && 'Z' >= cCharAt) || cCharAt == ':'))) == (!z)) {
                    return i;
                }
                i++;
            }
            return i2;
        }

        public final boolean m29b(String str, String str2) {
            if (AbstractC0116Ce.m472a(str, str2)) {
                return true;
            }
            return AbstractC0538Lm.m2719k(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.' && !AbstractC2623yo.m10931f(str);
        }

        public final C0007A6 m30c(C0069Bd c0069Bd, String str) {
            AbstractC0116Ce.m476e(c0069Bd, "url");
            AbstractC0116Ce.m476e(str, "setCookie");
            return m31d(System.currentTimeMillis(), c0069Bd, str);
        }

        /* JADX WARN: Removed duplicated region for block: B:43:0x00d7 A[PHI: r1
  0x00d7: PHI (r1v24 long) = (r1v7 long), (r1v11 long) binds: [B:42:0x00d5, B:53:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final C0007A6 m31d(long r26, C0069Bd r28, String r29) throws NumberFormatException {
            /*
                Method dump skipped, instructions count: 372
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C0007A6.a.m31d(long, Bd, java.lang.String):A6");
        }

        public final List m32e(C0069Bd c0069Bd, C1079Xc c1079Xc) {
            AbstractC0116Ce.m476e(c0069Bd, "url");
            AbstractC0116Ce.m476e(c1079Xc, "headers");
            List listM4741i = c1079Xc.m4741i("Set-Cookie");
            int size = listM4741i.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                C0007A6 c0007a6M30c = m30c(c0069Bd, (String) listM4741i.get(i));
                if (c0007a6M30c != null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList<>();
                    }
                    arrayList.add(c0007a6M30c);
                }
            }
            if (arrayList == null) {
                return AbstractC1810h5.m7783f();
            }
            List listUnmodifiableList = Collections.unmodifiableList(arrayList);
            AbstractC0116Ce.m475d(listUnmodifiableList, "Collections.unmodifiableList(cookies)");
            return listUnmodifiableList;
        }

        public final String m33f(String str) {
            if (!(!AbstractC0538Lm.m2719k(str, ".", false, 2, null))) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String strM9063e = AbstractC2198pd.m9063e(AbstractC0584Mm.m2943a0(str, "."));
            if (strM9063e != null) {
                return strM9063e;
            }
            throw new IllegalArgumentException();
        }

        public final long m34g(String str, int i, int i2) throws NumberFormatException {
            int iM28a = m28a(str, i, i2, false);
            Matcher matcher = C0007A6.f13m.matcher(str);
            int i3 = -1;
            int i4 = -1;
            int i5 = -1;
            int iM2929M = -1;
            int i6 = -1;
            int i7 = -1;
            while (iM28a < i2) {
                int iM28a2 = m28a(str, iM28a + 1, i2, true);
                matcher.region(iM28a, iM28a2);
                if (i4 == -1 && matcher.usePattern(C0007A6.f13m).matches()) {
                    String strGroup = matcher.group(1);
                    AbstractC0116Ce.m475d(strGroup, "matcher.group(1)");
                    i4 = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    AbstractC0116Ce.m475d(strGroup2, "matcher.group(2)");
                    i6 = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    AbstractC0116Ce.m475d(strGroup3, "matcher.group(3)");
                    i7 = Integer.parseInt(strGroup3);
                } else if (i5 == -1 && matcher.usePattern(C0007A6.f12l).matches()) {
                    String strGroup4 = matcher.group(1);
                    AbstractC0116Ce.m475d(strGroup4, "matcher.group(1)");
                    i5 = Integer.parseInt(strGroup4);
                } else if (iM2929M == -1 && matcher.usePattern(C0007A6.f11k).matches()) {
                    String strGroup5 = matcher.group(1);
                    AbstractC0116Ce.m475d(strGroup5, "matcher.group(1)");
                    Locale locale = Locale.US;
                    AbstractC0116Ce.m475d(locale, "Locale.US");
                    if (strGroup5 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                    }
                    String lowerCase = strGroup5.toLowerCase(locale);
                    AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
                    String strPattern = C0007A6.f11k.pattern();
                    AbstractC0116Ce.m475d(strPattern, "MONTH_PATTERN.pattern()");
                    iM2929M = AbstractC0584Mm.m2929M(strPattern, lowerCase, 0, false, 6, null) / 4;
                } else if (i3 == -1 && matcher.usePattern(C0007A6.f10j).matches()) {
                    String strGroup6 = matcher.group(1);
                    AbstractC0116Ce.m475d(strGroup6, "matcher.group(1)");
                    i3 = Integer.parseInt(strGroup6);
                }
                iM28a = m28a(str, iM28a2 + 1, i2, false);
            }
            if (70 <= i3 && 99 >= i3) {
                i3 += 1900;
            }
            if (i3 >= 0 && 69 >= i3) {
                i3 += 2000;
            }
            if (!(i3 >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(iM2929M != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= i5 && 31 >= i5)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i4 >= 0 && 23 >= i4)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i6 >= 0 && 59 >= i6)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(i7 >= 0 && 59 >= i7)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar gregorianCalendar = new GregorianCalendar(AbstractC2623yo.f8132f);
            gregorianCalendar.setLenient(false);
            gregorianCalendar.set(1, i3);
            gregorianCalendar.set(2, iM2929M - 1);
            gregorianCalendar.set(5, i5);
            gregorianCalendar.set(11, i4);
            gregorianCalendar.set(12, i6);
            gregorianCalendar.set(13, i7);
            gregorianCalendar.set(14, 0);
            return gregorianCalendar.getTimeInMillis();
        }

        public final long m35h(String str) throws NumberFormatException {
            try {
                long j = Long.parseLong(str);
                if (j <= 0) {
                    return Long.MIN_VALUE;
                }
                return j;
            } catch (NumberFormatException e) {
                if (new C2389tk("-?\\d+").m9728a(str)) {
                    return AbstractC0538Lm.m2731w(str, "-", false, 2, null) ? Long.MIN_VALUE : Long.MAX_VALUE;
                }
                throw e;
            }
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0007A6(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.f15a = str;
        this.f16b = str2;
        this.f17c = j;
        this.f18d = str3;
        this.f19e = str4;
        this.f20f = z;
        this.f21g = z2;
        this.f22h = z3;
        this.f23i = z4;
    }

    public final String m25e() {
        return this.f15a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C0007A6) {
            C0007A6 c0007a6 = (C0007A6) obj;
            if (AbstractC0116Ce.m472a(c0007a6.f15a, this.f15a) && AbstractC0116Ce.m472a(c0007a6.f16b, this.f16b) && c0007a6.f17c == this.f17c && AbstractC0116Ce.m472a(c0007a6.f18d, this.f18d) && AbstractC0116Ce.m472a(c0007a6.f19e, this.f19e) && c0007a6.f20f == this.f20f && c0007a6.f21g == this.f21g && c0007a6.f22h == this.f22h && c0007a6.f23i == this.f23i) {
                return true;
            }
        }
        return false;
    }

    public final String m26f(boolean z) {
        String strM9523b;
        StringBuilder sb = new StringBuilder();
        sb.append(this.f15a);
        sb.append('=');
        sb.append(this.f16b);
        if (this.f22h) {
            if (this.f17c == Long.MIN_VALUE) {
                strM9523b = "; max-age=0";
            } else {
                sb.append("; expires=");
                strM9523b = AbstractC2321s7.m9523b(new Date(this.f17c));
            }
            sb.append(strM9523b);
        }
        if (!this.f23i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f18d);
        }
        sb.append("; path=");
        sb.append(this.f19e);
        if (this.f20f) {
            sb.append("; secure");
        }
        if (this.f21g) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "toString()");
        return string;
    }

    public final String m27g() {
        return this.f16b;
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f15a.hashCode()) * 31) + this.f16b.hashCode()) * 31) + Long.hashCode(this.f17c)) * 31) + this.f18d.hashCode()) * 31) + this.f19e.hashCode()) * 31) + Boolean.hashCode(this.f20f)) * 31) + Boolean.hashCode(this.f21g)) * 31) + Boolean.hashCode(this.f22h)) * 31) + Boolean.hashCode(this.f23i);
    }

    public String toString() {
        return m26f(false);
    }

    public C0007A6(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, AbstractC0881T7 abstractC0881T7) {
        this(str, str2, j, str3, str4, z, z2, z3, z4);
    }
}
