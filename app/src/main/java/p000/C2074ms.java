package p000;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class C2074ms extends AbstractC1935jr {
    public C2074ms() {
        this.f5966a.add(EnumC2259qs.ASSIGN);
        this.f5966a.add(EnumC2259qs.CONST);
        this.f5966a.add(EnumC2259qs.CREATE_ARRAY);
        this.f5966a.add(EnumC2259qs.CREATE_OBJECT);
        this.f5966a.add(EnumC2259qs.EXPRESSION_LIST);
        this.f5966a.add(EnumC2259qs.GET);
        this.f5966a.add(EnumC2259qs.GET_INDEX);
        this.f5966a.add(EnumC2259qs.GET_PROPERTY);
        this.f5966a.add(EnumC2259qs.NULL);
        this.f5966a.add(EnumC2259qs.SET_PROPERTY);
        this.f5966a.add(EnumC2259qs.TYPEOF);
        this.f5966a.add(EnumC2259qs.UNDEFINED);
        this.f5966a.add(EnumC2259qs.VAR);
    }

    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        String str2;
        int i = 0;
        switch (AbstractC1982ks.f6040a[AbstractC1145Yw.m4998e(str).ordinal()]) {
            case 1:
                AbstractC1145Yw.m5000g(EnumC2259qs.ASSIGN, 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (!(interfaceC0909TqM9631c instanceof C1093Xq)) {
                    throw new IllegalArgumentException(String.format("Expected string for assign var. got %s", interfaceC0909TqM9631c.getClass().getCanonicalName()));
                }
                if (!c2357sy.m9635g(interfaceC0909TqM9631c.mo154h())) {
                    throw new IllegalArgumentException(String.format("Attempting to assign undefined value %s", interfaceC0909TqM9631c.mo154h()));
                }
                InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                c2357sy.m9636h(interfaceC0909TqM9631c.mo154h(), interfaceC0909TqM9631c2);
                return interfaceC0909TqM9631c2;
            case 2:
                AbstractC1145Yw.m5004k(EnumC2259qs.CONST, 2, list);
                if (list.size() % 2 != 0) {
                    throw new IllegalArgumentException(String.format("CONST requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                while (i < list.size() - 1) {
                    InterfaceC0909Tq interfaceC0909TqM9631c3 = c2357sy.m9631c((InterfaceC0909Tq) list.get(i));
                    if (!(interfaceC0909TqM9631c3 instanceof C1093Xq)) {
                        throw new IllegalArgumentException(String.format("Expected string for const name. got %s", interfaceC0909TqM9631c3.getClass().getCanonicalName()));
                    }
                    c2357sy.m9634f(interfaceC0909TqM9631c3.mo154h(), c2357sy.m9631c((InterfaceC0909Tq) list.get(i + 1)));
                    i += 2;
                }
                return InterfaceC0909Tq.f2785d;
            case 3:
                if (list.isEmpty()) {
                    return new C2257qq();
                }
                C2257qq c2257qq = new C2257qq();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    InterfaceC0909Tq interfaceC0909TqM9631c4 = c2357sy.m9631c((InterfaceC0909Tq) it.next());
                    if (interfaceC0909TqM9631c4 instanceof C0174Dq) {
                        throw new IllegalStateException("Failed to evaluate array element");
                    }
                    c2257qq.m9198x(i, interfaceC0909TqM9631c4);
                    i++;
                }
                return c2257qq;
            case 4:
                if (list.isEmpty()) {
                    return new C0817Rq();
                }
                if (list.size() % 2 != 0) {
                    throw new IllegalArgumentException(String.format("CREATE_OBJECT requires an even number of arguments, found %s", Integer.valueOf(list.size())));
                }
                C0817Rq c0817Rq = new C0817Rq();
                while (i < list.size() - 1) {
                    InterfaceC0909Tq interfaceC0909TqM9631c5 = c2357sy.m9631c((InterfaceC0909Tq) list.get(i));
                    InterfaceC0909Tq interfaceC0909TqM9631c6 = c2357sy.m9631c((InterfaceC0909Tq) list.get(i + 1));
                    if ((interfaceC0909TqM9631c5 instanceof C0174Dq) || (interfaceC0909TqM9631c6 instanceof C0174Dq)) {
                        throw new IllegalStateException("Failed to evaluate map entry");
                    }
                    c0817Rq.mo1619p(interfaceC0909TqM9631c5.mo154h(), interfaceC0909TqM9631c6);
                    i += 2;
                }
                return c0817Rq;
            case 5:
                AbstractC1145Yw.m5004k(EnumC2259qs.EXPRESSION_LIST, 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c7 = InterfaceC0909Tq.f2785d;
                while (i < list.size()) {
                    interfaceC0909TqM9631c7 = c2357sy.m9631c((InterfaceC0909Tq) list.get(i));
                    if (interfaceC0909TqM9631c7 instanceof C0174Dq) {
                        throw new IllegalStateException("ControlValue cannot be in an expression list");
                    }
                    i++;
                }
                return interfaceC0909TqM9631c7;
            case 6:
                AbstractC1145Yw.m5000g(EnumC2259qs.GET, 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c8 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (interfaceC0909TqM9631c8 instanceof C1093Xq) {
                    return c2357sy.m9629a(interfaceC0909TqM9631c8.mo154h());
                }
                throw new IllegalArgumentException(String.format("Expected string for get var. got %s", interfaceC0909TqM9631c8.getClass().getCanonicalName()));
            case 7:
            case 8:
                AbstractC1145Yw.m5000g(EnumC2259qs.GET_PROPERTY, 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c9 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                InterfaceC0909Tq interfaceC0909TqM9631c10 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                if ((interfaceC0909TqM9631c9 instanceof C2257qq) && AbstractC1145Yw.m5005l(interfaceC0909TqM9631c10)) {
                    return ((C2257qq) interfaceC0909TqM9631c9).m9192r(interfaceC0909TqM9631c10.mo153f().intValue());
                }
                if (interfaceC0909TqM9631c9 instanceof InterfaceC0358Hq) {
                    return ((InterfaceC0358Hq) interfaceC0909TqM9631c9).mo1617g(interfaceC0909TqM9631c10.mo154h());
                }
                if (interfaceC0909TqM9631c9 instanceof C1093Xq) {
                    if ("length".equals(interfaceC0909TqM9631c10.mo154h())) {
                        return new C0036Aq(Double.valueOf(interfaceC0909TqM9631c9.mo154h().length()));
                    }
                    if (AbstractC1145Yw.m5005l(interfaceC0909TqM9631c10) && interfaceC0909TqM9631c10.mo153f().doubleValue() < interfaceC0909TqM9631c9.mo154h().length()) {
                        return new C1093Xq(String.valueOf(interfaceC0909TqM9631c9.mo154h().charAt(interfaceC0909TqM9631c10.mo153f().intValue())));
                    }
                }
                return InterfaceC0909Tq.f2785d;
            case 9:
                AbstractC1145Yw.m5000g(EnumC2259qs.NULL, 0, list);
                return InterfaceC0909Tq.f2786e;
            case 10:
                AbstractC1145Yw.m5000g(EnumC2259qs.SET_PROPERTY, 3, list);
                InterfaceC0909Tq interfaceC0909TqM9631c11 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                InterfaceC0909Tq interfaceC0909TqM9631c12 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                InterfaceC0909Tq interfaceC0909TqM9631c13 = c2357sy.m9631c((InterfaceC0909Tq) list.get(2));
                if (interfaceC0909TqM9631c11 == InterfaceC0909Tq.f2785d || interfaceC0909TqM9631c11 == InterfaceC0909Tq.f2786e) {
                    throw new IllegalStateException(String.format("Can't set property %s of %s", interfaceC0909TqM9631c12.mo154h(), interfaceC0909TqM9631c11.mo154h()));
                }
                if ((interfaceC0909TqM9631c11 instanceof C2257qq) && (interfaceC0909TqM9631c12 instanceof C0036Aq)) {
                    ((C2257qq) interfaceC0909TqM9631c11).m9198x(interfaceC0909TqM9631c12.mo153f().intValue(), interfaceC0909TqM9631c13);
                } else if (interfaceC0909TqM9631c11 instanceof InterfaceC0358Hq) {
                    ((InterfaceC0358Hq) interfaceC0909TqM9631c11).mo1619p(interfaceC0909TqM9631c12.mo154h(), interfaceC0909TqM9631c13);
                }
                return interfaceC0909TqM9631c13;
            case 11:
                AbstractC1145Yw.m5000g(EnumC2259qs.TYPEOF, 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c14 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (interfaceC0909TqM9631c14 instanceof C1842hr) {
                    str2 = "undefined";
                } else if (interfaceC0909TqM9631c14 instanceof C2395tq) {
                    str2 = "boolean";
                } else if (interfaceC0909TqM9631c14 instanceof C0036Aq) {
                    str2 = "number";
                } else if (interfaceC0909TqM9631c14 instanceof C1093Xq) {
                    str2 = "string";
                } else if (interfaceC0909TqM9631c14 instanceof C1001Vq) {
                    str2 = "function";
                } else {
                    if ((interfaceC0909TqM9631c14 instanceof C1185Zq) || (interfaceC0909TqM9631c14 instanceof C0174Dq)) {
                        throw new IllegalArgumentException(String.format("Unsupported value type %s in typeof", interfaceC0909TqM9631c14));
                    }
                    str2 = "object";
                }
                return new C1093Xq(str2);
            case 12:
                AbstractC1145Yw.m5000g(EnumC2259qs.UNDEFINED, 0, list);
                return InterfaceC0909Tq.f2785d;
            case 13:
                AbstractC1145Yw.m5004k(EnumC2259qs.VAR, 1, list);
                Iterator it2 = list.iterator();
                while (it2.hasNext()) {
                    InterfaceC0909Tq interfaceC0909TqM9631c15 = c2357sy.m9631c((InterfaceC0909Tq) it2.next());
                    if (!(interfaceC0909TqM9631c15 instanceof C1093Xq)) {
                        throw new IllegalArgumentException(String.format("Expected string for var name. got %s", interfaceC0909TqM9631c15.getClass().getCanonicalName()));
                    }
                    c2357sy.m9633e(interfaceC0909TqM9631c15.mo154h(), InterfaceC0909Tq.f2785d);
                }
                return InterfaceC0909Tq.f2785d;
            default:
                return super.m8207a(str);
        }
    }
}
