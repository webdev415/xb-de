package p000;

import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class C2395tq implements InterfaceC0909Tq {

    public final boolean f7290l;

    public C2395tq(Boolean bool) {
        this.f7290l = bool == null ? false : bool.booleanValue();
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return new C2395tq(Boolean.valueOf(this.f7290l));
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.valueOf(this.f7290l);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof C2395tq) && this.f7290l == ((C2395tq) obj).f7290l;
    }

    @Override
    public final Double mo153f() {
        return Double.valueOf(this.f7290l ? 1.0d : 0.0d);
    }

    @Override
    public final String mo154h() {
        return Boolean.toString(this.f7290l);
    }

    public final int hashCode() {
        return Boolean.valueOf(this.f7290l).hashCode();
    }

    @Override
    public final Iterator mo155i() {
        return null;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        if ("toString".equals(str)) {
            return new C1093Xq(Boolean.toString(this.f7290l));
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", Boolean.toString(this.f7290l), str));
    }

    public final String toString() {
        return String.valueOf(this.f7290l);
    }
}
