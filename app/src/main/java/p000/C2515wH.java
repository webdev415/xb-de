package p000;

/* loaded from: classes.dex */
public final class C2515wH implements InterfaceC2100nH {

    public static final AbstractC2001lA f7824a;

    public static final AbstractC2001lA f7825b;

    public static final AbstractC2001lA f7826c;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.client.ad_id_consent_fix", true);
        c0057baM220e.m219d("measurement.service.consent.aiid_reset_fix", false);
        c0057baM220e.m219d("measurement.service.consent.aiid_reset_fix2", true);
        f7824a = c0057baM220e.m219d("measurement.service.consent.app_start_fix", true);
        f7825b = c0057baM220e.m219d("measurement.service.consent.params_on_fx", true);
        f7826c = c0057baM220e.m219d("measurement.service.consent.pfo_on_fx", true);
    }

    @Override
    public final boolean mo8740a() {
        return ((Boolean) f7824a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8741b() {
        return ((Boolean) f7825b.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8742c() {
        return ((Boolean) f7826c.m8368b()).booleanValue();
    }
}
