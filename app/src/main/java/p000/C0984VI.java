package p000;

import java.util.List;

public final class C0984VI extends AbstractC0450Jq {

    public C1184Zp f2958n;

    public C0984VI(C1184Zp c1184Zp) {
        super("internal.registerCallback");
        this.f2958n = c1184Zp;
    }

    @Override
    public final InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list) {
        AbstractC1145Yw.m4999f(this.f1460l, 3, list);
        String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h();
        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
        if (!(interfaceC0909TqM9631c instanceof C1001Vq)) {
            throw new IllegalArgumentException("Invalid callback type");
        }
        InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
        if (!(interfaceC0909TqM9631c2 instanceof C0817Rq)) {
            throw new IllegalArgumentException("Invalid callback params");
        }
        C0817Rq c0817Rq = (C0817Rq) interfaceC0909TqM9631c2;
        if (!c0817Rq.mo1618k("type")) {
            throw new IllegalArgumentException("Undefined rule type");
        }
        this.f2958n.m5082b(strMo154h, c0817Rq.mo1618k("priority") ? AbstractC1145Yw.m5002i(c0817Rq.mo1617g("priority").mo153f().doubleValue()) : 1000, (C1001Vq) interfaceC0909TqM9631c, c0817Rq.mo1617g("type").mo154h());
        return InterfaceC0909Tq.f2785d;
    }
}
