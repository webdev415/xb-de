package p000;

import p000.InterfaceC2550x6;

/* loaded from: classes.dex */
public interface InterfaceC0191E6 {

    public static final class a {

        public static final class C2686a extends AbstractC0025Af implements InterfaceC1920jc {

            public static final C2686a f461m = new C2686a();

            public C2686a() {
                super(2);
            }

            @Override
            public final InterfaceC0191E6 mo858j(InterfaceC0191E6 interfaceC0191E6, b bVar) {
                C2227q5 c2227q5;
                AbstractC0116Ce.m476e(interfaceC0191E6, "acc");
                AbstractC0116Ce.m476e(bVar, "element");
                InterfaceC0191E6 interfaceC0191E6Mo852B = interfaceC0191E6.mo852B(bVar.getKey());
                C0608N9 c0608n9 = C0608N9.f1911l;
                if (interfaceC0191E6Mo852B == c0608n9) {
                    return bVar;
                }
                InterfaceC2550x6.b bVar2 = InterfaceC2550x6.f7940a;
                InterfaceC2550x6 interfaceC2550x6 = (InterfaceC2550x6) interfaceC0191E6Mo852B.mo855b(bVar2);
                if (interfaceC2550x6 == null) {
                    c2227q5 = new C2227q5(interfaceC0191E6Mo852B, bVar);
                } else {
                    InterfaceC0191E6 interfaceC0191E6Mo852B2 = interfaceC0191E6Mo852B.mo852B(bVar2);
                    if (interfaceC0191E6Mo852B2 == c0608n9) {
                        return new C2227q5(bVar, interfaceC2550x6);
                    }
                    c2227q5 = new C2227q5(new C2227q5(interfaceC0191E6Mo852B2, bVar), interfaceC2550x6);
                }
                return c2227q5;
            }
        }

        public static InterfaceC0191E6 m856a(InterfaceC0191E6 interfaceC0191E6, InterfaceC0191E6 interfaceC0191E62) {
            AbstractC0116Ce.m476e(interfaceC0191E62, "context");
            return interfaceC0191E62 == C0608N9.f1911l ? interfaceC0191E6 : (InterfaceC0191E6) interfaceC0191E62.mo853E(interfaceC0191E6, C2686a.f461m);
        }
    }

    public interface b extends InterfaceC0191E6 {

        public static final class a {
            public static Object m859a(b bVar, Object obj, InterfaceC1920jc interfaceC1920jc) {
                AbstractC0116Ce.m476e(interfaceC1920jc, "operation");
                return interfaceC1920jc.mo858j(obj, bVar);
            }

            public static b m860b(b bVar, c cVar) {
                AbstractC0116Ce.m476e(cVar, "key");
                if (!AbstractC0116Ce.m472a(bVar.getKey(), cVar)) {
                    return null;
                }
                AbstractC0116Ce.m474c(bVar, "null cannot be cast to non-null type E of kotlin.coroutines.CoroutineContext.Element.get");
                return bVar;
            }

            public static InterfaceC0191E6 m861c(b bVar, c cVar) {
                AbstractC0116Ce.m476e(cVar, "key");
                return AbstractC0116Ce.m472a(bVar.getKey(), cVar) ? C0608N9.f1911l : bVar;
            }

            public static InterfaceC0191E6 m862d(b bVar, InterfaceC0191E6 interfaceC0191E6) {
                AbstractC0116Ce.m476e(interfaceC0191E6, "context");
                return a.m856a(bVar, interfaceC0191E6);
            }
        }

        @Override
        b mo855b(c cVar);

        c getKey();
    }

    public interface c {
    }

    InterfaceC0191E6 mo852B(c cVar);

    Object mo853E(Object obj, InterfaceC1920jc interfaceC1920jc);

    InterfaceC0191E6 mo854I(InterfaceC0191E6 interfaceC0191E6);

    b mo855b(c cVar);
}
