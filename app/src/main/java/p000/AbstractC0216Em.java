package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC0216Em extends AbstractC0170Dm {

    public static final class a extends AbstractC0025Af implements InterfaceC0986Vb {

        public static final a f533m = new a();

        public a() {
            super(1);
        }

        @Override
        public final String mo15n(String str) {
            AbstractC0116Ce.m476e(str, "line");
            return str;
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC0986Vb {

        public final String f534m;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(String str) {
            super(1);
            this.f534m = str;
        }

        @Override
        public final String mo15n(String str) {
            AbstractC0116Ce.m476e(str, "line");
            return this.f534m + str;
        }
    }

    public static final InterfaceC0986Vb m1071b(String str) {
        return str.length() == 0 ? a.f533m : new b(str);
    }

    public static final String m1072c(String str, String str2, String str3) {
        int i;
        String str4;
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "newIndent");
        AbstractC0116Ce.m476e(str3, "marginPrefix");
        if (!(!AbstractC0538Lm.m2721m(str3))) {
            throw new IllegalArgumentException("marginPrefix must be non-blank string.".toString());
        }
        List listM2937U = AbstractC0584Mm.m2937U(str);
        int length = str.length() + (str2.length() * listM2937U.size());
        InterfaceC0986Vb interfaceC0986VbM1071b = m1071b(str2);
        int iM7784g = AbstractC1810h5.m7784g(listM2937U);
        ArrayList arrayList = new ArrayList<>();
        int i2 = 0;
        for (Object obj : listM2937U) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                AbstractC1810h5.m7790m();
            }
            String str5 = (String) obj;
            String strSubstring = null;
            if ((i2 == 0 || i2 == iM7784g) && AbstractC0538Lm.m2721m(str5)) {
                str5 = null;
            } else {
                int length2 = str5.length();
                int i4 = 0;
                while (true) {
                    if (i4 >= length2) {
                        i = -1;
                        break;
                    }
                    if (!AbstractC2410u4.m9935c(str5.charAt(i4))) {
                        i = i4;
                        break;
                    }
                    i4++;
                }
                if (i != -1) {
                    int i5 = i;
                    if (AbstractC0538Lm.m2730v(str5, str3, i, false, 4, null)) {
                        int length3 = i5 + str3.length();
                        AbstractC0116Ce.m474c(str5, "null cannot be cast to non-null type java.lang.String");
                        strSubstring = str5.substring(length3);
                        AbstractC0116Ce.m475d(strSubstring, "this as java.lang.String).substring(startIndex)");
                    }
                }
                if (strSubstring != null && (str4 = (String) interfaceC0986VbM1071b.mo15n(strSubstring)) != null) {
                    str5 = str4;
                }
            }
            if (str5 != null) {
                arrayList.add(str5);
            }
            i2 = i3;
        }
        String string = ((StringBuilder) AbstractC2181p5.m9027v(arrayList, new StringBuilder(length), (124 & 2) != 0 ? ", " : "\n", (124 & 4) != 0 ? "" : null, (124 & 8) == 0 ? null : "", (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null)).toString();
        AbstractC0116Ce.m475d(string, "mapIndexedNotNull { inde…\"\\n\")\n        .toString()");
        return string;
    }

    public static final String m1073d(String str, String str2) {
        AbstractC0116Ce.m476e(str, "<this>");
        AbstractC0116Ce.m476e(str2, "marginPrefix");
        return m1072c(str, "", str2);
    }

    public static String m1074e(String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str2 = "|";
        }
        return m1073d(str, str2);
    }
}
