package p000;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.PersistableBundle;

public final class C2098nF extends AbstractC2513wF {

    public final AlarmManager f6306d;

    public AbstractC1795gr f6307e;

    public Integer f6308f;

    public C2098nF(C0200EF c0200ef) {
        super(c0200ef);
        this.f6306d = (AlarmManager) mo344a().getSystemService("alarm");
    }

    private final void m8734D() {
        JobScheduler jobScheduler = (JobScheduler) mo344a().getSystemService("jobscheduler");
        if (jobScheduler != null) {
            jobScheduler.cancel(m8735A());
        }
    }

    public final int m8735A() {
        if (this.f6308f == null) {
            this.f6308f = Integer.valueOf(("measurement" + mo344a().getPackageName()).hashCode());
        }
        return this.f6308f.intValue();
    }

    public final PendingIntent m8736B() {
        Context contextMo344a = mo344a();
        return AbstractC2536wt.m10615a(contextMo344a, 0, new Intent().setClassName(contextMo344a, "com.google.android.gms.measurement.AppMeasurementReceiver").setAction("com.google.android.gms.measurement.UPLOAD"), AbstractC2536wt.f7911a);
    }

    public final AbstractC1795gr m8737C() {
        if (this.f6307e == null) {
            this.f6307e = new C2375tF(this, this.f6912b.m958t0());
        }
        return this.f6307e;
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
    public final /* bridge */ C2145oG mo3244o() {
        return super.mo3244o();
    }

    @Override
    public final /* bridge */ C0846SI mo3245p() {
        return super.mo3245p();
    }

    @Override
    public final /* bridge */ C0496Kq mo3246q() {
        return super.mo3246q();
    }

    @Override
    public final /* bridge */ C0596My mo3247r() {
        return super.mo3247r();
    }

    @Override
    public final /* bridge */ C2420uE mo3248s() {
        return super.mo3248s();
    }

    @Override
    public final /* bridge */ C2467vF mo3249t() {
        return super.mo3249t();
    }

    @Override
    public final boolean mo2541x() {
        AlarmManager alarmManager = this.f6306d;
        if (alarmManager != null) {
            alarmManager.cancel(m8736B());
        }
        m8734D();
        return false;
    }

    public final void m8738y(long j) {
        m10440u();
        Context contextMo344a = mo344a();
        if (!C2514wG.m10463d0(contextMo344a)) {
            mo349g().m9617F().m10616a("Receiver not registered/enabled");
        }
        if (!C2514wG.m10464e0(contextMo344a, false)) {
            mo349g().m9617F().m10616a("Service not registered/enabled");
        }
        m8739z();
        mo349g().m9622K().m10617b("Scheduling upload, millis", Long.valueOf(j));
        mo345b().mo2817c();
        if (j < Math.max(0L, ((Long) AbstractC0818Rr.f2546z.m4296a(null)).longValue()) && !m8737C().m7758e()) {
            m8737C().m7757b(j);
        }
        Context contextMo344a2 = mo344a();
        ComponentName componentName = new ComponentName(contextMo344a2, "com.google.android.gms.measurement.AppMeasurementJobService");
        int iM8735A = m8735A();
        PersistableBundle persistableBundle = new PersistableBundle();
        persistableBundle.putString("action", "com.google.android.gms.measurement.UPLOAD");
        C0131Ct.m531c(contextMo344a2, new JobInfo.Builder(iM8735A, componentName).setMinimumLatency(j).setOverrideDeadline(j << 1).setExtras(persistableBundle).build(), "com.google.android.gms", "UploadAlarm");
    }

    public final void m8739z() {
        m10440u();
        mo349g().m9622K().m10616a("Unscheduling upload");
        AlarmManager alarmManager = this.f6306d;
        if (alarmManager != null) {
            alarmManager.cancel(m8736B());
        }
        m8737C().m7756a();
        m8734D();
    }
}
