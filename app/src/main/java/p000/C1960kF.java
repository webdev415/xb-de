package p000;

import java.util.Map;

/* loaded from: classes.dex */
public final class C1960kF implements Comparable, Map.Entry {

    public final Comparable f5996l;

    public Object f5997m;

    public final AbstractC1118YE f5998n;

    public C1960kF(AbstractC1118YE abstractC1118YE, Comparable comparable, Object obj) {
        this.f5998n = abstractC1118YE;
        this.f5996l = comparable;
        this.f5997m = obj;
    }

    public static boolean m8246c(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    @Override
    public final int compareTo(Object obj) {
        return ((Comparable) getKey()).compareTo((Comparable) ((C1960kF) obj).getKey());
    }

    @Override
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return m8246c(this.f5996l, entry.getKey()) && m8246c(this.f5997m, entry.getValue());
    }

    @Override
    public final Object getKey() {
        return this.f5996l;
    }

    @Override
    public final Object getValue() {
        return this.f5997m;
    }

    @Override
    public final int hashCode() {
        Comparable comparable = this.f5996l;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.f5997m;
        return iHashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    @Override
    public final Object setValue(Object obj) {
        this.f5998n.m4919q();
        Object obj2 = this.f5997m;
        this.f5997m = obj;
        return obj2;
    }

    public final String toString() {
        return String.valueOf(this.f5996l) + "=" + String.valueOf(this.f5997m);
    }

    public C1960kF(AbstractC1118YE abstractC1118YE, Map.Entry entry) {
        this(abstractC1118YE, (Comparable) entry.getKey(), entry.getValue());
    }
}
