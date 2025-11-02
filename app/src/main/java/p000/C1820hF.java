package p000;

import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class C1820hF {

    public final C0796RE f5727a;

    public C1820hF(C0796RE c0796re) {
        this.f5727a = c0796re;
    }

    public final void m7818a() {
        this.f5727a.mo356n();
        if (this.f5727a.mo351i().m7681z(this.f5727a.mo345b().mo2815a())) {
            this.f5727a.mo351i().f5563n.m8427a(true);
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(runningAppProcessInfo);
            if (runningAppProcessInfo.importance == 100) {
                this.f5727a.mo349g().m9622K().m10616a("Detected application was in foreground");
                m7820c(this.f5727a.mo345b().mo2815a(), false);
            }
        }
    }

    public final void m7819b(long j, boolean z) {
        this.f5727a.mo356n();
        this.f5727a.m3782G();
        if (this.f5727a.mo351i().m7681z(j)) {
            this.f5727a.mo351i().f5563n.m8427a(true);
            this.f5727a.mo3784p().m7773I();
        }
        this.f5727a.mo351i().f5567r.m9086b(j);
        if (this.f5727a.mo351i().f5563n.m8428b()) {
            m7820c(j, z);
        }
    }

    public final void m7820c(long j, boolean z) {
        this.f5727a.mo356n();
        if (this.f5727a.f8058a.m9242p()) {
            this.f5727a.mo351i().f5567r.m9086b(j);
            this.f5727a.mo349g().m9622K().m10617b("Session started, time", Long.valueOf(this.f5727a.mo345b().mo2817c()));
            long j2 = j / 1000;
            this.f5727a.mo3786r().m5161Y("auto", "_sid", Long.valueOf(j2), j);
            this.f5727a.mo351i().f5568s.m9086b(j2);
            this.f5727a.mo351i().f5563n.m8427a(false);
            Bundle bundle = new Bundle();
            bundle.putLong("_sid", j2);
            this.f5727a.mo3786r().m5151S("auto", "_s", j, bundle);
            String strM10620a = this.f5727a.mo351i().f5573x.m10620a();
            if (TextUtils.isEmpty(strM10620a)) {
                return;
            }
            Bundle bundle2 = new Bundle();
            bundle2.putString("_ffr", strM10620a);
            this.f5727a.mo3786r().m5151S("auto", "_ssr", j, bundle2);
        }
    }
}
