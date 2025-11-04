package p000;

import java.io.IOException;

public final class C0326H3 implements InterfaceC0070Be {

    public static final a f1013a = new a(null);

    public static final class a {
        public a() {
        }

        public final Headers m1507c(Headers headers, Headers headers2) {
            Headers.a aVar = new Headers.a();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String strM4738f = headers.m4738f(i);
                String strM4740h = headers.m4740h(i);
                if ((!AbstractC0538Lm.m2720l("Warning", strM4738f, true) || !AbstractC0538Lm.m2731w(strM4740h, "1", false, 2, null)) && (m1508d(strM4738f) || !m1509e(strM4738f) || headers2.m4737d(strM4738f) == null)) {
                    aVar.m4744c(strM4738f, strM4740h);
                }
            }
            int size2 = headers2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String strM4738f2 = headers2.m4738f(i2);
                if (!m1508d(strM4738f2) && m1509e(strM4738f2)) {
                    aVar.m4744c(strM4738f2, headers2.m4740h(i2));
                }
            }
            return aVar.m4745d();
        }

        public final boolean m1508d(String str) {
            return AbstractC0538Lm.m2720l("Content-Length", str, true) || AbstractC0538Lm.m2720l("Content-Encoding", str, true) || AbstractC0538Lm.m2720l("Content-Type", str, true);
        }

        public final boolean m1509e(String str) {
            return (AbstractC0538Lm.m2720l("Connection", str, true) || AbstractC0538Lm.m2720l("Keep-Alive", str, true) || AbstractC0538Lm.m2720l("Proxy-Authenticate", str, true) || AbstractC0538Lm.m2720l("Proxy-Authorization", str, true) || AbstractC0538Lm.m2720l("TE", str, true) || AbstractC0538Lm.m2720l("Trailers", str, true) || AbstractC0538Lm.m2720l("Transfer-Encoding", str, true) || AbstractC0538Lm.m2720l("Upgrade", str, true)) ? false : true;
        }

        public final Response m1510f(Response response) {
            return (response != null ? response.body() : null) != null ? response.m2386C().m2403b(null).m2404c() : response;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public C0326H3(AbstractC0234F3 abstractC0234F3) {
    }

    @Override
    public Response mo302a(InterfaceC0070Be.a aVar) throws IOException {
        AbstractC1918ja abstractC1918jaM7444q;
        AbstractC0116Ce.m476e(aVar, "chain");
        InterfaceC0418J3 interfaceC0418J3Call = aVar.call();
        C0372I3 c0372i3M1669b = new C0372I3.b(System.currentTimeMillis(), aVar.mo303a(), null).m1669b();
        Request requestM1666B = c0372i3M1669b.m1666b();
        Response responseM1665A = c0372i3M1669b.m1665a();
        C1694ek c1694ek = (C1694ek) (!(interfaceC0418J3Call instanceof C1694ek) ? null : interfaceC0418J3Call);
        if (c1694ek == null || (abstractC1918jaM7444q = c1694ek.m7444q()) == null) {
            abstractC1918jaM7444q = AbstractC1918ja.f5944a;
        }
        if (requestM1666B == null && responseM1665A == null) {
            Response c0490KkM2404c = new Response.a().m2419r(aVar.mo303a()).m2417p(EnumC2342sj.HTTP_1_1).m2408g(504).m2414m("Unsatisfiable Request (only-if-cached)").m2403b(AbstractC2623yo.f8129c).m2420s(-1L).m2418q(System.currentTimeMillis()).m2404c();
            abstractC1918jaM7444q.m8157z(interfaceC0418J3Call, c0490KkM2404c);
            return c0490KkM2404c;
        }
        if (requestM1666B == null) {
            AbstractC0116Ce.m473b(responseM1665A);
            Response c0490KkM2404c2 = responseM1665A.m2386C().m2405d(f1013a.m1510f(responseM1665A)).m2404c();
            abstractC1918jaM7444q.m8133b(interfaceC0418J3Call, c0490KkM2404c2);
            return c0490KkM2404c2;
        }
        if (responseM1665A != null) {
            abstractC1918jaM7444q.m8132a(interfaceC0418J3Call, responseM1665A);
        }
        Response responseMo304B = aVar.mo304b(requestM1666B);
        if (responseM1665A != null) {
            if (responseMo304B != null && responseMo304B.getStatus() == 304) {
                Response.a aVarM2386C = responseM1665A.m2386C();
                a aVar2 = f1013a;
                aVarM2386C.m2412k(aVar2.m1507c(responseM1665A.getHeaders(), responseMo304B.getHeaders())).m2420s(responseMo304B.m2391T()).m2418q(responseMo304B.m2389J()).m2405d(aVar2.m1510f(responseM1665A)).m2415n(aVar2.m1510f(responseMo304B)).m2404c();
                AbstractC0536Lk abstractC0536LkM2392a = responseMo304B.body();
                AbstractC0116Ce.m473b(abstractC0536LkM2392a);
                abstractC0536LkM2392a.close();
                AbstractC0116Ce.m473b(null);
                throw null;
            }
            AbstractC0536Lk abstractC0536LkM2392a2 = responseM1665A.body();
            if (abstractC0536LkM2392a2 != null) {
                AbstractC2623yo.m10935j(abstractC0536LkM2392a2);
            }
        }
        AbstractC0116Ce.m473b(responseMo304B);
        Response.a aVarM2386C2 = responseMo304B.m2386C();
        a aVar3 = f1013a;
        return aVarM2386C2.m2405d(aVar3.m1510f(responseM1665A)).m2415n(aVar3.m1510f(responseMo304B)).m2404c();
    }
}
