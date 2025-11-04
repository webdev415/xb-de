package p000;

public final class C0432JH implements InterfaceC0478KH {

    public static final AbstractC2001lA f1320a;

    public static final AbstractC2001lA f1321b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f1320a = c0057baM220e.m219d("measurement.gbraid_campaign.gbraid.client", false);
        f1321b = c0057baM220e.m219d("measurement.gbraid_campaign.gbraid.service", false);
        c0057baM220e.m217b("measurement.id.gbraid_campaign.service", 0L);
    }

    @Override
    public final boolean mo1896a() {
        return true;
    }

    @Override
    public final boolean mo1897b() {
        return ((Boolean) f1320a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo1898c() {
        return ((Boolean) f1321b.m8368b()).booleanValue();
    }
}
