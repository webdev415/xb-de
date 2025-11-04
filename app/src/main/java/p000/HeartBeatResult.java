package p000;

import java.util.List;

public final class C0783R1 extends AbstractC1967kd {

    public final String f2311a;

    public final List f2312b;

    public C0783R1(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.f2311a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f2312b = list;
    }

    @Override
    public List mo3749b() {
        return this.f2312b;
    }

    @Override
    public String mo3750c() {
        return this.f2311a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1967kd)) {
            return false;
        }
        AbstractC1967kd abstractC1967kd = (AbstractC1967kd) obj;
        return this.f2311a.equals(abstractC1967kd.mo3750c()) && this.f2312b.equals(abstractC1967kd.mo3749b());
    }

    public int hashCode() {
        return ((this.f2311a.hashCode() ^ 1000003) * 1000003) ^ this.f2312b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.f2311a + ", usedDates=" + this.f2312b + "}";
    }
}
