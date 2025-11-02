package p000;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public final class C2133o4 {

    public final Map f6534a;

    public final String f6535b;

    public C2133o4(String str, Map map) {
        String lowerCase;
        AbstractC0116Ce.m476e(str, "scheme");
        AbstractC0116Ce.m476e(map, "authParams");
        this.f6535b = str;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str2 = (String) entry.getKey();
            String str3 = (String) entry.getValue();
            if (str2 != null) {
                Locale locale = Locale.US;
                AbstractC0116Ce.m475d(locale, "US");
                lowerCase = str2.toLowerCase(locale);
                AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            } else {
                lowerCase = null;
            }
            linkedHashMap.put(lowerCase, str3);
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(linkedHashMap);
        AbstractC0116Ce.m475d(mapUnmodifiableMap, "unmodifiableMap<String?, String>(newAuthParams)");
        this.f6534a = mapUnmodifiableMap;
    }

    public final Charset m8837a() {
        String str = (String) this.f6534a.get("charset");
        if (str != null) {
            try {
                Charset charsetForName = Charset.forName(str);
                AbstractC0116Ce.m475d(charsetForName, "Charset.forName(charset)");
                return charsetForName;
            } catch (Exception unused) {
            }
        }
        Charset charset = StandardCharsets.ISO_8859_1;
        AbstractC0116Ce.m475d(charset, "ISO_8859_1");
        return charset;
    }

    public final String m8838b() {
        return (String) this.f6534a.get("realm");
    }

    public final String m8839c() {
        return this.f6535b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C2133o4) {
            C2133o4 c2133o4 = (C2133o4) obj;
            if (AbstractC0116Ce.m472a(c2133o4.f6535b, this.f6535b) && AbstractC0116Ce.m472a(c2133o4.f6534a, this.f6534a)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((899 + this.f6535b.hashCode()) * 31) + this.f6534a.hashCode();
    }

    public String toString() {
        return this.f6535b + " authParams=" + this.f6534a;
    }
}
