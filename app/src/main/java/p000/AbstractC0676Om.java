package p000;

public abstract class AbstractC0676Om extends AbstractC0630Nm {
    public static String m3436o0(String str, int i) {
        AbstractC0116Ce.m476e(str, "<this>");
        if (i >= 0) {
            String strSubstring = str.substring(0, AbstractC1132Yj.m4982c(i, str.length()));
            AbstractC0116Ce.m475d(strSubstring, "this as java.lang.String…ing(startIndex, endIndex)");
            return strSubstring;
        }
        throw new IllegalArgumentException(("Requested character count " + i + " is less than zero.").toString());
    }
}
