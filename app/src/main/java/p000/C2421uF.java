package p000;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

public class C2421uF extends AbstractSet {

    public final AbstractC1118YE f7395l;

    public C2421uF(AbstractC1118YE abstractC1118YE) {
        this.f7395l = abstractC1118YE;
    }

    @Override
    public boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.f7395l.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    @Override
    public void clear() {
        this.f7395l.clear();
    }

    @Override
    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.f7395l.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    @Override
    public Iterator iterator() {
        return new C2237qF(this.f7395l);
    }

    @Override
    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.f7395l.remove(entry.getKey());
        return true;
    }

    @Override
    public int size() {
        return this.f7395l.size();
    }
}
