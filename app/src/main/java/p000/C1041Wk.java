package p000;

public final class C1041Wk {

    public static C1041Wk f3103b;

    public static final C1087Xk f3104c = new C1087Xk(0, false, false, 0, 0);

    public C1087Xk f3105a;

    public static synchronized C1041Wk m4536a() {
        try {
            if (f3103b == null) {
                f3103b = new C1041Wk();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f3103b;
    }

    public final synchronized void m4537b(C1087Xk c1087Xk) {
        if (c1087Xk == null) {
            this.f3105a = f3104c;
            return;
        }
        C1087Xk c1087Xk2 = this.f3105a;
        if (c1087Xk2 == null || c1087Xk2.m4811i() < c1087Xk.m4811i()) {
            this.f3105a = c1087Xk;
        }
    }
}
