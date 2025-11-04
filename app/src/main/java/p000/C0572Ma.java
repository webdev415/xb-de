package p000;

import java.util.HashMap;
import java.util.Map;
import p000.C1836hl;

public class C0572Ma extends C1836hl {

    public final HashMap f1807p = new HashMap<>();

    public boolean contains(Object obj) {
        return this.f1807p.containsKey(obj);
    }

    @Override
    public c mo2849f(Object obj) {
        return (c) this.f1807p.get(obj);
    }

    @Override
    public Object mo2850k(Object obj) {
        Object objMo2850k = super.mo2850k(obj);
        this.f1807p.remove(obj);
        return objMo2850k;
    }

    public Map.Entry m2851o(Object obj) {
        if (contains(obj)) {
            return ((c) this.f1807p.get(obj)).f5764o;
        }
        return null;
    }

    public Object m2852p(Object obj, Object obj2) {
        c cVarMo2849f = mo2849f(obj);
        if (cVarMo2849f != null) {
            return cVarMo2849f.f5762m;
        }
        this.f1807p.put(obj, m7852i(obj, obj2));
        return null;
    }
}
