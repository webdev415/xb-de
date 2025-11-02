package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C1341bz implements InterfaceC0706PF {

    public final String f3901a;

    public final C0596My f3902b;

    public C1341bz(C0596My c0596My, String str) {
        this.f3901a = str;
        this.f3902b = c0596My;
    }

    @Override
    public final String mo3539g(String str) {
        Map map = (Map) this.f3902b.f1867d.get(this.f3901a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
