package p000;

public abstract class AbstractC2639z3 {
    public static final InterfaceC1953k8 m10989a(InterfaceC0559M6 interfaceC0559M6, InterfaceC0191E6 interfaceC0191E6, EnumC0743Q6 enumC0743Q6, InterfaceC1920jc interfaceC1920jc) {
        InterfaceC0191E6 interfaceC0191E6M1205d = AbstractC0237F6.m1205d(interfaceC0559M6, interfaceC0191E6);
        C1999l8 c0163Df = enumC0743Q6.m3631g() ? new C0163Df(interfaceC0191E6M1205d, interfaceC1920jc) : new C1999l8(interfaceC0191E6M1205d, true);
        c0163Df.m10827A0(enumC0743Q6, c0163Df, interfaceC1920jc);
        return c0163Df;
    }

    public static InterfaceC1953k8 m10990b(InterfaceC0559M6 interfaceC0559M6, InterfaceC0191E6 interfaceC0191E6, EnumC0743Q6 enumC0743Q6, InterfaceC1920jc interfaceC1920jc, int i, Object obj) {
        if ((i & 1) != 0) {
            interfaceC0191E6 = C0608N9.f1911l;
        }
        if ((i & 2) != 0) {
            enumC0743Q6 = EnumC0743Q6.DEFAULT;
        }
        return AbstractC2593y3.m10831a(interfaceC0559M6, interfaceC0191E6, enumC0743Q6, interfaceC1920jc);
    }
}
