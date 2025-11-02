package p000;

public final class C2008lH implements InterfaceC2054mH {

    public static final AbstractC2001lA f6084a;

    public static final AbstractC2001lA f6085b;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.collection.event_safelist", true);
        f6084a = c0057baM220e.m219d("measurement.service.store_null_safelist", true);
        f6085b = c0057baM220e.m219d("measurement.service.store_safelist", true);
    }

    @Override
    public final boolean mo8382a() {
        return true;
    }

    @Override
    public final boolean mo8383b() {
        return ((Boolean) f6084a.m8368b()).booleanValue();
    }

    @Override
    public final boolean mo8384c() {
        return ((Boolean) f6085b.m8368b()).booleanValue();
    }
}
