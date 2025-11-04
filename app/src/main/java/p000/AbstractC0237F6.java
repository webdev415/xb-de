package p000;

public abstract class AbstractC0237F6 {

    public static final class a extends AbstractC0025Af implements InterfaceC1920jc {

        public static final a f645m = new a();

        public a() {
            super(2);
        }

        @Override
        public final InterfaceC0191E6 mo858j(InterfaceC0191E6 interfaceC0191E6, InterfaceC0191E6.b bVar) {
            return interfaceC0191E6.mo854I(bVar);
        }
    }

    public static final class b extends AbstractC0025Af implements InterfaceC1920jc {

        public final C2205pk f646m;

        public final boolean f647n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(C2205pk c2205pk, boolean z) {
            super(2);
            this.f646m = c2205pk;
            this.f647n = z;
        }

        @Override
        public final InterfaceC0191E6 mo858j(InterfaceC0191E6 interfaceC0191E6, InterfaceC0191E6.b bVar) {
            return interfaceC0191E6.mo854I(bVar);
        }
    }

    public static final class c extends AbstractC0025Af implements InterfaceC1920jc {

        public static final c f648m = new c();

        public c() {
            super(2);
        }

        public final Boolean m1210a(boolean z, InterfaceC0191E6.b bVar) {
            return Boolean.valueOf(z);
        }

        @Override
        public /* bridge */ Object mo858j(Object obj, Object obj2) {
            return m1210a(((Boolean) obj).booleanValue(), (InterfaceC0191E6.b) obj2);
        }
    }

    public static final InterfaceC0191E6 m1202a(InterfaceC0191E6 interfaceC0191E6, InterfaceC0191E6 interfaceC0191E62, boolean z) {
        boolean zM1204c = m1204c(interfaceC0191E6);
        boolean zM1204c2 = m1204c(interfaceC0191E62);
        if (!zM1204c && !zM1204c2) {
            return interfaceC0191E6.mo854I(interfaceC0191E62);
        }
        C2205pk c2205pk = new C2205pk();
        c2205pk.f6647l = interfaceC0191E62;
        EmptyCoroutineContext emptyCoroutineContext = EmptyCoroutineContext.f1911l;
        InterfaceC0191E6 interfaceC0191E63 = (InterfaceC0191E6) interfaceC0191E6.mo853E(emptyCoroutineContext, new b(c2205pk, z));
        if (zM1204c2) {
            c2205pk.f6647l = ((InterfaceC0191E6) c2205pk.f6647l).mo853E(emptyCoroutineContext, a.f645m);
        }
        return interfaceC0191E63.mo854I((InterfaceC0191E6) c2205pk.f6647l);
    }

    public static final String m1203b(InterfaceC0191E6 interfaceC0191E6) {
        return null;
    }

    public static final boolean m1204c(InterfaceC0191E6 interfaceC0191E6) {
        return ((Boolean) interfaceC0191E6.mo853E(Boolean.FALSE, c.f648m)).booleanValue();
    }

    public static final InterfaceC0191E6 m1205d(InterfaceC0559M6 interfaceC0559M6, InterfaceC0191E6 interfaceC0191E6) {
        InterfaceC0191E6 interfaceC0191E6M1202a = m1202a(interfaceC0559M6.mo2826c(), interfaceC0191E6, true);
        return (interfaceC0191E6M1202a == C1158Z8.m5023a() || interfaceC0191E6M1202a.mo855b(InterfaceC2550x6.f7940a) != null) ? interfaceC0191E6M1202a : interfaceC0191E6M1202a.mo854I(C1158Z8.m5023a());
    }

    public static final AbstractC1886io m1206e(InterfaceC0697P6 interfaceC0697P6) {
        do {
            interfaceC0697P6 = interfaceC0697P6.mo3475d();
        } while (interfaceC0697P6 != null);
        return null;
    }

    public static final AbstractC1886io m1207f(InterfaceC2458v6 interfaceC2458v6, InterfaceC0191E6 interfaceC0191E6, Object obj) {
        if ((interfaceC2458v6 instanceof InterfaceC0697P6) && interfaceC0191E6.mo855b(C1978ko.f6032l) != null) {
            m1206e((InterfaceC0697P6) interfaceC2458v6);
        }
        return null;
    }
}
