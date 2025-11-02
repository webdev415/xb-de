package p000;

/* loaded from: classes.dex */
public final class C1729fI implements InterfaceC1361cI {

    public static final AbstractC2001lA f5495a;

    static {
        C0057BA c0057baM220e = new C0057BA(AbstractC1721fA.m7566a("com.google.android.gms.measurement")).m221f().m220e();
        c0057baM220e.m219d("measurement.sdk.collection.enable_extend_user_property_size", true);
        c0057baM220e.m219d("measurement.sdk.collection.last_deep_link_referrer2", true);
        f5495a = c0057baM220e.m219d("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        c0057baM220e.m217b("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    @Override
    public final boolean mo5855a() {
        return ((Boolean) f5495a.m8368b()).booleanValue();
    }
}
