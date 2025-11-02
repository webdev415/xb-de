package p000;

import android.content.Context;
import java.lang.reflect.InvocationTargetException;
import java.math.BigInteger;
import java.util.List;
import java.util.Locale;
import p000.C0425JA;

/* loaded from: classes.dex */
public final class C1801gx extends AbstractC0501Kv {

    public String f5654c;

    public String f5655d;

    public int f5656e;

    public String f5657f;

    public long f5658g;

    public long f5659h;

    public List f5660i;

    public String f5661j;

    public int f5662k;

    public String f5663l;

    public String f5664m;

    public String f5665n;

    public long f5666o;

    public String f5667p;

    public C1801gx(C2266qz c2266qz, long j) {
        super(c2266qz);
        this.f5666o = 0L;
        this.f5667p = null;
        this.f5659h = j;
    }

    private final String m7765J() throws IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException {
        C2540wx c2540wxM9625N;
        String str;
        if (C2516wI.m10527a() && mo347e().m10818t(AbstractC0818Rr.f2531r0)) {
            c2540wxM9625N = mo349g().m9622K();
            str = "Disabled IID for tests.";
        } else {
            try {
                Class<?> clsLoadClass = mo344a().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (clsLoadClass == null) {
                    return null;
                }
                try {
                    Object objInvoke = clsLoadClass.getDeclaredMethod("getInstance", Context.class).invoke(null, mo344a());
                    if (objInvoke == null) {
                        return null;
                    }
                    try {
                        return (String) clsLoadClass.getDeclaredMethod("getFirebaseInstanceId", null).invoke(objInvoke, null);
                    } catch (Exception unused) {
                        c2540wxM9625N = mo349g().m9624M();
                        str = "Failed to retrieve Firebase Instance Id";
                    }
                } catch (Exception unused2) {
                    c2540wxM9625N = mo349g().m9625N();
                    str = "Failed to obtain Firebase Analytics instance";
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        }
        c2540wxM9625N.m10616a(str);
        return null;
    }

    @Override
    public final boolean mo2545A() {
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01ce  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01ff  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final C0569MG m7766B(String r49) {
        /*
            Method dump skipped, instructions count: 572
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1801gx.m7766B(java.lang.String):MG");
    }

    public final int m7767C() {
        m2546v();
        return this.f5662k;
    }

    public final int m7768D() {
        m2546v();
        return this.f5656e;
    }

    public final String m7769E() {
        m2546v();
        return this.f5664m;
    }

    public final String m7770F() {
        m2546v();
        AbstractC1085Xi.m4801j(this.f5654c);
        return this.f5654c;
    }

    public final String m7771G() {
        mo356n();
        m2546v();
        AbstractC1085Xi.m4801j(this.f5663l);
        return this.f5663l;
    }

    public final List m7772H() {
        return this.f5660i;
    }

    public final void m7773I() {
        String str;
        mo356n();
        if (mo351i().m7667M().m1856m(C0425JA.a.ANALYTICS_STORAGE)) {
            byte[] bArr = new byte[16];
            mo352j().m10505W0().nextBytes(bArr);
            str = String.format(Locale.US, "%032x", new BigInteger(1, bArr));
        } else {
            mo349g().m9617F().m10616a("Analytics Storage consent is not granted");
            str = null;
        }
        mo349g().m9617F().m10616a(String.format("Resetting session stitching token to %s", str == null ? "null" : "not null"));
        this.f5665n = str;
        this.f5666o = mo345b().mo2815a();
    }

    public final boolean m7774K(String str) {
        String str2 = this.f5667p;
        boolean z = (str2 == null || str2.equals(str)) ? false : true;
        this.f5667p = str;
        return z;
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
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

    @Override
    public final /* bridge */ C1801gx mo3784p() {
        return super.mo3784p();
    }

    @Override
    public final /* bridge */ C2079mx mo3785q() {
        return super.mo3785q();
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0123  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0150 A[Catch: IllegalStateException -> 0x0168, TryCatch #3 {IllegalStateException -> 0x0168, blocks: (B:50:0x012b, B:54:0x0148, B:56:0x0150, B:60:0x016c, B:62:0x0180, B:64:0x0185, B:63:0x0183), top: B:90:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x016c A[Catch: IllegalStateException -> 0x0168, TryCatch #3 {IllegalStateException -> 0x0168, blocks: (B:50:0x012b, B:54:0x0148, B:56:0x0150, B:60:0x016c, B:62:0x0180, B:64:0x0185, B:63:0x0183), top: B:90:0x012b }] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e9  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void mo2549y() throws android.content.res.Resources.NotFoundException, android.content.pm.PackageManager.NameNotFoundException {
        /*
            Method dump skipped, instructions count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1801gx.mo2549y():void");
    }
}
