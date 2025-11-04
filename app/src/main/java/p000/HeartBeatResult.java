package p000;

import java.util.List;

public final class HeartBeatResult extends AbstractC1967kd {

    public final String userAgent;

    public final List usedDates;

    public HeartBeatResult(String str, List list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.userAgent = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.usedDates = list;
    }

    @Override
    public List mo3749b() {
        return this.usedDates;
    }

    @Override
    public String mo3750c() {
        return this.userAgent;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC1967kd)) {
            return false;
        }
        AbstractC1967kd abstractC1967kd = (AbstractC1967kd) obj;
        return this.userAgent.equals(abstractC1967kd.mo3750c()) && this.usedDates.equals(abstractC1967kd.mo3749b());
    }

    public int hashCode() {
        return ((this.userAgent.hashCode() ^ 1000003) * 1000003) ^ this.usedDates.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.userAgent + ", usedDates=" + this.usedDates + "}";
    }
}
