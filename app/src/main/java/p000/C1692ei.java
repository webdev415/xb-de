package p000;

public class C1692ei implements InterfaceC2388tj {

    public static final InterfaceC1906j8 f5427c = new InterfaceC1906j8() {
        @Override
        public final void mo5924a(InterfaceC2388tj interfaceC2388tj) {
            C1692ei.m7423d(interfaceC2388tj);
        }
    };

    public static final InterfaceC2388tj f5428d = new InterfaceC2388tj() {
        @Override
        public final Object get() {
            return C1692ei.m7424e();
        }
    };

    public InterfaceC1906j8 f5429a;

    public volatile InterfaceC2388tj f5430b;

    public C1692ei(InterfaceC1906j8 interfaceC1906j8, InterfaceC2388tj interfaceC2388tj) {
        this.f5429a = interfaceC1906j8;
        this.f5430b = interfaceC2388tj;
    }

    public static C1692ei m7422c() {
        return new C1692ei(f5427c, f5428d);
    }

    public static Object m7424e() {
        return null;
    }

    public void m7425f(InterfaceC2388tj interfaceC2388tj) {
        InterfaceC1906j8 interfaceC1906j8;
        if (this.f5430b != f5428d) {
            throw new IllegalStateException("provide() can be called only once.");
        }
        synchronized (this) {
            interfaceC1906j8 = this.f5429a;
            this.f5429a = null;
            this.f5430b = interfaceC2388tj;
        }
        interfaceC1906j8.mo5924a(interfaceC2388tj);
    }

    @Override
    public Object get() {
        return this.f5430b.get();
    }

    public static void m7423d(InterfaceC2388tj interfaceC2388tj) {
    }
}
