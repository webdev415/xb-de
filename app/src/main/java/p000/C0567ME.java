package p000;

import java.util.List;
import java.util.Map;

public final class C0567ME extends C0817Rq {

    public final C1700eq f1766m;

    public C0567ME(C1700eq c1700eq) {
        this.f1766m = c1700eq;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        str.hashCode();
        switch (str) {
            case "getEventName":
                AbstractC1145Yw.m4999f("getEventName", 0, list);
                return new C1093Xq(this.f1766m.m7476d().m8006e());
            case "getTimestamp":
                AbstractC1145Yw.m4999f("getTimestamp", 0, list);
                return new C0036Aq(Double.valueOf(this.f1766m.m7476d().m8003a()));
            case "getParamValue":
                AbstractC1145Yw.m4999f("getParamValue", 1, list);
                return AbstractC0103CA.m414a(this.f1766m.m7476d().m8004b(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h()));
            case "getParams":
                AbstractC1145Yw.m4999f("getParams", 0, list);
                Map mapM8008g = this.f1766m.m7476d().m8008g();
                C0817Rq c0817Rq = new C0817Rq();
                for (String str2 : mapM8008g.keySet()) {
                    c0817Rq.mo1619p(str2, AbstractC0103CA.m414a(mapM8008g.get(str2)));
                }
                return c0817Rq;
            case "setParamValue":
                AbstractC1145Yw.m4999f("setParamValue", 2, list);
                String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h();
                InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                this.f1766m.m7476d().m8005d(strMo154h, AbstractC1145Yw.m4996c(interfaceC0909TqM9631c));
                return interfaceC0909TqM9631c;
            case "setEventName":
                AbstractC1145Yw.m4999f("setEventName", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (InterfaceC0909Tq.f2785d.equals(interfaceC0909TqM9631c2) || InterfaceC0909Tq.f2786e.equals(interfaceC0909TqM9631c2)) {
                    throw new IllegalArgumentException("Illegal event name");
                }
                this.f1766m.m7476d().m8007f(interfaceC0909TqM9631c2.mo154h());
                return new C1093Xq(interfaceC0909TqM9631c2.mo154h());
            default:
                return super.mo156o(str, c2357sy, list);
        }
    }
}
