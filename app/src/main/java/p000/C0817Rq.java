package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C0817Rq implements InterfaceC0358Hq, InterfaceC0909Tq {

    public final Map f2428l = new HashMap<>();

    public final List m3834a() {
        return new ArrayList<>(this.f2428l.keySet());
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        Map map;
        String str;
        InterfaceC0909Tq interfaceC0909TqMo151c;
        C0817Rq c0817Rq = new C0817Rq();
        for (Map.Entry entry : this.f2428l.entrySet()) {
            if (entry.getValue() instanceof InterfaceC0358Hq) {
                map = c0817Rq.f2428l;
                str = (String) entry.getKey();
                interfaceC0909TqMo151c = (InterfaceC0909Tq) entry.getValue();
            } else {
                map = c0817Rq.f2428l;
                str = (String) entry.getKey();
                interfaceC0909TqMo151c = ((InterfaceC0909Tq) entry.getValue()).mo151c();
            }
            map.put(str, interfaceC0909TqMo151c);
        }
        return c0817Rq;
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C0817Rq) {
            return this.f2428l.equals(((C0817Rq) obj).f2428l);
        }
        return false;
    }

    @Override
    public final Double mo153f() {
        return Double.valueOf(Double.NaN);
    }

    @Override
    public final InterfaceC0909Tq mo1617g(String str) {
        return this.f2428l.containsKey(str) ? (InterfaceC0909Tq) this.f2428l.get(str) : InterfaceC0909Tq.f2785d;
    }

    @Override
    public final String mo154h() {
        return "[object Object]";
    }

    public int hashCode() {
        return this.f2428l.hashCode();
    }

    @Override
    public final Iterator mo155i() {
        return AbstractC0634Nq.m3338a(this.f2428l);
    }

    @Override
    public final boolean mo1618k(String str) {
        return this.f2428l.containsKey(str);
    }

    public InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        return "toString".equals(str) ? new C1093Xq(toString()) : AbstractC0634Nq.m3339b(this, new C1093Xq(str), c2357sy, list);
    }

    @Override
    public final void mo1619p(String str, InterfaceC0909Tq interfaceC0909Tq) {
        if (interfaceC0909Tq == null) {
            this.f2428l.remove(str);
        } else {
            this.f2428l.put(str, interfaceC0909Tq);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        if (!this.f2428l.isEmpty()) {
            for (String str : this.f2428l.keySet()) {
                sb.append(String.format("%s: %s,", str, this.f2428l.get(str)));
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("}");
        return sb.toString();
    }
}
