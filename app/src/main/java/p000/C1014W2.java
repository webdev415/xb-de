package p000;

import java.util.List;
import p000.C0122Ck;
import p000.C0490Kk;
import p000.InterfaceC0070Be;

public final class C1014W2 implements InterfaceC0070Be {

    public final InterfaceC0053B6 f3022a;

    public C1014W2(InterfaceC0053B6 interfaceC0053B6) {
        AbstractC0116Ce.m476e(interfaceC0053B6, "cookieJar");
        this.f3022a = interfaceC0053B6;
    }

    @Override
    public C0490Kk mo302a(a aVar) {
        AbstractC0536Lk abstractC0536LkM2392a;
        AbstractC0116Ce.m476e(aVar, "chain");
        C0122Ck c0122CkMo303a = aVar.mo303a();
        C0122Ck.a aVarM497h = c0122CkMo303a.m497h();
        AbstractC0168Dk abstractC0168DkM490a = c0122CkMo303a.m490a();
        if (abstractC0168DkM490a != null) {
            C0716Pg c0716PgMo721b = abstractC0168DkM490a.mo721b();
            if (c0716PgMo721b != null) {
                aVarM497h.m501c("Content-Type", c0716PgMo721b.toString());
            }
            long jMo720a = abstractC0168DkM490a.mo720a();
            if (jMo720a != -1) {
                aVarM497h.m501c("Content-Length", String.valueOf(jMo720a));
                aVarM497h.m505g("Transfer-Encoding");
            } else {
                aVarM497h.m501c("Transfer-Encoding", "chunked");
                aVarM497h.m505g("Content-Length");
            }
        }
        boolean z = false;
        if (c0122CkMo303a.m493d("Host") == null) {
            aVarM497h.m501c("Host", AbstractC2623yo.m10917M(c0122CkMo303a.m498i(), false, 1, null));
        }
        if (c0122CkMo303a.m493d("Connection") == null) {
            aVarM497h.m501c("Connection", "Keep-Alive");
        }
        if (c0122CkMo303a.m493d("Accept-Encoding") == null && c0122CkMo303a.m493d("Range") == null) {
            aVarM497h.m501c("Accept-Encoding", "gzip");
            z = true;
        }
        List listMo199a = this.f3022a.mo199a(c0122CkMo303a.m498i());
        if (!listMo199a.isEmpty()) {
            aVarM497h.m501c("Cookie", m4443b(listMo199a));
        }
        if (c0122CkMo303a.m493d("User-Agent") == null) {
            aVarM497h.m501c("User-Agent", "okhttp/4.9.1");
        }
        C0490Kk c0490KkMo304b = aVar.mo304b(aVarM497h.m500b());
        AbstractC2658zd.m11024f(this.f3022a, c0122CkMo303a.m498i(), c0490KkMo304b.m2401z());
        C0490Kk.a aVarM2419r = c0490KkMo304b.m2386C().m2419r(c0122CkMo303a);
        if (z && AbstractC0538Lm.m2720l("gzip", C0490Kk.m2383w(c0490KkMo304b, "Content-Encoding", null, 2, null), true) && AbstractC2658zd.m11020b(c0490KkMo304b) && (abstractC0536LkM2392a = c0490KkMo304b.m2392a()) != null) {
            C0666Oc c0666Oc = new C0666Oc(abstractC0536LkM2392a.mo2713k());
            aVarM2419r.m2412k(c0490KkMo304b.m2401z().m4739g().m4747f("Content-Encoding").m4747f("Content-Length").m4745d());
            aVarM2419r.m2403b(new C1928jk(C0490Kk.m2383w(c0490KkMo304b, "Content-Type", null, 2, null), -1L, AbstractC0487Kh.m2376b(c0666Oc)));
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
