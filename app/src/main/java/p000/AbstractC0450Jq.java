package p000;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractC0450Jq implements InterfaceC0358Hq, InterfaceC0909Tq {

    public final String f1460l;

    public final Map f1461m = new HashMap<>();

    public AbstractC0450Jq(String str) {
        this.f1460l = str;
    }

    public final String m2169a() {
        return this.f1460l;
    }

    public abstract InterfaceC0909Tq mo1366b(C2357sy c2357sy, List list);

    @Override
    public final Boolean mo152d() {
        return Boolean.TRUE;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC0450Jq)) {
            return false;
        }
        AbstractC0450Jq abstractC0450Jq = (AbstractC0450Jq) obj;
        String str = this.f1460l;
        if (str != null) {
            return str.equals(abstractC0450Jq.f1460l);
        }
        return false;
    }

    @Override
    public final Double mo153f() {
        return Double.valueOf(Double.NaN);
    }

    @Override
    public final InterfaceC0909Tq mo1617g(String str) {
        return this.f1461m.containsKey(str) ? (InterfaceC0909Tq) this.f1461m.get(str) : InterfaceC0909Tq.f2785d;
    }

    @Override
    public final String mo154h() {
        return this.f1460l;
    }

    public int hashCode() {
        String str = this.f1460l;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    @Override
    public final Iterator mo155i() {
        return AbstractC0634Nq.m3338a(this.f1461m);
    }

    @Override
    public final boolean mo1618k(String str) {
        return this.f1461m.containsKey(str);
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        return "toString".equals(str) ? new C1093Xq(this.f1460l) : AbstractC0634Nq.m3339b(this, new C1093Xq(str), c2357sy, list);
    }

    @Override
    public final void mo1619p(String str, InterfaceC0909Tq interfaceC0909Tq) {
        if (interfaceC0909Tq == null) {
            this.f1461m.remove(str);
        } else {
            this.f1461m.put(str, interfaceC0909Tq);
        }
    }

    @Override
    public InterfaceC0909Tq mo151c() {
        return this;
    }
}
