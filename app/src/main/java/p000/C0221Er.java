package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class C0221Er extends AbstractC1935jr {
    public C0221Er() {
        this.f5966a.add(EnumC2259qs.APPLY);
        this.f5966a.add(EnumC2259qs.BLOCK);
        this.f5966a.add(EnumC2259qs.BREAK);
        this.f5966a.add(EnumC2259qs.CASE);
        this.f5966a.add(EnumC2259qs.DEFAULT);
        this.f5966a.add(EnumC2259qs.CONTINUE);
        this.f5966a.add(EnumC2259qs.DEFINE_FUNCTION);
        this.f5966a.add(EnumC2259qs.FN);
        this.f5966a.add(EnumC2259qs.IF);
        this.f5966a.add(EnumC2259qs.QUOTE);
        this.f5966a.add(EnumC2259qs.RETURN);
        this.f5966a.add(EnumC2259qs.SWITCH);
        this.f5966a.add(EnumC2259qs.TERNARY);
    }

    public static InterfaceC0909Tq m1097c(C2357sy c2357sy, List list) {
        AbstractC1145Yw.m5004k(EnumC2259qs.FN, 2, list);
        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
        InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
        if (!(interfaceC0909TqM9631c2 instanceof C2257qq)) {
            throw new IllegalArgumentException(String.format("FN requires an ArrayValue of parameter names found %s", interfaceC0909TqM9631c2.getClass().getCanonicalName()));
        }
        List listM9189A = ((C2257qq) interfaceC0909TqM9631c2).m9189A();
        List arrayList = new ArrayList<>();
        if (list.size() > 2) {
            arrayList = list.subList(2, list.size());
        }
        return new C1001Vq(interfaceC0909TqM9631c.mo154h(), listM9189A, arrayList, c2357sy);
    }

    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        int i = 0;
        switch (AbstractC0497Kr.f1634a[AbstractC1145Yw.m4998e(str).ordinal()]) {
            case 1:
                AbstractC1145Yw.m5000g(EnumC2259qs.APPLY, 3, list);
                InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                String strMo154h = c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo154h();
                InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
                if (!(interfaceC0909TqM9631c2 instanceof C2257qq)) {
                    throw new IllegalArgumentException(String.format("Function arguments for Apply are not a list found %s", interfaceC0909TqM9631c2.getClass().getCanonicalName()));
                }
                if (strMo154h.isEmpty()) {
                    throw new IllegalArgumentException("Function name for apply is undefined");
                }
                return interfaceC0909TqM9631c.mo156o(strMo154h, c2357sy, ((C2257qq) interfaceC0909TqM9631c2).m9189A());
            case 2:
                return c2357sy.m9632d().m9630b(new C2257qq(list));
            case 3:
                AbstractC1145Yw.m5000g(EnumC2259qs.BREAK, 0, list);
                return InterfaceC0909Tq.f2788g;
            case 4:
            case 5:
                if (!list.isEmpty()) {
                    InterfaceC0909Tq interfaceC0909TqM9631c3 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                    if (interfaceC0909TqM9631c3 instanceof C2257qq) {
                        return c2357sy.m9630b((C2257qq) interfaceC0909TqM9631c3);
                    }
                }
                return InterfaceC0909Tq.f2785d;
            case 6:
                AbstractC1145Yw.m5000g(EnumC2259qs.BREAK, 0, list);
                return InterfaceC0909Tq.f2787f;
            case 7:
                AbstractC1145Yw.m5004k(EnumC2259qs.DEFINE_FUNCTION, 2, list);
                C1001Vq c1001Vq = (C1001Vq) m1097c(c2357sy, list);
                c2357sy.m9636h(c1001Vq.m2169a() == null ? "" : c1001Vq.m2169a(), c1001Vq);
                return c1001Vq;
            case 8:
                return m1097c(c2357sy, list);
            case 9:
                AbstractC1145Yw.m5004k(EnumC2259qs.IF, 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c4 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                InterfaceC0909Tq interfaceC0909TqM9631c5 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                InterfaceC0909Tq interfaceC0909TqM9631c6 = list.size() > 2 ? c2357sy.m9631c((InterfaceC0909Tq) list.get(2)) : null;
                InterfaceC0909Tq interfaceC0909Tq = InterfaceC0909Tq.f2785d;
                InterfaceC0909Tq interfaceC0909TqM9630b = interfaceC0909TqM9631c4.mo152d().booleanValue() ? c2357sy.m9630b((C2257qq) interfaceC0909TqM9631c5) : interfaceC0909TqM9631c6 != null ? c2357sy.m9630b((C2257qq) interfaceC0909TqM9631c6) : interfaceC0909Tq;
                return interfaceC0909TqM9630b instanceof C0174Dq ? interfaceC0909TqM9630b : interfaceC0909Tq;
            case 10:
                return new C2257qq(list);
            case 11:
                if (list.isEmpty()) {
                    return InterfaceC0909Tq.f2789h;
                }
                AbstractC1145Yw.m5000g(EnumC2259qs.RETURN, 1, list);
                return new C0174Dq("return", c2357sy.m9631c((InterfaceC0909Tq) list.get(0)));
            case 12:
                AbstractC1145Yw.m5000g(EnumC2259qs.SWITCH, 3, list);
                InterfaceC0909Tq interfaceC0909TqM9631c7 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                InterfaceC0909Tq interfaceC0909TqM9631c8 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                InterfaceC0909Tq interfaceC0909TqM9631c9 = c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
                if (!(interfaceC0909TqM9631c8 instanceof C2257qq)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, cases are not a list");
                }
                if (!(interfaceC0909TqM9631c9 instanceof C2257qq)) {
                    throw new IllegalArgumentException("Malformed SWITCH statement, case statements are not a list");
                }
                C2257qq c2257qq = (C2257qq) interfaceC0909TqM9631c8;
                C2257qq c2257qq2 = (C2257qq) interfaceC0909TqM9631c9;
                boolean z = false;
                while (true) {
                    if (i < c2257qq.m9195u()) {
                        if (z || interfaceC0909TqM9631c7.equals(c2357sy.m9631c(c2257qq.m9192r(i)))) {
                            InterfaceC0909Tq interfaceC0909TqM9631c10 = c2357sy.m9631c(c2257qq2.m9192r(i));
                            if (!(interfaceC0909TqM9631c10 instanceof C0174Dq)) {
                                z = true;
                            } else if (!((C0174Dq) interfaceC0909TqM9631c10).m781b().equals("break")) {
                                return interfaceC0909TqM9631c10;
                            }
                        }
                        i++;
                    } else if (c2257qq.m9195u() + 1 == c2257qq2.m9195u()) {
                        InterfaceC0909Tq interfaceC0909TqM9631c11 = c2357sy.m9631c(c2257qq2.m9192r(c2257qq.m9195u()));
                        if (interfaceC0909TqM9631c11 instanceof C0174Dq) {
                            String strM781b = ((C0174Dq) interfaceC0909TqM9631c11).m781b();
                            if (strM781b.equals("return") || strM781b.equals("continue")) {
                                return interfaceC0909TqM9631c11;
                            }
                        }
                    }
                }
                return InterfaceC0909Tq.f2785d;
            case 13:
                AbstractC1145Yw.m5000g(EnumC2259qs.TERNARY, 3, list);
                return c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo152d().booleanValue() ? c2357sy.m9631c((InterfaceC0909Tq) list.get(1)) : c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
            default:
                return super.m8207a(str);
        }
    }
}
