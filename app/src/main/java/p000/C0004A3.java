package p000;

import java.io.Serializable;

public final class C0004A3 extends AbstractC1786gi implements Serializable {

    public final InterfaceC2289rc f3l;

    public final AbstractC1786gi f4m;

    public C0004A3(InterfaceC2289rc interfaceC2289rc, AbstractC1786gi abstractC1786gi) {
        this.f3l = (InterfaceC2289rc) AbstractC1131Yi.m4973i(interfaceC2289rc);
        this.f4m = (AbstractC1786gi) AbstractC1131Yi.m4973i(abstractC1786gi);
    }

    @Override
    public int compare(Object obj, Object obj2) {
        return this.f4m.compare(this.f3l.apply(obj), this.f3l.apply(obj2));
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0004A3)) {
            return false;
        }
        C0004A3 c0004a3 = (C0004A3) obj;
        return this.f3l.equals(c0004a3.f3l) && this.f4m.equals(c0004a3.f4m);
    }

    public int hashCode() {
        return AbstractC0303Gh.m1399b(this.f3l, this.f4m);
    }

    public String toString() {
        String strValueOf = String.valueOf(this.f4m);
        String strValueOf2 = String.valueOf(this.f3l);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 13 + strValueOf2.length());
        sb.append(strValueOf);
        sb.append(".onResultOf(");
        sb.append(strValueOf2);
        sb.append(")");
        return sb.toString();
    }
}
