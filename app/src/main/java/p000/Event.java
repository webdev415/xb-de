package p000;

import java.util.HashMap;
import java.util.Map;

public final class Event {

    public static final AbstractC1220ae f5826d = AbstractC1220ae.m5258v("_syn", "_err", "_el");

    public String name;

    public long timestamp;

    public Map params;

    public Event(String str, long j, Map map) {
        this.name = str;
        this.timestamp = j;
        HashMap map2 = new HashMap<>();
        this.params = map2;
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
        return this.timestamp;
    }

    public final Object m8004b(String str) {
        if (this.params.containsKey(str)) {
            return this.params.get(str);
        }
        return null;
    }

    public final Object clone() {
        return new Event(this.name, this.timestamp, new HashMap<>(this.params));
    }

    public final void m8005d(String str, Object obj) {
        if (obj == null) {
            this.params.remove(str);
        } else {
            this.params.put(str, m8002c(str, this.params.get(str), obj));
        }
    }

    public final String m8006e() {
        return this.name;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Event)) {
            return false;
        }
        Event event = (Event) obj;
        if (this.timestamp == event.timestamp && this.name.equals(event.name)) {
            return this.params.equals(event.params);
        }
        return false;
    }

    public final void m8007f(String str) {
        this.name = str;
    }

    public final Map m8008g() {
        return this.params;
    }

    public final int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        long j = this.timestamp;
        return ((iHashCode + ((int) (j ^ (j >>> 32)))) * 31) + this.params.hashCode();
    }

    public final String toString() {
        return "Event{name='" + this.name + "', timestamp=" + this.timestamp + ", params=" + this.params + "}";
    }
}
