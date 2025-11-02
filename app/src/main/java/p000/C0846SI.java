package p000;

import android.content.ContentValues;
import android.database.sqlite.SQLiteException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p000.C0687Ox;

/* loaded from: classes.dex */
public final class C0846SI extends AbstractC2513wF {

    public String f2617d;

    public Set f2618e;

    public Map f2619f;

    public Long f2620g;

    public Long f2621h;

    public C0846SI(C0200EF c0200ef) {
        super(c0200ef);
    }

    private final void m4027B(List list) {
        C2124nw c2124nw;
        if (list.isEmpty()) {
            return;
        }
        C2453v1 c2453v1 = new C2453v1();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0779Qx c0779Qx = (C0779Qx) it.next();
            String strM3731U = c0779Qx.m3731U();
            Map mapM2496P0 = (Map) c2453v1.get(strM3731U);
            if (mapM2496P0 == null) {
                mapM2496P0 = mo3246q().m2496P0(this.f2617d, strM3731U);
                c2453v1.put(strM3731U, mapM2496P0);
            }
            Iterator it2 = mapM2496P0.keySet().iterator();
            while (true) {
                if (it2.hasNext()) {
                    Integer num = (Integer) it2.next();
                    int iIntValue = num.intValue();
                    if (this.f2618e.contains(num)) {
                        mo349g().m9622K().m10617b("Skipping failed audience ID", num);
                        break;
                    }
                    Iterator it3 = ((List) mapM2496P0.get(num)).iterator();
                    boolean zM8206k = true;
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        c2124nw = (C2124nw) it3.next();
                        if (mo349g().m9616C(2)) {
                            mo349g().m9622K().m10619d("Evaluating filter. audience, filter, property", num, c2124nw.m8806O() ? Integer.valueOf(c2124nw.m8808j()) : null, mo350h().m9213g(c2124nw.m8802K()));
                            mo349g().m9622K().m10617b("Filter definition", mo3244o().m8912G(c2124nw));
                        }
                        if (c2124nw.m8806O() && c2124nw.m8808j() <= 256) {
                            C1934jq c1934jq = new C1934jq(this, this.f2617d, iIntValue, c2124nw);
                            zM8206k = c1934jq.m8206k(this.f2620g, this.f2621h, c0779Qx, m4031D(iIntValue, c2124nw.m8808j()));
                            if (!zM8206k) {
                                this.f2618e.add(num);
                                break;
                            }
                            m4029A(num).m5247c(c1934jq);
                        } else {
                            break;
                        }
                    }
                    mo349g().m9623L().m10618c("Invalid property filter ID. appId, id", C2356sx.m9613v(this.f2617d), String.valueOf(c2124nw.m8806O() ? Integer.valueOf(c2124nw.m8808j()) : null));
                    zM8206k = false;
                    if (!zM8206k) {
                        this.f2618e.add(num);
                    }
                }
            }
        }
    }

    private final List m4028E() {
        ArrayList arrayList = new ArrayList<>();
        Set<Integer> setKeySet = this.f2619f.keySet();
        setKeySet.removeAll(this.f2618e);
        for (Integer num : setKeySet) {
            int iIntValue = num.intValue();
            C1215aJ c1215aJ = (C1215aJ) this.f2619f.get(num);
            AbstractC1085Xi.m4801j(c1215aJ);
            C0273Fx c0273FxM5246b = c1215aJ.m5246b(iIntValue);
            arrayList.add(c0273FxM5246b);
            C0496Kq c0496KqMo3246q = mo3246q();
            String str = this.f2617d;
            C0687Ox c0687OxM1300M = c0273FxM5246b.m1300M();
            c0496KqMo3246q.m10440u();
            c0496KqMo3246q.mo356n();
            AbstractC1085Xi.m4795d(str);
            AbstractC1085Xi.m4801j(c0687OxM1300M);
            byte[] bArrM4464i = c0687OxM1300M.m4464i();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("audience_id", num);
            contentValues.put("current_results", bArrM4464i);
            try {
                if (c0496KqMo3246q.m2467B().insertWithOnConflict("audience_filter_values", null, contentValues, 5) == -1) {
                    c0496KqMo3246q.mo349g().m9618G().m10617b("Failed to insert filter results (got -1). appId", C2356sx.m9613v(str));
                }
            } catch (SQLiteException e) {
                c0496KqMo3246q.mo349g().m9618G().m10618c("Error storing filter results. appId", C2356sx.m9613v(str), e);
            }
        }
        return arrayList;
    }

    public final C1215aJ m4029A(Integer num) {
        if (this.f2619f.containsKey(num)) {
            return (C1215aJ) this.f2619f.get(num);
        }
        C1215aJ c1215aJ = new C1215aJ(this, this.f2617d);
        this.f2619f.put(num, c1215aJ);
        return c1215aJ;
    }

    public final void m4030C(List list, boolean z) {
        C0267Fr c0267Fr;
        C1824hJ c1824hJ;
        Integer num;
        Map map;
        long j;
        if (list.isEmpty()) {
            return;
        }
        String str = null;
        C1824hJ c1824hJ2 = new C1824hJ(this);
        C2453v1 c2453v1 = new C2453v1();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0365Hx c0365Hx = (C0365Hx) it.next();
            C0365Hx c0365HxM7823a = c1824hJ2.m7823a(this.f2617d, c0365Hx);
            if (c0365HxM7823a != null) {
                C0496Kq c0496KqMo3246q = mo3246q();
                String str2 = this.f2617d;
                String strM1637U = c0365HxM7823a.m1637U();
                C0267Fr c0267FrM2486K0 = c0496KqMo3246q.m2486K0(str2, c0365Hx.m1637U());
                if (c0267FrM2486K0 == null) {
                    c0496KqMo3246q.mo349g().m9623L().m10618c("Event aggregate wasn't created during raw event logging. appId, event", C2356sx.m9613v(str2), c0496KqMo3246q.mo350h().m9209b(strM1637U));
                    c0267Fr = new C0267Fr(str2, c0365Hx.m1637U(), 1L, 1L, 1L, c0365Hx.m1636R(), 0L, null, null, null, null);
                } else {
                    c0267Fr = new C0267Fr(c0267FrM2486K0.f683a, c0267FrM2486K0.f684b, c0267FrM2486K0.f685c + 1, c0267FrM2486K0.f686d + 1, c0267FrM2486K0.f687e + 1, c0267FrM2486K0.f688f, c0267FrM2486K0.f689g, c0267FrM2486K0.f690h, c0267FrM2486K0.f691i, c0267FrM2486K0.f692j, c0267FrM2486K0.f693k);
                }
                C0267Fr c0267Fr2 = c0267Fr;
                mo3246q().m2516b0(c0267Fr2);
                if (!C0798RG.m3790a() || !mo347e().m10800J(str, AbstractC0818Rr.f2492d1) || !z) {
                    long j2 = c0267Fr2.f685c;
                    String strM1637U2 = c0365HxM7823a.m1637U();
                    Map mapM2492N0 = (Map) c2453v1.get(strM1637U2);
                    if (mapM2492N0 == null) {
                        mapM2492N0 = mo3246q().m2492N0(this.f2617d, strM1637U2);
                        c2453v1.put(strM1637U2, mapM2492N0);
                    }
                    Map map2 = mapM2492N0;
                    for (Integer num2 : map2.keySet()) {
                        int iIntValue = num2.intValue();
                        if (this.f2618e.contains(num2)) {
                            mo349g().m9622K().m10617b("Skipping failed audience ID", num2);
                        } else {
                            Iterator it2 = ((List) map2.get(num2)).iterator();
                            boolean zM7272k = true;
                            while (true) {
                                if (!it2.hasNext()) {
                                    c1824hJ = c1824hJ2;
                                    num = num2;
                                    map = map2;
                                    j = j2;
                                    break;
                                }
                                C1986kw c1986kw = (C1986kw) it2.next();
                                C1607cq c1607cq = new C1607cq(this, this.f2617d, iIntValue, c1986kw);
                                c1824hJ = c1824hJ2;
                                num = num2;
                                int i = iIntValue;
                                map = map2;
                                j = j2;
                                zM7272k = c1607cq.m7272k(this.f2620g, this.f2621h, c0365HxM7823a, j2, c0267Fr2, m4031D(iIntValue, c1986kw.m8324J()));
                                if (!zM7272k) {
                                    this.f2618e.add(num);
                                    break;
                                }
                                m4029A(num).m5247c(c1607cq);
                                num2 = num;
                                c1824hJ2 = c1824hJ;
                                iIntValue = i;
                                map2 = map;
                                j2 = j;
                            }
                            if (!zM7272k) {
                                this.f2618e.add(num);
                            }
                            c1824hJ2 = c1824hJ;
                            map2 = map;
                            j2 = j;
                            str = null;
                        }
                    }
                }
            }
        }
    }

    public final boolean m4031D(int i, int i2) {
        C1215aJ c1215aJ = (C1215aJ) this.f2619f.get(Integer.valueOf(i));
        if (c1215aJ == null) {
            return false;
        }
        return c1215aJ.f3531d.get(i2);
    }

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final List m4032y(String str, List list, List list2, Long l, Long l2) {
        return m4033z(str, list, list2, l, l2, false);
    }

    public final List m4033z(String str, List list, List list2, Long l, Long l2, boolean z) {
        boolean z2;
        Map map;
        List<C1986kw> list3;
        Iterator it;
        Iterator it2;
        Map map2;
        Map map3;
        Iterator it3;
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(list);
        AbstractC1085Xi.m4801j(list2);
        this.f2617d = str;
        this.f2618e = new HashSet();
        this.f2619f = new C2453v1();
        this.f2620g = l;
        this.f2621h = l2;
        Iterator it4 = list.iterator();
        while (true) {
            if (!it4.hasNext()) {
                z2 = false;
                break;
            }
            if ("_s".equals(((C0365Hx) it4.next()).m1637U())) {
                z2 = true;
                break;
            }
        }
        boolean z3 = C2469vH.m10335a() && mo347e().m10800J(this.f2617d, AbstractC0818Rr.f2527p0);
        boolean z4 = C2469vH.m10335a() && mo347e().m10800J(this.f2617d, AbstractC0818Rr.f2524o0);
        if (z2) {
            C0496Kq c0496KqMo3246q = mo3246q();
            String str2 = this.f2617d;
            c0496KqMo3246q.m10440u();
            c0496KqMo3246q.mo356n();
            AbstractC1085Xi.m4795d(str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("current_session_count", (Integer) 0);
            try {
                c0496KqMo3246q.m2467B().update("events", contentValues, "app_id = ?", new String[]{str2});
            } catch (SQLiteException e) {
                c0496KqMo3246q.mo349g().m9618G().m10618c("Error resetting session-scoped event counts. appId", C2356sx.m9613v(str2), e);
            }
        }
        Map mapEmptyMap = Collections.emptyMap();
        if (z4 && z3) {
            mapEmptyMap = mo3246q().m2513Z0(this.f2617d);
        }
        Map mapM2511Y0 = mo3246q().m2511Y0(this.f2617d);
        if (!mapM2511Y0.isEmpty()) {
            HashSet hashSet = new HashSet(mapM2511Y0.keySet());
            if (z2) {
                String str3 = this.f2617d;
                Map mapM2515a1 = mo3246q().m2515a1(this.f2617d);
                AbstractC1085Xi.m4795d(str3);
                AbstractC1085Xi.m4801j(mapM2511Y0);
                Map c2453v1 = new C2453v1();
                if (!mapM2511Y0.isEmpty()) {
                    Iterator it5 = mapM2511Y0.keySet().iterator();
                    while (it5.hasNext()) {
                        Integer num = (Integer) it5.next();
                        num.intValue();
                        C0687Ox c0687Ox = (C0687Ox) mapM2511Y0.get(num);
                        List list4 = (List) mapM2515a1.get(num);
                        if (list4 == null || list4.isEmpty()) {
                            map3 = mapM2515a1;
                            it3 = it5;
                            c2453v1.put(num, c0687Ox);
                        } else {
                            List listM8914K = mo3244o().m8914K(c0687Ox.m3461V(), list4);
                            if (!listM8914K.isEmpty()) {
                                C0687Ox.a aVarM3469w = ((C0687Ox.a) c0687Ox.m3517y()).m3468v().m3469w(listM8914K);
                                aVarM3469w.m3472z().m3465A(mo3244o().m8914K(c0687Ox.m3463X(), list4));
                                ArrayList arrayList = new ArrayList<>();
                                for (C0319Gx c0319Gx : c0687Ox.m3460U()) {
                                    Map map4 = mapM2515a1;
                                    Iterator it6 = it5;
                                    if (!list4.contains(Integer.valueOf(c0319Gx.m1458j()))) {
                                        arrayList.add(c0319Gx);
                                    }
                                    mapM2515a1 = map4;
                                    it5 = it6;
                                }
                                map3 = mapM2515a1;
                                it3 = it5;
                                aVarM3469w.m3466t().m3467u(arrayList);
                                ArrayList arrayList2 = new ArrayList<>();
                                for (C0733Px c0733Px : c0687Ox.m3462W()) {
                                    if (!list4.contains(Integer.valueOf(c0733Px.m3600J()))) {
                                        arrayList2.add(c0733Px);
                                    }
                                }
                                aVarM3469w.m3470x().m3471y(arrayList2);
                                c2453v1.put(num, (C0687Ox) ((AbstractC0703PC) aVarM3469w.m3526o()));
                            }
                        }
                        mapM2515a1 = map3;
                        it5 = it3;
                    }
                }
                map = c2453v1;
            } else {
                map = mapM2511Y0;
            }
            Iterator it7 = hashSet.iterator();
            Map map5 = mapM2511Y0;
            while (it7.hasNext()) {
                Integer num2 = (Integer) it7.next();
                num2.intValue();
                C0687Ox c0687Ox2 = (C0687Ox) map.get(num2);
                BitSet bitSet = new BitSet();
                BitSet bitSet2 = new BitSet();
                C2453v1 c2453v12 = new C2453v1();
                if (c0687Ox2 != null && c0687Ox2.m3464j() != 0) {
                    for (C0319Gx c0319Gx2 : c0687Ox2.m3460U()) {
                        if (c0319Gx2.m1457M()) {
                            c2453v12.put(Integer.valueOf(c0319Gx2.m1458j()), c0319Gx2.m1456L() ? Long.valueOf(c0319Gx2.m1455I()) : null);
                        }
                    }
                }
                C2453v1 c2453v13 = new C2453v1();
                if (c0687Ox2 != null && c0687Ox2.m3458L() != 0) {
                    Iterator it8 = c0687Ox2.m3462W().iterator();
                    while (it8.hasNext()) {
                        C0733Px c0733Px2 = (C0733Px) it8.next();
                        if (!c0733Px2.m3602N() || c0733Px2.m3603j() <= 0) {
                            it2 = it8;
                            map2 = map;
                        } else {
                            it2 = it8;
                            map2 = map;
                            c2453v13.put(Integer.valueOf(c0733Px2.m3600J()), Long.valueOf(c0733Px2.m3599G(c0733Px2.m3603j() - 1)));
                        }
                        it8 = it2;
                        map = map2;
                    }
                }
                Map map6 = map;
                if (c0687Ox2 != null) {
                    int i = 0;
                    while (i < (c0687Ox2.m3459O() << 6)) {
                        if (C2145oG.m8902e0(c0687Ox2.m3463X(), i)) {
                            it = it7;
                            mo349g().m9622K().m10618c("Filter already evaluated. audience ID, filter ID", num2, Integer.valueOf(i));
                            bitSet2.set(i);
                            if (C2145oG.m8902e0(c0687Ox2.m3461V(), i)) {
                                bitSet.set(i);
                            }
                            i++;
                            it7 = it;
                        } else {
                            it = it7;
                        }
                        c2453v12.remove(Integer.valueOf(i));
                        i++;
                        it7 = it;
                    }
                }
                Iterator it9 = it7;
                C0687Ox c0687Ox3 = (C0687Ox) map5.get(num2);
                if (z4 && z3 && (list3 = (List) mapEmptyMap.get(num2)) != null && this.f2621h != null && this.f2620g != null) {
                    for (C1986kw c1986kw : list3) {
                        int iM8324J = c1986kw.m8324J();
                        long jLongValue = this.f2621h.longValue() / 1000;
                        if (c1986kw.m8329Q()) {
                            jLongValue = this.f2620g.longValue() / 1000;
                        }
                        if (c2453v12.containsKey(Integer.valueOf(iM8324J))) {
                            c2453v12.put(Integer.valueOf(iM8324J), Long.valueOf(jLongValue));
                        }
                        if (c2453v13.containsKey(Integer.valueOf(iM8324J))) {
                            c2453v13.put(Integer.valueOf(iM8324J), Long.valueOf(jLongValue));
                        }
                    }
                }
                this.f2619f.put(num2, new C1215aJ(this, this.f2617d, c0687Ox3, bitSet, bitSet2, c2453v12, c2453v13));
                it7 = it9;
                map5 = map5;
                map = map6;
            }
        }
        if (!C0798RG.m3790a() || !mo347e().m10800J(null, AbstractC0818Rr.f2492d1)) {
            m4030C(list, true);
            m4027B(list2);
            return m4028E();
        }
        m4030C(list, z);
        if (z) {
            return new ArrayList<>();
        }
        m4027B(list2);
        return m4028E();
    }
}
