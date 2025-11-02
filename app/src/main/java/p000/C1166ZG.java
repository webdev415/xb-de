package p000;

/* loaded from: classes.dex */
public final class C1166ZG implements InterfaceC1213aH {

    public static final AbstractC2001lA f3431a;

    public static final AbstractC2001lA f3432b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f3431a = c0057baM220e.m219d("measurement.set_default_event_parameters_propagate_clear.client.dev", false);
        f3432b = c0057baM220e.m219d("measurement.set_default_event_parameters_propagate_clear.service", false);
    }

    @Override
    public final boolean mo5033a() {
        return ((Boolean) f3431a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo5034b() {
        return ((Boolean) f3432b.m8368b()).booleanValue();
    }
}
