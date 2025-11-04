package p000;

public abstract class AbstractC2251qk {

    public static final C2297rk f6730a;

    public static final InterfaceC2246qf[] f6731b;

    static {
        C2297rk c2297rk = null;
        try {
            c2297rk = (C2297rk) Class.forName("kotlin.reflect.jvm.internal.ReflectionFactoryImpl").newInstance();
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException unused) {
        }
        if (c2297rk == null) {
            c2297rk = new C2297rk();
        }
        f6730a = c2297rk;
        f6731b = new InterfaceC2246qf[0];
    }

    public static InterfaceC2246qf m9158a(Class cls) {
        return f6730a.m9429a(cls);
    }

    public static InterfaceC2292rf m9159b(Class cls) {
        return f6730a.m9430b(cls, "");
    }

    public static InterfaceC2338sf m9160c(AbstractC2204pj abstractC2204pj) {
        return f6730a.m9431c(abstractC2204pj);
    }

    public static String m9161d(InterfaceC2335sc interfaceC2335sc) {
        return f6730a.m9432d(interfaceC2335sc);
    }

    public static String m9162e(AbstractC0025Af abstractC0025Af) {
        return f6730a.m9433e(abstractC0025Af);
    }
}
