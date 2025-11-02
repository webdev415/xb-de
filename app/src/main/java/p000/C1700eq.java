package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1700eq {

    public C1888iq f5465a;

    public C1888iq f5466b;

    public List f5467c;

    public C1700eq() {
        this.f5465a = new C1888iq("", 0L, null);
        this.f5466b = new C1888iq("", 0L, null);
        this.f5467c = new ArrayList<>();
    }

    public final C1888iq m7473a() {
        return this.f5465a;
    }

    public final void m7474b(String str, long j, Map map) {
        HashMap map2 = new HashMap<>();
        for (String str2 : map.keySet()) {
            map2.put(str2, C1888iq.m8002c(str2, this.f5465a.m8004b(str2), map.get(str2)));
        }
        this.f5467c.add(new C1888iq(str, j, map2));
    }

    public final void m7475c(C1888iq c1888iq) {
        this.f5465a = c1888iq;
        this.f5466b = (C1888iq) c1888iq.clone();
        this.f5467c.clear();
    }

    public final Object clone() {
        C1700eq c1700eq = new C1700eq((C1888iq) this.f5465a.clone());
        Iterator it = this.f5467c.iterator();
        while (it.hasNext()) {
            c1700eq.f5467c.add((C1888iq) ((C1888iq) it.next()).clone());
        }
        return c1700eq;
    }

    public final C1888iq m7476d() {
        return this.f5466b;
    }

    public final void m7477e(C1888iq c1888iq) {
        this.f5466b = c1888iq;
    }

    public final List m7478f() {
        return this.f5467c;
    }

    public C1700eq(C1888iq c1888iq) {
        this.f5465a = c1888iq;
        this.f5466b = (C1888iq) c1888iq.clone();
        this.f5467c = new ArrayList<>();
    }
}
