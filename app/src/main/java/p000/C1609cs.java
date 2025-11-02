package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C1609cs extends AbstractC1935jr {
    public C1609cs() {
        this.f5966a.add(EnumC2259qs.ADD);
        this.f5966a.add(EnumC2259qs.DIVIDE);
        this.f5966a.add(EnumC2259qs.MODULUS);
        this.f5966a.add(EnumC2259qs.MULTIPLY);
        this.f5966a.add(EnumC2259qs.NEGATE);
        this.f5966a.add(EnumC2259qs.POST_DECREMENT);
        this.f5966a.add(EnumC2259qs.POST_INCREMENT);
        this.f5966a.add(EnumC2259qs.PRE_DECREMENT);
        this.f5966a.add(EnumC2259qs.PRE_INCREMENT);
        this.f5966a.add(EnumC2259qs.SUBTRACT);
    }

    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        switch (AbstractC1890is.f5831a[AbstractC1145Yw.m4998e(str).ordinal()]) {
            case 1:
                AbstractC1145Yw.m5000g(EnumC2259qs.ADD, 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                if (!(interfaceC0909TqM9631c instanceof InterfaceC0358Hq) && !(interfaceC0909TqM9631c instanceof C1093Xq) && !(interfaceC0909TqM9631c2 instanceof InterfaceC0358Hq) && !(interfaceC0909TqM9631c2 instanceof C1093Xq)) {
                    return new C0036Aq(Double.valueOf(interfaceC0909TqM9631c.mo153f().doubleValue() + interfaceC0909TqM9631c2.mo153f().doubleValue()));
                }
                return new C1093Xq(interfaceC0909TqM9631c.mo154h() + interfaceC0909TqM9631c2.mo154h());
            case 2:
                AbstractC1145Yw.m5000g(EnumC2259qs.DIVIDE, 2, list);
                return new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue() / c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()));
            case 3:
                AbstractC1145Yw.m5000g(EnumC2259qs.MODULUS, 2, list);
                return new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue() % c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()));
            case 4:
                AbstractC1145Yw.m5000g(EnumC2259qs.MULTIPLY, 2, list);
                return new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue() * c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()));
            case 5:
                AbstractC1145Yw.m5000g(EnumC2259qs.NEGATE, 1, list);
                return new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue() * (-1.0d)));
            case 6:
            case 7:
                AbstractC1145Yw.m4999f(str, 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c3 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                return interfaceC0909TqM9631c3;
            case 8:
            case 9:
                AbstractC1145Yw.m4999f(str, 1, list);
                return c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
            case 10:
                AbstractC1145Yw.m5000g(EnumC2259qs.SUBTRACT, 2, list);
                return new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue() + new C0036Aq(Double.valueOf(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue() * (-1.0d))).mo153f().doubleValue()));
            default:
                return super.m8207a(str);
        }
    }
}
