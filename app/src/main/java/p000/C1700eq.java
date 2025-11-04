package p000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class C1700eq {

    public Event f5465a;

    public Event f5466b;

    public List f5467c;

    public C1700eq() {
        this.f5465a = new Event("", 0L, null);
        this.f5466b = new Event("", 0L, null);
        this.f5467c = new ArrayList<>();
    }

    public final Event m7473a() {
        return this.f5465a;
    }

    public final void m7474b(String str, long j, Map map) {
        HashMap map2 = new HashMap<>();
        for (String str2 : map.keySet()) {
            map2.put(str2, Event.m8002c(str2, this.f5465a.m8004b(str2), map.get(str2)));
        }
        this.f5467c.add(new Event(str, j, map2));
    }

    public final void m7475c(Event event) {
        this.f5465a = event;
        this.f5466b = (Event) event.clone();
        this.f5467c.clear();
    }

    public final Object clone() {
        C1700eq c1700eq = new C1700eq((Event) this.f5465a.clone());
        Iterator it = this.f5467c.iterator();
        while (it.hasNext()) {
            c1700eq.f5467c.add((Event) ((Event) it.next()).clone());
        }
        return c1700eq;
    }

    public final Event m7476d() {
        return this.f5466b;
    }

    public final void m7477e(Event event) {
        this.f5466b = event;
    }

    public final List m7478f() {
        return this.f5467c;
    }

    public C1700eq(Event event) {
        this.f5465a = event;
        this.f5466b = (Event) event.clone();
        this.f5467c = new ArrayList<>();
    }
}
