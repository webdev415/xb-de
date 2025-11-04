package p000;

public final class C0967V1 extends AbstractC2391tm {

    public final long f2908a;

    public final long f2909b;

    public final long f2910c;

    public C0967V1(long j, long j2, long j3) {
        this.f2908a = j;
        this.f2909b = j2;
        this.f2910c = j3;
    }

    @Override
    public long mo4307b() {
        return this.f2909b;
    }

    @Override
    public long mo4308c() {
        return this.f2908a;
    }

    @Override
    public long mo4309d() {
        return this.f2910c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AbstractC2391tm)) {
            return false;
        }
        AbstractC2391tm abstractC2391tm = (AbstractC2391tm) obj;
        return this.f2908a == abstractC2391tm.mo4308c() && this.f2909b == abstractC2391tm.mo4307b() && this.f2910c == abstractC2391tm.mo4309d();
    }

    public int hashCode() {
        long j = this.f2908a;
        long j2 = this.f2909b;
        int i = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ ((int) (j2 ^ (j2 >>> 32)))) * 1000003;
        long j3 = this.f2910c;
        return i ^ ((int) ((j3 >>> 32) ^ j3));
    }

    public String toString() {
        return "StartupTime{epochMillis=" + this.f2908a + ", elapsedRealtime=" + this.f2909b + ", uptimeMillis=" + this.f2910c + "}";
    }
}
