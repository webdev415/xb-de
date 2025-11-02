package p000;

/* loaded from: classes.dex */
public final class C0836S8 extends RuntimeException {

    public final transient InterfaceC0191E6 f2605l;

    public C0836S8(InterfaceC0191E6 interfaceC0191E6) {
        this.f2605l = interfaceC0191E6;
    }

    @Override
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    @Override
    public String getLocalizedMessage() {
        return this.f2605l.toString();
    }
}
