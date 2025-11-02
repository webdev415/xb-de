package p000;

public final class C2055mI implements InterfaceC2101nI {

    public static final AbstractC2001lA f6164a;

    public static final AbstractC2001lA f6165b;

    public static final AbstractC2001lA f6166c;

    public static final AbstractC2001lA f6167d;

    public static final AbstractC2001lA f6168e;

    public static final AbstractC2001lA f6169f;

    public static final AbstractC2001lA f6170g;

    public static final AbstractC2001lA f6171h;

    public static final AbstractC2001lA f6172i;

    public static final AbstractC2001lA f6173j;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m217b("measurement.id.rb.attribution.bundle_on_backgrounded", 0L);
        f6164a = c0057baM220e.m219d("measurement.rb.attribution.ad_campaign_info", false);
        f6165b = c0057baM220e.m219d("measurement.rb.attribution.client.bundle_on_backgrounded", false);
        f6166c = c0057baM220e.m219d("measurement.rb.attribution.service.bundle_on_backgrounded", false);
        f6167d = c0057baM220e.m219d("measurement.rb.attribution.client2", true);
        c0057baM220e.m219d("measurement.rb.attribution.dma_fix", true);
        f6168e = c0057baM220e.m219d("measurement.rb.attribution.followup1.service", false);
        c0057baM220e.m219d("measurement.rb.attribution.index_out_of_bounds_fix", true);
        f6169f = c0057baM220e.m219d("measurement.rb.attribution.retry_disposition", false);
        f6170g = c0057baM220e.m219d("measurement.rb.attribution.service", true);
        f6171h = c0057baM220e.m219d("measurement.rb.attribution.enable_trigger_redaction", true);
        f6172i = c0057baM220e.m219d("measurement.rb.attribution.uuid_generation", true);
        c0057baM220e.m217b("measurement.id.rb.attribution.retry_disposition", 0L);
        f6173j = c0057baM220e.m219d("measurement.rb.attribution.improved_retry", true);
    }

    @Override
    public final boolean mo8449a() {
        return true;
    }

    @Override
    public final boolean mo8450b() {
        return ((Boolean) f6164a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8451c() {
        return ((Boolean) f6165b.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8452d() {
        return ((Boolean) f6166c.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8453e() {
        return ((Boolean) f6171h.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8454f() {
        return ((Boolean) f6167d.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8455g() {
        return ((Boolean) f6172i.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8456h() {
        return ((Boolean) f6168e.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8457i() {
        return ((Boolean) f6170g.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8458j() {
        return ((Boolean) f6169f.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8459m() {
        return ((Boolean) f6173j.m8368b()).booleanValue();
    }
}
