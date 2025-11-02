package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class C0388Ia {

    public final List f1148a;

    public final int f1149b;

    public final boolean f1150c;

    public C0388Ia(List list, int i, boolean z) {
        this.f1148a = new ArrayList<>(list);
        this.f1149b = i;
        this.f1150c = z;
    }

    public List m1685a() {
        return this.f1148a;
    }

    public int m1686b() {
        return this.f1149b;
    }

    public boolean m1687c(List list) {
        return this.f1148a.equals(list);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C0388Ia)) {
            return false;
        }
        C0388Ia c0388Ia = (C0388Ia) obj;
        return this.f1148a.equals(c0388Ia.f1148a) && this.f1150c == c0388Ia.f1150c;
    }

    public int hashCode() {
        return this.f1148a.hashCode() ^ Boolean.valueOf(this.f1150c).hashCode();
    }

    public String toString() {
        return "{ " + this.f1148a + " }";
    }
}
