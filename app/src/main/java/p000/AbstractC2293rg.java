package p000;

import java.util.Collections;
import java.util.Map;

public abstract class AbstractC2293rg extends AbstractC2247qg {
    public static int m9412a(int i) {
        if (i < 0) {
            return i;
        }
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    public static final Map m9413b(C0258Fi c0258Fi) {
        AbstractC0116Ce.m476e(c0258Fi, "pair");
        Map mapSingletonMap = Collections.singletonMap(c0258Fi.m1261c(), c0258Fi.m1262d());
        AbstractC0116Ce.m475d(mapSingletonMap, "singletonMap(pair.first, pair.second)");
        return mapSingletonMap;
    }

    public static final Map m9414c(Map map) {
        AbstractC0116Ce.m476e(map, "<this>");
        Map.Entry entry = (Map.Entry) map.entrySet().iterator().next();
        Map mapSingletonMap = Collections.singletonMap(entry.getKey(), entry.getValue());
        AbstractC0116Ce.m475d(mapSingletonMap, "with(entries.iterator().…ingletonMap(key, value) }");
        return mapSingletonMap;
    }
}
