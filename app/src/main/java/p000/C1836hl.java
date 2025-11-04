package p000;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

public class C1836hl implements Iterable {

    public c f5757l;

    public c f5758m;

    public final WeakHashMap f5759n = new WeakHashMap();

    public int f5760o = 0;

    public static class a extends e {
        public a(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override
        public c mo7853c(c cVar) {
            return cVar.f5764o;
        }

        @Override
        public c mo7854d(c cVar) {
            return cVar.f5763n;
        }
    }

    public static class b extends e {
        public b(c cVar, c cVar2) {
            super(cVar, cVar2);
        }

        @Override
        public c mo7853c(c cVar) {
            return cVar.f5763n;
        }

        @Override
        public c mo7854d(c cVar) {
            return cVar.f5764o;
        }
    }

    public static class c implements Map.Entry {

        public final Object f5761l;

        public final Object f5762m;

        public c f5763n;

        public c f5764o;

        public c(Object obj, Object obj2) {
            this.f5761l = obj;
            this.f5762m = obj2;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.f5761l.equals(cVar.f5761l) && this.f5762m.equals(cVar.f5762m);
        }

        @Override
        public Object getKey() {
            return this.f5761l;
        }

        @Override
        public Object getValue() {
            return this.f5762m;
        }

        @Override
        public int hashCode() {
            return this.f5761l.hashCode() ^ this.f5762m.hashCode();
        }

        @Override
        public Object setValue(Object obj) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public String toString() {
            return this.f5761l + "=" + this.f5762m;
        }
    }

    public class d extends f implements Iterator {

        public c f5765l;

        public boolean f5766m = true;

        public d() {
        }

        @Override
        public void mo7855b(c cVar) {
            c cVar2 = this.f5765l;
            if (cVar == cVar2) {
                c cVar3 = cVar2.f5764o;
                this.f5765l = cVar3;
                this.f5766m = cVar3 == null;
            }
        }

        @Override
        public Map.Entry next() {
            c cVar;
            if (this.f5766m) {
                this.f5766m = false;
                cVar = C1836hl.this.f5757l;
            } else {
                c cVar2 = this.f5765l;
                cVar = cVar2 != null ? cVar2.f5763n : null;
            }
            this.f5765l = cVar;
            return this.f5765l;
        }

        @Override
        public boolean hasNext() {
            if (this.f5766m) {
                return C1836hl.this.f5757l != null;
            }
            c cVar = this.f5765l;
            return (cVar == null || cVar.f5763n == null) ? false : true;
        }
    }

    public static abstract class e extends f implements Iterator {

        public c f5768l;

        public c f5769m;

        public e(c cVar, c cVar2) {
            this.f5768l = cVar2;
            this.f5769m = cVar;
        }

        @Override
        public void mo7855b(c cVar) {
            if (this.f5768l == cVar && cVar == this.f5769m) {
                this.f5769m = null;
                this.f5768l = null;
            }
            c cVar2 = this.f5768l;
            if (cVar2 == cVar) {
                this.f5768l = mo7853c(cVar2);
            }
            if (this.f5769m == cVar) {
                this.f5769m = m7858f();
            }
        }

        public abstract c mo7853c(c cVar);

        public abstract c mo7854d(c cVar);

        @Override
        public Map.Entry next() {
            c cVar = this.f5769m;
            this.f5769m = m7858f();
            return cVar;
        }

        public final c m7858f() {
            c cVar = this.f5769m;
            c cVar2 = this.f5768l;
            if (cVar == cVar2 || cVar2 == null) {
                return null;
            }
            return mo7854d(cVar);
        }

        @Override
        public boolean hasNext() {
            return this.f5769m != null;
        }
    }

    public static abstract class f {
        public abstract void mo7855b(c cVar);
    }

    public Map.Entry m7849d() {
        return this.f5757l;
    }

    public Iterator descendingIterator() {
        b bVar = new b(this.f5758m, this.f5757l);
        this.f5759n.put(bVar, Boolean.FALSE);
        return bVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C1836hl)) {
            return false;
        }
        C1836hl c1836hl = (C1836hl) obj;
        if (size() != c1836hl.size()) {
            return false;
        }
        Iterator it = iterator();
        Iterator it2 = c1836hl.iterator();
        while (it.hasNext() && it2.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object next = it2.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return (it.hasNext() || it2.hasNext()) ? false : true;
    }

    public c mo2849f(Object obj) {
        c cVar = this.f5757l;
        while (cVar != null && !cVar.f5761l.equals(obj)) {
            cVar = cVar.f5763n;
        }
        return cVar;
    }

    public d m7850g() {
        d dVar = new d();
        this.f5759n.put(dVar, Boolean.FALSE);
        return dVar;
    }

    public Map.Entry m7851h() {
        return this.f5758m;
    }

    public int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            iHashCode += ((Map.Entry) it.next()).hashCode();
        }
        return iHashCode;
    }

    public c m7852i(Object obj, Object obj2) {
        c cVar = new c(obj, obj2);
        this.f5760o++;
        c cVar2 = this.f5758m;
        if (cVar2 == null) {
            this.f5757l = cVar;
        } else {
            cVar2.f5763n = cVar;
            cVar.f5764o = cVar2;
        }
        this.f5758m = cVar;
        return cVar;
    }

    @Override
    public Iterator iterator() {
        a aVar = new a(this.f5757l, this.f5758m);
        this.f5759n.put(aVar, Boolean.FALSE);
        return aVar;
    }

    public Object mo2850k(Object obj) {
        c cVarMo2849f = mo2849f(obj);
        if (cVarMo2849f == null) {
            return null;
        }
        this.f5760o--;
        if (!this.f5759n.isEmpty()) {
            Iterator it = this.f5759n.keySet().iterator();
            while (it.hasNext()) {
                ((f) it.next()).mo7855b(cVarMo2849f);
            }
        }
        c cVar = cVarMo2849f.f5764o;
        c cVar2 = cVarMo2849f.f5763n;
        if (cVar != null) {
            cVar.f5763n = cVar2;
        } else {
            this.f5757l = cVar2;
        }
        c cVar3 = cVarMo2849f.f5763n;
        if (cVar3 != null) {
            cVar3.f5764o = cVar;
        } else {
            this.f5758m = cVar;
        }
        cVarMo2849f.f5763n = null;
        cVarMo2849f.f5764o = null;
        return cVarMo2849f.f5762m;
    }

    public int size() {
        return this.f5760o;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            sb.append(((Map.Entry) it.next()).toString());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
