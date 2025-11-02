package p000;

/* loaded from: classes.dex */
public final class C2286rI implements InterfaceC2147oI {

    public static final AbstractC2001lA f6914a;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.collection.enable_session_stitching_token.client.dev", true);
        c0057baM220e.m219d("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        f6914a = c0057baM220e.m219d("measurement.session_stitching_token_enabled", false);
        c0057baM220e.m219d("measurement.link_sst_to_sid", true);
    }

    @Override
    public final boolean mo8930a() {
        return true;
    }

    @Override
    public final boolean mo8931b() {
        return ((Boolean) f6914a.m8368b()).booleanValue();
    }
}
