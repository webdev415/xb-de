package p000;

public abstract class AbstractC1327bk extends Exception {

    public static final boolean f3878l;

    public static final StackTraceElement[] f3879m;

    static {
        f3878l = System.getProperty("surefire.test.class.path") != null;
        f3879m = new StackTraceElement[0];
    }

    public AbstractC1327bk() {
    }

    @Override
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }

    public AbstractC1327bk(Throwable th) {
        super(th);
    }
}
