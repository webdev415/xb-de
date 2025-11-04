package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class C2142oD extends AbstractC0501Kv {

    public final ServiceConnectionC1959kE f6549c;

    public InterfaceC1707ex f6550d;

    public volatile Boolean f6551e;

    public final AbstractC1795gr f6552f;

    public final C2006lF f6553g;

    public final List f6554h;

    public final AbstractC1795gr f6555i;

    public C2142oD(C2266qz c2266qz) {
        super(c2266qz);
        this.f6554h = new ArrayList<>();
        this.f6553g = new C2006lF(c2266qz.mo345b());
        this.f6549c = new ServiceConnectionC1959kE(this);
        this.f6552f = new C2189pD(this, c2266qz);
        this.f6555i = new C0841SD(this, c2266qz);
    }

    private final void m8845D(Runnable runnable) {
        mo356n();
        if (m8881g0()) {
            runnable.run();
        } else {
            if (this.f6554h.size() >= 1000) {
                mo349g().m9618G().m10616a("Discarding data. Max runnable queue size reached");
                return;
            }
            this.f6554h.add(runnable);
            this.f6555i.m7757b(60000L);
            m8874Z();
        }
    }

    public static void m8846R(C2142oD c2142oD, ComponentName componentName) {
        c2142oD.mo356n();
        if (c2142oD.f6550d != null) {
            c2142oD.f6550d = null;
            c2142oD.mo349g().m9622K().m10617b("Disconnected from device MeasurementService", componentName);
            c2142oD.mo356n();
            c2142oD.m8874Z();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m8848l0() {
        mo356n();
        mo349g().m9622K().m10617b("Processing queued up service tasks", Integer.valueOf(this.f6554h.size()));
        Iterator it = this.f6554h.iterator();
        while (it.hasNext()) {
            try {
                ((Runnable) it.next()).run();
            } catch (RuntimeException e) {
                mo349g().m9618G().m10617b("Task exception while flushing queue", e);
            }
        }
        this.f6554h.clear();
        this.f6555i.m7756a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void m8849m0() {
        mo356n();
        this.f6553g.m8381c();
        this.f6552f.m7757b(((Long) AbstractC0818Rr.f2453M.m4296a(null)).longValue());
    }

    public static void m8852s0(C2142oD c2142oD) {
        c2142oD.mo356n();
        if (c2142oD.m8881g0()) {
            c2142oD.mo349g().m9622K().m10616a("Inactivity, disconnecting from the service");
            c2142oD.m8875a0();
        }
    }

    @Override
    public final boolean mo2545A() {
        return false;
    }

    public final void m8854C(Bundle bundle) {
        mo356n();
        m2546v();
        m8845D(new RunnableC0750QD(this, m8888q0(false), bundle));
    }

    public final void m8855E(AtomicReference atomicReference) {
        mo356n();
        m2546v();
        m8845D(new RunnableC2603yD(this, atomicReference, m8888q0(false)));
    }

    public final void m8856F(AtomicReference atomicReference, Bundle bundle) {
        mo356n();
        m2546v();
        m8845D(new RunnableC2511wD(this, atomicReference, m8888q0(false), bundle));
    }

    public final void m8857G(AtomicReference atomicReference, String str, String str2, String str3) {
        mo356n();
        m2546v();
        m8845D(new RunnableC1866iE(this, atomicReference, str, str2, str3, m8888q0(false)));
    }

    public final void m8858H(AtomicReference atomicReference, String str, String str2, String str3, boolean z) {
        mo356n();
        m2546v();
        m8845D(new RunnableC2051mE(this, atomicReference, str, str2, str3, m8888q0(false), z));
    }

    public final void m8859I(C2303rq c2303rq) {
        AbstractC1085Xi.m4801j(c2303rq);
        mo356n();
        m2546v();
        m8845D(new RunnableC1357cE(this, true, m8888q0(true), mo3785q().m8660E(c2303rq), new C2303rq(c2303rq), c2303rq));
    }

    public final void m8860J(C0635Nr c0635Nr, String str) {
        AbstractC1085Xi.m4801j(c0635Nr);
        mo356n();
        m2546v();
        m8845D(new RunnableC1678eE(this, true, m8888q0(true), mo3785q().m8661F(c0635Nr), c0635Nr, str));
    }

    public final void m8861K(InterfaceC2076mu interfaceC2076mu) {
        mo356n();
        m2546v();
        m8845D(new RunnableC0198ED(this, m8888q0(false), interfaceC2076mu));
    }

    public final void m8862L(InterfaceC2076mu interfaceC2076mu, String str, String str2) {
        mo356n();
        m2546v();
        m8845D(new RunnableC1772gE(this, str, str2, m8888q0(false), interfaceC2076mu));
    }

    public final void m8863M(InterfaceC2076mu interfaceC2076mu, String str, String str2, boolean z) {
        mo356n();
        m2546v();
        m8845D(new RunnableC2373tD(this, str, str2, m8888q0(false), z, interfaceC2076mu));
    }

    public final void m8864N(InterfaceC2076mu interfaceC2076mu, C0635Nr c0635Nr, String str) {
        mo356n();
        m2546v();
        if (mo352j().m10519u(12451000) == 0) {
            m8845D(new RunnableC0933UD(this, c0635Nr, str, interfaceC2076mu));
        } else {
            mo349g().m9623L().m10616a("Not bundling data. Service unavailable or out of date");
            mo352j().m10504W(interfaceC2076mu, new byte[0]);
        }
    }

    public final void m8865O(InterfaceC1707ex interfaceC1707ex) {
        mo356n();
        AbstractC1085Xi.m4801j(interfaceC1707ex);
        this.f6550d = interfaceC1707ex;
        m8849m0();
        m8848l0();
    }

    public final void m8866P(InterfaceC1707ex interfaceC1707ex, AbstractC0552M abstractC0552M, C0569MG c0569mg) throws Throwable {
        int size;
        C2540wx c2540wxM9618G;
        String str;
        mo356n();
        m2546v();
        int i = 100;
        int i2 = 0;
        while (i2 < 1001 && i == 100) {
            ArrayList arrayList = new ArrayList<>();
            List listM8658C = mo3785q().m8658C(100);
            if (listM8658C != null) {
                arrayList.addAll(listM8658C);
                size = listM8658C.size();
            } else {
                size = 0;
            }
            if (abstractC0552M != null && size < 100) {
                arrayList.add(abstractC0552M);
            }
            int size2 = arrayList.size();
            int i3 = 0;
            while (i3 < size2) {
                Object obj = arrayList.get(i3);
                i3++;
                AbstractC0552M abstractC0552M2 = (AbstractC0552M) obj;
                if (abstractC0552M2 instanceof C0635Nr) {
                    try {
                        interfaceC1707ex.mo827r((C0635Nr) abstractC0552M2, c0569mg);
                    } catch (RemoteException e) {
                        e = e;
                        c2540wxM9618G = mo349g().m9618G();
                        str = "Failed to send event to the service";
                        c2540wxM9618G.m10617b(str, e);
                    }
                } else if (abstractC0552M2 instanceof C2053mG) {
                    try {
                        interfaceC1707ex.mo806J((C2053mG) abstractC0552M2, c0569mg);
                    } catch (RemoteException e2) {
                        e = e2;
                        c2540wxM9618G = mo349g().m9618G();
                        str = "Failed to send user property to the service";
                        c2540wxM9618G.m10617b(str, e);
                    }
                } else if (abstractC0552M2 instanceof C2303rq) {
                    try {
                        interfaceC1707ex.mo821j((C2303rq) abstractC0552M2, c0569mg);
                    } catch (RemoteException e3) {
                        e = e3;
                        c2540wxM9618G = mo349g().m9618G();
                        str = "Failed to send conditional user property to the service";
                        c2540wxM9618G.m10617b(str, e);
                    }
                } else {
                    mo349g().m9618G().m10616a("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i = size;
        }
    }

    public final void m8867Q(C1162ZC c1162zc) {
        mo356n();
        m2546v();
        m8845D(new RunnableC0566MD(this, c1162zc));
    }

    public final void m8868T(C2053mG c2053mG) {
        mo356n();
        m2546v();
        m8845D(new RunnableC2419uD(this, m8888q0(true), mo3785q().m8662G(c2053mG), c2053mG));
    }

    public final void m8869U(boolean z) {
        mo356n();
        m2546v();
        if ((!C0798RG.m3790a() || !mo347e().m10818t(AbstractC0818Rr.f2489c1)) && z) {
            mo3785q().m8663H();
        }
        if (m8883i0()) {
            m8845D(new RunnableC1117YD(this, m8888q0(false)));
        }
    }

    public final C0312Gq m8870V() {
        mo356n();
        m2546v();
        InterfaceC1707ex interfaceC1707ex = this.f6550d;
        if (interfaceC1707ex == null) {
            m8874Z();
            mo349g().m9617F().m10616a("Failed to get consents; not connected to service yet.");
            return null;
        }
        C0569MG c0569mgM8888q0 = m8888q0(false);
        AbstractC1085Xi.m4801j(c0569mgM8888q0);
        try {
            C0312Gq c0312GqMo828t = interfaceC1707ex.mo828t(c0569mgM8888q0);
            m8849m0();
            return c0312GqMo828t;
        } catch (RemoteException e) {
            mo349g().m9618G().m10617b("Failed to get consents; remote exception", e);
            return null;
        }
    }

    public final Boolean m8871W() {
        return this.f6551e;
    }

    public final void m8872X() {
        mo356n();
        m2546v();
        m8845D(new RunnableC0658OD(this, m8888q0(true)));
    }

    public final void m8873Y() {
        mo356n();
        m2546v();
        C0569MG c0569mgM8888q0 = m8888q0(true);
        mo3785q().m8664I();
        m8845D(new RunnableC0106CD(this, c0569mgM8888q0));
    }

    public final void m8874Z() {
        mo356n();
        m2546v();
        if (m8881g0()) {
            return;
        }
        if (m8885k0()) {
            this.f6549c.m8243d();
            return;
        }
        if (mo347e().m10819u()) {
            return;
        }
        List<ResolveInfo> listQueryIntentServices = mo344a().getPackageManager().queryIntentServices(new Intent().setClassName(mo344a(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
        if (listQueryIntentServices == null || listQueryIntentServices.isEmpty()) {
            mo349g().m9618G().m10616a("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            return;
        }
        Intent intent = new Intent("com.google.android.gms.measurement.START");
        intent.setComponent(new ComponentName(mo344a(), "com.google.android.gms.measurement.AppMeasurementService"));
        this.f6549c.m8244e(intent);
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    public final void m8875a0() {
        mo356n();
        m2546v();
        this.f6549c.m8245g();
        try {
            C1997l6.m8350b().m8355c(mo344a(), this.f6549c);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.f6550d = null;
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    public final void m8876b0() {
        InterfaceC1707ex interfaceC1707ex = this.f6550d;
        if (interfaceC1707ex == null) {
            mo349g().m9618G().m10616a("Failed to send Dma consent settings to service");
            return;
        }
        try {
            C0569MG c0569mgM8888q0 = m8888q0(false);
            AbstractC1085Xi.m4801j(c0569mgM8888q0);
            interfaceC1707ex.mo803G(c0569mgM8888q0);
            m8849m0();
        } catch (RemoteException e) {
            mo349g().m9618G().m10617b("Failed to send Dma consent settings to the service", e);
        }
    }

    public final void m8877c0() {
        InterfaceC1707ex interfaceC1707ex = this.f6550d;
        if (interfaceC1707ex == null) {
            mo349g().m9618G().m10616a("Failed to send storage consent settings to service");
            return;
        }
        try {
            C0569MG c0569mgM8888q0 = m8888q0(false);
            AbstractC1085Xi.m4801j(c0569mgM8888q0);
            interfaceC1707ex.mo805I(c0569mgM8888q0);
            m8849m0();
        } catch (RemoteException e) {
            mo349g().m9618G().m10617b("Failed to send storage consent settings to the service", e);
        }
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    public final void m8878d0() {
        mo356n();
        m2546v();
        C0569MG c0569mgM8888q0 = m8888q0(false);
        mo3785q().m8663H();
        m8845D(new RunnableC0014AD(this, c0569mgM8888q0));
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    public final void m8879e0() {
        mo356n();
        m2546v();
        m8845D(new Runnable() {
            @Override
            public final void run() {
                this.f6910l.m8876b0();
            }
        });
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    public final void m8880f0() {
        mo356n();
        m2546v();
        m8845D(new RunnableC1210aE(this, m8888q0(true)));
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    public final boolean m8881g0() {
        mo356n();
        m2546v();
        return this.f6550d != null;
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    public final boolean m8882h0() {
        mo356n();
        m2546v();
        return !m8885k0() || mo352j().m10484I0() >= 200900;
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    public final boolean m8883i0() {
        mo356n();
        m2546v();
        return !m8885k0() || mo352j().m10484I0() >= ((Integer) AbstractC0818Rr.f2535t0.m4296a(null)).intValue();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    public final boolean m8884j0() {
        mo356n();
        m2546v();
        return !m8885k0() || mo352j().m10484I0() >= 241200;
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m8885k0() {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2142oD.m8885k0():boolean");
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final /* bridge */ C1092Xp mo3783o() {
        return super.mo3783o();
    }

    public final void m8886o0(Bundle bundle) {
        mo356n();
        m2546v();
        if (mo347e().m10818t(AbstractC0818Rr.f2519m1)) {
            m8845D(new RunnableC1025WD(this, m8888q0(false), bundle));
        }
    }

    @Override
    public final /* bridge */ C1801gx mo3784p() {
        return super.mo3784p();
    }

    public final void m8887p0(boolean z) {
        mo356n();
        m2546v();
        if ((!C0798RG.m3790a() || !mo347e().m10818t(AbstractC0818Rr.f2489c1)) && z) {
            mo3785q().m8663H();
        }
        m8845D(new Runnable() {
            @Override
            public final void run() {
                this.f6305l.m8877c0();
            }
        });
    }

    @Override
    public final /* bridge */ C2079mx mo3785q() {
        return super.mo3785q();
    }

    public final C0569MG m8888q0(boolean z) {
        return mo3784p().m7766B(z ? mo349g().m9626O() : null);
    }

    @Override
    public final /* bridge */ C1207aB mo3786r() {
        return super.mo3786r();
    }

    @Override
    public final /* bridge */ C1070XC mo3787s() {
        return super.mo3787s();
    }

    @Override
    public final /* bridge */ C2142oD mo3788t() {
        return super.mo3788t();
    }

    @Override
    public final /* bridge */ C0796RE mo3789u() {
        return super.mo3789u();
    }
}
