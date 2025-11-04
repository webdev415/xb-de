package p000;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class C0978VC extends AbstractC2513wF {
    public C0978VC(C0200EF c0200ef) {
        super(c0200ef);
    }

    private static String m4365c(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final byte[] m4366y(C0635Nr c0635Nr, String str) {
        C2238qG c2238qG;
        Bundle bundle;
        C0595Mx.a aVar;
        C0549Lx.a aVar2;
        C2403ty c2403ty;
        byte[] bArr;
        long j;
        C0267Fr c0267FrM1291a;
        mo356n();
        this.f8058a.m9235Q();
        AbstractC1085Xi.m4801j(c0635Nr);
        AbstractC1085Xi.m4795d(str);
        if (!mo347e().m10798H(str, AbstractC0818Rr.f2515l0)) {
            mo349g().m9617F().m10617b("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(c0635Nr.name) && !"_iapx".equals(c0635Nr.name)) {
            mo349g().m9617F().m10618c("Generating a payload for this event is not available. package_name, event_name", str, c0635Nr.name);
            return null;
        }
        C0549Lx.a aVarM2772L = C0549Lx.m2772L();
        mo3246q().m2517b1();
        try {
            C2403ty c2403tyM2488L0 = mo3246q().m2488L0(str);
            if (c2403tyM2488L0 == null) {
                mo349g().m9617F().m10617b("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!c2403tyM2488L0.m9787A()) {
                mo349g().m9617F().m10617b("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            C0595Mx.a aVarM3155S0 = C0595Mx.m3030u2().m3196t0(1).m3155S0("android");
            if (!TextUtils.isEmpty(c2403tyM2488L0.m9848l())) {
                aVarM3155S0.m3152R(c2403tyM2488L0.m9848l());
            }
            if (!TextUtils.isEmpty(c2403tyM2488L0.m9852n())) {
                aVarM3155S0.m3176d0((String) AbstractC1085Xi.m4801j(c2403tyM2488L0.m9852n()));
            }
            if (!TextUtils.isEmpty(c2403tyM2488L0.m9854o())) {
                aVarM3155S0.m3185j0((String) AbstractC1085Xi.m4801j(c2403tyM2488L0.m9854o()));
            }
            if (c2403tyM2488L0.m9820U() != -2147483648L) {
                aVarM3155S0.m3182g0((int) c2403tyM2488L0.m9820U());
            }
            aVarM3155S0.m3188m0(c2403tyM2488L0.m9877z0()).m3172b0(c2403tyM2488L0.m9869v0());
            String strM9858q = c2403tyM2488L0.m9858q();
            String strM9844j = c2403tyM2488L0.m9844j();
            if (!TextUtils.isEmpty(strM9858q)) {
                aVarM3155S0.m3143M0(strM9858q);
            } else if (!TextUtils.isEmpty(strM9844j)) {
                aVarM3155S0.m3118A(strM9844j);
            }
            aVarM3155S0.m3123C0(c2403tyM2488L0.m9806J0());
            C0425JA c0425jaM923V = this.f6912b.m923V(str);
            aVarM3155S0.m3160V(c2403tyM2488L0.m9865t0());
            if (this.f8058a.m9242p() && mo347e().m10805P(aVarM3155S0.m3169Z0()) && c0425jaM923V.m1851A() && !TextUtils.isEmpty(null)) {
                aVarM3155S0.m3125D0(null);
            }
            aVarM3155S0.m3193r0(c0425jaM923V.m1866y());
            if (c0425jaM923V.m1851A() && c2403tyM2488L0.m9876z()) {
                Pair pairM9998z = mo3248s().m9998z(c2403tyM2488L0.m9848l(), c0425jaM923V);
                if (c2403tyM2488L0.m9876z() && pairM9998z != null && !TextUtils.isEmpty((CharSequence) pairM9998z.first)) {
                    aVarM3155S0.m3159U0(m4365c((String) pairM9998z.first, Long.toString(c0635Nr.f1977o)));
                    Object obj = pairM9998z.second;
                    if (obj != null) {
                        aVarM3155S0.m3166Y(((Boolean) obj).booleanValue());
                    }
                }
            }
            mo348f().m10436p();
            C0595Mx.a aVarM3208z0 = aVarM3155S0.m3208z0(Build.MODEL);
            mo348f().m10436p();
            aVarM3208z0.m3151Q0(Build.VERSION.RELEASE).m3121B0((int) mo348f().m359v()).m3167Y0(mo348f().m360w());
            if (c0425jaM923V.m1852B() && c2403tyM2488L0.m9850m() != null) {
                aVarM3155S0.m3164X(m4365c((String) AbstractC1085Xi.m4801j(c2403tyM2488L0.m9850m()), Long.toString(c0635Nr.f1977o)));
            }
            if (!TextUtils.isEmpty(c2403tyM2488L0.m9856p())) {
                aVarM3155S0.m3139K0((String) AbstractC1085Xi.m4801j(c2403tyM2488L0.m9856p()));
            }
            String strM9848l = c2403tyM2488L0.m9848l();
            List listM2509X0 = mo3246q().m2509X0(strM9848l);
            Iterator it = listM2509X0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    c2238qG = null;
                    break;
                }
                c2238qG = (C2238qG) it.next();
                if ("_lte".equals(c2238qG.f6718c)) {
                    break;
                }
            }
            if (c2238qG == null || c2238qG.f6720e == null) {
                C2238qG c2238qG2 = new C2238qG(strM9848l, "auto", "_lte", mo345b().mo2815a(), 0L);
                listM2509X0.add(c2238qG2);
                mo3246q().m2539n0(c2238qG2);
            }
            C0779Qx[] c0779QxArr = new C0779Qx[listM2509X0.size()];
            for (int i = 0; i < listM2509X0.size(); i++) {
                C0779Qx.a aVarM3744y = C0779Qx.m3725S().m3742w(((C2238qG) listM2509X0.get(i)).f6718c).m3744y(((C2238qG) listM2509X0.get(i)).f6719d);
                mo3244o().m8923c0(aVarM3744y, ((C2238qG) listM2509X0.get(i)).f6720e);
                c0779QxArr[i] = (C0779Qx) ((AbstractC0703PC) aVarM3744y.m3526o());
            }
            aVarM3155S0.m3184i0(Arrays.asList(c0779QxArr));
            mo3244o().m8922b0(aVarM3155S0);
            this.f6912b.m913G(c2403tyM2488L0, aVarM3155S0);
            if (C0340HH.m1558a() && mo347e().m10818t(AbstractC0818Rr.f2470U0)) {
                this.f6912b.m929b0(c2403tyM2488L0, aVarM3155S0);
            }
            C0043Ax c0043AxM169b = C0043Ax.m169b(c0635Nr);
            mo352j().m10490N(c0043AxM169b.params, mo3246q().m2484J0(str));
            mo352j().m10506X(c0043AxM169b, mo347e().m10822x(str));
            Bundle bundle2 = c0043AxM169b.params;
            bundle2.putLong("_c", 1L);
            mo349g().m9617F().m10616a("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", c0635Nr.origin);
            if (mo352j().m10480E0(aVarM3155S0.m3169Z0(), c2403tyM2488L0.m9868v())) {
                mo352j().m10491O(bundle2, "_dbg", 1L);
                mo352j().m10491O(bundle2, "_r", 1L);
            }
            C0267Fr c0267FrM2486K0 = mo3246q().m2486K0(str, c0635Nr.name);
            if (c0267FrM2486K0 == null) {
                bundle = bundle2;
                aVar = aVarM3155S0;
                aVar2 = aVarM2772L;
                c2403ty = c2403tyM2488L0;
                bArr = null;
                c0267FrM1291a = new C0267Fr(str, c0635Nr.name, 0L, 0L, c0635Nr.f1977o, 0L, null, null, null, null);
                j = 0;
            } else {
                bundle = bundle2;
                aVar = aVarM3155S0;
                aVar2 = aVarM2772L;
                c2403ty = c2403tyM2488L0;
                bArr = null;
                j = c0267FrM2486K0.f688f;
                c0267FrM1291a = c0267FrM2486K0.m1291a(c0635Nr.f1977o);
            }
            mo3246q().m2516b0(c0267FrM1291a);
            Event_ event = new Event_(this.f8058a, c0635Nr.origin, str, c0635Nr.name, c0635Nr.f1977o, j, bundle);
            C0365Hx.a aVarM1658x = C0365Hx.m1631S().m1647D(event.f8284d).m1660z(event.name).m1658x(event.f8285e);
            Iterator it2 = event.params.iterator();
            while (it2.hasNext()) {
                String str2 = (String) it2.next();
                C0457Jx.a aVarM2210x = C0457Jx.m2185U().m2210x(str2);
                Object objM787k = event.params.m787k(str2);
                if (objM787k != null) {
                    mo3244o().m8921a0(aVarM2210x, objM787k);
                    aVarM1658x.m1644A(aVarM2210x);
                }
            }
            C0595Mx.a aVar3 = aVar;
            aVar3.m3124D(aVarM1658x).m3126E(C0641Nx.m3344G().m3347t(C0411Ix.m1747G().m1751t(c0267FrM1291a.f685c).m1752u(c0635Nr.name)));
            aVar3.m3207z(mo3245p().m4032y(c2403ty.m9848l(), Collections.emptyList(), aVar3.m3136J(), Long.valueOf(aVarM1658x.m1649F()), Long.valueOf(aVarM1658x.m1649F())));
            if (aVarM1658x.m1653J()) {
                aVar3.m3206y0(aVarM1658x.m1649F()).m3183h0(aVarM1658x.m1649F());
            }
            long jM9794D0 = c2403ty.m9794D0();
            if (jM9794D0 != 0) {
                aVar3.m3192q0(jM9794D0);
            }
            long jM9802H0 = c2403ty.m9802H0();
            if (jM9802H0 != 0) {
                aVar3.m3198u0(jM9802H0);
            } else if (jM9794D0 != 0) {
                aVar3.m3198u0(jM9794D0);
            }
            String strM9866u = c2403ty.m9866u();
            if (C2194pI.m9056a() && mo347e().m10798H(str, AbstractC0818Rr.f2541w0) && strM9866u != null) {
                aVar3.m3163W0(strM9866u);
            }
            c2403ty.m9874y();
            aVar3.m3187l0((int) c2403ty.m9798F0()).m3137J0(102001L).m3129F0(mo345b().mo2815a()).m3178e0(true);
            this.f6912b.m957t(aVar3.m3169Z0(), aVar3);
            C0549Lx.a aVar4 = aVar2;
            aVar4.m2789w(aVar3);
            C2403ty c2403ty2 = c2403ty;
            c2403ty2.m9792C0(aVar3.m3186k0());
            c2403ty2.m9875y0(aVar3.m3180f0());
            mo3246q().m2518c0(c2403ty2, false, false);
            mo3246q().m2531i1();
            try {
                return mo3244o().m8925i0(((C0549Lx) ((AbstractC0703PC) aVar4.m3526o())).m4464i());
            } catch (IOException e) {
                mo349g().m9618G().m10618c("Data loss. Failed to bundle and serialize. appId", C2356sx.m9613v(str), e);
                return bArr;
            }
        } catch (SecurityException e2) {
            mo349g().m9617F().m10617b("Resettable device id encryption failed", e2.getMessage());
            return new byte[0];
        } catch (SecurityException e3) {
            mo349g().m9617F().m10617b("app instance id encryption failed", e3.getMessage());
            return new byte[0];
        } finally {
            mo3246q().m2527g1();
        }
    }
}
