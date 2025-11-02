package p000;

/* loaded from: classes.dex */
public final class C1120YG implements InterfaceC0982VG {

    public static final AbstractC2001lA f3331a;

    public static final AbstractC2001lA f3332b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f3331a = c0057baM220e.m219d("measurement.set_default_event_parameters_with_backfill.client.dev", false);
        f3332b = c0057baM220e.m219d("measurement.set_default_event_parameters_with_backfill.service", false);
    }

    @Override
    public final boolean mo4380a() {
        return true;
    }

    @Override
    public final boolean mo4381b() {
        return ((Boolean) f3331a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo4382c() {
        return ((Boolean) f3332b.m8368b()).booleanValue();
    }
}
