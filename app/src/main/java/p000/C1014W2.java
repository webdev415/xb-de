package p000;

import java.util.List;

public final class C1014W2 implements InterfaceC0070Be {

    public final InterfaceC0053B6 f3022a;

    public C1014W2(InterfaceC0053B6 interfaceC0053B6) {
        AbstractC0116Ce.m476e(interfaceC0053B6, "cookieJar");
        this.f3022a = interfaceC0053B6;
    }

    @Override
    public Response mo302a(a aVar) {
        AbstractC0536Lk abstractC0536LkM2392a;
        AbstractC0116Ce.m476e(aVar, "chain");
        Request requestMo303A = aVar.mo303a();
        Request.Builder builderVarM497H = requestMo303A.m497h();
        AbstractC0168Dk abstractC0168DkM490a = requestMo303A.m490a();
        if (abstractC0168DkM490a != null) {
            C0716Pg c0716PgMo721b = abstractC0168DkM490a.mo721b();
            if (c0716PgMo721b != null) {
                builderVarM497H.m501c("Content-Type", c0716PgMo721b.toString());
            }
            long jMo720a = abstractC0168DkM490a.mo720a();
            if (jMo720a != -1) {
                builderVarM497H.m501c("Content-Length", String.valueOf(jMo720a));
                builderVarM497H.m505g("Transfer-Encoding");
            } else {
                builderVarM497H.m501c("Transfer-Encoding", "chunked");
                builderVarM497H.m505g("Content-Length");
            }
        }
        boolean z = false;
        if (requestMo303A.m493d("Host") == null) {
            builderVarM497H.m501c("Host", AbstractC2623yo.m10917M(requestMo303A.getUrl(), false, 1, null));
        }
        if (requestMo303A.m493d("Connection") == null) {
            builderVarM497H.m501c("Connection", "Keep-Alive");
        }
        if (requestMo303A.m493d("Accept-Encoding") == null && requestMo303A.m493d("Range") == null) {
            builderVarM497H.m501c("Accept-Encoding", "gzip");
            z = true;
        }
        List listMo199a = this.f3022a.mo199a(requestMo303A.getUrl());
        if (!listMo199a.isEmpty()) {
            builderVarM497H.m501c("Cookie", m4443b(listMo199a));
        }
        if (requestMo303A.m493d("User-Agent") == null) {
            builderVarM497H.m501c("User-Agent", "okhttp/4.9.1");
        }
        Response responseMo304B = aVar.mo304b(builderVarM497H.m500b());
        AbstractC2658zd.m11024f(this.f3022a, requestMo303A.getUrl(), responseMo304B.getHeaders());
        Response.a aVarM2419r = responseMo304B.m2386C().m2419r(requestMo303A);
        if (z && AbstractC0538Lm.m2720l("gzip", Response.m2383w(responseMo304B, "Content-Encoding", null, 2, null), true) && AbstractC2658zd.m11020b(responseMo304B) && (abstractC0536LkM2392a = responseMo304B.body()) != null) {
            C0666Oc c0666Oc = new C0666Oc(abstractC0536LkM2392a.mo2713k());
            aVarM2419r.m2412k(responseMo304B.getHeaders().m4739g().m4747f("Content-Encoding").m4747f("Content-Length").m4745d());
            aVarM2419r.m2403b(new C1928jk(Response.m2383w(responseMo304B, "Content-Type", null, 2, null), -1L, AbstractC0487Kh.m2376b(c0666Oc)));
        }
        return aVarM2419r.m2404c();
    }

    public final String m4443b(List list) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                AbstractC1810h5.m7790m();
            }
            C0007A6 c0007a6 = (C0007A6) obj;
            if (i > 0) {
                sb.append("; ");
            }
            sb.append(c0007a6.m25e());
            sb.append('=');
            sb.append(c0007a6.m27g());
            i = i2;
        }
        String string = sb.toString();
        AbstractC0116Ce.m475d(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
