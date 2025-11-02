package p000;

import java.util.Iterator;
import java.util.List;

public final class C0174Dq implements InterfaceC0909Tq {

    public final InterfaceC0909Tq f433l;

    public final String f434m;

    public C0174Dq(String str) {
        this.f433l = InterfaceC0909Tq.f2785d;
        this.f434m = str;
    }

    public final InterfaceC0909Tq m780a() {
        return this.f433l;
    }

    public final String m781b() {
        return this.f434m;
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return new C0174Dq(this.f434m, this.f433l.mo151c());
    }

    @Override
    public final Boolean mo152d() {
        throw new IllegalStateException("Control is not a boolean");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0174Dq)) {
            return false;
        }
        C0174Dq c0174Dq = (C0174Dq) obj;
        return this.f434m.equals(c0174Dq.f434m) && this.f433l.equals(c0174Dq.f433l);
    }

    @Override
    public final Double mo153f() {
        throw new IllegalStateException("Control is not a double");
    }

    @Override
    public final String mo154h() {
        throw new IllegalStateException("Control is not a String");
    }

    public final int hashCode() {
        return (this.f434m.hashCode() * 31) + this.f433l.hashCode();
    }

    @Override
    public final Iterator mo155i() {
        return null;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        throw new IllegalStateException("Control does not have functions");
    }

    public C0174Dq(String str, InterfaceC0909Tq interfaceC0909Tq) {
        this.f433l = interfaceC0909Tq;
        this.f434m = str;
    }
}
