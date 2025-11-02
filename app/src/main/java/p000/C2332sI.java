package p000;

public final class C2332sI implements InterfaceC2378tI {

    public static final AbstractC2001lA f7030a;

    public static final AbstractC2001lA f7031b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.client.sessions.background_sessions_enabled", true);
        f7030a = c0057baM220e.m219d("measurement.client.sessions.enable_fix_background_engagement", false);
        c0057baM220e.m219d("measurement.client.sessions.immediate_start_enabled_foreground", true);
        f7031b = c0057baM220e.m219d("measurement.client.sessions.enable_pause_engagement_in_background", true);
        c0057baM220e.m219d("measurement.client.sessions.remove_expired_session_properties_enabled", true);
        c0057baM220e.m219d("measurement.client.sessions.session_id_enabled", true);
        c0057baM220e.m217b("measurement.id.client.sessions.enable_fix_background_engagement", 0L);
    }

    @Override
    public final boolean mo9528a() {
        return ((Boolean) f7030a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo9529b() {
        return ((Boolean) f7031b.m8368b()).booleanValue();
    }
}
