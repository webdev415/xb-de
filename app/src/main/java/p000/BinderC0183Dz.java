package p000;

import android.os.Binder;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class BinderC0183Dz extends AbstractBinderC1614cx {

    public final C0200EF f441c;

    public Boolean f442d;

    public String f443e;

    public BinderC0183Dz(C0200EF c0200ef) {
        this(c0200ef, null);
    }

    @Override
    public final List mo799A(String str, String str2, String str3) {
        m810S(str, true);
        try {
            return (List) this.f441c.mo354l().m7378v(new CallableC1674eA(this, str, str2, str3)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f441c.mo349g().m9618G().m10617b("Failed to get conditional user properties as", e);
            return Collections.emptyList();
        }
    }

    @Override
    public final List mo800B(C0569MG c0569mg, boolean z) {
        m814W(c0569mg, false);
        String str = c0569mg.f1787l;
        AbstractC1085Xi.m4801j(str);
        try {
            List<C2238qG> list = (List) this.f441c.mo354l().m7378v(new CallableC2324sA(this, str)).get();
            ArrayList arrayList = new ArrayList<>(list.size());
            for (C2238qG c2238qG : list) {
                if (z || !C2514wG.m10452J0(c2238qG.f6718c)) {
                    arrayList.add(new C2053mG(c2238qG));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.f441c.mo349g().m9618G().m10618c("Failed to get user properties. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            this.f441c.mo349g().m9618G().m10618c("Failed to get user properties. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return null;
        }
    }

    @Override
    public final void mo801C(C0569MG c0569mg) {
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        m810S(c0569mg.f1787l, false);
        m813V(new RunnableC1628dA(this, c0569mg));
    }

    @Override
    public final void mo802F(C2303rq c2303rq) {
        AbstractC1085Xi.m4801j(c2303rq);
        AbstractC1085Xi.m4801j(c2303rq.f6978n);
        AbstractC1085Xi.m4795d(c2303rq.f6976l);
        m810S(c2303rq.f6976l, true);
        m813V(new RunnableC1056Wz(this, new C2303rq(c2303rq)));
    }

    @Override
    public final void mo803G(final C0569MG c0569mg) {
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        AbstractC1085Xi.m4801j(c0569mg.f1776G);
        m809R(new Runnable() {
            @Override
            public final void run() {
                this.f698l.m817Z(c0569mg);
            }
        });
    }

    @Override
    public final List mo804H(C0569MG c0569mg, Bundle bundle) {
        m814W(c0569mg, false);
        AbstractC1085Xi.m4801j(c0569mg.f1787l);
        try {
            return (List) this.f441c.mo354l().m7378v(new CallableC2416uA(this, c0569mg, bundle)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f441c.mo349g().m9618G().m10618c("Failed to get trigger URIs. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return Collections.emptyList();
        }
    }

    @Override
    public final void mo805I(final C0569MG c0569mg) {
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        AbstractC1085Xi.m4801j(c0569mg.f1776G);
        m809R(new Runnable() {
            @Override
            public final void run() {
                this.f7926l.m818a0(c0569mg);
            }
        });
    }

    @Override
    public final void mo806J(C2053mG c2053mG, C0569MG c0569mg) {
        AbstractC1085Xi.m4801j(c2053mG);
        m814W(c0569mg, false);
        m813V(new RunnableC2139oA(this, c2053mG, c0569mg));
    }

    @Override
    public final void mo807K(C0635Nr c0635Nr, String str, String str2) {
        AbstractC1085Xi.m4801j(c0635Nr);
        AbstractC1085Xi.m4795d(str);
        m810S(str, true);
        m813V(new RunnableC1955kA(this, c0635Nr, str));
    }

    public final void m808Q(Bundle bundle, String str) {
        boolean zM10818t = this.f441c.m941i0().m10818t(AbstractC0818Rr.f2510j1);
        boolean zM10818t2 = this.f441c.m941i0().m10818t(AbstractC0818Rr.f2516l1);
        if (bundle.isEmpty() && zM10818t && zM10818t2) {
            this.f441c.m946l0().m2519c1(str);
        } else {
            this.f441c.m946l0().m2526g0(str, bundle);
        }
    }

    public final void m809R(Runnable runnable) {
        AbstractC1085Xi.m4801j(runnable);
        if (this.f441c.mo354l().m7376J()) {
            runnable.run();
        } else {
            this.f441c.mo354l().m7375G(runnable);
        }
    }

    public final void m810S(String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            this.f441c.mo349g().m9618G().m10616a("Measurement Service called without app package");
            throw new SecurityException("Measurement Service called without app package");
        }
        if (z) {
            try {
                if (this.f442d == null) {
                    this.f442d = Boolean.valueOf("com.google.android.gms".equals(this.f443e) || AbstractC1792go.m7752a(this.f441c.mo344a(), Binder.getCallingUid()) || C0528Lc.m2656a(this.f441c.mo344a()).m2660c(Binder.getCallingUid()));
                }
                if (this.f442d.booleanValue()) {
                    return;
                }
            } catch (SecurityException e) {
                this.f441c.mo349g().m9618G().m10617b("Measurement Service called with invalid calling package. appId", C2356sx.m9613v(str));
                throw e;
            }
        }
        if (this.f443e == null && AbstractC0482Kc.m2372f(this.f441c.mo344a(), Binder.getCallingUid(), str)) {
            this.f443e = str;
        }
        if (str.equals(this.f443e)) {
        } else {
            throw new SecurityException(String.format("Unknown calling package name '%s'.", str));
        }
    }

    public final C0635Nr m811T(C0635Nr c0635Nr, C0569MG c0569mg) {
        C0175Dr c0175Dr;
        if ("_cmp".equals(c0635Nr.name) && (c0175Dr = c0635Nr.params) != null && c0175Dr.m783d() != 0) {
            String strM788o = c0635Nr.params.m788o("_cis");
            if ("referrer broadcast".equals(strM788o) || "referrer API".equals(strM788o)) {
                this.f441c.mo349g().m9621J().m10617b("Event has been filtered ", c0635Nr.toString());
                return new C0635Nr("_cmpx", c0635Nr.params, c0635Nr.origin, c0635Nr.f1977o);
            }
        }
        return c0635Nr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01e3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m812U(Bundle r31, String r32) {
        /*
            Method dump skipped, instructions count: 557
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.BinderC0183Dz.m812U(android.os.Bundle, java.lang.String):void");
    }

    public final void m813V(Runnable runnable) {
        AbstractC1085Xi.m4801j(runnable);
        if (this.f441c.mo354l().m7376J()) {
            runnable.run();
        } else {
            this.f441c.mo354l().m7374C(runnable);
        }
    }

    public final void m814W(C0569MG c0569mg, boolean z) {
        AbstractC1085Xi.m4801j(c0569mg);
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        m810S(c0569mg.f1787l, false);
        this.f441c.m966y0().m10513k0(c0569mg.f1788m, c0569mg.f1771B);
    }

    public final void m815X(C0635Nr c0635Nr, C0569MG c0569mg) {
        boolean zM10610d;
        if (!this.f441c.m955r0().m3233X(c0569mg.f1787l)) {
            m816Y(c0635Nr, c0569mg);
            return;
        }
        this.f441c.mo349g().m9622K().m10617b("EES config found for", c0569mg.f1787l);
        C0596My c0596MyM955r0 = this.f441c.m955r0();
        String str = c0569mg.f1787l;
        C2534wr c2534wr = TextUtils.isEmpty(str) ? null : (C2534wr) c0596MyM955r0.f1873j.m7587c(str);
        if (c2534wr == null) {
            this.f441c.mo349g().m9622K().m10617b("EES not loaded for", c0569mg.f1787l);
        } else {
            try {
                Map mapM8915L = this.f441c.m965x0().m8915L(c0635Nr.params.m785h(), true);
                String strM3491a = AbstractC0701PA.m3491a(c0635Nr.name);
                if (strM3491a == null) {
                    strM3491a = c0635Nr.name;
                }
                zM10610d = c2534wr.m10610d(new Event(strM3491a, c0635Nr.f1977o, mapM8915L));
            } catch (C0222Es unused) {
                this.f441c.mo349g().m9618G().m10618c("EES error. appId, eventName", c0569mg.f1788m, c0635Nr.name);
                zM10610d = false;
            }
            if (zM10610d) {
                if (c2534wr.m10613g()) {
                    this.f441c.mo349g().m9622K().m10617b("EES edited event", c0635Nr.name);
                    c0635Nr = this.f441c.m965x0().m8916M(c2534wr.m10607a().m7476d());
                }
                m816Y(c0635Nr, c0569mg);
                if (c2534wr.m10612f()) {
                    for (Event event : c2534wr.m10607a().m7478f()) {
                        this.f441c.mo349g().m9622K().m10617b("EES logging created event", event.m8006e());
                        m816Y(this.f441c.m965x0().m8916M(event), c0569mg);
                    }
                    return;
                }
                return;
            }
            this.f441c.mo349g().m9622K().m10617b("EES was not applied to event", c0635Nr.name);
        }
        m816Y(c0635Nr, c0569mg);
    }

    public final void m816Y(C0635Nr c0635Nr, C0569MG c0569mg) {
        this.f441c.m968z0();
        this.f441c.m907C(c0635Nr, c0569mg);
    }

    public final void m817Z(C0569MG c0569mg) {
        this.f441c.m968z0();
        this.f441c.m947m0(c0569mg);
    }

    public final void m818a0(C0569MG c0569mg) {
        this.f441c.m968z0();
        this.f441c.m949o0(c0569mg);
    }

    @Override
    public final String mo819h(C0569MG c0569mg) {
        m814W(c0569mg, false);
        return this.f441c.m922U(c0569mg);
    }

    @Override
    public final void mo820i(C0569MG c0569mg) {
        m814W(c0569mg, false);
        m813V(new RunnableC0689Oz(this, c0569mg));
    }

    @Override
    public final void mo821j(C2303rq c2303rq, C0569MG c0569mg) {
        AbstractC1085Xi.m4801j(c2303rq);
        AbstractC1085Xi.m4801j(c2303rq.f6978n);
        m814W(c0569mg, false);
        C2303rq c2303rq2 = new C2303rq(c2303rq);
        c2303rq2.f6976l = c0569mg.f1787l;
        m813V(new RunnableC0781Qz(this, c2303rq2, c0569mg));
    }

    @Override
    public final List mo822k(String str, String str2, C0569MG c0569mg) {
        m814W(c0569mg, false);
        String str3 = c0569mg.f1787l;
        AbstractC1085Xi.m4801j(str3);
        try {
            return (List) this.f441c.mo354l().m7378v(new CallableC1148Yz(this, str3, str, str2)).get();
        } catch (InterruptedException | ExecutionException e) {
            this.f441c.mo349g().m9618G().m10617b("Failed to get conditional user properties", e);
            return Collections.emptyList();
        }
    }

    @Override
    public final void mo823m(final Bundle bundle, C0569MG c0569mg) {
        if (C1028WG.m4483a() && this.f441c.m941i0().m10818t(AbstractC0818Rr.f2516l1)) {
            m814W(c0569mg, false);
            final String str = c0569mg.f1787l;
            AbstractC1085Xi.m4801j(str);
            m813V(new Runnable() {
                @Override
                public final void run() {
                    this.f1110l.m812U(bundle, str);
                }
            });
        }
    }

    @Override
    public final void mo824n(C0569MG c0569mg) {
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        AbstractC1085Xi.m4801j(c0569mg.f1776G);
        m809R(new RunnableC1862iA(this, c0569mg));
    }

    @Override
    public final void mo825p(C0569MG c0569mg) {
        m814W(c0569mg, false);
        m813V(new RunnableC0459Jz(this, c0569mg));
    }

    @Override
    public final byte[] mo826q(C0635Nr c0635Nr, String str) {
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4801j(c0635Nr);
        m810S(str, true);
        this.f441c.mo349g().m9617F().m10617b("Log and bundle. event", this.f441c.m948n0().m9209b(c0635Nr.name));
        long jMo2816b = this.f441c.mo345b().mo2816b() / 1000000;
        try {
            byte[] bArr = (byte[]) this.f441c.mo354l().m7373A(new CallableC2232qA(this, c0635Nr, str)).get();
            if (bArr == null) {
                this.f441c.mo349g().m9618G().m10617b("Log and bundle returned null. appId", C2356sx.m9613v(str));
                bArr = new byte[0];
            }
            this.f441c.mo349g().m9617F().m10619d("Log and bundle processed. event, size, time_ms", this.f441c.m948n0().m9209b(c0635Nr.name), Integer.valueOf(bArr.length), Long.valueOf((this.f441c.mo345b().mo2816b() / 1000000) - jMo2816b));
            return bArr;
        } catch (InterruptedException e) {
            e = e;
            this.f441c.mo349g().m9618G().m10619d("Failed to log and bundle. appId, event, error", C2356sx.m9613v(str), this.f441c.m948n0().m9209b(c0635Nr.name), e);
            return null;
        } catch (ExecutionException e2) {
            e = e2;
            this.f441c.mo349g().m9618G().m10619d("Failed to log and bundle. appId, event, error", C2356sx.m9613v(str), this.f441c.m948n0().m9209b(c0635Nr.name), e);
            return null;
        }
    }

    @Override
    public final void mo827r(C0635Nr c0635Nr, C0569MG c0569mg) {
        AbstractC1085Xi.m4801j(c0635Nr);
        m814W(c0569mg, false);
        m813V(new RunnableC2047mA(this, c0635Nr, c0569mg));
    }

    @Override
    public final C0312Gq mo828t(C0569MG c0569mg) {
        m814W(c0569mg, false);
        AbstractC1085Xi.m4795d(c0569mg.f1787l);
        try {
            return (C0312Gq) this.f441c.mo354l().m7373A(new CallableC1768gA(this, c0569mg)).get(10000L, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            this.f441c.mo349g().m9618G().m10618c("Failed to get consent. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return new C0312Gq(null);
        }
    }

    @Override
    public final void mo829v(final Bundle bundle, C0569MG c0569mg) {
        m814W(c0569mg, false);
        final String str = c0569mg.f1787l;
        AbstractC1085Xi.m4801j(str);
        m813V(new Runnable() {
            @Override
            public final void run() {
                this.f1641l.m808Q(bundle, str);
            }
        });
    }

    @Override
    public final void mo830w(C0569MG c0569mg) {
        m814W(c0569mg, false);
        m813V(new RunnableC0597Mz(this, c0569mg));
    }

    @Override
    public final List mo831x(String str, String str2, boolean z, C0569MG c0569mg) {
        m814W(c0569mg, false);
        String str3 = c0569mg.f1787l;
        AbstractC1085Xi.m4801j(str3);
        try {
            List<C2238qG> list = (List) this.f441c.mo354l().m7378v(new CallableC0964Uz(this, str3, str, str2)).get();
            ArrayList arrayList = new ArrayList<>(list.size());
            for (C2238qG c2238qG : list) {
                if (z || !C2514wG.m10452J0(c2238qG.f6718c)) {
                    arrayList.add(new C2053mG(c2238qG));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.f441c.mo349g().m9618G().m10618c("Failed to query user properties. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.f441c.mo349g().m9618G().m10618c("Failed to query user properties. appId", C2356sx.m9613v(c0569mg.f1787l), e);
            return Collections.emptyList();
        }
    }

    @Override
    public final void mo832y(long j, String str, String str2, String str3) {
        m813V(new RunnableC0872Sz(this, str2, str3, str, j));
    }

    @Override
    public final List mo833z(String str, String str2, String str3, boolean z) {
        m810S(str, true);
        try {
            List<C2238qG> list = (List) this.f441c.mo354l().m7378v(new CallableC1206aA(this, str, str2, str3)).get();
            ArrayList arrayList = new ArrayList<>(list.size());
            for (C2238qG c2238qG : list) {
                if (z || !C2514wG.m10452J0(c2238qG.f6718c)) {
                    arrayList.add(new C2053mG(c2238qG));
                }
            }
            return arrayList;
        } catch (InterruptedException e) {
            e = e;
            this.f441c.mo349g().m9618G().m10618c("Failed to get user properties as. appId", C2356sx.m9613v(str), e);
            return Collections.emptyList();
        } catch (ExecutionException e2) {
            e = e2;
            this.f441c.mo349g().m9618G().m10618c("Failed to get user properties as. appId", C2356sx.m9613v(str), e);
            return Collections.emptyList();
        }
    }

    public BinderC0183Dz(C0200EF c0200ef, String str) {
        AbstractC1085Xi.m4801j(c0200ef);
        this.f441c = c0200ef;
        this.f443e = null;
    }
}
