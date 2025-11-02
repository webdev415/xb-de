package p000;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class C1777gJ extends AbstractC0450Jq {

    public final C0335HC f5624n;

    public final Map f5625o;

    public C1777gJ(C0335HC c0335hc) {
        super("require");
        this.f5625o = new HashMap<>();
        this.f5624n = c0335hc;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        AbstractC1145Yw.m4999f("require", 1, list);
        String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h();
        if (this.f5625o.containsKey(strMo154h)) {
            return (InterfaceC0909Tq) this.f5625o.get(strMo154h);
        }
        InterfaceC0909Tq interfaceC0909TqM1535a = this.f5624n.m1535a(strMo154h);
        if (interfaceC0909TqM1535a instanceof AbstractC0450Jq) {
            this.f5625o.put(strMo154h, (AbstractC0450Jq) interfaceC0909TqM1535a);
        }
        return interfaceC0909TqM1535a;
    }
}
