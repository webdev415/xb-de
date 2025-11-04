package p000;

import java.util.HashMap;
import java.util.List;

public final class C0288GB extends AbstractC0450Jq {

    public final C1700eq f870n;

    public C0288GB(C1700eq c1700eq) {
        super("internal.eventLogger");
        this.f870n = c1700eq;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        AbstractC1145Yw.m4999f(this.f1460l, 3, list);
        String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h();
        long jM4994a = (long) AbstractC1145Yw.m4994a(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue());
        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
        this.f870n.m7474b(strMo154h, jM4994a, interfaceC0909TqM9631c instanceof C0817Rq ? AbstractC1145Yw.m4997d((C0817Rq) interfaceC0909TqM9631c) : new HashMap<>());
        return InterfaceC0909Tq.f2785d;
    }
}
