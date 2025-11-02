package p000;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractC0405Ir {
    public static C2257qq m1719a(C2257qq c2257qq, C2357sy c2357sy, AbstractC0450Jq abstractC0450Jq) {
        return m1720b(c2257qq, c2357sy, abstractC0450Jq, null, null);
    }

    public static C2257qq m1720b(C2257qq c2257qq, C2357sy c2357sy, AbstractC0450Jq abstractC0450Jq, Boolean bool, Boolean bool2) {
        C2257qq c2257qq2 = new C2257qq();
        Iterator itM9200z = c2257qq.m9200z();
        while (itM9200z.hasNext()) {
            int iIntValue = ((Integer) itM9200z.next()).intValue();
            if (c2257qq.m9199y(iIntValue)) {
                InterfaceC0909Tq interfaceC0909TqMo1366b = abstractC0450Jq.mo1366b(c2357sy, Arrays.asList(c2257qq.m9192r(iIntValue), new C0036Aq(Double.valueOf(iIntValue)), c2257qq));
                if (interfaceC0909TqMo1366b.mo152d().equals(bool)) {
                    return c2257qq2;
                }
                if (bool2 == null || interfaceC0909TqMo1366b.mo152d().equals(bool2)) {
                    c2257qq2.m9198x(iIntValue, interfaceC0909TqMo1366b);
                }
            }
        }
        return c2257qq2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static InterfaceC0909Tq m1721c(String str, C2257qq c2257qq, C2357sy c2357sy, List list) {
        String str2;
        char c;
        double d;
        String strMo154h;
        AbstractC0450Jq abstractC0450Jq;
        int i;
        C2357sy c2357sy2;
        Double d2;
        double dM4994a;
        str.hashCode();
        Double dValueOf = Double.valueOf(-1.0d);
        switch (str.hashCode()) {
            case -1776922004:
                str2 = "toString";
                if (str.equals(str2)) {
                    c = 0;
                    break;
                } else {
                    c = 65535;
                    break;
                }
            case -1354795244:
                if (str.equals("concat")) {
                    str2 = "toString";
                    c = 1;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -1274492040:
                if (str.equals("filter")) {
                    c = 2;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -934873754:
                if (str.equals("reduce")) {
                    str2 = "toString";
                    c = 3;
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -895859076:
                if (str.equals("splice")) {
                    c = 4;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -678635926:
                if (str.equals("forEach")) {
                    c = 5;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -467511597:
                if (str.equals("lastIndexOf")) {
                    c = 6;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case -277637751:
                if (str.equals("unshift")) {
                    c = 7;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 107868:
                if (str.equals("map")) {
                    c = '\b';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 111185:
                if (str.equals("pop")) {
                    c = '\t';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3267882:
                if (str.equals("join")) {
                    c = '\n';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3452698:
                if (str.equals("push")) {
                    c = 11;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536116:
                if (str.equals("some")) {
                    c = '\f';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 3536286:
                if (str.equals("sort")) {
                    c = '\r';
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 96891675:
                if (str.equals("every")) {
                    c = 14;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109407362:
                if (str.equals("shift")) {
                    c = 15;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 109526418:
                if (str.equals("slice")) {
                    c = 16;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 965561430:
                if (str.equals("reduceRight")) {
                    c = 17;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1099846370:
                if (str.equals("reverse")) {
                    c = 18;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            case 1943291465:
                if (str.equals("indexOf")) {
                    c = 19;
                    str2 = "toString";
                    break;
                }
                str2 = "toString";
                c = 65535;
                break;
            default:
                str2 = "toString";
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                AbstractC1145Yw.m4999f(str2, 0, list);
                return new C1093Xq(c2257qq.toString());
            case 1:
                C2257qq c2257qq2 = (C2257qq) c2257qq.mo151c();
                if (!list.isEmpty()) {
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) it.next());
                        if (interfaceC0909TqM9631c instanceof C0174Dq) {
                            throw new IllegalStateException("Failed evaluation of arguments");
                        }
                        int iM9195u = c2257qq2.m9195u();
                        if (interfaceC0909TqM9631c instanceof C2257qq) {
                            C2257qq c2257qq3 = (C2257qq) interfaceC0909TqM9631c;
                            Iterator itM9200z = c2257qq3.m9200z();
                            while (itM9200z.hasNext()) {
                                Integer num = (Integer) itM9200z.next();
                                c2257qq2.m9198x(num.intValue() + iM9195u, c2257qq3.m9192r(num.intValue()));
                            }
                        } else {
                            c2257qq2.m9198x(iM9195u, interfaceC0909TqM9631c);
                        }
                    }
                }
                return c2257qq2;
            case 2:
                AbstractC1145Yw.m4999f("filter", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c2 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (!(interfaceC0909TqM9631c2 instanceof C1001Vq)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (c2257qq.m9191q() == 0) {
                    return new C2257qq();
                }
                C2257qq c2257qq4 = (C2257qq) c2257qq.mo151c();
                C2257qq c2257qqM1720b = m1720b(c2257qq, c2357sy, (C1001Vq) interfaceC0909TqM9631c2, null, Boolean.TRUE);
                C2257qq c2257qq5 = new C2257qq();
                Iterator itM9200z2 = c2257qqM1720b.m9200z();
                while (itM9200z2.hasNext()) {
                    c2257qq5.m9194t(c2257qq4.m9192r(((Integer) itM9200z2.next()).intValue()));
                }
                return c2257qq5;
            case 3:
                return m1722d(c2257qq, c2357sy, list, true);
            case 4:
                if (list.isEmpty()) {
                    return new C2257qq();
                }
                int iM4994a = (int) AbstractC1145Yw.m4994a(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue());
                if (iM4994a < 0) {
                    iM4994a = Math.max(0, iM4994a + c2257qq.m9195u());
                } else if (iM4994a > c2257qq.m9195u()) {
                    iM4994a = c2257qq.m9195u();
                }
                int iM9195u2 = c2257qq.m9195u();
                C2257qq c2257qq6 = new C2257qq();
                if (list.size() <= 1) {
                    while (iM4994a < iM9195u2) {
                        c2257qq6.m9194t(c2257qq.m9192r(iM4994a));
                        c2257qq.m9198x(iM4994a, null);
                        iM4994a++;
                    }
                    return c2257qq6;
                }
                int iMax = Math.max(0, (int) AbstractC1145Yw.m4994a(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue()));
                if (iMax > 0) {
                    for (int i2 = iM4994a; i2 < Math.min(iM9195u2, iM4994a + iMax); i2++) {
                        c2257qq6.m9194t(c2257qq.m9192r(iM4994a));
                        c2257qq.m9197w(iM4994a);
                    }
                }
                if (list.size() > 2) {
                    for (int i3 = 2; i3 < list.size(); i3++) {
                        InterfaceC0909Tq interfaceC0909TqM9631c3 = c2357sy.m9631c((InterfaceC0909Tq) list.get(i3));
                        if (interfaceC0909TqM9631c3 instanceof C0174Dq) {
                            throw new IllegalArgumentException("Failed to parse elements to add");
                        }
                        c2257qq.m9193s((iM4994a + i3) - 2, interfaceC0909TqM9631c3);
                    }
                }
                return c2257qq6;
            case 5:
                AbstractC1145Yw.m4999f("forEach", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c4 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (!(interfaceC0909TqM9631c4 instanceof C1001Vq)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (c2257qq.m9191q() == 0) {
                    return InterfaceC0909Tq.f2785d;
                }
                m1719a(c2257qq, c2357sy, (C1001Vq) interfaceC0909TqM9631c4);
                return InterfaceC0909Tq.f2785d;
            case 6:
                AbstractC1145Yw.m5007n("lastIndexOf", 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c5 = InterfaceC0909Tq.f2785d;
                if (!list.isEmpty()) {
                    interfaceC0909TqM9631c5 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                }
                double dM9195u = c2257qq.m9195u() - 1;
                if (list.size() > 1) {
                    InterfaceC0909Tq interfaceC0909TqM9631c6 = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
                    dM9195u = Double.isNaN(interfaceC0909TqM9631c6.mo153f().doubleValue()) ? c2257qq.m9195u() - 1 : AbstractC1145Yw.m4994a(interfaceC0909TqM9631c6.mo153f().doubleValue());
                    d = 0.0d;
                    if (dM9195u < 0.0d) {
                        dM9195u += c2257qq.m9195u();
                    }
                } else {
                    d = 0.0d;
                }
                if (dM9195u < d) {
                    return new C0036Aq(dValueOf);
                }
                for (int iMin = (int) Math.min(c2257qq.m9195u(), dM9195u); iMin >= 0; iMin--) {
                    if (c2257qq.m9199y(iMin) && AbstractC1145Yw.m5001h(c2257qq.m9192r(iMin), interfaceC0909TqM9631c5)) {
                        return new C0036Aq(Double.valueOf(iMin));
                    }
                }
                return new C0036Aq(dValueOf);
            case 7:
                if (!list.isEmpty()) {
                    C2257qq c2257qq7 = new C2257qq();
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        InterfaceC0909Tq interfaceC0909TqM9631c7 = c2357sy.m9631c((InterfaceC0909Tq) it2.next());
                        if (interfaceC0909TqM9631c7 instanceof C0174Dq) {
                            throw new IllegalStateException("Argument evaluation failed");
                        }
                        c2257qq7.m9194t(interfaceC0909TqM9631c7);
                    }
                    int iM9195u3 = c2257qq7.m9195u();
                    Iterator itM9200z3 = c2257qq.m9200z();
                    while (itM9200z3.hasNext()) {
                        Integer num2 = (Integer) itM9200z3.next();
                        c2257qq7.m9198x(num2.intValue() + iM9195u3, c2257qq.m9192r(num2.intValue()));
                    }
                    c2257qq.m9190B();
                    Iterator itM9200z4 = c2257qq7.m9200z();
                    while (itM9200z4.hasNext()) {
                        Integer num3 = (Integer) itM9200z4.next();
                        c2257qq.m9198x(num3.intValue(), c2257qq7.m9192r(num3.intValue()));
                    }
                }
                return new C0036Aq(Double.valueOf(c2257qq.m9195u()));
            case '\b':
                AbstractC1145Yw.m4999f("map", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c8 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (interfaceC0909TqM9631c8 instanceof C1001Vq) {
                    return c2257qq.m9195u() == 0 ? new C2257qq() : m1719a(c2257qq, c2357sy, (C1001Vq) interfaceC0909TqM9631c8);
                }
                throw new IllegalArgumentException("Callback should be a method");
            case '\t':
                AbstractC1145Yw.m4999f("pop", 0, list);
                int iM9195u4 = c2257qq.m9195u();
                if (iM9195u4 == 0) {
                    return InterfaceC0909Tq.f2785d;
                }
                int i4 = iM9195u4 - 1;
                InterfaceC0909Tq interfaceC0909TqM9192r = c2257qq.m9192r(i4);
                c2257qq.m9197w(i4);
                return interfaceC0909TqM9192r;
            case '\n':
                AbstractC1145Yw.m5007n("join", 1, list);
                if (c2257qq.m9195u() == 0) {
                    return InterfaceC0909Tq.f2792k;
                }
                if (list.isEmpty()) {
                    strMo154h = ",";
                } else {
                    InterfaceC0909Tq interfaceC0909TqM9631c9 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                    strMo154h = ((interfaceC0909TqM9631c9 instanceof C0726Pq) || (interfaceC0909TqM9631c9 instanceof C1842hr)) ? "" : interfaceC0909TqM9631c9.mo154h();
                }
                return new C1093Xq(c2257qq.m9196v(strMo154h));
            case 11:
                if (!list.isEmpty()) {
                    Iterator it3 = list.iterator();
                    while (it3.hasNext()) {
                        c2257qq.m9194t(c2357sy.m9631c((InterfaceC0909Tq) it3.next()));
                    }
                }
                return new C0036Aq(Double.valueOf(c2257qq.m9195u()));
            case '\f':
                AbstractC1145Yw.m4999f("some", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c10 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (!(interfaceC0909TqM9631c10 instanceof AbstractC0450Jq)) {
                    throw new IllegalArgumentException("Callback should be a method");
                }
                if (c2257qq.m9195u() != 0) {
                    AbstractC0450Jq abstractC0450Jq2 = (AbstractC0450Jq) interfaceC0909TqM9631c10;
                    Iterator itM9200z5 = c2257qq.m9200z();
                    while (itM9200z5.hasNext()) {
                        int iIntValue = ((Integer) itM9200z5.next()).intValue();
                        if (c2257qq.m9199y(iIntValue) && abstractC0450Jq2.mo1366b(c2357sy, Arrays.asList(c2257qq.m9192r(iIntValue), new C0036Aq(Double.valueOf(iIntValue)), c2257qq)).mo152d().booleanValue()) {
                            return InterfaceC0909Tq.f2790i;
                        }
                    }
                }
                return InterfaceC0909Tq.f2791j;
            case '\r':
                AbstractC1145Yw.m5007n("sort", 1, list);
                if (c2257qq.m9195u() >= 2) {
                    List listM9189A = c2257qq.m9189A();
                    if (list.isEmpty()) {
                        abstractC0450Jq = null;
                    } else {
                        InterfaceC0909Tq interfaceC0909TqM9631c11 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                        if (!(interfaceC0909TqM9631c11 instanceof AbstractC0450Jq)) {
                            throw new IllegalArgumentException("Comparator should be a method");
                        }
                        abstractC0450Jq = (AbstractC0450Jq) interfaceC0909TqM9631c11;
                    }
                    Collections.sort(listM9189A, new C0681Or(abstractC0450Jq, c2357sy));
                    c2257qq.m9190B();
                    Iterator it4 = listM9189A.iterator();
                    int i5 = 0;
                    while (it4.hasNext()) {
                        c2257qq.m9198x(i5, (InterfaceC0909Tq) it4.next());
                        i5++;
                    }
                }
                return c2257qq;
            case 14:
                AbstractC1145Yw.m4999f("every", 1, list);
                InterfaceC0909Tq interfaceC0909TqM9631c12 = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
                if (interfaceC0909TqM9631c12 instanceof C1001Vq) {
                    return (c2257qq.m9195u() == 0 || m1720b(c2257qq, c2357sy, (C1001Vq) interfaceC0909TqM9631c12, Boolean.FALSE, Boolean.TRUE).m9195u() == c2257qq.m9195u()) ? InterfaceC0909Tq.f2790i : InterfaceC0909Tq.f2791j;
                }
                throw new IllegalArgumentException("Callback should be a method");
            case 15:
                AbstractC1145Yw.m4999f("shift", 0, list);
                if (c2257qq.m9195u() == 0) {
                    return InterfaceC0909Tq.f2785d;
                }
                InterfaceC0909Tq interfaceC0909TqM9192r2 = c2257qq.m9192r(0);
                c2257qq.m9197w(0);
                return interfaceC0909TqM9192r2;
            case 16:
                AbstractC1145Yw.m5007n("slice", 2, list);
                if (list.isEmpty()) {
                    return c2257qq.mo151c();
                }
                double dM9195u2 = c2257qq.m9195u();
                double dM4994a2 = AbstractC1145Yw.m4994a(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo153f().doubleValue());
                double dMax = dM4994a2 < 0.0d ? Math.max(dM4994a2 + dM9195u2, 0.0d) : Math.min(dM4994a2, dM9195u2);
                if (list.size() == 2) {
                    double dM4994a3 = AbstractC1145Yw.m4994a(c2357sy.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue());
                    dM9195u2 = dM4994a3 < 0.0d ? Math.max(dM9195u2 + dM4994a3, 0.0d) : Math.min(dM9195u2, dM4994a3);
                }
                C2257qq c2257qq8 = new C2257qq();
                for (int i6 = (int) dMax; i6 < dM9195u2; i6++) {
                    c2257qq8.m9194t(c2257qq.m9192r(i6));
                }
                return c2257qq8;
            case 17:
                return m1722d(c2257qq, c2357sy, list, false);
            case 18:
                AbstractC1145Yw.m4999f("reverse", 0, list);
                int iM9195u5 = c2257qq.m9195u();
                if (iM9195u5 != 0) {
                    int i7 = 0;
                    while (i7 < iM9195u5 / 2) {
                        if (c2257qq.m9199y(i7)) {
                            InterfaceC0909Tq interfaceC0909TqM9192r3 = c2257qq.m9192r(i7);
                            c2257qq.m9198x(i7, null);
                            i = 1;
                            int i8 = (iM9195u5 - 1) - i7;
                            if (c2257qq.m9199y(i8)) {
                                c2257qq.m9198x(i7, c2257qq.m9192r(i8));
                            }
                            c2257qq.m9198x(i8, interfaceC0909TqM9192r3);
                        } else {
                            i = 1;
                        }
                        i7 += i;
                    }
                }
                return c2257qq;
            case 19:
                AbstractC1145Yw.m5007n("indexOf", 2, list);
                InterfaceC0909Tq interfaceC0909TqM9631c13 = InterfaceC0909Tq.f2785d;
                if (list.isEmpty()) {
                    c2357sy2 = c2357sy;
                } else {
                    c2357sy2 = c2357sy;
                    interfaceC0909TqM9631c13 = c2357sy2.m9631c((InterfaceC0909Tq) list.get(0));
                }
                if (list.size() > 1) {
                    dM4994a = AbstractC1145Yw.m4994a(c2357sy2.m9631c((InterfaceC0909Tq) list.get(1)).mo153f().doubleValue());
                    if (dM4994a >= c2257qq.m9195u()) {
                        return new C0036Aq(dValueOf);
                    }
                    d2 = dValueOf;
                    if (dM4994a < 0.0d) {
                        dM4994a += c2257qq.m9195u();
                    }
                } else {
                    d2 = dValueOf;
                    dM4994a = 0.0d;
                }
                Iterator itM9200z6 = c2257qq.m9200z();
                while (itM9200z6.hasNext()) {
                    int iIntValue2 = ((Integer) itM9200z6.next()).intValue();
                    double d3 = iIntValue2;
                    if (d3 >= dM4994a && AbstractC1145Yw.m5001h(c2257qq.m9192r(iIntValue2), interfaceC0909TqM9631c13)) {
                        return new C0036Aq(Double.valueOf(d3));
                    }
                }
                return new C0036Aq(d2);
            default:
                throw new IllegalArgumentException("Command not supported");
        }
    }

    public static InterfaceC0909Tq m1722d(C2257qq c2257qq, C2357sy c2357sy, List list, boolean z) {
        InterfaceC0909Tq interfaceC0909TqMo1366b;
        AbstractC1145Yw.m5003j("reduce", 1, list);
        AbstractC1145Yw.m5007n("reduce", 2, list);
        InterfaceC0909Tq interfaceC0909TqM9631c = c2357sy.m9631c((InterfaceC0909Tq) list.get(0));
        if (!(interfaceC0909TqM9631c instanceof AbstractC0450Jq)) {
            throw new IllegalArgumentException("Callback should be a method");
        }
        if (list.size() == 2) {
            interfaceC0909TqMo1366b = c2357sy.m9631c((InterfaceC0909Tq) list.get(1));
            if (interfaceC0909TqMo1366b instanceof C0174Dq) {
                throw new IllegalArgumentException("Failed to parse initial value");
            }
        } else {
            if (c2257qq.m9195u() == 0) {
                throw new IllegalStateException("Empty array with no initial value error");
            }
            interfaceC0909TqMo1366b = null;
        }
        AbstractC0450Jq abstractC0450Jq = (AbstractC0450Jq) interfaceC0909TqM9631c;
        int iM9195u = c2257qq.m9195u();
        int i = z ? 0 : iM9195u - 1;
        int i2 = z ? iM9195u - 1 : 0;
        int i3 = z ? 1 : -1;
        if (interfaceC0909TqMo1366b == null) {
            interfaceC0909TqMo1366b = c2257qq.m9192r(i);
            i += i3;
        }
        while ((i2 - i) * i3 >= 0) {
            if (c2257qq.m9199y(i)) {
                interfaceC0909TqMo1366b = abstractC0450Jq.mo1366b(c2357sy, Arrays.asList(interfaceC0909TqMo1366b, c2257qq.m9192r(i), new C0036Aq(Double.valueOf(i)), c2257qq));
                if (interfaceC0909TqMo1366b instanceof C0174Dq) {
                    throw new IllegalStateException("Reduce operation failed");
                }
                i += i3;
            } else {
                i += i3;
            }
        }
        return interfaceC0909TqMo1366b;
    }
}
