package p000;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class AbstractC2339sg extends AbstractC2293rg {
    public static Map m9572d() {
        C0791R9 c0791r9 = C0791R9.f2350l;
        AbstractC0116Ce.m474c(c0791r9, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.emptyMap, V of kotlin.collections.MapsKt__MapsKt.emptyMap>");
        return c0791r9;
    }

    public static final Map m9573e(Map map) {
        AbstractC0116Ce.m476e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? map : AbstractC2293rg.m9414c(map) : m9572d();
    }

    public static final void m9574f(Map map, Iterable iterable) {
        AbstractC0116Ce.m476e(map, "<this>");
        AbstractC0116Ce.m476e(iterable, "pairs");
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            C0258Fi c0258Fi = (C0258Fi) it.next();
            map.put(c0258Fi.m1259a(), c0258Fi.m1260b());
        }
    }

    public static Map m9575g(Iterable iterable) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        if (!(iterable instanceof Collection)) {
            return m9573e(m9576h(iterable, new LinkedHashMap()));
        }
        Collection collection = (Collection) iterable;
        int size = collection.size();
        if (size == 0) {
            return m9572d();
        }
        if (size != 1) {
            return m9576h(iterable, new LinkedHashMap(AbstractC2293rg.m9412a(collection.size())));
        }
        return AbstractC2293rg.m9413b((C0258Fi) (iterable instanceof List ? ((List) iterable).get(0) : iterable.iterator().next()));
    }

    public static final Map m9576h(Iterable iterable, Map map) {
        AbstractC0116Ce.m476e(iterable, "<this>");
        AbstractC0116Ce.m476e(map, "destination");
        m9574f(map, iterable);
        return map;
    }

    public static Map m9577i(Map map) {
        AbstractC0116Ce.m476e(map, "<this>");
        int size = map.size();
        return size != 0 ? size != 1 ? m9578j(map) : AbstractC2293rg.m9414c(map) : m9572d();
    }

    public static Map m9578j(Map map) {
        AbstractC0116Ce.m476e(map, "<this>");
        return new LinkedHashMap(map);
    }
}
