package p000;

public final class C0023Ad {

    public static final C0023Ad f66a = new C0023Ad();

    public static final boolean m117a(String str) {
        AbstractC0116Ce.m476e(str, "method");
        return (AbstractC0116Ce.m472a(str, "GET") || AbstractC0116Ce.m472a(str, "HEAD")) ? false : true;
    }

    public static final boolean m118d(String str) {
        AbstractC0116Ce.m476e(str, "method");
        return AbstractC0116Ce.m472a(str, "POST") || AbstractC0116Ce.m472a(str, "PUT") || AbstractC0116Ce.m472a(str, "PATCH") || AbstractC0116Ce.m472a(str, "PROPPATCH") || AbstractC0116Ce.m472a(str, "REPORT");
    }

    public final boolean m119b(String str) {
        AbstractC0116Ce.m476e(str, "method");
        return !AbstractC0116Ce.m472a(str, "PROPFIND");
    }

    public final boolean m120c(String str) {
        AbstractC0116Ce.m476e(str, "method");
        return AbstractC0116Ce.m472a(str, "PROPFIND");
    }
}
