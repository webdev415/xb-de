package p000;

import java.util.AbstractMap;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes.dex */
public abstract class AbstractC1118YE extends AbstractMap {

    public Object[] f3321l;

    public int f3322m;

    public Map f3323n;

    public boolean f3324o;

    public volatile C2421uF f3325p;

    public Map f3326q;

    public AbstractC1118YE() {
        this.f3323n = Collections.emptyMap();
        this.f3326q = Collections.emptyMap();
    }

    public final int m4909a() {
        return this.f3322m;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m4910b(Comparable r5) {
        /*
            r4 = this;
            int r0 = r4.f3322m
            int r1 = r0 + (-1)
            if (r1 < 0) goto L1f
            java.lang.Object[] r2 = r4.f3321l
            r2 = r2[r1]
            kF r2 = (p000.C1960kF) r2
            java.lang.Object r2 = r2.getKey()
            java.lang.Comparable r2 = (java.lang.Comparable) r2
            int r2 = r5.compareTo(r2)
            if (r2 <= 0) goto L1c
            int r0 = r0 + 1
        L1a:
            int r5 = -r0
            return r5
        L1c:
            if (r2 != 0) goto L1f
            return r1
        L1f:
            r0 = 0
        L20:
            if (r0 > r1) goto L41
            int r2 = r0 + r1
            int r2 = r2 / 2
            java.lang.Object[] r3 = r4.f3321l
            r3 = r3[r2]
            kF r3 = (p000.C1960kF) r3
            java.lang.Object r3 = r3.getKey()
            java.lang.Comparable r3 = (java.lang.Comparable) r3
            int r3 = r5.compareTo(r3)
            if (r3 >= 0) goto L3b
            int r1 = r2 + (-1)
            goto L20
        L3b:
            if (r3 <= 0) goto L40
            int r0 = r2 + 1
            goto L20
        L40:
            return r2
        L41:
            int r0 = r0 + 1
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC1118YE.m4910b(java.lang.Comparable):int");
    }

    @Override
    public void clear() {
        m4919q();
        if (this.f3322m != 0) {
            this.f3321l = null;
            this.f3322m = 0;
        }
        if (this.f3323n.isEmpty()) {
            return;
        }
        this.f3323n.clear();
    }

    @Override
    public boolean containsKey(Object obj) {
        Comparable comparable = (Comparable) obj;
        return m4910b(comparable) >= 0 || this.f3323n.containsKey(comparable);
    }

    @Override
    public final Object put(Comparable comparable, Object obj) {
        m4919q();
        int iM4910b = m4910b(comparable);
        if (iM4910b >= 0) {
            return ((C1960kF) this.f3321l[iM4910b]).setValue(obj);
        }
        m4919q();
        if (this.f3321l == null) {
            this.f3321l = new Object[16];
        }
        int i = -(iM4910b + 1);
        if (i >= 16) {
            return m4918p().put(comparable, obj);
        }
        int i2 = this.f3322m;
        if (i2 == 16) {
            C1960kF c1960kF = (C1960kF) this.f3321l[15];
            this.f3322m = i2 - 1;
            m4918p().put((Comparable) c1960kF.getKey(), c1960kF.getValue());
        }
        Object[] objArr = this.f3321l;
        System.arraycopy(objArr, i, objArr, i + 1, (objArr.length - i) - 1);
        this.f3321l[i] = new C1960kF(this, comparable, obj);
        this.f3322m++;
        return null;
    }

    @Override
    public Set entrySet() {
        if (this.f3325p == null) {
            this.f3325p = new C2421uF(this);
        }
        return this.f3325p;
    }

    @Override
    public boolean equals(Object obj) {
        Object objEntrySet;
        Object objEntrySet2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractC1118YE)) {
            return super.equals(obj);
        }
        AbstractC1118YE abstractC1118YE = (AbstractC1118YE) obj;
        int size = size();
        if (size != abstractC1118YE.size()) {
            return false;
        }
        int i = this.f3322m;
        if (i != abstractC1118YE.f3322m) {
            objEntrySet = entrySet();
            objEntrySet2 = abstractC1118YE.entrySet();
        } else {
            for (int i2 = 0; i2 < i; i2++) {
                if (!m4912f(i2).equals(abstractC1118YE.m4912f(i2))) {
                    return false;
                }
            }
            if (i == size) {
                return true;
            }
            objEntrySet = this.f3323n;
            objEntrySet2 = abstractC1118YE.f3323n;
        }
        return objEntrySet.equals(objEntrySet2);
    }

    public final Entry m4912f(int i) {
        if (i < this.f3322m) {
            return (C1960kF) this.f3321l[i];
        }
        throw new ArrayIndexOutOfBoundsException(i);
    }

    public final Iterable m4913g() {
        return this.f3323n.isEmpty() ? Collections.emptySet() : this.f3323n.entrySet();
    }

    @Override
    public Object get(Object obj) {
        Comparable comparable = (Comparable) obj;
        int iM4910b = m4910b(comparable);
        return iM4910b >= 0 ? ((C1960kF) this.f3321l[iM4910b]).getValue() : this.f3323n.get(comparable);
    }

    public final Object m4914h(int i) {
        m4919q();
        Object value = ((C1960kF) this.f3321l[i]).getValue();
        Object[] objArr = this.f3321l;
        System.arraycopy(objArr, i + 1, objArr, i, (this.f3322m - i) - 1);
        this.f3322m--;
        if (!this.f3323n.isEmpty()) {
            Iterator it = m4918p().entrySet().iterator();
            this.f3321l[this.f3322m] = new C1960kF(this, (Entry) it.next());
            this.f3322m++;
            it.remove();
        }
        return value;
    }

    @Override
    public int hashCode() {
        int i = this.f3322m;
        int iHashCode = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iHashCode += this.f3321l[i2].hashCode();
        }
        return this.f3323n.size() > 0 ? iHashCode + this.f3323n.hashCode() : iHashCode;
    }

    public final Set m4915k() {
        return new C1773gF(this);
    }

    public void mo4916l() {
        if (this.f3324o) {
            return;
        }
        this.f3323n = this.f3323n.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3323n);
        this.f3326q = this.f3326q.isEmpty() ? Collections.emptyMap() : Collections.unmodifiableMap(this.f3326q);
        this.f3324o = true;
    }

    public final boolean m4917n() {
        return this.f3324o;
    }

    public final SortedMap m4918p() {
        m4919q();
        if (this.f3323n.isEmpty() && !(this.f3323n instanceof TreeMap)) {
            TreeMap treeMap = new TreeMap();
            this.f3323n = treeMap;
            this.f3326q = treeMap.descendingMap();
        }
        return (SortedMap) this.f3323n;
    }

    public final void m4919q() {
        if (this.f3324o) {
            throw new UnsupportedOperationException();
        }
    }

    @Override
    public Object remove(Object obj) {
        m4919q();
        Comparable comparable = (Comparable) obj;
        int iM4910b = m4910b(comparable);
        if (iM4910b >= 0) {
            return m4914h(iM4910b);
        }
        if (this.f3323n.isEmpty()) {
            return null;
        }
        return this.f3323n.remove(comparable);
    }

    @Override
    public int size() {
        return this.f3322m + this.f3323n.size();
    }
}
