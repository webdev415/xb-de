package p000;

public final class StartupTime extends AbstractC2391tm {

    public final long epochMillis;

    public final long elapsedRealtime;

    public final long uptimeMillis;

    public StartupTime(long j, long j2, long j3) {
        this.epochMillis = j;
        this.elapsedRealtime = j2;
        this.uptimeMillis = j3;
    }

    @Override
    public long mo4307b() {
        return this.elapsedRealtime;
    }

    @Override
    public long mo4308c() {
        return this.epochMillis;
    }

    @Override
    public long mo4309d() {
        return this.uptimeMillis;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2391tm)) {
            return false;
        }
        AbstractC2391tm abstractC2391tm = (AbstractC2391tm) obj;
        return this.epochMillis == abstractC2391tm.mo4308c() && this.elapsedRealtime == abstractC2391tm.mo4307b() && this.uptimeMillis == abstractC2391tm.mo4309d();
    }

    public int hashCode() {
        long j = this.epochMillis;
        long j2 = this.elapsedRealtime;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.uptimeMillis;
        return i ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.epochMillis + ", elapsedRealtime=" + this.elapsedRealtime + ", uptimeMillis=" + this.uptimeMillis + "}";
    }
}
