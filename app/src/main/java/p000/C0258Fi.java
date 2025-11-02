package p000;

import java.io.Serializable;

/* loaded from: classes.dex */
public final class C0258Fi implements Serializable {

    public final Object f667l;

    public final Object f668m;

    public C0258Fi(Object obj, Object obj2) {
        this.f667l = obj;
        this.f668m = obj2;
    }

    public final Object m1259a() {
        return this.f667l;
    }

    public final Object m1260b() {
        return this.f668m;
    }

    public final Object m1261c() {
        return this.f667l;
    }

    public final Object m1262d() {
        return this.f668m;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0258Fi)) {
            return false;
        }
        C0258Fi c0258Fi = (C0258Fi) obj;
        return AbstractC0116Ce.m472a(this.f667l, c0258Fi.f667l) && AbstractC0116Ce.m472a(this.f668m, c0258Fi.f668m);
    }

    public int hashCode() {
        Object obj = this.f667l;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.f668m;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public String toString() {
        return '(' + this.f667l + ", " + this.f668m + ')';
    }
}
