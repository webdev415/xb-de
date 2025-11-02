package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC0103CA {
    public static InterfaceC0909Tq m414a(Object obj) {
        if (obj == null) {
            return InterfaceC0909Tq.f2786e;
        }
        if (obj instanceof String) {
            return new C1093Xq((String) obj);
        }
        if (obj instanceof Double) {
            return new C0036Aq((Double) obj);
        }
        if (obj instanceof Long) {
            return new C0036Aq(Double.valueOf(((Long) obj).doubleValue()));
        }
        if (obj instanceof Integer) {
            return new C0036Aq(Double.valueOf(((Integer) obj).doubleValue()));
        }
        if (obj instanceof Boolean) {
            return new C2395tq((Boolean) obj);
        }
        if (!(obj instanceof Map)) {
            if (!(obj instanceof List)) {
                throw new IllegalArgumentException("Invalid value type");
            }
            C2257qq c2257qq = new C2257qq();
            Iterator it = ((List) obj).iterator();
            while (it.hasNext()) {
                c2257qq.m9194t(m414a(it.next()));
            }
            return c2257qq;
        }
        C0817Rq c0817Rq = new C0817Rq();
        Map map = (Map) obj;
        for (Object string : map.keySet()) {
            InterfaceC0909Tq interfaceC0909TqM414a = m414a(map.get(string));
            if (string != null) {
                if (!(string instanceof String)) {
                    string = string.toString();
                }
                c0817Rq.mo1619p((String) string, interfaceC0909TqM414a);
            }
        }
        return c0817Rq;
    }

    public static InterfaceC0909Tq m415b(C0550Ly c0550Ly) {
        if (c0550Ly == null) {
            return InterfaceC0909Tq.f2785d;
        }
        int i = AbstractC0045Az.f101a[c0550Ly.m2797H().ordinal()];
        if (i == 1) {
            return c0550Ly.m2804P() ? new C1093Xq(c0550Ly.m2799K()) : InterfaceC0909Tq.f2792k;
        }
        if (i == 2) {
            return c0550Ly.m2803O() ? new C0036Aq(Double.valueOf(c0550Ly.m2796G())) : new C0036Aq(null);
        }
        if (i == 3) {
            return c0550Ly.m2802N() ? new C2395tq(Boolean.valueOf(c0550Ly.m2801M())) : new C2395tq(null);
        }
        if (i != 4) {
            if (i == 5) {
                throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
            }
            throw new IllegalStateException("Invalid entity: " + String.valueOf(c0550Ly));
        }
        List listM2800L = c0550Ly.m2800L();
        ArrayList arrayList = new ArrayList<>();
        Iterator it = listM2800L.iterator();
        while (it.hasNext()) {
            arrayList.add(m415b((C0550Ly) it.next()));
        }
        return new C1185Zq(c0550Ly.m2798J(), arrayList);
    }
}
