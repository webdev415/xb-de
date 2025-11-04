package p000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public final class C2257qq implements InterfaceC0358Hq, InterfaceC0909Tq, Iterable {

    public final SortedMap f6743l;

    public final Map f6744m;

    public C2257qq() {
        this.f6743l = new TreeMap();
        this.f6744m = new TreeMap();
    }

    public final List m9189A() {
        ArrayList arrayList = new ArrayList<>(m9195u());
        for (int i = 0; i < m9195u(); i++) {
            arrayList.add(m9192r(i));
        }
        return arrayList;
    }

    public final void m9190B() {
        this.f6743l.clear();
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        SortedMap sortedMap;
        Integer num;
        InterfaceC0909Tq interfaceC0909TqMo151c;
        C2257qq c2257qq = new C2257qq();
        for (Map.Entry entry : this.f6743l.entrySet()) {
            if (entry.getValue() instanceof InterfaceC0358Hq) {
                sortedMap = c2257qq.f6743l;
                num = (Integer) entry.getKey();
                interfaceC0909TqMo151c = (InterfaceC0909Tq) entry.getValue();
            } else {
                sortedMap = c2257qq.f6743l;
                num = (Integer) entry.getKey();
                interfaceC0909TqMo151c = ((InterfaceC0909Tq) entry.getValue()).mo151c();
            }
            sortedMap.put(num, interfaceC0909TqMo151c);
        }
        return c2257qq;
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.TRUE;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2257qq)) {
            return false;
        }
        C2257qq c2257qq = (C2257qq) obj;
        if (m9195u() != c2257qq.m9195u()) {
            return false;
        }
        if (this.f6743l.isEmpty()) {
            return c2257qq.f6743l.isEmpty();
        }
        for (int iIntValue = ((Integer) this.f6743l.firstKey()).intValue(); iIntValue <= ((Integer) this.f6743l.lastKey()).intValue(); iIntValue++) {
            if (!m9192r(iIntValue).equals(c2257qq.m9192r(iIntValue))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Double mo153f() {
        return this.f6743l.size() == 1 ? m9192r(0).mo153f() : this.f6743l.size() <= 0 ? Double.valueOf(0.0d) : Double.valueOf(Double.NaN);
    }

    @Override
    public final InterfaceC0909Tq mo1617g(String str) {
        InterfaceC0909Tq interfaceC0909Tq;
        return "length".equals(str) ? new C0036Aq(Double.valueOf(m9195u())) : (!mo1618k(str) || (interfaceC0909Tq = (InterfaceC0909Tq) this.f6744m.get(str)) == null) ? InterfaceC0909Tq.f2785d : interfaceC0909Tq;
    }

    @Override
    public final String mo154h() {
        return toString();
    }

    public final int hashCode() {
        return this.f6743l.hashCode() * 31;
    }

    @Override
    public final Iterator mo155i() {
        return new C2072mq(this, this.f6743l.keySet().iterator(), this.f6744m.keySet().iterator());
    }

    @Override
    public final Iterator iterator() {
        return new C2533wq(this);
    }

    @Override
    public final boolean mo1618k(String str) {
        return "length".equals(str) || this.f6744m.containsKey(str);
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        return ("concat".equals(str) || "every".equals(str) || "filter".equals(str) || "forEach".equals(str) || "indexOf".equals(str) || "join".equals(str) || "lastIndexOf".equals(str) || "map".equals(str) || "pop".equals(str) || "push".equals(str) || "reduce".equals(str) || "reduceRight".equals(str) || "reverse".equals(str) || "shift".equals(str) || "slice".equals(str) || "some".equals(str) || "sort".equals(str) || "splice".equals(str) || "toString".equals(str) || "unshift".equals(str)) ? AbstractC0405Ir.m1721c(str, this, c2357sy, list) : AbstractC0634Nq.m3339b(this, new C1093Xq(str), c2357sy, list);
    }

    @Override
    public final void mo1619p(String str, InterfaceC0909Tq interfaceC0909Tq) {
        if (interfaceC0909Tq == null) {
            this.f6744m.remove(str);
        } else {
            this.f6744m.put(str, interfaceC0909Tq);
        }
    }

    public final int m9191q() {
        return this.f6743l.size();
    }

    public final InterfaceC0909Tq m9192r(int i) {
        InterfaceC0909Tq interfaceC0909Tq;
        if (i < m9195u()) {
            return (!m9199y(i) || (interfaceC0909Tq = (InterfaceC0909Tq) this.f6743l.get(Integer.valueOf(i))) == null) ? InterfaceC0909Tq.f2785d : interfaceC0909Tq;
        }
        throw new IndexOutOfBoundsException("Attempting to get element outside of current array");
    }

    public final void m9193s(int i, InterfaceC0909Tq interfaceC0909Tq) {
        if (i < 0) {
            throw new IllegalArgumentException("Invalid value index: " + i);
        }
        if (i >= m9195u()) {
            m9198x(i, interfaceC0909Tq);
            return;
        }
        for (int iIntValue = ((Integer) this.f6743l.lastKey()).intValue(); iIntValue >= i; iIntValue--) {
            InterfaceC0909Tq interfaceC0909Tq2 = (InterfaceC0909Tq) this.f6743l.get(Integer.valueOf(iIntValue));
            if (interfaceC0909Tq2 != null) {
                m9198x(iIntValue + 1, interfaceC0909Tq2);
                this.f6743l.remove(Integer.valueOf(iIntValue));
            }
        }
        m9198x(i, interfaceC0909Tq);
    }

    public final void m9194t(InterfaceC0909Tq interfaceC0909Tq) {
        m9198x(m9195u(), interfaceC0909Tq);
    }

    public final String toString() {
        return m9196v(",");
    }

    public final int m9195u() {
        if (this.f6743l.isEmpty()) {
            return 0;
        }
        return ((Integer) this.f6743l.lastKey()).intValue() + 1;
    }

    public final String m9196v(String str) {
        if (str == null) {
            str = "";
        }
        StringBuilder sb = new StringBuilder();
        if (!this.f6743l.isEmpty()) {
            for (int i = 0; i < m9195u(); i++) {
                InterfaceC0909Tq interfaceC0909TqM9192r = m9192r(i);
                sb.append(str);
                if (!(interfaceC0909TqM9192r instanceof C1842hr) && !(interfaceC0909TqM9192r instanceof C0726Pq)) {
                    sb.append(interfaceC0909TqM9192r.mo154h());
                }
            }
            sb.delete(0, str.length());
        }
        return sb.toString();
    }

    public final void m9197w(int i) {
        int iIntValue = ((Integer) this.f6743l.lastKey()).intValue();
        if (i > iIntValue || i < 0) {
            return;
        }
        this.f6743l.remove(Integer.valueOf(i));
        if (i == iIntValue) {
            int i2 = i - 1;
            if (this.f6743l.containsKey(Integer.valueOf(i2)) || i2 < 0) {
                return;
            }
            this.f6743l.put(Integer.valueOf(i2), InterfaceC0909Tq.f2785d);
            return;
        }
        while (true) {
            i++;
            if (i > ((Integer) this.f6743l.lastKey()).intValue()) {
                return;
            }
            InterfaceC0909Tq interfaceC0909Tq = (InterfaceC0909Tq) this.f6743l.get(Integer.valueOf(i));
            if (interfaceC0909Tq != null) {
                this.f6743l.put(Integer.valueOf(i - 1), interfaceC0909Tq);
                this.f6743l.remove(Integer.valueOf(i));
            }
        }
    }

    public final void m9198x(int i, InterfaceC0909Tq interfaceC0909Tq) {
        if (i > 32468) {
            throw new IllegalStateException("Array too large");
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException("Out of bounds index: " + i);
        }
        if (interfaceC0909Tq == null) {
            this.f6743l.remove(Integer.valueOf(i));
        } else {
            this.f6743l.put(Integer.valueOf(i), interfaceC0909Tq);
        }
    }

    public final boolean m9199y(int i) {
        if (i >= 0 && i <= ((Integer) this.f6743l.lastKey()).intValue()) {
            return this.f6743l.containsKey(Integer.valueOf(i));
        }
        throw new IndexOutOfBoundsException("Out of bounds index: " + i);
    }

    public final Iterator m9200z() {
        return this.f6743l.keySet().iterator();
    }

    public C2257qq(List list) {
        this();
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                m9198x(i, (InterfaceC0909Tq) list.get(i));
            }
        }
    }

    public C2257qq(InterfaceC0909Tq... interfaceC0909TqArr) {
        this(Arrays.asList(interfaceC0909TqArr));
    }
}
