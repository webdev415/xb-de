package p000;

public final class C0844SG implements InterfaceC0707PG {

    public static final AbstractC2001lA f2614a;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.client.consent_state_v1", true);
        c0057baM220e.m219d("measurement.client.3p_consent_state_v1", true);
        c0057baM220e.m219d("measurement.service.consent_state_v1_W36", true);
        f2614a = c0057baM220e.m217b("measurement.service.storage_consent_support_version", 203600L);
    }

    @Override
    public final long mo3540a() {
        return ((Long) f2614a.m8368b()).longValue();
    }
}
