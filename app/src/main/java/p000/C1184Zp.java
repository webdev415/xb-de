package p000;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;

/* loaded from: classes.dex */
public final class C1184Zp {

    public final TreeMap f3474a = new TreeMap();

    public final TreeMap f3475b = new TreeMap();

    public static int m5081a(C2357sy c2357sy, C1001Vq c1001Vq, InterfaceC0909Tq interfaceC0909Tq) {
        InterfaceC0909Tq interfaceC0909TqMo1366b = c1001Vq.mo1366b(c2357sy, Collections.singletonList(interfaceC0909Tq));
        if (interfaceC0909TqMo1366b instanceof C0036Aq) {
            return AbstractC1145Yw.m5002i(interfaceC0909TqMo1366b.mo153f().doubleValue());
        }
        return -1;
    }

    public final void m5082b(String str, int i, C1001Vq c1001Vq, String str2) {
        TreeMap treeMap;
        if ("create".equals(str2)) {
            treeMap = this.f3475b;
        } else {
            if (!"edit".equals(str2)) {
                throw new IllegalStateException("Unknown callback type: " + str2);
            }
            treeMap = this.f3474a;
        }
        if (treeMap.containsKey(Integer.valueOf(i))) {
            i = ((Integer) treeMap.lastKey()).intValue() + 1;
        }
        treeMap.put(Integer.valueOf(i), c1001Vq);
    }

    public final void m5083c(C2357sy c2357sy, C1700eq c1700eq) {
        C0567ME c0567me = new C0567ME(c1700eq);
        for (Integer num : this.f3474a.keySet()) {
            C1888iq c1888iq = (C1888iq) c1700eq.m7476d().clone();
            int iM5081a = m5081a(c2357sy, (C1001Vq) this.f3474a.get(num), c0567me);
            if (iM5081a == 2 || iM5081a == -1) {
                c1700eq.m7477e(c1888iq);
            }
        }
        Iterator it = this.f3475b.keySet().iterator();
        while (it.hasNext()) {
            m5081a(c2357sy, (C1001Vq) this.f3475b.get((Integer) it.next()), c0567me);
        }
    }
}
