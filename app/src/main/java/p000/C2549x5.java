package p000;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes.dex */
public final class C2549x5 extends AbstractC1786gi implements Serializable {

    public final Comparator f7939l;

    public C2549x5(Comparator comparator) {
        this.f7939l = (Comparator) AbstractC1131Yi.m4973i(comparator);
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return this.f7939l.compare(obj, obj2);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C2549x5) {
            return this.f7939l.equals(((C2549x5) obj).f7939l);
        }
        return false;
    }

    public int hashCode() {
        return this.f7939l.hashCode();
    }

    public String toString() {
        return this.f7939l.toString();
    }
}
