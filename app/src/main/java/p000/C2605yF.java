package p000;

import java.util.Collections;
import java.util.Map;

public final class C2605yF {

    public String f8066a;

    public Map f8067b;

    public EnumC0016AF f8068c;

    public C2605yF(String str, Map map, EnumC0016AF enumC0016AF) {
        this.f8066a = str;
        this.f8067b = map;
        this.f8068c = enumC0016AF;
    }

    public final EnumC0016AF m10850a() {
        return this.f8068c;
    }

    public final String m10851b() {
        return this.f8066a;
    }

    public final Map m10852c() {
        Map map = this.f8067b;
        return map == null ? Collections.emptyMap() : map;
    }

    public C2605yF(String str, EnumC0016AF enumC0016AF) {
        this.f8066a = str;
        this.f8068c = enumC0016AF;
    }
}
