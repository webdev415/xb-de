package p000;

/* loaded from: classes.dex */
public abstract class AbstractC2113nl extends AbstractC2425ua {

    public final int f6474o;

    public final int f6475p;

    public final long f6476q;

    public final String f6477r;

    public ExecutorC0513L6 f6478s = m8793W();

    public AbstractC2113nl(int i, int i2, long j, String str) {
        this.f6474o = i;
        this.f6475p = i2;
        this.f6476q = j;
        this.f6477r = str;
    }

    @Override
    public void mo1351T(InterfaceC0191E6 interfaceC0191E6, Runnable runnable) {
        ExecutorC0513L6.m2590l(this.f6478s, runnable, null, false, 6, null);
    }

    public final ExecutorC0513L6 m8793W() {
        return new ExecutorC0513L6(this.f6474o, this.f6475p, this.f6476q, this.f6477r);
    }

    public final void m8794X(Runnable runnable, InterfaceC1931jn interfaceC1931jn, boolean z) {
        this.f6478s.m2602k(runnable, interfaceC1931jn, z);
    }
}
