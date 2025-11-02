package p000;

/* loaded from: classes.dex */
public final class C2115nn extends AbstractRunnableC1744fn {

    public final Runnable f6479n;

    public C2115nn(Runnable runnable, long j, InterfaceC1931jn interfaceC1931jn) {
        super(j, interfaceC1931jn);
        this.f6479n = runnable;
    }

    @Override
    public void run() {
        try {
            this.f6479n.run();
        } finally {
            this.f5548m.mo8203b();
        }
    }

    public String toString() {
        return "Task[" + AbstractC2505w7.m10433a(this.f6479n) + '@' + AbstractC2505w7.m10434b(this.f6479n) + ", " + this.f5547l + ", " + this.f5548m + ']';
    }
}
