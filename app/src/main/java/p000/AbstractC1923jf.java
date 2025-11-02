package p000;

public abstract class AbstractC1923jf {

    public static final C0951Um f5948a = new C0951Um("COMPLETING_ALREADY");

    public static final C0951Um f5949b = new C0951Um("COMPLETING_WAITING_CHILDREN");

    public static final C0951Um f5950c = new C0951Um("COMPLETING_RETRY");

    public static final C0951Um f5951d = new C0951Um("TOO_LATE_TO_CANCEL");

    public static final C0951Um f5952e = new C0951Um("SEALED");

    public static final C0562M9 f5953f = new C0562M9(false);

    public static final C0562M9 f5954g = new C0562M9(true);

    public static final Object m8175g(Object obj) {
        return obj instanceof InterfaceC1876ie ? new C1922je((InterfaceC1876ie) obj) : obj;
    }

    public static final Object m8176h(Object obj) {
        InterfaceC1876ie interfaceC1876ie;
        C1922je c1922je = obj instanceof C1922je ? (C1922je) obj : null;
        return (c1922je == null || (interfaceC1876ie = c1922je.f5947a) == null) ? obj : interfaceC1876ie;
    }
}
