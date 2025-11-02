package p000;

import p000.InterfaceC0191E6;

/* loaded from: classes.dex */
public interface InterfaceC2550x6 extends InterfaceC0191E6.b {

    public static final b f7940a = b.f7941l;

    public static final class a {
        public static InterfaceC0191E6.b m10628a(InterfaceC2550x6 interfaceC2550x6, c cVar) {
            AbstractC0116Ce.m476e(cVar, "key");
            if (!(cVar instanceof AbstractC0000A)) {
                if (InterfaceC2550x6.f7940a != cVar) {
                    return null;
                }
                AbstractC0116Ce.m474c(interfaceC2550x6, "null cannot be cast to non-null type E of kotlin.coroutines.ContinuationInterceptor.get");
                return interfaceC2550x6;
            }
            AbstractC0000A abstractC0000A = (AbstractC0000A) cVar;
            if (!abstractC0000A.m0a(interfaceC2550x6.getKey())) {
                return null;
            }
            InterfaceC0191E6.b bVarM1b = abstractC0000A.m1b(interfaceC2550x6);
            if (bVarM1b instanceof InterfaceC0191E6.b) {
                return bVarM1b;
            }
            return null;
        }

        public static InterfaceC0191E6 m10629b(InterfaceC2550x6 interfaceC2550x6, c cVar) {
            AbstractC0116Ce.m476e(cVar, "key");
            if (!(cVar instanceof AbstractC0000A)) {
                return InterfaceC2550x6.f7940a == cVar ? C0608N9.f1911l : interfaceC2550x6;
            }
            AbstractC0000A abstractC0000A = (AbstractC0000A) cVar;
            return (!abstractC0000A.m0a(interfaceC2550x6.getKey()) || abstractC0000A.m1b(interfaceC2550x6) == null) ? interfaceC2550x6 : C0608N9.f1911l;
        }
    }

    public static final class b implements c {

        public static final b f7941l = new b();
    }

    void mo1349J(InterfaceC2458v6 interfaceC2458v6);

    InterfaceC2458v6 mo1350S(InterfaceC2458v6 interfaceC2458v6);
}
