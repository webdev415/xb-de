package p000;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import java.io.IOException;
import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class C0083Br extends AbstractC2508wA {

    public long f211c;

    public String f212d;

    public AccountManager f213e;

    public Boolean f214f;

    public long f215g;

    public C0083Br(C2266qz c2266qz) {
        super(c2266qz);
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
    public final boolean mo357t() {
        Calendar calendar = Calendar.getInstance();
        this.f211c = TimeUnit.MINUTES.convert(calendar.get(15) + calendar.get(16), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        this.f212d = language.toLowerCase(locale2) + "-" + locale.getCountry().toLowerCase(locale2);
        return false;
    }

    public final long m358u() {
        mo356n();
        return this.f215g;
    }

    public final long m359v() {
        m10436p();
        return this.f211c;
    }

    public final String m360w() {
        m10436p();
        return this.f212d;
    }

    public final void m361x() {
        mo356n();
        this.f214f = null;
        this.f215g = 0L;
    }

    public final boolean m362y() throws OperationCanceledException, IOException, AuthenticatorException {
        mo356n();
        long jMo2815a = mo345b().mo2815a();
        if (jMo2815a - this.f215g > 86400000) {
            this.f214f = null;
        }
        Boolean bool = this.f214f;
        if (bool != null) {
            return bool.booleanValue();
        }
        if (AbstractC2320s6.m9505a(mo344a(), "android.permission.GET_ACCOUNTS") != 0) {
            mo349g().m9625N().m10616a("Permission error checking for dasher/unicorn accounts");
        } else {
            if (this.f213e == null) {
                this.f213e = AccountManager.get(mo344a());
            }
            try {
                Account[] result = this.f213e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_HOSTED"}, null, null).getResult();
                if (result != null && result.length > 0) {
                    this.f214f = Boolean.TRUE;
                    this.f215g = jMo2815a;
                    return true;
                }
                Account[] result2 = this.f213e.getAccountsByTypeAndFeatures("com.google", new String[]{"service_uca"}, null, null).getResult();
                if (result2 != null && result2.length > 0) {
                    this.f214f = Boolean.TRUE;
                    this.f215g = jMo2815a;
                    return true;
                }
            } catch (AuthenticatorException e) {
                e = e;
                mo349g().m9620I().m10617b("Exception checking account types", e);
                this.f215g = jMo2815a;
                this.f214f = Boolean.FALSE;
                return false;
            } catch (OperationCanceledException e2) {
                e = e2;
                mo349g().m9620I().m10617b("Exception checking account types", e);
                this.f215g = jMo2815a;
                this.f214f = Boolean.FALSE;
                return false;
            } catch (IOException e3) {
                e = e3;
                mo349g().m9620I().m10617b("Exception checking account types", e);
                this.f215g = jMo2815a;
                this.f214f = Boolean.FALSE;
                return false;
            }
        }
        this.f215g = jMo2815a;
        this.f214f = Boolean.FALSE;
        return false;
    }
}
