package p000;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import p000.C0733Px;

/* loaded from: classes.dex */
public final class C1215aJ {

    public String f3528a;

    public boolean f3529b;

    public C0687Ox f3530c;

    public BitSet f3531d;

    public BitSet f3532e;

    public Map f3533f;

    public Map f3534g;

    public final C0846SI f3535h;

    public C1215aJ(C0846SI c0846si, String str) {
        this.f3535h = c0846si;
        this.f3528a = str;
        this.f3529b = true;
        this.f3531d = new BitSet();
        this.f3532e = new BitSet();
        this.f3533f = new C2453v1();
        this.f3534g = new C2453v1();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [Fx$a, PC$b] */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r1v8, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.lang.Iterable] */
    /* JADX WARN: Type inference failed for: r8v5, types: [Ox$a] */
    public final C0273Fx m5246b(int i) {
        ArrayList arrayList;
        ?? arrayList2;
        ?? M1297J = C0273Fx.m1297J();
        M1297J.m1307t(i);
        M1297J.m1310w(this.f3529b);
        C0687Ox c0687Ox = this.f3530c;
        if (c0687Ox != null) {
            M1297J.m1309v(c0687Ox);
        }
        ?? M3465A = C0687Ox.m3454R().m3469w(C2145oG.m8892J(this.f3531d)).m3465A(C2145oG.m8892J(this.f3532e));
        if (this.f3533f == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>(this.f3533f.size());
            for (Integer num : this.f3533f.keySet()) {
                int iIntValue = num.intValue();
                Long l = (Long) this.f3533f.get(num);
                if (l != null) {
                    arrayList.add((C0319Gx) ((AbstractC0703PC) C0319Gx.m1453J().m1459t(iIntValue).m1460u(l.longValue()).m3526o()));
                }
            }
        }
        if (arrayList != null) {
            M3465A.m3467u(arrayList);
        }
        if (this.f3534g == null) {
            arrayList2 = Collections.emptyList();
        } else {
            arrayList2 = new ArrayList<>(this.f3534g.size());
            for (Integer num2 : this.f3534g.keySet()) {
                C0733Px.a aVarM3604t = C0733Px.m3597K().m3604t(num2.intValue());
                List list = (List) this.f3534g.get(num2);
                if (list != null) {
                    Collections.sort(list);
                    aVarM3604t.m3605u(list);
                }
                arrayList2.add((C0733Px) ((AbstractC0703PC) aVarM3604t.m3526o()));
            }
        }
        M3465A.m3471y(arrayList2);
        M1297J.m1308u(M3465A);
        return (C0273Fx) ((AbstractC0703PC) M1297J.m3526o());
    }

    public final void m5247c(AbstractC1286aq abstractC1286aq) {
        int iMo5562a = abstractC1286aq.mo5562a();
        Boolean bool = abstractC1286aq.f3800c;
        if (bool != null) {
            this.f3532e.set(iMo5562a, bool.booleanValue());
        }
        Boolean bool2 = abstractC1286aq.f3801d;
        if (bool2 != null) {
            this.f3531d.set(iMo5562a, bool2.booleanValue());
        }
        if (abstractC1286aq.f3802e != null) {
            Long l = (Long) this.f3533f.get(Integer.valueOf(iMo5562a));
            long jLongValue = abstractC1286aq.f3802e.longValue() / 1000;
            if (l == null || jLongValue > l.longValue()) {
                this.f3533f.put(Integer.valueOf(iMo5562a), Long.valueOf(jLongValue));
            }
        }
        if (abstractC1286aq.f3803f != null) {
            List arrayList = (List) this.f3534g.get(Integer.valueOf(iMo5562a));
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                this.f3534g.put(Integer.valueOf(iMo5562a), arrayList);
            }
            if (abstractC1286aq.mo5564j()) {
                arrayList.clear();
            }
            if (C2469vH.m10335a() && this.f3535h.mo347e().m10800J(this.f3528a, AbstractC0818Rr.f2527p0) && abstractC1286aq.mo5563i()) {
                arrayList.clear();
            }
            if (!C2469vH.m10335a() || !this.f3535h.mo347e().m10800J(this.f3528a, AbstractC0818Rr.f2527p0)) {
                arrayList.add(Long.valueOf(abstractC1286aq.f3803f.longValue() / 1000));
                return;
            }
            long jLongValue2 = abstractC1286aq.f3803f.longValue() / 1000;
            if (arrayList.contains(Long.valueOf(jLongValue2))) {
                return;
            }
            arrayList.add(Long.valueOf(jLongValue2));
        }
    }

    public C1215aJ(C0846SI c0846si, String str, C0687Ox c0687Ox, BitSet bitSet, BitSet bitSet2, Map map, Map map2) {
        this.f3535h = c0846si;
        this.f3528a = str;
        this.f3531d = bitSet;
        this.f3532e = bitSet2;
        this.f3533f = map;
        this.f3534g = new C2453v1();
        if (map2 != null) {
            for (Integer num : map2.keySet()) {
                ArrayList arrayList = new ArrayList<>();
                arrayList.add((Long) map2.get(num));
                this.f3534g.put(num, arrayList);
            }
        }
        this.f3529b = false;
        this.f3530c = c0687Ox;
    }
}
