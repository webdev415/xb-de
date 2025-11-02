package p000;

import java.util.concurrent.CancellationException;

/* loaded from: classes.dex */
public final class C1127Ye extends CancellationException {

    public final transient InterfaceC1081Xe f3354l;

    public C1127Ye(String str, Throwable th, InterfaceC1081Xe interfaceC1081Xe) {
        super(str);
        this.f3354l = interfaceC1081Xe;
        if (th != null) {
            initCause(th);
        }
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (obj instanceof C1127Ye) {
                C1127Ye c1127Ye = (C1127Ye) obj;
                if (!AbstractC0116Ce.m472a(c1127Ye.getMessage(), getMessage()) || !AbstractC0116Ce.m472a(c1127Ye.f3354l, this.f3354l) || !AbstractC0116Ce.m472a(c1127Ye.getCause(), getCause())) {
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }

    public int hashCode() {
        String message = getMessage();
        AbstractC0116Ce.m473b(message);
        int iHashCode = ((message.hashCode() * 31) + this.f3354l.hashCode()) * 31;
        Throwable cause = getCause();
        return iHashCode + (cause != null ? cause.hashCode() : 0);
    }

    @Override
    public String toString() {
        return super.toString() + "; job=" + this.f3354l;
    }
}
