package p000;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractC0634Nq {
    public static Iterator m3338a(Map map) {
        return new C0542Lq(map.keySet().iterator());
    }

    public static InterfaceC0909Tq m3339b(InterfaceC0358Hq interfaceC0358Hq, InterfaceC0909Tq interfaceC0909Tq, C2357sy c2357sy, List list) {
        if (interfaceC0358Hq.mo1618k(interfaceC0909Tq.mo154h())) {
            InterfaceC0909Tq interfaceC0909TqMo1617g = interfaceC0358Hq.mo1617g(interfaceC0909Tq.mo154h());
            if (interfaceC0909TqMo1617g instanceof AbstractC0450Jq) {
                return ((AbstractC0450Jq) interfaceC0909TqMo1617g).mo1366b(c2357sy, list);
            }
            throw new IllegalArgumentException(String.format("%s is not a function", interfaceC0909Tq.mo154h()));
        }
        if (!"hasOwnProperty".equals(interfaceC0909Tq.mo154h())) {
            throw new IllegalArgumentException(String.format("Object has no function %s", interfaceC0909Tq.mo154h()));
        }
        AbstractC1145Yw.m4999f("hasOwnProperty", 1, list);
        return interfaceC0358Hq.mo1618k(c2357sy.m9631c((InterfaceC0909Tq) list.get(0)).mo154h()) ? InterfaceC0909Tq.f2790i : InterfaceC0909Tq.f2791j;
    }
}
