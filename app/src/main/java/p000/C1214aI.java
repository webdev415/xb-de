package p000;

public final class C1214aI implements InterfaceC1315bI {

    public static final AbstractC2001lA f3526a;

    public static final AbstractC2001lA f3527b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f3526a = c0057baM220e.m219d("measurement.item_scoped_custom_parameters.client", true);
        f3527b = c0057baM220e.m219d("measurement.item_scoped_custom_parameters.service", true);
    }

    @Override
    public final boolean mo5242a() {
        return true;
    }

    @Override
    public final boolean mo5243b() {
        return ((Boolean) f3526a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo5244c() {
        return ((Boolean) f3527b.m8368b()).booleanValue();
    }
}
