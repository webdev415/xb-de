package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C0129Cr {

    public Map f320a = new HashMap<>();

    public C1796gs f321b = new C1796gs();

    public C0129Cr() {
        m527b(new C1748fr());
        m527b(new C0037Ar());
        m527b(new C0221Er());
        m527b(new C0589Mr());
        m527b(new C0773Qr());
        m527b(new C1609cs());
        m527b(new C2074ms());
    }

    public final InterfaceC0909Tq m526a(C2357sy c2357sy, InterfaceC0909Tq interfaceC0909Tq) {
        AbstractC1145Yw.m4995b(c2357sy);
        if (!(interfaceC0909Tq instanceof C1185Zq)) {
            return interfaceC0909Tq;
        }
        C1185Zq c1185Zq = (C1185Zq) interfaceC0909Tq;
        ArrayList arrayListM5085b = c1185Zq.m5085b();
        String strM5084a = c1185Zq.m5084a();
        return (this.f320a.containsKey(strM5084a) ? (AbstractC1935jr) this.f320a.get(strM5084a) : this.f321b).mo160b(strM5084a, c2357sy, arrayListM5085b);
    }

    public final void m527b(AbstractC1935jr abstractC1935jr) {
        Iterator it = abstractC1935jr.f5966a.iterator();
        while (it.hasNext()) {
            this.f320a.put(((EnumC2259qs) it.next()).toString(), abstractC1935jr);
        }
    }
}
