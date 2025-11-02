package p000;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class C1185Zq implements InterfaceC0909Tq {

    public final String f3476l;

    public final ArrayList f3477m;

    public C1185Zq(String str, List list) {
        this.f3476l = str;
        ArrayList arrayList = new ArrayList<>();
        this.f3477m = arrayList;
        arrayList.addAll(list);
    }

    public final String m5084a() {
        return this.f3476l;
    }

    public final ArrayList m5085b() {
        return this.f3477m;
    }

    @Override
    public final Boolean mo152d() {
        throw new IllegalStateException("Statement cannot be cast as Boolean");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1185Zq)) {
            return false;
        }
        C1185Zq c1185Zq = (C1185Zq) obj;
        String str = this.f3476l;
        if (str == null ? c1185Zq.f3476l != null : !str.equals(c1185Zq.f3476l)) {
            return false;
        }
        ArrayList arrayList = this.f3477m;
        ArrayList arrayList2 = c1185Zq.f3477m;
        return arrayList != null ? arrayList.equals(arrayList2) : arrayList2 == null;
    }

    @Override
    public final Double mo153f() {
        throw new IllegalStateException("Statement cannot be cast as Double");
    }

    @Override
    public final String mo154h() {
        throw new IllegalStateException("Statement cannot be cast as String");
    }

    public final int hashCode() {
        String str = this.f3476l;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        ArrayList arrayList = this.f3477m;
        return iHashCode + (arrayList != null ? arrayList.hashCode() : 0);
    }

    @Override
    public final Iterator mo155i() {
        return null;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        throw new IllegalStateException("Statement is not an evaluated entity");
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return this;
    }
}
