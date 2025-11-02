package p000;

import java.net.ProtocolException;
import p000.C0490Kk;
import p000.InterfaceC0070Be;

/* loaded from: classes.dex */
public final class C0464K3 implements InterfaceC0070Be {

    public final boolean f1517a;

    public C0464K3(boolean z) {
        this.f1517a = z;
    }

    @Override
    public C0490Kk mo302a(a aVar) throws ProtocolException {
        boolean z;
        C0490Kk.a aVarM9375p;
        C0490Kk.a aVarM2386C;
        AbstractC0536Lk abstractC0536LkM9374o;
        AbstractC0116Ce.m476e(aVar, "chain");
        C1882ik c1882ik = (C1882ik) aVar;
        C2287ra c2287raM7971g = c1882ik.m7971g();
        AbstractC0116Ce.m473b(c2287raM7971g);
        C0122Ck c0122CkM7973i = c1882ik.m7973i();
        AbstractC0168Dk abstractC0168DkM490a = c0122CkM7973i.m490a();
        long jCurrentTimeMillis = System.currentTimeMillis();
        c2287raM7971g.m9379t(c0122CkM7973i);
        if (!C0023Ad.m117a(c0122CkM7973i.m496g()) || abstractC0168DkM490a == null) {
            c2287raM7971g.m9373n();
            z = true;
            aVarM9375p = null;
        } else {
            if (AbstractC0538Lm.m2720l("100-continue", c0122CkM7973i.m493d("Expect"), true)) {
                c2287raM7971g.m9365f();
                aVarM9375p = c2287raM7971g.m9375p(true);
                c2287raM7971g.m9377r();
                z = false;
            } else {
                z = true;
                aVarM9375p = null;
            }
            if (aVarM9375p != null) {
                c2287raM7971g.m9373n();
                if (!c2287raM7971g.m9367h().m7633v()) {
                    c2287raM7971g.m9372m();
                }
            } else if (abstractC0168DkM490a.m722f()) {
                c2287raM7971g.m9365f();
                abstractC0168DkM490a.mo724h(AbstractC0487Kh.m2375a(c2287raM7971g.m9362c(c0122CkM7973i, true)));
            } else {
                InterfaceC2501w3 interfaceC2501w3M2375a = AbstractC0487Kh.m2375a(c2287raM7971g.m9362c(c0122CkM7973i, false));
                abstractC0168DkM490a.mo724h(interfaceC2501w3M2375a);
                interfaceC2501w3M2375a.close();
            }
        }
        if (abstractC0168DkM490a == null || !abstractC0168DkM490a.m722f()) {
            c2287raM7971g.m9364e();
        }
        if (aVarM9375p == null) {
            aVarM9375p = c2287raM7971g.m9375p(false);
            AbstractC0116Ce.m473b(aVarM9375p);
            if (z) {
                c2287raM7971g.m9377r();
                z = false;
            }
        }
        C0490Kk c0490KkM2404c = aVarM9375p.m2419r(c0122CkM7973i).m2410i(c2287raM7971g.m9367h().m7629r()).m2420s(jCurrentTimeMillis).m2418q(System.currentTimeMillis()).m2404c();
        int iM2396j = c0490KkM2404c.m2396j();
        if (iM2396j == 100) {
            C0490Kk.a aVarM9375p2 = c2287raM7971g.m9375p(false);
            AbstractC0116Ce.m473b(aVarM9375p2);
            if (z) {
                c2287raM7971g.m9377r();
            }
            c0490KkM2404c = aVarM9375p2.m2419r(c0122CkM7973i).m2410i(c2287raM7971g.m9367h().m7629r()).m2420s(jCurrentTimeMillis).m2418q(System.currentTimeMillis()).m2404c();
            iM2396j = c0490KkM2404c.m2396j();
        }
        c2287raM7971g.m9376q(c0490KkM2404c);
        if (this.f1517a && iM2396j == 101) {
            aVarM2386C = c0490KkM2404c.m2386C();
            abstractC0536LkM9374o = AbstractC2623yo.f8129c;
        } else {
            aVarM2386C = c0490KkM2404c.m2386C();
            abstractC0536LkM9374o = c2287raM7971g.m9374o(c0490KkM2404c);
        }
        C0490Kk c0490KkM2404c2 = aVarM2386C.m2403b(abstractC0536LkM9374o).m2404c();
        if (AbstractC0538Lm.m2720l("close", c0490KkM2404c2.m2390S().m493d("Connection"), true) || AbstractC0538Lm.m2720l("close", C0490Kk.m2383w(c0490KkM2404c2, "Connection", null, 2, null), true)) {
            c2287raM7971g.m9372m();
        }
        if (iM2396j == 204 || iM2396j == 205) {
            AbstractC0536Lk abstractC0536LkM2392a = c0490KkM2404c2.m2392a();
            if ((abstractC0536LkM2392a != null ? abstractC0536LkM2392a.mo2711i() : -1L) > 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("HTTP ");
                sb.append(iM2396j);
                sb.append(" had non-zero Content-Length: ");
                AbstractC0536Lk abstractC0536LkM2392a2 = c0490KkM2404c2.m2392a();
                sb.append(abstractC0536LkM2392a2 != null ? Long.valueOf(abstractC0536LkM2392a2.mo2711i()) : null);
                throw new ProtocolException(sb.toString());
            }
        }
        return c0490KkM2404c2;
    }
}
