package p000;

public abstract class AbstractC0282G5 {
    public static final Object m1346a(Object obj, InterfaceC1301b4 interfaceC1301b4) {
        Throwable thM3432b = AbstractC0674Ok.m3432b(obj);
        if (thM3432b == null) {
            return obj;
        }
        return new C0098C5(thM3432b, false, 2, null);
    }

    public static final Object m1347b(Object obj, InterfaceC0986Vb interfaceC0986Vb) {
        Throwable thM3432b = AbstractC0674Ok.m3432b(obj);
        if (thM3432b == null) {
            return interfaceC0986Vb != null ? new C0144D5(obj, interfaceC0986Vb) : obj;
        }
        return new C0098C5(thM3432b, false, 2, null);
    }

    public static Object m1348c(Object obj, InterfaceC0986Vb interfaceC0986Vb, int i, Object obj2) {
        if ((i & 1) != 0) {
            interfaceC0986Vb = null;
        }
        return m1347b(obj, interfaceC0986Vb);
    }
}
