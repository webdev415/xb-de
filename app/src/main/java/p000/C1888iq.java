package p000;

import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1888iq {

    public static final AbstractC1220ae f5826d = AbstractC1220ae.m5258v("_syn", "_err", "_el");

    public String f5827a;

    public long f5828b;

    public Map f5829c;

    public C1888iq(String str, long j, Map map) {
        this.f5827a = str;
        this.f5828b = j;
        HashMap map2 = new HashMap<>();
        this.f5829c = map2;
        if (map != null) {
            map2.putAll(map);
        }
    }

    public static Object m8002c(String str, Object obj, Object obj2) {
        if (!f5826d.contains(str) || !(obj2 instanceof Double)) {
            if (str.startsWith("_")) {
                return ((obj instanceof String) || obj == null) ? obj2 : obj;
            }
            if (obj instanceof Double) {
                return obj2;
            }
            if (!(obj instanceof Long)) {
                return obj instanceof String ? obj2.toString() : obj2;
            }
        }
        return Long.valueOf(Math.round(((Double) obj2).doubleValue()));
    }

    public final long m8003a() {
        return this.f5828b;
    }

    public final Object m8004b(String str) {
        if (this.f5829c.containsKey(str)) {
            return this.f5829c.get(str);
        }
        return null;
    }

    public final Object clone() {
        return new C1888iq(this.f5827a, this.f5828b, new HashMap<>(this.f5829c));
    }

    public final void m8005d(String str, Object obj) {
        if (obj == null) {
            this.f5829c.remove(str);
        } else {
            this.f5829c.put(str, m8002c(str, this.f5829c.get(str), obj));
        }
    }

    public final String m8006e() {
        return this.f5827a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1888iq)) {
            return false;
        }
        C1888iq c1888iq = (C1888iq) obj;
        if (this.f5828b == c1888iq.f5828b && this.f5827a.equals(c1888iq.f5827a)) {
            return this.f5829c.equals(c1888iq.f5829c);
        }
        return false;
    }

    public final void m8007f(String str) {
        this.f5827a = str;
    }

    public final Map m8008g() {
        return this.f5829c;
    }

    public final int hashCode() {
        int iHashCode = this.f5827a.hashCode() * 31;
        long j = this.f5828b;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.f5829c.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.f5827a + "', timestamp=" + this.f5828b + ", params=" + String.valueOf(this.f5829c) + "}";
    }
}
