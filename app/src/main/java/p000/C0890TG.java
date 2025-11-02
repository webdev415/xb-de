package p000;

/* loaded from: classes.dex */
public final class C0890TG implements InterfaceC0936UG {

    public static final AbstractC2001lA f2739a;

    public static final AbstractC2001lA f2740b;

    public static final AbstractC2001lA f2741c;

    public static final AbstractC2001lA f2742d;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f2739a = c0057baM220e.m219d("measurement.consent.stop_reset_on_storage_denied.client", true);
        f2740b = c0057baM220e.m219d("measurement.consent.stop_reset_on_storage_denied.service", true);
        f2741c = c0057baM220e.m219d("measurement.consent.scrub_audience_data_analytics_consent", true);
        f2742d = c0057baM220e.m219d("measurement.consent.fix_first_open_count_from_snapshot", true);
    }

    @Override
    public final boolean mo4124a() {
        return true;
    }

    @Override
    public final boolean mo4125b() {
        return ((Boolean) f2739a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo4126c() {
        return ((Boolean) f2740b.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo4127d() {
        return ((Boolean) f2741c.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo4128f() {
        return ((Boolean) f2742d.m8368b()).booleanValue();
    }
}
