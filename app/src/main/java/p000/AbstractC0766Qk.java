package p000;

public abstract class AbstractC0766Qk {
    public static final Object m3695a(Throwable th) {
        AbstractC0116Ce.m476e(th, "exception");
        return new AbstractC0674Ok.Failure(th);
    }

    public static final void m3696b(Object obj) throws Throwable {
        if (obj instanceof AbstractC0674Ok.Failure) {
            throw ((AbstractC0674Ok.Failure) obj).f2055l;
        }
    }
}
