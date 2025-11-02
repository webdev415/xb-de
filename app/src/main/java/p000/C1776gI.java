package p000;

/* loaded from: classes.dex */
public final class C1776gI implements InterfaceC1823hI {

    public static final AbstractC2001lA f5618a;

    public static final AbstractC2001lA f5619b;

    public static final AbstractC2001lA f5620c;

    public static final AbstractC2001lA f5621d;

    public static final AbstractC2001lA f5622e;

    public static final AbstractC2001lA f5623f;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        f5618a = c0057baM220e.m219d("measurement.test.boolean_flag", false);
        f5619b = c0057baM220e.m217b("measurement.test.cached_long_flag", -1L);
        f5620c = c0057baM220e.m216a("measurement.test.double_flag", -3.0d);
        f5621d = c0057baM220e.m217b("measurement.test.int_flag", -2L);
        f5622e = c0057baM220e.m217b("measurement.test.long_flag", -1L);
        f5623f = c0057baM220e.m218c("measurement.test.string_flag", "---");
    }

    @Override
    public final double mo7709a() {
        return ((Double) f5620c.m8368b()).doubleValue();
    }

    @Override
    public final long mo7710b() {
        return ((Long) f5619b.m8368b()).longValue();
    }

    @Override
    public final long mo7711c() {
        return ((Long) f5621d.m8368b()).longValue();
    }

    @Override
    public final long mo7712d() {
        return ((Long) f5622e.m8368b()).longValue();
    }

    @Override
    public final String mo7713f() {
        return (String) f5623f.m8368b();
    }

    @Override
    public final boolean mo7714h() {
        return ((Boolean) f5618a.m8368b()).booleanValue();
    }
}
