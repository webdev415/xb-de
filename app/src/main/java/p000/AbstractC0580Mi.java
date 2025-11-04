package p000;

public abstract class AbstractC0580Mi {

    public static AbstractC0580Mi f1839a = m2885a().mo2905a();

    public static abstract class a {
        public abstract AbstractC0580Mi mo2905a();

        public abstract a mo2906b(String str);

        public abstract a mo2907c(long j);

        public abstract a mo2908d(String str);

        public abstract a mo2909e(String str);

        public abstract a mo2910f(String str);

        public abstract a mo2911g(C0534Li.a aVar);

        public abstract a mo2912h(long j);
    }

    public static a m2885a() {
        return new PersistedInstallationEntry.b().mo2912h(0L).mo2911g(C0534Li.a.ATTEMPT_MIGRATION).mo2907c(0L);
    }

    public abstract String mo2886b();

    public abstract long mo2887c();

    public abstract String mo2888d();

    public abstract String mo2889e();

    public abstract String mo2890f();

    public abstract C0534Li.a mo2891g();

    public abstract long mo2892h();

    public boolean m2893i() {
        return mo2891g() == C0534Li.a.REGISTER_ERROR;
    }

    public boolean m2894j() {
        return mo2891g() == C0534Li.a.NOT_GENERATED || mo2891g() == C0534Li.a.ATTEMPT_MIGRATION;
    }

    public boolean m2895k() {
        return mo2891g() == C0534Li.a.REGISTERED;
    }

    public boolean m2896l() {
        return mo2891g() == C0534Li.a.UNREGISTERED;
    }

    public boolean m2897m() {
        return mo2891g() == C0534Li.a.ATTEMPT_MIGRATION;
    }

    public abstract a mo2898n();

    public AbstractC0580Mi m2899o(String str, long j, long j2) {
        return mo2898n().mo2906b(str).mo2907c(j).mo2912h(j2).mo2905a();
    }

    public AbstractC0580Mi m2900p() {
        return mo2898n().mo2906b(null).mo2905a();
    }

    public AbstractC0580Mi m2901q(String str) {
        return mo2898n().mo2909e(str).mo2911g(C0534Li.a.REGISTER_ERROR).mo2905a();
    }

    public AbstractC0580Mi m2902r() {
        return mo2898n().mo2911g(C0534Li.a.NOT_GENERATED).mo2905a();
    }

    public AbstractC0580Mi m2903s(String str, String str2, long j, String str3, long j2) {
        return mo2898n().mo2908d(str).mo2911g(C0534Li.a.REGISTERED).mo2906b(str3).mo2910f(str2).mo2907c(j2).mo2912h(j).mo2905a();
    }

    public AbstractC0580Mi m2904t(String str) {
        return mo2898n().mo2908d(str).mo2911g(C0534Li.a.UNREGISTERED).mo2905a();
    }
}
