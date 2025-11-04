package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractC1145Yw {
    public static double m4994a(double d) {
        if (Double.isNaN(d)) {
            return 0.0d;
        }
        if (Double.isInfinite(d) || d == 0.0d || d == -0.0d) {
            return d;
        }
        return (d > 0.0d ? 1 : -1) * Math.floor(Math.abs(d));
    }

    public static int m4995b(C2357sy c2357sy) {
        int iM5002i = m5002i(c2357sy.m9629a("runtime.counter").mo153f().doubleValue() + 1.0d);
        if (iM5002i > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        c2357sy.m9636h("runtime.counter", new C0036Aq(Double.valueOf(iM5002i)));
        return iM5002i;
    }

    public static Object m4996c(InterfaceC0909Tq interfaceC0909Tq) {
        if (InterfaceC0909Tq.f2786e.equals(interfaceC0909Tq)) {
            return null;
        }
        if (InterfaceC0909Tq.f2785d.equals(interfaceC0909Tq)) {
            return "";
        }
        if (interfaceC0909Tq instanceof C0817Rq) {
            return m4997d((C0817Rq) interfaceC0909Tq);
        }
        if (!(interfaceC0909Tq instanceof C2257qq)) {
            return !interfaceC0909Tq.mo153f().isNaN() ? interfaceC0909Tq.mo153f() : interfaceC0909Tq.mo154h();
        }
        ArrayList arrayList = new ArrayList<>();
        Iterator it = ((C2257qq) interfaceC0909Tq).iterator();
        while (it.hasNext()) {
            Object objM4996c = m4996c((InterfaceC0909Tq) it.next());
            if (objM4996c != null) {
                arrayList.add(objM4996c);
            }
        }
        return arrayList;
    }

    public static Map m4997d(C0817Rq c0817Rq) {
        HashMap map = new HashMap<>();
        for (String str : c0817Rq.m3834a()) {
            Object objM4996c = m4996c(c0817Rq.mo1617g(str));
            if (objM4996c != null) {
                map.put(str, objM4996c);
            }
        }
        return map;
    }

    public static EnumC2259qs m4998e(String str) {
        EnumC2259qs enumC2259qsM9203c = (str == null || str.isEmpty()) ? null : EnumC2259qs.m9203c(Integer.parseInt(str));
        if (enumC2259qsM9203c != null) {
            return enumC2259qsM9203c;
        }
        throw new IllegalArgumentException(String.format("Unsupported commandId %s", str));
    }

    public static void m4999f(String str, int i, List list) {
        if (list.size() != i) {
            throw new IllegalArgumentException(String.format("%s operation requires %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void m5000g(EnumC2259qs enumC2259qs, int i, List list) {
        m4999f(enumC2259qs.name(), i, list);
    }

    public static boolean m5001h(InterfaceC0909Tq interfaceC0909Tq, InterfaceC0909Tq interfaceC0909Tq2) {
        if (!interfaceC0909Tq.getClass().equals(interfaceC0909Tq2.getClass())) {
            return false;
        }
        if ((interfaceC0909Tq instanceof C1842hr) || (interfaceC0909Tq instanceof C0726Pq)) {
            return true;
        }
        if (!(interfaceC0909Tq instanceof C0036Aq)) {
            return interfaceC0909Tq instanceof C1093Xq ? interfaceC0909Tq.mo154h().equals(interfaceC0909Tq2.mo154h()) : interfaceC0909Tq instanceof C2395tq ? interfaceC0909Tq.mo152d().equals(interfaceC0909Tq2.mo152d()) : interfaceC0909Tq == interfaceC0909Tq2;
        }
        if (Double.isNaN(interfaceC0909Tq.mo153f().doubleValue()) || Double.isNaN(interfaceC0909Tq2.mo153f().doubleValue())) {
            return false;
        }
        return interfaceC0909Tq.mo153f().equals(interfaceC0909Tq2.mo153f());
    }

    public static int m5002i(double d) {
        if (Double.isNaN(d) || Double.isInfinite(d) || d == 0.0d) {
            return 0;
        }
        return (int) (((d > 0.0d ? 1 : -1) * Math.floor(Math.abs(d))) % 4.294967296E9d);
    }

    public static void m5003j(String str, int i, List list) {
        if (list.size() < i) {
            throw new IllegalArgumentException(String.format("%s operation requires at least %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }

    public static void m5004k(EnumC2259qs enumC2259qs, int i, List list) {
        m5003j(enumC2259qs.name(), i, list);
    }

    public static boolean m5005l(InterfaceC0909Tq interfaceC0909Tq) {
        if (interfaceC0909Tq == null) {
            return false;
        }
        Double dMo153f = interfaceC0909Tq.mo153f();
        return !dMo153f.isNaN() && dMo153f.doubleValue() >= 0.0d && dMo153f.equals(Double.valueOf(Math.floor(dMo153f.doubleValue())));
    }

    public static long m5006m(double d) {
        return m5002i(d) & 4294967295L;
    }

    public static void m5007n(String str, int i, List list) {
        if (list.size() > i) {
            throw new IllegalArgumentException(String.format("%s operation requires at most %s parameters found %s", str, Integer.valueOf(i), Integer.valueOf(list.size())));
        }
    }
}
