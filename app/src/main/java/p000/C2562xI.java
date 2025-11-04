package p000;

public final class C2562xI implements InterfaceC2424uI {

    public static final AbstractC2001lA f7963a;

    public static final AbstractC2001lA f7964b;

    public static final AbstractC2001lA f7965c;

    public static final AbstractC2001lA f7966d;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f7963a = c0057baM220e.m219d("measurement.sgtm.google_signal.enable", false);
        f7964b = c0057baM220e.m219d("measurement.sgtm.preview_mode_enabled", true);
        f7965c = c0057baM220e.m219d("measurement.sgtm.service", true);
        f7966d = c0057baM220e.m219d("measurement.sgtm.upload_queue", false);
        c0057baM220e.m217b("measurement.id.sgtm", 0L);
    }

    @Override
    public final boolean mo10002a() {
        return true;
    }

    @Override
    public final boolean mo10003b() {
        return ((Boolean) f7963a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo10004c() {
        return ((Boolean) f7964b.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo10005d() {
        return ((Boolean) f7965c.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo10006f() {
        return ((Boolean) f7966d.m8368b()).booleanValue();
    }
}
