package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC0584Mm extends AbstractC0538Lm {

    public static final class a extends AbstractC0025Af implements InterfaceC1920jc {

        public final char[] f1854m;

        public final boolean f1855n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(char[] cArr, boolean z) {
            super(2);
            this.f1854m = cArr;
            this.f1855n = z;
        }

        public final C0258Fi m2960a(CharSequence charSequence, int i) {
            AbstractC0116Ce.m476e(charSequence, "$this$$receiver");
            int iM2930N = AbstractC0584Mm.m2930N(charSequence, this.f1854m, i, this.f1855n);
            if (iM2930N < 0) {
                return null;
            }
            return AbstractC0769Qn.m3706a(Integer.valueOf(iM2930N), 1);
        }

        @Override
        public /* bridge */ Object mo858j(Object obj, Object obj2) {
            return m2960a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC1920jc {

        public final List f1856m;

        public final boolean f1857n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(List list, boolean z) {
            super(2);
            this.f1856m = list;
            this.f1857n = z;
        }

        public final C0258Fi m2961a(CharSequence charSequence, int i) {
            AbstractC0116Ce.m476e(charSequence, "$this$$receiver");
            C0258Fi c0258FiM2921E = AbstractC0584Mm.m2921E(charSequence, this.f1856m, i, this.f1857n, false);
            if (c0258FiM2921E != null) {
                return AbstractC0769Qn.m3706a(c0258FiM2921E.m1261c(), Integer.valueOf(((String) c0258FiM2921E.m1262d()).length()));
            }
            return null;
        }

        @Override
        public /* bridge */ Object mo858j(Object obj, Object obj2) {
            return m2961a((CharSequence) obj, ((Number) obj2).intValue());
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC0986Vb {

        public final CharSequence f1858m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(CharSequence charSequence) {
            super(1);
            this.f1858m = charSequence;
        }

        @Override
        public final String mo15n(C2659ze c2659ze) {
            AbstractC0116Ce.m476e(c2659ze, "it");
            return AbstractC0584Mm.m2953k0(this.f1858m, c2659ze);
        }
    }

    public static boolean m2917A(CharSequence charSequence, char c2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2958y(charSequence, c2, z);
    }

    public static boolean m2918B(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2959z(charSequence, charSequence2, z);
    }

    public static final boolean m2919C(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(charSequence2, "suffix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC0538Lm.m2719k((String) charSequence, (String) charSequence2, false, 2, null) : m2942Z(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), z);
    }

    public static boolean m2920D(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2919C(charSequence, charSequence2, z);
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x0096, code lost:
    
        return p000.AbstractC0769Qn.m3706a(java.lang.Integer.valueOf(r12), r9);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final C0258Fi m2921E(CharSequence r10, java.util.Collection r11, int r12, boolean r13, boolean r14) {
        /*
            r0 = 0
            if (r13 != 0) goto L2f
            int r1 = r11.size()
            r2 = 1
            if (r1 != r2) goto L2f
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.Object r11 = p000.AbstractC2181p5.m9015C(r11)
            java.lang.String r11 = (java.lang.String) r11
            r5 = 4
            r6 = 0
            r4 = 0
            r1 = r10
            r2 = r11
            r3 = r12
            if (r14 != 0) goto L1f
            int r10 = m2929M(r1, r2, r3, r4, r5, r6)
            goto L23
        L1f:
            int r10 = m2934R(r1, r2, r3, r4, r5, r6)
        L23:
            if (r10 >= 0) goto L26
            goto L2e
        L26:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            Fi r0 = p000.AbstractC0769Qn.m3706a(r10, r11)
        L2e:
            return r0
        L2f:
            r1 = 0
            if (r14 != 0) goto L40
            ze r14 = new ze
            int r12 = p000.AbstractC1132Yj.m4981b(r12, r1)
            int r1 = r10.length()
            r14.<init>(r12, r1)
            goto L4c
        L40:
            int r14 = m2923G(r10)
            int r12 = p000.AbstractC1132Yj.m4982c(r12, r14)
            xe r14 = p000.AbstractC1132Yj.m4985f(r12, r1)
        L4c:
            boolean r12 = r10 instanceof java.lang.String
            if (r12 == 0) goto L9b
            int r12 = r14.m10716d()
            int r1 = r14.m10717f()
            int r14 = r14.m10718g()
            if (r14 <= 0) goto L60
            if (r12 <= r1) goto L64
        L60:
            if (r14 >= 0) goto Ldc
            if (r1 > r12) goto Ldc
        L64:
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
        L6b:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto L89
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r4 = r10
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r2.length()
            r3 = 0
            r5 = r12
            r7 = r13
            boolean r2 = p000.AbstractC0538Lm.m2722n(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto L6b
            goto L8a
        L89:
            r9 = r0
        L8a:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto L97
        L8e:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r12)
            Fi r10 = p000.AbstractC0769Qn.m3706a(r10, r9)
            return r10
        L97:
            if (r12 == r1) goto Ldc
            int r12 = r12 + r14
            goto L64
        L9b:
            int r12 = r14.m10716d()
            int r1 = r14.m10717f()
            int r14 = r14.m10718g()
            if (r14 <= 0) goto Lab
            if (r12 <= r1) goto Laf
        Lab:
            if (r14 >= 0) goto Ldc
            if (r1 > r12) goto Ldc
        Laf:
            r2 = r11
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r8 = r2.iterator()
        Lb6:
            boolean r2 = r8.hasNext()
            if (r2 == 0) goto Ld2
            java.lang.Object r9 = r8.next()
            r2 = r9
            java.lang.String r2 = (java.lang.String) r2
            r3 = 0
            int r6 = r2.length()
            r4 = r10
            r5 = r12
            r7 = r13
            boolean r2 = m2942Z(r2, r3, r4, r5, r6, r7)
            if (r2 == 0) goto Lb6
            goto Ld3
        Ld2:
            r9 = r0
        Ld3:
            java.lang.String r9 = (java.lang.String) r9
            if (r9 == 0) goto Ld8
            goto L8e
        Ld8:
            if (r12 == r1) goto Ldc
            int r12 = r12 + r14
            goto Laf
        Ldc:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0584Mm.m2921E(java.lang.CharSequence, java.util.Collection, int, boolean, boolean):Fi");
    }

    public static final C2659ze m2922F(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return new C2659ze(0, charSequence.length() - 1);
    }

    public static final int m2923G(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return charSequence.length() - 1;
    }

    public static final int m2924H(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m2930N(charSequence, new char[]{c2}, i, z) : ((String) charSequence).indexOf(c2, i);
    }

    public static final int m2925I(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(str, "string");
        return (z || !(charSequence instanceof String)) ? m2927K(charSequence, str, i, charSequence.length(), z, false, 16, null) : ((String) charSequence).indexOf(str, i);
    }

    public static final int m2926J(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2) {
        C2567xe c2659ze = !z2 ? new C2659ze(AbstractC1132Yj.m4981b(i, 0), AbstractC1132Yj.m4982c(i2, charSequence.length())) : AbstractC1132Yj.m4985f(AbstractC1132Yj.m4982c(i, m2923G(charSequence)), AbstractC1132Yj.m4981b(i2, 0));
        if ((charSequence instanceof String) && (charSequence2 instanceof String)) {
            int iM10716d = c2659ze.m10716d();
            int iM10717f = c2659ze.m10717f();
            int iM10718g = c2659ze.m10718g();
            if ((iM10718g <= 0 || iM10716d > iM10717f) && (iM10718g >= 0 || iM10717f > iM10716d)) {
                return -1;
            }
            while (!AbstractC0538Lm.m2722n((String) charSequence2, 0, (String) charSequence, iM10716d, charSequence2.length(), z)) {
                if (iM10716d == iM10717f) {
                    return -1;
                }
                iM10716d += iM10718g;
            }
            return iM10716d;
        }
        int iM10716d2 = c2659ze.m10716d();
        int iM10717f2 = c2659ze.m10717f();
        int iM10718g2 = c2659ze.m10718g();
        if ((iM10718g2 <= 0 || iM10716d2 > iM10717f2) && (iM10718g2 >= 0 || iM10717f2 > iM10716d2)) {
            return -1;
        }
        while (!m2942Z(charSequence2, 0, charSequence, iM10716d2, charSequence2.length(), z)) {
            if (iM10716d2 == iM10717f2) {
                return -1;
            }
            iM10716d2 += iM10718g2;
        }
        return iM10716d2;
    }

    public static int m2927K(CharSequence charSequence, CharSequence charSequence2, int i, int i2, boolean z, boolean z2, int i3, Object obj) {
        if ((i3 & 16) != 0) {
            z2 = false;
        }
        return m2926J(charSequence, charSequence2, i, i2, z, z2);
    }

    public static int m2928L(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2924H(charSequence, c2, i, z);
    }

    public static int m2929M(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2925I(charSequence, str, i, z);
    }

    public static final int m2930N(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(AbstractC0002A1.m10q(cArr), i);
        }
        AbstractC2521we it = new C2659ze(AbstractC1132Yj.m4981b(i, 0), m2923G(charSequence)).iterator();
        while (it.hasNext()) {
            int iMo10565b = it.mo10565b();
            char cCharAt = charSequence.charAt(iMo10565b);
            for (char c2 : cArr) {
                if (AbstractC2456v4.m10313d(c2, cCharAt, z)) {
                    return iMo10565b;
                }
            }
        }
        return -1;
    }

    public static final int m2931O(CharSequence charSequence, char c2, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return (z || !(charSequence instanceof String)) ? m2935S(charSequence, new char[]{c2}, i, z) : ((String) charSequence).lastIndexOf(c2, i);
    }

    public static final int m2932P(CharSequence charSequence, String str, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(str, "string");
        return (z || !(charSequence instanceof String)) ? m2926J(charSequence, str, i, 0, z, true) : ((String) charSequence).lastIndexOf(str, i);
    }

    public static int m2933Q(CharSequence charSequence, char c2, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m2923G(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2931O(charSequence, c2, i, z);
    }

    public static int m2934R(CharSequence charSequence, String str, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = m2923G(charSequence);
        }
        if ((i2 & 4) != 0) {
            z = false;
        }
        return m2932P(charSequence, str, i, z);
    }

    public static final int m2935S(CharSequence charSequence, char[] cArr, int i, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(cArr, "chars");
        if (!z && cArr.length == 1 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(AbstractC0002A1.m10q(cArr), i);
        }
        for (int iM4982c = AbstractC1132Yj.m4982c(i, m2923G(charSequence)); -1 < iM4982c; iM4982c--) {
            char cCharAt = charSequence.charAt(iM4982c);
            for (char c2 : cArr) {
                if (AbstractC2456v4.m10313d(c2, cCharAt, z)) {
                    return iM4982c;
                }
            }
        }
        return -1;
    }

    public static final InterfaceC0031Al m2936T(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return m2950h0(charSequence, new String[]{"\r\n", "\n", "\r"}, false, 0, 6, null);
    }

    public static final List m2937U(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return AbstractC0261Fl.m1280j(m2936T(charSequence));
    }

    public static final InterfaceC0031Al m2938V(CharSequence charSequence, char[] cArr, int i, boolean z, int i2) {
        m2945c0(i2);
        return new C0147D8(charSequence, i, i2, new a(cArr, z));
    }

    public static final InterfaceC0031Al m2939W(CharSequence charSequence, String[] strArr, int i, boolean z, int i2) {
        m2945c0(i2);
        return new C0147D8(charSequence, i, i2, new b(AbstractC2637z1.m10981c(strArr), z));
    }

    public static InterfaceC0031Al m2940X(CharSequence charSequence, char[] cArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m2938V(charSequence, cArr, i, z, i2);
    }

    public static InterfaceC0031Al m2941Y(CharSequence charSequence, String[] strArr, int i, boolean z, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        if ((i3 & 8) != 0) {
            i2 = 0;
        }
        return m2939W(charSequence, strArr, i, z, i2);
    }

    public static final boolean m2942Z(CharSequence charSequence, int i, CharSequence charSequence2, int i2, int i3, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(charSequence2, "other");
        if (i2 < 0 || i < 0 || i > charSequence.length() - i3 || i2 > charSequence2.length() - i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (!AbstractC2456v4.m10313d(charSequence.charAt(i + i4), charSequence2.charAt(i2 + i4), z)) {
                return false;
            }
        }
        return true;
    }

    public static String m2943a0(String str, CharSequence charSequence) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(charSequence, "prefix");
        if (!m2952j0(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(charSequence.length());
        AbstractC0116Ce.m475d(strSubstring, "this as java.lang.String).substring(startIndex)");
        return strSubstring;
    }

    public static String m2944b0(String str, CharSequence charSequence) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(charSequence, "suffix");
        if (!m2920D(str, charSequence, false, 2, null)) {
            return str;
        }
        String strSubstring = str.substring(0, str.length() - charSequence.length());
        AbstractC0116Ce.m475d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static final void m2945c0(int i) {
        if (i >= 0) {
            return;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i).toString());
    }

    public static final List m2946d0(CharSequence charSequence, char[] cArr, boolean z, int i) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(cArr, "delimiters");
        if (cArr.length == 1) {
            return m2947e0(charSequence, String.valueOf(cArr[0]), z, i);
        }
        Iterable iterableM1273c = AbstractC0261Fl.m1273c(m2940X(charSequence, cArr, 0, z, i, 2, null));
        ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(iterableM1273c, 10));
        Iterator it = iterableM1273c.iterator();
        while (it.hasNext()) {
            arrayList.add(m2953k0(charSequence, (C2659ze) it.next()));
        }
        return arrayList;
    }

    public static final List m2947e0(CharSequence charSequence, String str, boolean z, int i) {
        m2945c0(i);
        int length = 0;
        int iM2925I = m2925I(charSequence, str, 0, z);
        if (iM2925I == -1 || i == 1) {
            return AbstractC1763g5.m7692b(charSequence.toString());
        }
        boolean z2 = i > 0;
        ArrayList arrayList = new ArrayList<>(z2 ? AbstractC1132Yj.m4982c(i, 10) : 10);
        do {
            arrayList.add(charSequence.subSequence(length, iM2925I).toString());
            length = str.length() + iM2925I;
            if (z2 && arrayList.size() == i - 1) {
                break;
            }
            iM2925I = m2925I(charSequence, str, length, z);
        } while (iM2925I != -1);
        arrayList.add(charSequence.subSequence(length, charSequence.length()).toString());
        return arrayList;
    }

    public static List m2948f0(CharSequence charSequence, char[] cArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m2946d0(charSequence, cArr, z, i);
    }

    public static final InterfaceC0031Al m2949g0(CharSequence charSequence, String[] strArr, boolean z, int i) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(strArr, "delimiters");
        return AbstractC0261Fl.m1278h(m2941Y(charSequence, strArr, 0, z, i, 2, null), new c(charSequence));
    }

    public static InterfaceC0031Al m2950h0(CharSequence charSequence, String[] strArr, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 0;
        }
        return m2949g0(charSequence, strArr, z, i);
    }

    public static final boolean m2951i0(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(charSequence2, "prefix");
        return (!z && (charSequence instanceof String) && (charSequence2 instanceof String)) ? AbstractC0538Lm.m2731w((String) charSequence, (String) charSequence2, false, 2, null) : m2942Z(charSequence, 0, charSequence2, 0, charSequence2.length(), z);
    }

    public static boolean m2952j0(CharSequence charSequence, CharSequence charSequence2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return m2951i0(charSequence, charSequence2, z);
    }

    public static final String m2953k0(CharSequence charSequence, C2659ze c2659ze) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(c2659ze, "range");
        return charSequence.subSequence(c2659ze.m11030p().intValue(), c2659ze.m11029o().intValue() + 1).toString();
    }

    public static final String m2954l0(String str, char c2, String str2) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "missingDelimiterValue");
        int iM2933Q = m2933Q(str, c2, 0, false, 6, null);
        if (iM2933Q == -1) {
            return str2;
        }
        String strSubstring = str.substring(iM2933Q + 1, str.length());
        AbstractC0116Ce.m475d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String m2955m0(String str, char c2, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = str;
        }
        return m2954l0(str, c2, str2);
    }

    public static CharSequence m2956n0(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        int length = charSequence.length() - 1;
        int i = 0;
        boolean z = false;
        while (i <= length) {
            boolean zM9935c = AbstractC2410u4.m9935c(charSequence.charAt(!z ? i : length));
            if (z) {
                if (!zM9935c) {
                    break;
                }
                length--;
            } else if (zM9935c) {
                i++;
            } else {
                z = true;
            }
        }
        return charSequence.subSequence(i, length + 1);
    }

    public static final boolean m2958y(CharSequence charSequence, char c2, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        return m2928L(charSequence, c2, 0, z, 2, null) >= 0;
    }

    public static final boolean m2959z(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AbstractC0116Ce.m476e(charSequence, "<this>");
        AbstractC0116Ce.m476e(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (m2929M(charSequence, (String) charSequence2, 0, z, 2, null) < 0) {
                return false;
            }
        } else if (m2927K(charSequence, charSequence2, 0, charSequence.length(), z, false, 16, null) < 0) {
            return false;
        }
        return true;
    }
}
