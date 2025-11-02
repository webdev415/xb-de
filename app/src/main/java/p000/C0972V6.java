package p000;

import java.nio.charset.Charset;

public final class C0972V6 {

    public static final C0972V6 f2937a = new C0972V6();

    public static final String m4332a(String str, String str2, Charset charset) {
        AbstractC0116Ce.m476e(str, "username");
        AbstractC0116Ce.m476e(str2, "password");
        AbstractC0116Ce.m476e(charset, "charset");
        return "Basic " + C0096C3.f235p.m394b(str + ':' + str2, charset).mo371c();
    }
}
