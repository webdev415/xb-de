package p000;

/* loaded from: classes.dex */
public final class C0339HG implements InterfaceC0661OG {

    public static final AbstractC2001lA f1044a;

    public static final AbstractC2001lA f1045b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f1044a = c0057baM220e.m219d("measurement.consent_regional_defaults.client2", true);
        f1045b = c0057baM220e.m219d("measurement.consent_regional_defaults.service", true);
    }

    @Override
    public final boolean mo1555a() {
        return true;
    }

    @Override
    public final boolean mo1556b() {
        return ((Boolean) f1044a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo1557c() {
        return ((Boolean) f1045b.m8368b()).booleanValue();
    }
}
