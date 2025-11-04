package p000;

public final class C2561xH implements InterfaceC2607yH {

    public static final AbstractC2001lA f7960a;

    public static final AbstractC2001lA f7961b;

    public static final AbstractC2001lA f7962c;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.service.audience.fix_skip_audience_with_failed_filters", true);
        f7960a = c0057baM220e.m219d("measurement.audience.refresh_event_count_filters_timestamp", false);
        f7961b = c0057baM220e.m219d("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false);
        f7962c = c0057baM220e.m219d("measurement.audience.use_bundle_timestamp_for_event_count_filters", false);
    }

    @Override
    public final boolean mo10648a() {
        return true;
    }

    @Override
    public final boolean mo10649b() {
        return ((Boolean) f7960a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo10650c() {
        return ((Boolean) f7961b.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo10651d() {
        return ((Boolean) f7962c.m8368b()).booleanValue();
    }
}
