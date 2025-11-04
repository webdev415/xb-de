package p000;

public abstract class AbstractC1791gn {

    public C2254qn f5642a;

    public long f5643b;

    public final String f5644c;

    public final boolean f5645d;

    public AbstractC1791gn(String str, boolean z) {
        AbstractC0116Ce.m476e(str, "name");
        this.f5644c = str;
        this.f5645d = z;
        this.f5643b = -1L;
    }

    public final boolean m7745a() {
        return this.f5645d;
    }

    public final String m7746b() {
        return this.f5644c;
    }

    public final long m7747c() {
        return this.f5643b;
    }

    public final C2254qn m7748d() {
        return this.f5642a;
    }

    public final void m7749e(C2254qn c2254qn) {
        AbstractC0116Ce.m476e(c2254qn, "queue");
        C2254qn c2254qn2 = this.f5642a;
        if (c2254qn2 == c2254qn) {
            return;
        }
        if (!(c2254qn2 == null)) {
            throw new IllegalStateException("task is in multiple queues".toString());
        }
        this.f5642a = c2254qn;
    }

    public abstract long mo7750f();

    public final void m7751g(long j) {
        this.f5643b = j;
    }

    public String toString() {
        return this.f5644c;
    }

    public AbstractC1791gn(String str, boolean z, int i, AbstractC0881T7 abstractC0881T7) {
        this(str, (i & 2) != 0 ? true : z);
    }
}
