package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C1748fr extends AbstractC1935jr {
    public C1748fr() {
        this.f5966a.add(EnumC2259qs.BITWISE_AND);
        this.f5966a.add(EnumC2259qs.BITWISE_LEFT_SHIFT);
        this.f5966a.add(EnumC2259qs.BITWISE_NOT);
        this.f5966a.add(EnumC2259qs.BITWISE_OR);
        this.f5966a.add(EnumC2259qs.BITWISE_RIGHT_SHIFT);
        this.f5966a.add(EnumC2259qs.BITWISE_UNSIGNED_RIGHT_SHIFT);
        this.f5966a.add(EnumC2259qs.BITWISE_XOR);
    }

    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        switch (AbstractC2027lr.f6107a[AbstractC1145Yw.m4998e(str).ordinal()]) {
            case 1:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_AND, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) & AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue())));
            case 2:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_LEFT_SHIFT, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) << ((int) (AbstractC1145Yw.m5006m(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()) & 31))));
            case 3:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_NOT, 1, list);
                return new C0036Aq(Double.valueOf(~AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue())));
            case 4:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_OR, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) | AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue())));
            case 5:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_RIGHT_SHIFT, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) >> ((int) (AbstractC1145Yw.m5006m(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()) & 31))));
            case 6:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_UNSIGNED_RIGHT_SHIFT, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5006m(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) >>> ((int) (AbstractC1145Yw.m5006m(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()) & 31))));
            case 7:
                AbstractC1145Yw.m5000g(EnumC2259qs.BITWISE_XOR, 2, list);
                return new C0036Aq(Double.valueOf(AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue()) ^ AbstractC1145Yw.m5002i(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue())));
            default:
                return super.m8207a(str);
        }
    }
}
