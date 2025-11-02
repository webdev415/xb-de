package p000;

/* loaded from: classes.dex */
public final class C1962kH implements InterfaceC1822hH {

    public static final AbstractC2001lA f6004a;

    public static final AbstractC2001lA f6005b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.dma_consent.client", true);
        c0057baM220e.m219d("measurement.dma_consent.client_bow_check2", true);
        c0057baM220e.m219d("measurement.dma_consent.separate_service_calls_fix", true);
        c0057baM220e.m219d("measurement.dma_consent.service", true);
        f6004a = c0057baM220e.m219d("measurement.dma_consent.service_database_update_fix", true);
        c0057baM220e.m219d("measurement.dma_consent.service_dcu_event", true);
        f6005b = c0057baM220e.m219d("measurement.dma_consent.service_dcu_event2", true);
        c0057baM220e.m219d("measurement.dma_consent.service_npa_remote_default", true);
        c0057baM220e.m219d("measurement.dma_consent.service_split_batch_on_consent", true);
        c0057baM220e.m219d("measurement.dma_consent.set_consent_inline_on_worker", true);
    }

    @Override
    public final boolean mo7821a() {
        return ((Boolean) f6004a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo7822b() {
        return ((Boolean) f6005b.m8368b()).booleanValue();
    }
}
