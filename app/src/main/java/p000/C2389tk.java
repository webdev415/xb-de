package p000;

import java.io.Serializable;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class C2389tk implements Serializable {

    public static final a f7236m = new a(null);

    public final Pattern f7237l;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C2389tk(String str) {
        AbstractC0116Ce.m476e(str, "pattern");
        Pattern patternCompile = Pattern.compile(str);
        AbstractC0116Ce.m475d(patternCompile, "compile(pattern)");
        this(patternCompile);
    }

    public final boolean m9728a(CharSequence charSequence) {
        AbstractC0116Ce.m476e(charSequence, "input");
        return this.f7237l.matcher(charSequence).matches();
    }

    public final String m9729b(CharSequence charSequence, String str) {
        AbstractC0116Ce.m476e(charSequence, "input");
        AbstractC0116Ce.m476e(str, "replacement");
        String strReplaceAll = this.f7237l.matcher(charSequence).replaceAll(str);
        AbstractC0116Ce.m475d(strReplaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return strReplaceAll;
    }

    public String toString() {
        String string = this.f7237l.toString();
        AbstractC0116Ce.m475d(string, "nativePattern.toString()");
        return string;
    }

    public C2389tk(Pattern pattern) {
        AbstractC0116Ce.m476e(pattern, "nativePattern");
        this.f7237l = pattern;
    }
}
