package p000;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class C2357sy {

    public final C2357sy f7096a;

    public C0129Cr f7097b;

    public Map f7098c = new HashMap<>();

    public Map f7099d = new HashMap<>();

    public C2357sy(C2357sy c2357sy, C0129Cr c0129Cr) {
        this.f7096a = c2357sy;
        this.f7097b = c0129Cr;
    }

    public final InterfaceC0909Tq m9629a(String str) {
        C2357sy c2357sy = this;
        while (!c2357sy.f7098c.containsKey(str)) {
            c2357sy = c2357sy.f7096a;
            if (c2357sy == null) {
                throw new IllegalArgumentException(String.format("%s is not defined", str));
            }
        }
        return (InterfaceC0909Tq) c2357sy.f7098c.get(str);
    }

    public final InterfaceC0909Tq m9630b(C2257qq c2257qq) {
        InterfaceC0909Tq interfaceC0909TqM526a = InterfaceC0909Tq.f2785d;
        Iterator itM9200z = c2257qq.m9200z();
        while (itM9200z.hasNext()) {
            interfaceC0909TqM526a = this.f7097b.m526a(this, c2257qq.m9192r(((Integer) itM9200z.next()).intValue()));
            if (interfaceC0909TqM526a instanceof C0174Dq) {
                break;
            }
        }
        return interfaceC0909TqM526a;
    }

    public final InterfaceC0909Tq m9631c(InterfaceC0909Tq interfaceC0909Tq) {
        return this.f7097b.m526a(this, interfaceC0909Tq);
    }

    public final C2357sy m9632d() {
        return new C2357sy(this, this.f7097b);
    }

    public final void m9633e(String str, InterfaceC0909Tq interfaceC0909Tq) {
        if (this.f7099d.containsKey(str)) {
            return;
        }
        if (interfaceC0909Tq == null) {
            this.f7098c.remove(str);
        } else {
            this.f7098c.put(str, interfaceC0909Tq);
        }
    }

    public final void m9634f(String str, InterfaceC0909Tq interfaceC0909Tq) {
        m9633e(str, interfaceC0909Tq);
        this.f7099d.put(str, Boolean.TRUE);
    }

    public final boolean m9635g(String str) {
        C2357sy c2357sy = this;
        while (!c2357sy.f7098c.containsKey(str)) {
            c2357sy = c2357sy.f7096a;
            if (c2357sy == null) {
                return false;
            }
        }
        return true;
    }

    public final void m9636h(String str, InterfaceC0909Tq interfaceC0909Tq) {
        C2357sy c2357sy;
        C2357sy c2357sy2 = this;
        while (!c2357sy2.f7098c.containsKey(str) && (c2357sy = c2357sy2.f7096a) != null && c2357sy.m9635g(str)) {
            c2357sy2 = c2357sy2.f7096a;
        }
        if (c2357sy2.f7099d.containsKey(str)) {
            return;
        }
        if (interfaceC0909Tq == null) {
            c2357sy2.f7098c.remove(str);
        } else {
            c2357sy2.f7098c.put(str, interfaceC0909Tq);
        }
    }
}
