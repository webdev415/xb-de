package p000;

public final class C2576xn {

    public static final C2576xn f8026a = new C2576xn();

    public static final ThreadLocal f8027b = AbstractC2622yn.m10904a(new C0951Um("ThreadLocalEventLoop"));

    public final AbstractC1964ka m10781a() {
        ThreadLocal threadLocal = f8027b;
        AbstractC1964ka abstractC1964ka = (AbstractC1964ka) threadLocal.get();
        if (abstractC1964ka != null) {
            return abstractC1964ka;
        }
        AbstractC1964ka abstractC1964kaM8743a = AbstractC2102na.m8743a();
        threadLocal.set(abstractC1964kaM8743a);
        return abstractC1964kaM8743a;
    }

    public final void m10782b() {
        f8027b.set(null);
    }

    public final void m10783c(AbstractC1964ka abstractC1964ka) {
        f8027b.set(abstractC1964ka);
    }
}
